package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<ReceiveContentRequest>
{
  static void zza(ReceiveContentRequest paramReceiveContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramReceiveContentRequest.versionCode);
    zzb.zza(paramParcel, 2, paramReceiveContentRequest.zzaXX, false);
    zzb.zza(paramParcel, 3, paramReceiveContentRequest.zzCV(), false);
    zzb.zza(paramParcel, 4, paramReceiveContentRequest.packageName, false);
    zzb.zza(paramParcel, 5, paramReceiveContentRequest.zzCJ(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ReceiveContentRequest zzgk(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
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
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        str = zza.zzp(paramParcel, k);
        break;
      case 5: 
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ReceiveContentRequest(i, localIBinder3, localIBinder2, str, localIBinder1);
  }
  
  public ReceiveContentRequest[] zzjm(int paramInt)
  {
    return new ReceiveContentRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */