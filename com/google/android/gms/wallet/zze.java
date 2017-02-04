package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zze
  implements Parcelable.Creator<FullWallet>
{
  static void zza(FullWallet paramFullWallet, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramFullWallet.getVersionCode());
    zzb.zza(paramParcel, 2, paramFullWallet.zzbjg, false);
    zzb.zza(paramParcel, 3, paramFullWallet.zzbjh, false);
    zzb.zza(paramParcel, 4, paramFullWallet.zzbji, paramInt, false);
    zzb.zza(paramParcel, 5, paramFullWallet.zzbjj, false);
    zzb.zza(paramParcel, 6, paramFullWallet.zzbjk, paramInt, false);
    zzb.zza(paramParcel, 7, paramFullWallet.zzbjl, paramInt, false);
    zzb.zza(paramParcel, 8, paramFullWallet.zzbjm, false);
    zzb.zza(paramParcel, 9, paramFullWallet.zzbjn, paramInt, false);
    zzb.zza(paramParcel, 10, paramFullWallet.zzbjo, paramInt, false);
    zzb.zza(paramParcel, 11, paramFullWallet.zzbjp, paramInt, false);
    zzb.zza(paramParcel, 12, paramFullWallet.zzbjq, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public FullWallet zzhf(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str3 = null;
    String str2 = null;
    ProxyCard localProxyCard = null;
    String str1 = null;
    Address localAddress2 = null;
    Address localAddress1 = null;
    String[] arrayOfString = null;
    UserAddress localUserAddress2 = null;
    UserAddress localUserAddress1 = null;
    InstrumentInfo[] arrayOfInstrumentInfo = null;
    PaymentMethodToken localPaymentMethodToken = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localProxyCard = (ProxyCard)zza.zza(paramParcel, k, ProxyCard.CREATOR);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        localAddress2 = (Address)zza.zza(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress1 = (Address)zza.zza(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfString = zza.zzB(paramParcel, k);
        break;
      case 9: 
        localUserAddress2 = (UserAddress)zza.zza(paramParcel, k, UserAddress.CREATOR);
        break;
      case 10: 
        localUserAddress1 = (UserAddress)zza.zza(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        arrayOfInstrumentInfo = (InstrumentInfo[])zza.zzb(paramParcel, k, InstrumentInfo.CREATOR);
        break;
      case 12: 
        localPaymentMethodToken = (PaymentMethodToken)zza.zza(paramParcel, k, PaymentMethodToken.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FullWallet(i, str3, str2, localProxyCard, str1, localAddress2, localAddress1, arrayOfString, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo, localPaymentMethodToken);
  }
  
  public FullWallet[] zzkz(int paramInt)
  {
    return new FullWallet[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */