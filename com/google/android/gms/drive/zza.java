package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ChangeSequenceNumber>
{
  static void zza(ChangeSequenceNumber paramChangeSequenceNumber, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramChangeSequenceNumber.mVersionCode);
    zzb.zza(paramParcel, 2, paramChangeSequenceNumber.zzamz);
    zzb.zza(paramParcel, 3, paramChangeSequenceNumber.zzamA);
    zzb.zza(paramParcel, 4, paramChangeSequenceNumber.zzamB);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ChangeSequenceNumber zzaH(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    long l2 = 0L;
    long l3 = 0L;
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
        l3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 3: 
        l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 4: 
        l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ChangeSequenceNumber(i, l3, l2, l1);
  }
  
  public ChangeSequenceNumber[] zzcs(int paramInt)
  {
    return new ChangeSequenceNumber[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */