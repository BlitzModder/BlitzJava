package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbz
  implements Parcelable.Creator<UpdateMetadataRequest>
{
  static void zza(UpdateMetadataRequest paramUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramUpdateMetadataRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramUpdateMetadataRequest.zzaoh, paramInt, false);
    zzb.zza(paramParcel, 3, paramUpdateMetadataRequest.zzaoi, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public UpdateMetadataRequest zzbX(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UpdateMetadataRequest(i, localDriveId, localMetadataBundle);
  }
  
  public UpdateMetadataRequest[] zzdS(int paramInt)
  {
    return new UpdateMetadataRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */