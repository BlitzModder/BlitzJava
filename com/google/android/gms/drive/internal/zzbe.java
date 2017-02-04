package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe
  implements Parcelable.Creator<OnListParentsResponse>
{
  static void zza(OnListParentsResponse paramOnListParentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnListParentsResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnListParentsResponse.zzaqq, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnListParentsResponse zzbE(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnListParentsResponse(i, localDataHolder);
  }
  
  public OnListParentsResponse[] zzdz(int paramInt)
  {
    return new OnListParentsResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */