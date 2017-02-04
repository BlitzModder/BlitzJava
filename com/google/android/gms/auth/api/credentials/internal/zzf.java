package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public final class zzf
  extends zzj<zzi>
{
  private final Auth.AuthCredentialsOptions zzVd;
  
  public zzf(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzVd = paramAuthCredentialsOptions;
  }
  
  protected zzi zzav(IBinder paramIBinder)
  {
    return zzi.zza.zzax(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  protected Bundle zzlU()
  {
    if (this.zzVd == null) {
      return new Bundle();
    }
    return this.zzVd.zzlU();
  }
  
  Auth.AuthCredentialsOptions zzmm()
  {
    return this.zzVd;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */