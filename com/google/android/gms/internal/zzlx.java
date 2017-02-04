package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zzlx
{
  public static abstract class zza<R extends Result, A extends Api.zzb>
    extends zzly<R>
    implements zzlx.zzb<R>, zzmg.zze<A>
  {
    private final Api.zzc<A> zzacX;
    private AtomicReference<zzmg.zzd> zzafc = new AtomicReference();
    
    protected zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzacX = ((Api.zzc)zzx.zzy(paramzzc));
    }
    
    private void zza(RemoteException paramRemoteException)
    {
      zzx(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void zza(A paramA)
      throws RemoteException;
    
    public void zza(zzmg.zzd paramzzd)
    {
      this.zzafc.set(paramzzd);
    }
    
    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zza(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zza(paramA);
      }
    }
    
    public final Api.zzc<A> zzoA()
    {
      return this.zzacX;
    }
    
    public void zzoP()
    {
      setResultCallback(null);
    }
    
    public int zzoQ()
    {
      return 0;
    }
    
    protected void zzoR()
    {
      zzmg.zzd localzzd = (zzmg.zzd)this.zzafc.getAndSet(null);
      if (localzzd != null) {
        localzzd.zzc(this);
      }
    }
    
    public final void zzx(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Failed result must not be success");
        zzb(zzc(paramStatus));
        return;
      }
    }
  }
  
  public static abstract interface zzb<R>
  {
    public abstract void zzr(R paramR);
    
    public abstract void zzx(Status paramStatus);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */