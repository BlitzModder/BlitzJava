package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLocationSettingsRequest.zzux(), false);
    zzb.zzc(paramParcel, 1000, paramLocationSettingsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramLocationSettingsRequest.zzxY());
    zzb.zza(paramParcel, 3, paramLocationSettingsRequest.zzxZ());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationSettingsRequest zzeJ(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
    boolean bool1 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsRequest(i, localArrayList, bool1, bool2);
  }
  
  public LocationSettingsRequest[] zzhm(int paramInt)
  {
    return new LocationSettingsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */