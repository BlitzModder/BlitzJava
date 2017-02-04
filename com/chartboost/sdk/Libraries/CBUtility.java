package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.chartboost.sdk.Chartboost.CBFramework;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class CBUtility
{
  private static Handler a;
  
  public static float a(float paramFloat, Context paramContext)
  {
    return a(paramContext) * paramFloat;
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int a(int paramInt, Context paramContext)
  {
    return Math.round(paramInt * a(paramContext));
  }
  
  public static SharedPreferences a()
  {
    if (c.y() == null)
    {
      CBLogging.b("CBUtility", "The context must be set through the Chartboost method onCreate() before modifying or accessing preferences.");
      return null;
    }
    return c.y().getSharedPreferences("cbPrefs", 0);
  }
  
  public static String a(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramMap.keySet().isEmpty()) {
      localStringBuilder.append("?");
    }
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append("&");
      }
      String str2 = paramMap.get(str1).toString();
      if (str1 != null) {}
      for (;;)
      {
        try
        {
          str1 = URLEncoder.encode(str1, "UTF-8");
          localStringBuilder.append(str1);
          localStringBuilder.append("=");
          if (str2 == null) {
            break label157;
          }
          str1 = URLEncoder.encode(str2, "UTF-8");
          localStringBuilder.append(str1);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          CBLogging.b("CBUtility", "This method requires UTF-8 encoding support", paramMap);
          return null;
        }
        str1 = "";
        continue;
        label157:
        str1 = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (!c.c)) {
      if ((paramActivity.getWindow().getAttributes().flags & 0x400) != 0) {
        CBLogging.d("CBUtility", "Attempting to show Status and Navigation bars on a fullscreen activity. Please change your Chartboost activity theme to: \"@android:style/Theme.Translucent\"` in your Manifest file");
      }
    }
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
  }
  
  public static void a(Activity paramActivity, a.b paramb)
  {
    if (paramActivity == null) {}
    while (((paramb != a.b.b) || (!c.H().booleanValue()) || (!c.M())) && ((paramb != a.b.a) || (!c.N()) || (!c.S()))) {
      return;
    }
    paramb = c();
    if (paramb == f.a)
    {
      paramActivity.setRequestedOrientation(1);
      return;
    }
    if (paramb == f.c)
    {
      paramActivity.setRequestedOrientation(9);
      return;
    }
    if (paramb == f.b)
    {
      paramActivity.setRequestedOrientation(0);
      return;
    }
    paramActivity.setRequestedOrientation(8);
  }
  
  public static void a(Handler paramHandler)
  {
    a = paramHandler;
  }
  
  public static boolean a(Chartboost.CBFramework paramCBFramework)
  {
    return (c.b() != null) && (c.b() == paramCBFramework);
  }
  
  public static void b(Activity paramActivity, a.b paramb)
  {
    if (paramActivity == null) {}
    while (((paramb != a.b.b) || (!c.H().booleanValue()) || (!c.M())) && ((paramb != a.b.a) || (!c.N()) || (!c.S()))) {
      return;
    }
    paramActivity.setRequestedOrientation(-1);
  }
  
  public static boolean b()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static f c()
  {
    Context localContext = c.y();
    Display localDisplay = ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay();
    int j = localContext.getResources().getConfiguration().orientation;
    int k = localDisplay.getRotation();
    int i;
    if (localDisplay.getWidth() == localDisplay.getHeight())
    {
      i = 3;
      if (i != 1) {
        break label131;
      }
      i = 1;
    }
    for (;;)
    {
      label59:
      j = i;
      if (k != 0)
      {
        if (k != 2) {
          break label166;
        }
        j = i;
      }
      for (;;)
      {
        if (j != 0) {
          switch (k)
          {
          default: 
            return f.a;
            if (localDisplay.getWidth() < localDisplay.getHeight())
            {
              i = 1;
              break;
            }
            i = 2;
            break;
            if (i == 2)
            {
              i = 0;
              break label59;
            }
            if (i != 3) {
              break label236;
            }
            if (j == 1)
            {
              i = 1;
              break label59;
            }
            if (j != 2) {
              break label236;
            }
            i = 0;
            break label59;
            if (i == 0) {
              j = 1;
            } else {
              j = 0;
            }
            break;
          case 1: 
            return f.g;
          case 2: 
            return f.c;
          case 3: 
            label131:
            label166:
            return f.h;
          }
        }
      }
      switch (k)
      {
      default: 
        return f.b;
      case 1: 
        return f.e;
      case 2: 
        return f.d;
      }
      return f.f;
      label236:
      i = 1;
    }
  }
  
  public static String d()
  {
    if (c.b() == null) {}
    for (Object localObject = "";; localObject = c.b()) {
      return String.format("%s %s %s", new Object[] { "Chartboost-Android-SDK", localObject, "6.4.1" });
    }
  }
  
  public static Handler e()
  {
    if (a == null) {
      a = new Handler(Looper.getMainLooper());
    }
    return a;
  }
  
  public static boolean f()
  {
    return (h()) || (i()) || (j());
  }
  
  public static String g()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("ZZZZ", Locale.US);; localSimpleDateFormat = new SimpleDateFormat("'GMT'ZZZZ", Locale.US))
    {
      localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
      return localSimpleDateFormat.format(new Date());
    }
  }
  
  private static boolean h()
  {
    String str = Build.TAGS;
    return (str != null) && (str.contains("test-keys"));
  }
  
  private static boolean i()
  {
    return new File("/system/app/Superuser.apk").exists();
  }
  
  private static boolean j()
  {
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "/sbin/su";
    arrayOfString[1] = "/system/bin/su";
    arrayOfString[2] = "/system/xbin/su";
    arrayOfString[3] = "/data/local/xbin/su";
    arrayOfString[4] = "/data/local/bin/su";
    arrayOfString[5] = "/system/sd/xbin/su";
    arrayOfString[6] = "/system/bin/failsafe/su";
    arrayOfString[7] = "/data/local/su";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (new File(arrayOfString[i]).exists()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void throwProguardError(Exception paramException)
  {
    if ((paramException instanceof NoSuchMethodException))
    {
      CBLogging.b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
      return;
    }
    if ((paramException != null) && (paramException.getMessage() != null))
    {
      CBLogging.b("CBUtility", paramException.getMessage());
      return;
    }
    CBLogging.b("CBUtility", "Unknown Proguard error");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/CBUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */