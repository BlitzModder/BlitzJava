package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.b.e;
import com.chartboost.sdk.c;
import com.chartboost.sdk.e;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends e
{
  private static final String d = ad.class.getSimpleName();
  private static ad e;
  
  public static ad i()
  {
    if (e == null) {
      e = new ad();
    }
    return e;
  }
  
  protected com.chartboost.sdk.Model.a a(String paramString, boolean paramBoolean)
  {
    return new com.chartboost.sdk.Model.a(a.a.a, paramBoolean, paramString, false, g());
  }
  
  protected void a(com.chartboost.sdk.Model.a parama, com.chartboost.sdk.Libraries.e.a parama1)
  {
    if (parama.a == a.b.a)
    {
      if ((b(parama, parama1)) && (!com.chartboost.sdk.h.c(parama1)))
      {
        CBLogging.b(d, "Video Media unavailable for the cached impression");
        a(parama, CBError.CBImpressionError.VIDEO_UNAVAILABLE);
      }
    }
    else
    {
      parama.a(parama1);
      if ((parama1.c()) && (parama1.a("webview").c()))
      {
        Object localObject = parama1.a("webview").e("template");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          parama.i = ((String)localObject);
        }
        localObject = new JSONArray();
        ((JSONArray)localObject).put(parama1.a("webview"));
        parama1 = new JSONObject();
        try
        {
          parama1.put("templates", localObject);
          if (!parama.j)
          {
            com.chartboost.sdk.b.a.put(parama, b.e.b);
            com.chartboost.sdk.b.a(b.e.b, com.chartboost.sdk.Libraries.e.a.a(parama1));
            return;
          }
        }
        catch (JSONException parama1)
        {
          parama1.printStackTrace();
          CBLogging.b(d, "Error while trying to create a template object from the response");
          a(parama, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
          return;
        }
        com.chartboost.sdk.b.a.put(parama, b.e.c);
        com.chartboost.sdk.b.a(b.e.c, com.chartboost.sdk.Libraries.e.a.a(parama1));
        return;
      }
      CBLogging.b(d, "Response got from the server is empty");
      a(parama, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
      return;
    }
    super.a(parama, parama1);
  }
  
  protected boolean b(com.chartboost.sdk.Model.a parama, com.chartboost.sdk.Libraries.e.a parama1)
  {
    return (parama1.a("media-type") != null) && (parama1.a("media-type").equals("video"));
  }
  
  protected com.chartboost.sdk.e.a c()
  {
    new com.chartboost.sdk.e.a()
    {
      public void a(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didClickInterstitial(paramAnonymousa.e);
        }
      }
      
      public void a(com.chartboost.sdk.Model.a paramAnonymousa, CBError.CBImpressionError paramAnonymousCBImpressionError)
      {
        if (c.h() != null) {
          c.h().didFailToLoadInterstitial(paramAnonymousa.e, paramAnonymousCBImpressionError);
        }
      }
      
      public void b(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCloseInterstitial(paramAnonymousa.e);
        }
      }
      
      public void c(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didDismissInterstitial(paramAnonymousa.e);
        }
      }
      
      public void d(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCacheInterstitial(paramAnonymousa.e);
        }
      }
      
      public void e(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didDisplayInterstitial(paramAnonymousa.e);
        }
      }
      
      public boolean f(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.h().shouldDisplayInterstitial(paramAnonymousa.e);
        }
        return true;
      }
      
      public boolean g(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.h().shouldRequestInterstitial(paramAnonymousa.e);
        }
        return true;
      }
      
      public boolean h(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.v();
        }
        return true;
      }
    };
  }
  
  protected ay e(com.chartboost.sdk.Model.a parama)
  {
    if (!c.H().booleanValue())
    {
      parama.a = a.b.a;
      localObject = new ay(c.A());
      ((ay)localObject).a("local-videos", j());
      ((ay)localObject).a(l.a.c);
      ((ay)localObject).a(com.chartboost.sdk.Model.b.f);
      ((ay)localObject).a("location", parama.e);
      if (parama.j)
      {
        ((ay)localObject).a("cache", "1");
        ((ay)localObject).b(true);
      }
      return (ay)localObject;
    }
    parama.a = a.b.b;
    Object localObject = com.chartboost.sdk.b.c();
    bc localbc = new bc(c.A());
    localbc.a("cache_assets", localObject, bc.a.a);
    localbc.a(l.a.c);
    localbc.a("location", parama.e, bc.a.a);
    if (parama.j)
    {
      localbc.a("cache", Boolean.valueOf(true), bc.a.a);
      localbc.b(true);
    }
    for (;;)
    {
      localbc.a(com.chartboost.sdk.Model.b.f);
      return localbc;
      localbc.a("cache", Boolean.valueOf(false), bc.a.a);
    }
  }
  
  public String f()
  {
    return String.format("%s-%s", new Object[] { "interstitial", h() });
  }
  
  protected void g(com.chartboost.sdk.Model.a parama)
  {
    super.g(parama);
  }
  
  protected void i(com.chartboost.sdk.Model.a parama)
  {
    if ((parama.f == a.c.b) || (parama.a == a.b.b)) {
      return;
    }
    super.i(parama);
  }
  
  public JSONArray j()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = com.chartboost.sdk.Libraries.h.c();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!str.contains("nomedia")) {
          localJSONArray.put(str);
        }
        i += 1;
      }
    }
    return localJSONArray;
  }
  
  protected ay l(com.chartboost.sdk.Model.a parama)
  {
    return new ay("/interstitial/show");
  }
  
  public void q(com.chartboost.sdk.Model.a parama)
  {
    com.chartboost.sdk.Libraries.e.a locala = parama.A();
    if ((locala.c()) && (locala.a("webview").c()))
    {
      String str = locala.a("webview").e("template");
      if (locala.j("prefetch_required")) {
        com.chartboost.sdk.b.b();
      }
      if (!com.chartboost.sdk.b.d().containsKey(str)) {
        break label117;
      }
      parama.i = str;
      this.b.put(parama.e, parama);
      if (parama.j)
      {
        b().d(parama);
        parama.c = a.e.d;
        n(parama);
      }
    }
    else
    {
      return;
    }
    super.a(parama, parama.A());
    return;
    label117:
    CBLogging.b(d, "Cannot able to find the html file for some reason due to some error");
    a(parama, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */