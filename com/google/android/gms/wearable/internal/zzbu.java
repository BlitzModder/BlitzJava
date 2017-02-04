package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbu
  implements Parcelable.Creator<RemoveLargeAssetQueueEntriesResponse>
{
  static void zza(RemoveLargeAssetQueueEntriesResponse paramRemoveLargeAssetQueueEntriesResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemoveLargeAssetQueueEntriesResponse.versionCode);
    zzb.zza(paramParcel, 2, paramRemoveLargeAssetQueueEntriesResponse.zzSE, paramInt, false);
    zzb.zzc(paramParcel, 3, paramRemoveLargeAssetQueueEntriesResponse.zzbnu);
    zzb.zzI(paramParcel, i);
  }
  
  public RemoveLargeAssetQueueEntriesResponse zziA(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzau(paramParcel);
    Status localStatus = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localStatus = (Status)zza.zza(paramParcel, m, Status.CREATOR);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new RemoveLargeAssetQueueEntriesResponse(j, localStatus, i);
  }
  
  public RemoveLargeAssetQueueEntriesResponse[] zzmf(int paramInt)
  {
    return new RemoveLargeAssetQueueEntriesResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */