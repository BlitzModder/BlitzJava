package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<NearbyDeviceFilter>
{
  static void zza(NearbyDeviceFilter paramNearbyDeviceFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramNearbyDeviceFilter.zzaXg);
    zzb.zzc(paramParcel, 1000, paramNearbyDeviceFilter.mVersionCode);
    zzb.zza(paramParcel, 2, paramNearbyDeviceFilter.zzaXh, false);
    zzb.zza(paramParcel, 3, paramNearbyDeviceFilter.zzaXi);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NearbyDeviceFilter zzfV(Parcel paramParcel)
  {
    boolean bool = false;
    int k = zza.zzau(paramParcel);
    byte[] arrayOfByte = null;
    int j = 0;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NearbyDeviceFilter(i, j, arrayOfByte, bool);
  }
  
  public NearbyDeviceFilter[] zziX(int paramInt)
  {
    return new NearbyDeviceFilter[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */