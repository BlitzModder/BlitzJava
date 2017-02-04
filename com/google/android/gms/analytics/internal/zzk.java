package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzqh;
import com.google.android.gms.measurement.zzg;

public class zzk
  extends zzd
{
  private final zzqh zzPD = new zzqh();
  
  zzk(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void zzim()
  {
    Object localObject = zziq();
    String str = ((zzan)localObject).zzkP();
    if (str != null) {
      this.zzPD.setAppName(str);
    }
    localObject = ((zzan)localObject).zzkR();
    if (localObject != null) {
      this.zzPD.setAppVersion((String)localObject);
    }
  }
  
  protected void zzir()
  {
    zziW().zzzR().zza(this.zzPD);
    zzim();
  }
  
  public zzqh zzjB()
  {
    zzje();
    return this.zzPD;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */