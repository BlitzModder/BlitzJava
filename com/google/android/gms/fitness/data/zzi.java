package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<Field>
{
  static void zza(Field paramField, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramField.getName(), false);
    zzb.zzc(paramParcel, 1000, paramField.getVersionCode());
    zzb.zzc(paramParcel, 2, paramField.getFormat());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Field zzcR(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    String str = null;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Field(i, str, j);
  }
  
  public Field[] zzeQ(int paramInt)
  {
    return new Field[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */