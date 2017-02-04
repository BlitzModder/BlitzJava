package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new zzbz();
  final int mVersionCode;
  final DriveId zzaoh;
  final MetadataBundle zzaoi;
  
  UpdateMetadataRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzaoh = paramDriveId;
    this.zzaoi = paramMetadataBundle;
  }
  
  public UpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this(1, paramDriveId, paramMetadataBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbz.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/UpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */