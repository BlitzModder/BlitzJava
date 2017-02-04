package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<CapabilityParcel>
{
  static void zza(CapabilityParcel paramCapabilityParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCapabilityParcel.versionCode);
    zzb.zza(paramParcel, 2, paramCapabilityParcel.zzHd);
    zzb.zza(paramParcel, 3, paramCapabilityParcel.zzHe);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CapabilityParcel[] zzI(int paramInt)
  {
    return new CapabilityParcel[paramInt];
  }
  
  public CapabilityParcel zzk(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = zza.zzau(paramParcel);
    boolean bool1 = false;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CapabilityParcel(i, bool1, bool2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */