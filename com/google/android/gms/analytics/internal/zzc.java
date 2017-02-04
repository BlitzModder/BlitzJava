package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.zzg;

public class zzc
{
  private final zzf zzOP;
  
  protected zzc(zzf paramzzf)
  {
    zzx.zzy(paramzzf);
    this.zzOP = paramzzf;
  }
  
  private void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    if (this.zzOP != null) {
      localObject = this.zzOP.zzjh();
    }
    if (localObject != null) {
      ((zzaf)localObject).zza(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
    do
    {
      return;
      localObject = (String)zzy.zzQr.get();
    } while (!Log.isLoggable((String)localObject, paramInt));
    Log.println(paramInt, (String)localObject, zzc(paramString, paramObject1, paramObject2, paramObject3));
  }
  
  protected static String zzc(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzi(paramObject1);
    paramObject2 = zzi(paramObject2);
    paramObject3 = zzi(paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzi(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject == Boolean.TRUE) {}
      for (paramObject = "true";; paramObject = "false") {
        return (String)paramObject;
      }
    }
    if ((paramObject instanceof Throwable)) {
      return ((Throwable)paramObject).toString();
    }
    return paramObject.toString();
  }
  
  protected Context getContext()
  {
    return this.zzOP.getContext();
  }
  
  public void zza(String paramString, Object paramObject)
  {
    zza(2, paramString, paramObject, null, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(2, paramString, paramObject1, paramObject2, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(3, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzb(String paramString, Object paramObject)
  {
    zza(3, paramString, paramObject, null, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(3, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(5, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzba(String paramString)
  {
    zza(2, paramString, null, null, null);
  }
  
  public void zzbb(String paramString)
  {
    zza(3, paramString, null, null, null);
  }
  
  public void zzbc(String paramString)
  {
    zza(4, paramString, null, null, null);
  }
  
  public void zzbd(String paramString)
  {
    zza(5, paramString, null, null, null);
  }
  
  public void zzbe(String paramString)
  {
    zza(6, paramString, null, null, null);
  }
  
  public void zzc(String paramString, Object paramObject)
  {
    zza(4, paramString, paramObject, null, null);
  }
  
  public void zzc(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(5, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzd(String paramString, Object paramObject)
  {
    zza(5, paramString, paramObject, null, null);
  }
  
  public void zzd(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(6, paramString, paramObject1, paramObject2, null);
  }
  
  public void zze(String paramString, Object paramObject)
  {
    zza(6, paramString, paramObject, null, null);
  }
  
  public zzf zziQ()
  {
    return this.zzOP;
  }
  
  protected void zziR()
  {
    if (zziV().zzka()) {
      throw new IllegalStateException("Call only supported on the client side");
    }
  }
  
  protected void zziS()
  {
    this.zzOP.zziS();
  }
  
  protected zznl zziT()
  {
    return this.zzOP.zziT();
  }
  
  protected zzaf zziU()
  {
    return this.zzOP.zziU();
  }
  
  protected zzr zziV()
  {
    return this.zzOP.zziV();
  }
  
  protected zzg zziW()
  {
    return this.zzOP.zziW();
  }
  
  protected zzv zziX()
  {
    return this.zzOP.zziX();
  }
  
  protected zzai zziY()
  {
    return this.zzOP.zziY();
  }
  
  protected zzn zziZ()
  {
    return this.zzOP.zzjl();
  }
  
  public GoogleAnalytics zzik()
  {
    return this.zzOP.zzji();
  }
  
  protected zzb zzip()
  {
    return this.zzOP.zzip();
  }
  
  protected zzan zziq()
  {
    return this.zzOP.zziq();
  }
  
  protected zza zzja()
  {
    return this.zzOP.zzjk();
  }
  
  protected zzk zzjb()
  {
    return this.zzOP.zzjb();
  }
  
  protected zzu zzjc()
  {
    return this.zzOP.zzjc();
  }
  
  public boolean zzjd()
  {
    return Log.isLoggable((String)zzy.zzQr.get(), 2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */