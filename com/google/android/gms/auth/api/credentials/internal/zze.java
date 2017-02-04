package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx.zza;

abstract class zze<R extends Result>
  extends zzlx.zza<R, zzf>
{
  zze(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.zzTX, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzi paramzzi)
    throws DeadObjectException, RemoteException;
  
  protected final void zza(zzf paramzzf)
    throws DeadObjectException, RemoteException
  {
    zza(paramzzf.getContext(), (zzi)paramzzf.zzqs());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */