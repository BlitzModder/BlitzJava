package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaq
  implements Parcelable.Creator<ListParentsRequest>
{
  static void zza(ListParentsRequest paramListParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramListParentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramListParentsRequest.zzapM, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ListParentsRequest zzbt(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ListParentsRequest(i, localDriveId);
  }
  
  public ListParentsRequest[] zzdo(int paramInt)
  {
    return new ListParentsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */