package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzn
  implements Parcelable.Creator<OfferWalletObject>
{
  static void zza(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOfferWalletObject.getVersionCode());
    zzb.zza(paramParcel, 2, paramOfferWalletObject.zzif, false);
    zzb.zza(paramParcel, 3, paramOfferWalletObject.zzbks, false);
    zzb.zza(paramParcel, 4, paramOfferWalletObject.zzbjt, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OfferWalletObject zzho(Parcel paramParcel)
  {
    CommonWalletObject localCommonWalletObject = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localCommonWalletObject = (CommonWalletObject)zza.zza(paramParcel, k, CommonWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OfferWalletObject(i, str1, str2, localCommonWalletObject);
  }
  
  public OfferWalletObject[] zzkI(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */