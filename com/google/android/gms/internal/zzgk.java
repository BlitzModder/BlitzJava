package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzha
public class zzgk
  implements InAppPurchase
{
  private final zzgb zzEK;
  
  public zzgk(zzgb paramzzgb)
  {
    this.zzEK = paramzzgb;
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.zzEK.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      this.zzEK.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      this.zzEK.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */