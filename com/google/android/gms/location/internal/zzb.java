package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzb
  extends zzj<zzi>
{
  private final String zzaLE;
  protected final zzp<zzi> zzaLF = new zzp()
  {
    public void zzqr()
    {
      zzb.zza(zzb.this);
    }
    
    public zzi zzya()
      throws DeadObjectException
    {
      return (zzi)zzb.this.zzqs();
    }
  };
  
  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, 23, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzaLE = paramString;
  }
  
  protected zzi zzcg(IBinder paramIBinder)
  {
    return zzi.zza.zzcj(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected Bundle zzlU()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.zzaLE);
    return localBundle;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */