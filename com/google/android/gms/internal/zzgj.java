package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzha
public class zzgj
  implements InAppPurchaseResult
{
  private final zzgf zzFa;
  
  public zzgj(zzgf paramzzgf)
  {
    this.zzFa = paramzzgf;
  }
  
  public void finishPurchase()
  {
    try
    {
      this.zzFa.finishPurchase();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward finishPurchase to InAppPurchaseResult", localRemoteException);
    }
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.zzFa.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getProductId to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public Intent getPurchaseData()
  {
    try
    {
      Intent localIntent = this.zzFa.getPurchaseData();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public int getResultCode()
  {
    try
    {
      int i = this.zzFa.getResultCode();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return 0;
  }
  
  public boolean isVerified()
  {
    try
    {
      boolean bool = this.zzFa.isVerified();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward isVerified to InAppPurchaseResult", localRemoteException);
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */