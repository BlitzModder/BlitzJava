package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GetPermissionStatusRequest>
{
  static void zza(GetPermissionStatusRequest paramGetPermissionStatusRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetPermissionStatusRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramGetPermissionStatusRequest.zzCJ(), false);
    zzb.zza(paramParcel, 3, paramGetPermissionStatusRequest.zzaWI, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetPermissionStatusRequest zzfX(Parcel paramParcel)
  {
    String str = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
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
        localIBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetPermissionStatusRequest(i, localIBinder, str);
  }
  
  public GetPermissionStatusRequest[] zziZ(int paramInt)
  {
    return new GetPermissionStatusRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */