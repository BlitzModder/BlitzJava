package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<DataSourcesResult>
{
  static void zza(DataSourcesResult paramDataSourcesResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramDataSourcesResult.getDataSources(), false);
    zzb.zzc(paramParcel, 1000, paramDataSourcesResult.getVersionCode());
    zzb.zza(paramParcel, 2, paramDataSourcesResult.getStatus(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public DataSourcesResult zzdJ(Parcel paramParcel)
  {
    Status localStatus = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataSourcesResult(i, localArrayList, localStatus);
  }
  
  public DataSourcesResult[] zzfK(int paramInt)
  {
    return new DataSourcesResult[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */