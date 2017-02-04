package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbk
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void zza(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOpenContentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramOpenContentsRequest.zzaoh, paramInt, false);
    zzb.zzc(paramParcel, 3, paramOpenContentsRequest.zzamE);
    zzb.zzc(paramParcel, 4, paramOpenContentsRequest.zzaqt);
    zzb.zzI(paramParcel, i);
  }
  
  public OpenContentsRequest zzbK(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    int k = 0;
    if (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
      }
      for (;;)
      {
        break;
        k = zza.zzg(paramParcel, n);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        continue;
        j = zza.zzg(paramParcel, n);
        continue;
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new OpenContentsRequest(k, localDriveId, j, i);
  }
  
  public OpenContentsRequest[] zzdF(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */