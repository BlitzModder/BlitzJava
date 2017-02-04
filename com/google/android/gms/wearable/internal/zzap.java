package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzap
  implements Parcelable.Creator<GetConfigResponse>
{
  static void zza(GetConfigResponse paramGetConfigResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetConfigResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetConfigResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetConfigResponse.zzbnC, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetConfigResponse zzih(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    ConnectionConfiguration localConnectionConfiguration = null;
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
        localConnectionConfiguration = (ConnectionConfiguration)zza.zza(paramParcel, m, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetConfigResponse(i, j, localConnectionConfiguration);
  }
  
  public GetConfigResponse[] zzlI(int paramInt)
  {
    return new GetConfigResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */