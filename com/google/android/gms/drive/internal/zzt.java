package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.internal.zzlx.zza;

public abstract class zzt<R extends Result>
  extends zzlx.zza<R, zzu>
{
  public zzt(GoogleApiClient paramGoogleApiClient)
  {
    super(Drive.zzTo, paramGoogleApiClient);
  }
  
  public static abstract class zza
    extends zzt<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */