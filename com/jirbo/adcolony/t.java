package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

class t
  implements ADCDownload.Listener
{
  d a;
  ArrayList<a> b = new ArrayList();
  ArrayList<a> c = new ArrayList();
  int d = 0;
  boolean e = false;
  int f;
  ADCData.c g = new ADCData.c();
  HashMap<Integer, Boolean> h = new HashMap();
  
  t(d paramd)
  {
    this.a = paramd;
  }
  
  void a()
  {
    b();
    this.d = 0;
  }
  
  void a(double paramDouble, AdColonyAd paramAdColonyAd)
  {
    if (paramAdColonyAd == null) {
      l.a.b("Ad object is released and null in track_video_progress");
    }
    double d1;
    do
    {
      return;
      d1 = paramAdColonyAd.p;
    } while (paramDouble < d1);
    label119:
    label165:
    ADCData.g localg;
    if ((d1 < 0.25D) && (paramDouble >= 0.25D))
    {
      if ((!AdColony.isZoneV4VC(paramAdColonyAd.h)) && (paramAdColonyAd.l.equals("native"))) {
        b("native_first_quartile", paramAdColonyAd);
      }
    }
    else
    {
      if ((d1 < 0.5D) && (paramDouble >= 0.5D))
      {
        if ((AdColony.isZoneV4VC(paramAdColonyAd.h)) || (!paramAdColonyAd.l.equals("native"))) {
          break label275;
        }
        b("native_midpoint", paramAdColonyAd);
      }
      if ((d1 < 0.75D) && (paramDouble >= 0.75D))
      {
        if ((AdColony.isZoneV4VC(paramAdColonyAd.h)) || (!paramAdColonyAd.l.equals("native"))) {
          break label285;
        }
        b("native_third_quartile", paramAdColonyAd);
      }
      if ((d1 < 1.0D) && (paramDouble >= 1.0D) && (!paramAdColonyAd.l.equals("native")))
      {
        l.a.a("Tracking ad event - complete");
        localg = new ADCData.g();
        if (!paramAdColonyAd.t) {
          break label295;
        }
        localg.b("ad_slot", a.l.e.j);
      }
    }
    for (;;)
    {
      localg.b("replay", paramAdColonyAd.u);
      a("complete", localg, paramAdColonyAd);
      paramAdColonyAd.j.r = false;
      paramAdColonyAd.p = paramDouble;
      return;
      b("first_quartile", paramAdColonyAd);
      break;
      label275:
      b("midpoint", paramAdColonyAd);
      break label119;
      label285:
      b("third_quartile", paramAdColonyAd);
      break label165;
      label295:
      localg.b("ad_slot", a.l.e.j);
    }
  }
  
  void a(ADCData.c paramc)
  {
    if (paramc.i() > 0)
    {
      ADCData.g localg = new ADCData.g();
      localg.a("downloads", paramc);
      a("assets", localg);
    }
  }
  
  void a(String paramString, ADCData.g paramg)
  {
    n.f localf = this.a.b.i.l;
    if (localf != null) {
      a(paramString, localf.i.e(paramString), paramg);
    }
    paramg = this.a.b.i.m;
    if (paramg != null) {
      a(paramString, (ArrayList)paramg.d.get(paramString));
    }
  }
  
  void a(String paramString, ADCData.g paramg, AdColonyAd paramAdColonyAd)
  {
    if (paramString == null)
    {
      l.d.b("No such event type:").b(paramString);
      return;
    }
    Object localObject;
    if ((paramString.equals("start")) || (paramString.equals("native_start")))
    {
      localObject = a.l.e;
      ((u)localObject).j += 1;
    }
    for (;;)
    {
      localObject = paramg;
      if (paramg == null)
      {
        localObject = new ADCData.g();
        ((ADCData.g)localObject).b("replay", paramAdColonyAd.u);
      }
      ((ADCData.g)localObject).b("s_imp_count", a.l.e.j);
      a(paramString, (String)paramAdColonyAd.B.get(paramString), (ADCData.g)localObject, paramAdColonyAd);
      a(paramString, (ArrayList)paramAdColonyAd.C.get(paramString));
      return;
      if ((paramString.equals("skip")) && (paramAdColonyAd != null)) {
        paramAdColonyAd.j.r = false;
      }
    }
  }
  
  void a(String paramString, AdColonyAd paramAdColonyAd)
  {
    if ((this.a == null) || (this.a.b == null) || (this.a.b.i == null) || (this.a.b.i.o == null) || (this.a.b.i.o.a(paramString) == null)) {}
    do
    {
      return;
      l.a.a("Ad request for zone ").b(paramString);
      paramString = this.a.b.i.o.a(paramString);
    } while ((paramString == null) || (paramString.l == null) || (paramString.l.a == null));
    ADCData.g localg = new ADCData.g();
    if (paramAdColonyAd.g == 0) {
      localg.b("request_denied", false);
    }
    for (;;)
    {
      localg.b("request_denied_reason", paramAdColonyAd.g);
      a("request", paramString.l.a, localg, paramAdColonyAd);
      l.a.a("Tracking ad request - URL : ").b(paramString.l.a);
      return;
      localg.b("request_denied", true);
    }
  }
  
  void a(String paramString1, String paramString2, ADCData.g paramg)
  {
    a(paramString1, paramString2, paramg, null);
  }
  
  void a(String paramString1, String paramString2, ADCData.g paramg, AdColonyAd paramAdColonyAd)
  {
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ADCData.g localg = paramg;
    if (paramg == null) {
      localg = new ADCData.g();
    }
    paramg = aa.b();
    if (paramAdColonyAd != null) {
      localg.b("asi", paramAdColonyAd.m);
    }
    double d1 = aa.c() - this.a.e.g;
    if ((d1 > 0.0D) && (d1 < 604800.0D)) {}
    localg.b("s_time", a.l.e.i);
    localg.b("sid", this.a.e.k);
    localg.b("guid", paramg);
    localg.b("guid_key", aa.b(paramg + "DUBu6wJ27y6xs7VWmNDw67DD"));
    paramg = new a();
    paramg.a = paramString1;
    paramg.b = paramString2;
    l.a.b("EVENT ---------------------------");
    l.a.a("EVENT - TYPE = ").b(paramString1);
    l.a.a("EVENT - URL  = ").b(paramString2);
    paramg.c = localg.q();
    if (paramString1.equals("reward_v4vc"))
    {
      paramg.d = localg.e("v4vc_name");
      paramg.h = localg.g("v4vc_amount");
    }
    this.b.add(paramg);
    this.e = true;
    a.z = true;
  }
  
  void a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      a locala = new a();
      locala.a = paramString;
      locala.b = str;
      locala.l = true;
      this.b.add(locala);
      i += 1;
    }
    this.e = true;
    a.z = true;
  }
  
  void b()
  {
    a.z = true;
    ADCData.c localc = k.c(new f("tracking_info.txt"));
    if (localc != null)
    {
      this.b.clear();
      int i = 0;
      while (i < localc.i())
      {
        ADCData.g localg = localc.b(i);
        a locala = new a();
        locala.a = localg.e("type");
        locala.b = localg.e("url");
        locala.c = localg.a("payload", null);
        locala.f = localg.g("attempts");
        locala.l = localg.h("third_party");
        if ((locala.a.equals("v4vc_callback")) || (locala.a.equals("reward_v4vc")))
        {
          locala.d = localg.e("v4vc_name");
          locala.h = localg.g("v4vc_amount");
        }
        this.b.add(locala);
        i += 1;
      }
    }
    l.a.a("Loaded ").a(this.b.size()).b(" events");
  }
  
  void b(String paramString, AdColonyAd paramAdColonyAd)
  {
    a(paramString, null, paramAdColonyAd);
  }
  
  void c()
  {
    this.c.clear();
    this.c.addAll(this.b);
    this.b.clear();
    ADCData.c localc = new ADCData.c();
    int i = 0;
    while (i < this.c.size())
    {
      a locala = (a)this.c.get(i);
      if (!locala.j)
      {
        this.b.add(locala);
        ADCData.g localg = new ADCData.g();
        localg.b("type", locala.a);
        localg.b("url", locala.b);
        if (locala.c != null) {
          localg.b("payload", locala.c);
        }
        localg.b("attempts", locala.f);
        if (locala.d != null)
        {
          localg.b("v4vc_name", locala.d);
          localg.b("v4vc_amount", locala.h);
        }
        if (locala.l) {
          localg.b("third_party", true);
        }
        localc.a(localg);
      }
      i += 1;
    }
    this.c.clear();
    l.a.a("Saving tracking_info (").a(this.b.size()).b(" events)");
    k.a(new f("tracking_info.txt"), localc);
  }
  
  void d()
  {
    if (this.e)
    {
      this.e = false;
      c();
    }
    e();
  }
  
  void e()
  {
    if (this.b.size() == 0) {}
    label277:
    for (;;)
    {
      return;
      while (this.b.size() > 1000) {
        this.b.remove(this.b.size() - 1);
      }
      if (q.c())
      {
        double d1 = aa.c();
        int i = 0;
        for (;;)
        {
          if (i >= this.b.size()) {
            break label277;
          }
          a locala = (a)this.b.get(i);
          if ((locala.e < d1) && (!locala.k))
          {
            if (this.d == 5) {
              break;
            }
            this.d += 1;
            locala.k = true;
            if (locala.a.equals("v4vc_callback"))
            {
              int j = this.f;
              this.f = (j + 1);
              locala.i = j;
              this.h.put(Integer.valueOf(locala.i), Boolean.valueOf(a.o));
            }
            ADCDownload localADCDownload = new ADCDownload(this.a, locala.b, this).a(locala);
            if (locala.l) {
              localADCDownload.h = true;
            }
            if (locala.c != null) {
              localADCDownload.a("application/json", locala.c);
            }
            l.b.a("Submitting '").a(locala.a).b("' event.");
            localADCDownload.b();
            a.z = true;
          }
          i += 1;
        }
      }
    }
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    int j = 10000;
    a.z = true;
    this.e = true;
    this.d -= 1;
    a locala1 = (a)paramADCDownload.e;
    l.a.a("on_download_finished - event.type = ").b(locala1.a);
    locala1.k = false;
    if (locala1.a.equals("session_start")) {
      a.h();
    }
    boolean bool2 = paramADCDownload.i;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (locala1.c != null)
      {
        Object localObject = k.b(paramADCDownload.p);
        if (localObject == null) {
          break label441;
        }
        bool2 = ((ADCData.g)localObject).e("status").equals("success");
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (locala1.a.equals("reward_v4vc"))
          {
            if (!((ADCData.g)localObject).h("v4vc_status")) {
              break label424;
            }
            localObject = ((ADCData.g)localObject).e("v4vc_callback");
            if (((String)localObject).length() <= 0) {
              break label394;
            }
            a locala2 = new a();
            locala2.a = "v4vc_callback";
            locala2.b = ((String)localObject);
            locala2.d = locala1.d;
            locala2.h = locala1.h;
            this.b.add(locala2);
            bool1 = bool2;
          }
        }
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (locala1.a.equals("v4vc_callback"))
      {
        l.a.b("v4vc_callback response:").b(paramADCDownload.p);
        if (paramADCDownload.p.indexOf("vc_success") == -1) {
          break label447;
        }
        if (a.U != null) {
          a.U.o = true;
        }
        l.a.b("v4vc_callback success");
        this.a.a(true, locala1.d, locala1.h);
        bool2 = bool1;
      }
    }
    label347:
    if (bool2)
    {
      l.a.a("Event submission SUCCESS for type: ").b(locala1.a);
      locala1.j = true;
    }
    for (;;)
    {
      if (!this.a.e.b) {
        c();
      }
      return;
      label394:
      if (a.U != null) {
        a.U.o = true;
      }
      l.a.b("Client-side V4VC success");
      bool1 = bool2;
      break;
      label424:
      l.a.b("Client-side V4VC failure");
      bool1 = bool2;
      break;
      label441:
      bool1 = false;
      break;
      label447:
      if ((paramADCDownload.p.indexOf("vc_decline") != -1) || (paramADCDownload.p.indexOf("vc_noreward") != -1))
      {
        l.c.a("Server-side V4VC failure: ").b(paramADCDownload.c);
        l.a.b("v4vc_callback declined");
        this.a.a(false, "", 0);
        bool2 = bool1;
        break label347;
      }
      l.c.a("Server-side V4VC failure: ").b(paramADCDownload.c);
      bool2 = false;
      break label347;
      l.a.a("Event submission FAILED for type: ").a(locala1.a).a(" on try ").b(locala1.f + 1);
      locala1.f += 1;
      if (locala1.f < 24) {
        break label645;
      }
      l.d.b("Discarding event after 24 attempts to report.");
      locala1.j = true;
      if (locala1.a.equals("v4vc_callback")) {
        this.a.a(false, "", 0);
      }
    }
    label645:
    int i = 20;
    if (locala1.g > 0) {
      i = locala1.g * 3;
    }
    if (i > 10000) {
      i = j;
    }
    for (;;)
    {
      l.a.a("Retrying in ").a(i).a(" seconds (attempt ").a(locala1.f).b(")");
      locala1.g = i;
      locala1.e = (aa.c() + i);
      break;
    }
  }
  
  static class a
  {
    String a;
    String b;
    String c;
    String d;
    double e;
    int f;
    int g;
    int h;
    int i = -1;
    boolean j;
    boolean k;
    boolean l;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */