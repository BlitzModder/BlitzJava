package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  private final int mVersionCode;
  public final String name;
  public final LatLng zzaQI;
  public final String zzaQJ;
  
  PointOfInterest(int paramInt, LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaQI = paramLatLng;
    this.zzaQJ = paramString1;
    this.name = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/PointOfInterest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */