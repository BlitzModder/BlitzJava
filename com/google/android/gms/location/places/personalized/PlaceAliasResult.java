package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlaceAliasResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlaceAliasResult> CREATOR = new zzc();
  final int mVersionCode;
  private final Status zzTA;
  final PlaceUserData zzaOu;
  
  PlaceAliasResult(int paramInt, Status paramStatus, PlaceUserData paramPlaceUserData)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzaOu = paramPlaceUserData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public PlaceUserData zzyP()
  {
    return this.zzaOu;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/personalized/PlaceAliasResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */