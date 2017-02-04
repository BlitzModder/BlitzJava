package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

abstract class zzla
  extends zzlx.zza<ProxyApi.ProxyResult, zzkx>
{
  public zzla(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.zzTW, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzkz paramzzkz)
    throws RemoteException;
  
  protected final void zza(zzkx paramzzkx)
    throws RemoteException
  {
    zza(paramzzkx.getContext(), (zzkz)paramzzkx.zzqs());
  }
  
  protected ProxyApi.ProxyResult zzj(Status paramStatus)
  {
    return new zzlc(paramStatus);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */