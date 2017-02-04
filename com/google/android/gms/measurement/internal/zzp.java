package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class zzp
  extends zzw
{
  public zzp(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private byte[] zzc(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = arrayOfByte;
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = paramHttpURLConnection;
      arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
    }
    finally
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    return arrayOfByte;
  }
  
  public void zza(URL paramURL, byte[] paramArrayOfByte, zza paramzza)
  {
    zziS();
    zzje();
    zzx.zzy(paramURL);
    zzx.zzy(paramArrayOfByte);
    zzx.zzy(paramzza);
    zzAV().zzh(new zzc(paramURL, paramArrayOfByte, paramzza));
  }
  
  protected HttpURLConnection zzc(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection)) {
      throw new IOException("Failed to obtain HTTP connection");
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout((int)zzAX().zzAB());
    paramURL.setReadTimeout((int)zzAX().zzAC());
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setDoInput(true);
    return paramURL;
  }
  
  protected void zzir() {}
  
  public boolean zzlk()
  {
    zzje();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected())) {
        return true;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return false;
  }
  
  static abstract interface zza
  {
    public abstract void zza(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte);
  }
  
  private static class zzb
    implements Runnable
  {
    private final int zzAk;
    private final zzp.zza zzaTv;
    private final Throwable zzaTw;
    private final byte[] zzaTx;
    
    private zzb(zzp.zza paramzza, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
    {
      this.zzaTv = paramzza;
      this.zzAk = paramInt;
      this.zzaTw = paramThrowable;
      this.zzaTx = paramArrayOfByte;
    }
    
    public void run()
    {
      this.zzaTv.zza(this.zzAk, this.zzaTw, this.zzaTx);
    }
  }
  
  private class zzc
    implements Runnable
  {
    private final byte[] zzaTy;
    private final zzp.zza zzaTz;
    private final URL zzyR;
    
    public zzc(URL paramURL, byte[] paramArrayOfByte, zzp.zza paramzza)
    {
      this.zzyR = paramURL;
      this.zzaTy = paramArrayOfByte;
      this.zzaTz = paramzza;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   4: invokevirtual 37	com/google/android/gms/measurement/internal/zzp:zzAR	()V
      //   7: iconst_0
      //   8: istore_3
      //   9: iconst_0
      //   10: istore 5
      //   12: iconst_0
      //   13: istore 4
      //   15: aload_0
      //   16: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   19: invokevirtual 41	com/google/android/gms/measurement/internal/zzp:zzAU	()Lcom/google/android/gms/measurement/internal/zzae;
      //   22: aload_0
      //   23: getfield 28	com/google/android/gms/measurement/internal/zzp$zzc:zzaTy	[B
      //   26: invokevirtual 47	com/google/android/gms/measurement/internal/zzae:zzg	([B)[B
      //   29: astore 8
      //   31: aload_0
      //   32: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   35: aload_0
      //   36: getfield 26	com/google/android/gms/measurement/internal/zzp$zzc:zzyR	Ljava/net/URL;
      //   39: invokevirtual 50	com/google/android/gms/measurement/internal/zzp:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
      //   42: astore 6
      //   44: iload_3
      //   45: istore_2
      //   46: iload 5
      //   48: istore_1
      //   49: aload 6
      //   51: iconst_1
      //   52: invokevirtual 56	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   55: iload_3
      //   56: istore_2
      //   57: iload 5
      //   59: istore_1
      //   60: aload 6
      //   62: ldc 58
      //   64: ldc 60
      //   66: invokevirtual 64	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   69: iload_3
      //   70: istore_2
      //   71: iload 5
      //   73: istore_1
      //   74: aload 6
      //   76: aload 8
      //   78: arraylength
      //   79: invokevirtual 68	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
      //   82: iload_3
      //   83: istore_2
      //   84: iload 5
      //   86: istore_1
      //   87: aload 6
      //   89: invokevirtual 71	java/net/HttpURLConnection:connect	()V
      //   92: iload_3
      //   93: istore_2
      //   94: iload 5
      //   96: istore_1
      //   97: aload 6
      //   99: invokevirtual 75	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   102: astore 7
      //   104: aload 7
      //   106: aload 8
      //   108: invokevirtual 81	java/io/OutputStream:write	([B)V
      //   111: aload 7
      //   113: invokevirtual 84	java/io/OutputStream:close	()V
      //   116: iload_3
      //   117: istore_2
      //   118: iload 5
      //   120: istore_1
      //   121: aload 6
      //   123: invokevirtual 88	java/net/HttpURLConnection:getResponseCode	()I
      //   126: istore_3
      //   127: iload_3
      //   128: istore_2
      //   129: iload_3
      //   130: istore_1
      //   131: aload_0
      //   132: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   135: aload 6
      //   137: invokestatic 92	com/google/android/gms/measurement/internal/zzp:zza	(Lcom/google/android/gms/measurement/internal/zzp;Ljava/net/HttpURLConnection;)[B
      //   140: astore 8
      //   142: iconst_0
      //   143: ifeq +11 -> 154
      //   146: new 94	java/lang/NullPointerException
      //   149: dup
      //   150: invokespecial 95	java/lang/NullPointerException:<init>	()V
      //   153: athrow
      //   154: aload 6
      //   156: ifnull +8 -> 164
      //   159: aload 6
      //   161: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   164: aload_0
      //   165: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   168: invokevirtual 102	com/google/android/gms/measurement/internal/zzp:zzAV	()Lcom/google/android/gms/measurement/internal/zzs;
      //   171: new 104	com/google/android/gms/measurement/internal/zzp$zzb
      //   174: dup
      //   175: aload_0
      //   176: getfield 30	com/google/android/gms/measurement/internal/zzp$zzc:zzaTz	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   179: iload_3
      //   180: aconst_null
      //   181: aload 8
      //   183: aconst_null
      //   184: invokespecial 107	com/google/android/gms/measurement/internal/zzp$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzp$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzp$1;)V
      //   187: invokevirtual 112	com/google/android/gms/measurement/internal/zzs:zzg	(Ljava/lang/Runnable;)V
      //   190: return
      //   191: astore 7
      //   193: aload_0
      //   194: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   197: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   200: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   203: ldc 124
      //   205: aload 7
      //   207: invokevirtual 130	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   210: goto -56 -> 154
      //   213: astore 6
      //   215: iconst_0
      //   216: istore_1
      //   217: aconst_null
      //   218: astore 7
      //   220: aconst_null
      //   221: astore 8
      //   223: aload 7
      //   225: ifnull +8 -> 233
      //   228: aload 7
      //   230: invokevirtual 84	java/io/OutputStream:close	()V
      //   233: aload 8
      //   235: ifnull +8 -> 243
      //   238: aload 8
      //   240: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   243: aload_0
      //   244: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   247: invokevirtual 102	com/google/android/gms/measurement/internal/zzp:zzAV	()Lcom/google/android/gms/measurement/internal/zzs;
      //   250: new 104	com/google/android/gms/measurement/internal/zzp$zzb
      //   253: dup
      //   254: aload_0
      //   255: getfield 30	com/google/android/gms/measurement/internal/zzp$zzc:zzaTz	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   258: iload_1
      //   259: aload 6
      //   261: aconst_null
      //   262: aconst_null
      //   263: invokespecial 107	com/google/android/gms/measurement/internal/zzp$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzp$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzp$1;)V
      //   266: invokevirtual 112	com/google/android/gms/measurement/internal/zzs:zzg	(Ljava/lang/Runnable;)V
      //   269: return
      //   270: astore 7
      //   272: aload_0
      //   273: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   276: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   279: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   282: ldc 124
      //   284: aload 7
      //   286: invokevirtual 130	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   289: goto -56 -> 233
      //   292: astore 6
      //   294: aconst_null
      //   295: astore 8
      //   297: aconst_null
      //   298: astore 7
      //   300: iload 4
      //   302: istore_2
      //   303: aload 7
      //   305: ifnull +8 -> 313
      //   308: aload 7
      //   310: invokevirtual 84	java/io/OutputStream:close	()V
      //   313: aload 8
      //   315: ifnull +8 -> 323
      //   318: aload 8
      //   320: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   323: aload_0
      //   324: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   327: invokevirtual 102	com/google/android/gms/measurement/internal/zzp:zzAV	()Lcom/google/android/gms/measurement/internal/zzs;
      //   330: new 104	com/google/android/gms/measurement/internal/zzp$zzb
      //   333: dup
      //   334: aload_0
      //   335: getfield 30	com/google/android/gms/measurement/internal/zzp$zzc:zzaTz	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   338: iload_2
      //   339: aconst_null
      //   340: aconst_null
      //   341: aconst_null
      //   342: invokespecial 107	com/google/android/gms/measurement/internal/zzp$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzp$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzp$1;)V
      //   345: invokevirtual 112	com/google/android/gms/measurement/internal/zzs:zzg	(Ljava/lang/Runnable;)V
      //   348: aload 6
      //   350: athrow
      //   351: astore 7
      //   353: aload_0
      //   354: getfield 21	com/google/android/gms/measurement/internal/zzp$zzc:zzaTA	Lcom/google/android/gms/measurement/internal/zzp;
      //   357: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   360: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   363: ldc 124
      //   365: aload 7
      //   367: invokevirtual 130	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   370: goto -57 -> 313
      //   373: astore 9
      //   375: aconst_null
      //   376: astore 7
      //   378: aload 6
      //   380: astore 8
      //   382: aload 9
      //   384: astore 6
      //   386: goto -83 -> 303
      //   389: astore 9
      //   391: aload 6
      //   393: astore 8
      //   395: iload 4
      //   397: istore_2
      //   398: aload 9
      //   400: astore 6
      //   402: goto -99 -> 303
      //   405: astore 9
      //   407: aconst_null
      //   408: astore 7
      //   410: aload 6
      //   412: astore 8
      //   414: aload 9
      //   416: astore 6
      //   418: goto -195 -> 223
      //   421: astore 9
      //   423: iconst_0
      //   424: istore_1
      //   425: aload 6
      //   427: astore 8
      //   429: aload 9
      //   431: astore 6
      //   433: goto -210 -> 223
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	436	0	this	zzc
      //   48	377	1	i	int
      //   45	353	2	j	int
      //   8	172	3	k	int
      //   13	383	4	m	int
      //   10	109	5	n	int
      //   42	118	6	localHttpURLConnection	HttpURLConnection
      //   213	47	6	localIOException1	IOException
      //   292	87	6	localObject1	Object
      //   384	48	6	localObject2	Object
      //   102	10	7	localOutputStream	java.io.OutputStream
      //   191	15	7	localIOException2	IOException
      //   218	11	7	localObject3	Object
      //   270	15	7	localIOException3	IOException
      //   298	11	7	localObject4	Object
      //   351	15	7	localIOException4	IOException
      //   376	33	7	localObject5	Object
      //   29	399	8	localObject6	Object
      //   373	10	9	localObject7	Object
      //   389	10	9	localObject8	Object
      //   405	10	9	localIOException5	IOException
      //   421	9	9	localIOException6	IOException
      // Exception table:
      //   from	to	target	type
      //   146	154	191	java/io/IOException
      //   15	44	213	java/io/IOException
      //   228	233	270	java/io/IOException
      //   15	44	292	finally
      //   308	313	351	java/io/IOException
      //   49	55	373	finally
      //   60	69	373	finally
      //   74	82	373	finally
      //   87	92	373	finally
      //   97	104	373	finally
      //   121	127	373	finally
      //   131	142	373	finally
      //   104	116	389	finally
      //   49	55	405	java/io/IOException
      //   60	69	405	java/io/IOException
      //   74	82	405	java/io/IOException
      //   87	92	405	java/io/IOException
      //   97	104	405	java/io/IOException
      //   121	127	405	java/io/IOException
      //   131	142	405	java/io/IOException
      //   104	116	421	java/io/IOException
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */