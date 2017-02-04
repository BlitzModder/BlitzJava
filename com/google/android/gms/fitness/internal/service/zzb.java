package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzb
  implements Parcelable.Creator<FitnessUnregistrationRequest>
{
  static void zza(FitnessUnregistrationRequest paramFitnessUnregistrationRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramFitnessUnregistrationRequest.getDataSource(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramFitnessUnregistrationRequest.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FitnessUnregistrationRequest zzdb(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    DataSource localDataSource = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localDataSource = (DataSource)zza.zza(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FitnessUnregistrationRequest(i, localDataSource);
  }
  
  public FitnessUnregistrationRequest[] zzfb(int paramInt)
  {
    return new FitnessUnregistrationRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/internal/service/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */