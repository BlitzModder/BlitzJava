package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.c.a;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.f;

public final class bc
  extends ay
{
  private e.a c = e.a.a();
  private e.a d = e.a.a();
  private e.a e = e.a.a();
  private e.a f = e.a.a();
  
  public bc(String paramString)
  {
    super(paramString);
  }
  
  public void a(String paramString, Object paramObject, a parama)
  {
    if (this.a == null) {
      this.a = e.a.a();
    }
    switch (1.a[parama.ordinal()])
    {
    default: 
      return;
    }
    this.f.a(paramString, paramObject);
    this.a.a("ad", this.f);
  }
  
  protected void d()
  {
    int i = 1;
    this.d.a("app", b.o);
    this.d.a("bundle", b.e);
    this.d.a("bundle_id", b.f);
    this.d.a("custom_id", com.chartboost.sdk.c.p());
    this.d.a("session_id", "");
    this.d.a("ui", Integer.valueOf(-1));
    this.d.a("test_mode", Boolean.valueOf(false));
    this.a.a("app", this.d);
    Object localObject = e.a(new e.b[] { e.a("carrier_name", b.q.e("carrier-name")), e.a("mobile_country_code", b.q.e("mobile-country-code")), e.a("mobile_network_code", b.q.e("mobile-network-code")), e.a("iso_country_code", b.q.e("iso-country-code")), e.a("phone_type", Integer.valueOf(b.q.f("phone-type"))) });
    this.e.a("carrier", localObject);
    this.e.a("model", b.a);
    this.e.a("device_type", b.p);
    this.e.a("os", b.b);
    this.e.a("country", b.c);
    this.e.a("language", b.d);
    this.e.a("timestamp", b.m);
    this.e.a("reachability", Integer.valueOf(ax.a().b()));
    this.e.a("scale", b.n);
    localObject = this.e;
    if (CBUtility.c().a()) {}
    for (;;)
    {
      ((e.a)localObject).a("is_portrait", Integer.valueOf(i));
      this.e.a("rooted_device", Boolean.valueOf(b.r));
      this.e.a("timezone", b.s);
      this.e.a("mobile_network", b.t);
      this.e.a("dw", b.j);
      this.e.a("dh", b.k);
      this.e.a("dpi", b.l);
      this.e.a("w", b.h);
      this.e.a("h", b.i);
      this.e.a("device_family", "");
      this.e.a("retina", Boolean.valueOf(false));
      this.e.a("identity", com.chartboost.sdk.Libraries.c.b());
      localObject = com.chartboost.sdk.Libraries.c.c();
      if (((c.a)localObject).b()) {
        this.e.a("tracking", Integer.valueOf(((c.a)localObject).a()));
      }
      this.a.a("device", this.e);
      this.c.a("framework", "");
      this.c.a("sdk", b.g);
      this.c.a("framework_version", com.chartboost.sdk.c.d());
      this.c.a("wrapper_version", com.chartboost.sdk.c.c());
      this.c.a("mediation", com.chartboost.sdk.c.e());
      this.a.a("sdk", this.c);
      i = CBUtility.a().getInt("cbPrefSessionCount", 0);
      this.f.a("session", Integer.valueOf(i));
      if (this.f.a("cache").b()) {
        this.f.a("cache", Boolean.valueOf(false));
      }
      if (this.f.a("amount").b()) {
        this.f.a("amount", Integer.valueOf(0));
      }
      if (this.f.a("retry_count").b()) {
        this.f.a("retry_count", Integer.valueOf(0));
      }
      if (this.f.a("location").b()) {
        this.f.a("location", "");
      }
      this.a.a("ad", this.f);
      return;
      i = 0;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */