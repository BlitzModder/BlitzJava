package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzry
  extends zzj<zzrx>
{
  public zzry(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramContext.getMainLooper(), 73, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzrx zzdU(IBinder paramIBinder)
  {
    return zzrx.zza.zzdT(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.search.service.SEARCH_AUTH_START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.search.internal.ISearchAuthService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */