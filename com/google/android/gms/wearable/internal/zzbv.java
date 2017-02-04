package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbv
  implements Parcelable.Creator<RemoveListenerRequest>
{
  static void zza(RemoveListenerRequest paramRemoveListenerRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemoveListenerRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRemoveListenerRequest.zzGB(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RemoveListenerRequest zziB(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
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
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RemoveListenerRequest(i, localIBinder);
  }
  
  public RemoveListenerRequest[] zzmg(int paramInt)
  {
    return new RemoveListenerRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */