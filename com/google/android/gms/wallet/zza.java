package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<Address>
{
  static void zza(Address paramAddress, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAddress.getVersionCode());
    zzb.zza(paramParcel, 2, paramAddress.name, false);
    zzb.zza(paramParcel, 3, paramAddress.zzaJQ, false);
    zzb.zza(paramParcel, 4, paramAddress.zzaJR, false);
    zzb.zza(paramParcel, 5, paramAddress.zzaJS, false);
    zzb.zza(paramParcel, 6, paramAddress.zzIE, false);
    zzb.zza(paramParcel, 7, paramAddress.zzbiX, false);
    zzb.zza(paramParcel, 8, paramAddress.zzbiY, false);
    zzb.zza(paramParcel, 9, paramAddress.zzaJX, false);
    zzb.zza(paramParcel, 10, paramAddress.phoneNumber, false);
    zzb.zza(paramParcel, 11, paramAddress.zzaJZ);
    zzb.zza(paramParcel, 12, paramAddress.zzaKa, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Address zzhb(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    boolean bool = false;
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
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3: 
        str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 4: 
        str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 5: 
        str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 6: 
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 7: 
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 8: 
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 9: 
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 10: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 11: 
        bool = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 12: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Address(i, str10, str9, str8, str7, str6, str5, str4, str3, str2, bool, str1);
  }
  
  public Address[] zzkv(int paramInt)
  {
    return new Address[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */