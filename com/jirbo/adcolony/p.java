package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class p
  implements Runnable
{
  public static final int a = 5;
  public static final int b = 10;
  static String c = "MONITOR_MUTEX";
  static volatile p d;
  static volatile long e;
  Runnable f;
  long g;
  long h = System.currentTimeMillis();
  
  static void a()
  {
    synchronized (c)
    {
      e = System.currentTimeMillis();
      if (d == null)
      {
        a.b("Creating ADC Monitor singleton.");
        d = new p();
        new Thread(d).start();
      }
      return;
    }
  }
  
  void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void run()
  {
    a.a(a.n);
    l.a.b("ADC Monitor Started.");
    a.l.b();
    int i = 0;
    long l1 = System.currentTimeMillis();
    long l3;
    long l2;
    label63:
    long l4;
    int j;
    if ((a.P != null) && (!AdColony.activity().isFinishing()))
    {
      l3 = System.currentTimeMillis();
      a.z = false;
      if (!a.z) {
        break label293;
      }
      l2 = 50L;
      l4 = System.currentTimeMillis();
      j = (int)((l4 - e) / 1000L);
      if (this.f == null) {
        this.f = new Runnable()
        {
          public void run()
          {
            a.l.g();
          }
        };
      }
      if ((a.l.m == null) || (a.l.m.isShutdown())) {
        a.l.m = Executors.newSingleThreadExecutor();
      }
      a.l.m.submit(this.f);
      if ((i != 0) && (j < 10)) {
        break label318;
      }
    }
    label293:
    label318:
    label792:
    for (;;)
    {
      synchronized (c)
      {
        d = null;
        if (i == 0) {
          a.l.c();
        }
        if ((a.P != null) && (AdColony.activity().isFinishing()))
        {
          a.A = true;
          a(5000L);
          if (a.A)
          {
            l.c.b("ADC.finishing, controller on_stop");
            a.l.d();
            z.a();
          }
          a(5000L);
          if (a.A)
          {
            l.c.b("Releasing Activity reference");
            if (a.l.m != null) {
              a.l.a(a.l.m);
            }
            a.P = null;
            a.h();
          }
        }
        System.out.println("Exiting monitor");
        return;
        if (i != 0)
        {
          j = 2000;
          l2 = j;
          break label63;
        }
        j = 250;
        continue;
        if (j < 5)
        {
          a.l.b();
          a.b("AdColony is active.");
          i = 0;
          if (System.currentTimeMillis() - l1 <= 3000L) {
            break label792;
          }
          l1 = System.currentTimeMillis();
          if (q.c()) {
            continue;
          }
          if (a.L) {
            a.h();
          }
          a.L = false;
          if ((a.l.b.i != null) && (a.l.b.i.o != null)) {
            a.l.b.i.o.a();
          }
          if (a.l.b.i != null)
          {
            j = a.l.b.i.k;
            if (l4 - this.h > j * 1000)
            {
              this.h = System.currentTimeMillis();
              a.l.d.a(a.l.d.g);
              a.l.d.g = new ADCData.c();
            }
          }
          a(l2);
          l2 = System.currentTimeMillis();
          if ((l2 - l3 <= 3000L) && (l2 - l3 > 0L))
          {
            ??? = a.l.e;
            double d1 = ((u)???).i;
            ((u)???).i = ((l2 - l3) / 1000.0D + d1);
            if ((a.P != null) && (l4 - this.g > 1000L)) {
              this.g = System.currentTimeMillis();
            }
          }
        }
        try
        {
          ??? = a.l.b.i.o.a.iterator();
          if (((Iterator)???).hasNext())
          {
            n.ad localad = (n.ad)((Iterator)???).next();
            if (((!localad.a()) || (localad.q == 0L) || (System.currentTimeMillis() - localad.q <= localad.p)) && ((localad.q == 0L) || (System.currentTimeMillis() - localad.q <= localad.o))) {
              continue;
            }
            if ((a.P != null) && (!a.p))
            {
              a.l.b.a(a.P);
              a.p = true;
            }
          }
        }
        catch (ConcurrentModificationException localConcurrentModificationException)
        {
          l.d.b("Issue refreshing zones, disabling AdColony.");
          AdColony.disable();
          return;
        }
        if (j >= 5)
        {
          a.b("AdColony is idle.");
          i = 1;
          a.l.c();
        }
        continue;
        if (!a.L) {
          a.h();
        }
        a.L = true;
      }
    }
  }
  
  static class a
    extends Handler
  {
    a()
    {
      a.s = true;
      sendMessageDelayed(obtainMessage(), 1000L);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((a.b() == null) || (a.b().isFinishing()))
      {
        a.b("Monitor pinger exiting.");
        a.s = false;
        return;
      }
      if (!a.r) {
        p.a();
      }
      sendMessageDelayed(obtainMessage(), 1000L);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */