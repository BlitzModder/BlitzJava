package net.wargaming.wot.blitz;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.dava.framework.JNIActivity;
import com.dava.framework.JNIApplication;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.mobileapptracker.MATEvent;
import com.mobileapptracker.MATEventItem;
import com.mobileapptracker.MobileAppTracker;
import java.util.Arrays;
import java.util.UUID;

public class AndroidHelpers
{
  static final int ANDROID_HELPERS_PHONE_STATE_PERMISSION_REQUEST = 100;
  private static String advertisingId;
  private static boolean limitAdTracking;
  private static PowerManager.WakeLock wakeLock;
  
  public static void acquirePartialWakeLock()
  {
    if (wakeLock == null) {
      wakeLock = ((PowerManager)JNIApplication.GetApplication().getApplicationContext().getSystemService("power")).newWakeLock(1, "BlitzWakelock");
    }
    Log.i("DAVA", "wakeLock.acquire()");
    wakeLock.acquire();
  }
  
  public static String getAdvertisingId()
  {
    return advertisingId;
  }
  
  public static String getAndroidId()
  {
    return Settings.Secure.getString(JNIApplication.GetApplication().getApplicationContext().getContentResolver(), "android_id");
  }
  
  public static float getAndroidVersion()
  {
    try
    {
      float f = Float.valueOf(Build.VERSION.RELEASE.substring(0, 2)).floatValue();
      return f;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0.0F;
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static String getGuidForPartnerAnalytics()
  {
    return UUID.randomUUID().toString().replace("{", "").replace("-", "").replace("}", "");
  }
  
  public static String getMATId()
  {
    return MobileAppTracker.getInstance().getMatId();
  }
  
  public static String getPackageName()
  {
    return JNIApplication.GetApplication().getApplicationContext().getPackageName();
  }
  
  public static boolean isGooglePlayServicesAvailable()
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(JNIApplication.GetApplication().getApplicationContext());
    return (i == 0) || (GooglePlayServicesUtil.isUserRecoverableError(i));
  }
  
  public static boolean isLimitAdTrackingEnabled()
  {
    return limitAdTracking;
  }
  
  public static native void nativeDeviceIdResponse(String paramString);
  
  public static native String nativeGetAppVersion();
  
  public static native boolean nativeGetUsePublicAnalyticsKeys();
  
  public static void onRequestPermissionsResult(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals("android.permission.READ_PHONE_STATE"))
      {
        if (paramArrayOfInt[i] != 0) {
          break label52;
        }
        nativeDeviceIdResponse(((TelephonyManager)JNIApplication.GetApplication().getApplicationContext().getSystemService("phone")).getDeviceId());
      }
      for (;;)
      {
        i += 1;
        break;
        label52:
        nativeDeviceIdResponse("");
      }
    }
  }
  
  public static void releasePartialWakeLock()
  {
    if (wakeLock != null)
    {
      Log.i("DAVA", "wakeLock.release()");
      wakeLock.release();
    }
  }
  
  public static void requestDeviceId(boolean paramBoolean)
  {
    Context localContext = JNIApplication.GetApplication().getApplicationContext();
    if (ContextCompat.checkSelfPermission(localContext, "android.permission.READ_PHONE_STATE") == 0)
    {
      nativeDeviceIdResponse(((TelephonyManager)localContext.getSystemService("phone")).getDeviceId());
      return;
    }
    if (paramBoolean)
    {
      ActivityCompat.requestPermissions(JNIActivity.GetActivity(), new String[] { "android.permission.READ_PHONE_STATE" }, 100);
      return;
    }
    nativeDeviceIdResponse("");
  }
  
  public static void sendMATEvent(String paramString)
  {
    MobileAppTracker.getInstance().measureEvent(paramString);
  }
  
  public static void sendRevenueMATEvent(String paramString1, float paramFloat, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new MATEventItem(paramString1).withUnitPrice(paramFloat).withQuantity(1);
    MobileAppTracker.getInstance().measureEvent(new MATEvent("purchase").withRevenue(paramFloat).withCurrencyCode(paramString2).withReceipt(paramString3, paramString4).withEventItems(Arrays.asList(new MATEventItem[] { paramString1 })));
  }
  
  public static void setAdvertisingId(String paramString)
  {
    advertisingId = paramString;
  }
  
  public static void setLimitAdTracking(boolean paramBoolean)
  {
    limitAdTracking = paramBoolean;
  }
  
  public static void setMATUserId(String paramString)
  {
    MobileAppTracker.getInstance().setUserId(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/AndroidHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */