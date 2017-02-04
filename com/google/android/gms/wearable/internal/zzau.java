package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzau
  implements Parcelable.Creator<GetLargeAssetQueueStateResponse>
{
  static void zza(GetLargeAssetQueueStateResponse paramGetLargeAssetQueueStateResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetLargeAssetQueueStateResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramGetLargeAssetQueueStateResponse.zzSE, paramInt, false);
    zzb.zza(paramParcel, 3, paramGetLargeAssetQueueStateResponse.zzbnH, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetLargeAssetQueueStateResponse zzim(Parcel paramParcel)
  {
    LargeAssetQueueStateParcelable localLargeAssetQueueStateParcelable = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localLargeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable)zza.zza(paramParcel, k, LargeAssetQueueStateParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetLargeAssetQueueStateResponse(i, localStatus, localLargeAssetQueueStateParcelable);
  }
  
  public GetLargeAssetQueueStateResponse[] zzlN(int paramInt)
  {
    return new GetLargeAssetQueueStateResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */