package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbr
  implements Parcelable.Creator<PackageStorageInfo>
{
  static void zza(PackageStorageInfo paramPackageStorageInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPackageStorageInfo.versionCode);
    zzb.zza(paramParcel, 2, paramPackageStorageInfo.packageName, false);
    zzb.zza(paramParcel, 3, paramPackageStorageInfo.label, false);
    zzb.zza(paramParcel, 4, paramPackageStorageInfo.zzboB);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PackageStorageInfo zziy(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PackageStorageInfo(i, str2, str1, l);
  }
  
  public PackageStorageInfo[] zzma(int paramInt)
  {
    return new PackageStorageInfo[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */