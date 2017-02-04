package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbn
  implements Parcelable.Creator<QueryRequest>
{
  static void zza(QueryRequest paramQueryRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramQueryRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramQueryRequest.zzaqw, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public QueryRequest zzbM(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    Query localQuery = null;
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
        localQuery = (Query)zza.zza(paramParcel, k, Query.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new QueryRequest(i, localQuery);
  }
  
  public QueryRequest[] zzdH(int paramInt)
  {
    return new QueryRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */