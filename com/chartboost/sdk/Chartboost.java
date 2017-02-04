package com.chartboost.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Libraries.k;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.au;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.m;

public final class Chartboost
{
  protected static boolean a;
  protected static boolean b;
  protected static volatile Handler c;
  protected static k d;
  private static Chartboost e;
  private static CBImpressionActivity f;
  private static com.chartboost.sdk.Model.a g;
  private static ax h;
  private static az i;
  public static boolean isFirstHardBootup;
  private static m j;
  private static com.chartboost.sdk.Tracking.a k;
  private static boolean l;
  private static SparseBooleanArray m;
  private static f n;
  private static d o;
  private static boolean p;
  private static boolean q;
  private static Application.ActivityLifecycleCallbacks r;
  private static boolean s;
  private static Runnable t;
  private static Runnable u;
  
  static
  {
    boolean bool = true;
    e = null;
    f = null;
    g = null;
    h = null;
    i = null;
    j = null;
    k = null;
    l = false;
    m = new SparseBooleanArray();
    n = null;
    o = null;
    a = true;
    b = false;
    isFirstHardBootup = true;
    p = false;
    if (Build.VERSION.SDK_INT >= 14) {}
    for (;;)
    {
      q = bool;
      s = false;
      c = new Handler(Looper.getMainLooper());
      d = null;
      u = new Runnable()
      {
        public void run() {}
      };
      if (q) {
        r = new Application.ActivityLifecycleCallbacks()
        {
          public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
          {
            CBLogging.a("Chartboost", "######## onActivityCreated callback called");
            if (!(paramAnonymousActivity instanceof CBImpressionActivity)) {
              Chartboost.d(paramAnonymousActivity);
            }
          }
          
          public void onActivityDestroyed(Activity paramAnonymousActivity)
          {
            if (!(paramAnonymousActivity instanceof CBImpressionActivity))
            {
              CBLogging.a("Chartboost", "######## onActivityDestroyed callback called from developer side");
              Chartboost.i(paramAnonymousActivity);
              return;
            }
            CBLogging.a("Chartboost", "######## onActivityDestroyed callback called from CBImpressionactivity");
            Chartboost.b(paramAnonymousActivity);
          }
          
          public void onActivityPaused(Activity paramAnonymousActivity)
          {
            if (!(paramAnonymousActivity instanceof CBImpressionActivity))
            {
              CBLogging.a("Chartboost", "######## onActivityPaused callback called from developer side");
              Chartboost.g(paramAnonymousActivity);
              return;
            }
            CBLogging.a("Chartboost", "######## onActivityPaused callback called from CBImpressionactivity");
            Chartboost.b(k.a(paramAnonymousActivity));
          }
          
          public void onActivityResumed(Activity paramAnonymousActivity)
          {
            if (!(paramAnonymousActivity instanceof CBImpressionActivity))
            {
              CBLogging.a("Chartboost", "######## onActivityResumed callback called from developer side");
              Chartboost.f(paramAnonymousActivity);
              return;
            }
            CBLogging.a("Chartboost", "######## onActivityResumed callback called from CBImpressionactivity");
            Chartboost.a(k.a(paramAnonymousActivity));
          }
          
          public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
          
          public void onActivityStarted(Activity paramAnonymousActivity)
          {
            if (!(paramAnonymousActivity instanceof CBImpressionActivity))
            {
              CBLogging.a("Chartboost", "######## onActivityStarted callback called from developer side");
              Chartboost.e(paramAnonymousActivity);
              return;
            }
            CBLogging.a("Chartboost", "######## onActivityStarted callback called from CBImpressionactivity");
            Chartboost.a(paramAnonymousActivity);
          }
          
          public void onActivityStopped(Activity paramAnonymousActivity)
          {
            if (!(paramAnonymousActivity instanceof CBImpressionActivity))
            {
              CBLogging.a("Chartboost", "######## onActivityStopped callback called from developer side");
              Chartboost.h(paramAnonymousActivity);
              return;
            }
            CBLogging.a("Chartboost", "######## onActivityStopped callback called from CBImpressionactivity");
            Chartboost.c(k.a(paramAnonymousActivity));
          }
        };
      }
      return;
      bool = false;
    }
  }
  
  private Chartboost(Activity paramActivity, String paramString1, String paramString2)
  {
    e = this;
    CBUtility.a(c);
    c.a(paramActivity.getApplication());
    if (i()) {
      paramActivity.getApplication().registerActivityLifecycleCallbacks(r);
    }
    c.a(paramActivity.getApplicationContext());
    c.b(paramString1);
    c.c(paramString2);
    d = k.a(paramActivity);
    h = ax.a();
    n = f.a();
    i = az.a(c.y());
    j = i.a();
    o = d.a();
    k = com.chartboost.sdk.Tracking.a.a();
    h.a(c.y());
    b.a();
    b.g();
    h.a();
    t = new a(null);
    com.chartboost.sdk.Libraries.c.a();
    c.b(true);
    c.a(new c.a()
    {
      public void a()
      {
        ay localay = new ay("api/install");
        localay.a(true);
        localay.a(new g.k[] { com.chartboost.sdk.Libraries.g.a("status", com.chartboost.sdk.Libraries.a.a) });
        localay.t();
        Chartboost.j();
        Chartboost.isFirstHardBootup = false;
      }
    });
  }
  
  protected static void a()
  {
    if (c.y() == null)
    {
      CBLogging.b("Chartboost", "The context must be set through the Chartboost method onCreate() before calling startSession().");
      return;
    }
    p();
  }
  
  private static void a(int paramInt, boolean paramBoolean)
  {
    m.put(paramInt, paramBoolean);
  }
  
  protected static void a(Activity paramActivity)
  {
    h.b(c.y());
    if (!(paramActivity instanceof CBImpressionActivity))
    {
      j.a();
      i.e();
    }
    c.a(paramActivity.getApplicationContext());
    int i1;
    if (!(paramActivity instanceof CBImpressionActivity))
    {
      d = k.a(paramActivity);
      c(d, true);
      c.removeCallbacks(t);
      if ((c.b() == null) || (!c.b().doesWrapperUseCustomBackgroundingBehavior())) {
        break label109;
      }
      i1 = 1;
      label83:
      if ((paramActivity != null) && ((i1 != 0) || (q(paramActivity)))) {
        break label114;
      }
    }
    label109:
    label114:
    do
    {
      return;
      a((CBImpressionActivity)paramActivity);
      break;
      i1 = 0;
      break label83;
      b(k.a(paramActivity), true);
      if ((paramActivity instanceof CBImpressionActivity)) {
        s = false;
      }
      if (o.a(paramActivity, g)) {
        g = null;
      }
      paramActivity = o.c();
    } while (paramActivity == null);
    paramActivity.y();
  }
  
  protected static void a(CBImpressionActivity paramCBImpressionActivity)
  {
    if (!l)
    {
      c.a(paramCBImpressionActivity.getApplicationContext());
      f = paramCBImpressionActivity;
      l = true;
    }
    c.removeCallbacks(t);
  }
  
  protected static void a(k paramk)
  {
    paramk = d.a().c();
    if (CBUtility.a(CBFramework.CBFrameworkUnity)) {
      a();
    }
    if (paramk != null) {
      paramk.x();
    }
  }
  
  protected static void a(com.chartboost.sdk.Model.a parama)
  {
    boolean bool = true;
    Object localObject = h();
    if ((localObject != null) && (((f)localObject).d())) {
      parama.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!c.i()) {
            break label336;
          }
          if (!l) {
            break label163;
          }
          if ((f() == null) || (localObject == null)) {
            break label123;
          }
          if (parama.a != a.b.b) {
            break;
          }
          localObject = parama.B();
        } while (localObject == null);
        localObject = ((g)localObject).c();
      } while (localObject == null);
      CBLogging.b("Chartboost", "Unable to create the view while trying th display the impression");
      parama.a((CBError.CBImpressionError)localObject);
      localObject = f.a();
    } while (localObject == null);
    ((f)localObject).d(parama);
    return;
    ((f)localObject).a(parama);
    return;
    label123:
    if (f() == null)
    {
      CBLogging.b("Chartboost", "Activity not found. Cannot display the view");
      parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
      return;
    }
    CBLogging.b("Chartboost", "Missing view controller to manage the impression activity");
    parama.a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
    return;
    label163:
    if (!s())
    {
      parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
      return;
    }
    localObject = getHostActivity();
    if (localObject == null)
    {
      CBLogging.b("Chartboost", "Failed to display impression as the host activity reference has been lost!");
      parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
      return;
    }
    if ((g != null) && (g != parama))
    {
      parama.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
      return;
    }
    g = parama;
    parama = new Intent((Context)localObject, CBImpressionActivity.class);
    int i1;
    int i2;
    if ((((Activity)localObject).getWindow().getAttributes().flags & 0x400) != 0)
    {
      i1 = 1;
      if ((((Activity)localObject).getWindow().getAttributes().flags & 0x800) == 0) {
        break label326;
      }
      i2 = 1;
      label282:
      if ((i1 == 0) || (i2 != 0)) {
        break label331;
      }
    }
    for (;;)
    {
      parama.putExtra("paramFullscreen", bool);
      try
      {
        ((Activity)localObject).startActivity(parama);
        s = true;
        return;
      }
      catch (ActivityNotFoundException parama)
      {
        CBLogging.b("Chartboost", "Chartboost impression activity not declared in manifest. Please add the following inside your manifest's <application> tag: \n<activity android:name=\"com.chartboost.sdk.CBImpressionActivity\" android:theme=\"@android:style/Theme.Translucent.NoTitleBar\" android:excludeFromRecents=\"true\" />");
        return;
      }
      i1 = 0;
      break;
      label326:
      i2 = 0;
      break label282;
      label331:
      bool = false;
    }
    label336:
    localObject = h();
    if ((localObject != null) && (s()))
    {
      ((f)localObject).a(parama);
      return;
    }
    parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
  }
  
  protected static void a(Runnable paramRunnable)
  {
    if (!CBUtility.b())
    {
      c.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected static void b()
  {
    if (c.i())
    {
      c.postDelayed(u, 500L);
      return;
    }
    c();
  }
  
  protected static void b(Activity paramActivity)
  {
    b(k.a(paramActivity), false);
    paramActivity = d.a().c();
    f localf = h();
    if ((localf != null) && (paramActivity != null)) {
      localf.d(paramActivity);
    }
    g = null;
  }
  
  private static void b(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    a(paramActivity.hashCode(), paramBoolean);
  }
  
  protected static void b(k paramk)
  {
    paramk = d.a().c();
    if (paramk != null) {
      paramk.z();
    }
  }
  
  private static void b(k paramk, boolean paramBoolean) {}
  
  protected static void c()
  {
    if (k == null) {
      k = com.chartboost.sdk.Tracking.a.a();
    }
    k.c();
  }
  
  protected static void c(k paramk)
  {
    com.chartboost.sdk.Model.a locala = d.a().c();
    if ((locala != null) && (locala.a == a.b.a))
    {
      f localf = h();
      if ((g(paramk)) && (localf != null))
      {
        if (locala != null)
        {
          localf.c(locala);
          g = locala;
        }
        b(paramk, false);
      }
      if (!(paramk.get() instanceof CBImpressionActivity)) {
        c(paramk, false);
      }
    }
    h.c(c.y());
    if (!(paramk.get() instanceof CBImpressionActivity))
    {
      j.b();
      i.f();
    }
  }
  
  private static void c(k paramk, boolean paramBoolean)
  {
    if (paramk == null) {
      return;
    }
    a(paramk.a(), paramBoolean);
  }
  
  public static void cacheInterstitial(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local7 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "cacheInterstitial location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadInterstitial(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        ad.i().b(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.I()))
    {
      a(local7);
      return;
    }
    if ((c.N()) && (c.O()))
    {
      a(local7);
      return;
    }
    c.h().didFailToLoadInterstitial(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void cacheMoreApps(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local10 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "cacheMoreApps location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadMoreApps(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        au.i().b(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.K()))
    {
      a(local10);
      return;
    }
    if ((c.N()) && (c.Q()))
    {
      a(local10);
      return;
    }
    c.h().didFailToLoadMoreApps(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void cacheRewardedVideo(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "cacheRewardedVideo location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadRewardedVideo(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        ae.k().b(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.J()))
    {
      a(local5);
      return;
    }
    if ((c.N()) && (c.P()))
    {
      a(local5);
      return;
    }
    c.h().didFailToLoadRewardedVideo(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void clearCache()
  {
    if (!c.r()) {
      return;
    }
    bb.a().b();
    ae.k().a();
    ad.i().a();
    au.i().a();
    com.chartboost.sdk.InPlay.a.b();
  }
  
  public static void closeImpression()
  {
    a(new Runnable()
    {
      public void run()
      {
        if (!c.r()) {
          return;
        }
        Chartboost.e();
      }
    });
  }
  
  protected static boolean d()
  {
    return e();
  }
  
  protected static boolean d(k paramk)
  {
    if (paramk == null) {}
    do
    {
      return false;
      paramk = Boolean.valueOf(m.get(paramk.a()));
    } while (paramk == null);
    return paramk.booleanValue();
  }
  
  public static void didPassAgeGate(boolean paramBoolean)
  {
    c.c(paramBoolean);
  }
  
  protected static boolean e()
  {
    final d locald = d.a();
    Object localObject = locald.c();
    if ((localObject != null) && (((com.chartboost.sdk.Model.a)localObject).c == a.e.c))
    {
      if (((com.chartboost.sdk.Model.a)localObject).w()) {
        return true;
      }
      a(new Runnable()
      {
        public void run()
        {
          this.a.b();
        }
      });
      return true;
    }
    localObject = h();
    if ((localObject != null) && (((f)localObject).c()))
    {
      a(new Runnable()
      {
        public void run()
        {
          this.a.a(locald.c(), true);
        }
      });
      return true;
    }
    return false;
  }
  
  protected static Activity f()
  {
    if (c.i()) {
      return f;
    }
    return getHostActivity();
  }
  
  private static void f(k paramk)
  {
    if (!c.i()) {
      c(paramk);
    }
    if (!(paramk.get() instanceof CBImpressionActivity)) {
      c(paramk, false);
    }
    b();
  }
  
  private static void forwardTouchEventsAIR(boolean paramBoolean)
  {
    a(new Runnable()
    {
      public void run()
      {
        if (Chartboost.o() != null)
        {
          if (this.a) {
            Chartboost.o().forwardTouchEvents(Chartboost.getHostActivity());
          }
        }
        else {
          return;
        }
        Chartboost.o().forwardTouchEvents(null);
      }
    });
  }
  
  protected static void g()
  {
    if (l)
    {
      f = null;
      l = false;
    }
  }
  
  private static boolean g(k paramk)
  {
    if (c.i()) {
      if (paramk == null) {
        if (f != null) {}
      }
    }
    do
    {
      return true;
      return false;
      return paramk.b(f);
      if (d != null) {
        break;
      }
    } while (paramk == null);
    return false;
    return d.a(paramk);
  }
  
  public static boolean getAutoCacheAds()
  {
    return c.k();
  }
  
  public static String getCustomId()
  {
    return c.p();
  }
  
  public static a getDelegate()
  {
    return c.h();
  }
  
  protected static Activity getHostActivity()
  {
    if (d != null) {
      return (Activity)d.get();
    }
    return null;
  }
  
  public static boolean getImpressionsUseActivities()
  {
    return c.i();
  }
  
  public static CBLogging.Level getLoggingLevel()
  {
    return c.o();
  }
  
  public static String getSDKVersion()
  {
    return "6.4.1";
  }
  
  protected static Context getValidContext()
  {
    if (d != null) {
      return d.b();
    }
    return c.y();
  }
  
  protected static f h()
  {
    if (f() == null) {
      return null;
    }
    return n;
  }
  
  public static boolean hasInterstitial(String paramString)
  {
    if (!c.r()) {
      return false;
    }
    return ad.i().d(paramString);
  }
  
  public static boolean hasMoreApps(String paramString)
  {
    if (!c.r()) {
      return false;
    }
    return au.i().d(paramString);
  }
  
  public static boolean hasRewardedVideo(String paramString)
  {
    if (!c.r()) {
      return false;
    }
    return ae.k().d(paramString);
  }
  
  protected static boolean i()
  {
    return (q) && (p);
  }
  
  public static boolean isAnyViewVisible()
  {
    f localf = h();
    if (localf == null) {
      return false;
    }
    return localf.d();
  }
  
  public static boolean isWebViewEnabled()
  {
    return c.H().booleanValue();
  }
  
  private static void j(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        Chartboost.c(this.a);
      }
    });
  }
  
  private static void k(Activity paramActivity)
  {
    if ((d != null) && (!d.b(paramActivity)) && (s()))
    {
      f(d);
      c(d, false);
    }
    c.removeCallbacks(t);
    d = k.a(paramActivity);
    az.a(paramActivity).d();
  }
  
  private static void l(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        Chartboost.c.removeCallbacks(Chartboost.l());
        if ((Chartboost.d != null) && (!Chartboost.d.b(this.a)) && (Chartboost.m()))
        {
          Chartboost.e(Chartboost.d);
          Chartboost.a(Chartboost.d, false);
        }
        Chartboost.a(this.a, true);
        Chartboost.d = k.a(this.a);
        Chartboost.a();
        if (c.d) {
          c.b(this.a);
        }
        if (!Chartboost.isFirstHardBootup)
        {
          f localf = f.a();
          if ((localf != null) && (!localf.d())) {
            b.g();
          }
          b.a(com.chartboost.sdk.Libraries.h.b());
          ad.i().d();
          ae.k().d();
        }
        Chartboost.a(this.a);
      }
    });
  }
  
  private static void m(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    if (!b)
    {
      if (c.h() != null) {
        c.h().didInitialize();
      }
      b = true;
    }
    a(new Runnable()
    {
      public void run()
      {
        k localk = k.a(this.a);
        if (Chartboost.d(localk)) {
          Chartboost.a(localk);
        }
        while (!CBUtility.a(Chartboost.CBFramework.CBFrameworkUnity)) {
          return;
        }
        Chartboost.a();
      }
    });
  }
  
  private static void n(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        k localk = k.a(this.a);
        if (Chartboost.d(localk)) {
          Chartboost.b(localk);
        }
      }
    });
  }
  
  private static void o(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        k localk = k.a(this.a);
        if (Chartboost.d(localk)) {
          Chartboost.e(localk);
        }
      }
    });
  }
  
  public static boolean onBackPressed()
  {
    return r();
  }
  
  public static void onCreate(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    j(paramActivity);
  }
  
  public static void onDestroy(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    p(paramActivity);
  }
  
  public static void onPause(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    n(paramActivity);
  }
  
  public static void onResume(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    m(paramActivity);
  }
  
  public static void onStart(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    l(paramActivity);
  }
  
  public static void onStop(Activity paramActivity)
  {
    if (i()) {
      return;
    }
    o(paramActivity);
  }
  
  private static void p()
  {
    if (k == null) {
      k = com.chartboost.sdk.Tracking.a.a();
    }
    k.f();
    com.chartboost.sdk.Tracking.a.b();
    if (!isFirstHardBootup) {
      c.a(new c.a()
      {
        public void a()
        {
          ay localay = new ay("api/install");
          localay.a(true);
          localay.a(new g.k[] { com.chartboost.sdk.Libraries.g.a("status", com.chartboost.sdk.Libraries.a.a) });
          localay.t();
          Chartboost.j();
        }
      });
    }
  }
  
  private static void p(Activity paramActivity)
  {
    if ((!c.t()) || (!c.a(paramActivity))) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        if ((Chartboost.d == null) || (Chartboost.d.b(this.a)))
        {
          Chartboost.b(new Chartboost.a(null));
          Chartboost.l().run();
        }
        Chartboost.b(this.a);
      }
    });
  }
  
  private static void q()
  {
    c.C();
    try
    {
      if (c.H().booleanValue())
      {
        b.b();
        return;
      }
      if (c.N())
      {
        h.b();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static boolean q(Activity paramActivity)
  {
    if (c.i()) {
      if (f != paramActivity) {}
    }
    do
    {
      return true;
      return false;
      if (d != null) {
        break;
      }
    } while (paramActivity == null);
    return false;
    return d.b(paramActivity);
  }
  
  private static boolean r()
  {
    if (!c.t()) {}
    do
    {
      return false;
      if (d == null)
      {
        CBLogging.b("Chartboost", "The Chartboost methods onCreate(), onStart(), onStop(), and onDestroy() must be called in the corresponding methods of your activity in order for Chartboost to function properly.");
        return false;
      }
      if (!c.i()) {
        break;
      }
    } while (!s);
    s = false;
    d();
    return true;
    return d();
  }
  
  private static boolean s()
  {
    return d(d);
  }
  
  public static void setActivityCallbacks(boolean paramBoolean)
  {
    Activity localActivity = getHostActivity();
    if (localActivity != null)
    {
      if ((!q) || (p) || (!paramBoolean)) {
        break label39;
      }
      localActivity.getApplication().registerActivityLifecycleCallbacks(r);
      p = paramBoolean;
    }
    label39:
    while ((!p) || (paramBoolean)) {
      return;
    }
    localActivity.getApplication().unregisterActivityLifecycleCallbacks(r);
    p = paramBoolean;
  }
  
  public static void setAutoCacheAds(boolean paramBoolean)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a);
      }
    });
  }
  
  public static void setCustomId(String paramString)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.d(this.a);
      }
    });
  }
  
  public static void setDelegate(ChartboostDelegate paramChartboostDelegate)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a);
      }
    });
  }
  
  public static void setFramework(CBFramework paramCBFramework)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a);
      }
    });
  }
  
  public static void setFramework(CBFramework paramCBFramework, final String paramString)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a, paramString);
      }
    });
  }
  
  public static void setFrameworkVersion(String paramString)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a);
      }
    });
  }
  
  public static void setImpressionsUseActivities(boolean paramBoolean)
  {
    c.a = paramBoolean;
  }
  
  public static void setLoggingLevel(CBLogging.Level paramLevel)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a);
      }
    });
  }
  
  public static void setMediation(CBMediation paramCBMediation, final String paramString)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.a(this.a, paramString);
      }
    });
  }
  
  public static void setShouldDisplayLoadingViewForMoreApps(boolean paramBoolean)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.f(this.a);
      }
    });
  }
  
  public static void setShouldHideSystemUI(Boolean paramBoolean)
  {
    c.a(paramBoolean);
  }
  
  public static void setShouldPauseClickForConfirmation(boolean paramBoolean)
  {
    c.d(paramBoolean);
  }
  
  public static void setShouldPrefetchVideoContent(boolean paramBoolean)
  {
    if (!c.r()) {
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        c.g(this.a);
        boolean bool = c.H().booleanValue();
        if ((this.a) && (Chartboost.n()))
        {
          if (bool)
          {
            b.b();
            return;
          }
          h.b();
          return;
        }
        if (bool)
        {
          b.e();
          return;
        }
        h.e();
      }
    });
  }
  
  public static void setShouldRequestInterstitialsInFirstSession(boolean paramBoolean)
  {
    a(new Runnable()
    {
      public void run()
      {
        c.e(this.a);
      }
    });
  }
  
  public static void showInterstitial(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local8 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "showInterstitial location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadInterstitial(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        ad.i().a(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.I()))
    {
      a(local8);
      return;
    }
    if ((c.N()) && (c.O()))
    {
      a(local8);
      return;
    }
    c.h().didFailToLoadInterstitial(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  private static void showInterstitialAIR(String paramString, final boolean paramBoolean)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local25 = new Runnable()
    {
      public void run()
      {
        ad.i().b(this.a, paramBoolean);
      }
    };
    if ((c.H().booleanValue()) && (c.I()))
    {
      a(local25);
      return;
    }
    if ((c.N()) && (c.O()))
    {
      a(local25);
      return;
    }
    c.h().didFailToLoadInterstitial(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void showMoreApps(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local11 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "showMoreApps location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadMoreApps(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        au.i().a(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.K()))
    {
      a(local11);
      return;
    }
    if ((c.N()) && (c.Q()))
    {
      a(local11);
      return;
    }
    c.h().didFailToLoadMoreApps(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  private static void showMoreAppsAIR(String paramString, final boolean paramBoolean)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local26 = new Runnable()
    {
      public void run()
      {
        au.i().b(this.a, paramBoolean);
      }
    };
    if ((c.H().booleanValue()) && (c.K()))
    {
      a(local26);
      return;
    }
    if ((c.N()) && (c.Q()))
    {
      a(local26);
      return;
    }
    c.h().didFailToLoadMoreApps(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void showRewardedVideo(String paramString)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local6 = new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(this.a))
        {
          CBLogging.b("Chartboost", "showRewardedVideo location cannot be empty");
          if (c.h() != null) {
            c.h().didFailToLoadRewardedVideo(this.a, CBError.CBImpressionError.INVALID_LOCATION);
          }
          return;
        }
        ae.k().a(this.a);
      }
    };
    if ((c.H().booleanValue()) && (c.J()))
    {
      a(local6);
      return;
    }
    if ((c.N()) && (c.P()))
    {
      a(local6);
      return;
    }
    c.h().didFailToLoadRewardedVideo(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  private static void showRewardedVideoAIR(String paramString, final boolean paramBoolean)
  {
    if (!c.r()) {}
    while (!t()) {
      return;
    }
    Runnable local27 = new Runnable()
    {
      public void run()
      {
        ae.k().b(this.a, paramBoolean);
      }
    };
    if ((c.H().booleanValue()) && (c.J()))
    {
      a(local27);
      return;
    }
    if ((c.N()) && (c.P()))
    {
      a(local27);
      return;
    }
    c.h().didFailToLoadRewardedVideo(paramString, CBError.CBImpressionError.END_POINT_DISABLED);
  }
  
  public static void startWithAppId(Activity paramActivity, final String paramString1, final String paramString2)
  {
    a(new Runnable()
    {
      public void run()
      {
        if (Chartboost.k() == null)
        {
          try
          {
            if (Chartboost.k() != null) {
              break label146;
            }
            if ((this.a == null) && (!(this.a instanceof Activity)))
            {
              CBLogging.b("Chartboost", "Activity object is null. Please pass a valid activity object");
              return;
            }
            if (!c.b(this.a))
            {
              CBLogging.b("Chartboost", "Permissions not set correctly");
              return;
            }
          }
          finally {}
          if (!c.c(this.a))
          {
            CBLogging.b("Chartboost", "CBImpression Activity not added in your manifest.xml");
            return;
          }
          if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
          {
            CBLogging.b("Chartboost", "AppId or AppSignature is null. Please pass a valid id's");
            return;
          }
          Chartboost.a(new Chartboost(this.a, paramString1, paramString2, null));
        }
        label146:
      }
    });
  }
  
  private static boolean t()
  {
    if (c.T().booleanValue()) {
      try
      {
        throw new Exception("Chartboost Integration Warning: your account has been set to advertiser only. This function has been disabled. Please contact support if you expect this call to function.");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public static enum CBFramework
  {
    private final String a;
    
    static
    {
      CBFrameworkCorona = new CBFramework("CBFrameworkCorona", 1, "Corona");
      CBFrameworkAir = new CBFramework("CBFrameworkAir", 2, "AIR");
      CBFrameworkGameSalad = new CBFramework("CBFrameworkGameSalad", 3, "GameSalad");
      CBFrameworkCordova = new CBFramework("CBFrameworkCordova", 4, "Cordova");
      CBFrameworkCocoonJS = new CBFramework("CBFrameworkCocoonJS", 5, "CocoonJS");
      CBFrameworkCocos2dx = new CBFramework("CBFrameworkCocos2dx", 6, "Cocos2dx");
      CBFrameworkPrime31Unreal = new CBFramework("CBFrameworkPrime31Unreal", 7, "Prime31Unreal");
      CBFrameworkWeeby = new CBFramework("CBFrameworkWeeby", 8, "Weeby");
    }
    
    private CBFramework(String paramString)
    {
      this.a = paramString;
    }
    
    public boolean doesWrapperUseCustomBackgroundingBehavior()
    {
      return this == CBFrameworkAir;
    }
    
    public boolean doesWrapperUseCustomShouldDisplayBehavior()
    {
      return (this == CBFrameworkAir) || (this == CBFrameworkCocos2dx);
    }
    
    public String toString()
    {
      return this.a;
    }
  }
  
  public static enum CBMediation
  {
    private final String a;
    
    private CBMediation(String paramString)
    {
      this.a = paramString;
    }
    
    public String toString()
    {
      return this.a;
    }
  }
  
  private static class a
    implements Runnable
  {
    private int a;
    private int b;
    private int c;
    
    private a()
    {
      a locala = a();
      if (Chartboost.o() == null)
      {
        i = -1;
        this.a = i;
        if (Chartboost.d != null) {
          break label59;
        }
        i = -1;
        label32:
        this.b = i;
        if (locala != null) {
          break label69;
        }
      }
      label59:
      label69:
      for (int i = j;; i = locala.hashCode())
      {
        this.c = i;
        return;
        i = Chartboost.o().hashCode();
        break;
        i = Chartboost.d.hashCode();
        break label32;
      }
    }
    
    private a a()
    {
      return c.h();
    }
    
    public void run()
    {
      a locala = a();
      if ((Chartboost.d != null) && (Chartboost.d.hashCode() == this.b)) {
        Chartboost.d = null;
      }
      if ((locala != null) && (locala.hashCode() == this.c)) {
        c.a(null);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Chartboost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */