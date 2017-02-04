package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzca
  implements Parcelable.Creator<UpdatePermissionRequest>
{
  static void zza(UpdatePermissionRequest paramUpdatePermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramUpdatePermissionRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramUpdatePermissionRequest.zzamF, paramInt, false);
    zzb.zza(paramParcel, 3, paramUpdatePermissionRequest.zzano, false);
    zzb.zzc(paramParcel, 4, paramUpdatePermissionRequest.zzaqz);
    zzb.zza(paramParcel, 5, paramUpdatePermissionRequest.zzaob);
    zzb.zza(paramParcel, 6, paramUpdatePermissionRequest.zzanc, false);
    zzb.zzI(paramParcel, i);
  }
  
  public UpdatePermissionRequest zzbY(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int k = zza.zzau(paramParcel);
    int i = 0;
    String str2 = null;
    DriveId localDriveId = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 6: 
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new UpdatePermissionRequest(j, localDriveId, str2, i, bool, str1);
  }
  
  public UpdatePermissionRequest[] zzdT(int paramInt)
  {
    return new UpdatePermissionRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */