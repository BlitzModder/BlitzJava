package com.jirbo.adcolony;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class o
  implements ADCDownload.Listener
{
  d a;
  ArrayList<a> b = new ArrayList();
  HashMap<String, a> c = new HashMap();
  int d = 1;
  aa.b e = new aa.b(2.0D);
  int f;
  ArrayList<String> g = new ArrayList();
  boolean h;
  boolean i;
  double j;
  
  o(d paramd)
  {
    this.a = paramd;
  }
  
  String a(String paramString, int paramInt)
  {
    int k = paramString.lastIndexOf('.');
    if (k == -1) {
      return paramInt + "";
    }
    String str = paramString.substring(k);
    paramString = str;
    if (str.contains("/")) {
      paramString = ".0";
    }
    return paramInt + paramString;
  }
  
  void a()
  {
    b();
    this.h = true;
  }
  
  void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    String str;
    Object localObject;
    do
    {
      return;
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localObject = (a)this.c.get(paramString1);
      if (localObject == null) {
        break label210;
      }
      ((a)localObject).h = aa.c();
      paramString2 = (String)localObject;
      if (!((a)localObject).c.equals(str)) {
        break;
      }
    } while ((((a)localObject).e) || (((a)localObject).d));
    paramString2 = (String)localObject;
    for (;;)
    {
      if (paramString2.f == 0)
      {
        int k = h();
        localObject = a(paramString1, k);
        localObject = this.a.f.c + (String)localObject;
        paramString2.f = k;
        paramString2.b = ((String)localObject);
      }
      paramString2.c = str;
      paramString2.d = true;
      paramString2.e = false;
      l.a.a("Adding ").a(paramString1).b(" to pending downloads.");
      this.g.add(paramString1);
      this.i = true;
      this.e.a(2.0D);
      a.z = true;
      return;
      label210:
      paramString2 = new a();
      paramString2.a = paramString1;
      this.b.add(paramString2);
      paramString2.h = aa.c();
      this.c.put(paramString1, paramString2);
    }
  }
  
  boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return false;
    }
    paramString = (a)this.c.get(paramString);
    if (paramString == null)
    {
      this.a.b.i.a();
      return false;
    }
    if ((paramString.b != null) && (paramString.b.equals("(file not found)"))) {
      return false;
    }
    if (paramString.e)
    {
      if (paramString.d) {
        return false;
      }
      paramString.h = aa.c();
      return true;
    }
    if (!paramString.d) {
      this.a.b.i.a();
    }
    return false;
  }
  
  String b(String paramString)
  {
    paramString = (a)this.c.get(paramString);
    if ((paramString == null) || (paramString.b == null)) {
      return "(file not found)";
    }
    paramString.h = aa.c();
    this.i = true;
    this.e.a(2.0D);
    return paramString.b;
  }
  
  void b()
  {
    l.a.b("Loading media info");
    Object localObject = k.b(new f("media_info.txt"));
    if (localObject == null)
    {
      localObject = new ADCData.g();
      l.a.b("No saved media info exists.");
    }
    for (;;)
    {
      this.d = ((ADCData.g)localObject).g("next_file_number");
      if (this.d <= 0) {
        this.d = 1;
      }
      localObject = ((ADCData.g)localObject).c("assets");
      if (localObject == null) {
        break;
      }
      this.b.clear();
      int k = 0;
      while (k < ((ADCData.c)localObject).i())
      {
        ADCData.g localg = ((ADCData.c)localObject).b(k);
        a locala = new a();
        locala.a = localg.e("url");
        locala.b = localg.e("filepath");
        locala.c = localg.e("last_modified");
        locala.f = localg.g("file_number");
        locala.g = localg.g("size");
        locala.e = localg.h("ready");
        locala.h = localg.f("last_accessed");
        if (locala.f > this.d) {
          this.d = (locala.f + 1);
        }
        this.b.add(locala);
        k += 1;
      }
      l.a.b("Loaded media info");
    }
    c();
  }
  
  void c()
  {
    Object localObject2 = new HashMap();
    String str1 = this.a.f.c;
    Object localObject1 = new File(str1).list();
    if (localObject1 == null) {
      localObject1 = new String[0];
    }
    for (;;)
    {
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject3 = localObject1[k];
        localObject3 = str1 + (String)localObject3;
        ((HashMap)localObject2).put(localObject3, localObject3);
        k += 1;
      }
      Object localObject3 = new HashMap();
      this.j = 0.0D;
      ArrayList localArrayList = new ArrayList();
      k = 0;
      while (k < this.b.size())
      {
        a locala = (a)this.b.get(k);
        if ((!locala.d) && (locala.e))
        {
          String str2 = locala.b;
          if ((((HashMap)localObject2).containsKey(str2)) && (new File(str2).length() == locala.g))
          {
            this.j += locala.g;
            localArrayList.add(locala);
            ((HashMap)localObject3).put(str2, str2);
          }
        }
        k += 1;
      }
      this.b = localArrayList;
      m = localObject1.length;
      k = 0;
      while (k < m)
      {
        localObject2 = localObject1[k];
        localObject2 = str1 + (String)localObject2;
        if (!((HashMap)localObject3).containsKey(localObject2))
        {
          l.b.a("Deleting unused media ").b(localObject2);
          new File((String)localObject2).delete();
        }
        k += 1;
      }
      this.c.clear();
      k = 0;
      while (k < this.b.size())
      {
        localObject1 = (a)this.b.get(k);
        this.c.put(((a)localObject1).a, localObject1);
        k += 1;
      }
      double d1 = this.a.b.i.g;
      if (d1 > 0.0D) {
        l.b.a("Media pool at ").a(this.j / 1048576.0D).a("/").a(d1 / 1048576.0D).b(" MB");
      }
      return;
    }
  }
  
  void d()
  {
    l.a.b("Saving media info");
    ADCData.c localc = new ADCData.c();
    int k = 0;
    while (k < this.b.size())
    {
      localObject = (a)this.b.get(k);
      if ((((a)localObject).e) && (!((a)localObject).d))
      {
        ADCData.g localg = new ADCData.g();
        localg.b("url", ((a)localObject).a);
        localg.b("filepath", ((a)localObject).b);
        localg.b("last_modified", ((a)localObject).c);
        localg.b("file_number", ((a)localObject).f);
        localg.b("size", ((a)localObject).g);
        localg.b("ready", ((a)localObject).e);
        localg.b("last_accessed", ((a)localObject).h);
        localc.a(localg);
      }
      k += 1;
    }
    Object localObject = new ADCData.g();
    ((ADCData.g)localObject).b("next_file_number", this.d);
    ((ADCData.g)localObject).a("assets", localc);
    k.a(new f("media_info.txt"), (ADCData.g)localObject);
    this.i = false;
  }
  
  void e()
  {
    f();
    if ((this.i) && (this.e.a()))
    {
      g();
      d();
    }
  }
  
  void f()
  {
    if ((this.a.b.i.j.equals("wifi")) && (!q.a())) {
      l.a.b("Skipping asset download due to CACHE_FILTER_WIFI");
    }
    for (;;)
    {
      return;
      if ((this.a.b.i.j.equals("cell")) && (!q.b()))
      {
        l.a.b("Skipping asset download due to CACHE_FILTER_CELL.");
        return;
      }
      while ((this.f < 3) && (this.g.size() > 0))
      {
        String str = (String)this.g.remove(0);
        a locala = (a)this.c.get(str);
        if ((locala != null) && ((str == null) || (str.equals(""))))
        {
          l.d.b("[ADC ERROR] - NULL URL");
          new RuntimeException().printStackTrace();
        }
        if ((locala != null) && (str != null) && (!str.equals("")))
        {
          a.z = true;
          this.f += 1;
          new ADCDownload(this.a, str, this, locala.b).a(locala).b();
        }
      }
    }
  }
  
  void g()
  {
    double d1 = this.a.b.i.g;
    if (d1 == 0.0D) {}
    label21:
    while (this.j <= this.a.b.i.g)
    {
      return;
      l.b.a("Deleting ").b(((a)localObject1).b);
      ((a)localObject1).e = false;
      new File(((a)localObject1).b).delete();
      ((a)localObject1).b = null;
      this.j -= ((a)localObject1).g;
      l.b.a("Media pool now at ").a(this.j / 1048576.0D).a("/").a(d1 / 1048576.0D).b(" MB");
      this.i = true;
      this.e.a(2.0D);
    }
    int k = 0;
    Object localObject1 = null;
    label163:
    a locala;
    if (k < this.b.size())
    {
      locala = (a)this.b.get(k);
      if (!locala.e) {
        break label247;
      }
      localObject2 = locala;
      if (localObject1 != null) {
        if (locala.h >= ((a)localObject1).h) {
          break label247;
        }
      }
    }
    label247:
    for (Object localObject2 = locala;; localObject2 = localObject1)
    {
      k += 1;
      localObject1 = localObject2;
      break label163;
      if (localObject1 == null) {
        break;
      }
      if (((a)localObject1).b != null) {
        break label21;
      }
      return;
    }
  }
  
  int h()
  {
    this.i = true;
    this.e.a(2.0D);
    int k = this.d;
    this.d = (k + 1);
    return k;
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    a locala = (a)paramADCDownload.e;
    this.f -= 1;
    this.i = true;
    this.e.a(2.0D);
    locala.e = paramADCDownload.i;
    locala.d = false;
    if (paramADCDownload.i)
    {
      locala.g = paramADCDownload.o;
      this.j += locala.g;
      l.a.a("Downloaded ").b(locala.a);
    }
    paramADCDownload.c();
    a.h();
    f();
  }
  
  static class a
  {
    String a;
    String b;
    String c;
    boolean d;
    boolean e;
    int f;
    int g;
    double h;
    long i;
    long j;
    String k = g.j();
    String l = q.d();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */