package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();
  final int mVersionCode;
  final DriveId zzamF;
  final Permission zzanY;
  final boolean zzanZ;
  final String zzanc;
  final String zzaoa;
  final boolean zzaob;
  
  AddPermissionRequest(int paramInt, DriveId paramDriveId, Permission paramPermission, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzamF = paramDriveId;
    this.zzanY = paramPermission;
    this.zzanZ = paramBoolean1;
    this.zzaoa = paramString1;
    this.zzaob = paramBoolean2;
    this.zzanc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/AddPermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */