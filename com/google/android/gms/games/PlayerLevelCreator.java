package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelCreator
  implements Parcelable.Creator<PlayerLevel>
{
  static void zza(PlayerLevel paramPlayerLevel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPlayerLevel.getLevelNumber());
    zzb.zzc(paramParcel, 1000, paramPlayerLevel.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlayerLevel.getMinXp());
    zzb.zza(paramParcel, 3, paramPlayerLevel.getMaxXp());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlayerLevel zzdU(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int k = zza.zzau(paramParcel);
    long l2 = 0L;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PlayerLevel(j, i, l2, l1);
  }
  
  public PlayerLevel[] zzfW(int paramInt)
  {
    return new PlayerLevel[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/PlayerLevelCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */