package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<EventParcel>
{
  static void zza(EventParcel paramEventParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramEventParcel.versionCode);
    zzb.zza(paramParcel, 2, paramEventParcel.name, false);
    zzb.zza(paramParcel, 3, paramEventParcel.zzaSL, paramInt, false);
    zzb.zza(paramParcel, 4, paramEventParcel.zzaSM, false);
    zzb.zza(paramParcel, 5, paramEventParcel.zzaSN);
    zzb.zzI(paramParcel, i);
  }
  
  public EventParcel zzfE(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    EventParams localEventParams = null;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localEventParams = (EventParams)zza.zza(paramParcel, k, EventParams.CREATOR);
        break;
      case 4: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new EventParcel(i, str2, localEventParams, str1, l);
  }
  
  public EventParcel[] zzix(int paramInt)
  {
    return new EventParcel[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */