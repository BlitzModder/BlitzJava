package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zzqe;

public final class Address
{
  public static final Api<AddressOptions> API = new Api("Address.API", zzTp, zzTo);
  static final Api.zzc<zzqe> zzTo = new Api.zzc();
  private static final Api.zza<zzqe, AddressOptions> zzTp = new Api.zza()
  {
    public zzqe zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      zzx.zzb(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      Address.AddressOptions localAddressOptions = paramAnonymousAddressOptions;
      if (paramAnonymousAddressOptions == null) {
        localAddressOptions = new Address.AddressOptions();
      }
      return new zzqe((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, localAddressOptions.theme, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, final UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(zzqe paramAnonymouszzqe)
        throws RemoteException
      {
        paramAnonymouszzqe.zza(paramUserAddressRequest, paramInt);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public static final class AddressOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int theme;
    
    public AddressOptions()
    {
      this.theme = 0;
    }
    
    public AddressOptions(int paramInt)
    {
      this.theme = paramInt;
    }
  }
  
  private static abstract class zza
    extends zzlx.zza<Status, zzqe>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    public Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/identity/intents/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */