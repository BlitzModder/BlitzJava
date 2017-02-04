package net.wargaming.wot.blitz;

import android.app.NotificationManager;
import android.app.backup.RestoreObserver;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import com.chartboost.sdk.Chartboost;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.dava.framework.JNIActivity;
import com.dava.framework.JNIBackupAgent;
import com.dava.framework.JNISurfaceView;
import com.facebook.Session;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.mobileapptracker.MobileAppTracker;
import com.parse.ParseAnalytics;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.IOException;
import net.wargaming.wot.util.AccountHelper;
import net.wargaming.wot.util.GameServicesHelper;

public class WotBlitz
  extends JNIActivity
{
  private static final String CHARTBOOST_APP_ID = "543d33441873da467e103a7c";
  private static final String CHARTBOOST_SIGNATURE = "1846befde290c77ca679994604f015e156fbe48f";
  private static final String MOBILEAPPTRACKER_ADVERTISER_ID = "12276";
  private static final String MOBILEAPPTRACKER_CONVERSION_KEY = "97bcc5a1a0e19598c20f47d97a5ad200";
  private static final String SHOP_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAogmFy2R9ZLHsm/GrQYbFsnPNwEj3iX+KXJUb5iO9GURhVWma23hCR+/MZRYOmSqq3/YgQzgXfCGbyZVoBf4HIDV+PcqpuVRnku9Rx1aFjxYATBkTqvc5UmDWERRiP50ZCqz+IKUNFpWS8Ef8eWubGJHgPIy4HwYQt5mTM+LzS89sqOkh3R7CPrePW8pSUPGUSV3VOLq5aKWw9uaQI0dtGL2uazvexGTiQCf67dTiGvRs83mmMJQHLydW9doSGdXEFKDTlC8dj1rkN61QWWOzpyn/AeB6ZASjbOnMlw0zYoq4X8SgCQreX5fPfC4v6gINRzW4LTo+TzUI2b/1mA1YYQIDAQAB";
  private AdColonyBridgeImpl adColonyImpl = null;
  private AccountHelper mAccountHelper = null;
  private boolean mDidDetectCrashDuringPreviousExecution = false;
  private GameServicesHelper mGameServicesHelper = null;
  private boolean mIsRunning = false;
  private String mLaunchOptions = "";
  BroadcastReceiver mSleepReceiver = null;
  public MobileAppTracker mobileAppTracker = null;
  private ShopAndroidJavaImpl shopImpl = null;
  
  public static AccountHelper GetAccountHelper()
  {
    return ((WotBlitz)GetActivity()).mAccountHelper;
  }
  
  public static AdColonyBridgeImpl GetAdColonyImpl()
  {
    return ((WotBlitz)GetActivity()).adColonyImpl;
  }
  
  public static GameServicesHelper GetGameServicesHelper()
  {
    return ((WotBlitz)GetActivity()).mGameServicesHelper;
  }
  
  public static int GetNotificationIconId()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (int i = 1; i != 0; i = 0) {
      return 2130837603;
    }
    return 2130837602;
  }
  
  public static ShopAndroidJavaImpl GetShopImpl()
  {
    return ((WotBlitz)GetActivity()).shopImpl;
  }
  
  private void shopInitializeIfNeeded()
  {
    if (this.shopImpl != null)
    {
      if (!this.shopImpl.isInitialized())
      {
        this.shopImpl.dispose();
        this.shopImpl = new ShopAndroidJavaImpl(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAogmFy2R9ZLHsm/GrQYbFsnPNwEj3iX+KXJUb5iO9GURhVWma23hCR+/MZRYOmSqq3/YgQzgXfCGbyZVoBf4HIDV+PcqpuVRnku9Rx1aFjxYATBkTqvc5UmDWERRiP50ZCqz+IKUNFpWS8Ef8eWubGJHgPIy4HwYQt5mTM+LzS89sqOkh3R7CPrePW8pSUPGUSV3VOLq5aKWw9uaQI0dtGL2uazvexGTiQCf67dTiGvRs83mmMJQHLydW9doSGdXEFKDTlC8dj1rkN61QWWOzpyn/AeB6ZASjbOnMlw0zYoq4X8SgCQreX5fPfC4v6gINRzW4LTo+TzUI2b/1mA1YYQIDAQAB");
      }
      return;
    }
    this.shopImpl = new ShopAndroidJavaImpl(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAogmFy2R9ZLHsm/GrQYbFsnPNwEj3iX+KXJUb5iO9GURhVWma23hCR+/MZRYOmSqq3/YgQzgXfCGbyZVoBf4HIDV+PcqpuVRnku9Rx1aFjxYATBkTqvc5UmDWERRiP50ZCqz+IKUNFpWS8Ef8eWubGJHgPIy4HwYQt5mTM+LzS89sqOkh3R7CPrePW8pSUPGUSV3VOLq5aKWw9uaQI0dtGL2uazvexGTiQCf67dTiGvRs83mmMJQHLydW9doSGdXEFKDTlC8dj1rkN61QWWOzpyn/AeB6ZASjbOnMlw0zYoq4X8SgCQreX5fPfC4v6gINRzW4LTo+TzUI2b/1mA1YYQIDAQAB");
  }
  
  public boolean DidDetectCrashDuringPreviousExecution()
  {
    return this.mDidDetectCrashDuringPreviousExecution;
  }
  
  public JNISurfaceView FindSurfaceView()
  {
    setContentView(2130903040);
    return (JNISurfaceView)findViewById(2131034165);
  }
  
  public int GetNotificationIcon()
  {
    return GetNotificationIconId();
  }
  
  public View GetSplashView()
  {
    return findViewById(2131034166);
  }
  
  public String dequeueLaunchOptions()
  {
    String str = this.mLaunchOptions;
    this.mLaunchOptions = "";
    return str;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mAccountHelper != null) {
      this.mAccountHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (this.shopImpl != null) {
      this.shopImpl.handleActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (this.mGameServicesHelper != null) {
      this.mGameServicesHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Session localSession = Session.getActiveSession();
    if (localSession != null) {
      localSession.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
    this.mSleepReceiver = new SleepReceiver();
    registerReceiver(this.mSleepReceiver, localIntentFilter);
    int i = 1;
    try
    {
      System.loadLibrary("crashlytics");
      if (i != 0)
      {
        Fabric.with(this, new Kit[] { new Crashlytics(), new CrashlyticsNdk(), new Answers() });
        FabricUserIdCrutch.Crutch();
        Chartboost.startWithAppId(this, "543d33441873da467e103a7c", "1846befde290c77ca679994604f015e156fbe48f");
        Chartboost.onCreate(this);
        MobileAppTracker.init(getApplicationContext(), "12276", "97bcc5a1a0e19598c20f47d97a5ad200");
        this.mobileAppTracker = MobileAppTracker.getInstance();
        ParseAnalytics.trackAppOpened(getIntent());
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(WotBlitz.this.getApplicationContext());
              String str = localInfo.getId();
              if (str != null) {
                Log.d("MobileAppTracker: advertisingId=", str);
              }
              WotBlitz.this.mobileAppTracker.setGoogleAdvertisingId(str, localInfo.isLimitAdTrackingEnabled());
              AndroidHelpers.setLimitAdTracking(localInfo.isLimitAdTrackingEnabled());
              AndroidHelpers.setAdvertisingId(str);
              return;
            }
            catch (IOException localIOException)
            {
              Log.d("MobileAppTracker: setting androidId to ", Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              WotBlitz.this.mobileAppTracker.setAndroidId(Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              return;
            }
            catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
            {
              Log.d("MobileAppTracker: setting androidId to ", Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              WotBlitz.this.mobileAppTracker.setAndroidId(Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              return;
            }
            catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
            {
              Log.d("MobileAppTracker: setting androidId to ", Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              WotBlitz.this.mobileAppTracker.setAndroidId(Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              return;
            }
            catch (NullPointerException localNullPointerException)
            {
              Log.d("MobileAppTracker: setting androidId to ", Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
              WotBlitz.this.mobileAppTracker.setAndroidId(Settings.Secure.getString(WotBlitz.this.getContentResolver(), "android_id"));
            }
          }
        }).start();
        shopInitializeIfNeeded();
        if (this.mGameServicesHelper == null) {
          this.mGameServicesHelper = new GameServicesHelper(this);
        }
        if (this.mAccountHelper == null)
        {
          this.mAccountHelper = new AccountHelper(this);
          this.mAccountHelper.onRestoreInstanceState(paramBundle);
        }
        if (this.adColonyImpl == null)
        {
          this.adColonyImpl = new AdColonyBridgeImpl();
          this.adColonyImpl.onCreate(this);
        }
        paramBundle = getIntent();
        if ((paramBundle == null) || (paramBundle.getExtras() == null)) {
          break label301;
        }
        this.mLaunchOptions = paramBundle.getExtras().getString("com.parse.Data");
        JNIBackupAgent.Restore(new BlitzRestoreObserver());
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        i = 0;
        continue;
        Fabric.with(this, new Kit[] { new Crashlytics(), new Answers() });
        continue;
        label301:
        this.mLaunchOptions = "";
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.shopImpl != null)
    {
      this.shopImpl.dispose();
      this.shopImpl = null;
    }
    if (this.mGameServicesHelper != null)
    {
      this.mGameServicesHelper.dispose();
      this.mGameServicesHelper = null;
    }
    if (this.mAccountHelper != null) {
      this.mAccountHelper = null;
    }
    if (this.adColonyImpl != null) {
      this.adColonyImpl = null;
    }
    unregisterReceiver(this.mSleepReceiver);
    this.mSleepReceiver = null;
    Chartboost.onDestroy(this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      this.mLaunchOptions = paramIntent.getString("com.parse.Data");
      return;
    }
    this.mLaunchOptions = "";
  }
  
  protected void onPause()
  {
    super.onPause();
    Chartboost.onPause(this);
    AdColonyBridgeImpl.onPause();
    this.mIsRunning = false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    AndroidHelpers.onRequestPermissionsResult(paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    this.mIsRunning = true;
    super.onResume();
    Crashlytics.setString("APP STATE", "Foreground");
    this.mobileAppTracker.setReferralSources(this);
    this.mobileAppTracker.measureSession();
    shopInitializeIfNeeded();
    Chartboost.onResume(this);
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancelAll();
    }
    AdColonyBridgeImpl.onResume(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mAccountHelper != null) {
      this.mAccountHelper.onSaveInstanceState(paramBundle);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    Chartboost.onStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    Chartboost.onStop(this);
  }
  
  class BlitzRestoreObserver
    extends RestoreObserver
  {
    BlitzRestoreObserver() {}
    
    public void onUpdate(int paramInt, String paramString)
    {
      Log.d("DAVA", "JNIBackupAgent::RestoreObserver::onUpdate, nowBeingRestored = " + paramInt + ", currentPackage = " + paramString);
    }
    
    public void restoreFinished(int paramInt)
    {
      Log.d("DAVA", "JNIBackupAgent::restoreFinished");
    }
    
    public void restoreStarting(int paramInt)
    {
      Log.d("DAVA", "JNIBackupAgent::RestoreObserver::restoreStarting, numPackages = " + paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/WotBlitz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */