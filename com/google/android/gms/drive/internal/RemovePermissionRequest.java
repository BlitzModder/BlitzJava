package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemovePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemovePermissionRequest> CREATOR = new zzbp();
  final int mVersionCode;
  final DriveId zzamF;
  final String zzanc;
  final String zzano;
  final boolean zzaob;
  
  RemovePermissionRequest(int paramInt, DriveId paramDriveId, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzamF = paramDriveId;
    this.zzano = paramString1;
    this.zzaob = paramBoolean;
    this.zzanc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/RemovePermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */