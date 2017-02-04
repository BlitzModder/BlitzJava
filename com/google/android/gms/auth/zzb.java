package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AccountChangeEventsRequest>
{
  static void zza(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAccountChangeEventsRequest.mVersion);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramAccountChangeEventsRequest.zzTF);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramAccountChangeEventsRequest.zzTD, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramAccountChangeEventsRequest.zzSo, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public AccountChangeEventsRequest zzA(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = 0;
    int k = zza.zzau(paramParcel);
    String str = null;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 4: 
        localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new AccountChangeEventsRequest(i, j, str, localAccount);
  }
  
  public AccountChangeEventsRequest[] zzav(int paramInt)
  {
    return new AccountChangeEventsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */