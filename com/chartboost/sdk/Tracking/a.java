package com.chartboost.sdk.Tracking;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.b;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.l.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  implements com.chartboost.sdk.Libraries.a
{
  private static final String b = a.class.getSimpleName();
  private static a i;
  private String c;
  private JSONArray d = new JSONArray();
  private long e;
  private long f;
  private long g = System.currentTimeMillis();
  private h h = new h(false);
  
  public static a a()
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new a();
      }
      return i;
    }
    finally {}
  }
  
  private static Object a(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    return "";
  }
  
  public static void a(String paramString)
  {
    i.a("session", paramString, null, null, null, null, "session", false);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a locala = i;
    if (com.chartboost.sdk.c.H().booleanValue()) {}
    for (String str = "web";; str = "native")
    {
      locala.a("asset-prefetcher", "start", str, paramString1, paramString2, null, null, "system", false);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    i.a("ad-show", paramString1, paramString2, paramString3, null, null, "system", false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, CBError.CBImpressionError paramCBImpressionError)
  {
    a locala = i;
    if (TextUtils.isEmpty(paramString3))
    {
      paramString3 = "empty-adid";
      if (paramCBImpressionError == null) {
        break label43;
      }
    }
    label43:
    for (paramCBImpressionError = paramCBImpressionError.toString();; paramCBImpressionError = "")
    {
      locala.a("ad-error", paramString1, paramString2, paramString3, paramCBImpressionError, null, "system", false);
      return;
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    i.a("webview-track", paramString1, paramString2, paramString3, paramString4, null, null, "system", false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, JSONObject paramJSONObject)
  {
    i.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramJSONObject, "system", false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a locala = i;
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "empty-adid";
    }
    for (;;)
    {
      locala.a("ad-error", paramString1, paramString2, paramString3, paramString4, null, "system", paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a locala = i;
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "empty-adid";
    }
    for (;;)
    {
      locala.a("ad-get", paramString1, paramString2, paramString3, b(paramBoolean), "single", null, "system", false);
      return;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    a locala = i;
    if (com.chartboost.sdk.c.H().booleanValue()) {}
    for (String str = "web";; str = "native")
    {
      locala.a("folder", str, null, null, null, null, paramJSONObject, "system", false);
      return;
    }
  }
  
  public static String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "1";
    }
    return "0";
  }
  
  public static void b()
  {
    a("start");
    a("did-become-active");
  }
  
  public static void b(String paramString1, String paramString2)
  {
    i.a("playback-complete", paramString1, paramString2, null, null, null, "system", false);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    i.a("ad-click", paramString1, paramString2, paramString3, null, null, "system", false);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a locala = i;
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "empty-adid";
    }
    for (;;)
    {
      locala.a("ad-warning", paramString1, paramString2, paramString3, paramString4, null, "system", false);
      return;
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    i.a("replay", paramString1, paramString2, null, null, null, "system", false);
  }
  
  public static void c(String paramString1, String paramString2, String paramString3)
  {
    i.a("ad-close", paramString1, paramString2, paramString3, null, null, "system", false);
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a locala = i;
    if (com.chartboost.sdk.c.H().booleanValue()) {}
    for (paramString3 = "web";; paramString3 = "native")
    {
      locala.a("asset-prefetcher", "failure", paramString3, paramString1, paramString2, paramString4, null, "system", false);
      return;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    i.a("playback-start", paramString1, paramString2, null, null, null, "system", false);
  }
  
  public static void d(String paramString1, String paramString2, String paramString3)
  {
    i.a("ad-dismiss", paramString1, paramString2, paramString3, null, null, "system", false);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    i.a("playback-stop", paramString1, paramString2, null, null, null, "system", false);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3)
  {
    a locala = i;
    if (com.chartboost.sdk.c.H().booleanValue()) {}
    for (String str = "web";; str = "native")
    {
      locala.a("asset-prefetcher", "success", str, paramString1, paramString2, paramString3, null, "system", false);
      return;
    }
  }
  
  public ay a(e.a parama)
  {
    ay localay = new ay("/api/track");
    localay.a("track", parama);
    localay.a(g.a(new g.k[] { g.a("status", com.chartboost.sdk.Libraries.a.a) }));
    localay.a(l.a.a);
    return localay;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    e.a locala = e.a.a();
    locala.a("start_timestamp", Long.valueOf(paramLong1));
    locala.a("timestamp", Long.valueOf(paramLong2));
    locala.a("session_id", this.c);
    this.h.a(this.h.h(), "cb_previous_session_info", locala);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    i.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, new JSONObject(), paramString7, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, JSONObject paramJSONObject, String paramString7, boolean paramBoolean)
  {
    JSONObject localJSONObject = com.chartboost.sdk.c.m();
    e.a locala = e.a.a();
    if ((localJSONObject != null) && (localJSONObject.optBoolean(paramString7)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.e;
      long l3 = this.g;
      locala.a("event", a(paramString1));
      locala.a("kingdom", a(paramString2));
      locala.a("phylum", a(paramString3));
      locala.a("class", a(paramString4));
      locala.a("family", a(paramString5));
      locala.a("genus", a(paramString6));
      paramString2 = paramJSONObject;
      if (paramJSONObject == null) {
        paramString2 = new JSONObject();
      }
      locala.a("meta", paramString2);
      locala.a("clientTimestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
      locala.a("session_id", i());
      locala.a("totalSessionTime", Long.valueOf((l1 - l2) / 1000L));
      locala.a("currentSessionTime", Long.valueOf((l1 - l3) / 1000L));
      try
      {
        this.d.put(locala.e());
        paramString2 = e.a.a();
        paramString2.a("events", this.d);
        CBLogging.a(b, "###Writing" + a(paramString1) + "to tracking cache dir");
        h();
        if ((paramBoolean) || (d()))
        {
          i.a(e.a.a(paramString2)).t();
          l();
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    e.a locala = e.a.a();
    locala.a("complete", Boolean.valueOf(paramBoolean));
    i.a("session", "end", null, null, null, null, locala.e(), "session", false);
    a("did-become-active");
  }
  
  public void c()
  {
    a(false);
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.d != null)
    {
      bool1 = bool2;
      if (this.d.length() >= 50) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String e()
  {
    e.a locala = e.a.a();
    locala.a("startTime", Long.valueOf(System.currentTimeMillis()));
    locala.a("deviceID", com.chartboost.sdk.Libraries.c.e());
    this.c = b.b(locala.toString().getBytes());
    return this.c;
  }
  
  public void f()
  {
    e.a locala = this.h.a(this.h.h(), "cb_previous_session_info");
    if (locala != null)
    {
      this.f = locala.i("timestamp");
      this.e = locala.i("start_timestamp");
      this.c = locala.e("session_id");
      if (System.currentTimeMillis() - this.f <= 180000L)
      {
        if (!TextUtils.isEmpty(this.c)) {
          h();
        }
      }
      else {
        a(true);
      }
    }
    g();
  }
  
  public void g()
  {
    long l = System.currentTimeMillis();
    this.e = l;
    this.f = l;
    this.c = e();
    a(l, l);
    Object localObject = CBUtility.a();
    int j = ((SharedPreferences)localObject).getInt("cbPrefSessionCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("cbPrefSessionCount", j + 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void h()
  {
    long l = System.currentTimeMillis();
    a(this.e, l);
  }
  
  public String i()
  {
    return this.c;
  }
  
  public JSONArray j()
  {
    return this.d;
  }
  
  public long k()
  {
    return this.e;
  }
  
  public void l()
  {
    this.d = new JSONArray();
  }
  
  public String toString()
  {
    return "Session [ startTime: " + k() + " sessionEvents: " + j() + " ]";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Tracking/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */