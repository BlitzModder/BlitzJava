package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.b;
import com.chartboost.sdk.c;
import com.chartboost.sdk.d;
import com.chartboost.sdk.d.b;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.ba.a;
import com.chartboost.sdk.impl.l.a;
import com.chartboost.sdk.impl.m;
import com.chartboost.sdk.impl.n.a;
import com.chartboost.sdk.impl.n.b;
import com.chartboost.sdk.impl.s;
import com.chartboost.sdk.impl.z;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class a
{
  private static final String a = a.class.getSimpleName();
  private static ArrayList<CBInPlay> b;
  private static int c = 4;
  private static a d;
  private static LinkedHashMap<String, Bitmap> e;
  private static volatile boolean f = false;
  
  private a()
  {
    b = new ArrayList();
    e = new LinkedHashMap(c);
  }
  
  public static a a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new a();
      }
      return d;
    }
    finally {}
  }
  
  private void a(CBInPlay paramCBInPlay, String paramString, boolean paramBoolean)
  {
    try
    {
      paramCBInPlay.a((Bitmap)e.get(paramString));
      b.add(paramCBInPlay);
      paramString = c.h();
      if ((paramString != null) && (paramBoolean)) {
        paramString.didCacheInPlay(paramCBInPlay.getLocation());
      }
      if ((!e()) && (!f)) {
        a(paramCBInPlay.getLocation(), false);
      }
      return;
    }
    finally {}
  }
  
  private void a(final String paramString, final boolean paramBoolean)
  {
    f = true;
    ay localay = new ay("/inplay/get");
    localay.a("raw", Boolean.valueOf(true));
    localay.a("cache", Boolean.valueOf(true));
    localay.a(l.a.c);
    localay.b(true);
    localay.a("location", paramString);
    localay.a(b.e);
    localay.a(new ay.c()
    {
      public void a(e.a paramAnonymousa, ay paramAnonymousay)
      {
        a.a(false);
        if (paramAnonymousa.c())
        {
          paramAnonymousay = new CBInPlay();
          paramAnonymousay.a(paramAnonymousa);
          paramAnonymousay.b(paramAnonymousa.e("name"));
          if (!TextUtils.isEmpty(paramString)) {
            paramAnonymousay.a(paramString);
          }
          paramAnonymousa = paramAnonymousa.a("icons");
          if ((paramAnonymousa.c()) && (!TextUtils.isEmpty(paramAnonymousa.e("lg"))))
          {
            paramAnonymousa = paramAnonymousa.e("lg");
            if (a.c().get(paramAnonymousa) != null) {
              break label180;
            }
            a.b localb = new a.b(a.this, null);
            a.a locala = new a.a(a.this, null);
            localb.c = paramAnonymousay;
            localb.b = paramAnonymousa;
            localb.a = paramBoolean;
            locala.a = paramString;
            paramAnonymousa = new z(paramAnonymousa, localb, 0, 0, null, locala);
            az.a(c.y()).a().a(paramAnonymousa);
          }
        }
        return;
        label180:
        a.a(a.this, paramAnonymousay, paramAnonymousa, true);
      }
      
      public void a(e.a paramAnonymousa, ay paramAnonymousay, CBError paramAnonymousCBError)
      {
        CBLogging.b(a.d(), "InPlay cache call failed" + paramAnonymousCBError);
        a.a(false);
        String str;
        if (c.h() != null)
        {
          paramAnonymousay = c.h();
          str = paramString;
          if (paramAnonymousCBError == null) {
            break label65;
          }
        }
        label65:
        for (paramAnonymousa = paramAnonymousCBError.c();; paramAnonymousa = null)
        {
          paramAnonymousay.didFailToLoadInPlay(str, paramAnonymousa);
          return;
        }
      }
    });
  }
  
  public static void b()
  {
    if (e != null) {
      e.clear();
    }
    if (b != null) {
      b.clear();
    }
  }
  
  private static boolean e()
  {
    return b.size() == c;
  }
  
  protected void a(CBInPlay paramCBInPlay)
  {
    e.a locala = paramCBInPlay.a();
    ay localay = new ay("/inplay/show");
    localay.a("inplay-dictionary", locala);
    localay.a("location", paramCBInPlay.getLocation());
    localay.a(true);
    localay.t();
    if (paramCBInPlay.a().c()) {
      locala.e("ad_id");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 94	com/chartboost/sdk/InPlay/a:e	()Z
    //   5: ifne +11 -> 16
    //   8: getstatic 40	com/chartboost/sdk/InPlay/a:f	Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: aload_1
    //   21: iconst_1
    //   22: invokespecial 97	com/chartboost/sdk/InPlay/a:a	(Ljava/lang/String;Z)V
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	a
    //   0	33	1	paramString	String
    //   11	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
    //   19	25	28	finally
  }
  
  protected void b(final CBInPlay paramCBInPlay)
  {
    final e.a locala = paramCBInPlay.a();
    Object localObject1;
    Object localObject2;
    if (locala != null)
    {
      localObject1 = locala.e("link");
      localObject2 = locala.e("deep-link");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    for (;;)
    {
      try
      {
        boolean bool = ba.a((String)localObject2);
        if (!bool) {
          break label113;
        }
        localObject1 = localObject2;
        paramCBInPlay = new d.b()
        {
          public void a()
          {
            ay localay = d.a().d();
            localay.a("location", paramCBInPlay.getLocation());
            localay.a("to", locala);
            localay.a("cgn", locala);
            localay.a("creative", locala);
            localay.a("ad_id", locala);
            localay.a("type", locala);
            localay.a("more_type", locala);
            localay.a(true);
            localay.t();
          }
        };
        localObject2 = d.a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label95;
        }
        ((d)localObject2).b(null, (String)localObject1, paramCBInPlay);
        return;
      }
      catch (Exception localException)
      {
        CBLogging.b(a, "Cannot open a url");
      }
      continue;
      label95:
      localException.b.a(null, false, (String)localObject1, CBError.CBClickError.URI_INVALID, paramCBInPlay);
      return;
      label113:
      continue;
      localObject1 = null;
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 49	com/chartboost/sdk/InPlay/a:b	Ljava/util/ArrayList;
    //   5: invokevirtual 156	java/util/ArrayList:size	()I
    //   8: istore_2
    //   9: iload_2
    //   10: ifle +9 -> 19
    //   13: iconst_1
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_3
    //   21: goto -6 -> 15
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	a
    //   0	29	1	paramString	String
    //   8	2	2	i	int
    //   14	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	24	finally
  }
  
  public CBInPlay c(String paramString)
  {
    CBInPlay localCBInPlay = null;
    try
    {
      if (b.size() > 0)
      {
        localCBInPlay = (CBInPlay)b.get(0);
        b.remove(0);
      }
      if ((!e()) && (!f)) {
        a(paramString, true);
      }
      if ((localCBInPlay == null) && (c.h() != null)) {
        c.h().didFailToLoadInPlay(paramString, CBError.CBImpressionError.NO_AD_FOUND);
      }
      return localCBInPlay;
    }
    finally {}
  }
  
  private class a
    implements n.a
  {
    protected String a;
    
    private a() {}
    
    public void a(s params)
    {
      CBLogging.b(a.d(), "Bitmap download failed " + params.getMessage());
      if (c.h() != null) {
        c.h().didFailToLoadInPlay(this.a, CBError.CBImpressionError.NETWORK_FAILURE);
      }
    }
  }
  
  private class b
    implements n.b<Bitmap>
  {
    protected boolean a;
    protected String b;
    protected CBInPlay c;
    
    private b() {}
    
    public void a(Bitmap paramBitmap)
    {
      a.c().put(this.b, paramBitmap);
      a.a(a.this, this.c, this.b, this.a);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/InPlay/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */