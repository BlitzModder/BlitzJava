package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbp
  implements Parcelable.Creator<RemovePermissionRequest>
{
  static void zza(RemovePermissionRequest paramRemovePermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemovePermissionRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRemovePermissionRequest.zzamF, paramInt, false);
    zzb.zza(paramParcel, 3, paramRemovePermissionRequest.zzano, false);
    zzb.zza(paramParcel, 4, paramRemovePermissionRequest.zzaob);
    zzb.zza(paramParcel, 5, paramRemovePermissionRequest.zzanc, false);
    zzb.zzI(paramParcel, i);
  }
  
  public RemovePermissionRequest zzbO(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzau(paramParcel);
    String str2 = null;
    DriveId localDriveId = null;
    int i = 0;
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
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RemovePermissionRequest(i, localDriveId, str2, bool, str1);
  }
  
  public RemovePermissionRequest[] zzdJ(int paramInt)
  {
    return new RemovePermissionRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */