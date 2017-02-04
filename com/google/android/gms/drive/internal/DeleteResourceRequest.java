package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeleteResourceRequest> CREATOR = new zzq();
  final int mVersionCode;
  final DriveId zzaoh;
  
  DeleteResourceRequest(int paramInt, DriveId paramDriveId)
  {
    this.mVersionCode = paramInt;
    this.zzaoh = paramDriveId;
  }
  
  public DeleteResourceRequest(DriveId paramDriveId)
  {
    this(1, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/DeleteResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */