package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<DeviceStatus>
{
  static void zza(DeviceStatus paramDeviceStatus, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramDeviceStatus.getVersionCode());
    zzb.zza(paramParcel, 2, paramDeviceStatus.zznS());
    zzb.zza(paramParcel, 3, paramDeviceStatus.zzob());
    zzb.zzc(paramParcel, 4, paramDeviceStatus.zznT());
    zzb.zza(paramParcel, 5, paramDeviceStatus.getApplicationMetadata(), paramInt, false);
    zzb.zzc(paramParcel, 6, paramDeviceStatus.zznU());
    zzb.zzI(paramParcel, i);
  }
  
  public DeviceStatus zzae(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzau(paramParcel);
    double d = 0.0D;
    ApplicationMetadata localApplicationMetadata = null;
    int j = 0;
    boolean bool = false;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        d = zza.zzn(paramParcel, n);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localApplicationMetadata = (ApplicationMetadata)zza.zza(paramParcel, n, ApplicationMetadata.CREATOR);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new DeviceStatus(k, d, bool, j, localApplicationMetadata, i);
  }
  
  public DeviceStatus[] zzbo(int paramInt)
  {
    return new DeviceStatus[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */