package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class d
{
  c a = new c(this);
  b b = new b(this);
  o c = new o(this);
  t d = new t(this);
  u e = new u(this);
  ADCStorage f = new ADCStorage(this);
  ag g = new ag(this);
  ArrayList<j> h = new ArrayList();
  ArrayList<j> i = new ArrayList();
  volatile boolean j;
  boolean k;
  boolean l;
  ExecutorService m;
  Runnable n;
  aa.a o = new aa.a();
  
  double a(String paramString)
  {
    try
    {
      d1 = this.a.i.f(paramString);
      return d1;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        double d1 = 0.0D;
      }
    }
    finally {}
  }
  
  void a()
  {
    if (this.k) {}
    while (!a.d()) {
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        if ((!this.k) || ((!this.j) && (this.h.size() > 0)))
        {
          this.k = true;
          this.i.addAll(this.h);
          this.h.clear();
          i1 = 0;
          if (i1 < this.i.size())
          {
            if (this.i.get(i1) == null) {
              break label144;
            }
            ((j)this.i.get(i1)).a();
            break label144;
          }
          this.i.clear();
          continue;
        }
        this.k = false;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.k = false;
        this.i.clear();
        this.h.clear();
        a.a(localRuntimeException);
        return;
      }
      return;
      label144:
      i1 += 1;
    }
  }
  
  void a(final double paramDouble, final AdColonyAd paramAdColonyAd)
  {
    new j(this)
    {
      void a()
      {
        if ((!a.o) && (paramAdColonyAd != null) && (paramAdColonyAd.j != null) && (paramAdColonyAd.j.w != null) && (paramAdColonyAd.j.w.a) && (paramDouble > 0.9D))
        {
          l.c.b("V4VC validated.");
          a.o = true;
        }
        this.q.d.a(paramDouble, paramAdColonyAd);
      }
    };
  }
  
  void a(int paramInt)
  {
    a.a(paramInt);
  }
  
  void a(final AdColonyAd paramAdColonyAd)
  {
    try
    {
      this.a.o = 0.0D;
      l.a.b("Tracking ad event - start");
      af localaf = paramAdColonyAd.i.r;
      localaf.d += 1;
      if (!paramAdColonyAd.b()) {
        paramAdColonyAd.i.m();
      }
      new j(this)
      {
        void a()
        {
          if ((AdColony.isZoneV4VC(paramAdColonyAd.h)) || (paramAdColonyAd.j.A == null) || (!paramAdColonyAd.j.A.a) || ((paramAdColonyAd.j.A.a) && (paramAdColonyAd.u) && (paramAdColonyAd.l.equals("fullscreen"))))
          {
            d.this.a("start", "{\"ad_slot\":" + (a.l.e.j + 1) + ", \"replay\":" + paramAdColonyAd.u + "}", paramAdColonyAd);
            paramAdColonyAd.j.q = true;
            paramAdColonyAd.j.r = true;
            a.h();
            if (paramAdColonyAd.i.j == null) {
              paramAdColonyAd.i.j = new ADCData.c();
            }
            paramAdColonyAd.i.j.a(paramAdColonyAd.j.a);
          }
        }
      };
      return;
    }
    finally {}
  }
  
  void a(AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    try
    {
      this.a.b(paramAdColonyInterstitialAd.h);
      return;
    }
    finally
    {
      paramAdColonyInterstitialAd = finally;
      throw paramAdColonyInterstitialAd;
    }
  }
  
  void a(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    try
    {
      this.a.c(paramAdColonyV4VCAd.h);
      return;
    }
    finally
    {
      paramAdColonyV4VCAd = finally;
      throw paramAdColonyV4VCAd;
    }
  }
  
  void a(AdColonyVideoAd paramAdColonyVideoAd)
  {
    try
    {
      this.a.b(paramAdColonyVideoAd.h);
      return;
    }
    finally
    {
      paramAdColonyVideoAd = finally;
      throw paramAdColonyVideoAd;
    }
  }
  
  void a(j paramj)
  {
    if (this.n == null) {
      this.n = new Runnable()
      {
        public void run()
        {
          d.this.g();
        }
      };
    }
    if ((this.m == null) || (this.m.isShutdown())) {
      this.m = Executors.newSingleThreadExecutor();
    }
    synchronized (this.h)
    {
      if (!a.d()) {
        return;
      }
      this.h.add(paramj);
      if (!this.j)
      {
        boolean bool = this.m.isShutdown();
        if (bool) {}
      }
    }
    try
    {
      this.m.submit(this.n);
      return;
      paramj = finally;
      throw paramj;
    }
    catch (RejectedExecutionException paramj)
    {
      for (;;)
      {
        l.d.b("ExecutorService threw RejectedExecutionException. Disabling AdColony");
        l.a.b("RejectedExecutionException from ADCController: " + Log.getStackTraceString(paramj));
        a(this.m);
        AdColony.disable();
      }
    }
  }
  
  void a(final String paramString1, final String paramString2)
  {
    new j(this)
    {
      void a()
      {
        this.q.d.a(paramString1, k.b(paramString2));
      }
    };
  }
  
  void a(final String paramString1, final String paramString2, final AdColonyAd paramAdColonyAd)
  {
    new j(this)
    {
      void a()
      {
        this.q.d.a(paramString1, k.b(paramString2), paramAdColonyAd);
      }
    };
  }
  
  void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(a.n);
      l.c.a("==== Configuring AdColony ").a(this.a.b).b(" with app/zone ids: ====");
      l.c.b(paramString2);
      int i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        l.c.b(paramArrayOfString[i1]);
        i1 += 1;
      }
      l.a.a("package name: ").b(aa.f());
      this.a.k = paramString2;
      this.a.l = paramArrayOfString;
      this.a.a(paramString1);
      this.o.a();
    }
    catch (RuntimeException paramString1)
    {
      for (;;)
      {
        a.a(paramString1);
      }
    }
    finally {}
  }
  
  void a(ExecutorService paramExecutorService)
  {
    paramExecutorService.shutdown();
    try
    {
      if (!paramExecutorService.awaitTermination(1L, TimeUnit.SECONDS))
      {
        paramExecutorService.shutdownNow();
        if (!paramExecutorService.awaitTermination(1L, TimeUnit.SECONDS)) {
          System.err.println(getClass().getSimpleName() + ": ScheduledExecutorService did not terminate");
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      paramExecutorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
  
  void a(boolean paramBoolean, final AdColonyAd paramAdColonyAd)
  {
    int i1 = 1;
    if (paramAdColonyAd == null) {}
    for (;;)
    {
      return;
      try
      {
        a(1.0D, paramAdColonyAd);
        if ((paramBoolean) || (!paramAdColonyAd.b())) {
          continue;
        }
        paramAdColonyAd.i.m();
        Object localObject = paramAdColonyAd.i;
        ((n.ad)localObject).s += 1;
        localObject = (AdColonyV4VCAd)a.T;
        final String str = ((AdColonyV4VCAd)localObject).getRewardName();
        final int i2 = ((AdColonyV4VCAd)localObject).getRewardAmount();
        if (!paramAdColonyAd.i.b()) {
          i1 = 0;
        }
        if (i1 == 0) {
          continue;
        }
        if ((((AdColonyV4VCAd)localObject).i.n.e) && (a.o)) {
          a(true, str, i2);
        }
        new j(this)
        {
          void a()
          {
            ADCData.g localg = new ADCData.g();
            localg.b("v4vc_name", str);
            localg.b("v4vc_amount", i2);
            this.q.d.a("reward_v4vc", localg, paramAdColonyAd);
          }
        };
      }
      finally {}
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    try
    {
      a.X.a(paramBoolean, paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = a.d();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        a.a(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.b.b(paramString, paramBoolean1)) {
        bool1 = this.b.i.o.a(paramString).b(paramBoolean2);
      }
    }
  }
  
  int b(String paramString)
  {
    try
    {
      i1 = this.a.i.g(paramString);
      return i1;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        int i1 = 0;
      }
    }
    finally {}
  }
  
  void b()
  {
    this.j = true;
    new j(this)
    {
      void a()
      {
        this.q.e.c();
      }
    };
  }
  
  boolean b(AdColonyAd paramAdColonyAd)
  {
    for (;;)
    {
      try
      {
        if (this.a.m.d())
        {
          a.T.f = 3;
          bool = false;
          return bool;
        }
        ADCVideo.a();
        if (a.m)
        {
          l.a.b("Launching AdColonyOverlay");
          if (a.b() != null)
          {
            paramAdColonyAd = new Intent(a.b(), AdColonyOverlay.class);
            a.b().startActivity(paramAdColonyAd);
          }
        }
        else
        {
          l.a.b("Launching AdColonyFullscreen");
          if (a.b() != null)
          {
            paramAdColonyAd = new Intent(a.b(), AdColonyFullscreen.class);
            a.b().startActivity(paramAdColonyAd);
          }
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  boolean b(AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.T = paramAdColonyInterstitialAd;
        str = paramAdColonyInterstitialAd.h;
        bool2 = e(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyInterstitialAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyInterstitialAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing ad for zone ").b(str);
      a(paramAdColonyInterstitialAd);
      bool2 = b(paramAdColonyInterstitialAd);
      bool1 = bool2;
    }
  }
  
  boolean b(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.T = paramAdColonyV4VCAd;
        str = paramAdColonyV4VCAd.h;
        bool2 = f(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyV4VCAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyV4VCAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing v4vc for zone ").b(str);
      a(paramAdColonyV4VCAd);
      bool2 = b(paramAdColonyV4VCAd);
      bool1 = bool2;
    }
  }
  
  boolean b(AdColonyVideoAd paramAdColonyVideoAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.T = paramAdColonyVideoAd;
        str = paramAdColonyVideoAd.h;
        bool2 = e(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyVideoAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyVideoAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing ad for zone ").b(str);
      a(paramAdColonyVideoAd);
      bool2 = b(paramAdColonyVideoAd);
      bool1 = bool2;
    }
  }
  
  boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = a.d();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        a.a(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.b.b(paramString, paramBoolean1)) {
        bool1 = this.b.i.o.a(paramString).c(paramBoolean2);
      }
    }
  }
  
  void c()
  {
    this.j = false;
    new j(this)
    {
      void a()
      {
        this.q.e.d();
      }
    };
  }
  
  boolean c(String paramString)
  {
    try
    {
      bool = this.a.i.h(paramString);
      return bool;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        boolean bool = false;
      }
    }
    finally {}
  }
  
  String d(String paramString)
  {
    try
    {
      paramString = this.a.i.e(paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        paramString = null;
      }
    }
    finally {}
  }
  
  void d()
  {
    new j(this)
    {
      void a()
      {
        this.q.e.e();
      }
    };
  }
  
  String e()
  {
    try
    {
      String str = this.b.c();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean e(String paramString)
  {
    try
    {
      boolean bool = a(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String f()
  {
    try
    {
      String str = this.b.d();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean f(String paramString)
  {
    try
    {
      boolean bool = b(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  n.ad g(String paramString)
  {
    try
    {
      paramString = this.b.i.o.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 491	com/jirbo/adcolony/a:c	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 492	com/jirbo/adcolony/d:a	()V
    //   17: getstatic 495	com/jirbo/adcolony/a:x	Z
    //   20: ifne +45 -> 65
    //   23: invokestatic 499	com/jirbo/adcolony/g:n	()Ljava/lang/String;
    //   26: ifnonnull +17 -> 43
    //   29: aload_0
    //   30: getfield 103	com/jirbo/adcolony/d:o	Lcom/jirbo/adcolony/aa$a;
    //   33: invokevirtual 502	com/jirbo/adcolony/aa$a:b	()D
    //   36: ldc2_w 503
    //   39: dcmpl
    //   40: ifle +14 -> 54
    //   43: aload_0
    //   44: getfield 61	com/jirbo/adcolony/d:a	Lcom/jirbo/adcolony/c;
    //   47: invokevirtual 505	com/jirbo/adcolony/c:a	()V
    //   50: iconst_1
    //   51: putstatic 495	com/jirbo/adcolony/a:x	Z
    //   54: iconst_1
    //   55: putstatic 508	com/jirbo/adcolony/a:z	Z
    //   58: aload_0
    //   59: getfield 66	com/jirbo/adcolony/d:b	Lcom/jirbo/adcolony/b;
    //   62: invokevirtual 510	com/jirbo/adcolony/b:f	()V
    //   65: aload_0
    //   66: getfield 71	com/jirbo/adcolony/d:c	Lcom/jirbo/adcolony/o;
    //   69: invokevirtual 512	com/jirbo/adcolony/o:e	()V
    //   72: aload_0
    //   73: getfield 81	com/jirbo/adcolony/d:e	Lcom/jirbo/adcolony/u;
    //   76: invokevirtual 514	com/jirbo/adcolony/u:b	()V
    //   79: aload_0
    //   80: getfield 76	com/jirbo/adcolony/d:d	Lcom/jirbo/adcolony/t;
    //   83: invokevirtual 516	com/jirbo/adcolony/t:d	()V
    //   86: aload_0
    //   87: getfield 91	com/jirbo/adcolony/d:g	Lcom/jirbo/adcolony/ag;
    //   90: invokevirtual 517	com/jirbo/adcolony/ag:d	()V
    //   93: goto -83 -> 10
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 119	com/jirbo/adcolony/a:a	(Ljava/lang/RuntimeException;)V
    //   101: goto -91 -> 10
    //   104: astore_2
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	d
    //   5	2	1	bool	boolean
    //   96	2	2	localRuntimeException	RuntimeException
    //   104	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	43	96	java/lang/RuntimeException
    //   43	54	96	java/lang/RuntimeException
    //   54	65	96	java/lang/RuntimeException
    //   65	93	96	java/lang/RuntimeException
    //   2	6	104	finally
    //   13	43	104	finally
    //   43	54	104	finally
    //   54	65	104	finally
    //   65	93	104	finally
    //   97	101	104	finally
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */