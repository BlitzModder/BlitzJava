package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzo
  implements Parcelable.Creator<RawDataSet>
{
  static void zza(RawDataSet paramRawDataSet, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRawDataSet.zzauX);
    zzb.zzc(paramParcel, 1000, paramRawDataSet.mVersionCode);
    zzb.zzc(paramParcel, 2, paramRawDataSet.zzauZ);
    zzb.zzc(paramParcel, 3, paramRawDataSet.zzava, false);
    zzb.zza(paramParcel, 4, paramRawDataSet.zzaud);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RawDataSet zzcV(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    int j = 0;
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
        j = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        i = zza.zzg(paramParcel, n);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, n, RawDataPoint.CREATOR);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new RawDataSet(k, j, i, localArrayList, bool);
  }
  
  public RawDataSet[] zzeU(int paramInt)
  {
    return new RawDataSet[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */