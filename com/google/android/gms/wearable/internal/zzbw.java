package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbw
  implements Parcelable.Creator<RemoveLocalCapabilityResponse>
{
  static void zza(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemoveLocalCapabilityResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramRemoveLocalCapabilityResponse.statusCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RemoveLocalCapabilityResponse zziC(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new RemoveLocalCapabilityResponse(i, j);
  }
  
  public RemoveLocalCapabilityResponse[] zzmh(int paramInt)
  {
    return new RemoveLocalCapabilityResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */