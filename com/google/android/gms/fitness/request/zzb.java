package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.fitness.data.BleDevice;

public class zzb
  implements Parcelable.Creator<ClaimBleDeviceRequest>
{
  static void zza(ClaimBleDeviceRequest paramClaimBleDeviceRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramClaimBleDeviceRequest.getDeviceAddress(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramClaimBleDeviceRequest.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramClaimBleDeviceRequest.zzuh(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramClaimBleDeviceRequest.zzui(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public ClaimBleDeviceRequest zzdc(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      Object localObject3;
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = zza.zzp(paramParcel, k);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (BleDevice)zza.zza(paramParcel, k, BleDevice.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localIBinder = zza.zzq(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ClaimBleDeviceRequest(i, (String)localObject1, (BleDevice)localObject2, localIBinder);
  }
  
  public ClaimBleDeviceRequest[] zzfc(int paramInt)
  {
    return new ClaimBleDeviceRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */