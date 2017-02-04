package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.fitness.zza;
import java.util.Set;

public abstract class zzor<T extends IInterface>
  extends zzj<T>
{
  protected zzor(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, paramInt, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected Set<Scope> zzb(Set<Scope> paramSet)
  {
    return zza.zze(paramSet);
  }
  
  public boolean zzmn()
  {
    return !zzoo.zzaC(getContext());
  }
  
  public boolean zzqu()
  {
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */