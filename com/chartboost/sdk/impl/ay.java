package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.b;
import com.chartboost.sdk.Libraries.c.a;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.a;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Model.CBError;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ay
{
  protected static e b;
  private static Map<String, Object> g;
  private static e.a i = null;
  protected e.a a;
  private String c;
  private String d;
  private Map<String, Object> e;
  private Map<String, Object> f;
  private String h;
  private c j = null;
  private boolean k = false;
  private boolean l = false;
  private g.a m = null;
  private az n;
  private int o;
  private boolean p = false;
  private boolean q = true;
  private l.a r = l.a.b;
  
  public ay(String paramString)
  {
    this.c = paramString;
    this.h = "POST";
    this.n = az.a(com.chartboost.sdk.c.y());
    a(0);
    if (b == null) {
      b = new e();
    }
  }
  
  public static ay a(e.a parama)
  {
    try
    {
      ay localay = new ay(parama.e("path"));
      localay.h = parama.e("method");
      localay.e = parama.a("query").f();
      localay.a = parama.a("body");
      localay.f = parama.a("headers").f();
      localay.l = parama.j("ensureDelivery");
      localay.d = parama.e("eventType");
      localay.c = parama.e("path");
      localay.o = parama.f("retryCount");
      if ((parama.a("callback") instanceof c)) {
        localay.j = ((c)parama.a("callback"));
      }
      return localay;
    }
    catch (Exception parama)
    {
      CBLogging.d("CBRequest", "Unable to deserialize failed request", parama);
    }
    return null;
  }
  
  public static Map<String, Object> b()
  {
    if (g == null)
    {
      g = new HashMap();
      g.put("X-Chartboost-Client", CBUtility.d());
      g.put("X-Chartboost-App", com.chartboost.sdk.c.f());
    }
    g.put("X-Chartboost-Reachability", Integer.valueOf(ax.a().b()));
    return g;
  }
  
  protected void a()
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.put("Accept", "application/json");
    this.f.put("X-Chartboost-Client", CBUtility.d());
    this.f.put("X-Chartboost-API", "6.4.1");
    this.f.put("X-Chartboost-Client", CBUtility.d());
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void a(g.a parama)
  {
    if (!g.c(parama)) {
      CBLogging.b("CBRequest", "Validation predicate must be a dictionary style -- either VDictionary, VDictionaryExact, VDictionaryWithValues, or just a list of KV pairs.");
    }
    this.m = parama;
  }
  
  public void a(c paramc)
  {
    if (!com.chartboost.sdk.c.n())
    {
      this.l = false;
      this.p = false;
    }
    this.j = paramc;
    d(true);
    this.n.a(this, paramc);
  }
  
  public void a(d paramd, b paramb)
  {
    if (!com.chartboost.sdk.c.n())
    {
      this.l = false;
      this.p = false;
    }
    d(true);
    this.j = new a(paramd, paramb);
    this.n.a(this, this.j);
  }
  
  public void a(l.a parama)
  {
    this.r = parama;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString, e.a parama)
  {
    if ((parama != null) && (parama.c(paramString))) {
      a(paramString, parama.e(paramString));
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.a == null) {
      this.a = e.a.a();
    }
    this.a.a(paramString, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(g.k... paramVarArgs)
  {
    this.m = g.a(paramVarArgs);
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected String c()
  {
    return "application/json";
  }
  
  public void c(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  protected void d()
  {
    int i1 = 0;
    a("app", b.o);
    a("model", b.a);
    a("device_type", b.p);
    a("os", b.b);
    a("country", b.c);
    a("language", b.d);
    a("sdk", b.g);
    a("timestamp", b.m);
    a("session", Integer.valueOf(CBUtility.a().getInt("cbPrefSessionCount", 0)));
    a("reachability", Integer.valueOf(ax.a().b()));
    a("scale", b.n);
    if (CBUtility.c().a()) {
      i1 = 1;
    }
    a("is_portrait", Integer.valueOf(i1));
    a("bundle", b.e);
    a("bundle_id", b.f);
    a("carrier", b.q);
    a("custom_id", com.chartboost.sdk.c.p());
    a("mediation", com.chartboost.sdk.c.e());
    if (com.chartboost.sdk.c.b() != null)
    {
      a("framework_version", com.chartboost.sdk.c.d());
      a("wrapper_version", com.chartboost.sdk.c.c());
    }
    a("rooted_device", Boolean.valueOf(b.r));
    a("timezone", b.s);
    a("mobile_network", b.t);
    a("dw", b.j);
    a("dh", b.k);
    a("dpi", b.l);
    a("w", b.h);
    a("h", b.i);
    a("identity", com.chartboost.sdk.Libraries.c.b());
    c.a locala = com.chartboost.sdk.Libraries.c.c();
    if (locala.b()) {
      a("tracking", Integer.valueOf(locala.a()));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void e()
  {
    String str1 = com.chartboost.sdk.c.f();
    String str2 = com.chartboost.sdk.c.g();
    str2 = b.b(b.a(String.format(Locale.US, "%s %s\n%s\n%s", new Object[] { this.h, f(), str2, g() }).getBytes()));
    a("X-Chartboost-App", str1);
    a("X-Chartboost-Signature", str2);
  }
  
  public String f()
  {
    return h() + CBUtility.a(this.e);
  }
  
  public String g()
  {
    return this.a.toString();
  }
  
  public String h()
  {
    if (this.c == null) {
      return "/";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c.startsWith("/")) {}
    for (String str = "";; str = "/") {
      return str + this.c;
    }
  }
  
  public boolean i()
  {
    return h().equals("/api/track");
  }
  
  public e.a j()
  {
    return this.a;
  }
  
  public Map<String, Object> k()
  {
    return this.f;
  }
  
  public boolean l()
  {
    return this.l;
  }
  
  public g.a m()
  {
    return this.m;
  }
  
  public boolean n()
  {
    return this.p;
  }
  
  public l.a o()
  {
    return this.r;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public boolean q()
  {
    return this.q;
  }
  
  public boolean r()
  {
    return this.k;
  }
  
  public c s()
  {
    return this.j;
  }
  
  public void t()
  {
    a(null, null);
  }
  
  public e.a u()
  {
    return e.a(new e.b[] { e.a("path", this.c), e.a("method", this.h), e.a("query", e.a(this.e)), e.a("body", this.a), e.a("eventType", this.d), e.a("headers", e.a(this.f)), e.a("ensureDelivery", Boolean.valueOf(this.l)), e.a("retryCount", Integer.valueOf(this.o)), e.a("callback", this.j) });
  }
  
  private static class a
    implements ay.c
  {
    private ay.d a;
    private ay.b b;
    
    public a(ay.d paramd, ay.b paramb)
    {
      this.a = paramd;
      this.b = paramb;
    }
    
    public void a(e.a parama, ay paramay)
    {
      if (this.a != null) {
        this.a.a(parama, paramay);
      }
    }
    
    public void a(e.a parama, ay paramay, CBError paramCBError)
    {
      if (this.b != null) {
        this.b.a(parama, paramay, paramCBError);
      }
    }
  }
  
  public static abstract class b
    implements ay.c
  {}
  
  public static abstract interface c
  {
    public abstract void a(e.a parama, ay paramay);
    
    public abstract void a(e.a parama, ay paramay, CBError paramCBError);
  }
  
  public static abstract class d
    implements ay.c
  {
    public void a(e.a parama, ay paramay, CBError paramCBError) {}
  }
  
  class e
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public e.a q;
    public boolean r;
    public String s;
    public Integer t;
    
    public e()
    {
      Context localContext = com.chartboost.sdk.c.y();
      this.o = com.chartboost.sdk.c.f();
      if ("sdk".equals(Build.PRODUCT)) {
        this.a = "Android Simulator";
      }
      for (;;)
      {
        this.p = (Build.MANUFACTURER + " " + Build.MODEL);
        this.b = ("Android " + Build.VERSION.RELEASE);
        this.c = Locale.getDefault().getCountry();
        this.d = Locale.getDefault().getLanguage();
        this.g = "6.4.1";
        this.m = String.valueOf(Long.valueOf(new Date().getTime() / 1000L).intValue());
        this.n = ("" + localContext.getResources().getDisplayMetrics().density);
        try
        {
          this$1 = localContext.getPackageName();
          this.e = localContext.getPackageManager().getPackageInfo(ay.this, 128).versionName;
          this.f = ay.this;
          if (ay.v() == null)
          {
            TelephonyManager localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
            if ((localTelephonyManager != null) && (localTelephonyManager.getPhoneType() != 0))
            {
              this$1 = localTelephonyManager.getSimOperator();
              if (TextUtils.isEmpty(ay.this)) {
                break label659;
              }
              localObject1 = ay.this.substring(0, 3);
              this$1 = ay.this.substring(3);
              ay.b(e.a(new e.b[] { e.a("carrier-name", localTelephonyManager.getNetworkOperatorName()), e.a("mobile-country-code", localObject1), e.a("mobile-network-code", ay.this), e.a("iso-country-code", localTelephonyManager.getNetworkCountryIso()), e.a("phone-type", Integer.valueOf(localTelephonyManager.getPhoneType())) }));
            }
          }
          else
          {
            this.q = ay.v();
            this.r = CBUtility.f();
            this.s = CBUtility.g();
            this.t = ax.d();
          }
          for (;;)
          {
            try
            {
              if (!(localContext instanceof Activity)) {
                continue;
              }
              this$1 = (Activity)localContext;
              localObject1 = new Rect();
              ay.this.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
              i2 = ((Rect)localObject1).width();
            }
            catch (Exception this$1)
            {
              int i4;
              int i3;
              int i1 = 0;
              CBLogging.c("CBRequest", "Exception getting activity size", ay.this);
              i2 = i1;
              i1 = 0;
              continue;
              i2 = i4;
              continue;
              i1 = i3;
              continue;
              i1 = 0;
              continue;
            }
            try
            {
              i1 = ((Rect)localObject1).height();
              this$1 = localContext.getResources().getDisplayMetrics();
              i4 = ay.this.widthPixels;
              i3 = ay.this.heightPixels;
              this.j = ("" + i4);
              this.k = ("" + i3);
              this.l = ("" + ay.this.densityDpi);
              if ((i2 <= 0) || (i2 > i4)) {
                continue;
              }
              if ((i1 <= 0) || (i1 > i3)) {
                continue;
              }
              this.h = ("" + i2);
              this.i = ("" + i1);
              return;
            }
            catch (Exception this$1)
            {
              i1 = i2;
            }
          }
          this.a = Build.MODEL;
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            CBLogging.b("CBRequest", "Exception raised getting package mager object", ay.this);
            continue;
            ay.b(e.a.a());
            continue;
            label659:
            Object localObject2 = null;
            this$1 = (ay)localObject1;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */