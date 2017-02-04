package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public final class zzci
  extends zzck.zza
{
  private final zzg zzxg;
  private final String zzxh;
  private final String zzxi;
  
  public zzci(zzg paramzzg, String paramString1, String paramString2)
  {
    this.zzxg = paramzzg;
    this.zzxh = paramString1;
    this.zzxi = paramString2;
  }
  
  public String getContent()
  {
    return this.zzxi;
  }
  
  public void recordClick()
  {
    this.zzxg.recordClick();
  }
  
  public void recordImpression()
  {
    this.zzxg.recordImpression();
  }
  
  public void zza(zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    this.zzxg.zzc((View)zze.zzp(paramzzd));
  }
  
  public String zzdy()
  {
    return this.zzxh;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */