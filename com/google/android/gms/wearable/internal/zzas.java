package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzas
  implements Parcelable.Creator<GetDataItemResponse>
{
  static void zza(GetDataItemResponse paramGetDataItemResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetDataItemResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetDataItemResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetDataItemResponse.zzbnF, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetDataItemResponse zzik(Parcel paramParcel)
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
    return new GetDataItemResponse(i, j, localDataItemParcelable);
  }
  
  public GetDataItemResponse[] zzlL(int paramInt)
  {
    return new GetDataItemResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */