package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzl
  extends zzj<zzg>
{
  private final zzh zzWg;
  
  public zzl(Context paramContext, Looper paramLooper, zzf paramzzf, zzh paramzzh, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 87, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzWg = ((zzh)zzx.zzy(paramzzh));
  }
  
  protected zzg zzaB(IBinder paramIBinder)
  {
    return zzg.zza.zzaD(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */