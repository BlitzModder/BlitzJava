package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzmf
  implements zzmh
{
  private final zzmi zzafD;
  
  public zzmf(zzmi paramzzmi)
  {
    this.zzafD = paramzzmi;
  }
  
  public void begin()
  {
    this.zzafD.zzpy();
    this.zzafD.zzafp.zzagq = Collections.emptySet();
  }
  
  public void connect()
  {
    this.zzafD.zzpw();
  }
  
  public void disconnect()
  {
    this.zzafD.zzafp.zzpn();
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    this.zzafD.zzafp.zzagj.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */