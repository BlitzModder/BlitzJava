package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbh
  implements Parcelable.Creator<LargeAssetQueueStateParcelable>
{
  static void zza(LargeAssetQueueStateParcelable paramLargeAssetQueueStateParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetQueueStateParcelable.mVersionCode);
    zzb.zzc(paramParcel, 2, paramLargeAssetQueueStateParcelable.zzbnZ);
    zzb.zza(paramParcel, 3, paramLargeAssetQueueStateParcelable.zzboa, false);
    zzb.zza(paramParcel, 4, paramLargeAssetQueueStateParcelable.zzGW(), false);
    zzb.zzc(paramParcel, 5, paramLargeAssetQueueStateParcelable.zzboc);
    zzb.zzc(paramParcel, 6, paramLargeAssetQueueStateParcelable.zzbod);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LargeAssetQueueStateParcelable zzis(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int i = 0;
    int n = zza.zzau(paramParcel);
    int j = 0;
    String str = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        str = zza.zzp(paramParcel, i1);
        break;
      case 4: 
        localBundle = zza.zzr(paramParcel, i1);
        break;
      case 5: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new LargeAssetQueueStateParcelable(m, k, str, localBundle, j, i);
  }
  
  public LargeAssetQueueStateParcelable[] zzlU(int paramInt)
  {
    return new LargeAssetQueueStateParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */