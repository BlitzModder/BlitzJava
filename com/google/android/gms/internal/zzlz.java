package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;

public class zzlz
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> zzafm;
  private final int zzafn;
  private zzmi zzafo;
  
  public zzlz(Api<?> paramApi, int paramInt)
  {
    this.zzafm = paramApi;
    this.zzafn = paramInt;
  }
  
  private void zzoT()
  {
    zzx.zzb(this.zzafo, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
  }
  
  public void onConnected(Bundle paramBundle)
  {
    zzoT();
    this.zzafo.onConnected(paramBundle);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzoT();
    this.zzafo.zza(paramConnectionResult, this.zzafm, this.zzafn);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzoT();
    this.zzafo.onConnectionSuspended(paramInt);
  }
  
  public void zza(zzmi paramzzmi)
  {
    this.zzafo = paramzzmi;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */