package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<CreateContentsRequest>
{
  static void zza(CreateContentsRequest paramCreateContentsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCreateContentsRequest.mVersionCode);
    zzb.zzc(paramParcel, 2, paramCreateContentsRequest.zzamE);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CreateContentsRequest zzbf(Parcel paramParcel)
  {
    int k = zza.zzau(paramParcel);
    int i = 0;
    int j = 536870912;
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CreateContentsRequest(i, j);
  }
  
  public CreateContentsRequest[] zzcV(int paramInt)
  {
    return new CreateContentsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */