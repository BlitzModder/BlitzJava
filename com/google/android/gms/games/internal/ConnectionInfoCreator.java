package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ConnectionInfoCreator
  implements Parcelable.Creator<ConnectionInfo>
{
  static void zza(ConnectionInfo paramConnectionInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramConnectionInfo.zzvN(), false);
    zzb.zzc(paramParcel, 1000, paramConnectionInfo.getVersionCode());
    zzb.zzc(paramParcel, 2, paramConnectionInfo.zzvO());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ConnectionInfo zzed(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ConnectionInfo(i, str, j);
  }
  
  public ConnectionInfo[] zzgj(int paramInt)
  {
    return new ConnectionInfo[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfoCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */