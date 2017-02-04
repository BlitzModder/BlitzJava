package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationAvailability
  implements SafeParcelable
{
  public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
  private final int mVersionCode;
  int zzaLg;
  int zzaLh;
  long zzaLi;
  int zzaLj;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.mVersionCode = paramInt1;
    this.zzaLj = paramInt2;
    this.zzaLg = paramInt3;
    this.zzaLh = paramInt4;
    this.zzaLi = paramLong;
  }
  
  public static LocationAvailability extractLocationAvailability(Intent paramIntent)
  {
    if (!hasLocationAvailability(paramIntent)) {
      return null;
    }
    return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public static boolean hasLocationAvailability(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationAvailability)) {}
    do
    {
      return false;
      paramObject = (LocationAvailability)paramObject;
    } while ((this.zzaLj != ((LocationAvailability)paramObject).zzaLj) || (this.zzaLg != ((LocationAvailability)paramObject).zzaLg) || (this.zzaLh != ((LocationAvailability)paramObject).zzaLh) || (this.zzaLi != ((LocationAvailability)paramObject).zzaLi));
    return true;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaLj), Integer.valueOf(this.zzaLg), Integer.valueOf(this.zzaLh), Long.valueOf(this.zzaLi) });
  }
  
  public boolean isLocationAvailable()
  {
    return this.zzaLj < 1000;
  }
  
  public String toString()
  {
    return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationAvailabilityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/LocationAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */