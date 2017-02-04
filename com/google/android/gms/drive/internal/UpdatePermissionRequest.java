package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzca();
  final int mVersionCode;
  final DriveId zzamF;
  final String zzanc;
  final String zzano;
  final boolean zzaob;
  final int zzaqz;
  
  UpdatePermissionRequest(int paramInt1, DriveId paramDriveId, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzamF = paramDriveId;
    this.zzano = paramString1;
    this.zzaqz = paramInt2;
    this.zzaob = paramBoolean;
    this.zzanc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzca.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/UpdatePermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */