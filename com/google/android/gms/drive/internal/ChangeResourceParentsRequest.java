package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class ChangeResourceParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangeResourceParentsRequest> CREATOR = new zzf();
  final int mVersionCode;
  final DriveId zzaod;
  final List<DriveId> zzaoe;
  final List<DriveId> zzaof;
  
  ChangeResourceParentsRequest(int paramInt, DriveId paramDriveId, List<DriveId> paramList1, List<DriveId> paramList2)
  {
    this.mVersionCode = paramInt;
    this.zzaod = paramDriveId;
    this.zzaoe = paramList1;
    this.zzaof = paramList2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/ChangeResourceParentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */