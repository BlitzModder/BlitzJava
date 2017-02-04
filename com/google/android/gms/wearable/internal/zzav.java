package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzav
  implements Parcelable.Creator<GetLocalNodeResponse>
{
  static void zza(GetLocalNodeResponse paramGetLocalNodeResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetLocalNodeResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetLocalNodeResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetLocalNodeResponse.zzbnI, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetLocalNodeResponse zzin(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    NodeParcelable localNodeParcelable = null;
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
        localNodeParcelable = (NodeParcelable)zza.zza(paramParcel, m, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetLocalNodeResponse(i, j, localNodeParcelable);
  }
  
  public GetLocalNodeResponse[] zzlO(int paramInt)
  {
    return new GetLocalNodeResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */