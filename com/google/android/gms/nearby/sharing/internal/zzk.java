package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<TrustedDevicesRequest>
{
  static void zza(TrustedDevicesRequest paramTrustedDevicesRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramTrustedDevicesRequest.versionCode);
    zzb.zza(paramParcel, 2, paramTrustedDevicesRequest.zzaYd, false);
    zzb.zza(paramParcel, 3, paramTrustedDevicesRequest.zzaYe, false);
    zzb.zza(paramParcel, 4, paramTrustedDevicesRequest.zzCJ(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TrustedDevicesRequest zzgm(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 4: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new TrustedDevicesRequest(i, str, arrayOfByte, localIBinder);
  }
  
  public TrustedDevicesRequest[] zzjo(int paramInt)
  {
    return new TrustedDevicesRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */