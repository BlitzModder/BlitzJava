package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj
  implements Parcelable.Creator<ControlProgressRequest>
{
  static void zza(ControlProgressRequest paramControlProgressRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramControlProgressRequest.mVersionCode);
    zzb.zzc(paramParcel, 2, paramControlProgressRequest.zzaoo);
    zzb.zzc(paramParcel, 3, paramControlProgressRequest.zzaop);
    zzb.zza(paramParcel, 4, paramControlProgressRequest.zzamF, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ControlProgressRequest zzbe(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        break;
      case 4: 
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ControlProgressRequest(i, j, k, localDriveId);
  }
  
  public ControlProgressRequest[] zzcU(int paramInt)
  {
    return new ControlProgressRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */