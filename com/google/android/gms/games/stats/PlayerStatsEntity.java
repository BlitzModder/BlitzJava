package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlayerStatsEntity
  implements SafeParcelable, PlayerStats
{
  public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
  private final int mVersionCode;
  private final Bundle zzaIA;
  private final float zzaIt;
  private final float zzaIu;
  private final int zzaIv;
  private final int zzaIw;
  private final int zzaIx;
  private final float zzaIy;
  private final float zzaIz;
  
  PlayerStatsEntity(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, int paramInt4, float paramFloat3, float paramFloat4, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.zzaIt = paramFloat1;
    this.zzaIu = paramFloat2;
    this.zzaIv = paramInt2;
    this.zzaIw = paramInt3;
    this.zzaIx = paramInt4;
    this.zzaIy = paramFloat3;
    this.zzaIz = paramFloat4;
    this.zzaIA = paramBundle;
  }
  
  public PlayerStatsEntity(PlayerStats paramPlayerStats)
  {
    this.mVersionCode = 2;
    this.zzaIt = paramPlayerStats.getAverageSessionLength();
    this.zzaIu = paramPlayerStats.getChurnProbability();
    this.zzaIv = paramPlayerStats.getDaysSinceLastPlayed();
    this.zzaIw = paramPlayerStats.getNumberOfPurchases();
    this.zzaIx = paramPlayerStats.getNumberOfSessions();
    this.zzaIy = paramPlayerStats.getSessionPercentile();
    this.zzaIz = paramPlayerStats.getSpendPercentile();
    this.zzaIA = paramPlayerStats.zzxo();
  }
  
  static int zza(PlayerStats paramPlayerStats)
  {
    return zzw.hashCode(new Object[] { Float.valueOf(paramPlayerStats.getAverageSessionLength()), Float.valueOf(paramPlayerStats.getChurnProbability()), Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed()), Integer.valueOf(paramPlayerStats.getNumberOfPurchases()), Integer.valueOf(paramPlayerStats.getNumberOfSessions()), Float.valueOf(paramPlayerStats.getSessionPercentile()), Float.valueOf(paramPlayerStats.getSpendPercentile()) });
  }
  
  static boolean zza(PlayerStats paramPlayerStats, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerStats)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayerStats == paramObject);
      paramObject = (PlayerStats)paramObject;
      if ((!zzw.equal(Float.valueOf(((PlayerStats)paramObject).getAverageSessionLength()), Float.valueOf(paramPlayerStats.getAverageSessionLength()))) || (!zzw.equal(Float.valueOf(((PlayerStats)paramObject).getChurnProbability()), Float.valueOf(paramPlayerStats.getChurnProbability()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getDaysSinceLastPlayed()), Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getNumberOfPurchases()), Integer.valueOf(paramPlayerStats.getNumberOfPurchases()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getNumberOfSessions()), Integer.valueOf(paramPlayerStats.getNumberOfSessions()))) || (!zzw.equal(Float.valueOf(((PlayerStats)paramObject).getSessionPercentile()), Float.valueOf(paramPlayerStats.getSessionPercentile())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Float.valueOf(((PlayerStats)paramObject).getSpendPercentile()), Float.valueOf(paramPlayerStats.getSpendPercentile())));
    return false;
  }
  
  static String zzb(PlayerStats paramPlayerStats)
  {
    return zzw.zzx(paramPlayerStats).zzg("AverageSessionLength", Float.valueOf(paramPlayerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(paramPlayerStats.getChurnProbability())).zzg("DaysSinceLastPlayed", Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(paramPlayerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(paramPlayerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(paramPlayerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(paramPlayerStats.getSpendPercentile())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public float getAverageSessionLength()
  {
    return this.zzaIt;
  }
  
  public float getChurnProbability()
  {
    return this.zzaIu;
  }
  
  public int getDaysSinceLastPlayed()
  {
    return this.zzaIv;
  }
  
  public int getNumberOfPurchases()
  {
    return this.zzaIw;
  }
  
  public int getNumberOfSessions()
  {
    return this.zzaIx;
  }
  
  public float getSessionPercentile()
  {
    return this.zzaIy;
  }
  
  public float getSpendPercentile()
  {
    return this.zzaIz;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerStatsEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzxo()
  {
    return this.zzaIA;
  }
  
  public PlayerStats zzxp()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/PlayerStatsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */