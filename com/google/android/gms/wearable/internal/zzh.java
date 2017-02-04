package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<AncsNotificationParcelable>
{
  static void zza(AncsNotificationParcelable paramAncsNotificationParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAncsNotificationParcelable.mVersionCode);
    zzb.zzc(paramParcel, 2, paramAncsNotificationParcelable.getId());
    zzb.zza(paramParcel, 3, paramAncsNotificationParcelable.zzwg(), false);
    zzb.zza(paramParcel, 4, paramAncsNotificationParcelable.zzGE(), false);
    zzb.zza(paramParcel, 5, paramAncsNotificationParcelable.zzGF(), false);
    zzb.zza(paramParcel, 6, paramAncsNotificationParcelable.getTitle(), false);
    zzb.zza(paramParcel, 7, paramAncsNotificationParcelable.zzvw(), false);
    zzb.zza(paramParcel, 8, paramAncsNotificationParcelable.getDisplayName(), false);
    zzb.zza(paramParcel, 9, paramAncsNotificationParcelable.zzGG());
    zzb.zza(paramParcel, 10, paramAncsNotificationParcelable.zzGH());
    zzb.zza(paramParcel, 11, paramAncsNotificationParcelable.zzGI());
    zzb.zza(paramParcel, 12, paramAncsNotificationParcelable.zzGJ());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AncsNotificationParcelable zzhP(Parcel paramParcel)
  {
    int k = zza.zzau(paramParcel);
    int j = 0;
    int i = 0;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    byte b4 = 0;
    byte b3 = 0;
    byte b2 = 0;
    byte b1 = 0;
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
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str6 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 5: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 9: 
        b4 = zza.zze(paramParcel, m);
        break;
      case 10: 
        b3 = zza.zze(paramParcel, m);
        break;
      case 11: 
        b2 = zza.zze(paramParcel, m);
        break;
      case 12: 
        b1 = zza.zze(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new AncsNotificationParcelable(j, i, str6, str5, str4, str3, str2, str1, b4, b3, b2, b1);
  }
  
  public AncsNotificationParcelable[] zzln(int paramInt)
  {
    return new AncsNotificationParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */