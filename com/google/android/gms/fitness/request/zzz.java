package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz
  implements Parcelable.Creator<SessionUnregistrationRequest>
{
  static void zza(SessionUnregistrationRequest paramSessionUnregistrationRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionUnregistrationRequest.zzuu(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionUnregistrationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionUnregistrationRequest.zzui(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionUnregistrationRequest zzdz(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    PendingIntent localPendingIntent = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionUnregistrationRequest(i, localPendingIntent, localIBinder);
  }
  
  public SessionUnregistrationRequest[] zzfA(int paramInt)
  {
    return new SessionUnregistrationRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */