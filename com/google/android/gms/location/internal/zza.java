package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.zza;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramPendingIntent);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramLong, this.zzaLC);
        zzb(Status.zzaeX);
      }
    });
  }
  
  private static abstract class zza
    extends ActivityRecognition.zza<Status>
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */