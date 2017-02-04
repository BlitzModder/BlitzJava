package com.jirbo.adcolony;

class u
{
  d a;
  boolean b;
  boolean c;
  boolean d = false;
  boolean e = false;
  boolean f = true;
  double g;
  double h;
  double i;
  int j;
  String k = "uuid";
  
  u(d paramd)
  {
    this.a = paramd;
    this.k = aa.b();
  }
  
  void a() {}
  
  void a(double paramDouble)
  {
    l.a.a("Submitting session duration ").b(paramDouble);
    ADCData.g localg = new ADCData.g();
    localg.b("session_length", (int)paramDouble);
    this.a.d.a("session_end", localg);
  }
  
  void b()
  {
    if (this.a.b.b)
    {
      if (this.d)
      {
        this.d = false;
        this.a.d.a("install", null);
      }
      if (this.e)
      {
        this.e = false;
        this.a.d.a("session_start", null);
      }
    }
  }
  
  void c()
  {
    l.b.b("AdColony resuming");
    a.z = true;
    if (this.b) {
      l.d.b("AdColony.onResume() called multiple times in succession.");
    }
    this.b = true;
    g();
    double d1 = aa.c();
    if (this.c)
    {
      if (d1 - this.h > this.a.a.d)
      {
        a(this.i);
        this.g = d1;
        h();
      }
      this.c = false;
      f();
    }
    for (;;)
    {
      a.h();
      return;
      this.g = d1;
      h();
    }
  }
  
  void d()
  {
    l.b.b("AdColony suspending");
    a.z = true;
    if (!this.b) {
      l.d.b("AdColony.onPause() called without initial call to onResume().");
    }
    this.b = false;
    this.c = true;
    this.h = aa.c();
    f();
  }
  
  void e()
  {
    l.b.b("AdColony terminating");
    a.z = true;
    a(this.i);
    this.c = false;
    f();
  }
  
  void f()
  {
    ADCData.g localg = new ADCData.g();
    localg.b("allow_resume", this.c);
    localg.b("start_time", this.g);
    localg.b("finish_time", this.h);
    localg.b("session_time", this.i);
    k.a(new f("session_info.txt"), localg);
  }
  
  void g()
  {
    ADCData.g localg = k.b(new f("session_info.txt"));
    if (localg != null)
    {
      this.c = localg.h("allow_resume");
      this.g = localg.f("start_time");
      this.h = localg.f("finish_time");
      this.i = localg.f("session_time");
      return;
    }
    this.d = true;
  }
  
  void h()
  {
    this.e = true;
    if (!this.f) {
      this.k = aa.b();
    }
    this.f = false;
    this.i = 0.0D;
    this.j = 0;
    if ((a.l == null) || (a.l.b == null) || (a.l.b.i == null) || (a.l.b.i.o == null)) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < a.l.b.i.o.b())
      {
        if (a.l.b.i.o.a(m).r != null) {
          a.l.b.i.o.a(m).r.d = 0;
        }
        if (a.l.b.i.o.a(m) != null) {
          a.l.b.i.o.a(m).j = new ADCData.c();
        }
        m += 1;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */