package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbj
  implements Parcelable.Creator<OnSyncMoreResponse>
{
  static void zza(OnSyncMoreResponse paramOnSyncMoreResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnSyncMoreResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnSyncMoreResponse.zzaoG);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public OnSyncMoreResponse zzbJ(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzau(paramParcel);
    int i = 0;
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
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnSyncMoreResponse(i, bool);
  }
  
  public OnSyncMoreResponse[] zzdE(int paramInt)
  {
    return new OnSyncMoreResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */