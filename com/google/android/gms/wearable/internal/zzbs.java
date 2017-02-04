package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbs
  implements Parcelable.Creator<PutDataResponse>
{
  static void zza(PutDataResponse paramPutDataResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPutDataResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramPutDataResponse.statusCode);
    zzb.zza(paramParcel, 3, paramPutDataResponse.zzbnF, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PutDataResponse zziz(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    DataItemParcelable localDataItemParcelable = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localDataItemParcelable = (DataItemParcelable)zza.zza(paramParcel, m, DataItemParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PutDataResponse(i, j, localDataItemParcelable);
  }
  
  public PutDataResponse[] zzmb(int paramInt)
  {
    return new PutDataResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */