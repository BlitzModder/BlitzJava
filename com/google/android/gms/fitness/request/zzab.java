package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab
  implements Parcelable.Creator<StopBleScanRequest>
{
  static void zza(StopBleScanRequest paramStopBleScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramStopBleScanRequest.zzuE(), false);
    zzb.zzc(paramParcel, 1000, paramStopBleScanRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramStopBleScanRequest.zzui(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StopBleScanRequest zzdB(Parcel paramParcel)
  {
    IBinder localIBinder2 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    IBinder localIBinder1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localIBinder2 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StopBleScanRequest(i, localIBinder1, localIBinder2);
  }
  
  public StopBleScanRequest[] zzfC(int paramInt)
  {
    return new StopBleScanRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */