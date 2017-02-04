package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzx
  implements Parcelable.Creator<SessionStartRequest>
{
  static void zza(SessionStartRequest paramSessionStartRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionStartRequest.getSession(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionStartRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionStartRequest.zzui(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionStartRequest zzdx(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Session localSession = null;
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
        localSession = (Session)zza.zza(paramParcel, k, Session.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionStartRequest(i, localSession, localIBinder);
  }
  
  public SessionStartRequest[] zzfy(int paramInt)
  {
    return new SessionStartRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */