package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.TextureView;

public abstract class zzi
  extends TextureView
{
  public zzi(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setMimeType(String paramString);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract void stop();
  
  public abstract void zza(float paramFloat);
  
  public abstract void zza(zzh paramzzh);
  
  public abstract String zzeO();
  
  public abstract void zzeU();
  
  public abstract void zzeV();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */