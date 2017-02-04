package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AdColonyAd
  implements Serializable
{
  static final int a = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int e = 4;
  AdColonyIAPEngagement A = AdColonyIAPEngagement.NONE;
  HashMap<String, String> B = new HashMap();
  HashMap<String, ArrayList<String>> C = new HashMap();
  int f = 0;
  int g;
  String h;
  n.ad i;
  n.a j;
  String k = "";
  String l = "";
  String m = "";
  String n = "";
  String o = "";
  double p = 0.0D;
  double q = 0.0D;
  int r;
  boolean s;
  boolean t;
  boolean u;
  boolean v;
  boolean w;
  boolean x;
  AdColonyNativeAdView y;
  AdColonyAdListener z;
  
  abstract void a();
  
  abstract boolean a(boolean paramBoolean);
  
  abstract boolean b();
  
  boolean b(boolean paramBoolean)
  {
    if (this.f == 4) {
      return true;
    }
    if ((!isReady()) && (!paramBoolean)) {
      return false;
    }
    if ((!a(true)) && (paramBoolean)) {
      return false;
    }
    this.i = a.l.g(this.h);
    if (paramBoolean) {}
    for (n.a locala = this.i.l();; locala = this.i.k())
    {
      this.j = locala;
      if (this.j != null) {
        break;
      }
      return false;
    }
    this.B.put("replay", this.j.x.a);
    this.B.put("card_shown", this.j.x.b);
    this.B.put("html5_interaction", this.j.x.c);
    this.B.put("cancel", this.j.x.d);
    this.B.put("download", this.j.x.e);
    this.B.put("skip", this.j.x.f);
    this.B.put("info", this.j.x.g);
    this.B.put("custom_event", this.j.x.h);
    this.B.put("midpoint", this.j.x.i);
    this.B.put("card_dissolved", this.j.x.j);
    this.B.put("start", this.j.x.k);
    this.B.put("third_quartile", this.j.x.l);
    this.B.put("complete", this.j.x.m);
    this.B.put("continue", this.j.x.n);
    this.B.put("in_video_engagement", this.j.x.o);
    this.B.put("reward_v4vc", this.j.x.p);
    this.B.put("v4iap", this.j.x.q);
    this.B.put("first_quartile", this.j.x.r);
    this.B.put("video_expanded", this.j.x.t);
    this.B.put("sound_mute", this.j.x.u);
    this.B.put("sound_unmute", this.j.x.v);
    this.B.put("video_paused", this.j.x.w);
    this.B.put("video_resumed", this.j.x.x);
    this.B.put("native_start", this.j.x.y);
    this.B.put("native_first_quartile", this.j.x.z);
    this.B.put("native_midpoint", this.j.x.A);
    this.B.put("native_third_quartile", this.j.x.B);
    this.B.put("native_complete", this.j.x.C);
    this.B.put("native_overlay_click", this.j.x.D);
    this.B.put("click", this.j.x.s);
    this.C.put("replay", this.j.u.a);
    this.C.put("card_shown", this.j.u.b);
    this.C.put("html5_interaction", this.j.u.c);
    this.C.put("cancel", this.j.u.d);
    this.C.put("download", this.j.u.e);
    this.C.put("skip", this.j.u.f);
    this.C.put("midpoint", this.j.u.h);
    this.C.put("card_dissolved", this.j.u.i);
    this.C.put("start", this.j.u.j);
    this.C.put("third_quartile", this.j.u.k);
    this.C.put("complete", this.j.u.l);
    this.C.put("continue", this.j.u.m);
    this.C.put("in_video_engagement", this.j.u.n);
    this.C.put("reward_v4vc", this.j.u.o);
    this.C.put("v4iap", this.j.u.q);
    this.C.put("first_quartile", this.j.u.p);
    this.C.put("video_expanded", this.j.u.r);
    this.C.put("sound_mute", this.j.u.s);
    this.C.put("sound_unmute", this.j.u.t);
    this.C.put("video_paused", this.j.u.u);
    this.C.put("video_resumed", this.j.u.v);
    this.C.put("native_start", this.j.u.w);
    this.C.put("native_first_quartile", this.j.u.x);
    this.C.put("native_midpoint", this.j.u.y);
    this.C.put("native_third_quartile", this.j.u.z);
    this.C.put("native_complete", this.j.u.A);
    this.C.put("native_overlay_click", this.j.u.B);
    return true;
  }
  
  boolean c()
  {
    return b(false);
  }
  
  public boolean canceled()
  {
    return this.f == 1;
  }
  
  public int getAvailableViews()
  {
    if (!isReady()) {}
    while (!c()) {
      return 0;
    }
    return this.i.f();
  }
  
  public String getZoneID()
  {
    if (this.h == null) {
      return "";
    }
    return this.h;
  }
  
  public boolean iapEnabled()
  {
    return this.v;
  }
  
  public AdColonyIAPEngagement iapEngagementType()
  {
    return this.A;
  }
  
  public String iapProductID()
  {
    return this.n;
  }
  
  abstract boolean isReady();
  
  public boolean noFill()
  {
    return this.f == 2;
  }
  
  public boolean notShown()
  {
    return this.f != 4;
  }
  
  public boolean shown()
  {
    return this.f == 4;
  }
  
  public boolean skipped()
  {
    return this.f == 3;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */