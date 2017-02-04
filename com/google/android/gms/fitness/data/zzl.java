package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<MapValue>
{
  static void zza(MapValue paramMapValue, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramMapValue.getFormat());
    zzb.zzc(paramParcel, 1000, paramMapValue.getVersionCode());
    zzb.zza(paramParcel, 2, paramMapValue.zztR());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public MapValue zzcS(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    float f = 0.0F;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        f = zza.zzl(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new MapValue(i, j, f);
  }
  
  public MapValue[] zzeR(int paramInt)
  {
    return new MapValue[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */