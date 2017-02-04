package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerStatsEntityCreator
  implements Parcelable.Creator<PlayerStatsEntity>
{
  static void zza(PlayerStatsEntity paramPlayerStatsEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramPlayerStatsEntity.getAverageSessionLength());
    zzb.zzc(paramParcel, 1000, paramPlayerStatsEntity.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlayerStatsEntity.getChurnProbability());
    zzb.zzc(paramParcel, 3, paramPlayerStatsEntity.getDaysSinceLastPlayed());
    zzb.zzc(paramParcel, 4, paramPlayerStatsEntity.getNumberOfPurchases());
    zzb.zzc(paramParcel, 5, paramPlayerStatsEntity.getNumberOfSessions());
    zzb.zza(paramParcel, 6, paramPlayerStatsEntity.getSessionPercentile());
    zzb.zza(paramParcel, 7, paramPlayerStatsEntity.getSpendPercentile());
    zzb.zza(paramParcel, 8, paramPlayerStatsEntity.zzxo(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlayerStatsEntity zzew(Parcel paramParcel)
  {
    int i = 0;
    float f1 = 0.0F;
    int n = zza.zzau(paramParcel);
    Bundle localBundle = null;
    float f2 = 0.0F;
    int j = 0;
    int k = 0;
    float f3 = 0.0F;
    float f4 = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        f4 = zza.zzl(paramParcel, i1);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        f3 = zza.zzl(paramParcel, i1);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        f2 = zza.zzl(paramParcel, i1);
        break;
      case 7: 
        f1 = zza.zzl(paramParcel, i1);
        break;
      case 8: 
        localBundle = zza.zzr(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new PlayerStatsEntity(m, f4, f3, k, j, i, f2, f1, localBundle);
  }
  
  public PlayerStatsEntity[] zzgO(int paramInt)
  {
    return new PlayerStatsEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/PlayerStatsEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */