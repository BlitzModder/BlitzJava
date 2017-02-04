package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzha
public final class zzcm
  extends zzcl.zza
{
  private final OnCustomRenderedAdLoadedListener zzuB;
  
  public zzcm(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzuB = paramOnCustomRenderedAdLoadedListener;
  }
  
  public void zza(zzck paramzzck)
  {
    this.zzuB.onCustomRenderedAdLoaded(new zzcj(paramzzck));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */