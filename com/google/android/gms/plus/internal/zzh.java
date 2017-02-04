package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<PlusSession>
{
  static void zza(PlusSession paramPlusSession, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramPlusSession.getAccountName(), false);
    zzb.zzc(paramParcel, 1000, paramPlusSession.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlusSession.zzDi(), false);
    zzb.zza(paramParcel, 3, paramPlusSession.zzDj(), false);
    zzb.zza(paramParcel, 4, paramPlusSession.zzDk(), false);
    zzb.zza(paramParcel, 5, paramPlusSession.zzDl(), false);
    zzb.zza(paramParcel, 6, paramPlusSession.zzDm(), false);
    zzb.zza(paramParcel, 7, paramPlusSession.zznF(), false);
    zzb.zza(paramParcel, 8, paramPlusSession.zzDn(), false);
    zzb.zza(paramParcel, 9, paramPlusSession.zzDo(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlusSession zzgq(Parcel paramParcel)
  {
    PlusCommonExtras localPlusCommonExtras = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    String[] arrayOfString3 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        arrayOfString3 = zza.zzB(paramParcel, k);
        break;
      case 3: 
        arrayOfString2 = zza.zzB(paramParcel, k);
        break;
      case 4: 
        arrayOfString1 = zza.zzB(paramParcel, k);
        break;
      case 5: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        localPlusCommonExtras = (PlusCommonExtras)zza.zza(paramParcel, k, PlusCommonExtras.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlusSession(i, str5, arrayOfString3, arrayOfString2, arrayOfString1, str4, str3, str2, str1, localPlusCommonExtras);
  }
  
  public PlusSession[] zzjt(int paramInt)
  {
    return new PlusSession[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */