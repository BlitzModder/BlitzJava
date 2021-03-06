package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah
  implements Parcelable.Creator<EnqueueLargeAssetResponse>
{
  static void zza(EnqueueLargeAssetResponse paramEnqueueLargeAssetResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramEnqueueLargeAssetResponse.mVersionCode);
    zzb.zzc(paramParcel, 2, paramEnqueueLargeAssetResponse.statusCode);
    zzb.zza(paramParcel, 3, paramEnqueueLargeAssetResponse.zzbnv, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public EnqueueLargeAssetResponse zzhZ(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    LargeAssetQueueEntryParcelable localLargeAssetQueueEntryParcelable = null;
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
        localLargeAssetQueueEntryParcelable = (LargeAssetQueueEntryParcelable)zza.zza(paramParcel, m, LargeAssetQueueEntryParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new EnqueueLargeAssetResponse(i, j, localLargeAssetQueueEntryParcelable);
  }
  
  public EnqueueLargeAssetResponse[] zzlA(int paramInt)
  {
    return new EnqueueLargeAssetResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */