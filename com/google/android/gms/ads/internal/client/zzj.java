package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzj
  extends zzu.zza
{
  private final AppEventListener zzub;
  
  public zzj(AppEventListener paramAppEventListener)
  {
    this.zzub = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.zzub.onAppEvent(paramString1, paramString2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */