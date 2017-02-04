package com.jirbo.adcolony;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

class g
{
  static String a;
  static boolean b;
  
  static String a()
  {
    if (a.P == null) {
      return "";
    }
    return Settings.Secure.getString(AdColony.activity().getContentResolver(), "android_id");
  }
  
  static String b()
  {
    Object localObject;
    if (a.P == null) {
      localObject = "";
    }
    String str;
    do
    {
      return (String)localObject;
      str = ((TelephonyManager)AdColony.activity().getSystemService("phone")).getNetworkOperatorName();
      localObject = str;
    } while (str.length() != 0);
    return "unknown";
  }
  
  static int c()
  {
    if (a.P == null) {
      return 0;
    }
    Context localContext = a.b().getApplicationContext();
    a.b();
    return ((ActivityManager)localContext.getSystemService("activity")).getMemoryClass();
  }
  
  static long d()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1048576;
  }
  
  static String e()
  {
    if (a.P == null) {
      return "";
    }
    return ai.a(a.b());
  }
  
  static int f()
  {
    if (a.P == null) {
      return 0;
    }
    return a.b().getResources().getDisplayMetrics().widthPixels;
  }
  
  static int g()
  {
    if (a.P == null) {
      return 0;
    }
    return a.b().getResources().getDisplayMetrics().heightPixels;
  }
  
  static String h()
  {
    return "";
  }
  
  static boolean i()
  {
    boolean bool = true;
    if (a.P == null) {
      bool = false;
    }
    float f1;
    float f2;
    do
    {
      do
      {
        return bool;
        if (a.ah == null) {
          break;
        }
      } while (a.ah.equals("tablet"));
      return false;
      DisplayMetrics localDisplayMetrics = AdColony.activity().getResources().getDisplayMetrics();
      f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
      f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
    } while (Math.sqrt(f2 * f2 + f1 * f1) >= 6.0D);
    return false;
  }
  
  static String j()
  {
    return Locale.getDefault().getLanguage();
  }
  
  static String k()
  {
    if (a.P == null) {
      return "";
    }
    try
    {
      String str = ((WifiManager)AdColony.activity().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return str;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
  
  static String l()
  {
    return Build.MANUFACTURER;
  }
  
  static String m()
  {
    return Build.MODEL;
  }
  
  static String n()
  {
    return "";
  }
  
  static String o()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */