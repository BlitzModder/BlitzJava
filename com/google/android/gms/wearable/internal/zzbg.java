package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg
  implements Parcelable.Creator<LargeAssetQueueStateChangeParcelable>
{
  static void zza(LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetQueueStateChangeParcelable.mVersionCode);
    zzb.zza(paramParcel, 4, paramLargeAssetQueueStateChangeParcelable.zzbnX, paramInt, false);
    zzb.zza(paramParcel, 5, paramLargeAssetQueueStateChangeParcelable.zzGV(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LargeAssetQueueStateChangeParcelable zzir(Parcel paramParcel)
  {
    LargeAssetQueueStateParcelable localLargeAssetQueueStateParcelable = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      case 2: 
      case 3: 
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        continue;
        localLargeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable)zza.zza(paramParcel, k, LargeAssetQueueStateParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LargeAssetQueueStateChangeParcelable(i, localDataHolder, localLargeAssetQueueStateParcelable);
  }
  
  public LargeAssetQueueStateChangeParcelable[] zzlS(int paramInt)
  {
    return new LargeAssetQueueStateChangeParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */