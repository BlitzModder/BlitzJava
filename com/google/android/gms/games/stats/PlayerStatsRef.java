package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;

public class PlayerStatsRef
  extends zzc
  implements PlayerStats
{
  private Bundle zzaIA;
  
  PlayerStatsRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerStatsEntity.zza(this, paramObject);
  }
  
  public float getAverageSessionLength()
  {
    return getFloat("ave_session_length_minutes");
  }
  
  public float getChurnProbability()
  {
    return getFloat("churn_probability");
  }
  
  public int getDaysSinceLastPlayed()
  {
    return getInteger("days_since_last_played");
  }
  
  public int getNumberOfPurchases()
  {
    return getInteger("num_purchases");
  }
  
  public int getNumberOfSessions()
  {
    return getInteger("num_sessions");
  }
  
  public float getSessionPercentile()
  {
    return getFloat("num_sessions_percentile");
  }
  
  public float getSpendPercentile()
  {
    return getFloat("spend_percentile");
  }
  
  public int hashCode()
  {
    return PlayerStatsEntity.zza(this);
  }
  
  public String toString()
  {
    return PlayerStatsEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerStatsEntity)zzxp()).writeToParcel(paramParcel, paramInt);
  }
  
  public Bundle zzxo()
  {
    int i = 0;
    if (this.zzaIA != null) {
      return this.zzaIA;
    }
    this.zzaIA = new Bundle();
    Object localObject2 = getString("unknown_raw_keys");
    Object localObject1 = getString("unknown_raw_values");
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((String)localObject2).split(",");
      localObject1 = ((String)localObject1).split(",");
      if (localObject2.length <= localObject1.length) {}
      for (boolean bool = true;; bool = false)
      {
        zzb.zza(bool, "Invalid raw arguments!");
        while (i < localObject2.length)
        {
          this.zzaIA.putString(localObject2[i], localObject1[i]);
          i += 1;
        }
      }
    }
    return this.zzaIA;
  }
  
  public PlayerStats zzxp()
  {
    return new PlayerStatsEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/PlayerStatsRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */