package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.Set;

public final class zzkx
  extends zzj<zzkz>
{
  private final Bundle zzUq;
  
  public zzkx(Context paramContext, Looper paramLooper, zzf paramzzf, Auth.zza paramzza, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 16, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramzza == null) {}
    for (paramContext = new Bundle();; paramContext = paramzza.zzmb())
    {
      this.zzUq = paramContext;
      return;
    }
  }
  
  protected zzkz zzay(IBinder paramIBinder)
  {
    return zzkz.zza.zzaA(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.auth.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.auth.api.internal.IAuthService";
  }
  
  protected Bundle zzlU()
  {
    return this.zzUq;
  }
  
  public boolean zzmn()
  {
    zzf localzzf = zzqq();
    return (!TextUtils.isEmpty(localzzf.getAccountName())) && (!localzzf.zzb(Auth.PROXY_API).isEmpty());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */