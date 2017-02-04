package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.c;
import com.chartboost.sdk.d.b;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class ba
{
  private static ba c;
  private a a;
  private a b;
  
  private ba(a parama)
  {
    this.a = parama;
  }
  
  public static ba a(a parama)
  {
    if (c == null) {
      c = new ba(parama);
    }
    return c;
  }
  
  private void a(String paramString, Context paramContext, d.b paramb)
  {
    if ((this.b != null) && (this.b.a())) {
      this.b.c = a.e.f;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = c.y();
    }
    if (localContext == null) {
      if (this.a != null) {
        this.a.a(this.b, false, paramString, CBError.CBClickError.NO_HOST_ACTIVITY, paramb);
      }
    }
    for (;;)
    {
      return;
      try
      {
        paramContext = new Intent("android.intent.action.VIEW");
        if (!(localContext instanceof Activity)) {
          paramContext.addFlags(268435456);
        }
        paramContext.setData(Uri.parse(paramString));
        localContext.startActivity(paramContext);
        if (this.a == null) {
          continue;
        }
        this.a.a(this.b, true, paramString, null, paramb);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (paramString.startsWith("market://"))
          {
            paramContext = paramString;
            try
            {
              paramString = "http://market.android.com/" + paramString.substring(9);
              paramContext = paramString;
              Intent localIntent = new Intent("android.intent.action.VIEW");
              paramContext = paramString;
              if (!(localContext instanceof Activity))
              {
                paramContext = paramString;
                localIntent.addFlags(268435456);
              }
              paramContext = paramString;
              localIntent.setData(Uri.parse(paramString));
              paramContext = paramString;
              localContext.startActivity(localIntent);
            }
            catch (Exception paramString)
            {
              CBLogging.b("CBURLOpener", "Exception raised openeing an inavld playstore URL", paramString);
            }
            if (this.a == null) {
              break;
            }
            this.a.a(this.b, false, paramContext, CBError.CBClickError.URI_UNRECOGNIZED, paramb);
            return;
          }
          if (this.a != null) {
            this.a.a(this.b, false, paramString, CBError.CBClickError.URI_UNRECOGNIZED, paramb);
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      Context localContext = c.y();
      Intent localIntent = new Intent("android.intent.action.VIEW");
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localIntent.setData(Uri.parse(paramString));
      int i = localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size();
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      CBLogging.b("CBURLOpener", "Cannot open URL", paramString);
    }
    return false;
  }
  
  public void a(a parama, final String paramString, final Activity paramActivity, final d.b paramb)
  {
    this.b = parama;
    Object localObject;
    try
    {
      localObject = new URI(paramString);
      localObject = ((URI)localObject).getScheme();
      if (localObject == null)
      {
        if (this.a != null) {
          this.a.a(parama, false, paramString, CBError.CBClickError.URI_INVALID, paramb);
        }
        return;
      }
    }
    catch (URISyntaxException paramActivity)
    {
      while (this.a == null) {}
      this.a.a(parama, false, paramString, CBError.CBClickError.URI_INVALID, paramb);
      return;
    }
    if ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))
    {
      a(paramString, paramActivity, paramb);
      return;
    }
    parama = new Runnable()
    {
      public void a(final String paramAnonymousString)
      {
        paramAnonymousString = new Runnable()
        {
          public void run()
          {
            ba.a(ba.this, paramAnonymousString, ba.1.this.b, ba.1.this.c);
          }
        };
        if (paramActivity != null)
        {
          paramActivity.runOnUiThread(paramAnonymousString);
          return;
        }
        CBUtility.e().post(paramAnonymousString);
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 26	com/chartboost/sdk/impl/ba$1:a	Ljava/lang/String;
        //   4: astore_1
        //   5: aload_1
        //   6: astore_2
        //   7: invokestatic 64	com/chartboost/sdk/impl/ax:a	()Lcom/chartboost/sdk/impl/ax;
        //   10: invokevirtual 67	com/chartboost/sdk/impl/ax:c	()Z
        //   13: ifeq +127 -> 140
        //   16: aconst_null
        //   17: astore_2
        //   18: aconst_null
        //   19: astore 4
        //   21: new 69	java/net/URL
        //   24: dup
        //   25: aload_0
        //   26: getfield 26	com/chartboost/sdk/impl/ba$1:a	Ljava/lang/String;
        //   29: invokespecial 71	java/net/URL:<init>	(Ljava/lang/String;)V
        //   32: invokevirtual 75	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   35: checkcast 77	java/net/HttpURLConnection
        //   38: astore_3
        //   39: aload_3
        //   40: iconst_0
        //   41: invokevirtual 81	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   44: aload_3
        //   45: sipush 10000
        //   48: invokevirtual 85	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   51: aload_3
        //   52: sipush 10000
        //   55: invokevirtual 88	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   58: aload_3
        //   59: ldc 90
        //   61: invokevirtual 94	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   64: astore_2
        //   65: aload_2
        //   66: ifnull +5 -> 71
        //   69: aload_2
        //   70: astore_1
        //   71: aload_1
        //   72: astore_2
        //   73: aload_3
        //   74: ifnull +66 -> 140
        //   77: aload_3
        //   78: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   81: aload_0
        //   82: aload_1
        //   83: invokevirtual 99	com/chartboost/sdk/impl/ba$1:a	(Ljava/lang/String;)V
        //   86: return
        //   87: astore_2
        //   88: aload 4
        //   90: astore_3
        //   91: aload_2
        //   92: astore 4
        //   94: aload_3
        //   95: astore_2
        //   96: ldc 101
        //   98: ldc 103
        //   100: aload 4
        //   102: invokestatic 108	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   105: aload_1
        //   106: astore_2
        //   107: aload_3
        //   108: ifnull +32 -> 140
        //   111: aload_3
        //   112: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   115: goto -34 -> 81
        //   118: astore_1
        //   119: aload_2
        //   120: ifnull +7 -> 127
        //   123: aload_2
        //   124: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   127: aload_1
        //   128: athrow
        //   129: astore_1
        //   130: aload_3
        //   131: astore_2
        //   132: goto -13 -> 119
        //   135: astore 4
        //   137: goto -43 -> 94
        //   140: aload_2
        //   141: astore_1
        //   142: goto -61 -> 81
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	1
        //   4	102	1	localObject1	Object
        //   118	10	1	localObject2	Object
        //   129	1	1	localObject3	Object
        //   141	1	1	localObject4	Object
        //   6	67	2	localObject5	Object
        //   87	5	2	localException1	Exception
        //   95	46	2	localObject6	Object
        //   38	93	3	localObject7	Object
        //   19	82	4	localException2	Exception
        //   135	1	4	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   21	39	87	java/lang/Exception
        //   21	39	118	finally
        //   96	105	118	finally
        //   39	65	129	finally
        //   39	65	135	java/lang/Exception
      }
    };
    aw.a().execute(parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, boolean paramBoolean, String paramString, CBError.CBClickError paramCBClickError, d.b paramb);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */