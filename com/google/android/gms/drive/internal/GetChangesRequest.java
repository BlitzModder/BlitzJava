package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Set;

public class GetChangesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzah();
  final int mVersionCode;
  final List<DriveSpace> zzanF;
  private final Set<DriveSpace> zzanG;
  final ChangeSequenceNumber zzapF;
  final int zzapG;
  final boolean zzapH;
  
  private GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList, Set<DriveSpace> paramSet, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzapF = paramChangeSequenceNumber;
    this.zzapG = paramInt2;
    this.zzanF = paramList;
    this.zzanG = paramSet;
    this.zzapH = paramBoolean;
  }
  
  GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList, boolean paramBoolean) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/GetChangesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */