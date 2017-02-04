package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.g.a;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.a;
import com.chartboost.sdk.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class az
  implements Observer
{
  private static az b;
  private static ConcurrentHashMap<ay, File> e;
  private static List<Runnable> g = new ArrayList();
  private ax a = null;
  private m c = new m(new aa(), new u(new y()));
  private h d = new h(false);
  private ConcurrentHashMap<String, b> f;
  private CountDownTimer h;
  
  private az(Context paramContext)
  {
    e = new ConcurrentHashMap();
    this.f = new ConcurrentHashMap();
    j();
    this.a.addObserver(this);
  }
  
  private ay a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.d.a(this.d.g(), paramString);
      localObject1 = localObject2;
      if (paramString.c()) {
        localObject1 = ay.a(paramString);
      }
    }
    return (ay)localObject1;
  }
  
  public static az a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new az(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private void a(ay paramay)
  {
    Object localObject;
    if (paramay != null)
    {
      if (!paramay.l()) {
        break label129;
      }
      localObject = (b)this.f.get(paramay.h());
      if ((localObject == null) || (TextUtils.isEmpty(((b)localObject).b())) || (!((b)localObject).c())) {
        break label106;
      }
      paramay = ((b)localObject).a(paramay);
      localObject = ((b)localObject).a();
      localObject = this.d.a(this.d.g(), (String)localObject, paramay.u());
    }
    for (;;)
    {
      if (((paramay.l()) || (paramay.n())) && (localObject != null)) {
        e.put(paramay, localObject);
      }
      return;
      label106:
      localObject = this.d.a(this.d.g(), null, paramay.u());
      continue;
      label129:
      localObject = null;
    }
  }
  
  private void a(ay paramay, i parami, CBError paramCBError, boolean paramBoolean)
  {
    if (paramay == null) {
      return;
    }
    e.b localb1 = e.a("endpoint", paramay.h());
    if (parami == null)
    {
      parami = "None";
      e.b localb2 = e.a("statuscode", parami);
      if (paramCBError != null) {
        break label135;
      }
      parami = "None";
      label38:
      e.b localb3 = e.a("error", parami);
      if (paramCBError != null) {
        break label143;
      }
      parami = "None";
      label53:
      parami = e.a(new e.b[] { localb1, localb2, localb3, e.a("errorDescription", parami), e.a("retryCount", Integer.valueOf(paramay.p())) });
      if (!paramBoolean) {
        break label151;
      }
    }
    label135:
    label143:
    label151:
    for (paramay = "success";; paramay = "failure")
    {
      com.chartboost.sdk.Tracking.a.a("request_manager", "request", paramay, null, null, null, parami.e());
      return;
      parami = Integer.valueOf(parami.a);
      break;
      parami = paramCBError.a();
      break label38;
      parami = paramCBError.b();
      break label53;
    }
  }
  
  public static void b()
  {
    Object localObject1 = new ArrayList();
    try
    {
      ((List)localObject1).addAll(g);
      g.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Runnable)((Iterator)localObject1).next()).run();
      }
      return;
    }
    finally {}
  }
  
  private void j()
  {
    b localb = new b();
    localb.a("track_info");
    localb.a(true);
    this.f.put("/post-install-event/".concat("tracking"), localb);
  }
  
  public m a()
  {
    return this.c;
  }
  
  protected void a(ay paramay, ay.c paramc)
  {
    if (paramay == null) {}
    CBError localCBError;
    do
    {
      do
      {
        return;
        if (this.a.c()) {
          break;
        }
        localCBError = new CBError(CBError.a.b, "Internet Unavailable");
        paramay.d(false);
      } while (paramay.i());
      if (paramay.q())
      {
        paramay.c(false);
        a(paramay);
      }
      a(paramay, null, localCBError, false);
    } while (paramc == null);
    CBLogging.b("Network failure", String.format("request %s failed with error : %s", new Object[] { paramay.h(), localCBError.b() }));
    paramc.a(e.a.a, paramay, localCBError);
    return;
    if ((!paramay.i()) && (paramay.q()))
    {
      paramay.c(false);
      a(paramay);
    }
    a(new e(paramay));
  }
  
  /* Error */
  public void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc -29
    //   4: monitorenter
    //   5: invokestatic 332	com/chartboost/sdk/Libraries/c:c	()Lcom/chartboost/sdk/Libraries/c$a;
    //   8: astore_3
    //   9: aload_3
    //   10: getstatic 337	com/chartboost/sdk/Libraries/c$a:a	Lcom/chartboost/sdk/Libraries/c$a;
    //   13: if_acmpeq +10 -> 23
    //   16: aload_3
    //   17: getstatic 339	com/chartboost/sdk/Libraries/c$a:b	Lcom/chartboost/sdk/Libraries/c$a;
    //   20: if_acmpne +27 -> 47
    //   23: getstatic 47	com/chartboost/sdk/impl/az:g	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 343 2 0
    //   32: pop
    //   33: ldc -29
    //   35: monitorexit
    //   36: iload_2
    //   37: ifeq +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 254 1 0
    //   46: return
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -16 -> 33
    //   52: astore_1
    //   53: ldc -29
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	az
    //   0	58	1	paramRunnable	Runnable
    //   1	48	2	i	int
    //   8	9	3	locala	com.chartboost.sdk.Libraries.c.a
    // Exception table:
    //   from	to	target	type
    //   5	23	52	finally
    //   23	33	52	finally
    //   33	36	52	finally
    //   53	56	52	finally
  }
  
  public void c()
  {
    int i = 0;
    ay localay1;
    try
    {
      if ((e != null) && (!e.isEmpty()))
      {
        Iterator localIterator = e.keySet().iterator();
        while (localIterator.hasNext())
        {
          localay1 = (ay)localIterator.next();
          if ((localay1 != null) && (!localay1.r()))
          {
            localay1.a(localay1.p() + 1);
            localay1.a(localay1.s());
          }
        }
      }
      localObject2 = this.d.g();
    }
    finally {}
    if (localObject2 == null) {
      return;
    }
    Object localObject2 = this.d.g().list();
    int j;
    if (localObject2 != null) {
      j = localObject2.length;
    }
    for (;;)
    {
      if (i < j)
      {
        localay1 = localObject2[i];
        ay localay2 = a(localay1);
        if (localay2 != null)
        {
          e.put(localay2, this.d.c(this.d.g(), localay1));
          localay2.c(false);
          localay2.a(localay2.p() + 1);
          localay2.a(localay2.s());
        }
      }
      else
      {
        e();
        break;
      }
      i += 1;
    }
  }
  
  public void d()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.d != null)
        {
          String[] arrayOfString = this.d.c(this.d.g());
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            int j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              Object localObject3 = arrayOfString[i];
              e.a locala = this.d.a(this.d.g(), (String)localObject3);
              if (!locala.c()) {
                break label152;
              }
              this.d.b(this.d.g(), (String)localObject3);
              localObject3 = ay.a(locala);
              if (localObject3 != null)
              {
                ((ay)localObject3).a(true);
                ((ay)localObject3).t();
              }
              else
              {
                CBLogging.b("CBRequestManager", "Error processing video completion event");
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        CBLogging.b("CBRequestManager", "Error executing saved requests", localException);
        return;
      }
      finally {}
      Object localObject2 = null;
      continue;
      label152:
      i += 1;
    }
  }
  
  public void e()
  {
    if (this.h == null) {
      this.h = new CountDownTimer(240000L, 1000L)
      {
        public void onFinish()
        {
          az.this.c();
        }
        
        public void onTick(long paramAnonymousLong) {}
      }.start();
    }
  }
  
  public void f()
  {
    CBLogging.a("CBRequestManager", "Timer stopped:");
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
  }
  
  public ConcurrentHashMap<ay, File> g()
  {
    return e;
  }
  
  public h h()
  {
    return this.d;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.h != null) {
      f();
    }
    c();
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private class b
  {
    private String b = null;
    private int c = 50;
    private String d = Long.toString(System.nanoTime());
    private az.a e = az.a.a;
    private boolean f = false;
    private JSONArray g = null;
    private ay h;
    
    public b() {}
    
    public ay a(ay paramay)
    {
      for (;;)
      {
        e.a locala;
        try
        {
          locala = paramay.j();
          localay = paramay;
          if (locala.c())
          {
            locala = locala.a(this.b);
            boolean bool = locala.b();
            if (bool) {
              localay = paramay;
            }
          }
          else
          {
            return localay;
          }
          localay = paramay;
          if (this.e != az.a.a) {
            continue;
          }
          if ((az.d(az.this).c()) || ((this.h != null) && (this.h.r())))
          {
            this.d = Long.toString(System.nanoTime());
            paramay.a(this.b, new JSONArray().put(locala.e()));
            localay = paramay;
            continue;
          }
          if (this.g.length() != this.c) {
            break label165;
          }
        }
        finally {}
        this.d = Long.toString(System.nanoTime());
        this.g = new JSONArray();
        label165:
        this.g.put(locala.e());
        if (this.h != null) {
          az.i().remove(this.h);
        }
        paramay.a(this.b, this.g);
        this.h = paramay;
        ay localay = this.h;
      }
    }
    
    public String a()
    {
      return this.d;
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
    }
    
    public void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public void b(ay paramay)
    {
      this.h = paramay;
    }
    
    public boolean c()
    {
      return this.f;
    }
    
    public void d()
    {
      this.g = new JSONArray();
    }
  }
  
  public static class c
    extends s
  {
    private CBError b;
    
    public c(CBError paramCBError)
    {
      this.b = paramCBError;
    }
  }
  
  public static class d
  {
    private e.a a;
    private i b;
    
    public d(e.a parama, i parami)
    {
      this.a = parama;
      this.b = parami;
    }
  }
  
  private class e
    implements Runnable
  {
    private ay b;
    
    public e(ay paramay)
    {
      this.b = paramay;
    }
    
    public void run()
    {
      this.b.d();
      this.b.e();
      Object localObject = String.format("%s%s", new Object[] { "https://live.chartboost.com", this.b.f() });
      this.b.a();
      localObject = new a(1, (String)localObject, this.b);
      ((a)localObject).a(new d(10000, 1, 1.0F));
      ((a)localObject).a(false);
      az.a(az.this).a((l)localObject);
    }
    
    private class a
      extends l<az.d>
    {
      private ay b;
      
      public a(int paramInt, String paramString, ay paramay)
      {
        super(paramString, null);
        this.b = paramay;
      }
      
      protected n<az.d> a(i parami)
      {
        Object localObject3 = e.a.a;
        int i = parami.a;
        Object localObject1;
        if ((i > 300) && (i < 200))
        {
          CBLogging.b("CBRequestManager", "Request " + this.b.h() + " failed. Response code: " + i);
          localObject1 = new CBError(CBError.a.e, "Request failed. Response code: " + i + " is not valid ");
        }
        for (;;)
        {
          if ((((e.a)localObject3).c()) && (localObject1 == null)) {
            return n.a(new az.d(e.a.a(localObject3), parami), null);
          }
          e.a locala;
          for (;;)
          {
            try
            {
              localObject1 = parami.b;
              if (localObject1 == null) {
                break label392;
              }
              localObject1 = new String((byte[])localObject1);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = new JSONObject(new JSONTokener((String)localObject1));
              locala = e.a.a(localObject1);
              try
              {
                localObject3 = this.b.m();
                CBLogging.c("CBRequestManager", "Request " + this.b.h() + " succeeded. Response code: " + i + ", body: " + ((JSONObject)localObject1).toString(4));
                if (locala.f("status") == 404)
                {
                  localObject1 = new CBError(CBError.a.g, "404 error from server");
                }
                else
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  if ((localObject3 != null) && (!((g.a)localObject3).a(locala, localStringBuilder)))
                  {
                    localObject1 = new CBError(CBError.a.d, "Json response failed validation");
                    CBLogging.b("CBRequestManager", "Json response failed validation: " + localStringBuilder.toString());
                  }
                }
              }
              catch (Exception localException1)
              {
                localObject3 = locala;
              }
            }
            catch (Exception localException2)
            {
              CBError localCBError;
              continue;
            }
            localCBError = new CBError(CBError.a.a, localException1.getLocalizedMessage());
            break;
            localCBError = new CBError(CBError.a.c, "Response is not a valid json object");
            break;
            return n.a(new az.c(localException2));
            Object localObject2 = null;
            break label397;
            label392:
            localObject2 = null;
          }
          label397:
          localObject3 = locala;
        }
      }
      
      protected void a(az.d paramd)
      {
        if ((az.e.a(az.e.this).s() != null) && (paramd != null)) {
          az.e.a(az.e.this).s().a(az.d.a(paramd), az.e.a(az.e.this));
        }
        if (!az.e.a(az.e.this).i())
        {
          az.b(az.this).e((File)az.i().get(az.e.a(az.e.this)));
          az.i().remove(az.e.a(az.e.this));
          az.b localb = (az.b)az.c(az.this).get(az.e.a(az.e.this).h());
          if ((localb != null) && (!TextUtils.isEmpty(localb.b())) && (localb.c()) && (az.b.a(localb) == az.e.a(az.e.this)))
          {
            localb.d();
            localb.b(null);
          }
          az.e.a(az.e.this).d(false);
          az.a(az.this, az.e.a(az.e.this), az.d.b(paramd), null, true);
        }
      }
      
      public void b(s params)
      {
        if ((az.e.a(az.e.this) != null) && (!c.n()) && (!az.e.a(az.e.this).i()) && (az.i().containsKey(az.e.a(az.e.this))))
        {
          az.b(az.this).e((File)az.i().get(az.e.a(az.e.this)));
          az.i().remove(az.e.a(az.e.this));
        }
        if (params == null) {}
        CBError localCBError;
        e.a locala3;
        label283:
        do
        {
          return;
          if ((params instanceof az.c)) {}
          for (localCBError = az.c.a((az.c)params);; localCBError = new CBError(CBError.a.e, params.getMessage()))
          {
            locala3 = e.a.a;
            e.a locala1 = locala3;
            if (params != null) {
              locala1 = locala3;
            }
            try
            {
              if (params.a != null)
              {
                locala1 = locala3;
                if (params.a.b != null)
                {
                  locala1 = locala3;
                  if (params.a.b.length > 0) {
                    locala1 = e.a.k(new String(params.a.b));
                  }
                }
              }
            }
            catch (Exception localException)
            {
              e.a locala2;
              for (;;)
              {
                CBLogging.d("CBRequestManager", "unable to read error json", localException);
                locala2 = locala3;
              }
              if (az.e.a(az.e.this).s() == null) {
                break label283;
              }
              az.e.a(az.e.this).s().a(locala2, az.e.a(az.e.this), localCBError);
            }
            if ((params.a == null) || (params.a.a != 200)) {
              break;
            }
            a(new az.d(locala1, params.a));
            return;
          }
        } while (az.e.a(az.e.this).i());
        az.e.a(az.e.this).d(false);
        az.a(az.this, az.e.a(az.e.this), params.a, localCBError, false);
      }
      
      public Map<String, String> i()
        throws a
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = this.b.k().entrySet().iterator();
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
      
      public String p()
      {
        String str2 = this.b.c();
        String str1 = str2;
        if (str2 == null) {
          str1 = "application/json; charset=utf-8";
        }
        return str1;
      }
      
      public byte[] q()
      {
        if (this.b.j() == null) {}
        for (String str = "";; str = this.b.j().toString()) {
          return str.getBytes();
        }
      }
      
      public l.a s()
      {
        return this.b.o();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */