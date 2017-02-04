package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zza
  implements Parcelable.Creator<ComparisonFilter>
{
  static void zza(ComparisonFilter paramComparisonFilter, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1000, paramComparisonFilter.mVersionCode);
    zzb.zza(paramParcel, 1, paramComparisonFilter.zzasa, paramInt, false);
    zzb.zza(paramParcel, 2, paramComparisonFilter.zzasb, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ComparisonFilter zzch(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    Operator localOperator = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        continue;
        localOperator = (Operator)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Operator.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ComparisonFilter(i, localOperator, localMetadataBundle);
  }
  
  public ComparisonFilter[] zzec(int paramInt)
  {
    return new ComparisonFilter[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */