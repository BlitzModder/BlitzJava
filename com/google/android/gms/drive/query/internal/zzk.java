package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<LogicalFilter>
{
  static void zza(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1000, paramLogicalFilter.mVersionCode);
    zzb.zza(paramParcel, 1, paramLogicalFilter.zzasa, paramInt, false);
    zzb.zzc(paramParcel, 2, paramLogicalFilter.zzasp, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LogicalFilter zzco(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Operator localOperator = null;
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
        i = zza.zzg(paramParcel, k);
        continue;
        localOperator = (Operator)zza.zza(paramParcel, k, Operator.CREATOR);
        continue;
        localArrayList = zza.zzc(paramParcel, k, FilterHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LogicalFilter(i, localOperator, localArrayList);
  }
  
  public LogicalFilter[] zzej(int paramInt)
  {
    return new LogicalFilter[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */