package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe
  implements Parcelable.Creator<LargeAssetQuery>
{
  static void zza(LargeAssetQuery paramLargeAssetQuery, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetQuery.mVersionCode);
    zzb.zzc(paramParcel, 2, paramLargeAssetQuery.zzbnP);
    zzb.zza(paramParcel, 3, paramLargeAssetQuery.zzaXR, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LargeAssetQuery zzip(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    Uri localUri = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localUri = (Uri)zza.zza(paramParcel, m, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new LargeAssetQuery(i, j, localUri);
  }
  
  public LargeAssetQuery[] zzlQ(int paramInt)
  {
    return new LargeAssetQuery[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */