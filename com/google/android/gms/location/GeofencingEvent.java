package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent
{
  private final int zzFt;
  private final int zzaKW;
  private final List<Geofence> zzaKX;
  private final Location zzaKY;
  
  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    this.zzFt = paramInt1;
    this.zzaKW = paramInt2;
    this.zzaKX = paramList;
    this.zzaKY = paramLocation;
  }
  
  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return new GeofencingEvent(paramIntent.getIntExtra("gms_error_code", -1), zzy(paramIntent), zzz(paramIntent), (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
  }
  
  private static int zzy(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    if (i == -1) {}
    while ((i != 1) && (i != 2) && (i != 4)) {
      return -1;
    }
    return i;
  }
  
  private static List<Geofence> zzz(Intent paramIntent)
  {
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localObject == null) {
      return null;
    }
    paramIntent = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(ParcelableGeofence.zzo((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public int getErrorCode()
  {
    return this.zzFt;
  }
  
  public int getGeofenceTransition()
  {
    return this.zzaKW;
  }
  
  public List<Geofence> getTriggeringGeofences()
  {
    return this.zzaKX;
  }
  
  public Location getTriggeringLocation()
  {
    return this.zzaKY;
  }
  
  public boolean hasError()
  {
    return this.zzFt != -1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/GeofencingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */