package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef
  extends zzc
  implements LeaderboardScore
{
  private final PlayerRef zzaGG;
  
  LeaderboardScoreRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.zzaGG = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardScoreEntity.zza(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return getString("display_rank");
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("display_rank", paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return getString("display_score");
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("display_score", paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return getLong("rank");
  }
  
  public long getRawScore()
  {
    return getLong("raw_score");
  }
  
  public Player getScoreHolder()
  {
    if (zzcv("external_player_id")) {
      return null;
    }
    return this.zzaGG;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (zzcv("external_player_id")) {
      return getString("default_display_name");
    }
    return this.zzaGG.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (zzcv("external_player_id"))
    {
      zza("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.zzaGG.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (zzcv("external_player_id")) {
      return null;
    }
    return this.zzaGG.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (zzcv("external_player_id")) {
      return null;
    }
    return this.zzaGG.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (zzcv("external_player_id")) {
      return zzcu("default_display_image_uri");
    }
    return this.zzaGG.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (zzcv("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.zzaGG.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return getString("score_tag");
  }
  
  public long getTimestampMillis()
  {
    return getLong("achieved_timestamp");
  }
  
  public int hashCode()
  {
    return LeaderboardScoreEntity.zza(this);
  }
  
  public String toString()
  {
    return LeaderboardScoreEntity.zzb(this);
  }
  
  public LeaderboardScore zzxd()
  {
    return new LeaderboardScoreEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */