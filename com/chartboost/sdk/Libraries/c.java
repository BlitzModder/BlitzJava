package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.chartboost.sdk.impl.az;
import java.util.UUID;
import org.json.JSONObject;

public final class c
{
  private static String a = null;
  private static String b = null;
  private static a c = a.a;
  private static String d = null;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 34
    //   2: monitorenter
    //   3: invokestatic 37	com/chartboost/sdk/Libraries/c:c	()Lcom/chartboost/sdk/Libraries/c$a;
    //   6: getstatic 22	com/chartboost/sdk/Libraries/c$a:a	Lcom/chartboost/sdk/Libraries/c$a;
    //   9: if_acmpeq +7 -> 16
    //   12: ldc 34
    //   14: monitorexit
    //   15: return
    //   16: getstatic 39	com/chartboost/sdk/Libraries/c$a:b	Lcom/chartboost/sdk/Libraries/c$a;
    //   19: invokestatic 42	com/chartboost/sdk/Libraries/c:a	(Lcom/chartboost/sdk/Libraries/c$a;)V
    //   22: ldc 34
    //   24: monitorexit
    //   25: aconst_null
    //   26: astore_0
    //   27: ldc 44
    //   29: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +28 -> 64
    //   39: new 32	java/lang/ClassNotFoundException
    //   42: dup
    //   43: ldc 52
    //   45: invokespecial 55	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 58	java/lang/ClassNotFoundException:printStackTrace	()V
    //   54: invokestatic 61	com/chartboost/sdk/Libraries/c:h	()V
    //   57: return
    //   58: astore_0
    //   59: ldc 34
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    //   64: invokestatic 66	com/chartboost/sdk/impl/aw:a	()Ljava/util/concurrent/ExecutorService;
    //   67: new 6	com/chartboost/sdk/Libraries/c$1
    //   70: dup
    //   71: invokespecial 67	com/chartboost/sdk/Libraries/c$1:<init>	()V
    //   74: invokeinterface 73 2 0
    //   79: return
    //   80: astore_1
    //   81: goto -46 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	10	0	localObject1	Object
    //   49	2	0	localClassNotFoundException1	ClassNotFoundException
    //   58	5	0	localObject2	Object
    //   32	2	1	localClass	Class
    //   80	1	1	localClassNotFoundException2	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   39	49	49	java/lang/ClassNotFoundException
    //   3	15	58	finally
    //   16	25	58	finally
    //   59	62	58	finally
    //   27	33	80	java/lang/ClassNotFoundException
  }
  
  protected static void a(a parama)
  {
    try
    {
      c = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static String b()
  {
    if (a == null) {
      a = i();
    }
    return a;
  }
  
  private static void b(String paramString)
  {
    try
    {
      b = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static a c()
  {
    try
    {
      a locala = c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String d()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String e()
  {
    return Settings.Secure.getString(com.chartboost.sdk.c.y().getContentResolver(), "android_id");
  }
  
  public static String f()
  {
    return b.b(b.a(k()));
  }
  
  private static void h()
  {
    CBLogging.b("CBIdentity", "WARNING: It looks like you've forgotten to include the Google Play Services library in your project. Please review the SDK documentation for more details.");
    a(a.c);
    az.b();
  }
  
  private static String i()
  {
    Object localObject2 = e();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"9774d56d682e549c".equals(localObject2)) {}
    }
    else
    {
      localObject1 = j();
    }
    localObject2 = f();
    String str = d();
    e.a locala = e.a.a();
    locala.a("uuid", localObject1);
    locala.a("macid", localObject2);
    locala.a("gaid", str);
    localObject2 = locala.e();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    return Base64.encodeToString(((JSONObject)localObject1).toString().getBytes(), 0);
  }
  
  private static String j()
  {
    if (d == null)
    {
      Object localObject = CBUtility.a();
      d = ((SharedPreferences)localObject).getString("cbUUID", null);
      if (d == null)
      {
        d = UUID.randomUUID().toString();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("cbUUID", d);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    return d;
  }
  
  private static byte[] k()
  {
    try
    {
      Object localObject = ((WifiManager)com.chartboost.sdk.c.y().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        String[] arrayOfString = ((String)localObject).split(":");
        byte[] arrayOfByte2 = new byte[6];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfByte2;
          if (i >= arrayOfString.length) {
            break;
          }
          arrayOfByte2[i] = Integer.valueOf(Integer.parseInt(arrayOfString[i], 16)).byteValue();
          i += 1;
        }
      }
      arrayOfByte1 = null;
    }
    catch (Exception localException)
    {
      return null;
    }
    byte[] arrayOfByte1;
    return arrayOfByte1;
  }
  
  public static enum a
  {
    private int f;
    
    private a(int paramInt)
    {
      this.f = paramInt;
    }
    
    public int a()
    {
      return this.f;
    }
    
    public boolean b()
    {
      return this.f != -1;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */