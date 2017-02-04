package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzkg
  extends zzj<zzkd>
{
  public zzkg(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 19, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzkd zzai(IBinder paramIBinder)
  {
    return zzkd.zza.zzag(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }
  
  public zzkd zzlS()
    throws DeadObjectException
  {
    return (zzkd)zzqs();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */