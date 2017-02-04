package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;

public class zzg
{
  private final Context zzPi;
  private final Context zzrI;
  
  public zzg(Context paramContext)
  {
    zzx.zzy(paramContext);
    paramContext = paramContext.getApplicationContext();
    zzx.zzb(paramContext, "Application context can't be null");
    this.zzrI = paramContext;
    this.zzPi = paramContext;
  }
  
  public Context getApplicationContext()
  {
    return this.zzrI;
  }
  
  protected zzu zza(zzf paramzzf)
  {
    return new zzu(paramzzf);
  }
  
  protected com.google.android.gms.measurement.zzg zzaa(Context paramContext)
  {
    return com.google.android.gms.measurement.zzg.zzaT(paramContext);
  }
  
  protected zzk zzb(zzf paramzzf)
  {
    return new zzk(paramzzf);
  }
  
  protected zza zzc(zzf paramzzf)
  {
    return new zza(paramzzf);
  }
  
  protected zzn zzd(zzf paramzzf)
  {
    return new zzn(paramzzf);
  }
  
  protected zzan zze(zzf paramzzf)
  {
    return new zzan(paramzzf);
  }
  
  protected zzaf zzf(zzf paramzzf)
  {
    return new zzaf(paramzzf);
  }
  
  protected zzr zzg(zzf paramzzf)
  {
    return new zzr(paramzzf);
  }
  
  protected zznl zzh(zzf paramzzf)
  {
    return zzno.zzrM();
  }
  
  protected GoogleAnalytics zzi(zzf paramzzf)
  {
    return new GoogleAnalytics(paramzzf);
  }
  
  zzl zzj(zzf paramzzf)
  {
    return new zzl(paramzzf, this);
  }
  
  public Context zzjg()
  {
    return this.zzPi;
  }
  
  zzag zzk(zzf paramzzf)
  {
    return new zzag(paramzzf);
  }
  
  protected zzb zzl(zzf paramzzf)
  {
    return new zzb(paramzzf, this);
  }
  
  public zzj zzm(zzf paramzzf)
  {
    return new zzj(paramzzf);
  }
  
  public zzah zzn(zzf paramzzf)
  {
    return new zzah(paramzzf);
  }
  
  public zzi zzo(zzf paramzzf)
  {
    return new zzi(paramzzf);
  }
  
  public zzv zzp(zzf paramzzf)
  {
    return new zzv(paramzzf);
  }
  
  public zzai zzq(zzf paramzzf)
  {
    return new zzai(paramzzf);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */