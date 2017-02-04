package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<NearbyDevice>
{
  static void zza(NearbyDevice paramNearbyDevice, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramNearbyDevice.zzCI(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramNearbyDevice.mVersionCode);
    zzb.zza(paramParcel, 2, paramNearbyDevice.getUrl(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public NearbyDevice zzfU(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    NearbyDeviceId localNearbyDeviceId = null;
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
        localNearbyDeviceId = (NearbyDeviceId)zza.zza(paramParcel, k, NearbyDeviceId.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new NearbyDevice(i, localNearbyDeviceId, str);
  }
  
  public NearbyDevice[] zziW(int paramInt)
  {
    return new NearbyDevice[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */