package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ReadStatsRequest>
{
  static void zza(ReadStatsRequest paramReadStatsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramReadStatsRequest.zzui(), false);
    zzb.zzc(paramParcel, 1000, paramReadStatsRequest.getVersionCode());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ReadStatsRequest zzdr(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ReadStatsRequest(i, localIBinder);
  }
  
  public ReadStatsRequest[] zzfr(int paramInt)
  {
    return new ReadStatsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */