package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzq
  implements SettingsApi
{
  public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest)
  {
    return zza(paramGoogleApiClient, paramLocationSettingsRequest, null);
  }
  
  public PendingResult<LocationSettingsResult> zza(GoogleApiClient paramGoogleApiClient, final LocationSettingsRequest paramLocationSettingsRequest, final String paramString)
  {
    paramGoogleApiClient.zza(new LocationServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramLocationSettingsRequest, this, paramString);
      }
      
      public LocationSettingsResult zzaO(Status paramAnonymousStatus)
      {
        return new LocationSettingsResult(paramAnonymousStatus);
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */