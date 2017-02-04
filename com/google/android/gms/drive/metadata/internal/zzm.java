package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PartialDriveId>
{
  static void zza(PartialDriveId paramPartialDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPartialDriveId.mVersionCode);
    zzb.zza(paramParcel, 2, paramPartialDriveId.zzamR, false);
    zzb.zza(paramParcel, 3, paramPartialDriveId.zzamS);
    zzb.zzc(paramParcel, 4, paramPartialDriveId.zzamT);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PartialDriveId zzce(Parcel paramParcel)
  {
    int k = zza.zzau(paramParcel);
    int j = 0;
    String str = null;
    long l = 0L;
    int i = -1;
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
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PartialDriveId(j, str, l, i);
  }
  
  public PartialDriveId[] zzdZ(int paramInt)
  {
    return new PartialDriveId[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */