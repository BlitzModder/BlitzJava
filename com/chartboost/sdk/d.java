package com.chartboost.sdk;

import android.app.Activity;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.Model.a.d;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.ba.a;
import com.chartboost.sdk.impl.bo;
import com.chartboost.sdk.impl.bs;

public final class d
{
  private static final String c = d.class.getSimpleName();
  private static d d;
  public a.d a = new a.d()
  {
    public void a(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      boolean bool;
      synchronized (d.this)
      {
        bool = paramAnonymousa.j;
        if (paramAnonymousa.c != a.e.a) {
          break label75;
        }
        paramAnonymousa.c = a.e.b;
        if (paramAnonymousa.a == a.b.b)
        {
          paramAnonymousa.u().g(paramAnonymousa);
          paramAnonymousa.u().n(paramAnonymousa);
          return;
        }
      }
      if (bool) {
        paramAnonymousa.u().a(paramAnonymousa);
      }
      for (;;)
      {
        label75:
        if ((!bool) || (paramAnonymousa.c == a.e.c)) {
          paramAnonymousa.u().g(paramAnonymousa);
        }
        paramAnonymousa.u().n(paramAnonymousa);
        return;
        paramAnonymousa.u().p(paramAnonymousa);
      }
    }
    
    public void a(com.chartboost.sdk.Model.a paramAnonymousa, CBError.CBImpressionError paramAnonymousCBImpressionError)
    {
      e locale = paramAnonymousa.u();
      com.chartboost.sdk.Tracking.a.a(locale.f(), paramAnonymousa.e, paramAnonymousa.t(), paramAnonymousCBImpressionError);
      locale.a(paramAnonymousa, paramAnonymousCBImpressionError);
    }
    
    public void a(com.chartboost.sdk.Model.a paramAnonymousa, String paramAnonymousString, com.chartboost.sdk.Libraries.e.a paramAnonymousa1)
    {
      paramAnonymousa.u().b().a(paramAnonymousa);
      Object localObject;
      if ((!c.u()) && (paramAnonymousa.a()) && (paramAnonymousa.c == a.e.c))
      {
        localObject = Chartboost.h();
        if (localObject != null) {
          ((f)localObject).b(paramAnonymousa);
        }
      }
      int i;
      ay localay;
      if (!TextUtils.isEmpty(paramAnonymousString))
      {
        i = 1;
        if (i == 0) {
          break label436;
        }
        localObject = paramAnonymousa.A();
        localay = d.this.d();
        localay.a("ad_id", (com.chartboost.sdk.Libraries.e.a)localObject);
        localay.a("to", (com.chartboost.sdk.Libraries.e.a)localObject);
        localay.a("cgn", (com.chartboost.sdk.Libraries.e.a)localObject);
        localay.a("creative", (com.chartboost.sdk.Libraries.e.a)localObject);
        if ((paramAnonymousa.f == a.c.b) || (paramAnonymousa.f == a.c.c))
        {
          if ((paramAnonymousa.a != a.b.a) || (paramAnonymousa.m() == null)) {
            break label389;
          }
          localObject = (ah)paramAnonymousa.B();
        }
      }
      for (;;)
      {
        label164:
        float f1;
        if (localObject != null)
        {
          f1 = ((g)localObject).k();
          float f2 = ((g)localObject).j();
          CBLogging.a(paramAnonymousa.u().getClass().getSimpleName(), String.format("TotalDuration: %f PlaybackTime: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
          localay.a("total_time", Float.valueOf(f2 / 1000.0F));
          if (f1 <= 0.0F) {
            localay.a("playback_time", Float.valueOf(f2 / 1000.0F));
          }
        }
        else
        {
          label258:
          if (paramAnonymousa1 != null)
          {
            localay.a("cgn", paramAnonymousa1);
            localay.a("creative", paramAnonymousa1);
            localay.a("type", paramAnonymousa1);
            localay.a("more_type", paramAnonymousa1);
            paramAnonymousa1 = paramAnonymousa1.a("click_coordinates");
            if (!paramAnonymousa1.b()) {
              localay.a("click_coordinates", paramAnonymousa1);
            }
          }
          localay.a("location", paramAnonymousa.e);
          if (paramAnonymousa.e()) {
            localay.a("retarget_reinstall", Boolean.valueOf(paramAnonymousa.f()));
          }
          paramAnonymousa.r = localay;
          d.this.b(paramAnonymousa, paramAnonymousString, null);
        }
        for (;;)
        {
          com.chartboost.sdk.Tracking.a.b(paramAnonymousa.u().f(), paramAnonymousa.e, paramAnonymousa.t());
          return;
          i = 0;
          break;
          label389:
          if ((paramAnonymousa.a != a.b.b) || (paramAnonymousa.m() == null)) {
            break label458;
          }
          localObject = (bs)paramAnonymousa.B();
          break label164;
          localay.a("playback_time", Float.valueOf(f1 / 1000.0F));
          break label258;
          label436:
          d.this.b.a(paramAnonymousa, false, paramAnonymousString, CBError.CBClickError.URI_INVALID, null);
        }
        label458:
        localObject = null;
      }
    }
    
    public void b(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      f localf;
      if (paramAnonymousa.c == a.e.c)
      {
        localf = Chartboost.h();
        if (localf != null) {
          localf.b(paramAnonymousa);
        }
      }
      while (paramAnonymousa.C())
      {
        com.chartboost.sdk.Tracking.a.c(paramAnonymousa.u().f(), paramAnonymousa.e, paramAnonymousa.t());
        return;
        if ((paramAnonymousa.a == a.b.b) && (paramAnonymousa.c == a.e.b))
        {
          localf = Chartboost.h();
          if (localf != null) {
            localf.d(paramAnonymousa);
          }
        }
      }
      com.chartboost.sdk.Tracking.a.d(paramAnonymousa.u().f(), paramAnonymousa.e, paramAnonymousa.t());
    }
    
    public void c(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      paramAnonymousa.p = true;
      if ((paramAnonymousa.d == a.a.c) && (c.h() != null)) {
        c.h().didCompleteRewardedVideo(paramAnonymousa.e, paramAnonymousa.g);
      }
      d.a(paramAnonymousa);
    }
    
    public void d(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      paramAnonymousa.q = true;
    }
  };
  public ba.a b = new ba.a()
  {
    public void a(com.chartboost.sdk.Model.a paramAnonymousa, boolean paramAnonymousBoolean, String paramAnonymousString, CBError.CBClickError paramAnonymousCBClickError, d.b paramAnonymousb)
    {
      if (paramAnonymousa != null)
      {
        paramAnonymousa.s = false;
        if (paramAnonymousa.a()) {
          paramAnonymousa.c = a.e.e;
        }
      }
      if (!paramAnonymousBoolean) {
        if (c.h() != null) {
          c.h().didFailToRecordClick(paramAnonymousString, paramAnonymousCBClickError);
        }
      }
      do
      {
        return;
        if ((paramAnonymousa != null) && (paramAnonymousa.r != null))
        {
          paramAnonymousa.r.a(true);
          paramAnonymousa.r.t();
          return;
        }
      } while (paramAnonymousb == null);
      paramAnonymousb.a();
    }
  };
  private ba e = ba.a(this.b);
  
  public static d a()
  {
    if (d == null) {
      d = new d();
    }
    return d;
  }
  
  /* Error */
  private static void b(com.chartboost.sdk.Model.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 66	com/chartboost/sdk/impl/ay
    //   6: dup
    //   7: ldc 68
    //   9: invokespecial 71	com/chartboost/sdk/impl/ay:<init>	(Ljava/lang/String;)V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 73
    //   18: aload_0
    //   19: getfield 77	com/chartboost/sdk/Model/a:e	Ljava/lang/String;
    //   22: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   25: aload 5
    //   27: ldc 82
    //   29: aload_0
    //   30: getfield 86	com/chartboost/sdk/Model/a:g	I
    //   33: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   39: aload 5
    //   41: ldc 94
    //   43: aload_0
    //   44: getfield 97	com/chartboost/sdk/Model/a:h	Ljava/lang/String;
    //   47: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   50: aload 5
    //   52: ldc 99
    //   54: aload_0
    //   55: invokevirtual 102	com/chartboost/sdk/Model/a:t	()Ljava/lang/String;
    //   58: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   61: aload 5
    //   63: ldc 104
    //   65: iconst_0
    //   66: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   72: aconst_null
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 112	com/chartboost/sdk/Model/a:a	Lcom/chartboost/sdk/Model/a$b;
    //   79: getstatic 115	com/chartboost/sdk/Model/a$b:a	Lcom/chartboost/sdk/Model/a$b;
    //   82: if_acmpne +117 -> 199
    //   85: aload_0
    //   86: invokevirtual 119	com/chartboost/sdk/Model/a:m	()Lcom/chartboost/sdk/g$a;
    //   89: ifnull +110 -> 199
    //   92: aload_0
    //   93: invokevirtual 123	com/chartboost/sdk/Model/a:B	()Lcom/chartboost/sdk/g;
    //   96: checkcast 125	com/chartboost/sdk/impl/ah
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull +83 -> 184
    //   104: aload_3
    //   105: invokevirtual 131	com/chartboost/sdk/g:k	()F
    //   108: fstore_1
    //   109: aload_3
    //   110: invokevirtual 134	com/chartboost/sdk/g:j	()F
    //   113: fstore_2
    //   114: aload_0
    //   115: invokevirtual 138	com/chartboost/sdk/Model/a:u	()Lcom/chartboost/sdk/e;
    //   118: invokevirtual 142	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: invokevirtual 36	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   124: ldc -112
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: fload_2
    //   133: invokestatic 149	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: fload_1
    //   140: invokestatic 149	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   143: aastore
    //   144: invokestatic 155	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   147: invokestatic 160	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   150: aload 5
    //   152: ldc -94
    //   154: fload_2
    //   155: ldc -93
    //   157: fdiv
    //   158: invokestatic 149	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   161: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   164: fload_1
    //   165: fconst_0
    //   166: fcmpg
    //   167: ifgt +66 -> 233
    //   170: aload 5
    //   172: ldc -91
    //   174: fload_2
    //   175: ldc -93
    //   177: fdiv
    //   178: invokestatic 149	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   181: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   184: aload 5
    //   186: iconst_1
    //   187: invokevirtual 168	com/chartboost/sdk/impl/ay:a	(Z)V
    //   190: aload 5
    //   192: invokevirtual 170	com/chartboost/sdk/impl/ay:t	()V
    //   195: ldc 2
    //   197: monitorexit
    //   198: return
    //   199: aload 4
    //   201: astore_3
    //   202: aload_0
    //   203: getfield 112	com/chartboost/sdk/Model/a:a	Lcom/chartboost/sdk/Model/a$b;
    //   206: getstatic 172	com/chartboost/sdk/Model/a$b:b	Lcom/chartboost/sdk/Model/a$b;
    //   209: if_acmpne -109 -> 100
    //   212: aload 4
    //   214: astore_3
    //   215: aload_0
    //   216: invokevirtual 119	com/chartboost/sdk/Model/a:m	()Lcom/chartboost/sdk/g$a;
    //   219: ifnull -119 -> 100
    //   222: aload_0
    //   223: invokevirtual 123	com/chartboost/sdk/Model/a:B	()Lcom/chartboost/sdk/g;
    //   226: checkcast 174	com/chartboost/sdk/impl/bs
    //   229: astore_3
    //   230: goto -130 -> 100
    //   233: aload 5
    //   235: ldc -91
    //   237: fload_1
    //   238: ldc -93
    //   240: fdiv
    //   241: invokestatic 149	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   244: invokevirtual 80	com/chartboost/sdk/impl/ay:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   247: goto -63 -> 184
    //   250: astore_0
    //   251: ldc 2
    //   253: monitorexit
    //   254: aload_0
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	parama	com.chartboost.sdk.Model.a
    //   108	130	1	f1	float
    //   113	62	2	f2	float
    //   99	131	3	localObject1	Object
    //   73	140	4	localObject2	Object
    //   12	222	5	localay	ay
    // Exception table:
    //   from	to	target	type
    //   3	72	250	finally
    //   75	100	250	finally
    //   104	164	250	finally
    //   170	184	250	finally
    //   184	195	250	finally
    //   202	212	250	finally
    //   215	230	250	finally
    //   233	247	250	finally
  }
  
  public final void a(com.chartboost.sdk.Model.a parama, String paramString, b paramb)
  {
    this.e.a(parama, paramString, Chartboost.getHostActivity(), paramb);
  }
  
  public final boolean a(Activity paramActivity, com.chartboost.sdk.Model.a parama)
  {
    if (parama != null) {
      switch (4.a[parama.c.ordinal()])
      {
      }
    }
    for (;;)
    {
      return true;
      if (parama.m)
      {
        Chartboost.a(parama);
        continue;
        Chartboost.a(parama);
        continue;
        if (!parama.i())
        {
          if ((c.b() != null) && (c.b().doesWrapperUseCustomBackgroundingBehavior()) && (!(paramActivity instanceof CBImpressionActivity))) {
            return false;
          }
          paramActivity = Chartboost.h();
          if (paramActivity != null)
          {
            CBLogging.b(c, "Error onActivityStart " + parama.c.name());
            paramActivity.d(parama);
          }
        }
      }
    }
  }
  
  public final void b(final com.chartboost.sdk.Model.a parama, final String paramString, final b paramb)
  {
    c.b = new a()
    {
      public void a(final boolean paramAnonymousBoolean)
      {
        Chartboost.a(new Runnable()
        {
          public void run()
          {
            if (d.1.this.a != null)
            {
              if (d.1.this.a.b()) {
                d.1.this.a.p();
              }
              if (!paramAnonymousBoolean) {
                d.1.this.a.x();
              }
              if ((d.1.this.a.a()) && (d.1.this.a.c == a.e.c))
              {
                f localf = Chartboost.h();
                if (localf != null) {
                  localf.b(d.1.this.a);
                }
              }
            }
            if (paramAnonymousBoolean)
            {
              d.this.a(d.1.this.a, d.1.this.b, d.1.this.c);
              return;
            }
            d.this.b.a(d.1.this.a, false, d.1.this.b, CBError.CBClickError.AGE_GATE_FAILURE, d.1.this.c);
          }
        });
      }
    };
    if (!c.u()) {
      a(parama, paramString, paramb);
    }
    while (c.h() == null) {
      return;
    }
    if (parama != null)
    {
      if (parama.b()) {
        parama.q();
      }
      parama.z();
      parama.s = false;
    }
    if (parama == null)
    {
      c.h().didPauseClickForConfirmation(Chartboost.getHostActivity());
      return;
    }
    c.h().didPauseClickForConfirmation(Chartboost.f());
  }
  
  protected final boolean b()
  {
    com.chartboost.sdk.Model.a locala = c();
    if (locala == null) {
      return false;
    }
    locala.u = true;
    this.a.b(locala);
    return true;
  }
  
  protected final com.chartboost.sdk.Model.a c()
  {
    Object localObject = Chartboost.h();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((f)localObject).e()) {
      return null;
    }
    return ((bo)localObject).h();
  }
  
  public ay d()
  {
    ay localay = new ay("/api/click");
    if (Chartboost.f() == null) {
      Chartboost.getValidContext();
    }
    return localay;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */