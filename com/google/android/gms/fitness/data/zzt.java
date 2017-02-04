package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt
  implements Parcelable.Creator<Value>
{
  static void zza(Value paramValue, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramValue.getFormat());
    zzb.zzc(paramParcel, 1000, paramValue.getVersionCode());
    zzb.zza(paramParcel, 2, paramValue.isSet());
    zzb.zza(paramParcel, 3, paramValue.zztR());
    zzb.zza(paramParcel, 4, paramValue.zztX(), false);
    zzb.zza(paramParcel, 5, paramValue.zztY(), false);
    zzb.zza(paramParcel, 6, paramValue.zztZ(), false);
    zzb.zza(paramParcel, 7, paramValue.zzua(), false);
    zzb.zza(paramParcel, 8, paramValue.zzub(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Value zzcZ(Parcel paramParcel)
  {
    boolean bool = false;
    byte[] arrayOfByte = null;
    int k = zza.zzau(paramParcel);
    float f = 0.0F;
    float[] arrayOfFloat = null;
    int[] arrayOfInt = null;
    Bundle localBundle = null;
    String str = null;
    int i = 0;
    int j = 0;
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
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 3: 
        f = zza.zzl(paramParcel, m);
        break;
      case 4: 
        str = zza.zzp(paramParcel, m);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 6: 
        arrayOfInt = zza.zzv(paramParcel, m);
        break;
      case 7: 
        arrayOfFloat = zza.zzy(paramParcel, m);
        break;
      case 8: 
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Value(j, i, bool, f, str, localBundle, arrayOfInt, arrayOfFloat, arrayOfByte);
  }
  
  public Value[] zzeZ(int paramInt)
  {
    return new Value[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */