package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface PlayerStats
  extends Parcelable, Freezable<PlayerStats>
{
  public static final float UNSET_VALUE = -1.0F;
  
  public abstract float getAverageSessionLength();
  
  public abstract float getChurnProbability();
  
  public abstract int getDaysSinceLastPlayed();
  
  public abstract int getNumberOfPurchases();
  
  public abstract int getNumberOfSessions();
  
  public abstract float getSessionPercentile();
  
  public abstract float getSpendPercentile();
  
  public abstract Bundle zzxo();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/PlayerStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */