package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SetResourceParentsRequest> CREATOR = new zzbs();
  final int mVersionCode;
  final DriveId zzaod;
  final List<DriveId> zzaqx;
  
  SetResourceParentsRequest(int paramInt, DriveId paramDriveId, List<DriveId> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzaod = paramDriveId;
    this.zzaqx = paramList;
  }
  
  public SetResourceParentsRequest(DriveId paramDriveId, List<DriveId> paramList)
  {
    this(1, paramDriveId, paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbs.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/SetResourceParentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */