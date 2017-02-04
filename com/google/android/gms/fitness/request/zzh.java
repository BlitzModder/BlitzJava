package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<DataSourcesRequest>
{
  static void zza(DataSourcesRequest paramDataSourcesRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramDataSourcesRequest.getDataTypes(), false);
    zzb.zzc(paramParcel, 1000, paramDataSourcesRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramDataSourcesRequest.zzur(), false);
    zzb.zza(paramParcel, 3, paramDataSourcesRequest.zzus());
    zzb.zza(paramParcel, 4, paramDataSourcesRequest.zzui(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DataSourcesRequest zzdi(Parcel paramParcel)
  {
    boolean bool = false;
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList2 = zza.zzc(paramParcel, k, DataType.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList1 = zza.zzC(paramParcel, k);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 4: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataSourcesRequest(i, localArrayList2, localArrayList1, bool, localIBinder);
  }
  
  public DataSourcesRequest[] zzfi(int paramInt)
  {
    return new DataSourcesRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */