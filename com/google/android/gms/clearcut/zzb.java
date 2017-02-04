package com.google.android.gms.clearcut;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract interface zzb
{
  public abstract PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable);
  
  public abstract boolean zza(GoogleApiClient paramGoogleApiClient, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/clearcut/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */