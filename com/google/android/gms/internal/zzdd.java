package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzha
public class zzdd
  extends zzcy.zza
{
  private final NativeContentAd.OnContentAdLoadedListener zzyv;
  
  public zzdd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    this.zzyv = paramOnContentAdLoadedListener;
  }
  
  public void zza(zzct paramzzct)
  {
    this.zzyv.onContentAdLoaded(zzb(paramzzct));
  }
  
  zzcu zzb(zzct paramzzct)
  {
    return new zzcu(paramzzct);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */