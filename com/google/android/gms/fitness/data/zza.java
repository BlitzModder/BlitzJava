package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<Application>
{
  static void zza(Application paramApplication, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramApplication.getPackageName(), false);
    zzb.zzc(paramParcel, 1000, paramApplication.getVersionCode());
    zzb.zza(paramParcel, 2, paramApplication.getVersion(), false);
    zzb.zza(paramParcel, 3, paramApplication.zzty(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Application zzcJ(Parcel paramParcel)
  {
    String str3 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3: 
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Application(i, str1, str2, str3);
  }
  
  public Application[] zzeG(int paramInt)
  {
    return new Application[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */