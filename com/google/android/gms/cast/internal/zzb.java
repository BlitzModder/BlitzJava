package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zza;

public abstract class zzb<R extends Result>
  extends zzlx.zza<R, zze>
{
  public zzb(GoogleApiClient paramGoogleApiClient)
  {
    super(zzk.zzTo, paramGoogleApiClient);
  }
  
  public void zzbj(int paramInt)
  {
    zzb(zzc(new Status(paramInt)));
  }
  
  public void zzg(int paramInt, String paramString)
  {
    zzb(zzc(new Status(paramInt, paramString, null)));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */