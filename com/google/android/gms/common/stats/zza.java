package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ConnectionEvent>
{
  static void zza(ConnectionEvent paramConnectionEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramConnectionEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramConnectionEvent.getTimeMillis());
    zzb.zza(paramParcel, 4, paramConnectionEvent.zzrp(), false);
    zzb.zza(paramParcel, 5, paramConnectionEvent.zzrq(), false);
    zzb.zza(paramParcel, 6, paramConnectionEvent.zzrr(), false);
    zzb.zza(paramParcel, 7, paramConnectionEvent.zzrs(), false);
    zzb.zza(paramParcel, 8, paramConnectionEvent.zzrt(), false);
    zzb.zza(paramParcel, 10, paramConnectionEvent.zzrx());
    zzb.zza(paramParcel, 11, paramConnectionEvent.zzrw());
    zzb.zzc(paramParcel, 12, paramConnectionEvent.getEventType());
    zzb.zza(paramParcel, 13, paramConnectionEvent.zzru(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ConnectionEvent zzaF(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int j = 0;
    long l3 = 0L;
    int i = 0;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    long l2 = 0L;
    long l1 = 0L;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(m))
      {
      case 3: 
      case 9: 
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        l3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, m);
        break;
      case 4: 
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 5: 
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 6: 
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 7: 
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 8: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 10: 
        l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, m);
        break;
      case 11: 
        l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, m);
        break;
      case 12: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 13: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ConnectionEvent(j, l3, i, str6, str5, str4, str3, str2, str1, l2, l1);
  }
  
  public ConnectionEvent[] zzcn(int paramInt)
  {
    return new ConnectionEvent[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */