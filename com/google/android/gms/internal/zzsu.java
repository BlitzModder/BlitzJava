package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

public class zzsu
  extends zzj<zzsp>
{
  private final Context mContext;
  private final int mTheme;
  private final String zzTD;
  private final int zzbkD;
  private final boolean zzbkE;
  
  public zzsu(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramLooper, 4, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.mContext = paramContext;
    this.zzbkD = paramInt1;
    this.zzTD = paramzzf.getAccountName();
    this.mTheme = paramInt2;
    this.zzbkE = paramBoolean;
  }
  
  private Bundle zzGs()
  {
    return zza(this.zzbkD, this.mContext.getPackageName(), this.zzTD, this.mTheme, this.zzbkE);
  }
  
  public static Bundle zza(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
    localBundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", paramBoolean);
    localBundle.putString("androidPackageName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
    return localBundle;
  }
  
  public void zza(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    zzb localzzb = new zzb(this.mContext, paramInt);
    Bundle localBundle = zzGs();
    try
    {
      ((zzsp)zzqs()).zza(paramFullWalletRequest, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramFullWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting full wallet", paramFullWalletRequest);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  public void zza(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = zzGs();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzsp)zzqs()).zza(paramMaskedWalletRequest, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramMaskedWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting masked wallet", paramMaskedWalletRequest);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  public void zza(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = zzGs();
    try
    {
      ((zzsp)zzqs()).zza(paramNotifyTransactionStatusRequest, localBundle);
      return;
    }
    catch (RemoteException paramNotifyTransactionStatusRequest) {}
  }
  
  protected zzsp zzek(IBinder paramIBinder)
  {
    return zzsp.zza.zzeg(paramIBinder);
  }
  
  public void zzf(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = zzGs();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzsp)zzqs()).zza(paramString1, paramString2, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.e("WalletClientImpl", "RemoteException changing masked wallet", paramString1);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  public void zzkV(int paramInt)
  {
    Bundle localBundle = zzGs();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzsp)zzqs()).zza(localBundle, localzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
      localzzb.zza(8, false, Bundle.EMPTY);
    }
  }
  
  public void zzkW(int paramInt)
  {
    Bundle localBundle = zzGs();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzsp)zzqs()).zzb(localBundle, localzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during isNewUser", localRemoteException);
      localzzb.zzb(8, false, Bundle.EMPTY);
    }
  }
  
  public boolean zzqu()
  {
    return true;
  }
  
  private static class zza
    extends zzss.zza
  {
    public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {}
    
    public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {}
    
    public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, GetBuyFlowInitializationTokenResponse paramGetBuyFlowInitializationTokenResponse, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, GetInstrumentsResponse paramGetInstrumentsResponse, Bundle paramBundle) {}
    
    public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void zzj(int paramInt, Bundle paramBundle) {}
  }
  
  static final class zzb
    extends zzsu.zza
  {
    private final int zzaeU;
    private final WeakReference<Activity> zzblt;
    
    public zzb(Context paramContext, int paramInt)
    {
      super();
      this.zzblt = new WeakReference((Activity)paramContext);
      this.zzaeU = paramInt;
    }
    
    public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    {
      Activity localActivity = (Activity)this.zzblt.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
        return;
      }
      Object localObject = null;
      if (paramBundle != null) {
        localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaeU);
          return;
        }
        catch (IntentSender.SendIntentException paramFullWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramFullWallet);
          return;
        }
      }
      localObject = new Intent();
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
        paramFullWallet = localActivity.createPendingResult(this.zzaeU, (Intent)localObject, 1073741824);
        if (paramFullWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramFullWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramFullWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramFullWallet);
      }
    }
    
    public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    {
      Activity localActivity = (Activity)this.zzblt.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
        return;
      }
      Object localObject = null;
      if (paramBundle != null) {
        localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaeU);
          return;
        }
        catch (IntentSender.SendIntentException paramMaskedWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramMaskedWallet);
          return;
        }
      }
      localObject = new Intent();
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
        paramMaskedWallet = localActivity.createPendingResult(this.zzaeU, (Intent)localObject, 1073741824);
        if (paramMaskedWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramMaskedWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramMaskedWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramMaskedWallet);
      }
    }
    
    public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = (Activity)this.zzblt.get();
      if (paramBundle == null)
      {
        Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
      paramBundle = paramBundle.createPendingResult(this.zzaeU, localIntent, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
        return;
      }
      try
      {
        paramBundle.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
    
    public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = (Activity)this.zzblt.get();
      if (paramBundle == null)
      {
        Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_IS_NEW_USER", paramBoolean);
      paramBundle = paramBundle.createPendingResult(this.zzaeU, localIntent, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
        return;
      }
      try
      {
        paramBundle.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
    
    public void zzj(int paramInt, Bundle paramBundle)
    {
      zzx.zzb(paramBundle, "Bundle should not be null");
      Activity localActivity = (Activity)this.zzblt.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
        return;
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaeU);
          return;
        }
        catch (IntentSender.SendIntentException paramBundle)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramBundle);
          return;
        }
      }
      Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + paramBundle);
      paramBundle = new Intent();
      paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
      paramBundle = localActivity.createPendingResult(this.zzaeU, paramBundle, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
        return;
      }
      try
      {
        paramBundle.send(1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */