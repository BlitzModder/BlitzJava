package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzhx
  extends zza.zza
{
  private zzhy zzJp;
  private zzhv zzJv;
  private zzhw zzJw;
  
  public zzhx(zzhw paramzzhw)
  {
    this.zzJw = paramzzhw;
  }
  
  public void zza(zzd paramzzd, RewardItemParcel paramRewardItemParcel)
  {
    if (this.zzJw != null) {
      this.zzJw.zza(paramRewardItemParcel);
    }
  }
  
  public void zza(zzhv paramzzhv)
  {
    this.zzJv = paramzzhv;
  }
  
  public void zza(zzhy paramzzhy)
  {
    this.zzJp = paramzzhy;
  }
  
  public void zzb(zzd paramzzd, int paramInt)
  {
    if (this.zzJv != null) {
      this.zzJv.zzN(paramInt);
    }
  }
  
  public void zzc(zzd paramzzd, int paramInt)
  {
    if (this.zzJp != null) {
      this.zzJp.zza(zze.zzp(paramzzd).getClass().getName(), paramInt);
    }
  }
  
  public void zzg(zzd paramzzd)
  {
    if (this.zzJv != null) {
      this.zzJv.zzgC();
    }
  }
  
  public void zzh(zzd paramzzd)
  {
    if (this.zzJp != null) {
      this.zzJp.zzaw(zze.zzp(paramzzd).getClass().getName());
    }
  }
  
  public void zzi(zzd paramzzd)
  {
    if (this.zzJw != null) {
      this.zzJw.onRewardedVideoAdOpened();
    }
  }
  
  public void zzj(zzd paramzzd)
  {
    if (this.zzJw != null) {
      this.zzJw.onRewardedVideoStarted();
    }
  }
  
  public void zzk(zzd paramzzd)
  {
    if (this.zzJw != null) {
      this.zzJw.onRewardedVideoAdClosed();
    }
  }
  
  public void zzl(zzd paramzzd)
  {
    if (this.zzJw != null) {
      this.zzJw.zzgz();
    }
  }
  
  public void zzm(zzd paramzzd)
  {
    if (this.zzJw != null) {
      this.zzJw.onRewardedVideoAdLeftApplication();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */