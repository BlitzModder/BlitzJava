package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<LargeParcelTeleporter>
{
  static void zza(LargeParcelTeleporter paramLargeParcelTeleporter, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeParcelTeleporter.mVersionCode);
    zzb.zza(paramParcel, 2, paramLargeParcelTeleporter.zzHf, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LargeParcelTeleporter[] zzJ(int paramInt)
  {
    return new LargeParcelTeleporter[paramInt];
  }
  
  public LargeParcelTeleporter zzl(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LargeParcelTeleporter(i, localParcelFileDescriptor);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */