package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi
  implements Parcelable.Creator<ReadRawResult>
{
  static void zza(ReadRawResult paramReadRawResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramReadRawResult.zzsA(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramReadRawResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramReadRawResult.zzuM(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public ReadRawResult zzdN(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localArrayList = zza.zzc(paramParcel, k, DataHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ReadRawResult(i, localDataHolder, localArrayList);
  }
  
  public ReadRawResult[] zzfO(int paramInt)
  {
    return new ReadRawResult[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */