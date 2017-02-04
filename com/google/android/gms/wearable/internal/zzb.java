package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;

final class zzb<T>
  extends zzi<Status>
{
  private T mListener;
  private zzmn<T> zzaWl;
  private zza<T> zzbmv;
  
  private zzb(GoogleApiClient paramGoogleApiClient, T paramT, zzmn<T> paramzzmn, zza<T> paramzza)
  {
    super(paramGoogleApiClient);
    this.mListener = zzx.zzy(paramT);
    this.zzaWl = ((zzmn)zzx.zzy(paramzzmn));
    this.zzbmv = ((zza)zzx.zzy(paramzza));
  }
  
  static <T> PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zza<T> paramzza, T paramT)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramT, paramGoogleApiClient.zzq(paramT), paramzza));
  }
  
  protected void zza(zzce paramzzce)
    throws RemoteException
  {
    this.zzbmv.zza(paramzzce, this, this.mListener, this.zzaWl);
    this.mListener = null;
    this.zzaWl = null;
  }
  
  protected Status zzb(Status paramStatus)
  {
    this.mListener = null;
    this.zzaWl = null;
    return paramStatus;
  }
  
  static abstract interface zza<T>
  {
    public abstract void zza(zzce paramzzce, zzlx.zzb<Status> paramzzb, T paramT, zzmn<T> paramzzmn)
      throws RemoteException;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */