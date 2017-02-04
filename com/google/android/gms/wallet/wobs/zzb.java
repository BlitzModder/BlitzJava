package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<LabelValue>
{
  static void zza(LabelValue paramLabelValue, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramLabelValue.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramLabelValue.label, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramLabelValue.value, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public LabelValue zzhB(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LabelValue(i, str1, str2);
  }
  
  public LabelValue[] zzkY(int paramInt)
  {
    return new LabelValue[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/wobs/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */