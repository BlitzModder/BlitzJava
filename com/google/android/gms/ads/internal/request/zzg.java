package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzha;
import java.lang.ref.WeakReference;

@zzha
public final class zzg
  extends zzk.zza
{
  private final WeakReference<zzc.zza> zzGL;
  
  public zzg(zzc.zza paramzza)
  {
    this.zzGL = new WeakReference(paramzza);
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    zzc.zza localzza = (zzc.zza)this.zzGL.get();
    if (localzza != null) {
      localzza.zzb(paramAdResponseParcel);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */