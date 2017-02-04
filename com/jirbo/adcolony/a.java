package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class a
{
  static boolean A = false;
  static boolean B = false;
  static boolean C = false;
  static boolean D = false;
  static boolean E = true;
  static int F = 0;
  static double G = 1.0D;
  static boolean H = false;
  static boolean I = false;
  static boolean J = false;
  static boolean K = false;
  static boolean L = true;
  static boolean M = false;
  static boolean N = false;
  static boolean O = false;
  static Activity P;
  static boolean Q = false;
  static boolean R = false;
  static h S;
  static AdColonyAd T;
  static ADCVideo U;
  static ADCVideo V;
  static a W;
  static b X;
  static boolean Y = false;
  static boolean Z = false;
  public static final boolean a = false;
  static boolean aa = false;
  static boolean ab = false;
  static int ac = 0;
  static String ad;
  static String ae;
  static String af;
  static String ag;
  static String ah;
  static ArrayList<String> ai = new ArrayList();
  static ADCData.c aj = new ADCData.c();
  static boolean ak = false;
  static long al = 0L;
  static int am = 0;
  static ArrayList<Bitmap> an = new ArrayList();
  static ArrayList<AdColonyV4VCListener> ao = new ArrayList();
  static ArrayList<AdColonyAdAvailabilityListener> ap = new ArrayList();
  static ArrayList<AdColonyNativeAdView> aq = new ArrayList();
  static HashMap ar;
  public static final boolean b = false;
  public static final boolean c = false;
  public static final boolean d = false;
  public static String e = null;
  public static final String f = null;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  static final String k = "AdColony";
  static d l = new d();
  static boolean m;
  static int n = 2;
  static boolean o;
  static boolean p;
  static double q;
  static boolean r;
  static boolean s;
  static long t;
  static long u;
  static AdColonyAd v;
  static boolean w;
  static boolean x;
  static boolean y;
  static boolean z;
  
  static void a(int paramInt)
  {
    boolean bool2 = false;
    n = paramInt;
    l locall = l.a;
    if (paramInt <= 0)
    {
      bool1 = true;
      locall.f = bool1;
      locall = l.b;
      if (paramInt > 1) {
        break label96;
      }
      bool1 = true;
      label32:
      locall.f = bool1;
      locall = l.c;
      if (paramInt > 2) {
        break label101;
      }
    }
    label96:
    label101:
    for (boolean bool1 = true;; bool1 = false)
    {
      locall.f = bool1;
      locall = l.d;
      bool1 = bool2;
      if (paramInt <= 3) {
        bool1 = true;
      }
      locall.f = bool1;
      if (paramInt <= 0) {
        b("DEVELOPER LOGGING ENABLED");
      }
      if (paramInt <= 1) {
        c("DEBUG LOGGING ENABLED");
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
    }
  }
  
  static void a(int paramInt, String paramString)
  {
    if (n <= paramInt) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      Log.d("AdColony", paramString);
      return;
    case 2: 
      Log.i("AdColony", paramString);
      return;
    }
    Log.e("AdColony", paramString);
  }
  
  static void a(Activity paramActivity)
  {
    if ((paramActivity == P) || (paramActivity == null)) {}
    do
    {
      return;
      P = paramActivity;
      W = new a();
      X = new b();
    } while (s);
    new p.a();
  }
  
  static void a(AdColonyAd paramAdColonyAd)
  {
    v = paramAdColonyAd;
  }
  
  static void a(AdColonyNativeAdView paramAdColonyNativeAdView)
  {
    aq.add(paramAdColonyNativeAdView);
  }
  
  static void a(j paramj)
  {
    l.a(paramj);
  }
  
  static void a(RuntimeException paramRuntimeException)
  {
    Q = true;
    e(paramRuntimeException.toString());
    paramRuntimeException.printStackTrace();
  }
  
  static void a(String paramString)
  {
    Q = true;
    e(paramString);
  }
  
  static void a(String paramString, AdColonyAd paramAdColonyAd)
  {
    l.a(paramString, null, paramAdColonyAd);
  }
  
  static void a(String paramString1, String paramString2)
  {
    l.a(paramString1, paramString2);
  }
  
  static void a(String paramString1, String paramString2, AdColonyAd paramAdColonyAd)
  {
    l.a(paramString1, paramString2, paramAdColonyAd);
  }
  
  static boolean a()
  {
    return P == null;
  }
  
  static Activity b()
  {
    if (P == null)
    {
      l.d.b("AdColony methods used before initialization, Activity reference is null. Disabling AdColony until next launch.");
      AdColony.disable();
      return null;
    }
    return P;
  }
  
  static void b(Activity paramActivity)
  {
    x = false;
    a(paramActivity);
    S = null;
    m = g.i();
    if (Q)
    {
      Q = false;
      w = false;
      l = new d();
    }
  }
  
  static void b(String paramString)
  {
    a(0, paramString);
  }
  
  static boolean b(int paramInt)
  {
    return n <= paramInt;
  }
  
  static void c(String paramString)
  {
    a(1, paramString);
  }
  
  static boolean c()
  {
    return (Q) || (y) || (!w);
  }
  
  static void d(String paramString)
  {
    a(2, paramString);
  }
  
  static boolean d()
  {
    return (w) && (!Q) && (!y);
  }
  
  static void e()
  {
    b();
  }
  
  static void e(String paramString)
  {
    a(3, paramString);
  }
  
  static void f(String paramString)
  {
    if (b() != null) {
      Toast.makeText(b(), paramString, 0).show();
    }
  }
  
  static boolean f()
  {
    return n <= 0;
  }
  
  static double g(String paramString)
  {
    return l.a(paramString);
  }
  
  static boolean g()
  {
    return n <= 1;
  }
  
  static int h(String paramString)
  {
    return l.b(paramString);
  }
  
  static void h()
  {
    if (l == null) {
      break label6;
    }
    label6:
    while ((ap.size() == 0) || (ar == null)) {
      return;
    }
    Iterator localIterator = ar.entrySet().iterator();
    label103:
    label244:
    label256:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      boolean bool2 = ((Boolean)localEntry.getValue()).booleanValue();
      boolean bool1;
      if (AdColony.isZoneV4VC((String)localEntry.getKey()))
      {
        bool1 = l.b((String)localEntry.getKey(), true, false);
        if ((!AdColony.isZoneNative((String)localEntry.getKey())) || (b() == null)) {
          break label244;
        }
        bool1 = new AdColonyNativeAdView(b(), (String)localEntry.getKey(), 300, true).b(true);
      }
      for (;;)
      {
        if (bool2 == bool1) {
          break label256;
        }
        ar.put(localEntry.getKey(), Boolean.valueOf(bool1));
        int i1 = 0;
        while (i1 < ap.size())
        {
          ((AdColonyAdAvailabilityListener)ap.get(i1)).onAdColonyAdAvailabilityChange(bool1, (String)localEntry.getKey());
          i1 += 1;
        }
        break;
        bool1 = l.a((String)localEntry.getKey(), true, false);
        break label103;
        if (b() == null) {
          bool1 = false;
        }
      }
    }
  }
  
  static boolean i(String paramString)
  {
    return l.c(paramString);
  }
  
  static String j(String paramString)
  {
    return l.d(paramString);
  }
  
  static void k(String paramString)
  {
    l.a(paramString, null);
  }
  
  static class a
    extends Handler
  {
    AdColonyAd a;
    
    public void a(AdColonyAd paramAdColonyAd)
    {
      if (paramAdColonyAd == null) {}
      for (this.a = a.T;; this.a = paramAdColonyAd)
      {
        sendMessage(obtainMessage(1));
        return;
      }
    }
    
    public void b(AdColonyAd paramAdColonyAd)
    {
      if (paramAdColonyAd == null) {}
      for (this.a = a.T;; this.a = paramAdColonyAd)
      {
        sendMessage(obtainMessage(0));
        return;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 0: 
        do
        {
          return;
          a.a("skip", this.a);
          if (a.T != null)
          {
            a.T.f = 1;
            a.T.a();
          }
        } while (a.V == null);
        a.V = null;
        return;
      }
      paramMessage = new ADCData.g();
      if (a.V.H.Q) {
        paramMessage.b("html5_endcard_loading_started", a.V.k);
      }
      if (a.V.H.Q) {
        paramMessage.b("html5_endcard_loading_finished", a.V.l);
      }
      if (a.V.H.Q) {
        paramMessage.b("html5_endcard_loading_time", a.V.p);
      }
      if (a.V.H.Q) {
        paramMessage.b("html5_endcard_loading_timeout", a.V.m);
      }
      if (a.V.q < 60000.0D) {
        paramMessage.b("endcard_time_spent", a.V.q);
      }
      paramMessage.b("endcard_dissolved", a.V.n);
      ADCVideo localADCVideo = a.V;
      paramMessage.b("replay", ADCVideo.e);
      paramMessage.b("reward", a.V.o);
      a.l.d.a("continue", paramMessage, this.a);
      if (a.T != null)
      {
        a.T.f = 4;
        a.T.a();
      }
      a.V.H = null;
      a.V = null;
    }
  }
  
  static class b
    extends Handler
  {
    public void a(boolean paramBoolean, String paramString, int paramInt)
    {
      if (paramBoolean) {}
      for (;;)
      {
        sendMessage(obtainMessage(paramInt, paramString));
        return;
        paramString = null;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = 0;
      String str = (String)paramMessage.obj;
      int j = paramMessage.what;
      if (str != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage = str;
        if (!bool) {
          paramMessage = "";
        }
        paramMessage = new AdColonyV4VCReward(bool, paramMessage, j);
        while (i < a.ao.size())
        {
          ((AdColonyV4VCListener)a.ao.get(i)).onAdColonyV4VCReward(paramMessage);
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */