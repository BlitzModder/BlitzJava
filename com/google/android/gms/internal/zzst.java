package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzst
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zzf(paramString1, paramString2, paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zzkV(paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public void isNewUser(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zzkW(paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zza(paramFullWalletRequest, paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zza(paramMaskedWalletRequest, paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, final NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzsu paramAnonymouszzsu)
      {
        paramAnonymouszzsu.zza(paramNotifyTransactionStatusRequest);
        zzb(Status.zzaeX);
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */