package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzkk
  extends zzj<zzkn>
{
  private final String zzTz;
  
  public zzkk(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 77, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzTz = paramzzf.zzqd();
  }
  
  private Bundle zzlV()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("authPackage", this.zzTz);
    return localBundle;
  }
  
  public void zza(zzkm paramzzkm)
  {
    try
    {
      ((zzkn)zzqs()).zza(paramzzkm);
      return;
    }
    catch (RemoteException paramzzkm) {}
  }
  
  public void zza(zzkm paramzzkm, String paramString)
  {
    try
    {
      ((zzkn)zzqs()).zza(paramzzkm, paramString);
      return;
    }
    catch (RemoteException paramzzkm) {}
  }
  
  protected zzkn zzaj(IBinder paramIBinder)
  {
    return zzkn.zza.zzal(paramIBinder);
  }
  
  public void zzb(zzkm paramzzkm, String paramString)
  {
    try
    {
      ((zzkn)zzqs()).zzb(paramzzkm, paramString);
      return;
    }
    catch (RemoteException paramzzkm) {}
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.appinvite.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.appinvite.internal.IAppInviteService";
  }
  
  protected Bundle zzlU()
  {
    return zzlV();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */