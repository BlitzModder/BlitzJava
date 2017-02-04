package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<VersionInfoParcel>
{
  static void zza(VersionInfoParcel paramVersionInfoParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramVersionInfoParcel.versionCode);
    zzb.zza(paramParcel, 2, paramVersionInfoParcel.afmaVersion, false);
    zzb.zzc(paramParcel, 3, paramVersionInfoParcel.zzLF);
    zzb.zzc(paramParcel, 4, paramVersionInfoParcel.zzLG);
    zzb.zza(paramParcel, 5, paramVersionInfoParcel.zzLH);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public VersionInfoParcel[] zzR(int paramInt)
  {
    return new VersionInfoParcel[paramInt];
  }
  
  public VersionInfoParcel zzp(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    String str = null;
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
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str = zza.zzp(paramParcel, n);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        i = zza.zzg(paramParcel, n);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new VersionInfoParcel(k, str, j, i, bool);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/util/client/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */