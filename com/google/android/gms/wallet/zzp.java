package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<PaymentMethodTokenizationParameters>
{
  static void zza(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPaymentMethodTokenizationParameters.getVersionCode());
    zzb.zzc(paramParcel, 2, paramPaymentMethodTokenizationParameters.zzbkt);
    zzb.zza(paramParcel, 3, paramPaymentMethodTokenizationParameters.zzbku, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PaymentMethodTokenizationParameters zzhq(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    Bundle localBundle = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PaymentMethodTokenizationParameters(i, j, localBundle);
  }
  
  public PaymentMethodTokenizationParameters[] zzkK(int paramInt)
  {
    return new PaymentMethodTokenizationParameters[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */