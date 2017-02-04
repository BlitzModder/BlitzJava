package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<DriveId>
{
  static void zza(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramDriveId.mVersionCode);
    zzb.zza(paramParcel, 2, paramDriveId.zzamR, false);
    zzb.zza(paramParcel, 3, paramDriveId.zzamS);
    zzb.zza(paramParcel, 4, paramDriveId.zzamA);
    zzb.zzc(paramParcel, 5, paramDriveId.zzamT);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DriveId zzaK(Parcel paramParcel)
  {
    long l1 = 0L;
    int k = zza.zzau(paramParcel);
    int j = 0;
    String str = null;
    int i = -1;
    long l2 = 0L;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 3: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 4: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 5: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new DriveId(j, str, l2, l1, i);
  }
  
  public DriveId[] zzcv(int paramInt)
  {
    return new DriveId[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */