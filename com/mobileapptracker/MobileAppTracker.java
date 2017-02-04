package com.mobileapptracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MobileAppTracker
{
  private static volatile MobileAppTracker tune = null;
  private final String IV = "heF9BATUfWuISyO8";
  private boolean debugMode;
  private MATDeferredDplinkr dplinkr;
  private MATEncryption encryption;
  protected MATEventQueue eventQueue;
  private boolean fbLogging;
  private boolean firstSession;
  boolean gotGaid;
  boolean gotReferrer;
  private long initTime;
  protected boolean initialized;
  protected boolean isRegistered;
  protected Context mContext;
  private MATPreloadData mPreloadData;
  protected BroadcastReceiver networkStateReceiver;
  boolean notifiedPool;
  protected MATParameters params;
  ExecutorService pool;
  protected ExecutorService pubQueue;
  private long referrerTime;
  private MATResponse tuneListener;
  protected MATTestRequest tuneRequest;
  private MATUrlRequester urlRequester;
  
  private boolean firstInstall()
  {
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("com.mobileapptracking", 0);
    if (localSharedPreferences.contains("mat_installed")) {
      return false;
    }
    localSharedPreferences.edit().putBoolean("mat_installed", true).commit();
    return true;
  }
  
  public static MobileAppTracker getInstance()
  {
    try
    {
      MobileAppTracker localMobileAppTracker = tune;
      return localMobileAppTracker;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static MobileAppTracker init(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (tune == null)
      {
        tune = new MobileAppTracker();
        tune.mContext = paramContext.getApplicationContext();
        tune.pubQueue = Executors.newSingleThreadExecutor();
        tune.initAll(paramString1, paramString2);
      }
      paramContext = tune;
      return paramContext;
    }
    finally {}
  }
  
  private void initLocalVariables(String paramString)
  {
    this.pool = Executors.newSingleThreadExecutor();
    this.urlRequester = new MATUrlRequester();
    this.encryption = new MATEncryption(paramString.trim(), "heF9BATUfWuISyO8");
    this.initTime = System.currentTimeMillis();
    if (this.mContext.getSharedPreferences("com.mobileapptracking", 0).getString("mat_referrer", "").equals("")) {}
    for (boolean bool = false;; bool = true)
    {
      this.gotReferrer = bool;
      this.firstSession = true;
      this.initialized = false;
      this.isRegistered = false;
      this.debugMode = false;
      this.fbLogging = false;
      return;
    }
  }
  
  public static boolean isOnline(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private void measure(MATEvent paramMATEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = this.initialized;
        if (!bool) {
          return;
        }
        dumpQueue();
        this.params.setAction("conversion");
        Object localObject1 = new Date();
        if (paramMATEvent.getEventName() != null)
        {
          str = paramMATEvent.getEventName();
          if (this.fbLogging) {
            MATFBBridge.logEvent(paramMATEvent);
          }
          if (str.equals("close")) {
            continue;
          }
          if ((str.equals("open")) || (str.equals("install")) || (str.equals("update")) || (str.equals("session")))
          {
            this.params.setAction("session");
            new Date(((Date)localObject1).getTime() + 60000L);
          }
        }
        if (paramMATEvent.getRevenue() > 0.0D) {
          this.params.setIsPayingUser("1");
        }
        localObject1 = MATUrlBuilder.buildLink(paramMATEvent, this.mPreloadData, this.debugMode);
        String str = MATUrlBuilder.buildDataUnencrypted(paramMATEvent);
        Object localObject2 = new JSONArray();
        if (paramMATEvent.getEventItems() != null)
        {
          i = 0;
          if (i < paramMATEvent.getEventItems().size()) {}
        }
        else
        {
          localObject2 = MATUrlBuilder.buildBody((JSONArray)localObject2, paramMATEvent.getReceiptData(), paramMATEvent.getReceiptSignature(), this.params.getUserEmails());
          if (this.tuneRequest != null) {
            this.tuneRequest.constructedRequest((String)localObject1, str, (JSONObject)localObject2);
          }
          addEventToQueue((String)localObject1, str, (JSONObject)localObject2, this.firstSession);
          this.firstSession = false;
          dumpQueue();
          if (this.tuneListener == null) {
            continue;
          }
          this.tuneListener.enqueuedActionWithRefId(paramMATEvent.getRefId());
          continue;
        }
        ((JSONArray)localObject2).put(((MATEventItem)paramMATEvent.getEventItems().get(i)).toJSON());
      }
      finally {}
      i += 1;
    }
  }
  
  private void requestDeeplink()
  {
    if (this.dplinkr.isEnabled())
    {
      this.dplinkr.setUserAgent(this.params.getUserAgent());
      this.dplinkr.checkForDeferredDeeplink(this.mContext, this.urlRequester);
    }
  }
  
  protected void addEventToQueue(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    ExecutorService localExecutorService = this.pool;
    MATEventQueue localMATEventQueue = this.eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Add(localMATEventQueue, paramString1, paramString2, paramJSONObject, paramBoolean));
  }
  
  public void checkForDeferredDeeplink(MATDeeplinkListener paramMATDeeplinkListener)
  {
    setDeeplinkListener(paramMATDeeplinkListener);
    if (firstInstall()) {
      this.dplinkr.enable(true);
    }
    for (;;)
    {
      if ((this.dplinkr.getGoogleAdvertisingId() != null) || (this.dplinkr.getAndroidId() != null)) {
        requestDeeplink();
      }
      return;
      this.dplinkr.enable(false);
    }
  }
  
  protected void dumpQueue()
  {
    if (!isOnline(this.mContext)) {
      return;
    }
    ExecutorService localExecutorService = this.pool;
    MATEventQueue localMATEventQueue = this.eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Dump(localMATEventQueue));
  }
  
  public String getAction()
  {
    return this.params.getAction();
  }
  
  public String getAdvertiserId()
  {
    return this.params.getAdvertiserId();
  }
  
  public int getAge()
  {
    return Integer.parseInt(this.params.getAge());
  }
  
  public double getAltitude()
  {
    return Double.parseDouble(this.params.getAltitude());
  }
  
  public String getAndroidId()
  {
    return this.params.getAndroidId();
  }
  
  public boolean getAppAdTrackingEnabled()
  {
    return Integer.parseInt(this.params.getAppAdTrackingEnabled()) == 1;
  }
  
  public String getAppName()
  {
    return this.params.getAppName();
  }
  
  public int getAppVersion()
  {
    return Integer.parseInt(this.params.getAppVersion());
  }
  
  public String getConnectionType()
  {
    return this.params.getConnectionType();
  }
  
  public String getCountryCode()
  {
    return this.params.getCountryCode();
  }
  
  public String getCurrencyCode()
  {
    return this.params.getCurrencyCode();
  }
  
  public String getDeviceBrand()
  {
    return this.params.getDeviceBrand();
  }
  
  public String getDeviceCarrier()
  {
    return this.params.getDeviceCarrier();
  }
  
  public String getDeviceId()
  {
    return this.params.getDeviceId();
  }
  
  public String getDeviceModel()
  {
    return this.params.getDeviceModel();
  }
  
  public boolean getExistingUser()
  {
    return Integer.parseInt(this.params.getExistingUser()) == 1;
  }
  
  public String getFacebookUserId()
  {
    return this.params.getFacebookUserId();
  }
  
  public int getGender()
  {
    return Integer.parseInt(this.params.getGender());
  }
  
  public boolean getGoogleAdTrackingLimited()
  {
    return Integer.parseInt(this.params.getGoogleAdTrackingLimited()) != 0;
  }
  
  public String getGoogleAdvertisingId()
  {
    return this.params.getGoogleAdvertisingId();
  }
  
  public String getGoogleUserId()
  {
    return this.params.getGoogleUserId();
  }
  
  public long getInstallDate()
  {
    return Long.parseLong(this.params.getInstallDate());
  }
  
  public String getInstallReferrer()
  {
    return this.params.getInstallReferrer();
  }
  
  public boolean getIsPayingUser()
  {
    return this.params.getIsPayingUser().equals("1");
  }
  
  public String getLanguage()
  {
    return this.params.getLanguage();
  }
  
  public String getLastOpenLogId()
  {
    return this.params.getLastOpenLogId();
  }
  
  public double getLatitude()
  {
    return Double.parseDouble(this.params.getLatitude());
  }
  
  public double getLongitude()
  {
    return Double.parseDouble(this.params.getLongitude());
  }
  
  public String getMCC()
  {
    return this.params.getMCC();
  }
  
  public String getMNC()
  {
    return this.params.getMNC();
  }
  
  public String getMacAddress()
  {
    return this.params.getMacAddress();
  }
  
  public String getMatId()
  {
    return this.params.getMatId();
  }
  
  public String getOpenLogId()
  {
    return this.params.getOpenLogId();
  }
  
  public String getOsVersion()
  {
    return this.params.getOsVersion();
  }
  
  public String getPackageName()
  {
    return this.params.getPackageName();
  }
  
  public String getPluginName()
  {
    return this.params.getPluginName();
  }
  
  public String getRefId()
  {
    return this.params.getRefId();
  }
  
  public String getReferralSource()
  {
    return this.params.getReferralSource();
  }
  
  public String getReferralUrl()
  {
    return this.params.getReferralUrl();
  }
  
  public Double getRevenue()
  {
    return Double.valueOf(Double.parseDouble(this.params.getRevenue()));
  }
  
  public String getSDKVersion()
  {
    return this.params.getSdkVersion();
  }
  
  public String getScreenDensity()
  {
    return this.params.getScreenDensity();
  }
  
  public String getScreenHeight()
  {
    return this.params.getScreenHeight();
  }
  
  public String getScreenWidth()
  {
    return this.params.getScreenWidth();
  }
  
  public String getSiteId()
  {
    return this.params.getSiteId();
  }
  
  public String getTRUSTeId()
  {
    return this.params.getTRUSTeId();
  }
  
  public String getTwitterUserId()
  {
    return this.params.getTwitterUserId();
  }
  
  public String getUserAgent()
  {
    return this.params.getUserAgent();
  }
  
  public String getUserEmail()
  {
    return this.params.getUserEmail();
  }
  
  public String getUserId()
  {
    return this.params.getUserId();
  }
  
  public String getUserName()
  {
    return this.params.getUserName();
  }
  
  protected void initAll(String paramString1, String paramString2)
  {
    this.dplinkr = MATDeferredDplinkr.initialize(paramString1, paramString2, this.mContext.getPackageName());
    this.params = MATParameters.init(this, this.mContext, paramString1, paramString2);
    initLocalVariables(paramString2);
    this.eventQueue = new MATEventQueue(this.mContext, this);
    dumpQueue();
    this.networkStateReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (MobileAppTracker.this.isRegistered) {
          MobileAppTracker.this.dumpQueue();
        }
      }
    };
    if (this.isRegistered) {}
    try
    {
      this.mContext.unregisterReceiver(this.networkStateReceiver);
      this.isRegistered = false;
      paramString1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.mContext.registerReceiver(this.networkStateReceiver, paramString1);
      this.isRegistered = true;
      this.initialized = true;
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;) {}
    }
  }
  
  protected boolean makeRequest(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (this.debugMode) {
      Log.d("MobileAppTracker", "Sending event to server...");
    }
    paramString2 = MATUrlBuilder.updateAndEncryptData(paramString2, this.encryption);
    paramString1 = MATUrlRequester.requestUrl(paramString1 + "&data=" + paramString2, paramJSONObject, this.debugMode);
    if (paramString1 == null)
    {
      if (this.tuneListener != null) {
        this.tuneListener.didFailWithError(paramString1);
      }
      return true;
    }
    if (!paramString1.has("success"))
    {
      if (this.debugMode) {
        Log.d("MobileAppTracker", "Request failed, event will remain in queue");
      }
      return false;
    }
    int i;
    if (this.tuneListener != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramString1.getString("success").equals("true");
        if (bool) {
          i = 1;
        }
        if (i != 0)
        {
          this.tuneListener.didSucceedWithData(paramString1);
          try
          {
            if (!paramString1.getString("site_event_type").equals("open")) {
              break;
            }
            paramString1 = paramString1.getString("log_id");
            if (getOpenLogId().equals("")) {
              this.params.setOpenLogId(paramString1);
            }
            this.params.setLastOpenLogId(paramString1);
            return true;
          }
          catch (JSONException paramString1)
          {
            return true;
          }
        }
        this.tuneListener.didFailWithError(paramString1);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
    }
  }
  
  public void measureEvent(int paramInt)
  {
    measureEvent(new MATEvent(paramInt));
  }
  
  public void measureEvent(final MATEvent paramMATEvent)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.measure(paramMATEvent);
      }
    });
  }
  
  public void measureEvent(String paramString)
  {
    measureEvent(new MATEvent(paramString));
  }
  
  public void measureSession()
  {
    this.notifiedPool = false;
    measureEvent(new MATEvent("session"));
  }
  
  public void setAdvertiserId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAdvertiserId(paramString);
      }
    });
  }
  
  public void setAge(final int paramInt)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAge(Integer.toString(paramInt));
      }
    });
  }
  
  public void setAllowDuplicates(final boolean paramBoolean)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          MobileAppTracker.this.params.setAllowDuplicates(Integer.toString(1));
          return;
        }
        MobileAppTracker.this.params.setAllowDuplicates(Integer.toString(0));
      }
    });
    if (paramBoolean) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          Toast.makeText(MobileAppTracker.this.mContext, "TUNE Allow Duplicate Requests Enabled, do not release with this enabled!!", 1).show();
        }
      });
    }
  }
  
  public void setAltitude(final double paramDouble)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAltitude(Double.toString(paramDouble));
      }
    });
  }
  
  public void setAndroidId(String paramString)
  {
    if (this.dplinkr != null)
    {
      this.dplinkr.setAndroidId(paramString);
      requestDeeplink();
    }
    if (this.params != null) {
      this.params.setAndroidId(paramString);
    }
  }
  
  public void setAndroidIdMd5(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAndroidIdMd5(paramString);
      }
    });
  }
  
  public void setAndroidIdSha1(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAndroidIdSha1(paramString);
      }
    });
  }
  
  public void setAndroidIdSha256(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setAndroidIdSha256(paramString);
      }
    });
  }
  
  public void setAppAdTrackingEnabled(final boolean paramBoolean)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          MobileAppTracker.this.params.setAppAdTrackingEnabled(Integer.toString(1));
          return;
        }
        MobileAppTracker.this.params.setAppAdTrackingEnabled(Integer.toString(0));
      }
    });
  }
  
  public void setConversionKey(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setConversionKey(paramString);
      }
    });
  }
  
  public void setCurrencyCode(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if ((paramString == null) || (paramString.equals("")))
        {
          MobileAppTracker.this.params.setCurrencyCode("USD");
          return;
        }
        MobileAppTracker.this.params.setCurrencyCode(paramString);
      }
    });
  }
  
  public void setDebugMode(final boolean paramBoolean)
  {
    this.debugMode = paramBoolean;
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setDebugMode(paramBoolean);
      }
    });
    if (paramBoolean) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          Toast.makeText(MobileAppTracker.this.mContext, "TUNE Debug Mode Enabled, do not release with this enabled!!", 1).show();
        }
      });
    }
  }
  
  public void setDeeplinkListener(MATDeeplinkListener paramMATDeeplinkListener)
  {
    this.dplinkr.setListener(paramMATDeeplinkListener);
  }
  
  public void setDeviceBrand(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setDeviceBrand(paramString);
      }
    });
  }
  
  public void setDeviceId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setDeviceId(paramString);
      }
    });
  }
  
  public void setDeviceModel(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setDeviceModel(paramString);
      }
    });
  }
  
  public void setEmailCollection(final boolean paramBoolean)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        int j = 0;
        int i;
        Object localObject;
        Account[] arrayOfAccount;
        int k;
        if (MobileAppTracker.this.mContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0)
        {
          i = 1;
          if ((paramBoolean) && (i != 0))
          {
            localObject = AccountManager.get(MobileAppTracker.this.mContext).getAccountsByType("com.google");
            if (localObject.length > 0) {
              MobileAppTracker.this.params.setUserEmail(localObject[0].name);
            }
            localObject = new HashMap();
            arrayOfAccount = AccountManager.get(MobileAppTracker.this.mContext).getAccounts();
            k = arrayOfAccount.length;
            i = j;
          }
        }
        for (;;)
        {
          if (i >= k)
          {
            localObject = ((HashMap)localObject).keySet();
            localObject = (String[])((Set)localObject).toArray(new String[((Set)localObject).size()]);
            MobileAppTracker.this.params.setUserEmails((String[])localObject);
            return;
            i = 0;
            break;
          }
          Account localAccount = arrayOfAccount[i];
          if (Patterns.EMAIL_ADDRESS.matcher(localAccount.name).matches()) {
            ((HashMap)localObject).put(localAccount.name, localAccount.type);
          }
          i += 1;
        }
      }
    });
  }
  
  public void setExistingUser(final boolean paramBoolean)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          MobileAppTracker.this.params.setExistingUser(Integer.toString(1));
          return;
        }
        MobileAppTracker.this.params.setExistingUser(Integer.toString(0));
      }
    });
  }
  
  public void setFacebookEventLogging(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    this.fbLogging = paramBoolean1;
    if (paramBoolean1) {
      MATFBBridge.startLogger(paramContext, paramBoolean2);
    }
  }
  
  public void setFacebookUserId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setFacebookUserId(paramString);
      }
    });
  }
  
  public void setGender(final MATGender paramMATGender)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setGender(paramMATGender);
      }
    });
  }
  
  public void setGoogleAdvertisingId(String arg1, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      if (this.dplinkr != null)
      {
        this.dplinkr.setGoogleAdvertisingId(???, i);
        requestDeeplink();
      }
      if (this.params != null)
      {
        this.params.setGoogleAdvertisingId(???);
        this.params.setGoogleAdTrackingLimited(Integer.toString(i));
      }
      this.gotGaid = true;
      if ((this.gotReferrer) && (!this.notifiedPool)) {
        synchronized (this.pool)
        {
          this.pool.notifyAll();
          this.notifiedPool = true;
          return;
        }
      }
      return;
    }
  }
  
  public void setGoogleUserId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setGoogleUserId(paramString);
      }
    });
  }
  
  public void setInstallReferrer(final String paramString)
  {
    this.gotReferrer = true;
    this.referrerTime = System.currentTimeMillis();
    if (this.params != null) {
      this.params.setReferrerDelay(this.referrerTime - this.initTime);
    }
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setInstallReferrer(paramString);
      }
    });
  }
  
  public void setIsPayingUser(final boolean paramBoolean)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          MobileAppTracker.this.params.setIsPayingUser(Integer.toString(1));
          return;
        }
        MobileAppTracker.this.params.setIsPayingUser(Integer.toString(0));
      }
    });
  }
  
  public void setLatitude(final double paramDouble)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setLatitude(Double.toString(paramDouble));
      }
    });
  }
  
  public void setLocation(final Location paramLocation)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setLocation(paramLocation);
      }
    });
  }
  
  public void setLongitude(final double paramDouble)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setLongitude(Double.toString(paramDouble));
      }
    });
  }
  
  public void setMATResponse(MATResponse paramMATResponse)
  {
    this.tuneListener = paramMATResponse;
  }
  
  public void setMacAddress(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setMacAddress(paramString);
      }
    });
  }
  
  public void setOsVersion(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setOsVersion(paramString);
      }
    });
  }
  
  public void setPackageName(final String paramString)
  {
    this.dplinkr.setPackageName(paramString);
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if ((paramString == null) || (paramString.equals("")))
        {
          MobileAppTracker.this.params.setPackageName(MobileAppTracker.this.mContext.getPackageName());
          return;
        }
        MobileAppTracker.this.params.setPackageName(paramString);
      }
    });
  }
  
  public void setPhoneNumber(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        String str = paramString.replaceAll("\\D+", "");
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (;;)
        {
          if (i >= str.length())
          {
            MobileAppTracker.this.params.setPhoneNumber(localStringBuilder.toString());
            return;
          }
          localStringBuilder.append(Integer.parseInt(String.valueOf(str.charAt(i))));
          i += 1;
        }
      }
    });
  }
  
  public void setPluginName(final String paramString)
  {
    if (Arrays.asList(MATConstants.PLUGIN_NAMES).contains(paramString)) {
      this.pubQueue.execute(new Runnable()
      {
        public void run()
        {
          MobileAppTracker.this.params.setPluginName(paramString);
        }
      });
    }
    while (!this.debugMode) {
      return;
    }
    throw new IllegalArgumentException("Plugin name not acceptable");
  }
  
  public void setPreloadedApp(MATPreloadData paramMATPreloadData)
  {
    this.mPreloadData = paramMATPreloadData;
  }
  
  public void setReferralSources(final Activity paramActivity)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setReferralSource(paramActivity.getCallingPackage());
        Object localObject = paramActivity.getIntent();
        if (localObject != null)
        {
          localObject = ((Intent)localObject).getData();
          if (localObject != null) {
            MobileAppTracker.this.params.setReferralUrl(((Uri)localObject).toString());
          }
        }
      }
    });
  }
  
  public void setSiteId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setSiteId(paramString);
      }
    });
  }
  
  public void setTRUSTeId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setTRUSTeId(paramString);
      }
    });
  }
  
  public void setTwitterUserId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setTwitterUserId(paramString);
      }
    });
  }
  
  public void setUserEmail(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setUserEmail(paramString);
      }
    });
  }
  
  public void setUserId(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setUserId(paramString);
      }
    });
  }
  
  public void setUserName(final String paramString)
  {
    this.pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.params.setUserName(paramString);
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MobileAppTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */