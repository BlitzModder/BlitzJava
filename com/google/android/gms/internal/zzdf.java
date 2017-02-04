package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzha
public class zzdf
  extends zzda.zza
{
  private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzyx;
  
  public zzdf(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener)
  {
    this.zzyx = paramOnCustomTemplateAdLoadedListener;
  }
  
  public void zza(zzcv paramzzcv)
  {
    this.zzyx.onCustomTemplateAdLoaded(new zzcw(paramzzcv));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */