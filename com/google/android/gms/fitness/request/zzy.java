package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<SessionStopRequest>
{
  static void zza(SessionStopRequest paramSessionStopRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionStopRequest.getName(), false);
    zzb.zzc(paramParcel, 1000, paramSessionStopRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionStopRequest.getIdentifier(), false);
    zzb.zza(paramParcel, 3, paramSessionStopRequest.zzui(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public SessionStopRequest zzdy(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionStopRequest(i, str1, str2, localIBinder);
  }
  
  public SessionStopRequest[] zzfz(int paramInt)
  {
    return new SessionStopRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */