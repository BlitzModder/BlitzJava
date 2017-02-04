package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.ArrayList;
import java.util.HashMap;

public class AdColony
{
  static boolean b = true;
  static boolean c;
  boolean a = false;
  
  static void a()
  {
    l.c.b("[ADC] AdColony pause called.");
    a.r = true;
    a.B = true;
    int i = 0;
    while (i < a.aq.size())
    {
      if (a.aq.get(i) != null)
      {
        AdColonyNativeAdView localAdColonyNativeAdView = (AdColonyNativeAdView)a.aq.get(i);
        localAdColonyNativeAdView.A = true;
        if ((localAdColonyNativeAdView.ag != null) && (!localAdColonyNativeAdView.u) && (localAdColonyNativeAdView.ag.isPlaying()))
        {
          if (a.E) {
            localAdColonyNativeAdView.T.setVisibility(0);
          }
          localAdColonyNativeAdView.c();
        }
      }
      i += 1;
    }
  }
  
  static void a(Activity paramActivity)
  {
    l.c.b("[ADC] AdColony resume called.");
    a.B = false;
    a.r = false;
    a.a(paramActivity);
    a.A = false;
    a.h();
    if (paramActivity == null)
    {
      l.d.b("Activity reference is null. Disabling AdColony.");
      disable();
      return;
    }
    if ((a.v != null) && (!(paramActivity instanceof ADCVideo)))
    {
      a.W.a(a.v);
      a.v = null;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        this.a.runOnUiThread(new Runnable()
        {
          public void run()
          {
            int i = 0;
            while (i < a.aq.size())
            {
              AdColonyNativeAdView localAdColonyNativeAdView = (AdColonyNativeAdView)a.aq.get(i);
              if ((a.b() != null) && (localAdColonyNativeAdView != null) && (a.b() == localAdColonyNativeAdView.d) && (!localAdColonyNativeAdView.u))
              {
                localAdColonyNativeAdView.A = false;
                localAdColonyNativeAdView.invalidate();
                if (localAdColonyNativeAdView.T != null)
                {
                  localAdColonyNativeAdView.T.a = false;
                  localAdColonyNativeAdView.T.invalidate();
                }
              }
              i += 1;
            }
          }
        });
      }
    }).start();
    a.M = false;
  }
  
  public static Activity activity()
  {
    return a.b();
  }
  
  public static void addAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    if (a.ap.contains(paramAdColonyAdAvailabilityListener)) {
      return;
    }
    a.ap.add(paramAdColonyAdAvailabilityListener);
  }
  
  public static void addV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    if (a.ao.contains(paramAdColonyV4VCListener)) {
      return;
    }
    a.ao.add(paramAdColonyV4VCListener);
  }
  
  public static void cancelVideo()
  {
    if (a.U != null)
    {
      a.U.finish();
      a.ak = true;
      a.W.b(null);
    }
  }
  
  public static void configure(Activity paramActivity, String paramString1, String paramString2, String... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      l.d.b("AdColony requires API version 14 or higher.");
      disable();
    }
    for (;;)
    {
      return;
      if (b) {
        paramActivity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
        {
          public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
          {
            if (a.P == null) {
              a.y = false;
            }
            a.a(paramAnonymousActivity);
          }
          
          public void onActivityDestroyed(Activity paramAnonymousActivity) {}
          
          public void onActivityPaused(Activity paramAnonymousActivity) {}
          
          public void onActivityResumed(Activity paramAnonymousActivity)
          {
            AdColony.a(paramAnonymousActivity);
          }
          
          public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
          
          public void onActivityStarted(Activity paramAnonymousActivity) {}
          
          public void onActivityStopped(Activity paramAnonymousActivity) {}
        });
      }
      c = false;
      if (!b)
      {
        a.ao.clear();
        a.ap.clear();
        a.a(paramActivity);
        return;
      }
      b = false;
      new a(paramActivity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      a.aq.clear();
      Handler localHandler = new Handler();
      Runnable local2 = new Runnable()
      {
        public void run()
        {
          a.H = false;
        }
      };
      if ((!a.H) || (a.I))
      {
        if (!a.y)
        {
          if (paramString2 == null)
          {
            a.a("Null App ID - disabling AdColony.");
            return;
          }
          if (paramVarArgs == null)
          {
            a.a("Null Zone IDs array - disabling AdColony.");
            return;
          }
          if (paramVarArgs.length == 0)
          {
            a.a("No Zone IDs provided - disabling AdColony.");
            return;
          }
          a.b(paramActivity);
          a.l.a(paramString1, paramString2, paramVarArgs);
          a.w = true;
          a.H = true;
          localHandler.postDelayed(local2, 120000L);
        }
      }
      else
      {
        if (a.U == null) {
          a.E = true;
        }
        a.ao.clear();
        a.ap.clear();
        a.ar = new HashMap();
        int i = 0;
        while (i < paramVarArgs.length)
        {
          a.ar.put(paramVarArgs[i], Boolean.valueOf(false));
          i += 1;
        }
      }
    }
  }
  
  public static void disable()
  {
    a.y = true;
  }
  
  public static void disableDECOverride()
  {
    a.e = null;
  }
  
  public static void forceMobileCache()
  {
    if (!a.N)
    {
      a.N = true;
      a.H = false;
      a.l.b.d = true;
      a.l.b.b = false;
      a.l.b.c = true;
    }
  }
  
  public static String getCustomID()
  {
    return a.l.a.y;
  }
  
  public static String getDeviceID()
  {
    return a.l.a.z;
  }
  
  public static void get_images(String paramString)
  {
    a.l.a.b(paramString);
  }
  
  public static boolean isConfigured()
  {
    return !b;
  }
  
  public static boolean isTablet()
  {
    return g.i();
  }
  
  public static boolean isZoneNative(String paramString)
  {
    if (a.l == null) {}
    for (;;)
    {
      return false;
      if ((a.l.b != null) && (a.l.b.i != null) && (a.l.b.i.o != null) && (a.l.b.i.o.a(paramString) != null) && (a.l.b.i.o.a(paramString).m != null) && (a.l.b.i.o.a(paramString).m.a != null))
      {
        int i = 0;
        while (i < a.l.b.i.o.a(paramString).m.a.size())
        {
          if (a.l.b.i.o.a(paramString).m.a(i).A.a) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isZoneV4VC(String paramString)
  {
    if (a.l == null) {}
    while ((a.l.b == null) || (a.l.b.i == null) || (a.l.b.i.o == null)) {
      return false;
    }
    return a.l.b.a(paramString, false);
  }
  
  public static void notifyIAPComplete(String paramString1, String paramString2)
  {
    notifyIAPComplete(paramString1, paramString2, null, 0.0D);
  }
  
  public static void notifyIAPComplete(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    l.c.b("notifyIAPComplete() called.");
    ADCData.g localg = new ADCData.g();
    localg.b("product_id", paramString1);
    if (paramDouble != 0.0D) {
      localg.b("price", paramDouble);
    }
    localg.b("trans_id", paramString2);
    localg.b("quantity", 1);
    if (paramString3 != null) {
      localg.b("price_currency_code", paramString3);
    }
    if (a.O)
    {
      a.l.d.a("in_app_purchase", localg);
      return;
    }
    a.aj.a(localg);
  }
  
  public static void onBackPressed()
  {
    if ((a.S != null) && (((a.S instanceof ab)) || ((a.S instanceof ac)))) {
      ((ViewGroup)a.S.getParent()).removeView(a.S);
    }
  }
  
  public static void pause() {}
  
  public static void removeAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    a.ap.remove(paramAdColonyAdAvailabilityListener);
  }
  
  public static void removeV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    a.ao.remove(paramAdColonyV4VCListener);
  }
  
  public static void resume(Activity paramActivity) {}
  
  public static void setCustomID(String paramString)
  {
    if ((!paramString.equals(a.l.a.y)) && (a.l != null) && (a.l.b != null))
    {
      a.l.a.y = paramString;
      if (a.x) {
        a.l.b.h();
      }
    }
  }
  
  public static void setDeviceID(String paramString)
  {
    if (!paramString.equals(a.l.a.z))
    {
      a.l.a.z = paramString;
      a.H = false;
      a.l.b.d = true;
      a.l.b.b = false;
      a.l.b.c = true;
    }
  }
  
  public static String statusForZone(String paramString)
  {
    if ((a.l == null) || (a.l.b == null) || (a.l.b.i == null) || (a.l.b.i.o == null)) {
      return "unknown";
    }
    if (a.y) {
      return "unknown";
    }
    n.ad localad = a.l.b.i.o.a(paramString);
    if (localad != null)
    {
      if (!localad.g) {
        return "off";
      }
      if ((localad.h) && (a.l.b.c(paramString, true))) {
        return "active";
      }
      return "loading";
    }
    if (!a.x) {
      return "unknown";
    }
    return "invalid";
  }
  
  private static class a
    extends AsyncTask<Void, Void, Void>
  {
    Activity a;
    String b = "";
    boolean c;
    
    a(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    protected Void a(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
        this.b = paramVarArgs.getId();
        this.c = paramVarArgs.isLimitAdTrackingEnabled();
      }
      catch (NoClassDefFoundError paramVarArgs)
      {
        l.d.b("Google Play Services SDK not installed! Collecting Android Id instead of Advertising Id.");
        return null;
      }
      catch (NoSuchMethodError paramVarArgs)
      {
        l.d.b("Google Play Services SDK is out of date! Collecting Android Id instead of Advertising Id.");
        return null;
      }
      catch (Exception paramVarArgs)
      {
        while (Build.MANUFACTURER.equals("Amazon")) {}
        l.d.b("Advertising Id not available! Collecting Android Id instead of Advertising Id.");
        paramVarArgs.printStackTrace();
      }
      return null;
      return null;
    }
    
    protected void a(Void paramVoid)
    {
      g.a = this.b;
      g.b = this.c;
      AdColony.c = true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */