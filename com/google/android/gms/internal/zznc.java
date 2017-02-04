package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zznc<R extends Result>
  extends zzlx.zza<R, zznd>
{
  public zznc(GoogleApiClient paramGoogleApiClient)
  {
    super(zzmz.zzTo, paramGoogleApiClient);
  }
  
  static abstract class zza
    extends zznc<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zznc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */