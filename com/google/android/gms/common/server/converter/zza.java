package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ConverterWrapper>
{
  static void zza(ConverterWrapper paramConverterWrapper, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramConverterWrapper.getVersionCode());
    zzb.zza(paramParcel, 2, paramConverterWrapper.zzqQ(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ConverterWrapper zzax(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    StringToIntConverter localStringToIntConverter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        localStringToIntConverter = (StringToIntConverter)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, StringToIntConverter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ConverterWrapper(i, localStringToIntConverter);
  }
  
  public ConverterWrapper[] zzcf(int paramInt)
  {
    return new ConverterWrapper[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/server/converter/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */