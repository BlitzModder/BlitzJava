package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Map;

public class zzmd
  implements zzmh
{
  private final zzmi zzafD;
  
  public zzmd(zzmi paramzzmi)
  {
    this.zzafD = paramzzmi;
  }
  
  private <A extends Api.zzb> void zza(zzmg.zze<A> paramzze)
    throws DeadObjectException
  {
    this.zzafD.zzafp.zzb(paramzze);
    Api.zzb localzzb = this.zzafD.zzafp.zza(paramzze.zzoA());
    if ((!localzzb.isConnected()) && (this.zzafD.zzagJ.containsKey(paramzze.zzoA())))
    {
      paramzze.zzx(new Status(17));
      return;
    }
    paramzze.zzb(localzzb);
  }
  
  public void begin() {}
  
  public void connect() {}
  
  public void disconnect()
  {
    this.zzafD.zzj(null);
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzafD.zzj(null);
    this.zzafD.zzagN.zzbz(paramInt);
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zza(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.zzafD.zza(new zzmi.zza(this)
      {
        public void zzpc()
        {
          zzmd.this.onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */