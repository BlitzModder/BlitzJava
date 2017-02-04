package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void zza(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramNotifyTransactionStatusRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramNotifyTransactionStatusRequest.zzbjg, false);
    zzb.zzc(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
    zzb.zza(paramParcel, 4, paramNotifyTransactionStatusRequest.zzbkq, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NotifyTransactionStatusRequest zzhn(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int k = zza.zzau(paramParcel);
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NotifyTransactionStatusRequest(i, str1, j, str2);
  }
  
  public NotifyTransactionStatusRequest[] zzkH(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */