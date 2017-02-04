package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzca
  implements Parcelable.Creator<StorageInfoResponse>
{
  static void zza(StorageInfoResponse paramStorageInfoResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramStorageInfoResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramStorageInfoResponse.statusCode);
    zzb.zza(paramParcel, 3, paramStorageInfoResponse.zzboB);
    zzb.zzc(paramParcel, 4, paramStorageInfoResponse.zzboH, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StorageInfoResponse zziE(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzau(paramParcel);
    long l = 0L;
    ArrayList localArrayList = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, m, PackageStorageInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new StorageInfoResponse(j, i, l, localArrayList);
  }
  
  public StorageInfoResponse[] zzmj(int paramInt)
  {
    return new StorageInfoResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */