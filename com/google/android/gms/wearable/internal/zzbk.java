package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbk
  implements Parcelable.Creator<LargeAssetSyncRequestPayload>
{
  static void zza(LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetSyncRequestPayload.versionCode);
    zzb.zza(paramParcel, 2, paramLargeAssetSyncRequestPayload.zzbnK, false);
    zzb.zza(paramParcel, 3, paramLargeAssetSyncRequestPayload.zzbom);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LargeAssetSyncRequestPayload zziu(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str = null;
    long l = 0L;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LargeAssetSyncRequestPayload(i, str, l);
  }
  
  public LargeAssetSyncRequestPayload[] zzlW(int paramInt)
  {
    return new LargeAssetSyncRequestPayload[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */