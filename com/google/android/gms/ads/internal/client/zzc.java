package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzc
  extends zzo.zza
{
  private final AdListener zzto;
  
  public zzc(AdListener paramAdListener)
  {
    this.zzto = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.zzto.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.zzto.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.zzto.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.zzto.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.zzto.onAdOpened();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */