package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzha
public class zzdc
  extends zzcx.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzyu;
  
  public zzdc(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    this.zzyu = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzcr paramzzcr)
  {
    this.zzyu.onAppInstallAdLoaded(zzb(paramzzcr));
  }
  
  zzcs zzb(zzcr paramzzcr)
  {
    return new zzcs(paramzzcr);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */