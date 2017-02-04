package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<NearbyAlertRequest>
{
  static void zza(NearbyAlertRequest paramNearbyAlertRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramNearbyAlertRequest.zzyj());
    zzb.zzc(paramParcel, 1000, paramNearbyAlertRequest.getVersionCode());
    zzb.zzc(paramParcel, 2, paramNearbyAlertRequest.zzym());
    zzb.zza(paramParcel, 3, paramNearbyAlertRequest.zzyn(), paramInt, false);
    zzb.zza(paramParcel, 4, paramNearbyAlertRequest.zzyo(), paramInt, false);
    zzb.zza(paramParcel, 5, paramNearbyAlertRequest.zzyp());
    zzb.zzc(paramParcel, 6, paramNearbyAlertRequest.zzyq());
    zzb.zzI(paramParcel, i);
  }
  
  public NearbyAlertRequest zzeU(Parcel paramParcel)
  {
    NearbyAlertFilter localNearbyAlertFilter = null;
    int i = 0;
    int n = zza.zzau(paramParcel);
    int j = -1;
    boolean bool = false;
    PlaceFilter localPlaceFilter = null;
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
        k = zza.zzg(paramParcel, i1);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        localPlaceFilter = (PlaceFilter)zza.zza(paramParcel, i1, PlaceFilter.CREATOR);
        break;
      case 4: 
        localNearbyAlertFilter = (NearbyAlertFilter)zza.zza(paramParcel, i1, NearbyAlertFilter.CREATOR);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 6: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new NearbyAlertRequest(m, k, j, localPlaceFilter, localNearbyAlertFilter, bool, i);
  }
  
  public NearbyAlertRequest[] zzhC(int paramInt)
  {
    return new NearbyAlertRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */