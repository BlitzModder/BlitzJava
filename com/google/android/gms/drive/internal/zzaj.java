package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaj
  implements Parcelable.Creator<GetMetadataRequest>
{
  static void zza(GetMetadataRequest paramGetMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetMetadataRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramGetMetadataRequest.zzaoh, paramInt, false);
    zzb.zza(paramParcel, 3, paramGetMetadataRequest.zzapK);
    zzb.zzI(paramParcel, i);
  }
  
  public GetMetadataRequest zzbq(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    int i = 0;
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
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetMetadataRequest(i, localDriveId, bool);
  }
  
  public GetMetadataRequest[] zzdl(int paramInt)
  {
    return new GetMetadataRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */