package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<Device>
{
  static void zza(Device paramDevice, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramDevice.getManufacturer(), false);
    zzb.zzc(paramParcel, 1000, paramDevice.getVersionCode());
    zzb.zza(paramParcel, 2, paramDevice.getModel(), false);
    zzb.zza(paramParcel, 3, paramDevice.getVersion(), false);
    zzb.zza(paramParcel, 4, paramDevice.zztP(), false);
    zzb.zzc(paramParcel, 5, paramDevice.getType());
    zzb.zzc(paramParcel, 6, paramDevice.zztN());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Device zzcQ(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int m = zza.zzau(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zza.zzp(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 4: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 5: 
        j = zza.zzg(paramParcel, n);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new Device(k, str4, str3, str2, str1, j, i);
  }
  
  public Device[] zzeP(int paramInt)
  {
    return new Device[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */