package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

class b
  implements ADCDownload.Listener
{
  d a;
  boolean b;
  boolean c;
  boolean d;
  boolean e = true;
  boolean f = false;
  boolean g = true;
  double h;
  n.e i = new n.e();
  
  b(d paramd)
  {
    this.a = paramd;
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
  }
  
  void a() {}
  
  void a(Activity paramActivity)
  {
    a.z = true;
    if (!this.d)
    {
      this.d = true;
      if (!this.b) {
        b();
      }
    }
    if (paramActivity != null) {
      a.U = null;
    }
    ADCData.g localg = this.a.a.j;
    localg.b("app_id", this.a.a.k);
    paramActivity = new ADCData.c();
    int k;
    int j;
    Object localObject3;
    if (this.a.a.l != null)
    {
      localObject1 = this.a.a.l;
      k = localObject1.length;
      j = 0;
      while (j < k)
      {
        localObject2 = localObject1[j];
        localObject3 = a.l.g((String)localObject2);
        if ((localObject3 == null) || ((localObject3 != null) && ((((n.ad)localObject3).a()) || (System.currentTimeMillis() - ((n.ad)localObject3).q > ((n.ad)localObject3).o)))) {
          paramActivity.a((String)localObject2);
        }
        j += 1;
      }
    }
    if (paramActivity.i() == 0) {
      return;
    }
    localg.a("zones", paramActivity);
    paramActivity = new ADCData.g();
    Object localObject1 = new ADCData.g();
    Object localObject2 = new ADCData.g();
    if (this.a.a.l != null)
    {
      localObject3 = this.a.a.l;
      k = localObject3.length;
      j = 0;
      while (j < k)
      {
        String str = localObject3[j];
        n.ad localad = a.l.g(str);
        ADCData.c localc1 = new ADCData.c();
        ADCData.c localc2 = new ADCData.c();
        if ((localad != null) && (localad.m != null) && (localad.m.a != null))
        {
          Iterator localIterator = localad.m.a.iterator();
          while (localIterator.hasNext())
          {
            n.a locala = (n.a)localIterator.next();
            if (!locala.b()) {
              localc1.a(locala.a);
            }
            if (locala.c()) {
              localc2.a(locala.a);
            }
          }
        }
        if (localc1.i() > 0) {
          paramActivity.a(str, localc1);
        }
        if (localc2.i() > 0) {
          ((ADCData.g)localObject1).a(str, localc2);
        }
        if ((localad != null) && (localad.j == null)) {
          localad.j = new ADCData.c();
        }
        if ((localad != null) && (localad.j.i() > 0)) {
          ((ADCData.g)localObject2).a(str, localad.j);
        }
        j += 1;
      }
    }
    localg.a("ad_queue", paramActivity);
    localg.a("ad_playing", (ADCData.i)localObject1);
    localg.a("ad_history", (ADCData.i)localObject2);
    if (a.l.e.k == null)
    {
      paramActivity = "";
      label520:
      j = a.l.e.j;
      localg.b("carrier", this.a.a.x);
      if (!q.a()) {
        break label701;
      }
      localg.b("network_type", "wifi");
    }
    for (;;)
    {
      localg.b("custom_id", this.a.a.y);
      localg.b("sid", paramActivity);
      localg.b("s_imp_count", j);
      if (a.p) {
        break;
      }
      paramActivity = l.b.a("Downloading ad manifest from ");
      localObject1 = this.a.a;
      paramActivity.a(c.c).b(" with the following post content: ");
      l.b.b(localg.toString());
      a.p = true;
      paramActivity = this.a;
      localObject1 = this.a.a;
      new ADCDownload(paramActivity, c.c, this).a("application/json", localg.q()).b();
      return;
      paramActivity = a.l.e.k;
      break label520;
      label701:
      if (q.b()) {
        localg.b("network_type", "cell");
      } else {
        localg.b("network_type", "none");
      }
    }
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    while ((!paramg.e("status").equals("success")) || (!this.i.a(paramg.b("app")))) {
      return false;
    }
    l.a.b("Finished parsing manifest");
    a.h();
    if (!this.i.h.equalsIgnoreCase("none"))
    {
      l.c.b("Enabling debug logging.");
      a.a(1);
    }
    for (;;)
    {
      return true;
      a.a(2);
    }
  }
  
  boolean a(String paramString)
  {
    return a(paramString, true);
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < this.i.o.b())
      {
        n.ad localad = this.i.o.a(j);
        if ((localad.c(paramBoolean)) && (localad.a.equals(paramString))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      j += 1;
    }
  }
  
  void b()
  {
    l.b.b("Attempting to load backup manifest from file.");
    f localf = new f("manifest.txt");
    ADCData.g localg1 = k.b(localf);
    if (localg1 != null)
    {
      ADCData.c localc = localg1.b("app").c("zones");
      if (localc == null) {
        break label197;
      }
      j = 0;
      if (j >= localc.i()) {
        break label197;
      }
      ADCData.g localg2 = localc.b(j);
      int k = 0;
      int m = 0;
      while (k < a.l.a.l.length)
      {
        if (localg2.e("uuid").equals(a.l.a.l[k])) {
          m = 1;
        }
        k += 1;
      }
      if (m != 0) {
        break label165;
      }
    }
    label165:
    label197:
    for (int j = 0;; j = 1)
    {
      a.C = true;
      if ((j != 0) && (a(localg1)))
      {
        this.b = true;
        this.i.a();
        a.C = false;
        return;
        j += 1;
        break;
      }
      l.b.b("Invalid manifest loaded.");
      localf.c();
      a.C = false;
      this.b = false;
      return;
    }
  }
  
  boolean b(String paramString)
  {
    return b(paramString, false);
  }
  
  boolean b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return c(paramString, paramBoolean);
    }
    if (!this.b) {
      return l.c.b("Ads are not ready to be played, as they are still downloading.");
    }
    if (paramBoolean) {
      return this.i.a(paramString, true, false);
    }
    return this.i.a(paramString, false, true);
  }
  
  String c()
  {
    if (!this.b) {
      return null;
    }
    String str = null;
    int j = 0;
    while (j < this.i.o.b())
    {
      n.ad localad = this.i.o.a(j);
      if (localad.g())
      {
        str = localad.a;
        if (localad.c()) {
          return localad.a;
        }
      }
      j += 1;
    }
    return str;
  }
  
  boolean c(String paramString, boolean paramBoolean)
  {
    if (!this.b) {
      return false;
    }
    if (paramBoolean) {
      return this.i.a(paramString, true, false);
    }
    return this.i.a(paramString, false, true);
  }
  
  String d()
  {
    if (!this.b) {
      return null;
    }
    String str = null;
    int j = 0;
    while (j < this.i.o.b())
    {
      n.ad localad = this.i.o.a(j);
      if (localad.i())
      {
        str = localad.a;
        if (localad.c()) {
          return localad.a;
        }
      }
      j += 1;
    }
    return str;
  }
  
  void e() {}
  
  void f()
  {
    this.c = true;
    if (this.c)
    {
      this.c = false;
      if (g.c() >= 32)
      {
        this.h = (aa.c() + 600.0D);
        h();
      }
    }
    if (!q.c())
    {
      if (a.L) {
        a.h();
      }
      a.L = false;
      return;
    }
    if (!a.L) {
      a.h();
    }
    a.L = true;
  }
  
  void g()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        for (;;)
        {
          if ((i < 500) && (a.a())) {
            try
            {
              Thread.sleep(10L);
              i += 1;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;) {}
            }
          }
        }
      }
    }).start();
    h();
  }
  
  void h()
  {
    a(null);
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    a.z = true;
    ADCData.g localg;
    if (paramADCDownload.i)
    {
      l.c.b("Received ad server response from:");
      l.c.b(paramADCDownload.c);
      localg = k.b(paramADCDownload.p);
      if (localg == null)
      {
        l.a.b("Invalid JSON in manifest.  Raw data:");
        l.a.b(paramADCDownload.p);
      }
    }
    else
    {
      l.c.b("Error retrieving ad server response from:");
      l.c.b(paramADCDownload.c);
      return;
    }
    int j;
    if (a(localg))
    {
      l.b.b("Ad manifest updated.");
      paramADCDownload = k.c(localg.b("app").c("zones").toString());
      j = 0;
      if (j < this.i.o.b())
      {
        k = 0;
        label147:
        if (k >= paramADCDownload.i()) {
          break label487;
        }
        if (!((n.ad)this.i.o.a.get(j)).a.equals(paramADCDownload.b(k).e("uuid"))) {}
      }
    }
    label487:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        paramADCDownload.a(this.i.o.a(j).b);
      }
      j += 1;
      break;
      k += 1;
      break label147;
      localg.b("app").c("zones").j();
      j = 0;
      while (j < paramADCDownload.i())
      {
        k = 0;
        int m = 0;
        while (k < a.l.a.l.length)
        {
          if (a.l.a.l[k].equals(paramADCDownload.b(j).e("uuid"))) {
            m = 1;
          }
          k += 1;
        }
        if (m != 0)
        {
          paramADCDownload.b(j).b("last_config_ms", new Long(System.currentTimeMillis()).toString());
          localg.b("app").c("zones").a(paramADCDownload.b(j));
        }
        j += 1;
      }
      new f("manifest.txt").a(localg.toString());
      this.b = true;
      this.i.a();
      if ((this.i.i == null) || (this.i.i.equals(""))) {
        this.i.i = "all";
      }
      if ((this.i.j == null) || (this.i.j.equals(""))) {
        this.i.j = "all";
      }
      a.h();
      return;
      l.b.b("Invalid manifest.");
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */