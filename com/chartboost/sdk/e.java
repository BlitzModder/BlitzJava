package com.chartboost.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.CBError.a;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.ay.d;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public abstract class e
{
  protected static Handler a = ;
  public ConcurrentHashMap<String, com.chartboost.sdk.Model.a> b = new ConcurrentHashMap();
  public a.b c = a.b.a;
  private Map<String, com.chartboost.sdk.Model.a> d = new HashMap();
  private ConcurrentHashMap<String, com.chartboost.sdk.Model.a> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, com.chartboost.sdk.Model.a> f = new ConcurrentHashMap();
  private a g = null;
  
  private void a(com.chartboost.sdk.Model.a parama, boolean paramBoolean)
  {
    int i;
    if (parama.c == a.e.d)
    {
      i = 1;
      i(parama);
      f localf = Chartboost.h();
      if (localf != null)
      {
        if (!localf.c()) {
          break label57;
        }
        localf.a(parama, false);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        h(parama);
        return;
        i = 0;
        break;
        label57:
        if ((parama.m) && (i == 0) && (parama.c != a.e.c)) {
          return;
        }
      }
    }
    Chartboost.a(parama);
  }
  
  private final boolean g(String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        com.chartboost.sdk.Model.a locala = c(paramString);
        if (locala == null) {
          break label138;
        }
        if (b.f())
        {
          CBLogging.b(getClass().getSimpleName(), "Some downloads are in progress");
          if (b.a.contains(locala))
          {
            CBLogging.b(getClass().getSimpleName(), String.format("%s %s", new Object[] { "Request already in process for impression with location", paramString }));
            return bool;
          }
          bool = false;
          continue;
        }
        if (b.a.contains(locala))
        {
          CBLogging.b(getClass().getSimpleName(), String.format("%s %s", new Object[] { "Request already in process for impression with location", paramString }));
          continue;
        }
        b.a.remove(locala);
      }
      finally {}
      bool = false;
      continue;
      label138:
      bool = false;
    }
  }
  
  protected abstract com.chartboost.sdk.Model.a a(String paramString, boolean paramBoolean);
  
  protected void a()
  {
    CBLogging.a(getClass().getSimpleName(), "##### Clearing all cached impressions for ->" + f());
    this.e.clear();
  }
  
  protected void a(com.chartboost.sdk.Model.a parama)
  {
    p(parama);
    b().d(parama);
    parama.c = a.e.d;
  }
  
  protected void a(com.chartboost.sdk.Model.a parama, com.chartboost.sdk.Libraries.e.a parama1)
  {
    if (parama1.f("status") == 404)
    {
      CBLogging.b(parama.d, "Invalid status code" + parama1.a("status"));
      a(parama, CBError.CBImpressionError.NO_AD_FOUND);
      return;
    }
    if (parama1.f("status") != 200)
    {
      CBLogging.b(parama.d, "Invalid status code" + parama1.a("status"));
      a(parama, CBError.CBImpressionError.INVALID_RESPONSE);
      return;
    }
    parama.a(parama1, d.a().a);
  }
  
  protected void a(final com.chartboost.sdk.Model.a parama, final CBError.CBImpressionError paramCBImpressionError)
  {
    Chartboost.a(new Runnable()
    {
      public void run()
      {
        e.this.n(parama);
        Object localObject = Chartboost.h();
        if ((localObject != null) && (((f)localObject).c())) {
          ((f)localObject).a(parama, true);
        }
        for (;;)
        {
          e.this.b().a(parama, paramCBImpressionError);
          String str1 = parama.t();
          String str2 = parama.u().f();
          String str3 = parama.e;
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = "";
          }
          com.chartboost.sdk.Tracking.a.a(str2, str3, (String)localObject, paramCBImpressionError);
          return;
          if ((parama.c == a.e.c) && (localObject != null)) {
            ((f)localObject).b(parama);
          }
        }
      }
    });
  }
  
  public void a(com.chartboost.sdk.Model.a parama, a.b paramb)
  {
    if (parama != null) {
      parama.a = paramb;
    }
    this.c = paramb;
  }
  
  protected final void a(ay paramay, final com.chartboost.sdk.Model.a parama)
  {
    parama.v = true;
    paramay.a(new ay.c()
    {
      public void a(final com.chartboost.sdk.Libraries.e.a paramAnonymousa, ay paramAnonymousay)
      {
        Chartboost.a(new Runnable()
        {
          public void run()
          {
            try
            {
              if (paramAnonymousa.c())
              {
                e.4.this.a.v = false;
                String str = paramAnonymousa.e("type");
                if ((!TextUtils.isEmpty(str)) && (str.equals("native"))) {
                  e.this.a(e.4.this.a, a.b.a);
                }
                for (;;)
                {
                  e.this.a(e.4.this.a, paramAnonymousa);
                  return;
                  e.this.a(e.4.this.a, a.b.b);
                }
              }
              e.this.a(e.4.this.a, CBError.CBImpressionError.INVALID_RESPONSE);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              return;
            }
          }
        });
      }
      
      public void a(com.chartboost.sdk.Libraries.e.a paramAnonymousa, final ay paramAnonymousay, final CBError paramAnonymousCBError)
      {
        Chartboost.a(new Runnable()
        {
          public void run()
          {
            e.4.this.a.v = false;
            String str2 = paramAnonymousay.h();
            String str3 = paramAnonymousCBError.a().name();
            if (paramAnonymousCBError.b() != null) {}
            for (String str1 = paramAnonymousCBError.b();; str1 = "")
            {
              CBLogging.d("network failure", String.format("request %s failed with error %s: %s", new Object[] { str2, str3, str1 }));
              e.this.a(e.4.this.a, paramAnonymousCBError.c());
              return;
            }
          }
        });
      }
    });
  }
  
  public void a(final String paramString)
  {
    if (g(paramString)) {}
    final com.chartboost.sdk.Model.a locala;
    do
    {
      do
      {
        return;
        locala = a(paramString, false);
        localObject = Chartboost.h();
        if ((localObject == null) || (!((f)localObject).d())) {
          break;
        }
      } while (b() == null);
      b().a(locala, CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
      return;
    } while (b(locala));
    final Object localObject = (com.chartboost.sdk.Model.a)this.e.get(paramString);
    paramString = (com.chartboost.sdk.Model.a)this.b.get(paramString);
    a.post(new Runnable()
    {
      public void run()
      {
        if (localObject != null)
        {
          if (localObject.c == a.e.f) {
            localObject.c = a.e.d;
          }
          e.this.g(localObject);
          return;
        }
        if ((paramString != null) && (paramString.A().c()))
        {
          paramString.a(paramString.A(), d.a().a);
          return;
        }
        e.this.c(locala);
      }
    });
  }
  
  protected final a b()
  {
    if (this.g == null) {
      this.g = c();
    }
    return this.g;
  }
  
  public void b(String paramString)
  {
    if (g(paramString)) {}
    do
    {
      return;
      com.chartboost.sdk.Model.a locala = (com.chartboost.sdk.Model.a)this.e.get(paramString);
      if (locala != null)
      {
        b().d(locala);
        return;
      }
      locala = (com.chartboost.sdk.Model.a)this.b.get(paramString);
      if (locala != null)
      {
        b().d(locala);
        return;
      }
      paramString = a(paramString, true);
    } while (b(paramString));
    c(paramString);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = (com.chartboost.sdk.Model.a)this.f.get(str);
    if (paramString != null)
    {
      this.f.remove(str);
      if (paramBoolean) {
        a(paramString, true);
      }
    }
  }
  
  protected final boolean b(com.chartboost.sdk.Model.a parama)
  {
    if (b().h(parama)) {}
    while (CBUtility.a().getInt("cbPrefSessionCount", 0) != 1) {
      return false;
    }
    a(parama, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
    return true;
  }
  
  /* Error */
  protected com.chartboost.sdk.Model.a c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +21 -> 27
    //   9: aload_0
    //   10: getfield 65	com/chartboost/sdk/e:d	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 297 2 0
    //   19: checkcast 70	com/chartboost/sdk/Model/a
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	e
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  protected abstract a c();
  
  protected void c(com.chartboost.sdk.Model.a parama)
  {
    if (!f(parama)) {}
    ay localay;
    do
    {
      do
      {
        do
        {
          return;
        } while (!b().g(parama));
        if ((!parama.j) && (parama.d == a.a.b) && (c.w()))
        {
          parama.m = true;
          Chartboost.a(parama);
        }
      } while (!d(parama));
      localay = e(parama);
    } while (localay == null);
    a(localay, parama);
    o(parama);
    com.chartboost.sdk.Tracking.a.a(f(), parama.e, parama.t(), parama.j);
  }
  
  public void d()
  {
    Iterator localIterator;
    com.chartboost.sdk.Model.a locala;
    if ((this.b != null) && (!this.b.isEmpty()))
    {
      CBLogging.a(getClass().getSimpleName(), "###### Invalidate Cached Impression for webview");
      localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        locala = (com.chartboost.sdk.Model.a)localIterator.next();
        o(locala);
        this.b.remove(locala.e);
        a(locala, locala.A());
      }
    }
    if ((this.e != null) && (!this.e.isEmpty()))
    {
      localIterator = this.e.values().iterator();
      while (localIterator.hasNext())
      {
        locala = (com.chartboost.sdk.Model.a)localIterator.next();
        o(locala);
        a(locala, locala.A());
        this.e.remove(locala.e);
      }
    }
    if ((this.f != null) && (!this.f.isEmpty()))
    {
      localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        locala = (com.chartboost.sdk.Model.a)localIterator.next();
        o(locala);
        a(locala, locala.A());
        this.f.remove(locala.e);
      }
    }
  }
  
  protected boolean d(com.chartboost.sdk.Model.a parama)
  {
    return true;
  }
  
  public boolean d(String paramString)
  {
    return e(paramString) != null;
  }
  
  protected Context e()
  {
    try
    {
      Object localObject = Chartboost.class.getDeclaredMethod("getValidContext", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (Context)((Method)localObject).invoke(null, new Object[0]);
      return (Context)localObject;
    }
    catch (Exception localException)
    {
      CBLogging.b(this, "Error encountered getting valid context", localException);
      CBUtility.throwProguardError(localException);
    }
    return c.y();
  }
  
  protected com.chartboost.sdk.Model.a e(String paramString)
  {
    com.chartboost.sdk.Model.a locala = (com.chartboost.sdk.Model.a)this.e.get(paramString);
    if ((locala != null) && (!m(locala))) {
      paramString = locala;
    }
    do
    {
      return paramString;
      if ((this.b.isEmpty()) || (!this.b.containsKey(paramString))) {
        break;
      }
      locala = (com.chartboost.sdk.Model.a)this.b.get(paramString);
      if (locala == null) {
        break;
      }
      paramString = locala;
    } while (!m(locala));
    return null;
  }
  
  protected abstract ay e(com.chartboost.sdk.Model.a parama);
  
  public abstract String f();
  
  protected void f(String paramString)
  {
    CBLogging.a(getClass().getSimpleName(), "##### Removing impression-> " + f() + " at location" + paramString);
    this.e.remove(paramString);
  }
  
  protected final boolean f(com.chartboost.sdk.Model.a parama)
  {
    if (!c.q()) {
      a(parama, CBError.CBImpressionError.SESSION_NOT_STARTED);
    }
    do
    {
      return false;
      f localf = Chartboost.h();
      if ((parama.j) || (localf == null) || (!localf.d())) {
        break;
      }
    } while (b() == null);
    b().a(parama, CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    return false;
    if (!ax.a().c())
    {
      a(parama, CBError.CBImpressionError.INTERNET_UNAVAILABLE);
      return false;
    }
    return true;
  }
  
  public a.b g()
  {
    return this.c;
  }
  
  protected void g(com.chartboost.sdk.Model.a parama)
  {
    boolean bool;
    if (parama.c != a.e.c)
    {
      bool = true;
      if (!bool) {
        break label79;
      }
      if ((c.b() != null) && (c.b().doesWrapperUseCustomShouldDisplayBehavior())) {
        if (parama.e != null) {
          break label71;
        }
      }
    }
    label71:
    for (String str = "";; str = parama.e)
    {
      this.f.put(str, parama);
      if (b().f(parama)) {
        break label79;
      }
      return;
      bool = false;
      break;
    }
    label79:
    a(parama, bool);
  }
  
  public String h()
  {
    if (this.c == a.b.a) {
      return "native";
    }
    return "web";
  }
  
  protected void h(com.chartboost.sdk.Model.a parama)
  {
    Chartboost.a(parama);
  }
  
  protected void i(com.chartboost.sdk.Model.a parama)
  {
    j(parama);
  }
  
  public void j(com.chartboost.sdk.Model.a parama)
  {
    if (parama.k) {}
    do
    {
      return;
      parama.k = true;
      parama.j = false;
      k(parama);
      this.b.remove(parama.e);
    } while (e(parama.e) != parama);
    f(parama.e);
  }
  
  protected void k(final com.chartboost.sdk.Model.a parama)
  {
    ay localay = l(parama);
    localay.a(true);
    if (parama.j) {
      localay.a("cached", "1");
    }
    for (;;)
    {
      String str = parama.A().e("ad_id");
      if (str != null) {
        localay.a("ad_id", str);
      }
      localay.a("location", parama.e);
      localay.a(new ay.d()
      {
        public void a(com.chartboost.sdk.Libraries.e.a paramAnonymousa, ay paramAnonymousay)
        {
          if ((c.k()) && (!e.this.d(parama.e))) {
            e.this.b(parama.e);
          }
        }
      });
      com.chartboost.sdk.Tracking.a.a(f(), parama.e, parama.t());
      return;
      localay.a("cached", "0");
    }
  }
  
  protected abstract ay l(com.chartboost.sdk.Model.a parama);
  
  protected final boolean m(com.chartboost.sdk.Model.a parama)
  {
    return TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - parama.b.getTime()) >= 86400L;
  }
  
  protected void n(com.chartboost.sdk.Model.a parama)
  {
    if (parama != null) {}
    try
    {
      this.d.remove(parama.e);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected void o(com.chartboost.sdk.Model.a parama)
  {
    if (parama != null) {}
    try
    {
      this.d.put(parama.e, parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected void p(com.chartboost.sdk.Model.a parama)
  {
    CBLogging.a(getClass().getSimpleName(), "##### Adding aimpression-> " + f() + " at location" + parama.e);
    CBLogging.a(getClass().getSimpleName(), "##### Impression should cache:" + parama.j);
    this.e.put(parama.e, parama);
  }
  
  public void q(com.chartboost.sdk.Model.a parama) {}
  
  protected static abstract interface a
  {
    public abstract void a(com.chartboost.sdk.Model.a parama);
    
    public abstract void a(com.chartboost.sdk.Model.a parama, CBError.CBImpressionError paramCBImpressionError);
    
    public abstract void b(com.chartboost.sdk.Model.a parama);
    
    public abstract void c(com.chartboost.sdk.Model.a parama);
    
    public abstract void d(com.chartboost.sdk.Model.a parama);
    
    public abstract void e(com.chartboost.sdk.Model.a parama);
    
    public abstract boolean f(com.chartboost.sdk.Model.a parama);
    
    public abstract boolean g(com.chartboost.sdk.Model.a parama);
    
    public abstract boolean h(com.chartboost.sdk.Model.a parama);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */