package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<VisibleRegion>
{
  static void zza(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramVisibleRegion.getVersionCode());
    zzb.zza(paramParcel, 2, paramVisibleRegion.nearLeft, paramInt, false);
    zzb.zza(paramParcel, 3, paramVisibleRegion.nearRight, paramInt, false);
    zzb.zza(paramParcel, 4, paramVisibleRegion.farLeft, paramInt, false);
    zzb.zza(paramParcel, 5, paramVisibleRegion.farRight, paramInt, false);
    zzb.zza(paramParcel, 6, paramVisibleRegion.latLngBounds, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public VisibleRegion zzfB(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
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
        localLatLng4 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        localLatLng3 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 4: 
        localLatLng2 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localLatLng1 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)zza.zza(paramParcel, k, LatLngBounds.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new VisibleRegion(i, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }
  
  public VisibleRegion[] zzim(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */