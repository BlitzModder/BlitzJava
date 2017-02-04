package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzkq
  extends zzj<zzks>
{
  public zzkq(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 74, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzks zzaq(IBinder paramIBinder)
  {
    return zzks.zza.zzas(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.auth.api.accountstatus.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */