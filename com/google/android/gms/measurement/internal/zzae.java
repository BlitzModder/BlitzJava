package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.internal.zztd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class zzae
  extends zzv
{
  zzae(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private Object zza(int paramInt, Object paramObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramObject;
        } while ((paramObject instanceof Long));
        localObject = paramObject;
      } while ((paramObject instanceof Float));
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {}
        for (long l = 1L;; l = 0L) {
          return Long.valueOf(l);
        }
      }
      if ((paramObject instanceof Double)) {
        return Float.valueOf((float)((Double)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        break;
      }
      paramObject = String.valueOf(paramObject);
      localObject = paramObject;
    } while (((String)paramObject).length() <= paramInt);
    if (paramBoolean) {
      return ((String)paramObject).substring(0, paramInt);
    }
    return null;
    return null;
  }
  
  private void zza(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      zzzz().zzBo().zzj(paramString1 + " value can't be null. Ignoring " + paramString1, paramString2);
    }
    do
    {
      do
      {
        return;
      } while (((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))));
      paramObject = String.valueOf(paramObject);
    } while (((String)paramObject).length() <= paramInt);
    zzzz().zzBo().zze("Ignoring " + paramString1 + ". Value is too long. name, value length", paramString2, Integer.valueOf(((String)paramObject).length()));
  }
  
  public static boolean zza(Context paramContext, Class<? extends Service> paramClass)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, paramClass), 4);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean zza(Context paramContext, Class<? extends BroadcastReceiver> paramClass, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getReceiverInfo(new ComponentName(paramContext, paramClass), 2);
      if ((paramContext != null) && (paramContext.enabled)) {
        if (paramBoolean)
        {
          paramBoolean = paramContext.exported;
          if (!paramBoolean) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private int zzeH(String paramString)
  {
    if ("_ldl".equals(paramString)) {
      return zzAX().zzAy();
    }
    return zzAX().zzAx();
  }
  
  public void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    }
    do
    {
      return;
      if ((paramObject instanceof Float))
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        paramBundle.putString(paramString, String.valueOf(paramObject));
        return;
      }
    } while (paramString == null);
    zzzz().zzBo().zze("Not putting event parameter. Invalid value type. name, type", paramString, paramObject.getClass().getSimpleName());
  }
  
  public void zza(zzqq.zzb paramzzb, Object paramObject)
  {
    zzx.zzy(paramObject);
    paramzzb.zzakS = null;
    paramzzb.zzaVo = null;
    paramzzb.zzaVi = null;
    if ((paramObject instanceof String))
    {
      paramzzb.zzakS = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzb.zzaVo = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramzzb.zzaVi = ((Float)paramObject);
      return;
    }
    zzzz().zzBl().zzj("Ignoring invalid (type) event param value", paramObject);
  }
  
  public void zza(zzqq.zze paramzze, Object paramObject)
  {
    zzx.zzy(paramObject);
    paramzze.zzakS = null;
    paramzze.zzaVo = null;
    paramzze.zzaVi = null;
    if ((paramObject instanceof String))
    {
      paramzze.zzakS = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzze.zzaVo = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramzze.zzaVi = ((Float)paramObject);
      return;
    }
    zzzz().zzBl().zzj("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  public byte[] zza(zzqq.zzc paramzzc)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramzzc.getSerializedSize()];
      zztd localzztd = zztd.zzD(arrayOfByte);
      paramzzc.writeTo(localzztd);
      localzztd.zzHy();
      return arrayOfByte;
    }
    catch (IOException paramzzc)
    {
      zzzz().zzBl().zzj("Data loss. Failed to serialize batch", paramzzc);
    }
    return null;
  }
  
  public boolean zzbh(String paramString)
  {
    zziS();
    return getContext().checkCallingOrSelfPermission(paramString) == 0;
  }
  
  void zzc(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException(paramString1 + " name is required and can't be null");
    }
    if (paramString2.length() == 0) {
      throw new IllegalArgumentException(paramString1 + " name is required and can't be empty");
    }
    char c = paramString2.charAt(0);
    if ((!Character.isLetter(c)) && (c != '_')) {
      throw new IllegalArgumentException(paramString1 + " name must start with a letter or _");
    }
    int i = 1;
    while (i < paramString2.length())
    {
      c = paramString2.charAt(i);
      if ((c != '_') && (!Character.isLetterOrDigit(c))) {
        throw new IllegalArgumentException(paramString1 + " name must consist of letters, digits or _ (underscores)");
      }
      i += 1;
    }
    if (paramString2.length() > paramInt) {
      throw new IllegalArgumentException(paramString1 + " name is too long. The maximum supported length is " + paramInt);
    }
  }
  
  public boolean zzc(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 <= 0L)) {}
    while (Math.abs(zziT().currentTimeMillis() - paramLong1) > paramLong2) {
      return true;
    }
    return false;
  }
  
  public void zzeE(String paramString)
  {
    zzc("event", zzAX().zzAt(), paramString);
  }
  
  public void zzeF(String paramString)
  {
    zzc("user attribute", zzAX().zzAu(), paramString);
  }
  
  public void zzeG(String paramString)
  {
    zzc("event param", zzAX().zzAu(), paramString);
  }
  
  public byte[] zzg(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzzz().zzBl().zzj("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public Object zzk(String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"))) {}
    for (int i = zzAX().zzAw();; i = zzAX().zzAv()) {
      return zza(i, paramObject, false);
    }
  }
  
  public void zzl(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString))
    {
      zza("user attribute referrer", paramString, zzeH(paramString), paramObject);
      return;
    }
    zza("user attribute", paramString, zzeH(paramString), paramObject);
  }
  
  public Object zzm(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zza(zzeH(paramString), paramObject, true);
    }
    return zza(zzeH(paramString), paramObject, false);
  }
  
  /* Error */
  public byte[] zzq(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 427	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 429	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 431	java/util/zip/GZIPInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 434	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: new 369	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 370	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 4
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore 5
    //   34: aload_3
    //   35: aload 5
    //   37: invokevirtual 438	java/util/zip/GZIPInputStream:read	([B)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifgt +17 -> 59
    //   45: aload_3
    //   46: invokevirtual 439	java/util/zip/GZIPInputStream:close	()V
    //   49: aload_1
    //   50: invokevirtual 440	java/io/ByteArrayInputStream:close	()V
    //   53: aload 4
    //   55: invokevirtual 387	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   58: areturn
    //   59: aload 4
    //   61: aload 5
    //   63: iconst_0
    //   64: iload_2
    //   65: invokevirtual 443	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -34 -> 34
    //   71: astore_1
    //   72: aload_0
    //   73: invokevirtual 73	com/google/android/gms/measurement/internal/zzae:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   76: invokevirtual 259	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   79: ldc_w 445
    //   82: aload_1
    //   83: invokevirtual 100	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	zzae
    //   0	88	1	paramArrayOfByte	byte[]
    //   40	25	2	i	int
    //   17	29	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   25	35	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   32	30	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	34	71	java/io/IOException
    //   34	41	71	java/io/IOException
    //   45	59	71	java/io/IOException
    //   59	68	71	java/io/IOException
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */