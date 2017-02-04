package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzha
public class zzde
  extends zzcz.zza
{
  private final NativeCustomTemplateAd.OnCustomClickListener zzyw;
  
  public zzde(NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    this.zzyw = paramOnCustomClickListener;
  }
  
  public void zza(zzcv paramzzcv, String paramString)
  {
    this.zzyw.onCustomClick(new zzcw(paramzzcv), paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */