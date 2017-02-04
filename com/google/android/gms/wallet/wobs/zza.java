package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<CommonWalletObject>
{
  static void zza(CommonWalletObject paramCommonWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCommonWalletObject.getVersionCode());
    zzb.zza(paramParcel, 2, paramCommonWalletObject.zzif, false);
    zzb.zza(paramParcel, 3, paramCommonWalletObject.zzbjN, false);
    zzb.zza(paramParcel, 4, paramCommonWalletObject.name, false);
    zzb.zza(paramParcel, 5, paramCommonWalletObject.zzbjH, false);
    zzb.zza(paramParcel, 6, paramCommonWalletObject.zzbjJ, false);
    zzb.zza(paramParcel, 7, paramCommonWalletObject.zzbjK, false);
    zzb.zza(paramParcel, 8, paramCommonWalletObject.zzbjL, false);
    zzb.zza(paramParcel, 9, paramCommonWalletObject.zzbjM, false);
    zzb.zzc(paramParcel, 10, paramCommonWalletObject.state);
    zzb.zzc(paramParcel, 11, paramCommonWalletObject.zzbjO, false);
    zzb.zza(paramParcel, 12, paramCommonWalletObject.zzbjP, paramInt, false);
    zzb.zzc(paramParcel, 13, paramCommonWalletObject.zzbjQ, false);
    zzb.zza(paramParcel, 14, paramCommonWalletObject.zzbjR, false);
    zzb.zza(paramParcel, 15, paramCommonWalletObject.zzbjS, false);
    zzb.zza(paramParcel, 17, paramCommonWalletObject.zzbjU);
    zzb.zzc(paramParcel, 16, paramCommonWalletObject.zzbjT, false);
    zzb.zzc(paramParcel, 19, paramCommonWalletObject.zzbjW, false);
    zzb.zzc(paramParcel, 18, paramCommonWalletObject.zzbjV, false);
    zzb.zzc(paramParcel, 20, paramCommonWalletObject.zzbjX, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CommonWalletObject zzhA(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int j = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    int i = 0;
    ArrayList localArrayList6 = zznh.zzrK();
    TimeInterval localTimeInterval = null;
    ArrayList localArrayList5 = zznh.zzrK();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = zznh.zzrK();
    boolean bool = false;
    ArrayList localArrayList3 = zznh.zzrK();
    ArrayList localArrayList2 = zznh.zzrK();
    ArrayList localArrayList1 = zznh.zzrK();
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 3: 
        str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 4: 
        str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 5: 
        str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 6: 
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 7: 
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 8: 
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 9: 
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 10: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 11: 
        localArrayList6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, WalletObjectMessage.CREATOR);
        break;
      case 12: 
        localTimeInterval = (TimeInterval)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, TimeInterval.CREATOR);
        break;
      case 13: 
        localArrayList5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, LatLng.CREATOR);
        break;
      case 14: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 15: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 17: 
        bool = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m);
        break;
      case 16: 
        localArrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, LabelValueRow.CREATOR);
        break;
      case 19: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, TextModuleData.CREATOR);
        break;
      case 18: 
        localArrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, UriData.CREATOR);
        break;
      case 20: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, UriData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CommonWalletObject(j, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localTimeInterval, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1);
  }
  
  public CommonWalletObject[] zzkX(int paramInt)
  {
    return new CommonWalletObject[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/wobs/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */