package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
  final int mVersionCode;
  final String zzanc;
  final boolean zzand;
  final DriveId zzaoh;
  final MetadataBundle zzaoi;
  final Contents zzaoj;
  final int zzaok;
  final int zzaol;
  final boolean zzaom;
  
  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaoh = paramDriveId;
    this.zzaoi = paramMetadataBundle;
    this.zzaoj = paramContents;
    this.zzand = paramBoolean1;
    this.zzanc = paramString;
    this.zzaok = paramInt2;
    this.zzaol = paramInt3;
    this.zzaom = paramBoolean2;
  }
  
  public CloseContentsAndUpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt, boolean paramBoolean, ExecutionOptions paramExecutionOptions)
  {
    this(1, paramDriveId, paramMetadataBundle, null, paramExecutionOptions.zzsm(), paramExecutionOptions.zzsl(), paramExecutionOptions.zzsn(), paramInt, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/CloseContentsAndUpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */