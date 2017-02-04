package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzrj.zza;

public class zzd
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzf zzaYl;
  private final zzrj.zza zzaYw;
  private boolean zzaYx;
  
  public zzd(zzrj.zza paramzza)
  {
    this.zzaYw = paramzza;
    this.zzaYl = null;
    this.zzaYx = true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.zzaYl.zzas(false);
    if ((this.zzaYx) && (this.zzaYw != null)) {
      this.zzaYw.zzCX();
    }
    this.zzaYx = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzaYl.zzas(true);
    if ((this.zzaYx) && (this.zzaYw != null))
    {
      if (!paramConnectionResult.hasResolution()) {
        break label48;
      }
      this.zzaYw.zze(paramConnectionResult.getResolution());
    }
    for (;;)
    {
      this.zzaYx = false;
      return;
      label48:
      this.zzaYw.zzCY();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaYl.zzas(true);
  }
  
  public void zza(zzf paramzzf)
  {
    this.zzaYl = paramzzf;
  }
  
  public void zzar(boolean paramBoolean)
  {
    this.zzaYx = paramBoolean;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/playlog/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */