package com.chartboost.sdk;

import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Libraries.h.a;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.bc.a;
import com.chartboost.sdk.impl.d;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.l.a;
import com.chartboost.sdk.impl.m;
import com.chartboost.sdk.impl.n.a;
import com.chartboost.sdk.impl.q;
import com.chartboost.sdk.impl.r;
import com.chartboost.sdk.impl.s;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class b
{
  private static HashMap<e, ArrayList<e.a>> A;
  private static Object B = new Object();
  private static boolean C = true;
  private static boolean D = false;
  private static ay.c E = new ay.c()
  {
    public void a(e.a paramAnonymousa, ay paramAnonymousay)
    {
      b.a(b.b.a);
      try
      {
        if (paramAnonymousa.c())
        {
          paramAnonymousay = paramAnonymousa.a("cache_assets");
          CBLogging.a(b.j(), "Got Asset list for Web Prefetch from server :)" + paramAnonymousa);
          b.a(b.e.d, paramAnonymousay);
        }
        return;
      }
      catch (Exception paramAnonymousa)
      {
        paramAnonymousa.printStackTrace();
      }
    }
    
    public void a(e.a paramAnonymousa, ay paramAnonymousay, CBError paramAnonymousCBError)
    {
      try
      {
        b.a(b.b.a);
        return;
      }
      catch (Exception paramAnonymousa)
      {
        paramAnonymousa.printStackTrace();
      }
    }
  };
  public static volatile ConcurrentHashMap<com.chartboost.sdk.Model.a, e> a;
  public static b b;
  public static ArrayList<String> c;
  private static final String d = b.class.getSimpleName();
  private static com.chartboost.sdk.Libraries.h e;
  private static m f;
  private static b g;
  private static b h;
  private static AtomicInteger i = new AtomicInteger();
  private static AtomicInteger j = new AtomicInteger();
  private static String k = "blacklist";
  private static boolean l = false;
  private static ConcurrentHashMap<String, a> m;
  private static ConcurrentHashMap<String, JSONArray> n;
  private static ConcurrentHashMap<String, String> o;
  private static ConcurrentHashMap<String, Integer> p;
  private static e.a q;
  private static ArrayList<c> r = new ArrayList();
  private static ArrayList<String> s = new ArrayList();
  private static HashMap<String, File> t;
  private static HashMap<String, String> u;
  private static e v;
  private static e.a w;
  private static ArrayList<e.a> x;
  private static ArrayList<e.a> y;
  private static ArrayList<e.a> z;
  
  public static b a()
  {
    try
    {
      if (b == null)
      {
        b = new b();
        q();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((n.isEmpty()) || (paramString1.isEmpty())) {
      paramString1 = null;
    }
    label117:
    do
    {
      return paramString1;
      JSONArray localJSONArray = (JSONArray)n.get(paramString2);
      paramString2 = paramString1;
      if (localJSONArray != null)
      {
        paramString2 = paramString1;
        if (localJSONArray.length() > 0)
        {
          int i1 = 0;
          for (;;)
          {
            paramString2 = paramString1;
            if (i1 >= localJSONArray.length()) {
              break label117;
            }
            try
            {
              Object localObject = (a)localJSONArray.get(i1);
              paramString2 = ((a)localObject).b;
              localObject = ((a)localObject).d;
              paramString2 = paramString1.replaceAll(Pattern.quote(paramString2), (String)localObject);
              paramString1 = paramString2;
            }
            catch (Exception paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
                CBLogging.b(d, "Error while injecting values into the html");
              }
            }
            i1 += 1;
          }
        }
      }
      paramString1 = paramString2;
    } while (!paramString2.contains("{{"));
    CBLogging.b(d, " Html data still contains mustache injection values, cannot load the web view ad");
    return null;
  }
  
  private static void a(e.a parama)
  {
    int i1 = parama.p();
    u = new HashMap();
    int i2 = c.F();
    if (i1 > i2) {
      i1 = i2;
    }
    for (;;)
    {
      i2 = 0;
      while (i2 < i1)
      {
        e.a locala1 = parama.c(i2);
        String str1 = locala1.e("template");
        locala1 = locala1.a("elements");
        JSONArray localJSONArray = new JSONArray();
        if ((!TextUtils.isEmpty(str1)) && (locala1 != null) && (locala1.p() > 0))
        {
          int i3 = 0;
          if (i3 < locala1.p())
          {
            e.a locala2 = locala1.c(i3);
            Object localObject = locala2.e("type");
            String str2 = locala2.e("name");
            String str4 = locala2.e("value");
            String str3 = locala2.e("param");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!s.contains(localObject)))
            {
              e.e((String)localObject);
              s.add(localObject);
            }
            if (t.containsKey(str2))
            {
              if ((((String)localObject).equals("html")) && (!u.containsKey(str2))) {
                u.put(str2, str1);
              }
              ((File)t.get(str2)).setLastModified(System.currentTimeMillis());
              if (!TextUtils.isEmpty(str3)) {
                localJSONArray.put(new a(str1, str3, "param", str2, locala2));
              }
            }
            label479:
            for (;;)
            {
              i3 += 1;
              break;
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("param")))
              {
                localJSONArray.put(new a(str1, str3, "param", str4, locala2));
              }
              else if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)))
              {
                if (((String)localObject).equals("html")) {
                  u.put(str2, str1);
                }
                if (m.containsKey(str2))
                {
                  localObject = (a)m.get(str2);
                  ((a)localObject).f.add(str1);
                  m.put(str2, localObject);
                }
                for (;;)
                {
                  if (TextUtils.isEmpty(str3)) {
                    break label479;
                  }
                  localJSONArray.put(new a(str1, str3, "param", str2, locala2));
                  break;
                  localObject = new a(str1, str2, (String)localObject, str4, locala2);
                  m.put(str2, localObject);
                }
              }
            }
          }
          if ((localJSONArray.length() > 0) && (!n.containsKey(str1))) {
            n.put(str1, localJSONArray);
          }
        }
        i2 += 1;
      }
      return;
    }
  }
  
  private static void a(e.a parama, String paramString)
  {
    int i2 = parama.p();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = parama.c(i1);
      String str = ((e.a)localObject).e("name");
      localObject = ((e.a)localObject).e("value");
      if ((!TextUtils.isEmpty(paramString)) && (!s.contains(paramString)))
      {
        e.e(paramString);
        s.add(paramString);
      }
      if (!t.containsKey(str))
      {
        localObject = new a(paramString, str, paramString, (String)localObject, null);
        m.put(str, localObject);
      }
      i1 += 1;
    }
  }
  
  public static void a(e.a parama, boolean paramBoolean, e parame)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      a locala;
      try
      {
        synchronized (b)
        {
          m = new ConcurrentHashMap();
          n = new ConcurrentHashMap();
          localObject1 = e.k();
          localObject2 = e.l();
          if ((q != null) && (q.c()) && (q.p() > 0)) {
            a(q);
          }
          if ((parama == null) || (!parama.c())) {
            break label430;
          }
          localObject3 = parama.a("templates");
          if ((localObject3 != null) && (((e.a)localObject3).c())) {
            a((e.a)localObject3);
          }
          localObject3 = new ArrayList();
          Iterator localIterator = m.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (a)((Map.Entry)localIterator.next()).getValue();
          if (!p.containsKey(locala.a))
          {
            if (!((ArrayList)localObject3).contains(locala.a)) {
              ((ArrayList)localObject3).add(locala.a);
            }
            p.put(locala.a, Integer.valueOf(1));
          }
        }
        i1 = ((Integer)p.get(locala.a)).intValue();
      }
      catch (Exception parama)
      {
        CBLogging.b(d, "Error while syncrhonizing assets");
        return;
      }
      int i1;
      p.put(locala.a, Integer.valueOf(i1 + 1));
    }
    if (com.chartboost.sdk.Libraries.h.e())
    {
      CBLogging.e(d, "##### Serializing blacklist ad id to " + localObject2);
      com.chartboost.sdk.Libraries.h.a((ArrayList)localObject3, (File)localObject2, true);
    }
    for (;;)
    {
      localObject1 = parama.q().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!((String)localObject2).contains("template"))
        {
          localObject3 = parama.a((String)localObject2);
          if ((localObject3 != null) && (((e.a)localObject3).c())) {
            a((e.a)localObject3, (String)localObject2);
          }
        }
      }
      CBLogging.e(d, "##### Serializing blacklist ad id to " + localObject1);
      com.chartboost.sdk.Libraries.h.a((ArrayList)localObject3, (File)localObject1, true);
    }
    label430:
    if (!m.isEmpty())
    {
      j.set(m.size());
      a(m, parame);
    }
    for (;;)
    {
      return;
      h = b.a;
      CBLogging.a(d, "####### Nothing to download for the given response object");
      if ((parama.c()) && (parama.a("templates").c()) && (parama.a("templates").p() > 0))
      {
        parama = parama.a("templates").c(0);
        if (parama.c())
        {
          parama = parama.e("template");
          if (parame != e.d) {
            if (!TextUtils.isEmpty(parama))
            {
              b(parame, parama, true);
            }
            else
            {
              b(parame, "", false);
              CBLogging.a(d, "###### TemplateId Missing for the given response object");
            }
          }
        }
      }
    }
  }
  
  private static void a(e parame)
  {
    if (parame != null) {}
    for (;;)
    {
      try
      {
        CBLogging.a(d, "##### Flush AdQueue called on state: " + parame);
        if (f())
        {
          CBLogging.a(d, "##### Flush AdQueue Download in progress: ");
          if ((parame == e.b) && ((v == e.c) || (v == e.d)))
          {
            CBLogging.a(d, "###### FlushAdQueue: Overrriding the current AdPriority" + v + " with a high priority one");
            ((ArrayList)A.get(v)).add(w);
            e();
            v = e.b;
            w = (e.a)z.remove(0);
            a(w, false, parame);
            h = b.b;
            return;
          }
          if ((parame != e.c) || (v != e.d)) {
            continue;
          }
          CBLogging.a(d, "###### FlushAdQueue: Overrriding the current AdPriority" + v + " with a medium priority one");
          ((ArrayList)A.get(v)).add(w);
          e();
          v = e.c;
          a((e.a)y.remove(0), false, parame);
          h = b.b;
          continue;
        }
        if (f()) {
          continue;
        }
      }
      finally {}
      CBLogging.a(d, "###### FlushAdQueue: Download is not in progress");
      CBLogging.a(d, "###### FlushAdQueue: AdPriorityQueue");
      if (!z.isEmpty())
      {
        v = e.b;
        h = b.b;
        w = (e.a)z.remove(0);
        CBLogging.a(d, "###### Flush Ad Queue: Synchronizing a high priority Ad");
        a(w, false, e.b);
      }
      else if (!y.isEmpty())
      {
        v = e.c;
        h = b.b;
        CBLogging.a(d, "###### Flush Ad Queue: Synchronizing a medium priority Ad");
        w = (e.a)y.remove(0);
        a(w, false, e.c);
      }
      else if (!x.isEmpty())
      {
        v = e.d;
        h = b.b;
        CBLogging.a(d, "###### Flush Ad Queue: Synchronizing a low priority Ad");
        w = (e.a)x.remove(0);
        a(w, true, e.d);
      }
      else
      {
        CBLogging.a(d, "###### Flush Ad Queue: Nothing avaliable in queue resetting the state to initial and idle");
        if ((a != null) && (a.size() > 0))
        {
          parame = a.keySet().iterator();
          while (parame.hasNext())
          {
            com.chartboost.sdk.Model.a locala = (com.chartboost.sdk.Model.a)parame.next();
            locala.u().a(locala, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            a.remove(locala);
          }
        }
        h = b.a;
        v = e.a;
        w = null;
      }
    }
  }
  
  public static void a(e parame, e.a parama)
  {
    for (;;)
    {
      try
      {
        CBLogging.a(d, "##### SynchronizeAssets called on state: " + parame);
        switch (5.a[parame.ordinal()])
        {
        case 1: 
          a(parame);
          return;
        }
      }
      finally {}
      x.add(parama);
      continue;
      y.add(parama);
      continue;
      z.add(parama);
    }
  }
  
  private static void a(File paramFile1, File paramFile2, ArrayList<String> paramArrayList)
  {
    if (paramFile2 != null)
    {
      paramFile2 = paramFile2.listFiles();
      if ((paramFile2 != null) && (paramFile2.length > 0))
      {
        int i3 = paramFile2.length;
        int i1 = 0;
        while (i1 < i3)
        {
          File[] arrayOfFile = paramFile2[i1];
          paramArrayList.add(arrayOfFile.getName());
          if (o.containsKey(paramArrayList)) {
            o.remove(paramArrayList);
          }
          if (c.contains(paramArrayList)) {
            c.remove(paramArrayList);
          }
          arrayOfFile = arrayOfFile.listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0))
          {
            int i4 = arrayOfFile.length;
            int i2 = 0;
            while (i2 < i4)
            {
              File localFile = arrayOfFile[i2];
              String[] arrayOfString = paramFile1.getName().split("\\.(?=[^\\.]+$)");
              if (localFile.getName().equalsIgnoreCase(arrayOfString[0]))
              {
                CBLogging.a(d, "Deleting log file info:" + localFile);
                localFile.delete();
              }
              i2 += 1;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public static void a(HashMap<String, File> paramHashMap)
  {
    ArrayList localArrayList;
    synchronized (B)
    {
      localArrayList = new ArrayList();
      paramHashMap = paramHashMap.keySet().iterator();
      if (paramHashMap.hasNext()) {
        localArrayList.add(((String)paramHashMap.next()).split("\\.(?=[^\\.]+$)")[0]);
      }
    }
    paramHashMap = e.j();
    int i5;
    int i2;
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.listFiles();
      if ((paramHashMap != null) && (paramHashMap.length > 0))
      {
        i5 = paramHashMap.length;
        i2 = 0;
      }
    }
    for (;;)
    {
      File[] arrayOfFile;
      int i3;
      int i1;
      String str;
      int i4;
      int i6;
      if (i2 < i5)
      {
        arrayOfFile = paramHashMap[i2];
        if (TextUtils.isEmpty(arrayOfFile.getName())) {
          break label254;
        }
        i3 = 1;
        i1 = 1;
        str = arrayOfFile.getName();
        arrayOfFile = arrayOfFile.listFiles();
        i4 = i3;
        if (arrayOfFile != null)
        {
          i4 = i3;
          if (arrayOfFile.length > 0)
          {
            i6 = arrayOfFile.length;
            i3 = 0;
          }
        }
      }
      for (;;)
      {
        i4 = i1;
        if (i3 < i6)
        {
          if (!localArrayList.contains(arrayOfFile[i3].getName())) {
            i1 = 0;
          }
        }
        else
        {
          if (i4 != 0)
          {
            if (c.contains(str)) {
              break;
            }
            c.add(str);
            break;
          }
          if (!c.contains(str)) {
            break;
          }
          c.remove(str);
          break;
          return;
        }
        i3 += 1;
      }
      label254:
      i2 += 1;
    }
  }
  
  private static void a(ConcurrentHashMap<String, a> paramConcurrentHashMap, e parame)
  {
    try
    {
      paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
      while (paramConcurrentHashMap.hasNext())
      {
        a locala = (a)paramConcurrentHashMap.next();
        d locald = new d(null);
        c localc = new c(0, locala.d, locald, locala.b, locala);
        d.a(locald, localc);
        localc.a(Integer.valueOf(b.hashCode()));
        localc.a(false);
        localc.a(new d(10000, 1, 1.0F));
        r.add(localc);
        com.chartboost.sdk.Tracking.a.a(locala.d, locala.b);
      }
      bool = D;
    }
    finally {}
    boolean bool;
    if (bool) {}
    for (;;)
    {
      return;
      if (parame == v)
      {
        CBLogging.a(d, "##### DownloadAssets:Sending request to volley: " + v);
        if (!r.isEmpty()) {
          f.a((l)r.remove(0));
        }
      }
      else
      {
        CBLogging.a(d, "##### DownloadAssets: Priority states are different probably overridden by a high priority one ");
      }
    }
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        synchronized (b)
        {
          if (!c.H().booleanValue())
          {
            CBLogging.a(d, "###### WebView is disabled so not performing prefetch");
            return;
          }
          if (c.x()) {}
        }
        if (!c.T().booleanValue()) {
          break label69;
        }
      }
      finally {}
      continue;
      label69:
      CBLogging.a(d, "Webview Prefetching the asset list");
      if (g == b.b)
      {
        CBLogging.a(d, "###### Webview Prefetch is already in progress");
      }
      else if (!C)
      {
        CBLogging.a(d, "Webview Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires");
      }
      else
      {
        new CountDownTimer(c.U() * 60 * 1000, 1000L)
        {
          public void onFinish()
          {
            CBLogging.a(b.j(), "###### Webview Prefetch Session expired");
            b.a(true);
          }
          
          public void onTick(long paramAnonymousLong) {}
        }.start();
        C = false;
        g = b.b;
        j.set(0);
        i.set(0);
        bc localbc = new bc(c.C());
        localbc.a("cache_assets", c(), bc.a.a);
        localbc.a(g.a(new g.k[] { g.a("status", com.chartboost.sdk.Libraries.a.a), g.a("message", g.a()), g.a("cache_assets", g.a(new g.k[] { g.a("templates", g.a(g.b(g.a(new g.k[] { g.a("template", g.a()), g.a("elements", g.b(g.a(new g.k[] { g.a("type", g.a()), g.a("name", g.a()), g.a("value", g.a()) }))) })))), g.a("images", g.a(g.b(g.a(new g.k[] { g.a("name", g.a()), g.a("value", g.a()) })))), g.a("videos", g.a(g.b(g.a(new g.k[] { g.a("name", g.a()), g.a("value", g.a()) })))) })) }));
        localbc.b(true);
        localbc.a(E);
        com.chartboost.sdk.Tracking.a.a(com.chartboost.sdk.Libraries.h.n().e());
        v = e.d;
      }
    }
  }
  
  private static void b(e parame, String paramString, boolean paramBoolean)
  {
    String str1 = d;
    Object localObject2 = new StringBuilder().append("##### notifyCacheImpressionCallback called on state:").append(parame).append(" for adId:");
    if (TextUtils.isEmpty(paramString)) {}
    for (Object localObject1 = "Empty";; localObject1 = paramString)
    {
      CBLogging.a(str1, (String)localObject1);
      if (parame != e.d) {
        break;
      }
      CBLogging.a(d, "##### No need to notify any impressions as they are prefetch download request");
      return;
    }
    if ((!u.isEmpty()) && (!n.isEmpty()))
    {
      parame = new File(e.m(), h.a.f.toString());
      if ((parame != null) && (parame.exists())) {
        localObject1 = u.keySet().iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new File(parame, str1);
        if ((localObject2 != null) && (((File)localObject2).exists()))
        {
          String str2 = new String(e.b((File)localObject2), Charset.defaultCharset());
          CBLogging.a(d, "##### Before html injection file path " + localObject2);
          str2 = a(str2, (String)u.get(str1));
          if (!TextUtils.isEmpty(str2)) {
            o.put(u.get(str1), str2);
          } else {
            CBLogging.b(d, "Error happened while injection on updating the html file in cache " + localObject2);
          }
        }
        else
        {
          CBLogging.b(d, "Error happened, cannot able to find html file in the directory for some reason:" + str1);
          continue;
          CBLogging.b(d, "Error happened, cannot able to find html directory for some reason");
        }
      }
    }
    if (a.size() > 0)
    {
      parame = a.keySet().iterator();
      while (parame.hasNext())
      {
        localObject1 = (com.chartboost.sdk.Model.a)parame.next();
        if ((!TextUtils.isEmpty(paramString)) && (((com.chartboost.sdk.Model.a)localObject1).i.equals(paramString))) {
          if (paramBoolean)
          {
            CBUtility.e().post(new Runnable()
            {
              public void run()
              {
                CBLogging.a(b.j(), "######## Impression found and is read to be notified.");
                this.a.u().q(this.a);
              }
            });
            a.remove(localObject1);
          }
          else
          {
            ((com.chartboost.sdk.Model.a)localObject1).u().a((com.chartboost.sdk.Model.a)localObject1, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
            a.remove(localObject1);
          }
        }
      }
    }
    h = b.a;
    a(null);
  }
  
  public static e.a c()
  {
    e.a locala;
    Object localObject2;
    Object localObject3;
    label98:
    do
    {
      try
      {
        locala = e.a.a();
        try
        {
          t = com.chartboost.sdk.Libraries.h.b();
          a(t);
          List localList = c.l();
          localObject2 = new JSONArray();
          if (c.size() <= 0) {
            break label98;
          }
          localObject3 = c.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((JSONArray)localObject2).put((String)((Iterator)localObject3).next());
          }
          locala = e.a.a(locala);
        }
        catch (Exception localException)
        {
          CBLogging.b(d, "getAvailableAdIdList(): Error while loading ad id into json array");
        }
        return locala;
      }
      finally {}
      locala.a("templates", localObject2);
    } while ((localException == null) || (localException.isEmpty()));
    Iterator localIterator = localException.iterator();
    label127:
    Object localObject4;
    int i2;
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        if (!((String)localObject2).contains("template"))
        {
          localObject3 = e;
          localObject4 = new File(com.chartboost.sdk.Libraries.h.a(), (String)localObject2);
          localObject3 = new JSONArray();
          if (((File)localObject4).exists())
          {
            localObject4 = ((File)localObject4).list();
            if (localObject4 != null)
            {
              i2 = localObject4.length;
              i1 = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i1 < i2)
      {
        Object localObject5 = localObject4[i1];
        if (!((String)localObject5).contains("nomedia")) {
          ((JSONArray)localObject3).put(localObject5);
        }
      }
      else
      {
        locala.a((String)localObject2, localObject3);
        break label127;
        break;
      }
      i1 += 1;
    }
  }
  
  public static ConcurrentHashMap<String, String> d()
  {
    return o;
  }
  
  public static void e()
  {
    try
    {
      f.a(Integer.valueOf(b.hashCode()));
      if ((r != null) && (!r.isEmpty())) {
        r.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static boolean f()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 110	com/chartboost/sdk/b:r	Ljava/util/ArrayList;
    //   6: invokevirtual 434	java/util/ArrayList:isEmpty	()Z
    //   9: ifne +19 -> 28
    //   12: getstatic 90	com/chartboost/sdk/b:d	Ljava/lang/String;
    //   15: ldc_w 772
    //   18: invokestatic 384	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: iconst_1
    //   22: istore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_0
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_0
    //   30: goto -7 -> 23
    //   33: astore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	8	0	bool	boolean
    //   33	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	33	finally
  }
  
  public static void g()
  {
    label39:
    long l1;
    try
    {
      CBLogging.a(d, "########### Invalidating the disk cache");
      t = com.chartboost.sdk.Libraries.h.b();
      if (t != null)
      {
        boolean bool = t.isEmpty();
        if (!bool) {
          break label39;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        File[] arrayOfFile;
        long l3;
        int i2;
        File localFile1;
        int i3;
        File localFile2;
        localException.printStackTrace();
      }
    }
    finally {}
    return;
    arrayOfFile = new File[t.size()];
    Object localObject2 = t.values().iterator();
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      arrayOfFile[i1] = ((File)((Iterator)localObject2).next());
      i1 += 1;
    }
    if (arrayOfFile.length > 1) {
      Arrays.sort(arrayOfFile, new Comparator()
      {
        public int a(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          return Long.valueOf(paramAnonymousFile1.lastModified()).compareTo(Long.valueOf(paramAnonymousFile2.lastModified()));
        }
      });
    }
    localObject2 = new ArrayList();
    label247:
    long l2;
    if (arrayOfFile.length > 0)
    {
      l3 = c.G();
      l1 = com.chartboost.sdk.Libraries.h.f(e.f());
      i2 = c.E();
      CBLogging.a(d, "Total local file count:" + arrayOfFile.length);
      CBLogging.a(d, "Video Folder Size in bytes :" + l1);
      CBLogging.a(d, "Max Bytes allowed:" + l3);
      localFile1 = e.j();
      i3 = arrayOfFile.length;
      i1 = 0;
      if (i1 < i3)
      {
        localFile2 = arrayOfFile[i1];
        if (l1 > l3)
        {
          l2 = l1;
          if (localFile2 == null) {
            break label531;
          }
          if (!localFile2.getPath().contains(h.a.b.toString()))
          {
            l2 = l1;
            if (!localFile2.getPath().contains("video")) {
              break label531;
            }
          }
          CBLogging.a(d, "Deleting file at path:" + localFile2.getPath());
          l2 = l1 - localFile2.length();
          CBLogging.a(d, "Current Video Size:" + l2);
          localFile2.delete();
          a(localFile2, localFile1, (ArrayList)localObject2);
          break label531;
        }
      }
      i3 = arrayOfFile.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i3)
      {
        localFile2 = arrayOfFile[i1];
        if ((com.chartboost.sdk.Libraries.h.a(localFile2, i2)) && (localFile2.exists()))
        {
          CBLogging.a(d, "Deleting file at path:" + localFile2.getPath());
          localFile2.delete();
          a(localFile2, localFile1, (ArrayList)localObject2);
        }
      }
      else
      {
        if (com.chartboost.sdk.Libraries.h.e())
        {
          com.chartboost.sdk.Libraries.h.a((ArrayList)localObject2, e.l(), true);
          break;
        }
        com.chartboost.sdk.Libraries.h.a((ArrayList)localObject2, e.k(), true);
        break;
        label531:
        i1 += 1;
        l1 = l2;
        break label247;
      }
      i1 += 1;
    }
  }
  
  public static void h()
  {
    if (!D)
    {
      CBLogging.a(d, "######## Pause any downloads for webview, as a ad is about to be shown");
      CBLogging.a(d, "######## Current dowload Queue size: " + r.size());
      CBLogging.a(d, "######## CurrentAdPriority: " + v);
      D = true;
    }
  }
  
  public static void i()
  {
    if (D)
    {
      CBLogging.a(d, "######## Resuming any downloads for webview, as a ad is about to be dismissed");
      CBLogging.a(d, "######## Current dowload Queue size" + r.size());
      CBLogging.a(d, "######## CurrentAdPriority: " + v);
      D = false;
      if (!r.isEmpty()) {
        b.a(null);
      }
    }
    else
    {
      return;
    }
    a(null);
  }
  
  /* Error */
  private static void q()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 105	com/chartboost/sdk/b:l	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 105	com/chartboost/sdk/b:l	Z
    //   19: new 236	com/chartboost/sdk/Libraries/h
    //   22: dup
    //   23: iconst_1
    //   24: invokespecial 842	com/chartboost/sdk/Libraries/h:<init>	(Z)V
    //   27: putstatic 234	com/chartboost/sdk/b:e	Lcom/chartboost/sdk/Libraries/h;
    //   30: getstatic 378	com/chartboost/sdk/b$b:a	Lcom/chartboost/sdk/b$b;
    //   33: putstatic 126	com/chartboost/sdk/b:g	Lcom/chartboost/sdk/b$b;
    //   36: getstatic 378	com/chartboost/sdk/b$b:a	Lcom/chartboost/sdk/b$b;
    //   39: putstatic 380	com/chartboost/sdk/b:h	Lcom/chartboost/sdk/b$b;
    //   42: new 561	com/chartboost/sdk/impl/m
    //   45: dup
    //   46: new 844	com/chartboost/sdk/impl/aa
    //   49: dup
    //   50: invokespecial 845	com/chartboost/sdk/impl/aa:<init>	()V
    //   53: new 847	com/chartboost/sdk/impl/u
    //   56: dup
    //   57: new 849	com/chartboost/sdk/impl/y
    //   60: dup
    //   61: invokespecial 850	com/chartboost/sdk/impl/y:<init>	()V
    //   64: invokespecial 853	com/chartboost/sdk/impl/u:<init>	(Lcom/chartboost/sdk/impl/x;)V
    //   67: invokespecial 856	com/chartboost/sdk/impl/m:<init>	(Lcom/chartboost/sdk/impl/b;Lcom/chartboost/sdk/impl/f;)V
    //   70: putstatic 557	com/chartboost/sdk/b:f	Lcom/chartboost/sdk/impl/m;
    //   73: new 139	java/util/concurrent/ConcurrentHashMap
    //   76: dup
    //   77: invokespecial 284	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   80: putstatic 446	com/chartboost/sdk/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: new 139	java/util/concurrent/ConcurrentHashMap
    //   86: dup
    //   87: invokespecial 284	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   90: putstatic 323	com/chartboost/sdk/b:p	Ljava/util/concurrent/ConcurrentHashMap;
    //   93: new 139	java/util/concurrent/ConcurrentHashMap
    //   96: dup
    //   97: invokespecial 284	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   100: putstatic 490	com/chartboost/sdk/b:o	Ljava/util/concurrent/ConcurrentHashMap;
    //   103: new 107	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 108	java/util/ArrayList:<init>	()V
    //   110: putstatic 492	com/chartboost/sdk/b:c	Ljava/util/ArrayList;
    //   113: new 196	java/util/HashMap
    //   116: dup
    //   117: invokespecial 197	java/util/HashMap:<init>	()V
    //   120: putstatic 244	com/chartboost/sdk/b:t	Ljava/util/HashMap;
    //   123: new 196	java/util/HashMap
    //   126: dup
    //   127: invokespecial 197	java/util/HashMap:<init>	()V
    //   130: putstatic 199	com/chartboost/sdk/b:u	Ljava/util/HashMap;
    //   133: getstatic 469	com/chartboost/sdk/b$e:a	Lcom/chartboost/sdk/b$e;
    //   136: putstatic 404	com/chartboost/sdk/b:v	Lcom/chartboost/sdk/b$e;
    //   139: new 107	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 108	java/util/ArrayList:<init>	()V
    //   146: putstatic 440	com/chartboost/sdk/b:x	Ljava/util/ArrayList;
    //   149: new 107	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 108	java/util/ArrayList:<init>	()V
    //   156: putstatic 429	com/chartboost/sdk/b:y	Ljava/util/ArrayList;
    //   159: new 107	java/util/ArrayList
    //   162: dup
    //   163: invokespecial 108	java/util/ArrayList:<init>	()V
    //   166: putstatic 418	com/chartboost/sdk/b:z	Ljava/util/ArrayList;
    //   169: new 196	java/util/HashMap
    //   172: dup
    //   173: invokespecial 197	java/util/HashMap:<init>	()V
    //   176: putstatic 412	com/chartboost/sdk/b:A	Ljava/util/HashMap;
    //   179: getstatic 412	com/chartboost/sdk/b:A	Ljava/util/HashMap;
    //   182: getstatic 386	com/chartboost/sdk/b$e:d	Lcom/chartboost/sdk/b$e;
    //   185: getstatic 440	com/chartboost/sdk/b:x	Ljava/util/ArrayList;
    //   188: invokevirtual 256	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: getstatic 412	com/chartboost/sdk/b:A	Ljava/util/HashMap;
    //   195: getstatic 406	com/chartboost/sdk/b$e:c	Lcom/chartboost/sdk/b$e;
    //   198: getstatic 429	com/chartboost/sdk/b:y	Ljava/util/ArrayList;
    //   201: invokevirtual 256	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: getstatic 412	com/chartboost/sdk/b:A	Ljava/util/HashMap;
    //   208: getstatic 402	com/chartboost/sdk/b$e:b	Lcom/chartboost/sdk/b$e;
    //   211: getstatic 418	com/chartboost/sdk/b:z	Ljava/util/ArrayList;
    //   214: invokevirtual 256	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: getstatic 234	com/chartboost/sdk/b:e	Lcom/chartboost/sdk/Libraries/h;
    //   221: invokevirtual 858	com/chartboost/sdk/Libraries/h:o	()V
    //   224: invokestatic 756	com/chartboost/sdk/Libraries/h:a	()Ljava/io/File;
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +48 -> 277
    //   232: aload_3
    //   233: invokevirtual 760	java/io/File:list	()[Ljava/lang/String;
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +39 -> 277
    //   241: aload_3
    //   242: arraylength
    //   243: ifle +34 -> 277
    //   246: aload_3
    //   247: arraylength
    //   248: istore_1
    //   249: iconst_0
    //   250: istore_0
    //   251: iload_0
    //   252: iload_1
    //   253: if_icmpge +24 -> 277
    //   256: aload_3
    //   257: iload_0
    //   258: aaload
    //   259: astore 4
    //   261: getstatic 112	com/chartboost/sdk/b:s	Ljava/util/ArrayList;
    //   264: aload 4
    //   266: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: iload_0
    //   271: iconst_1
    //   272: iadd
    //   273: istore_0
    //   274: goto -23 -> 251
    //   277: getstatic 557	com/chartboost/sdk/b:f	Lcom/chartboost/sdk/impl/m;
    //   280: invokevirtual 860	com/chartboost/sdk/impl/m:a	()V
    //   283: goto -272 -> 11
    //   286: astore_3
    //   287: ldc 2
    //   289: monitorexit
    //   290: aload_3
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   250	24	0	i1	int
    //   248	6	1	i2	int
    //   6	2	2	bool	boolean
    //   227	30	3	localObject1	Object
    //   286	5	3	localObject2	Object
    //   259	6	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	286	finally
    //   15	228	286	finally
    //   232	237	286	finally
    //   241	249	286	finally
    //   261	270	286	finally
    //   277	283	286	finally
  }
  
  public void a(a parama)
  {
    if (r.isEmpty())
    {
      h = b.a;
      CBLogging.a(d, "######## No request to flush from queue");
    }
    do
    {
      return;
      if (D)
      {
        CBLogging.a(d, "######## Request download is paused");
        CBLogging.a(d, "######## Current download queue size: " + r.size());
        return;
      }
    } while ((D) || (r.isEmpty()));
    CBLogging.a(d, "######## Flushing out next asset download request");
    CBLogging.a(d, "######## Current download queue size: " + r.size());
    f.a((l)r.remove(0));
  }
  
  private static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public e.a e;
    public ArrayList<String> f;
    public boolean g;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, e.a parama)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = parama;
      this.f = new ArrayList();
      this.f.add(this.a);
      this.g = false;
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  private static class c
    extends l<Object>
  {
    private String a;
    private long b;
    private String c;
    private b.a d;
    
    public c(int paramInt, String paramString1, b.d paramd, String paramString2, b.a parama)
    {
      super(paramString1, paramd);
      this.a = paramString2;
      this.c = paramString1;
      this.b = System.currentTimeMillis();
      this.d = parama;
    }
    
    /* Error */
    protected com.chartboost.sdk.impl.n<Object> a(com.chartboost.sdk.impl.i parami)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +293 -> 294
      //   4: invokestatic 29	java/lang/System:currentTimeMillis	()J
      //   7: aload_0
      //   8: getfield 31	com/chartboost/sdk/b$c:b	J
      //   11: lsub
      //   12: ldc2_w 43
      //   15: ldiv
      //   16: lstore_3
      //   17: aload_0
      //   18: getfield 23	com/chartboost/sdk/b$c:c	Ljava/lang/String;
      //   21: aload_0
      //   22: getfield 21	com/chartboost/sdk/b$c:a	Ljava/lang/String;
      //   25: lload_3
      //   26: invokestatic 50	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   29: invokevirtual 54	java/lang/Long:toString	()Ljava/lang/String;
      //   32: invokestatic 60	com/chartboost/sdk/Tracking/a:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   35: invokestatic 64	com/chartboost/sdk/b:k	()Lcom/chartboost/sdk/Libraries/h;
      //   38: aload_0
      //   39: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   42: getfield 67	com/chartboost/sdk/b$a:c	Ljava/lang/String;
      //   45: invokevirtual 72	com/chartboost/sdk/Libraries/h:d	(Ljava/lang/String;)Ljava/io/File;
      //   48: astore 5
      //   50: aload 5
      //   52: ifnull +380 -> 432
      //   55: aload 5
      //   57: ifnull +30 -> 87
      //   60: new 74	java/io/File
      //   63: dup
      //   64: aload 5
      //   66: aload_0
      //   67: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   70: getfield 76	com/chartboost/sdk/b$a:b	Ljava/lang/String;
      //   73: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   76: astore 5
      //   78: aload 5
      //   80: aload_1
      //   81: getfield 84	com/chartboost/sdk/impl/i:b	[B
      //   84: invokestatic 89	com/chartboost/sdk/impl/bt:a	(Ljava/io/File;[B)V
      //   87: aload_0
      //   88: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   91: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   94: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   97: ifne +335 -> 432
      //   100: aload_0
      //   101: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   104: getfield 99	com/chartboost/sdk/b$a:e	Lcom/chartboost/sdk/Libraries/e$a;
      //   107: ifnull +325 -> 432
      //   110: aload_0
      //   111: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   114: getfield 99	com/chartboost/sdk/b$a:e	Lcom/chartboost/sdk/Libraries/e$a;
      //   117: invokevirtual 104	com/chartboost/sdk/Libraries/e$a:c	()Z
      //   120: ifeq +312 -> 432
      //   123: aload_0
      //   124: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   127: getfield 67	com/chartboost/sdk/b$a:c	Ljava/lang/String;
      //   130: ldc 106
      //   132: invokevirtual 111	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   135: ifne +297 -> 432
      //   138: invokestatic 64	com/chartboost/sdk/b:k	()Lcom/chartboost/sdk/Libraries/h;
      //   141: invokevirtual 115	com/chartboost/sdk/Libraries/h:j	()Ljava/io/File;
      //   144: astore_1
      //   145: aload_1
      //   146: ifnull +286 -> 432
      //   149: aload_0
      //   150: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   153: getfield 119	com/chartboost/sdk/b$a:f	Ljava/util/ArrayList;
      //   156: invokevirtual 125	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   159: astore 5
      //   161: aload 5
      //   163: invokeinterface 130 1 0
      //   168: ifeq +264 -> 432
      //   171: new 74	java/io/File
      //   174: dup
      //   175: aload_1
      //   176: aload 5
      //   178: invokeinterface 134 1 0
      //   183: checkcast 108	java/lang/String
      //   186: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   189: astore 6
      //   191: aload 6
      //   193: invokevirtual 137	java/io/File:exists	()Z
      //   196: ifne +9 -> 205
      //   199: aload 6
      //   201: invokevirtual 140	java/io/File:mkdir	()Z
      //   204: pop
      //   205: new 74	java/io/File
      //   208: dup
      //   209: aload 6
      //   211: aload_0
      //   212: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   215: getfield 76	com/chartboost/sdk/b$a:b	Ljava/lang/String;
      //   218: ldc -114
      //   220: invokevirtual 146	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   223: iconst_0
      //   224: aaload
      //   225: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   228: astore 6
      //   230: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   233: new 150	java/lang/StringBuilder
      //   236: dup
      //   237: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   240: ldc -101
      //   242: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: aload_0
      //   246: getfield 21	com/chartboost/sdk/b$c:a	Ljava/lang/String;
      //   249: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   255: invokestatic 165	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   258: aload 6
      //   260: aload_0
      //   261: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   264: getfield 99	com/chartboost/sdk/b$a:e	Lcom/chartboost/sdk/Libraries/e$a;
      //   267: invokevirtual 166	com/chartboost/sdk/Libraries/e$a:toString	()Ljava/lang/String;
      //   270: invokevirtual 170	java/lang/String:getBytes	()[B
      //   273: invokestatic 89	com/chartboost/sdk/impl/bt:a	(Ljava/io/File;[B)V
      //   276: goto -115 -> 161
      //   279: astore 6
      //   281: aload 6
      //   283: invokevirtual 173	java/io/IOException:printStackTrace	()V
      //   286: goto -125 -> 161
      //   289: astore_1
      //   290: aload_1
      //   291: invokevirtual 174	java/lang/Exception:printStackTrace	()V
      //   294: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   297: new 150	java/lang/StringBuilder
      //   300: dup
      //   301: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   304: ldc -80
      //   306: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: invokestatic 180	com/chartboost/sdk/b:n	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   312: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   315: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   318: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   321: invokestatic 165	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   324: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   327: new 150	java/lang/StringBuilder
      //   330: dup
      //   331: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   334: ldc -65
      //   336: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   339: invokestatic 194	com/chartboost/sdk/b:o	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   342: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   345: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   348: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   351: invokestatic 165	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   354: invokestatic 180	com/chartboost/sdk/b:n	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   357: invokevirtual 197	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
      //   360: invokestatic 194	com/chartboost/sdk/b:o	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   363: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   366: if_icmpne +42 -> 408
      //   369: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   372: ldc -57
      //   374: invokestatic 201	com/chartboost/sdk/Libraries/CBLogging:e	(Ljava/lang/Object;Ljava/lang/String;)V
      //   377: invokestatic 180	com/chartboost/sdk/b:n	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   380: iconst_0
      //   381: invokevirtual 205	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   384: invokestatic 194	com/chartboost/sdk/b:o	()Ljava/util/concurrent/atomic/AtomicInteger;
      //   387: iconst_0
      //   388: invokevirtual 205	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   391: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   394: ldc -49
      //   396: invokestatic 201	com/chartboost/sdk/Libraries/CBLogging:e	(Ljava/lang/Object;Ljava/lang/String;)V
      //   399: invokestatic 211	com/chartboost/sdk/b:m	()Lcom/chartboost/sdk/b$e;
      //   402: ldc -43
      //   404: iconst_0
      //   405: invokestatic 216	com/chartboost/sdk/b:a	(Lcom/chartboost/sdk/b$e;Ljava/lang/String;Z)V
      //   408: getstatic 219	com/chartboost/sdk/b:b	Lcom/chartboost/sdk/b;
      //   411: aload_0
      //   412: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   415: invokevirtual 222	com/chartboost/sdk/b:a	(Lcom/chartboost/sdk/b$a;)V
      //   418: aconst_null
      //   419: aconst_null
      //   420: invokestatic 227	com/chartboost/sdk/impl/n:a	(Ljava/lang/Object;Lcom/chartboost/sdk/impl/b$a;)Lcom/chartboost/sdk/impl/n;
      //   423: areturn
      //   424: astore_1
      //   425: aload_1
      //   426: invokevirtual 173	java/io/IOException:printStackTrace	()V
      //   429: goto -342 -> 87
      //   432: aload_0
      //   433: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   436: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   439: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   442: ifne -148 -> 294
      //   445: aload_0
      //   446: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   449: getfield 99	com/chartboost/sdk/b$a:e	Lcom/chartboost/sdk/Libraries/e$a;
      //   452: ifnull -158 -> 294
      //   455: aload_0
      //   456: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   459: getfield 99	com/chartboost/sdk/b$a:e	Lcom/chartboost/sdk/Libraries/e$a;
      //   462: invokevirtual 104	com/chartboost/sdk/Libraries/e$a:c	()Z
      //   465: ifeq -171 -> 294
      //   468: invokestatic 231	com/chartboost/sdk/b:l	()Ljava/util/concurrent/ConcurrentHashMap;
      //   471: aload_0
      //   472: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   475: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   478: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
      //   481: ifeq -187 -> 294
      //   484: invokestatic 231	com/chartboost/sdk/b:l	()Ljava/util/concurrent/ConcurrentHashMap;
      //   487: aload_0
      //   488: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   491: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   494: invokevirtual 240	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   497: checkcast 242	java/lang/Integer
      //   500: invokevirtual 245	java/lang/Integer:intValue	()I
      //   503: iconst_1
      //   504: isub
      //   505: istore_2
      //   506: iload_2
      //   507: ifle +24 -> 531
      //   510: invokestatic 231	com/chartboost/sdk/b:l	()Ljava/util/concurrent/ConcurrentHashMap;
      //   513: aload_0
      //   514: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   517: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   520: iload_2
      //   521: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   524: invokevirtual 252	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   527: pop
      //   528: goto -234 -> 294
      //   531: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   534: new 150	java/lang/StringBuilder
      //   537: dup
      //   538: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   541: ldc -2
      //   543: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   546: aload_0
      //   547: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   550: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   553: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   556: ldc_w 256
      //   559: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   562: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   565: invokestatic 165	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   568: invokestatic 231	com/chartboost/sdk/b:l	()Ljava/util/concurrent/ConcurrentHashMap;
      //   571: aload_0
      //   572: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   575: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   578: invokevirtual 259	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   581: pop
      //   582: invokestatic 64	com/chartboost/sdk/b:k	()Lcom/chartboost/sdk/Libraries/h;
      //   585: invokevirtual 261	com/chartboost/sdk/Libraries/h:k	()Ljava/io/File;
      //   588: astore 5
      //   590: invokestatic 64	com/chartboost/sdk/b:k	()Lcom/chartboost/sdk/Libraries/h;
      //   593: invokevirtual 263	com/chartboost/sdk/Libraries/h:l	()Ljava/io/File;
      //   596: astore 6
      //   598: invokestatic 265	com/chartboost/sdk/Libraries/h:e	()Z
      //   601: ifeq +133 -> 734
      //   604: aload 6
      //   606: invokestatic 268	com/chartboost/sdk/Libraries/h:d	(Ljava/io/File;)Ljava/util/ArrayList;
      //   609: astore_1
      //   610: aload_1
      //   611: ifnull +36 -> 647
      //   614: aload_1
      //   615: invokevirtual 270	java/util/ArrayList:isEmpty	()Z
      //   618: ifne +29 -> 647
      //   621: aload_1
      //   622: aload_0
      //   623: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   626: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   629: invokevirtual 272	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
      //   632: ifeq +15 -> 647
      //   635: aload_1
      //   636: aload_0
      //   637: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   640: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   643: invokevirtual 274	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   646: pop
      //   647: invokestatic 265	com/chartboost/sdk/Libraries/h:e	()Z
      //   650: ifeq +93 -> 743
      //   653: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   656: new 150	java/lang/StringBuilder
      //   659: dup
      //   660: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   663: ldc_w 276
      //   666: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   669: aload 6
      //   671: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   674: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   677: invokestatic 201	com/chartboost/sdk/Libraries/CBLogging:e	(Ljava/lang/Object;Ljava/lang/String;)V
      //   680: aload_1
      //   681: aload 6
      //   683: iconst_0
      //   684: invokestatic 282	com/chartboost/sdk/Libraries/h:a	(Ljava/util/ArrayList;Ljava/io/File;Z)V
      //   687: getstatic 284	com/chartboost/sdk/b:c	Ljava/util/ArrayList;
      //   690: aload_0
      //   691: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   694: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   697: invokevirtual 272	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
      //   700: ifne +17 -> 717
      //   703: getstatic 284	com/chartboost/sdk/b:c	Ljava/util/ArrayList;
      //   706: aload_0
      //   707: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   710: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   713: invokevirtual 287	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   716: pop
      //   717: invokestatic 211	com/chartboost/sdk/b:m	()Lcom/chartboost/sdk/b$e;
      //   720: aload_0
      //   721: getfield 33	com/chartboost/sdk/b$c:d	Lcom/chartboost/sdk/b$a;
      //   724: getfield 90	com/chartboost/sdk/b$a:a	Ljava/lang/String;
      //   727: iconst_1
      //   728: invokestatic 216	com/chartboost/sdk/b:a	(Lcom/chartboost/sdk/b$e;Ljava/lang/String;Z)V
      //   731: goto -437 -> 294
      //   734: aload 5
      //   736: invokestatic 268	com/chartboost/sdk/Libraries/h:d	(Ljava/io/File;)Ljava/util/ArrayList;
      //   739: astore_1
      //   740: goto -130 -> 610
      //   743: invokestatic 148	com/chartboost/sdk/b:j	()Ljava/lang/String;
      //   746: new 150	java/lang/StringBuilder
      //   749: dup
      //   750: invokespecial 153	java/lang/StringBuilder:<init>	()V
      //   753: ldc_w 276
      //   756: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   759: aload 5
      //   761: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   764: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   767: invokestatic 201	com/chartboost/sdk/Libraries/CBLogging:e	(Ljava/lang/Object;Ljava/lang/String;)V
      //   770: aload_1
      //   771: aload 5
      //   773: iconst_0
      //   774: invokestatic 282	com/chartboost/sdk/Libraries/h:a	(Ljava/util/ArrayList;Ljava/io/File;Z)V
      //   777: goto -90 -> 687
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	780	0	this	c
      //   0	780	1	parami	com.chartboost.sdk.impl.i
      //   505	16	2	i	int
      //   16	10	3	l	long
      //   48	724	5	localObject	Object
      //   189	70	6	localFile1	File
      //   279	3	6	localIOException	java.io.IOException
      //   596	86	6	localFile2	File
      // Exception table:
      //   from	to	target	type
      //   230	276	279	java/io/IOException
      //   4	50	289	java/lang/Exception
      //   60	78	289	java/lang/Exception
      //   78	87	289	java/lang/Exception
      //   87	145	289	java/lang/Exception
      //   149	161	289	java/lang/Exception
      //   161	205	289	java/lang/Exception
      //   205	230	289	java/lang/Exception
      //   230	276	289	java/lang/Exception
      //   281	286	289	java/lang/Exception
      //   425	429	289	java/lang/Exception
      //   432	506	289	java/lang/Exception
      //   510	528	289	java/lang/Exception
      //   531	610	289	java/lang/Exception
      //   614	647	289	java/lang/Exception
      //   647	687	289	java/lang/Exception
      //   687	717	289	java/lang/Exception
      //   717	731	289	java/lang/Exception
      //   734	740	289	java/lang/Exception
      //   743	777	289	java/lang/Exception
      //   78	87	424	java/io/IOException
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
  
  private static class d
    implements n.a
  {
    private b.c a;
    
    public void a(s params)
    {
      for (;;)
      {
        synchronized ()
        {
          try
          {
            if ((((params instanceof r)) || ((params instanceof q)) || ((params instanceof com.chartboost.sdk.impl.h))) && (this.a != null))
            {
              long l = (System.currentTimeMillis() - b.c.a(this.a)) / 1000L;
              com.chartboost.sdk.Tracking.a.c(b.c.b(this.a), b.c.c(this.a), Long.valueOf(l).toString(), params.getMessage());
              CBLogging.b(b.j(), "Error downloading asset " + params.getMessage() + b.c.c(this.a));
            }
            params = b.c.d(this.a);
            if (b.l().containsKey(params.a)) {
              b.l().remove(params.a);
            }
          }
          catch (Exception params)
          {
            params.printStackTrace();
            continue;
          }
          if (b.n().incrementAndGet() == b.o().get())
          {
            CBLogging.e(b.j(), "##### Failure response callback : Asset Prefetch Download Complete");
            b.n().set(0);
            b.o().set(0);
            b.b(b.b.a);
            if ((b.c.d(this.a) != null) && (!TextUtils.isEmpty(b.c.d(this.a).a))) {
              b.a(b.m(), b.c.d(this.a).a, false);
            }
          }
          else
          {
            if ((this.a != null) && (!TextUtils.isEmpty(b.c.b(this.a))))
            {
              CBLogging.a(b.j(), "Removing the cache from volley for: " + b.c.b(this.a));
              b.p().d().b(b.c.b(this.a));
            }
            params = b.c.d(this.a);
            b.b.a(params);
            return;
          }
        }
        b.a(b.m(), "", false);
      }
    }
  }
  
  public static enum e
  {
    private e() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */