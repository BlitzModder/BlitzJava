package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbo
  implements Parcelable.Creator<RemoveEventListenerRequest>
{
  static void zza(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemoveEventListenerRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRemoveEventListenerRequest.zzamF, paramInt, false);
    zzb.zzc(paramParcel, 3, paramRemoveEventListenerRequest.zzalo);
    zzb.zzI(paramParcel, i);
  }
  
  public RemoveEventListenerRequest zzbN(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new RemoveEventListenerRequest(j, localDriveId, i);
  }
  
  public RemoveEventListenerRequest[] zzdI(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */