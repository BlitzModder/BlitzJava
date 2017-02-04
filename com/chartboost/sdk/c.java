package com.chartboost.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.l.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class c
{
  private static float A;
  private static boolean B;
  private static boolean C;
  private static boolean D;
  private static boolean E;
  private static boolean F;
  private static boolean G;
  protected static boolean a;
  public static d.a b;
  public static boolean c;
  public static boolean d;
  private static final String e = c.class.getSimpleName();
  private static String f;
  private static String g;
  private static a h;
  private static boolean i;
  private static boolean j;
  private static Chartboost.CBFramework k;
  private static String l;
  private static String m;
  private static String n;
  private static Chartboost.CBMediation o;
  private static String p;
  private static String q;
  private static SharedPreferences r;
  private static boolean s;
  private static volatile boolean t;
  private static Context u;
  private static Application v;
  private static boolean w;
  private static boolean x;
  private static boolean y;
  private static boolean z;
  
  static
  {
    a = true;
    i = false;
    j = false;
    k = null;
    l = null;
    m = null;
    n = null;
    o = null;
    p = null;
    q = null;
    r = null;
    s = true;
    t = false;
    u = null;
    v = null;
    w = false;
    x = true;
    y = false;
    z = true;
    A = 250.0F;
    c = true;
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      B = false;
      C = true;
      D = true;
      E = true;
      F = true;
      G = true;
      return;
    }
  }
  
  public static String A()
  {
    if (H().booleanValue()) {
      return String.format("%s/%s%s", new Object[] { "webview", D(), "/interstitial/get" });
    }
    return "/interstitial/get";
  }
  
  public static String B()
  {
    if (H().booleanValue()) {
      return String.format("%s/%s%s", new Object[] { "webview", D(), "/reward/get" });
    }
    return "/reward/get";
  }
  
  public static String C()
  {
    if (H().booleanValue()) {
      return String.format("%s/%s/%s", new Object[] { "webview", D(), "prefetch" });
    }
    return "/api/video-prefetch";
  }
  
  public static String D()
  {
    Object localObject = X().getString("webview", "v2");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (!((e.a)localObject).a("version").b())) {
        return ((e.a)localObject).e("version");
      }
    }
    return "v2";
  }
  
  public static int E()
  {
    Float localFloat = e("cacheTTLs");
    if (localFloat != null) {
      return (int)TimeUnit.SECONDS.toDays(localFloat.longValue());
    }
    return 7;
  }
  
  public static int F()
  {
    Float localFloat = e("cacheMaxUnits");
    if ((localFloat != null) && (localFloat.floatValue() > 0.0F)) {
      return localFloat.intValue();
    }
    return 10;
  }
  
  public static int G()
  {
    Float localFloat = e("cacheMaxBytes");
    if (localFloat != null) {
      return localFloat.intValue();
    }
    return 104857600;
  }
  
  public static Boolean H()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("enabled").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return Boolean.valueOf(((e.a)localObject).j("enabled"));
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static boolean I()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("interstitialEnabled").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return ((e.a)localObject).j("interstitialEnabled");
      }
    }
    return true;
  }
  
  public static boolean J()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("rewardVideoEnabled").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return ((e.a)localObject).j("rewardVideoEnabled");
      }
    }
    return true;
  }
  
  public static boolean K()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("moreAppsEnabled").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return ((e.a)localObject).j("moreAppsEnabled");
      }
    }
    return true;
  }
  
  public static boolean L()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("inplayEnabled").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return ((e.a)localObject).j("inplayEnabled");
      }
    }
    return true;
  }
  
  public static boolean M()
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("lockOrientation").c()) && (Build.VERSION.SDK_INT >= 14)) {
        return ((e.a)localObject).j("lockOrientation");
      }
    }
    return true;
  }
  
  public static boolean N()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("enabled").c())) {
        return ((e.a)localObject).j("enabled");
      }
    }
    return true;
  }
  
  public static boolean O()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("interstitialEnabled").c())) {
        return ((e.a)localObject).j("interstitialEnabled");
      }
    }
    return true;
  }
  
  public static boolean P()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("rewardVideoEnabled").c())) {
        return ((e.a)localObject).j("rewardVideoEnabled");
      }
    }
    return true;
  }
  
  public static boolean Q()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("moreAppsEnabled").c())) {
        return ((e.a)localObject).j("moreAppsEnabled");
      }
    }
    return true;
  }
  
  public static boolean R()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("inplayEnabled").c())) {
        return ((e.a)localObject).j("inplayEnabled");
      }
    }
    return true;
  }
  
  public static boolean S()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("lockOrientation").c())) {
        return ((e.a)localObject).j("lockOrientation");
      }
    }
    return false;
  }
  
  public static Boolean T()
  {
    return Boolean.valueOf(X().getBoolean("publisherDisable", false));
  }
  
  public static int U()
  {
    Float localFloat = e("prefetchSession");
    if ((localFloat != null) && (localFloat.floatValue() > 0.0F)) {
      return localFloat.intValue();
    }
    return 3;
  }
  
  public static int V()
  {
    Object localObject = X().getString("native", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (((e.a)localObject).a("prefetchSession").c())) {
        return ((e.a)localObject).f("prefetchSession");
      }
    }
    return 3;
  }
  
  private static SharedPreferences X()
  {
    if (r == null) {
      r = CBUtility.a();
    }
    return r;
  }
  
  public static void a(Application paramApplication)
  {
    v = paramApplication;
  }
  
  public static void a(Context paramContext)
  {
    u = paramContext;
  }
  
  public static void a(Chartboost.CBFramework paramCBFramework)
  {
    if (paramCBFramework == null)
    {
      CBLogging.b(e, "Pass a valid CBFramework enum value");
      return;
    }
    k = paramCBFramework;
  }
  
  public static void a(Chartboost.CBFramework paramCBFramework, String paramString)
  {
    if (!t()) {
      return;
    }
    a(paramCBFramework);
    l = paramString;
  }
  
  public static void a(Chartboost.CBMediation paramCBMediation, String paramString)
  {
    o = paramCBMediation;
    p = paramString;
    n = o + " " + p;
  }
  
  public static void a(CBLogging.Level paramLevel)
  {
    if (!t()) {
      return;
    }
    CBLogging.a = paramLevel;
  }
  
  public static void a(e.a parama)
  {
    SharedPreferences.Editor localEditor;
    for (;;)
    {
      String str;
      Object localObject;
      try
      {
        if (parama.c())
        {
          parama = parama.f();
          if (parama != null)
          {
            localEditor = X().edit();
            Iterator localIterator = parama.keySet().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = parama.get(str);
            if (!(localObject instanceof String)) {
              break label95;
            }
            localEditor.putString(str, (String)localObject);
            continue;
          }
        }
        return;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
      label95:
      if ((localObject instanceof Integer)) {
        localEditor.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Float)) {
        localEditor.putFloat(str, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Long)) {
        localEditor.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Boolean)) {
        localEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if (localObject != null) {
        localEditor.putString(str, e.a.a((HashMap)localObject).toString());
      }
    }
    localEditor.commit();
  }
  
  public static void a(a parama)
  {
    if (!t()) {
      return;
    }
    h = parama;
  }
  
  public static void a(a parama)
  {
    Chartboost.a = true;
    ay localay = new ay("/api/config");
    localay.a(false);
    localay.b(false);
    localay.a(l.a.c);
    localay.a(g.a(new g.k[] { g.a("status", com.chartboost.sdk.Libraries.a.a) }));
    localay.a(new ay.c()
    {
      public void a(e.a paramAnonymousa, ay paramAnonymousay)
      {
        Chartboost.a = false;
        if (paramAnonymousa.c())
        {
          paramAnonymousa = paramAnonymousa.a("response");
          if (paramAnonymousa.c()) {
            c.a(paramAnonymousa);
          }
        }
        if (this.a != null) {
          this.a.a();
        }
        if (!Chartboost.b)
        {
          if (c.W() != null) {
            c.W().didInitialize();
          }
          Chartboost.b = true;
        }
      }
      
      public void a(e.a paramAnonymousa, ay paramAnonymousay, CBError paramAnonymousCBError)
      {
        Chartboost.a = false;
        if (this.a != null) {
          this.a.a();
        }
        if (!Chartboost.b)
        {
          if (c.W() != null) {
            c.W().didInitialize();
          }
          Chartboost.b = true;
        }
      }
    });
  }
  
  public static void a(Boolean paramBoolean)
  {
    c = paramBoolean.booleanValue();
  }
  
  public static void a(String paramString)
  {
    if (k == null)
    {
      CBLogging.b(e, "Set a valid CBFramework first");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      CBLogging.b(e, "Invalid Version String");
      return;
    }
    m = paramString;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!t()) {
      return;
    }
    s = paramBoolean;
  }
  
  public static boolean a()
  {
    return C;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      try
      {
        throw new Exception("Invalid activity context: Host Activity object is null, Please send a valid activity object");
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public static Chartboost.CBFramework b()
  {
    t();
    if (k == null) {
      return null;
    }
    return k;
  }
  
  public static void b(String paramString)
  {
    f = paramString;
    X().edit().putString("appId", paramString).commit();
  }
  
  protected static void b(boolean paramBoolean)
  {
    t = paramBoolean;
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {
      try
      {
        throw new RuntimeException("Invalid activity context passed during intitalization");
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
    }
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    if (d)
    {
      i5 = paramActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
      i4 = paramActivity.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
      i3 = paramActivity.checkSelfPermission("android.permission.INTERNET");
      i2 = paramActivity.checkSelfPermission("android.permission.READ_PHONE_STATE");
      i1 = paramActivity.checkSelfPermission("android.permission.ACCESS_WIFI_STATE");
      if (i5 == 0) {
        break label143;
      }
    }
    label143:
    for (C = true;; C = false)
    {
      if (i3 == 0) {
        break label150;
      }
      D = true;
      throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
      i5 = paramActivity.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
      i4 = paramActivity.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
      i3 = paramActivity.checkCallingOrSelfPermission("android.permission.INTERNET");
      i2 = paramActivity.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
      i1 = paramActivity.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE");
      break;
    }
    label150:
    D = false;
    if (i4 != 0)
    {
      E = true;
      throw new RuntimeException("Please add the permission :  android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
    }
    E = false;
    if (i2 == 0) {}
    for (F = false; i1 == 0; F = true)
    {
      G = false;
      return true;
    }
    G = true;
    return true;
  }
  
  public static String c()
  {
    if (k != null) {
      return String.format("%s %s", new Object[] { k, l });
    }
    return "";
  }
  
  public static void c(String paramString)
  {
    g = paramString;
    X().edit().putString("appSignature", paramString).commit();
  }
  
  public static void c(boolean paramBoolean)
  {
    if (b != null) {
      b.a(paramBoolean);
    }
  }
  
  public static boolean c(Activity paramActivity)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(paramActivity, CBImpressionActivity.class);
        if (paramActivity.getPackageManager().queryIntentActivities(localIntent, 65536).size() <= 0) {
          break label63;
        }
        B = true;
        if (!B) {
          throw new RuntimeException("Please add             <activity android:name=\"com.chartboost.sdk.CBImpressionActivity\"\n                  android:excludeFromRecents=\"true\"\n                  android:theme=\"@android:style/Theme.Translucent.NoTitleBar.Fullscreen\"\n                  android:configChanges=\"keyboardHidden|orientation|screenSize\"/> in your android manifest.xml");
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        bool = false;
      }
      return bool;
      label63:
      B = false;
    }
  }
  
  public static String d()
  {
    t();
    return m;
  }
  
  public static void d(String paramString)
  {
    q = paramString;
  }
  
  protected static void d(boolean paramBoolean)
  {
    if (!t()) {
      return;
    }
    w = paramBoolean;
  }
  
  private static Float e(String paramString)
  {
    Object localObject = X().getString("webview", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.a.k((String)localObject);
      if ((((e.a)localObject).c()) && (!((e.a)localObject).a(paramString).b())) {
        return Float.valueOf(((e.a)localObject).g(paramString));
      }
    }
    return null;
  }
  
  public static String e()
  {
    t();
    return n;
  }
  
  public static void e(boolean paramBoolean)
  {
    if (!t()) {
      return;
    }
    x = paramBoolean;
  }
  
  public static String f()
  {
    if (!t()) {
      return "";
    }
    f = X().getString("appId", f);
    return f;
  }
  
  public static void f(boolean paramBoolean)
  {
    if (!t()) {
      return;
    }
    y = paramBoolean;
  }
  
  public static String g()
  {
    if (!t()) {
      return "";
    }
    g = X().getString("appSignature", g);
    return g;
  }
  
  public static void g(boolean paramBoolean)
  {
    if (!t()) {
      return;
    }
    z = paramBoolean;
  }
  
  public static a h()
  {
    if (!t()) {
      return null;
    }
    return h;
  }
  
  public static boolean i()
  {
    return (b() == null) && (a);
  }
  
  public static boolean j()
  {
    if (!t()) {
      return false;
    }
    return j;
  }
  
  public static boolean k()
  {
    return s;
  }
  
  public static List<String> l()
  {
    Object localObject = X().getString("webview", "");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = e.a.k((String)localObject);
        if ((((e.a)localObject).c()) && (!TextUtils.isEmpty(((e.a)localObject).e("directories"))))
        {
          localObject = ((e.a)localObject).a("directories").h();
          return (List<String>)localObject;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject m()
  {
    if (!t()) {}
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = X().getString("trackingLevels", "");
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = e.a.k((String)localObject);
    } while (!((e.a)localObject).c());
    return ((e.a)localObject).e();
  }
  
  public static boolean n()
  {
    t();
    return X().getBoolean("retriesEnabled", true);
  }
  
  public static CBLogging.Level o()
  {
    t();
    return CBLogging.a;
  }
  
  public static String p()
  {
    if (!t()) {
      return "";
    }
    return q;
  }
  
  public static boolean q()
  {
    return t;
  }
  
  public static boolean r()
  {
    return (t()) && (s());
  }
  
  public static boolean s()
  {
    if (Chartboost.d == null) {
      try
      {
        throw new Exception("Chartboost Weak Activity reference is null");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public static boolean t()
  {
    try
    {
      if (z() == null) {
        throw new Exception("SDK Initialization error. Activity context seems to be not initialized properly, host activity or application context is being sent as null");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    if (TextUtils.isEmpty(f)) {
      throw new Exception("SDK Initialization error. AppId is missing");
    }
    if (TextUtils.isEmpty(g)) {
      throw new Exception("SDK Initialization error. AppSignature is missing");
    }
    return true;
  }
  
  public static boolean u()
  {
    return w;
  }
  
  public static boolean v()
  {
    return x;
  }
  
  public static boolean w()
  {
    return y;
  }
  
  public static boolean x()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (z)
    {
      bool1 = bool2;
      if (!X().getBoolean("prefetchDisable", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Context y()
  {
    return u;
  }
  
  public static Application z()
  {
    return v;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */