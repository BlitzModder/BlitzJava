package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<LogEvent>
{
  static void zza(LogEvent paramLogEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLogEvent.versionCode);
    zzb.zza(paramParcel, 2, paramLogEvent.zzaYn);
    zzb.zza(paramParcel, 3, paramLogEvent.tag, false);
    zzb.zza(paramParcel, 4, paramLogEvent.zzaYp, false);
    zzb.zza(paramParcel, 5, paramLogEvent.zzaYq, false);
    zzb.zza(paramParcel, 6, paramLogEvent.zzaYo);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LogEvent zzgn(Parcel paramParcel)
  {
    long l1 = 0L;
    Bundle localBundle = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    String str = null;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 6: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LogEvent(i, l2, l1, str, arrayOfByte, localBundle);
  }
  
  public LogEvent[] zzjp(int paramInt)
  {
    return new LogEvent[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/playlog/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */