package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AppIdentifier>
{
  static void zza(AppIdentifier paramAppIdentifier, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramAppIdentifier.getIdentifier(), false);
    zzb.zzc(paramParcel, 1000, paramAppIdentifier.getVersionCode());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AppIdentifier zzfP(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppIdentifier(i, str);
  }
  
  public AppIdentifier[] zziI(int paramInt)
  {
    return new AppIdentifier[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/connection/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */