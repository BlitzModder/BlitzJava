package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd
  implements Parcelable.Creator<DisconnectRequest>
{
  static void zza(DisconnectRequest paramDisconnectRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramDisconnectRequest.zzCm(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDisconnectRequest.versionCode);
    zzb.zza(paramParcel, 2, paramDisconnectRequest.zzui(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public DisconnectRequest zzfK(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Device localDevice = null;
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
        localDevice = (Device)zza.zza(paramParcel, k, Device.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DisconnectRequest(i, localDevice, localIBinder);
  }
  
  public DisconnectRequest[] zziD(int paramInt)
  {
    return new DisconnectRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */