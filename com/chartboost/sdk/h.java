package com.chartboost.sdk;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.b;
import com.chartboost.sdk.impl.d;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.l.a;
import com.chartboost.sdk.impl.m;
import com.chartboost.sdk.impl.n;
import com.chartboost.sdk.impl.n.a;
import com.chartboost.sdk.impl.q;
import com.chartboost.sdk.impl.r;
import com.chartboost.sdk.impl.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class h
{
  public static h a;
  private static final String b = h.class.getSimpleName();
  private static com.chartboost.sdk.Libraries.h c;
  private static m d;
  private static ArrayList<b> e;
  private static ConcurrentHashMap<Integer, b> f;
  private static a g;
  private static a h;
  private static AtomicInteger i = new AtomicInteger();
  private static AtomicInteger j = new AtomicInteger();
  private static boolean k = true;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean n = true;
  private static Observer o = new Observer()
  {
    public void update(Observable paramAnonymousObservable, Object paramAnonymousObject) {}
  };
  private static ay.c p = new ay.c()
  {
    public void a(e.a paramAnonymousa, ay paramAnonymousay)
    {
      try
      {
        try
        {
          h.a(h.a.a);
          if (paramAnonymousa.c()) {
            h.a(paramAnonymousa.a("videos"));
          }
          return;
        }
        finally {}
        return;
      }
      catch (Exception paramAnonymousa)
      {
        paramAnonymousa.printStackTrace();
      }
    }
    
    public void a(e.a paramAnonymousa, ay paramAnonymousay, CBError paramAnonymousCBError)
    {
      h.a(h.a.a);
    }
  };
  
  public static h a()
  {
    try
    {
      if (a == null)
      {
        a = new h();
        o();
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    if (c.c(paramString)) {
      return c.c(c.f(), paramString).getPath();
    }
    return null;
  }
  
  public static void a(e.a parama)
  {
    int i1 = 0;
    for (;;)
    {
      HashMap localHashMap;
      try
      {
        boolean bool = c.x();
        if (!bool) {
          return;
        }
        if (!parama.c()) {
          continue;
        }
        localHashMap = new HashMap();
        d();
        if (i1 < parama.p())
        {
          Object localObject = parama.c(i1);
          if ((((e.a)localObject).b("id")) || (((e.a)localObject).b("video"))) {
            break label191;
          }
          String str = ((e.a)localObject).e("id");
          localObject = ((e.a)localObject).e("video");
          if ((c.c(str)) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (localHashMap.get(str) != null)) {
            break label191;
          }
          localHashMap.put(str, localObject);
          j.incrementAndGet();
        }
      }
      finally {}
      if (k) {
        k = false;
      }
      CBLogging.a(b, "Synchronizing videos with the list from the server");
      if (!localHashMap.isEmpty())
      {
        a(localHashMap);
        h = a.b;
        continue;
        label191:
        i1 += 1;
      }
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap)
  {
    try
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        c localc = new c(null);
        b localb = new b(0, (String)paramHashMap.get(str), localc, str);
        localb.a(new d(10000, 1, 1.0F));
        c.a(localc, localb);
        localb.a(false);
        localb.a(Integer.valueOf(o.hashCode()));
        com.chartboost.sdk.Tracking.a.a((String)paramHashMap.get(str), str);
        e.add(localb);
        CBLogging.a(b, "Downloading video:" + (String)paramHashMap.get(str));
      }
      if (!l) {
        break label188;
      }
    }
    finally {}
    CBLogging.a(b, "##### Video Download is put on hold, it seems an ad is shown, it will resume once the ad is closed");
    for (;;)
    {
      return;
      label188:
      if (!e.isEmpty()) {
        d.a((l)e.remove(0));
      }
    }
  }
  
  public static String b(e.a parama)
  {
    if (parama == null) {
      return null;
    }
    e.a locala = parama.a("assets");
    if (locala.b()) {
      return null;
    }
    if (CBUtility.c().a()) {}
    for (parama = "video-portrait";; parama = "video-landscape")
    {
      parama = locala.a(parama);
      if (!parama.b()) {
        break;
      }
      return null;
    }
    parama = parama.e("id");
    if (TextUtils.isEmpty(parama)) {
      return null;
    }
    return a(parama);
  }
  
  public static void b()
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (!m) {
          o();
        }
        if (!c.N())
        {
          CBLogging.a(b, "###### Native is disabled so not performing prefetch");
          return;
        }
        if ((!c.x()) || (c.T().booleanValue())) {
          continue;
        }
        CBLogging.a(b, "Native Prefetching the Video list");
        if ((a.b == g) || (a.b == h)) {
          continue;
        }
        if (!n)
        {
          CBLogging.a(b, "Native Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires");
          continue;
        }
        new CountDownTimer(c.V() * 60 * 1000, 1000L)
        {
          public void onFinish()
          {
            CBLogging.a(h.i(), "###### Native Prefetch Session expired");
            h.a(true);
          }
          
          public void onTick(long paramAnonymousLong) {}
        }.start();
      }
      finally {}
      n = false;
      if ((f != null) && (!f.isEmpty()))
      {
        f.clear();
        d.a(Integer.valueOf(o.hashCode()));
        h = a.a;
        CBLogging.a(b, "prefetchVideo: Clearing all volley request for new start");
      }
      g = a.b;
      JSONArray localJSONArray = new JSONArray();
      if (d() != null)
      {
        localObject2 = d();
        int i2 = localObject2.length;
        while (i1 < i2)
        {
          localJSONArray.put(localObject2[i1]);
          i1 += 1;
        }
      }
      j.set(0);
      i.set(0);
      Object localObject2 = new ay("/api/video-prefetch");
      ((ay)localObject2).a("local-videos", localJSONArray);
      ((ay)localObject2).a(g.a(new g.k[] { g.a("status", com.chartboost.sdk.Libraries.a.a), g.a("videos", g.b(g.a(new g.k[] { g.a("video", g.a(g.a())), g.a("id", g.a()) }))) }));
      ((ay)localObject2).b(true);
      ((ay)localObject2).a(p);
    }
  }
  
  public static boolean c(e.a parama)
  {
    return !TextUtils.isEmpty(b(parama));
  }
  
  public static String[] d()
  {
    if (c == null) {
      return null;
    }
    return c.c(c.f());
  }
  
  public static void e()
  {
    try
    {
      d.a(Integer.valueOf(o.hashCode()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void f()
  {
    if (!l)
    {
      CBLogging.a(b, "##### Pause Video Downloads if its in progress.");
      CBLogging.a(b, "##### Current Queue size: " + e.size());
      l = true;
    }
  }
  
  public static void g()
  {
    if (l)
    {
      CBLogging.a(b, "##### Resume video download if its in progress");
      CBLogging.a(b, "##### Current Queue size: " + e.size());
      l = false;
      a.c();
    }
  }
  
  /* Error */
  private static void o()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 70	com/chartboost/sdk/h:m	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 70	com/chartboost/sdk/h:m	Z
    //   19: new 94	com/chartboost/sdk/Libraries/h
    //   22: dup
    //   23: iconst_1
    //   24: invokespecial 423	com/chartboost/sdk/Libraries/h:<init>	(Z)V
    //   27: putstatic 92	com/chartboost/sdk/h:c	Lcom/chartboost/sdk/Libraries/h;
    //   30: new 326	java/util/concurrent/ConcurrentHashMap
    //   33: dup
    //   34: invokespecial 424	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   37: putstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: getstatic 335	com/chartboost/sdk/h$a:a	Lcom/chartboost/sdk/h$a;
    //   43: putstatic 83	com/chartboost/sdk/h:g	Lcom/chartboost/sdk/h$a;
    //   46: getstatic 335	com/chartboost/sdk/h$a:a	Lcom/chartboost/sdk/h$a;
    //   49: putstatic 172	com/chartboost/sdk/h:h	Lcom/chartboost/sdk/h$a;
    //   52: new 263	com/chartboost/sdk/impl/m
    //   55: dup
    //   56: new 426	com/chartboost/sdk/impl/aa
    //   59: dup
    //   60: invokespecial 427	com/chartboost/sdk/impl/aa:<init>	()V
    //   63: new 429	com/chartboost/sdk/impl/u
    //   66: dup
    //   67: new 431	com/chartboost/sdk/impl/y
    //   70: dup
    //   71: invokespecial 432	com/chartboost/sdk/impl/y:<init>	()V
    //   74: invokespecial 435	com/chartboost/sdk/impl/u:<init>	(Lcom/chartboost/sdk/impl/x;)V
    //   77: invokespecial 438	com/chartboost/sdk/impl/m:<init>	(Lcom/chartboost/sdk/impl/b;Lcom/chartboost/sdk/impl/f;)V
    //   80: putstatic 255	com/chartboost/sdk/h:d	Lcom/chartboost/sdk/impl/m;
    //   83: new 234	java/util/ArrayList
    //   86: dup
    //   87: invokespecial 439	java/util/ArrayList:<init>	()V
    //   90: putstatic 232	com/chartboost/sdk/h:e	Ljava/util/ArrayList;
    //   93: invokestatic 444	com/chartboost/sdk/impl/ax:a	()Lcom/chartboost/sdk/impl/ax;
    //   96: getstatic 75	com/chartboost/sdk/h:o	Ljava/util/Observer;
    //   99: invokevirtual 448	com/chartboost/sdk/impl/ax:addObserver	(Ljava/util/Observer;)V
    //   102: getstatic 255	com/chartboost/sdk/h:d	Lcom/chartboost/sdk/impl/m;
    //   105: invokevirtual 450	com/chartboost/sdk/impl/m:a	()V
    //   108: goto -97 -> 11
    //   111: astore_1
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   111	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	111	finally
    //   15	108	111	finally
  }
  
  /* Error */
  private static void p()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 55	com/chartboost/sdk/h:b	Ljava/lang/String;
    //   6: ldc_w 452
    //   9: invokestatic 163	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: getstatic 83	com/chartboost/sdk/h:g	Lcom/chartboost/sdk/h$a;
    //   15: getstatic 170	com/chartboost/sdk/h$a:b	Lcom/chartboost/sdk/h$a;
    //   18: if_acmpeq +16 -> 34
    //   21: getstatic 172	com/chartboost/sdk/h:h	Lcom/chartboost/sdk/h$a;
    //   24: astore_0
    //   25: getstatic 170	com/chartboost/sdk/h$a:b	Lcom/chartboost/sdk/h$a;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: if_acmpne +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 172	com/chartboost/sdk/h:h	Lcom/chartboost/sdk/h$a;
    //   41: getstatic 335	com/chartboost/sdk/h$a:a	Lcom/chartboost/sdk/h$a;
    //   44: if_acmpne +9 -> 53
    //   47: getstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: ifnonnull +12 -> 62
    //   53: getstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: invokevirtual 453	java/util/concurrent/ConcurrentHashMap:size	()I
    //   59: ifle -25 -> 34
    //   62: getstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: invokevirtual 454	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   68: invokeinterface 182 1 0
    //   73: astore_0
    //   74: aload_0
    //   75: invokeinterface 187 1 0
    //   80: ifeq -46 -> 34
    //   83: aload_0
    //   84: invokeinterface 191 1 0
    //   89: checkcast 218	java/lang/Integer
    //   92: astore_1
    //   93: getstatic 170	com/chartboost/sdk/h$a:b	Lcom/chartboost/sdk/h$a;
    //   96: putstatic 172	com/chartboost/sdk/h:h	Lcom/chartboost/sdk/h$a;
    //   99: getstatic 255	com/chartboost/sdk/h:d	Lcom/chartboost/sdk/impl/m;
    //   102: getstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   105: aload_1
    //   106: invokevirtual 455	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 261	com/chartboost/sdk/impl/l
    //   112: invokevirtual 266	com/chartboost/sdk/impl/m:a	(Lcom/chartboost/sdk/impl/l;)Lcom/chartboost/sdk/impl/l;
    //   115: pop
    //   116: getstatic 324	com/chartboost/sdk/h:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload_1
    //   120: invokevirtual 457	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: goto -50 -> 74
    //   127: astore_0
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload_0
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	60	0	localObject1	Object
    //   127	5	0	localObject2	Object
    //   28	92	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	29	127	finally
    //   38	53	127	finally
    //   53	62	127	finally
    //   62	74	127	finally
    //   74	124	127	finally
  }
  
  public void c()
  {
    if ((!l) && (!e.isEmpty()))
    {
      CBLogging.a(b, "##### Flushing out next request to download");
      d.a((l)e.remove(0));
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private static class b
    extends l<Object>
  {
    private String a;
    private long b;
    private String c;
    
    public b(int paramInt, String paramString1, h.c paramc, String paramString2)
    {
      super(paramString1, paramc);
      this.a = paramString2;
      this.c = paramString1;
      this.b = System.currentTimeMillis();
    }
    
    protected n<Object> a(i arg1)
    {
      if (??? != null)
      {
        long l = (System.currentTimeMillis() - this.b) / 1000L;
        com.chartboost.sdk.Tracking.a.e(this.c, this.a, Long.valueOf(l).toString());
        CBLogging.a(h.i(), "Video download Success. Storing video in cache " + h.j().f() + this.a);
        h.j().a(h.j().f(), this.a, ???.b);
      }
      synchronized (h.a())
      {
        h.a.c();
        if (h.k().incrementAndGet() == h.l().get())
        {
          CBLogging.a(h.i(), "Video Prefetcher downloads completed");
          h.k().set(0);
          h.l().set(0);
          h.b(h.a.a);
          h.m().clear();
        }
        return n.a(null, null);
      }
    }
    
    protected void b(Object paramObject) {}
    
    public Map<String, String> i()
      throws com.chartboost.sdk.impl.a
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ay.b().entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject1).getKey();
        if (((Map.Entry)localObject1).getValue() != null) {}
        for (localObject1 = ((Map.Entry)localObject1).getValue().toString();; localObject1 = null)
        {
          localHashMap.put(localObject2, localObject1);
          break;
        }
      }
      return localHashMap;
    }
    
    public l.a s()
    {
      return l.a.a;
    }
  }
  
  private static class c
    implements n.a
  {
    private h.b a;
    
    public void a(s params)
    {
      h.a.c();
      if (((params instanceof r)) || ((params instanceof q)) || ((params instanceof com.chartboost.sdk.impl.h)))
      {
        if (this.a != null)
        {
          long l = (System.currentTimeMillis() - h.b.a(this.a)) / 1000L;
          com.chartboost.sdk.Tracking.a.c(h.b.b(this.a), h.b.c(this.a), Long.valueOf(l).toString(), params.getMessage());
        }
        h.m().put(Integer.valueOf(this.a.hashCode()), this.a);
        CBLogging.b(h.i(), "Error downloading video " + params.getMessage() + h.b.c(this.a));
      }
      if ((this.a != null) && (!TextUtils.isEmpty(h.b.b(this.a))))
      {
        CBLogging.a(h.i(), "Removing the cache from volley for: " + h.b.b(this.a));
        h.n().d().b(h.b.b(this.a));
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */