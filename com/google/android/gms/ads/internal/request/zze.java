package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzha;

@zzha
public class zze
  extends com.google.android.gms.common.internal.zzj<zzj>
{
  final int zzGo;
  
  public zze(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramLooper, 8, zzf.zzas(paramContext), paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzGo = paramInt;
  }
  
  protected zzj zzV(IBinder paramIBinder)
  {
    return zzj.zza.zzX(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public zzj zzgj()
    throws DeadObjectException
  {
    return (zzj)super.zzqs();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */