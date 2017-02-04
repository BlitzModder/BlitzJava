package com.jirbo.adcolony;

import android.app.Activity;
import android.os.StatFs;
import java.io.File;

public class ADCStorage
{
  d a;
  String b;
  String c;
  String d;
  File e;
  File f;
  
  ADCStorage(d paramd)
  {
    this.a = paramd;
  }
  
  double a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getBlockSize();
      int i = paramString.getAvailableBlocks();
      return i * l;
    }
    catch (RuntimeException paramString) {}
    return 0.0D;
  }
  
  void a()
  {
    l.a.b("Configuring storage");
    l.b.b("Using internal storage:");
    this.b = (c() + "/adc/");
    this.c = (this.b + "media/");
    l.a.b(this.c);
    this.e = new File(this.c);
    if (!this.e.isDirectory())
    {
      this.e.delete();
      this.e.mkdirs();
    }
    if (!this.e.isDirectory())
    {
      a.a("Cannot create media folder.");
      return;
    }
    if (a(this.c) < 2.097152E7D)
    {
      a.a("Not enough space to store temporary files (" + a(this.c) + " bytes available).");
      return;
    }
    this.d = (c() + "/adc/data/");
    if (a.n == 0) {
      this.d = (this.b + "data/");
    }
    l.a.a("Internal data path: ").b(this.d);
    this.f = new File(this.d);
    if (!this.f.isDirectory()) {
      this.f.delete();
    }
    this.f.mkdirs();
    f localf = new f("iap_cache.txt");
    localf.c();
    k.a(localf, a.aj);
  }
  
  void b()
  {
    if ((this.e == null) || (this.f == null)) {
      return;
    }
    if (!this.e.isDirectory()) {
      this.e.delete();
    }
    if (!this.f.isDirectory()) {
      this.f.delete();
    }
    this.e.mkdirs();
    this.f.mkdirs();
  }
  
  String c()
  {
    if (a.P == null) {
      return "";
    }
    return AdColony.activity().getFilesDir().getAbsolutePath();
  }
  
  String d()
  {
    if (a.P == null) {
      return "";
    }
    return AdColony.activity().getExternalFilesDir(null).getAbsolutePath();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ADCStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */