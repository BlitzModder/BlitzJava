package net.wargaming.wot.blitz;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.dava.framework.JNIActivity;
import com.dava.framework.JNIApplication;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyIAPEngagement;
import com.jirbo.adcolony.AdColonyV4VCAd;
import com.jirbo.adcolony.AdColonyV4VCListener;
import com.jirbo.adcolony.AdColonyV4VCReward;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdColonyBridgeImpl
  implements AdColonyAdAvailabilityListener, AdColonyAdListener, AdColonyV4VCListener
{
  private static final String ADCOLONY_APP_ID = "appdf58af88d6134d2d9c";
  private static final String[] ADCOLONY_ZONES = { "vz5e95bf77c266432a9b", "vza8c7fb165759411fba", "vz6e13e48b8b0d446098", "vz32513290bb1b4c428d", "vz0641d58a11b141118c", "vz7f39571a1f9e480992", "vz893b3a1785074573aa", "vz125feb60530e403188" };
  private static final Map<AdColonyIAPEngagement, Integer> IAP_IDS_MAP;
  private static final String LOGGING_TAG = "AdColony";
  private boolean adRunning = false;
  private String configurationCustomID = null;
  private String lastActiveZoneID = null;
  private AdColonyNativeDelegate nativeDelegate = null;
  private AdColonyV4VCAd preparedAd = null;
  private String storedCustomID = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(AdColonyIAPEngagement.NONE, Integer.valueOf(0));
    localHashMap.put(AdColonyIAPEngagement.AUTOMATIC, Integer.valueOf(1));
    localHashMap.put(AdColonyIAPEngagement.END_CARD, Integer.valueOf(2));
    localHashMap.put(AdColonyIAPEngagement.OVERLAY, Integer.valueOf(3));
    IAP_IDS_MAP = Collections.unmodifiableMap(localHashMap);
  }
  
  private static String[] filterUnregisteredZones(String[] paramArrayOfString)
  {
    List localList = Arrays.asList(ADCOLONY_ZONES);
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!localList.contains(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private native String getAppVersion();
  
  private static String loadCustomID()
  {
    Log.d("AdColony", "AdColonyBridgeImpl::loadCustomID");
    String str2 = null;
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = JNIApplication.GetApplication().getApplicationContext().openFileInput("custom_id");
      str1 = str2;
      str2 = new BufferedReader(new InputStreamReader(localFileInputStream)).readLine();
      str1 = str2;
      localFileInputStream.close();
      return str2;
    }
    catch (IOException localIOException)
    {
      Log.e("AdColony", "AdColonyBridgeImpl::loadCustomID" + localIOException.getMessage());
    }
    return str1;
  }
  
  public static void onPause() {}
  
  public static void onResume(Activity paramActivity)
  {
    AdColony.resume(paramActivity);
  }
  
  private void prepareAdForZone(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preparedAd == null) || (this.preparedAd.getZoneID() != paramString)) {
      this.preparedAd = new AdColonyV4VCAd(paramString);
    }
  }
  
  private static void storeCustomID(String paramString)
  {
    Log.d("AdColony", "AdColonyBridgeImpl::storeCustomID, customID = " + paramString);
    try
    {
      FileOutputStream localFileOutputStream = JNIApplication.GetApplication().getApplicationContext().openFileOutput("custom_id", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return;
    }
    catch (IOException paramString)
    {
      Log.e("AdColony", "AdColonyBridgeImpl::storeCustomID" + paramString.getMessage());
    }
  }
  
  public void configure(String paramString, String[] paramArrayOfString)
  {
    Log.d("AdColony", "AdColonyBridgeImpl::configure, zones = " + Arrays.toString(paramArrayOfString));
    this.nativeDelegate = new AdColonyNativeDelegate();
    if (!"appdf58af88d6134d2d9c".equals(paramString)) {
      Log.e("AdColony", "AdColonyBridgeImpl::configure: wrong AppID: " + paramString);
    }
    paramString = filterUnregisteredZones(paramArrayOfString);
    if (paramString.length != 0) {
      Log.e("AdColony", "AdColonyBridgeImpl::configure: unregistered zones: " + Arrays.toString(paramString));
    }
    AdColony.addAdAvailabilityListener(this);
    AdColony.addV4VCListener(this);
  }
  
  public String getCurrencyNameForZone(String paramString)
  {
    prepareAdForZone(paramString, false);
    String str = this.preparedAd.getRewardName();
    Log.d("AdColony", "AdColonyBridgeImpl::getCurrencyNameForZone, zone = " + paramString + ", name = " + str);
    return str;
  }
  
  public String getCustomID()
  {
    String str = "";
    if (this.storedCustomID != null) {
      str = this.storedCustomID;
    }
    Log.d("AdColony", "AdColonyBridgeImpl::getCustomID returns " + str);
    return str;
  }
  
  public int getRewardAmountForZone(String paramString)
  {
    prepareAdForZone(paramString, false);
    int i = this.preparedAd.getRewardAmount();
    Log.d("AdColony", "AdColonyBridgeImpl::getRewardAmountForZone, zone = " + paramString + ", amount = " + i);
    return i;
  }
  
  public void onAdColonyAdAttemptFinished(final AdColonyAd paramAdColonyAd)
  {
    WotBlitz.GetActivity().RunOnMainLoopThread(new Runnable()
    {
      private final boolean iapEnabled = paramAdColonyAd.iapEnabled();
      private final int iapEngagementID = ((Integer)AdColonyBridgeImpl.IAP_IDS_MAP.get(paramAdColonyAd.iapEngagementType())).intValue();
      private final String iapProductID = paramAdColonyAd.iapProductID();
      private final boolean shown = paramAdColonyAd.shown();
      private final AdColonyNativeDelegate storedNativeDelegate = AdColonyBridgeImpl.this.nativeDelegate;
      private final String zoneID = paramAdColonyAd.getZoneID();
      
      public void run()
      {
        Log.d("AdColony", "AdColonyBridgeImpl::onAdColonyAdAttemptFinishedWithInfo, ad.zoneID = " + paramAdColonyAd.getZoneID() + ", ad.iapProductID = " + paramAdColonyAd.iapProductID() + ", ad.iapEnabled = " + paramAdColonyAd.iapEnabled() + ", ad.iapEngagementType = " + paramAdColonyAd.iapEngagementType() + ", ad.shown = " + paramAdColonyAd.shown() + ", ad.canceled = " + paramAdColonyAd.canceled() + ", ad.noFill = " + paramAdColonyAd.noFill() + ", ad.notShown = " + paramAdColonyAd.notShown() + ", ad.skipped = " + paramAdColonyAd.skipped());
        AdColonyBridgeImpl.access$202(AdColonyBridgeImpl.this, false);
        this.storedNativeDelegate.onAdColonyAdAttemptFinishedWithInfo(this.shown, this.zoneID, this.iapEnabled, this.iapProductID, this.iapEngagementID);
      }
    });
  }
  
  public void onAdColonyAdAvailabilityChange(final boolean paramBoolean, final String paramString)
  {
    WotBlitz.GetActivity().RunOnMainLoopThread(new Runnable()
    {
      private final boolean storedAvailable = paramBoolean;
      private final AdColonyNativeDelegate storedNativeDelegate = AdColonyBridgeImpl.this.nativeDelegate;
      private final String storedZoneID = paramString;
      
      public void run()
      {
        Log.d("AdColony", "AdColonyBridgeImpl::onAdColonyAdAvailabilityChange, available = " + paramBoolean + ", zoneID = " + paramString);
        this.storedNativeDelegate.onAdColonyAdAvailabilityChange(this.storedAvailable, this.storedZoneID);
      }
    });
  }
  
  public void onAdColonyAdStarted(final AdColonyAd paramAdColonyAd)
  {
    WotBlitz.GetActivity().RunOnMainLoopThread(new Runnable()
    {
      private final AdColonyNativeDelegate storedNativeDelegate = AdColonyBridgeImpl.this.nativeDelegate;
      private final String zoneID = paramAdColonyAd.getZoneID();
      
      public void run()
      {
        Log.d("AdColony", "AdColonyBridgeImpl::onAdColonyAdStarted, ad.zoneID = " + paramAdColonyAd.getZoneID() + ", ad.iapProductID = " + paramAdColonyAd.iapProductID() + ", ad.iapEnabled = " + paramAdColonyAd.iapEnabled() + ", ad.iapEngagementType = " + paramAdColonyAd.iapEngagementType() + ", ad.shown = " + paramAdColonyAd.shown() + ", ad.canceled = " + paramAdColonyAd.canceled() + ", ad.noFill = " + paramAdColonyAd.noFill() + ", ad.notShown = " + paramAdColonyAd.notShown() + ", ad.skipped = " + paramAdColonyAd.skipped());
        AdColonyBridgeImpl.access$202(AdColonyBridgeImpl.this, true);
        this.storedNativeDelegate.onAdColonyAdStartedInZone(this.zoneID);
      }
    });
  }
  
  public void onAdColonyV4VCReward(final AdColonyV4VCReward paramAdColonyV4VCReward)
  {
    WotBlitz.GetActivity().RunOnMainLoopThread(new Runnable()
    {
      private final int amount = paramAdColonyV4VCReward.amount();
      private final String name = paramAdColonyV4VCReward.name();
      private final AdColonyNativeDelegate storedNativeDelegate = AdColonyBridgeImpl.this.nativeDelegate;
      private final boolean success = paramAdColonyV4VCReward.success();
      private final String zoneID = AdColonyBridgeImpl.this.lastActiveZoneID;
      
      public void run()
      {
        Log.d("AdColony", "AdColonyBridgeImpl::onAdColonyV4VCReward, rewardInfo = " + paramAdColonyV4VCReward + " (success = " + paramAdColonyV4VCReward.success() + ", name = " + paramAdColonyV4VCReward.name() + ", amount = " + paramAdColonyV4VCReward.amount() + ")");
        this.storedNativeDelegate.onAdColonyV4VCReward(this.success, this.name, this.amount, this.zoneID);
      }
    });
  }
  
  public void onCreate(Activity paramActivity)
  {
    Log.d("AdColony", "AdColonyBridgeImpl::onCreate");
    this.storedCustomID = loadCustomID();
    if (this.storedCustomID != null)
    {
      this.configurationCustomID = this.storedCustomID;
      Log.d("AdColony", "AdColony.setCustomID(" + this.configurationCustomID + ")");
      AdColony.setCustomID(this.configurationCustomID);
    }
    AdColony.configure(paramActivity, "version:" + getAppVersion() + ",store:google", "appdf58af88d6134d2d9c", ADCOLONY_ZONES);
  }
  
  public void playVideoForZone(String paramString)
  {
    Log.d("AdColony", "AdColonyBridgeImpl::playVideoForZone, zone = " + paramString);
    prepareAdForZone(paramString, true);
    this.preparedAd.withListener(this).show();
    this.lastActiveZoneID = paramString;
    this.preparedAd = null;
  }
  
  public void setCustomID(String paramString)
  {
    Log.d("AdColony", "AdColonyBridgeImpl::setCustomID, customID = " + paramString);
    if ((this.storedCustomID == null) || (!this.storedCustomID.equals(paramString)))
    {
      storeCustomID(paramString);
      this.storedCustomID = paramString;
    }
  }
  
  public String statusForZone(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (this.configurationCustomID != null)
    {
      str1 = str2;
      if (this.configurationCustomID.equals(this.storedCustomID)) {
        str1 = AdColony.statusForZone(paramString);
      }
    }
    Log.d("AdColony", "AdColonyBridgeImpl::statusForZone, zone = " + paramString + ", returns " + str1);
    return str1;
  }
  
  public boolean virtualAdCurrentlyRunning()
  {
    Log.d("AdColony", "AdColonyBridgeImpl::virtualAdCurrentlyRunning: " + this.adRunning);
    return this.adRunning;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/AdColonyBridgeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */