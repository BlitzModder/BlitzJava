package com.chartboost.sdk.impl;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class l<T>
  implements Comparable<l<T>>
{
  private final t.a a;
  private final int b;
  private final String c;
  private final int d;
  private final n.a e;
  private Integer f;
  private m g;
  private boolean h;
  private boolean i;
  private boolean j;
  private p k;
  private b.a l;
  private Object m;
  
  public l(int paramInt, String paramString, n.a parama)
  {
    if (t.a.a) {}
    for (t.a locala = new t.a();; locala = null)
    {
      this.a = locala;
      this.h = false;
      this.i = false;
      this.j = false;
      this.l = null;
      this.b = paramInt;
      this.c = paramString;
      this.e = parama;
      a(new d());
      this.d = c(paramString);
      return;
    }
  }
  
  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
      paramMap = localStringBuilder.toString().getBytes(paramString);
    }
    catch (UnsupportedEncodingException paramMap)
    {
      throw new RuntimeException("Encoding not supported: " + paramString, paramMap);
    }
    return paramMap;
  }
  
  private static int c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(l<T> paraml)
  {
    a locala1 = s();
    a locala2 = paraml.s();
    if (locala1 == locala2) {
      return this.f.intValue() - paraml.f.intValue();
    }
    return locala2.ordinal() - locala1.ordinal();
  }
  
  public final l<?> a(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
    return this;
  }
  
  public l<?> a(b.a parama)
  {
    this.l = parama;
    return this;
  }
  
  public l<?> a(m paramm)
  {
    this.g = paramm;
    return this;
  }
  
  public l<?> a(p paramp)
  {
    this.k = paramp;
    return this;
  }
  
  public l<?> a(Object paramObject)
  {
    this.m = paramObject;
    return this;
  }
  
  public final l<?> a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  protected abstract n<T> a(i parami);
  
  protected s a(s params)
  {
    return params;
  }
  
  public void a(String paramString)
  {
    if (t.a.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
  }
  
  public Object b()
  {
    return this.m;
  }
  
  public void b(s params)
  {
    if (this.e != null) {
      this.e.a(params);
    }
  }
  
  protected abstract void b(T paramT);
  
  void b(final String paramString)
  {
    if (this.g != null) {
      this.g.b(this);
    }
    final long l1;
    if (t.a.a)
    {
      l1 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            l.b(l.this).a(paramString, l1);
            l.b(l.this).a(toString());
          }
        });
      }
    }
    else
    {
      return;
    }
    this.a.a(paramString, l1);
    this.a.a(toString());
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return d();
  }
  
  public b.a f()
  {
    return this.l;
  }
  
  public void g()
  {
    this.i = true;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public Map<String, String> i()
    throws a
  {
    return Collections.emptyMap();
  }
  
  @Deprecated
  protected Map<String, String> j()
    throws a
  {
    return n();
  }
  
  @Deprecated
  protected String k()
  {
    return o();
  }
  
  @Deprecated
  public String l()
  {
    return p();
  }
  
  @Deprecated
  public byte[] m()
    throws a
  {
    Map localMap = j();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, k());
    }
    return null;
  }
  
  protected Map<String, String> n()
    throws a
  {
    return null;
  }
  
  protected String o()
  {
    return "UTF-8";
  }
  
  public String p()
  {
    return "application/x-www-form-urlencoded; charset=" + o();
  }
  
  public byte[] q()
    throws a
  {
    Map localMap = n();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, o());
    }
    return null;
  }
  
  public final boolean r()
  {
    return this.h;
  }
  
  public a s()
  {
    return a.b;
  }
  
  public final int t()
  {
    return this.k.a();
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(c());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.i) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + d() + " " + str2 + " " + s() + " " + this.f;
    }
  }
  
  public p u()
  {
    return this.k;
  }
  
  public void v()
  {
    this.j = true;
  }
  
  public boolean w()
  {
    return this.j;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */