package net.wargaming.wot.blitz;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.dava.framework.JNIApplication;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;

public class AnalyticsBridge
{
  private static Tracker googleAnalyticsTracker;
  private static boolean isTestMode = false;
  
  private static Product createGoogleAnalyticsProduct(String paramString1, String paramString2, float paramFloat)
  {
    return new Product().setId(paramString1).setName(paramString1).setPrice(paramFloat).setQuantity(1);
  }
  
  public static void logCheckout(String paramString1, String paramString2, float paramFloat)
  {
    if (googleAnalyticsTracker != null)
    {
      paramString1 = createGoogleAnalyticsProduct(paramString1, paramString2, paramFloat);
      ProductAction localProductAction = new ProductAction("checkout").setCheckoutStep(1);
      paramString1 = (HitBuilders.ScreenViewBuilder)((HitBuilders.ScreenViewBuilder)new HitBuilders.ScreenViewBuilder().addProduct(paramString1)).setProductAction(localProductAction);
      googleAnalyticsTracker.set("&cu", paramString2);
      googleAnalyticsTracker.send(paramString1.build());
      if (isTestMode) {
        ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics().dispatchLocalHits();
      }
    }
  }
  
  public static void logCustomEvent(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (googleAnalyticsTracker != null)
    {
      googleAnalyticsTracker.send(new HitBuilders.EventBuilder().setCategory(paramString1).setAction(paramString2).setLabel(paramString3).setValue(paramInt).build());
      if (isTestMode) {
        ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics().dispatchLocalHits();
      }
    }
  }
  
  public static void logNewSession()
  {
    if (googleAnalyticsTracker != null) {
      googleAnalyticsTracker.send(((HitBuilders.ScreenViewBuilder)new HitBuilders.ScreenViewBuilder().setNewSession()).build());
    }
  }
  
  public static void logRevenue(String paramString1, String paramString2, String paramString3, float paramFloat, String paramString4, String paramString5)
  {
    if (googleAnalyticsTracker != null)
    {
      paramString2 = createGoogleAnalyticsProduct(paramString2, paramString3, paramFloat);
      paramString1 = new ProductAction("purchase").setTransactionId(paramString1).setTransactionRevenue(paramFloat);
      paramString1 = (HitBuilders.ScreenViewBuilder)((HitBuilders.ScreenViewBuilder)new HitBuilders.ScreenViewBuilder().addProduct(paramString2)).setProductAction(paramString1);
      googleAnalyticsTracker.set("&cu", paramString3);
      googleAnalyticsTracker.send(paramString1.build());
      if (isTestMode) {
        ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics().dispatchLocalHits();
      }
    }
  }
  
  public static void logScreen(String paramString)
  {
    if (googleAnalyticsTracker != null)
    {
      googleAnalyticsTracker.setScreenName(paramString);
      googleAnalyticsTracker.send(new HitBuilders.ScreenViewBuilder().build());
      if (isTestMode) {
        ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics().dispatchLocalHits();
      }
    }
  }
  
  public static void sendEventToAnswers(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, long[] paramArrayOfLong)
  {
    paramString = (CustomEvent)((CustomEvent)((CustomEvent)new CustomEvent(paramString).putCustomAttribute("Manufacturer", Build.MANUFACTURER)).putCustomAttribute("Model", Build.MODEL)).putCustomAttribute("Version", Integer.valueOf(Build.VERSION.SDK_INT));
    int i;
    if (paramArrayOfString1.length == paramArrayOfString2.length)
    {
      i = 0;
      while (i < paramArrayOfString1.length)
      {
        paramString.putCustomAttribute(paramArrayOfString1[i], paramArrayOfString2[i]);
        Log.d("Answers", "string attributes: " + paramArrayOfString1[i] + " - " + paramArrayOfString2[i]);
        i += 1;
      }
    }
    Log.e("Answers", "string attributes: number of names and values doesn't match!");
    if (paramArrayOfString3.length == paramArrayOfLong.length)
    {
      i = 0;
      while (i < paramArrayOfString3.length)
      {
        paramString.putCustomAttribute(paramArrayOfString3[i], Long.valueOf(paramArrayOfLong[i]));
        Log.d("Answers", "long attributes: " + paramArrayOfString3[i] + " - " + paramArrayOfLong[i]);
        i += 1;
      }
    }
    Log.e("Answers", "long attributes: number of names and values doesn't match!");
    Answers.getInstance().logCustom(paramString);
  }
  
  public static void startSession(String paramString, boolean paramBoolean)
  {
    GoogleAnalytics localGoogleAnalytics = ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics();
    isTestMode = paramBoolean;
    if (localGoogleAnalytics != null)
    {
      if (paramBoolean) {
        localGoogleAnalytics.setLocalDispatchPeriod(20);
      }
      googleAnalyticsTracker = localGoogleAnalytics.newTracker(paramString);
      googleAnalyticsTracker.setAppVersion(AndroidHelpers.nativeGetAppVersion());
      googleAnalyticsTracker.enableAdvertisingIdCollection(true);
    }
  }
  
  public static void stopSession()
  {
    ((WotBlitzApp)JNIApplication.GetApplication()).getGoogleAnalytics();
    googleAnalyticsTracker = null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/AnalyticsBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */