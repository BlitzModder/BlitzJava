package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zzqe
  extends zzj<zzqg>
{
  private Activity mActivity;
  private final int mTheme;
  private final String zzTD;
  private zza zzaJP;
  
  public zzqe(Activity paramActivity, Looper paramLooper, zzf paramzzf, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramActivity, paramLooper, 12, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzTD = paramzzf.getAccountName();
    this.mActivity = paramActivity;
    this.mTheme = paramInt;
  }
  
  public void disconnect()
  {
    super.disconnect();
    if (this.zzaJP != null)
    {
      zza.zza(this.zzaJP, null);
      this.zzaJP = null;
    }
  }
  
  public void zza(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    zzxL();
    this.zzaJP = new zza(paramInt, this.mActivity);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(this.zzTD)) {
        localBundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzTD, "com.google"));
      }
      localBundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
      zzxK().zza(this.zzaJP, paramUserAddressRequest, localBundle);
      return;
    }
    catch (RemoteException paramUserAddressRequest)
    {
      Log.e("AddressClientImpl", "Exception requesting user address", paramUserAddressRequest);
      paramUserAddressRequest = new Bundle();
      paramUserAddressRequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
      this.zzaJP.zzh(1, paramUserAddressRequest);
    }
  }
  
  protected zzqg zzca(IBinder paramIBinder)
  {
    return zzqg.zza.zzcc(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.identity.service.BIND";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }
  
  public boolean zzqu()
  {
    return true;
  }
  
  protected zzqg zzxK()
    throws DeadObjectException
  {
    return (zzqg)super.zzqs();
  }
  
  protected void zzxL()
  {
    super.zzqr();
  }
  
  public static final class zza
    extends zzqf.zza
  {
    private Activity mActivity;
    private final int zzaeU;
    
    public zza(int paramInt, Activity paramActivity)
    {
      this.zzaeU = paramInt;
      this.mActivity = paramActivity;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.mActivity = paramActivity;
    }
    
    public void zzh(int paramInt, Bundle paramBundle)
    {
      Object localObject;
      if (paramInt == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramBundle);
        paramBundle = this.mActivity.createPendingResult(this.zzaeU, (Intent)localObject, 1073741824);
        if (paramBundle != null) {}
      }
      for (;;)
      {
        return;
        try
        {
          paramBundle.send(1);
          return;
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", paramBundle);
          return;
        }
        localObject = null;
        if (paramBundle != null) {
          localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        }
        paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
        if (paramBundle.hasResolution()) {
          try
          {
            paramBundle.startResolutionForResult(this.mActivity, this.zzaeU);
            return;
          }
          catch (IntentSender.SendIntentException paramBundle)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", paramBundle);
            return;
          }
        }
        try
        {
          paramBundle = this.mActivity.createPendingResult(this.zzaeU, new Intent(), 1073741824);
          if (paramBundle != null)
          {
            paramBundle.send(1);
            return;
          }
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception setting pending result", paramBundle);
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */