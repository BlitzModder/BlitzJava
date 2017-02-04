package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GestureRequest>
{
  static void zza(GestureRequest paramGestureRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramGestureRequest.zzxX(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramGestureRequest.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public GestureRequest zzeH(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzC(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GestureRequest(i, localArrayList);
  }
  
  public GestureRequest[] zzhi(int paramInt)
  {
    return new GestureRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */