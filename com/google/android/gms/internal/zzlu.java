package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzlu
  extends zzj<zzlw>
{
  public zzlu(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 40, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void zza(zzlv paramzzlv, LogEventParcelable paramLogEventParcelable)
    throws RemoteException
  {
    ((zzlw)zzqs()).zza(paramzzlv, paramLogEventParcelable);
  }
  
  protected zzlw zzaK(IBinder paramIBinder)
  {
    return zzlw.zza.zzaM(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.clearcut.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */