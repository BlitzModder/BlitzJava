package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

public abstract interface GeofencingApi
{
  public abstract PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent);
  
  @Deprecated
  public abstract PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, List<String> paramList);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/GeofencingApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */