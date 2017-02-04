package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzai
  implements Parcelable.Creator<GetAllCapabilitiesResponse>
{
  static void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetAllCapabilitiesResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetAllCapabilitiesResponse.statusCode);
    zzb.zzc(paramParcel, 3, paramGetAllCapabilitiesResponse.zzbnw, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetAllCapabilitiesResponse zzia(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, m, CapabilityInfoParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetAllCapabilitiesResponse(i, j, localArrayList);
  }
  
  public GetAllCapabilitiesResponse[] zzlB(int paramInt)
  {
    return new GetAllCapabilitiesResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */