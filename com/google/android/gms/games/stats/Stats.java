package com.google.android.gms.games.stats;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Stats
{
  public abstract PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public static abstract interface LoadPlayerStatsResult
    extends Releasable, Result
  {
    public abstract PlayerStats getPlayerStats();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */