package com.jirbo.adcolony;

import android.os.Build.VERSION;

class c
{
  static String c = "https://androidads23.adcolony.com/configure";
  String A;
  String B;
  String C;
  String D;
  String E;
  String F;
  String G;
  String H;
  String I;
  String J;
  String K;
  String L;
  String M;
  String N;
  boolean O;
  boolean P;
  d a;
  String b = "2.3.6";
  int d = 300;
  int e = 0;
  boolean f = false;
  boolean g = false;
  String h;
  ADCData.g i = new ADCData.g();
  ADCData.g j;
  String k;
  String[] l;
  n.ad m;
  n.a n;
  double o = 0.0D;
  String p = "android";
  String q = "android_native";
  String r = "1.0";
  String s = "google";
  boolean t = false;
  String u;
  String v;
  ADCData.c w;
  String x;
  String y = "";
  String z;
  
  c(d paramd)
  {
    this.a = paramd;
  }
  
  String a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  void a()
  {
    while ((!AdColony.c) && (this.e < 60)) {
      try
      {
        this.e += 1;
        Thread.sleep(50L);
      }
      catch (Exception localException) {}
    }
    this.e = 0;
    this.a.g.a();
    this.L = a(g.a, "");
    this.O = g.b;
    this.u = a(g.a(), "");
    Object localObject;
    boolean bool;
    if (!this.L.equals(""))
    {
      localObject = "";
      this.v = ((String)localObject);
      this.x = a(g.b(), "");
      if (this.z == null) {
        this.z = a(g.e(), "");
      }
      this.A = a(g.l(), "");
      this.B = a(g.m(), "");
      this.F = a(g.j(), "en");
      this.G = a(g.n(), "");
      this.H = a(g.o(), "");
      this.K = a("" + Build.VERSION.SDK_INT, "");
      this.D = a(g.h(), "");
      this.E = "";
      this.I = a("" + g.c(), "");
      this.J = a("" + g.d(), "");
      if ((!aa.d()) || (!aa.e())) {
        break label1291;
      }
      bool = true;
      label330:
      this.P = bool;
      a.af = this.H;
      a.ag = this.b;
      if (!a.m) {
        break label1296;
      }
    }
    label1291:
    label1296:
    for (this.C = "tablet";; this.C = "phone")
    {
      this.w = new ADCData.c();
      if ((aa.a("com.android.vending")) || (aa.a("com.android.market"))) {
        this.w.a("google");
      }
      if (aa.a("com.amazon.venezia")) {
        this.w.a("amazon");
      }
      if (l.b.f)
      {
        l.b.a("sdk_version:").b(this.b);
        l.b.a("ad_manifest_url:").b(c);
        l.b.a("app_id:").b(this.k);
        l.b.a("zone_ids:").b(this.l);
        l.b.a("os_name:").b(this.p);
        l.b.a("sdk_type:").b(this.q);
        l.b.a("app_version:").b(this.r);
        l.b.a("origin_store:").b(this.s);
        l.b.a("skippable:").b(this.t);
        l.b.a("android_id:").b(this.u);
        l.b.a("android_id_sha1:").b(this.v);
        l.b.a("available_stores:").b(this.w);
        l.b.a("carrier_name:").b(this.x);
        l.b.a("custom_id:").b(this.y);
        l.b.a("device_id:").b(this.z);
        l.b.a("device_manufacturer:").b(this.A);
        l.b.a("device_model:").b(this.B);
        l.b.a("device_type:").b(this.C);
        l.b.a("imei:").b(this.D);
        l.b.a("imei_sha1:").b(this.E);
        l.b.a("language:").b(this.F);
        l.b.a("open_udid:").b(this.G);
        l.b.a("os_version:").b(this.H);
      }
      localObject = new ADCData.g();
      ((ADCData.g)localObject).b("os_name", this.p);
      ((ADCData.g)localObject).b("os_version", this.H);
      ((ADCData.g)localObject).b("device_api", this.K);
      ((ADCData.g)localObject).b("app_version", this.r);
      ((ADCData.g)localObject).b("android_id_sha1", this.v);
      ((ADCData.g)localObject).b("device_id", this.z);
      ((ADCData.g)localObject).b("open_udid", this.G);
      ((ADCData.g)localObject).b("device_type", this.C);
      ((ADCData.g)localObject).b("ln", this.F);
      ((ADCData.g)localObject).b("device_brand", this.A);
      ((ADCData.g)localObject).b("device_model", this.B);
      ((ADCData.g)localObject).b("screen_width", g.f());
      ((ADCData.g)localObject).b("screen_height", g.g());
      ((ADCData.g)localObject).b("sdk_type", this.q);
      ((ADCData.g)localObject).b("sdk_version", this.b);
      ((ADCData.g)localObject).b("origin_store", this.s);
      ((ADCData.g)localObject).a("available_stores", this.w);
      ((ADCData.g)localObject).b("imei_sha1", this.E);
      ((ADCData.g)localObject).b("memory_class", this.I);
      ((ADCData.g)localObject).b("memory_used_mb", this.J);
      ((ADCData.g)localObject).b("advertiser_id", this.L);
      ((ADCData.g)localObject).b("limit_tracking", this.O);
      ((ADCData.g)localObject).b("immersion", this.P);
      this.j = ((ADCData.g)localObject);
      this.a.f.a();
      this.a.c.a();
      this.a.d.a();
      this.a.b.a();
      this.a.e.a();
      this.g = true;
      a.l.b.i.o = new n.ag();
      this.a.b.h();
      if ((this.a.b.i.i == null) || (this.a.b.i.i.equals(""))) {
        this.a.b.i.i = "all";
      }
      if ((this.a.b.i.j == null) || (this.a.b.i.j.equals(""))) {
        this.a.b.i.j = "all";
      }
      return;
      localObject = a(aa.b(this.u), "");
      break;
      bool = false;
      break label330;
    }
  }
  
  void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str.split(",");
    int i2 = paramString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = paramString[i1].split(":");
      if (localObject.length == 2)
      {
        str = localObject[0];
        localObject = localObject[1];
        if (str.equals("version")) {
          this.r = ((String)localObject);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("store"))
        {
          if ((((String)localObject).toLowerCase().equals("google")) || (((String)localObject).toLowerCase().equals("amazon"))) {
            this.s = ((String)localObject);
          } else {
            throw new AdColonyException("Origin store in client options must be set to either 'google' or 'amazon'");
          }
        }
        else if (str.equals("skippable"))
        {
          this.t = false;
          continue;
          if (localObject[0].equals("skippable")) {
            this.t = false;
          }
        }
      }
    }
  }
  
  void a(String paramString, n.a parama)
  {
    this.m = this.a.b.i.o.a(paramString);
    if (this.m == null) {}
    for (;;)
    {
      return;
      if (parama == null) {}
      for (this.n = this.m.k(); this.n != null; this.n = parama)
      {
        paramString = this.a.c;
        parama = this.n.z;
        this.i.b("video_enabled", parama.a);
        this.i.b("video_filepath", parama.b());
        this.i.b("video_width", parama.b);
        this.i.b("video_height", parama.c);
        this.i.b("video_duration", parama.k);
        this.i.b("engagement_delay", parama.m.e);
        this.i.b("skip_delay", parama.l.e);
        this.i.b("browser_close_image_normal", paramString.b(this.n.v.k.f));
        this.i.b("browser_close_image_down", paramString.b(this.n.v.k.h));
        this.i.b("browser_reload_image_normal", paramString.b(this.n.v.m.f));
        this.i.b("browser_reload_image_down", paramString.b(this.n.v.m.h));
        this.i.b("browser_back_image_normal", paramString.b(this.n.v.j.f));
        this.i.b("browser_back_image_down", paramString.b(this.n.v.j.h));
        this.i.b("browser_forward_image_normal", paramString.b(this.n.v.l.f));
        this.i.b("browser_forward_image_down", paramString.b(this.n.v.l.h));
        this.i.b("browser_stop_image_normal", paramString.b(this.n.v.i.f));
        this.i.b("browser_stop_image_down", paramString.b(this.n.v.i.h));
        this.i.b("browser_glow_button", paramString.b(this.n.v.a));
        this.i.b("browser_icon", paramString.b(this.n.v.h.d));
        this.i.b("mute", paramString.b(this.n.A.j.d));
        this.i.b("unmute", paramString.b(this.n.A.k.d));
        this.i.b("poster_image", paramString.b(this.n.A.g.a));
        this.i.b("thumb_image", paramString.b(this.n.A.f.a));
        this.i.b("advertiser_name", this.n.A.c);
        this.i.b("description", this.n.A.d);
        this.i.b("title", this.n.A.e);
        this.i.b("click_to_install", this.n.A.g.c.equals("install"));
        this.i.b("store_url", this.n.A.g.d);
        this.i.b("native_engagement_enabled", this.n.A.h.a);
        this.i.b("native_engagement_type", this.n.A.h.c);
        this.i.b("native_engagement_command", this.n.A.h.e);
        this.i.b("native_engagement_label", this.n.A.h.d);
        this.i.b("skip_video_image_normal", paramString.b(parama.l.f));
        this.i.b("skip_video_image_down", paramString.b(parama.l.h));
        this.i.b("engagement_image_normal", paramString.b(parama.m.f));
        this.i.b("engagement_image_down", paramString.b(parama.m.h));
        this.i.b("engagement_height", parama.m.c);
        this.i.b("image_overlay_enabled", parama.n.a);
        this.i.b("image_overlay_filepath", paramString.b(parama.n.f));
        this.i.b("haptics_enabled", parama.o.a);
        this.i.b("haptics_filepath", paramString.b(parama.o.c));
        this.i.b("v4iap_enabled", this.n.B.c);
        this.i.b("product_id", this.n.B.a);
        this.i.b("in_progress", this.n.B.b);
        b();
        return;
      }
    }
  }
  
  void b()
  {
    Object localObject = this.n.y.h;
    n.j localj = this.n.y.i;
    o localo = this.a.c;
    if (!this.n.y.d)
    {
      this.i.b("end_card_enabled", this.n.y.d);
      return;
    }
    if (localj.a())
    {
      a.Y = true;
      a.ad = localj.g;
      a.ae = localo.b(localj.f.b);
      this.i.b("close_image_normal", localo.b(localj.j.f));
      this.i.b("close_image_down", localo.b(localj.j.h));
      this.i.b("reload_image_normal", localo.b(localj.i.f));
      this.i.b("reload_image_down", localo.b(localj.i.h));
    }
    for (;;)
    {
      localObject = this.n.z;
      this.i.b("end_card_enabled", this.n.y.d);
      this.i.b("load_timeout_enabled", this.n.y.i.c);
      this.i.b("load_timeout", this.n.y.i.b);
      this.i.b("hardware_acceleration_disabled", this.a.b.i.e);
      return;
      a.Y = false;
      this.i.b("end_card_filepath", localo.b(((n.x)localObject).d));
      this.i.b("info_image_normal", localo.b(((n.x)localObject).f.f));
      this.i.b("info_image_down", localo.b(((n.x)localObject).f.h));
      this.i.b("info_url", ((n.x)localObject).f.j);
      this.i.b("replay_image_normal", localo.b(((n.x)localObject).h.f));
      this.i.b("replay_image_down", localo.b(((n.x)localObject).h.h));
      this.i.b("continue_image_normal", localo.b(((n.x)localObject).i.f));
      this.i.b("continue_image_down", localo.b(((n.x)localObject).i.h));
      this.i.b("download_image_normal", localo.b(((n.x)localObject).g.f));
      this.i.b("download_image_down", localo.b(((n.x)localObject).g.h));
      this.i.b("download_url", ((n.x)localObject).g.j);
    }
  }
  
  void b(String paramString)
  {
    a(paramString, null);
  }
  
  void c(String paramString)
  {
    this.m = this.a.b.i.o.a(paramString);
    this.n = this.m.k();
    paramString = this.a.c;
    n.ac localac = this.n.z;
    this.i.b("video_enabled", localac.a);
    this.i.b("video_filepath", localac.b());
    this.i.b("video_width", localac.b);
    this.i.b("video_height", localac.c);
    this.i.b("video_duration", localac.k);
    a.q = localac.k;
    this.i.b("engagement_delay", localac.m.e);
    this.i.b("skip_delay", localac.l.e);
    b();
    n.c localc = this.n.w;
    this.i.b("pre_popup_bg", paramString.b(localc.b.d.e));
    this.i.b("v4vc_logo", paramString.b(localc.b.d.l.d));
    this.i.b("no_button_normal", paramString.b(localc.b.d.n.f));
    this.i.b("no_button_down", paramString.b(localc.b.d.n.h));
    this.i.b("yes_button_normal", paramString.b(localc.b.d.m.f));
    this.i.b("yes_button_down", paramString.b(localc.b.d.m.h));
    this.i.b("done_button_normal", paramString.b(localc.c.d.m.f));
    this.i.b("done_button_down", paramString.b(localc.c.d.m.h));
    this.i.b("browser_close_image_normal", paramString.b(this.n.v.k.f));
    this.i.b("browser_close_image_down", paramString.b(this.n.v.k.h));
    this.i.b("browser_reload_image_normal", paramString.b(this.n.v.m.f));
    this.i.b("browser_reload_image_down", paramString.b(this.n.v.m.h));
    this.i.b("browser_back_image_normal", paramString.b(this.n.v.j.f));
    this.i.b("browser_back_image_down", paramString.b(this.n.v.j.h));
    this.i.b("browser_forward_image_normal", paramString.b(this.n.v.l.f));
    this.i.b("browser_forward_image_down", paramString.b(this.n.v.l.h));
    this.i.b("browser_stop_image_normal", paramString.b(this.n.v.i.f));
    this.i.b("browser_stop_image_down", paramString.b(this.n.v.i.h));
    this.i.b("browser_glow_button", paramString.b(this.n.v.a));
    this.i.b("browser_icon", paramString.b(this.n.v.h.d));
    this.i.b("skip_video_image_normal", paramString.b(localac.l.f));
    this.i.b("skip_video_image_down", paramString.b(localac.l.h));
    this.i.b("engagement_image_normal", paramString.b(localac.m.f));
    this.i.b("engagement_image_down", paramString.b(localac.m.h));
    this.i.b("engagement_height", localac.m.c);
    this.i.b("image_overlay_enabled", localac.n.a);
    this.i.b("image_overlay_filepath", paramString.b(localac.n.f));
    this.i.b("haptics_enabled", localac.o.a);
    this.i.b("haptics_filepath", paramString.b(localac.o.c));
    this.i.b("v4iap_enabled", this.n.B.c);
    this.i.b("product_id", this.n.B.a);
    this.i.b("in_progress", this.n.B.b);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */