package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlacePhotoMetadataResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
  final int mVersionCode;
  private final Status zzTA;
  final DataHolder zzaML;
  private final PlacePhotoMetadataBuffer zzaMM;
  
  PlacePhotoMetadataResult(int paramInt, Status paramStatus, DataHolder paramDataHolder)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzaML = paramDataHolder;
    if (paramDataHolder == null)
    {
      this.zzaMM = null;
      return;
    }
    this.zzaMM = new PlacePhotoMetadataBuffer(this.zzaML);
  }
  
  public PlacePhotoMetadataResult(Status paramStatus, DataHolder paramDataHolder)
  {
    this(0, paramStatus, paramDataHolder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PlacePhotoMetadataBuffer getPhotoMetadata()
  {
    return this.zzaMM;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlacePhotoMetadataResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */