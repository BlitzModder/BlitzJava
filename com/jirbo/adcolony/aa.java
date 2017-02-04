package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

class aa
{
  static byte[] a = new byte['Ѐ'];
  static StringBuilder b = new StringBuilder();
  
  static String a()
  {
    if (a.P == null) {
      return "1.0";
    }
    try
    {
      String str = AdColony.activity().getPackageManager().getPackageInfo(AdColony.activity().getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      a.e("Failed to retrieve package info.");
    }
    return "1.0";
  }
  
  static String a(double paramDouble, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramDouble, paramInt, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        l.a.a("Loading ").b(paramString1);
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        synchronized (a)
        {
          b.setLength(0);
          b.append(paramString2);
          i = localFileInputStream.read(a, 0, a.length);
          break label152;
          if (j < i)
          {
            b.append((char)a[j]);
            j += 1;
            continue;
          }
          i = localFileInputStream.read(a, 0, a.length);
          break label152;
          localFileInputStream.close();
          paramString2 = b.toString();
          return paramString2;
        }
        return "";
      }
      catch (IOException paramString2)
      {
        l.d.a("Unable to load ").b(paramString1);
        return "";
      }
      label152:
      if (i != -1) {
        j = 0;
      }
    }
  }
  
  static void a(double paramDouble, int paramInt, StringBuilder paramStringBuilder)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      paramStringBuilder.append(paramDouble);
    }
    long l2;
    long l3;
    for (;;)
    {
      return;
      double d = paramDouble;
      if (paramDouble < 0.0D)
      {
        d = -paramDouble;
        paramStringBuilder.append('-');
      }
      if (paramInt == 0)
      {
        paramStringBuilder.append(Math.round(d));
        return;
      }
      l2 = Math.pow(10.0D, paramInt);
      l1 = Math.round(l2 * d);
      paramStringBuilder.append(l1 / l2);
      paramStringBuilder.append('.');
      l3 = l1 % l2;
      if (l3 != 0L) {
        break;
      }
      int i = 0;
      while (i < paramInt)
      {
        paramStringBuilder.append('0');
        i += 1;
      }
    }
    for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(l3);
  }
  
  static boolean a(String paramString)
  {
    if (a.P == null) {
      return false;
    }
    try
    {
      AdColony.activity().getApplication().getPackageManager().getApplicationInfo(paramString, 0);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static String b()
  {
    return UUID.randomUUID().toString();
  }
  
  static String b(String paramString)
  {
    try
    {
      paramString = ah.a(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static double c()
  {
    return System.currentTimeMillis() / 1000.0D;
  }
  
  static String c(String paramString)
  {
    return a(paramString, "");
  }
  
  static boolean d()
  {
    return new File(a.l.f.c() + "/../lib/libImmEndpointWarpJ.so").exists();
  }
  
  static boolean e()
  {
    if (a.P == null) {}
    while (a.b().checkCallingOrSelfPermission("android.permission.VIBRATE") != 0) {
      return false;
    }
    return true;
  }
  
  static String f()
  {
    if (a.P == null) {
      return "";
    }
    return a.b().getPackageName();
  }
  
  static class a
  {
    long a = System.currentTimeMillis();
    
    void a()
    {
      this.a = System.currentTimeMillis();
    }
    
    double b()
    {
      return (System.currentTimeMillis() - this.a) / 1000.0D;
    }
    
    public String toString()
    {
      return aa.a(b(), 2);
    }
  }
  
  static class b
  {
    double a = System.currentTimeMillis();
    
    b(double paramDouble)
    {
      a(paramDouble);
    }
    
    void a(double paramDouble)
    {
      this.a = (System.currentTimeMillis() / 1000.0D + paramDouble);
    }
    
    boolean a()
    {
      return b() == 0.0D;
    }
    
    double b()
    {
      double d = System.currentTimeMillis() / 1000.0D;
      d = this.a - d;
      if (d <= 0.0D) {
        return 0.0D;
      }
      return d;
    }
    
    public String toString()
    {
      return aa.a(b(), 2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */