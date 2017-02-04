package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi
  implements Parcelable.Creator<LargeAssetRemoveRequest>
{
  static void zza(LargeAssetRemoveRequest paramLargeAssetRemoveRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetRemoveRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramLargeAssetRemoveRequest.zzbof, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LargeAssetRemoveRequest zzit(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    long[] arrayOfLong = null;
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
        arrayOfLong = zza.zzw(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LargeAssetRemoveRequest(i, arrayOfLong);
  }
  
  public LargeAssetRemoveRequest[] zzlV(int paramInt)
  {
    return new LargeAssetRemoveRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */