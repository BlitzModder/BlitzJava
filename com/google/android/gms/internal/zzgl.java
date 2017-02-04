package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@zzha
public final class zzgl
  extends zzgg.zza
{
  private final PlayStorePurchaseListener zzuA;
  
  public zzgl(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.zzuA = paramPlayStorePurchaseListener;
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.zzuA.isValidPurchase(paramString);
  }
  
  public void zza(zzgf paramzzgf)
  {
    this.zzuA.onInAppPurchaseFinished(new zzgj(paramzzgf));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */