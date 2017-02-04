package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<NativeAdOptionsParcel>
{
  static void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramNativeAdOptionsParcel.versionCode);
    zzb.zza(paramParcel, 2, paramNativeAdOptionsParcel.zzyc);
    zzb.zzc(paramParcel, 3, paramNativeAdOptionsParcel.zzyd);
    zzb.zza(paramParcel, 4, paramNativeAdOptionsParcel.zzye);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NativeAdOptionsParcel zze(Parcel paramParcel)
  {
    boolean bool2 = false;
    int k = zza.zzau(paramParcel);
    int j = 0;
    boolean bool1 = false;
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
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NativeAdOptionsParcel(i, bool1, j, bool2);
  }
  
  public NativeAdOptionsParcel[] zzp(int paramInt)
  {
    return new NativeAdOptionsParcel[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */