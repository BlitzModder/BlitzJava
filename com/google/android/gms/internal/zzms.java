package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

public class zzms<R extends Result>
  extends zze<R>
  implements ResultCallback<R>
{
  private final Object zzafd;
  private zzb<? super R, ? extends Result> zzahj;
  private zzms<? extends Result> zzahk;
  private ResultCallbacks<? super R> zzahl;
  private PendingResult<R> zzahm;
  
  private void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("TransformedResultImpl", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  private void zzpD()
  {
    if ((this.zzahm == null) || ((this.zzahj == null) && (this.zzahl == null))) {
      return;
    }
    this.zzahm.setResultCallback(this);
  }
  
  public void onResult(R paramR)
  {
    for (;;)
    {
      synchronized (this.zzafd)
      {
        if (!paramR.getStatus().isSuccess()) {
          break label96;
        }
        if (this.zzahj != null)
        {
          PendingResult localPendingResult = this.zzahj.zza(paramR);
          if (localPendingResult == null)
          {
            zzz(new Status(13, "Transform returned null"));
            zzd(paramR);
            return;
          }
          this.zzahk.zza(localPendingResult);
        }
      }
      if (this.zzahl != null)
      {
        this.zzahl.onSuccess(paramR);
        continue;
        label96:
        zzz(paramR.getStatus());
        zzd(paramR);
      }
    }
  }
  
  public void zza(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zzafd)
    {
      this.zzahm = paramPendingResult;
      zzpD();
      return;
    }
  }
  
  public void zzz(Status paramStatus)
  {
    synchronized (this.zzafd)
    {
      if (this.zzahj != null)
      {
        paramStatus = this.zzahj.zzw(paramStatus);
        zzx.zzb(paramStatus, "onFailure must not return null");
        this.zzahk.zzz(paramStatus);
      }
      while (this.zzahl == null) {
        return;
      }
      this.zzahl.onFailure(paramStatus);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */