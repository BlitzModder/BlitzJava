package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class LeaderboardVariantRef
  extends zzc
  implements LeaderboardVariant
{
  LeaderboardVariantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardVariantEntity.zza(this, paramObject);
  }
  
  public int getCollection()
  {
    return getInteger("collection");
  }
  
  public String getDisplayPlayerRank()
  {
    return getString("player_display_rank");
  }
  
  public String getDisplayPlayerScore()
  {
    return getString("player_display_score");
  }
  
  public long getNumScores()
  {
    if (zzcv("total_scores")) {
      return -1L;
    }
    return getLong("total_scores");
  }
  
  public long getPlayerRank()
  {
    if (zzcv("player_rank")) {
      return -1L;
    }
    return getLong("player_rank");
  }
  
  public String getPlayerScoreTag()
  {
    return getString("player_score_tag");
  }
  
  public long getRawPlayerScore()
  {
    if (zzcv("player_raw_score")) {
      return -1L;
    }
    return getLong("player_raw_score");
  }
  
  public int getTimeSpan()
  {
    return getInteger("timespan");
  }
  
  public boolean hasPlayerInfo()
  {
    return !zzcv("player_raw_score");
  }
  
  public int hashCode()
  {
    return LeaderboardVariantEntity.zza(this);
  }
  
  public String toString()
  {
    return LeaderboardVariantEntity.zzb(this);
  }
  
  public String zzxe()
  {
    return getString("top_page_token_next");
  }
  
  public String zzxf()
  {
    return getString("window_page_token_prev");
  }
  
  public String zzxg()
  {
    return getString("window_page_token_next");
  }
  
  public LeaderboardVariant zzxh()
  {
    return new LeaderboardVariantEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */