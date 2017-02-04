package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class n
{
  static class a
  {
    n.p A;
    n.aa B;
    String a;
    String b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    long i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    n.n t;
    n.z u;
    n.m v;
    n.c w;
    n.b x;
    n.h y;
    n.ac z;
    
    boolean a()
    {
      if (!this.v.a()) {}
      while (((this.w.a) && (!this.w.a())) || ((this.A.a) && (!this.A.a())) || ((this.y.d) && (!this.y.a())) || (!this.z.a()) || (!this.B.a()) || (b())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return false;
                        this.a = paramg.e("uuid");
                        this.b = paramg.e("title");
                        this.c = paramg.g("ad_campaign_id");
                        this.d = paramg.g("ad_id");
                        this.e = paramg.g("ad_group_id");
                        this.f = paramg.g("cpcv_bid");
                        this.g = paramg.g("net_earnings");
                        this.h = paramg.a("expires", 660);
                        this.j = paramg.h("enable_in_app_store");
                        this.k = paramg.h("video_events_on_replays");
                        this.l = paramg.h("test_ad");
                        this.m = paramg.h("fullscreen");
                        this.n = paramg.h("house_ad");
                        this.o = paramg.h("contracted");
                        this.s = false;
                        this.i = System.currentTimeMillis();
                        this.t = new n.n();
                      } while (!this.t.a(paramg.b("limits")));
                      this.u = new n.z();
                    } while (!this.u.a(paramg.b("third_party_tracking")));
                    this.v = new n.m();
                  } while (!this.v.a(paramg.b("in_app_browser")));
                  this.A = new n.p();
                } while (!this.A.a(paramg.b("native")));
                this.w = new n.c();
              } while (!this.w.a(paramg.b("v4vc")));
              this.x = new n.b();
            } while (!this.x.a(paramg.b("ad_tracking")));
            this.y = new n.h();
          } while (!this.y.a(paramg.b("companion_ad")));
          this.z = new n.ac();
        } while (!this.z.a(paramg.b("video")));
        this.B = new n.aa();
      } while (!this.B.a(paramg.b("v4iap")));
      l.b.b("Finished parsing ad");
      return true;
    }
    
    boolean b()
    {
      return (this.q) || (System.currentTimeMillis() - this.i > this.h * 1000);
    }
    
    boolean c()
    {
      return this.r;
    }
    
    void d()
    {
      this.w.b();
      this.v.b();
      this.A.b();
      this.y.b();
      this.z.c();
    }
  }
  
  static class aa
  {
    String a;
    String b;
    boolean c;
    
    boolean a()
    {
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.c = paramg.h("enabled");
      if (!this.c) {
        return true;
      }
      this.a = ((String)paramg.d("product_ids").get(0));
      this.b = paramg.e("in_progress");
      return true;
    }
  }
  
  static class ab
  {
    int a;
    int b;
    int c;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = -1;
      this.b = -1;
      this.c = -1;
      return true;
    }
  }
  
  static class ac
  {
    boolean a;
    int b;
    int c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    double k;
    n.g l;
    n.g m;
    n.g n;
    n.k o;
    
    boolean a()
    {
      if (!this.a) {}
      do
      {
        return true;
        if (!a.l.c.a(this.d)) {
          return false;
        }
        if (!this.l.a()) {
          return false;
        }
        if (!this.m.a()) {
          return false;
        }
        if (!this.o.a()) {
          return false;
        }
        if (!this.n.a()) {
          return false;
        }
        if (b().equals("(file not found)")) {
          return false;
        }
        if ((a.l.b.i.i.equals("online")) && (!q.c()))
        {
          a.am = 9;
          return l.c.b("Video not ready due to VIEW_FILTER_ONLINE");
        }
        if ((a.l.b.i.i.equals("wifi")) && (!q.a()))
        {
          a.am = 9;
          return l.c.b("Video not ready due to VIEW_FILTER_WIFI");
        }
        if ((a.l.b.i.i.equals("cell")) && (!q.b()))
        {
          a.am = 9;
          return l.c.b("Video not ready due to VIEW_FILTER_CELL");
        }
      } while ((!a.l.b.i.i.equals("offline")) || (!q.c()));
      a.am = 9;
      return l.c.b("Video not ready due to VIEW_FILTER_OFFLINE");
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.a = paramg.h("enabled");
              if (!this.a) {
                return true;
              }
              this.b = paramg.g("width");
              this.c = paramg.g("height");
              this.d = paramg.e("url");
              this.e = paramg.e("last_modified");
              this.f = paramg.e("video_frame_rate");
              this.g = paramg.e("audio_channels");
              this.h = paramg.e("audio_codec");
              this.i = paramg.e("audio_sample_rate");
              this.j = paramg.e("video_codec");
              this.k = paramg.f("duration");
              this.l = new n.g();
            } while (!this.l.a(paramg.b("skip_video")));
            this.m = new n.g();
          } while (!this.m.a(paramg.b("in_video_engagement")));
          this.o = new n.k();
        } while (!this.o.a(paramg.b("haptic")));
        this.n = new n.g();
      } while (!this.n.a(paramg.b("in_video_engagement").b("image_overlay")));
      return true;
    }
    
    String b()
    {
      return a.l.c.b(this.d);
    }
    
    void c()
    {
      a.l.c.a(this.d, this.e);
      this.m.b();
      this.l.b();
      this.o.b();
      this.n.b();
    }
  }
  
  static class ad
  {
    String a;
    ADCData.g b;
    int c;
    int d;
    int e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    ADCData.c j;
    ArrayList<String> k;
    n.ae l;
    n.d m;
    n.af n;
    long o = 600000L;
    long p = 60000L;
    long q;
    af r;
    int s = 0;
    
    int a(int paramInt1, int paramInt2)
    {
      int i1;
      if (paramInt2 <= 0) {
        i1 = 0;
      }
      do
      {
        return i1;
        i1 = paramInt2;
      } while (paramInt1 == -1);
      if (paramInt1 < paramInt2) {}
      for (;;)
      {
        return paramInt1;
        paramInt1 = paramInt2;
      }
    }
    
    /* Error */
    int a(n.a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: getfield 59	com/jirbo/adcolony/n$a:q	Z
      //   6: istore_3
      //   7: iload_3
      //   8: ifeq +9 -> 17
      //   11: iconst_0
      //   12: istore_2
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_2
      //   16: ireturn
      //   17: iconst_1
      //   18: istore_2
      //   19: goto -6 -> 13
      //   22: astore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	27	0	this	ad
      //   0	27	1	parama	n.a
      //   12	7	2	i1	int
      //   6	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	22	finally
    }
    
    boolean a()
    {
      boolean bool = false;
      if (this.m == null) {
        bool = true;
      }
      label67:
      label68:
      for (;;)
      {
        return bool;
        Iterator localIterator = this.m.a.iterator();
        int i1 = 0;
        if (localIterator.hasNext())
        {
          if (((n.a)localIterator.next()).b()) {
            break label67;
          }
          i1 += 1;
        }
        for (;;)
        {
          break;
          if (i1 >= this.f) {
            break label68;
          }
          return true;
        }
      }
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.b = paramg;
      this.a = paramg.e("uuid");
      this.g = paramg.h("enabled");
      this.h = paramg.h("active");
      if (Long.parseLong(paramg.a("last_config_ms", "0")) == 0L) {}
      for (long l1 = System.currentTimeMillis();; l1 = Long.parseLong(paramg.e("last_config_ms")))
      {
        this.q = l1;
        this.i = paramg.h("clear_ad_queue");
        if ((this.g) && (this.h)) {
          break;
        }
        return true;
      }
      this.c = paramg.g("play_interval");
      this.d = paramg.g("daily_play_cap");
      this.e = paramg.g("session_play_cap");
      this.f = paramg.a("min_ad_thresh", 1);
      this.p = (paramg.a("min_config_win", 60) * 1000L);
      this.o = (paramg.a("max_config_win", 600) * 1000L);
      this.k = new ArrayList();
      ArrayList localArrayList = paramg.d("play_order");
      this.k = localArrayList;
      if (localArrayList == null) {
        return false;
      }
      this.l = new n.ae();
      if (!this.l.a(paramg.b("tracking"))) {
        return false;
      }
      if ((this.m == null) || (this.i)) {
        this.m = new n.d();
      }
      if (!this.m.a(paramg.c("ads"))) {
        return false;
      }
      if (!a.C) {
        l.c.a("Finished parsing response for zone \"").a(this.a).a("\": ").a(this.m.b()).b(" ad(s). Attempting to cache media assets.");
      }
      this.n = new n.af();
      if (!this.n.a(paramg.b("v4vc"))) {
        return false;
      }
      this.r = a.l.g.a(this.a);
      l.a.b("Finished parsing zone");
      return true;
    }
    
    boolean a(boolean paramBoolean)
    {
      if (!paramBoolean) {
        a.h();
      }
      if ((!this.g) || (!this.h)) {}
      label108:
      for (;;)
      {
        return false;
        if ((this.m.b() != 0) && (this.k.size() != 0))
        {
          int i2 = this.k.size();
          int i1 = 0;
          n.a locala;
          if (i1 < i2)
          {
            locala = k();
            if (locala == null) {
              continue;
            }
            if (!locala.a()) {}
          }
          for (;;)
          {
            if ((locala == null) || (a(locala) == 0)) {
              break label108;
            }
            return true;
            m();
            i1 += 1;
            break;
            locala = null;
          }
        }
      }
    }
    
    boolean a(boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = true;
      if (!paramBoolean2)
      {
        paramBoolean1 = a(paramBoolean1);
        return paramBoolean1;
      }
      if ((!this.g) || (!this.h))
      {
        a.am = 1;
        return l.c.b("Ad is not ready to be played, as zone " + this.a + " is disabled or inactive.");
      }
      if ((this.m.b() == 0) || (this.k.size() == 0))
      {
        a.am = 5;
        return l.c.b("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.a + ".");
      }
      int i2 = this.k.size();
      int i1 = 0;
      label140:
      n.a locala;
      if (i1 < i2)
      {
        locala = k();
        if (locala == null) {
          return l.c.b("Ad is not ready to be played due to an unknown error.");
        }
        if (!locala.a()) {}
      }
      for (;;)
      {
        if (locala == null)
        {
          a.am = 6;
          return l.c.b("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.a + ".");
          m();
          i1 += 1;
          break label140;
        }
        paramBoolean1 = bool;
        if (a(locala) != 0) {
          break;
        }
        return false;
        locala = null;
      }
    }
    
    boolean b()
    {
      boolean bool = false;
      if (this.s % this.n.f == 0)
      {
        this.s = 0;
        bool = true;
      }
      return bool;
    }
    
    boolean b(boolean paramBoolean)
    {
      boolean bool = true;
      if (!paramBoolean) {
        paramBoolean = h();
      }
      do
      {
        return paramBoolean;
        if ((!this.g) || (!this.h))
        {
          a.am = 1;
          return l.c.b("Ad is not ready, as zone " + this.a + " is disabled or inactive.");
        }
        if (this.m.b() == 0)
        {
          a.am = 5;
          return l.c.b("Ad is not ready, as there are currently no ads to play in zone " + this.a + ".");
        }
        paramBoolean = bool;
      } while (!this.m.c().w.a);
      a.am = 14;
      return l.c.b("Ad is not ready, as zone " + this.a + " is V4VC enabled and must be played using an AdColonyV4VCAd object.");
    }
    
    boolean c()
    {
      return a(false, true);
    }
    
    boolean c(boolean paramBoolean)
    {
      boolean bool = true;
      if (!paramBoolean) {
        paramBoolean = j();
      }
      do
      {
        return paramBoolean;
        if ((!this.g) || (!this.h))
        {
          a.am = 1;
          return l.c.b("Ad is not ready, as zone " + this.a + " is disabled or inactive.");
        }
        if (this.m.b() == 0)
        {
          a.am = 5;
          return l.c.b("Ad is not ready, as there are currently no ads to play in zone " + this.a + ".");
        }
        paramBoolean = bool;
      } while (this.m.c().w.a);
      a.am = 15;
      return l.c.b("Ad is not ready, as zone " + this.a + " is not V4VC enabled and must be played using an AdColonyVideoAd object.");
    }
    
    boolean d()
    {
      if (this.c <= 1) {}
      int i1;
      do
      {
        return false;
        a.l.g.b = true;
        af localaf = this.r;
        i1 = localaf.b;
        localaf.b = (i1 + 1);
      } while (i1 == 0);
      if (this.r.b >= this.c) {
        this.r.b = 0;
      }
      return true;
    }
    
    void e()
    {
      a.l.b.e();
    }
    
    int f()
    {
      try
      {
        int i1 = a(k());
        return i1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean g()
    {
      return b(true);
    }
    
    boolean h()
    {
      if ((!this.g) || (!this.h)) {}
      while ((this.m.b() == 0) || (this.m.c().w.a)) {
        return false;
      }
      return true;
    }
    
    boolean i()
    {
      return c(true);
    }
    
    boolean j()
    {
      if ((!this.g) || (!this.h)) {}
      while ((this.m.b() == 0) || (!this.m.c().w.a)) {
        return false;
      }
      return true;
    }
    
    n.a k()
    {
      if (this.k.size() > 0) {
        return this.m.a((String)this.k.get(this.r.c % this.k.size()));
      }
      return null;
    }
    
    n.a l()
    {
      if (this.k.size() > 0) {
        return this.m.b(this.r.c % this.k.size());
      }
      return null;
    }
    
    void m()
    {
      if (this.k.size() > 0) {
        this.r.c = ((this.r.c + 1) % this.k.size());
      }
    }
    
    void n()
    {
      if ((!this.g) || (!this.h)) {}
      for (;;)
      {
        return;
        int i1 = 0;
        while (i1 < this.m.b())
        {
          this.m.a(i1).d();
          i1 += 1;
        }
      }
    }
  }
  
  static class ae
  {
    String a;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return true;
      }
      this.a = paramg.a("request", null);
      return true;
    }
  }
  
  static class af
  {
    boolean a;
    n.ab b;
    int c;
    String d;
    boolean e;
    int f;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        return false;
        this.a = paramg.h("enabled");
        if (!this.a) {
          return true;
        }
        this.b = new n.ab();
      } while (!this.b.a(paramg.b("limits")));
      this.c = paramg.g("reward_amount");
      this.d = paramg.e("reward_name");
      this.e = paramg.h("client_side");
      this.f = paramg.g("videos_per_reward");
      return true;
    }
  }
  
  static class ag
  {
    ArrayList<n.ad> a = new ArrayList();
    
    n.ad a(int paramInt)
    {
      return (n.ad)this.a.get(paramInt);
    }
    
    n.ad a(String paramString)
    {
      int i = 0;
      while (i < this.a.size())
      {
        n.ad localad = (n.ad)this.a.get(i);
        if (localad.a.equals(paramString)) {
          return localad;
        }
        i += 1;
      }
      return null;
    }
    
    void a()
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (((n.ad)this.a.get(i)).m != null) {
          ((n.ad)this.a.get(i)).m.a();
        }
        i += 1;
      }
    }
    
    boolean a(ADCData.c paramc)
    {
      if (paramc == null)
      {
        a.p = false;
        return false;
      }
      int i = 0;
      while (i < paramc.i())
      {
        ADCData.g localg = paramc.b(i);
        n.ad localad2 = a(localg.e("uuid"));
        n.ad localad1 = localad2;
        if (localad2 == null) {
          localad1 = new n.ad();
        }
        if (!localad1.a(localg))
        {
          a.p = false;
          return false;
        }
        this.a.add(localad1);
        i += 1;
      }
      a.p = false;
      return true;
    }
    
    int b()
    {
      return this.a.size();
    }
    
    n.ad c()
    {
      return (n.ad)this.a.get(0);
    }
  }
  
  static class b
  {
    String A;
    String B;
    String C;
    String D;
    ADCData.g E = new ADCData.g();
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return true;
      }
      this.a = paramg.a("replay", null);
      this.b = paramg.a("card_shown", null);
      this.c = paramg.a("html5_interaction", null);
      this.d = paramg.a("cancel", null);
      this.e = paramg.a("download", null);
      this.f = paramg.a("skip", null);
      this.g = paramg.a("info", null);
      this.h = paramg.a("custom_event", null);
      this.i = paramg.a("midpoint", null);
      this.j = paramg.a("card_dissolved", null);
      this.k = paramg.a("start", null);
      this.l = paramg.a("third_quartile", null);
      this.m = paramg.a("complete", null);
      this.n = paramg.a("continue", null);
      this.o = paramg.a("in_video_engagement", null);
      this.p = paramg.a("reward_v4vc", null);
      this.r = paramg.a("first_quartile", null);
      this.q = paramg.a("v4iap", null);
      this.s = paramg.a("click", null);
      this.t = paramg.a("video_expanded", null);
      this.u = paramg.a("sound_mute", null);
      this.v = paramg.a("sound_unmute", null);
      this.w = paramg.a("video_paused", null);
      this.x = paramg.a("video_resumed", null);
      this.y = paramg.a("native_start", null);
      this.z = paramg.a("native_first_quartile", null);
      this.A = paramg.a("native_midpoint", null);
      this.B = paramg.a("native_third_quartile", null);
      this.C = paramg.a("native_complete", null);
      this.D = paramg.a("native_overlay_click", null);
      this.E.b("replay", this.a);
      this.E.b("card_shown", this.b);
      this.E.b("html5_interaction", this.c);
      this.E.b("cancel", this.d);
      this.E.b("download", this.e);
      this.E.b("skip", this.f);
      this.E.b("info", this.g);
      this.E.b("custom_event", this.h);
      this.E.b("midpoint", this.i);
      this.E.b("card_dissolved", this.j);
      this.E.b("start", this.k);
      this.E.b("third_quartile", this.l);
      this.E.b("complete", this.m);
      this.E.b("continue", this.n);
      this.E.b("in_video_engagement", this.o);
      this.E.b("reward_v4vc", this.p);
      this.E.b("first_quartile", this.r);
      this.E.b("v4iap", this.q);
      this.E.b("click", this.s);
      this.E.b("video_expanded", this.t);
      this.E.b("sound_mute", this.u);
      this.E.b("sound_unmute", this.v);
      this.E.b("video_paused", this.w);
      this.E.b("video_resumed", this.x);
      this.E.b("native_start", this.y);
      this.E.b("native_first_quartile", this.z);
      this.E.b("native_midpoint", this.A);
      this.E.b("native_third_quartile", this.B);
      this.E.b("native_complete", this.C);
      this.E.b("native_overlay_click", this.D);
      return true;
    }
  }
  
  static class c
  {
    boolean a;
    n.w b;
    n.u c;
    
    boolean a()
    {
      if (!this.b.a()) {}
      while (!this.c.a()) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          return false;
          this.a = paramg.h("enabled");
          if (!this.a) {
            return true;
          }
          this.b = new n.w();
        } while (!this.b.a(paramg.b("pre_popup")));
        this.c = new n.u();
      } while (!this.c.a(paramg.b("post_popup")));
      return true;
    }
    
    void b()
    {
      if (!this.a) {
        return;
      }
      this.b.b();
      this.c.b();
    }
  }
  
  static class d
  {
    ArrayList<n.a> a = new ArrayList();
    
    n.a a(int paramInt)
    {
      return (n.a)this.a.get(paramInt);
    }
    
    n.a a(String paramString)
    {
      int i = 0;
      while (i < this.a.size())
      {
        n.a locala = (n.a)this.a.get(i);
        if (locala.a.equals(paramString)) {
          return locala;
        }
        i += 1;
      }
      return null;
    }
    
    void a()
    {
      int i = 0;
      while (i < this.a.size())
      {
        n.a locala = (n.a)this.a.get(i);
        if ((locala.b()) && (!locala.s))
        {
          a.h();
          locala.s = true;
        }
        i += 1;
      }
    }
    
    void a(n.a parama)
    {
      this.a.add(parama);
    }
    
    boolean a(ADCData.c paramc)
    {
      if (paramc == null) {
        return false;
      }
      int i = 0;
      while (i < this.a.size())
      {
        if (((n.a)this.a.get(i)).b()) {
          this.a.remove(i);
        }
        i += 1;
      }
      i = 0;
      for (;;)
      {
        if (i >= paramc.i()) {
          break label98;
        }
        n.a locala = new n.a();
        if (!locala.a(paramc.b(i))) {
          break;
        }
        this.a.add(locala);
        i += 1;
      }
      label98:
      return true;
    }
    
    int b()
    {
      return this.a.size();
    }
    
    n.a b(int paramInt)
    {
      Object localObject;
      while (paramInt < this.a.size())
      {
        localObject = (n.a)this.a.get(paramInt);
        if (((n.a)localObject).A.a) {
          return (n.a)localObject;
        }
        paramInt += 1;
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= this.a.size()) {
          break label86;
        }
        n.a locala = (n.a)this.a.get(paramInt);
        localObject = locala;
        if (locala.A.a) {
          break;
        }
        paramInt += 1;
      }
      label86:
      return null;
    }
    
    n.a c()
    {
      return (n.a)this.a.get(0);
    }
  }
  
  static class e
  {
    boolean a;
    boolean b;
    String c;
    String d;
    boolean e = false;
    boolean f;
    double g;
    String h;
    String i;
    String j;
    int k;
    n.f l;
    n.y m;
    ArrayList<String> n;
    n.ag o = new n.ag();
    n.i p;
    
    void a()
    {
      l.a.b("Caching media");
      if (!this.a) {}
      for (;;)
      {
        return;
        int i1 = 0;
        while (i1 < this.o.b())
        {
          this.o.a(i1).n();
          i1 += 1;
        }
      }
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.a = paramg.h("enabled");
              this.b = paramg.h("log_screen_overlay");
              this.c = paramg.e("last_country");
              this.d = paramg.e("last_ip");
              this.f = paramg.h("collect_iap_enabled");
              this.g = paramg.f("media_pool_size");
              this.h = paramg.e("log_level");
              this.k = paramg.a("asset_tracking_interval", 60);
              this.i = paramg.e("view_network_pass_filter");
              this.j = paramg.e("cache_network_pass_filter");
              this.e = paramg.h("hardware_acceleration_disabled");
              if ((this.i == null) || (this.i.equals(""))) {
                this.i = "all";
              }
              if ((this.j == null) || (this.j.equals(""))) {
                this.j = "all";
              }
              this.l = new n.f();
            } while (!this.l.a(paramg.b("tracking")));
            this.m = new n.y();
          } while (!this.m.a(paramg.b("third_party_tracking")));
          this.n = paramg.d("console_messages");
          l.a.b("Parsing zones");
        } while (!this.o.a(paramg.c("zones")));
        this.p = new n.i();
      } while (!this.p.a(paramg.b("device")));
      l.a.b("Finished parsing app info");
      return true;
    }
    
    boolean a(String paramString)
    {
      return a(paramString, false, true);
    }
    
    boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (!this.a) {}
      do
      {
        return false;
        paramString = this.o.a(paramString);
      } while (paramString == null);
      return paramString.a(paramBoolean1, paramBoolean2);
    }
  }
  
  static class f
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    ADCData.g i;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return true;
      }
      this.a = paramg.a("update", null);
      this.b = paramg.a("install", null);
      this.c = paramg.a("dynamic_interests", null);
      this.d = paramg.a("user_meta_data", null);
      this.e = paramg.a("in_app_purchase", null);
      this.g = paramg.a("session_end", null);
      this.f = paramg.a("session_start", null);
      this.h = paramg.a("assets", null);
      this.i = new ADCData.g();
      this.i.b("update", this.a);
      this.i.b("install", this.b);
      this.i.b("dynamic_interests", this.c);
      this.i.b("user_meta_data", this.d);
      this.i.b("in_app_purchase", this.e);
      this.i.b("session_end", this.g);
      this.i.b("session_start", this.f);
      this.i.b("assets", this.h);
      paramg = new f("iap_cache.txt");
      ADCData.c localc = k.c(paramg);
      if (localc != null)
      {
        int j = 0;
        while (j < localc.i())
        {
          ADCData.g localg = localc.a(j, new ADCData.g());
          a.l.d.a("in_app_purchase", localg);
          j += 1;
        }
        paramg.c();
        a.aj.j();
      }
      a.O = true;
      return true;
    }
  }
  
  static class g
  {
    boolean a;
    int b;
    int c;
    int d;
    int e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    
    boolean a()
    {
      if (!this.a) {}
      do
      {
        return true;
        if (!a.l.c.a(this.f)) {
          return false;
        }
      } while (a.l.c.a(this.h));
      return false;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.a("enabled", true);
      this.e = paramg.g("delay");
      this.b = paramg.g("width");
      this.c = paramg.g("height");
      this.d = paramg.g("scale");
      this.f = paramg.e("image_normal");
      this.g = paramg.e("image_normal_last_modified");
      this.h = paramg.e("image_down");
      this.i = paramg.e("image_down_last_modified");
      this.j = paramg.e("click_action");
      this.k = paramg.e("click_action_type");
      this.l = paramg.e("label");
      this.m = paramg.e("label_rgba");
      this.n = paramg.e("label_shadow_rgba");
      this.o = paramg.e("label_html");
      this.p = paramg.e("event");
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.f, this.g);
      a.l.c.a(this.h, this.i);
    }
  }
  
  static class h
  {
    String a;
    int b;
    int c;
    boolean d;
    boolean e;
    boolean f;
    double g;
    n.x h;
    n.j i;
    
    boolean a()
    {
      if ((this.i.a) && (!this.i.a())) {}
      do
      {
        return false;
        if (!this.d) {
          return true;
        }
      } while ((!this.h.a()) && (!this.i.a()));
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          return false;
          this.d = paramg.h("enabled");
          if (!this.d) {
            return true;
          }
          this.a = paramg.e("uuid");
          this.b = paramg.g("ad_id");
          this.c = paramg.g("ad_campaign_id");
          this.e = paramg.h("dissolve");
          this.f = paramg.h("enable_in_app_store");
          this.g = paramg.f("dissolve_delay");
          this.h = new n.x();
        } while (!this.h.a(paramg.b("static")));
        this.i = new n.j();
      } while (!this.i.a(paramg.b("html5")));
      return true;
    }
    
    void b()
    {
      if (!this.d) {
        return;
      }
      this.h.b();
      this.i.b();
    }
  }
  
  static class i
  {
    String a;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.a("type", null);
      a.ah = this.a;
      return true;
    }
  }
  
  static class j
  {
    boolean a;
    double b;
    boolean c;
    boolean d;
    String e;
    n.o f;
    String g;
    n.l h;
    n.g i;
    n.g j;
    
    boolean a()
    {
      boolean bool2 = false;
      boolean bool1;
      if (!q.c())
      {
        a.am = 8;
        bool1 = l.c.b("Ad not ready due to no network connection.");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!this.a);
              bool1 = bool2;
            } while (!this.f.a());
            bool1 = bool2;
          } while (!this.h.a());
          bool1 = bool2;
        } while (!this.i.a());
        bool1 = bool2;
      } while (!this.j.a());
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.a = paramg.h("enabled");
              this.b = paramg.f("load_timeout");
              this.c = paramg.h("load_timeout_enabled");
              this.d = paramg.h("load_spinner_enabled");
              this.e = paramg.e("background_color");
              this.g = paramg.e("html5_tag");
              this.f = new n.o();
            } while (!this.f.a(paramg.b("mraid_js")));
            this.h = new n.l();
          } while (!this.h.a(paramg.b("background_logo")));
          this.i = new n.g();
        } while (!this.i.a(paramg.b("replay")));
        this.j = new n.g();
      } while (!this.j.a(paramg.b("close")));
      return true;
    }
    
    void b()
    {
      if (!this.a) {}
      do
      {
        return;
        if (this.f != null) {
          this.f.b();
        }
        if (this.h != null) {
          this.h.b();
        }
        if (this.i != null) {
          this.i.b();
        }
      } while (this.j == null);
      this.j.b();
    }
  }
  
  static class k
  {
    boolean a;
    String b;
    String c;
    String d;
    
    boolean a()
    {
      if (!this.a) {}
      while (a.l.c.a(this.c)) {
        return true;
      }
      return false;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.a("enabled", false);
      this.c = paramg.e("file_url");
      this.d = paramg.e("last_modified");
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.c, this.d);
    }
  }
  
  static class l
  {
    int a;
    int b;
    int c;
    String d;
    String e;
    boolean f;
    
    boolean a()
    {
      if (!this.f) {
        return true;
      }
      return a.l.c.a(this.d);
    }
    
    boolean a(ADCData.g paramg)
    {
      boolean bool = true;
      if (paramg == null) {
        bool = false;
      }
      do
      {
        return bool;
        this.f = paramg.a("enabled", true);
        this.a = paramg.g("width");
        this.b = paramg.g("height");
        this.c = paramg.g("scale");
        this.d = paramg.e("image");
        this.e = paramg.e("image_last_modified");
      } while (!this.e.equals(""));
      this.e = paramg.e("last_modified");
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.d, this.e);
    }
  }
  
  static class m
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    n.l h;
    n.g i;
    n.g j;
    n.g k;
    n.g l;
    n.g m;
    
    boolean a()
    {
      if (!a.l.c.a(this.a)) {}
      while ((!a.l.c.a(this.c)) || (!a.l.c.a(this.e)) || (!this.h.a()) || (!this.i.a()) || (!this.j.a()) || (!this.k.a()) || (!this.l.a()) || (!this.m.a())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                    this.a = paramg.e("tiny_glow_image");
                    this.b = paramg.e("tiny_glow_image_last_modified;");
                    this.c = paramg.e("background_bar_image");
                    this.d = paramg.e("background_bar_image_last_modified");
                    this.e = paramg.e("background_tile_image");
                    this.f = paramg.e("background_tile_image_last_modified");
                    this.g = paramg.e("background_color");
                    this.h = new n.l();
                  } while (!this.h.a(paramg.b("logo")));
                  this.h = new n.l();
                } while (!this.h.a(paramg.b("logo")));
                this.i = new n.g();
              } while (!this.i.a(paramg.b("stop")));
              this.j = new n.g();
            } while (!this.j.a(paramg.b("back")));
            this.k = new n.g();
          } while (!this.k.a(paramg.b("close")));
          this.l = new n.g();
        } while (!this.l.a(paramg.b("forward")));
        this.m = new n.g();
      } while (!this.m.a(paramg.b("reload")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.a, this.b);
      a.l.c.a(this.c, this.d);
      a.l.c.a(this.e, this.f);
      this.h.b();
      this.i.b();
      this.j.b();
      this.k.b();
      this.l.b();
      this.m.b();
    }
  }
  
  static class n
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = -1;
      this.b = -1;
      this.c = -1;
      this.d = -1;
      this.e = -1;
      this.f = -1;
      this.g = -1;
      this.h = -1;
      return true;
    }
  }
  
  static class o
  {
    boolean a;
    String b;
    String c;
    
    boolean a()
    {
      if (!this.a) {}
      while (a.l.c.a(this.b)) {
        return true;
      }
      return false;
    }
    
    boolean a(ADCData.g paramg)
    {
      boolean bool = true;
      if (paramg == null) {
        bool = false;
      }
      do
      {
        return bool;
        this.a = paramg.h("enabled");
      } while (!this.a);
      this.b = paramg.e("url");
      this.c = paramg.e("last_modified");
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.b, this.c);
    }
  }
  
  static class p
  {
    boolean a;
    boolean b;
    String c;
    String d;
    String e;
    n.s f;
    n.r g;
    n.q h;
    boolean i;
    n.l j;
    n.l k;
    
    boolean a()
    {
      if (!this.a) {}
      while ((!a.l.c.a(this.g.a)) || (!a.l.c.a(this.f.a)) || (!this.j.a()) || (!this.k.a()) || (this.i)) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                this.a = paramg.h("enabled");
                this.c = paramg.e("advertiser_name");
                this.d = paramg.e("description");
                this.e = paramg.e("title");
                this.i = false;
                this.f = new n.s();
              } while (!this.f.a(paramg.b("thumb")));
              this.g = new n.r();
            } while (!this.g.a(paramg.b("poster")));
            this.j = new n.l();
          } while (!this.j.a(paramg.b("mute")));
          this.b = this.j.f;
          this.k = new n.l();
        } while (!this.k.a(paramg.b("unmute")));
        this.h = new n.q();
      } while (!this.h.a(paramg.b("overlay")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.g.a, this.g.b);
      a.l.c.a(this.f.a, this.f.b);
      this.j.b();
      this.k.b();
    }
  }
  
  static class q
  {
    boolean a;
    boolean b;
    String c;
    String d;
    String e;
    
    boolean a(ADCData.g paramg)
    {
      boolean bool = true;
      if (paramg == null) {
        bool = false;
      }
      do
      {
        return bool;
        this.a = paramg.h("enabled");
      } while (!this.a);
      this.b = paramg.h("in_app");
      this.c = paramg.e("click_action_type");
      this.e = paramg.e("click_action");
      this.d = paramg.e("label");
      return true;
    }
  }
  
  static class r
  {
    String a;
    String b;
    String c;
    String d;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.e("image");
      this.b = paramg.e("last_modified");
      this.c = paramg.e("click_action_type");
      this.d = paramg.e("click_action");
      return true;
    }
  }
  
  static class s
  {
    String a;
    String b;
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.e("image");
      this.b = paramg.e("last_modified");
      return true;
    }
  }
  
  static class t
  {
    int a;
    String b;
    int c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    n.l l;
    n.g m;
    
    boolean a()
    {
      if (!a.l.c.a(this.e)) {}
      while ((!this.l.a()) || (!this.m.a())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      this.a = paramg.g("scale");
      this.b = paramg.e("label_reward");
      this.c = paramg.g("width");
      this.d = paramg.g("height");
      this.e = paramg.e("image");
      this.f = paramg.e("image_last_modified");
      this.g = paramg.e("label");
      this.h = paramg.e("label_rgba");
      this.i = paramg.e("label_shadow_rgba");
      this.j = paramg.e("label_fraction");
      this.k = paramg.e("label_html");
      this.l = new n.l();
      if (!this.l.a(paramg.b("logo"))) {}
      do
      {
        return false;
        this.m = new n.g();
      } while (!this.m.a(paramg.b("option_done")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.e, this.f);
      this.l.b();
      this.m.b();
    }
  }
  
  static class u
  {
    String a;
    String b;
    n.l c;
    n.t d;
    
    boolean a()
    {
      if (!a.l.c.a(this.a)) {}
      while ((!this.c.a()) || (!this.d.a())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      this.a = paramg.e("background_image");
      this.b = paramg.e("background_image_last_modified");
      this.c = new n.l();
      if (!this.c.a(paramg.b("background_logo"))) {}
      do
      {
        return false;
        this.d = new n.t();
      } while (!this.d.a(paramg.b("dialog")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.a, this.b);
      this.d.b();
    }
  }
  
  static class v
  {
    int a;
    String b;
    int c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    n.l l;
    n.g m;
    n.g n;
    
    boolean a()
    {
      if (!a.l.c.a(this.e)) {}
      while ((!this.l.a()) || (!this.m.a())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      this.a = paramg.g("scale");
      this.b = paramg.e("label_reward");
      this.c = paramg.g("width");
      this.d = paramg.g("height");
      this.e = paramg.e("image");
      this.f = paramg.e("image_last_modified");
      this.g = paramg.e("label");
      this.h = paramg.e("label_rgba");
      this.i = paramg.e("label_shadow_rgba");
      this.j = paramg.e("label_fraction");
      this.k = paramg.e("label_html");
      this.l = new n.l();
      if (!this.l.a(paramg.b("logo"))) {}
      do
      {
        do
        {
          return false;
          this.m = new n.g();
        } while (!this.m.a(paramg.b("option_yes")));
        this.n = new n.g();
      } while (!this.n.a(paramg.b("option_no")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.e, this.f);
      this.l.b();
      this.m.b();
      this.n.b();
    }
  }
  
  static class w
  {
    String a;
    String b;
    n.l c;
    n.v d;
    
    boolean a()
    {
      if (!a.l.c.a(this.a)) {}
      while ((!this.c.a()) || (!this.d.a())) {
        return false;
      }
      return true;
    }
    
    boolean a(ADCData.g paramg)
    {
      this.a = paramg.e("background_image");
      this.b = paramg.e("background_image_last_modified");
      this.c = new n.l();
      if (!this.c.a(paramg.b("background_logo"))) {}
      do
      {
        return false;
        this.d = new n.v();
      } while (!this.d.a(paramg.b("dialog")));
      return true;
    }
    
    void b()
    {
      a.l.c.a(this.a, this.b);
      this.c.b();
      this.d.b();
    }
  }
  
  static class x
  {
    boolean a;
    int b;
    int c;
    String d;
    String e;
    n.g f;
    n.g g;
    n.g h;
    n.g i;
    
    boolean a()
    {
      if (!this.a) {}
      do
      {
        return true;
        if (!a.l.c.a(this.d)) {
          return false;
        }
        if (!this.h.a()) {
          return false;
        }
        if (!this.i.a()) {
          return false;
        }
        if (!this.g.a()) {
          return false;
        }
      } while (this.f.a());
      return false;
    }
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.a = paramg.h("enabled");
              if (!this.a) {
                return true;
              }
              this.b = paramg.g("width");
              this.c = paramg.g("height");
              this.d = paramg.e("background_image");
              this.e = paramg.e("background_image_last_modified");
              if (a.f != null) {
                this.d = a.f;
              }
              this.h = new n.g();
            } while (!this.h.a(paramg.b("replay")));
            this.i = new n.g();
          } while (!this.i.a(paramg.b("continue")));
          this.g = new n.g();
        } while (!this.g.a(paramg.b("download")));
        this.f = new n.g();
      } while (!this.f.a(paramg.b("info")));
      return true;
    }
    
    void b()
    {
      if (!this.a) {
        return;
      }
      a.l.c.a(this.d, this.e);
      this.h.b();
      this.i.b();
      this.g.b();
      this.f.b();
    }
  }
  
  static class y
  {
    ArrayList<String> a = new ArrayList();
    ArrayList<String> b = new ArrayList();
    ArrayList<String> c = new ArrayList();
    HashMap<String, ArrayList<String>> d = new HashMap();
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {}
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            return false;
            localArrayList = paramg.d("update");
            this.a = localArrayList;
          } while (localArrayList == null);
          localArrayList = paramg.d("install");
          this.b = localArrayList;
        } while (localArrayList == null);
        paramg = paramg.d("session_start");
        this.c = paramg;
      } while (paramg == null);
      this.d.put("update", this.a);
      this.d.put("install", this.b);
      this.d.put("session_start", this.c);
      return true;
    }
  }
  
  static class z
  {
    ArrayList<String> A = new ArrayList();
    ArrayList<String> B = new ArrayList();
    HashMap<String, ArrayList<String>> C = new HashMap();
    ArrayList<String> a = new ArrayList();
    ArrayList<String> b = new ArrayList();
    ArrayList<String> c = new ArrayList();
    ArrayList<String> d = new ArrayList();
    ArrayList<String> e = new ArrayList();
    ArrayList<String> f = new ArrayList();
    ArrayList<String> g = new ArrayList();
    ArrayList<String> h = new ArrayList();
    ArrayList<String> i = new ArrayList();
    ArrayList<String> j = new ArrayList();
    ArrayList<String> k = new ArrayList();
    ArrayList<String> l = new ArrayList();
    ArrayList<String> m = new ArrayList();
    ArrayList<String> n = new ArrayList();
    ArrayList<String> o = new ArrayList();
    ArrayList<String> p = new ArrayList();
    ArrayList<String> q = new ArrayList();
    ArrayList<String> r = new ArrayList();
    ArrayList<String> s = new ArrayList();
    ArrayList<String> t = new ArrayList();
    ArrayList<String> u = new ArrayList();
    ArrayList<String> v = new ArrayList();
    ArrayList<String> w = new ArrayList();
    ArrayList<String> x = new ArrayList();
    ArrayList<String> y = new ArrayList();
    ArrayList<String> z = new ArrayList();
    
    boolean a(ADCData.g paramg)
    {
      if (paramg == null) {
        return false;
      }
      this.a = paramg.d("replay");
      this.b = paramg.d("card_shown");
      this.c = paramg.d("html5_interaction");
      this.d = paramg.d("cancel");
      this.e = paramg.d("download");
      this.f = paramg.d("skip");
      this.g = paramg.d("info");
      this.h = paramg.d("midpoint");
      this.i = paramg.d("card_dissolved");
      this.j = paramg.d("start");
      this.k = paramg.d("third_quartile");
      this.l = paramg.d("complete");
      this.m = paramg.d("continue");
      this.n = paramg.d("in_video_engagement");
      this.o = paramg.d("reward_v4vc");
      this.p = paramg.d("first_quartile");
      this.q = paramg.d("v4iap");
      this.r = paramg.d("video_expanded");
      this.s = paramg.d("sound_mute");
      this.t = paramg.d("sound_unmute");
      this.u = paramg.d("video_paused");
      this.v = paramg.d("video_resumed");
      this.w = paramg.d("native_start");
      this.x = paramg.d("native_first_quartile");
      this.y = paramg.d("native_midpoint");
      this.z = paramg.d("native_third_quartile");
      this.A = paramg.d("native_complete");
      this.B = paramg.d("native_overlay_click");
      this.C.put("replay", this.a);
      this.C.put("card_shown", this.b);
      this.C.put("html5_interaction", this.c);
      this.C.put("cancel", this.d);
      this.C.put("download", this.e);
      this.C.put("skip", this.f);
      this.C.put("info", this.g);
      this.C.put("midpoint", this.h);
      this.C.put("card_dissolved", this.i);
      this.C.put("start", this.j);
      this.C.put("third_quartile", this.k);
      this.C.put("complete", this.l);
      this.C.put("continue", this.m);
      this.C.put("in_video_engagement", this.n);
      this.C.put("reward_v4vc", this.o);
      this.C.put("first_quartile", this.p);
      this.C.put("v4iap", this.q);
      this.C.put("video_expanded", this.r);
      this.C.put("sound_mute", this.s);
      this.C.put("sound_unmute", this.t);
      this.C.put("video_paused", this.u);
      this.C.put("video_resumed", this.v);
      this.C.put("native_start", this.w);
      this.C.put("native_first_quartile", this.x);
      this.C.put("native_midpoint", this.y);
      this.C.put("native_third_quartile", this.z);
      this.C.put("native_complete", this.A);
      this.C.put("native_overlay_click", this.B);
      return true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */