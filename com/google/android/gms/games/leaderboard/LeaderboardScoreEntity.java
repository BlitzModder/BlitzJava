package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final Uri zzaGA;
  private final Uri zzaGB;
  private final PlayerEntity zzaGC;
  private final String zzaGD;
  private final String zzaGE;
  private final String zzaGF;
  private final long zzaGu;
  private final String zzaGv;
  private final String zzaGw;
  private final long zzaGx;
  private final long zzaGy;
  private final String zzaGz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.zzaGu = paramLeaderboardScore.getRank();
    this.zzaGv = ((String)zzx.zzy(paramLeaderboardScore.getDisplayRank()));
    this.zzaGw = ((String)zzx.zzy(paramLeaderboardScore.getDisplayScore()));
    this.zzaGx = paramLeaderboardScore.getRawScore();
    this.zzaGy = paramLeaderboardScore.getTimestampMillis();
    this.zzaGz = paramLeaderboardScore.getScoreHolderDisplayName();
    this.zzaGA = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.zzaGB = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.zzaGC = ((PlayerEntity)localObject);
      this.zzaGD = paramLeaderboardScore.getScoreTag();
      this.zzaGE = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.zzaGF = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int zza(LeaderboardScore paramLeaderboardScore)
  {
    return zzw.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
  }
  
  static boolean zza(LeaderboardScore paramLeaderboardScore, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardScore)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardScore == paramObject);
      paramObject = (LeaderboardScore)paramObject;
      if ((!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!zzw.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!zzw.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String zzb(LeaderboardScore paramLeaderboardScore)
  {
    zzw.zza localzza = zzw.zzx(paramLeaderboardScore).zzg("Rank", Long.valueOf(paramLeaderboardScore.getRank())).zzg("DisplayRank", paramLeaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).zzg("DisplayScore", paramLeaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).zzg("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
    if (paramLeaderboardScore.getScoreHolder() == null) {}
    for (Object localObject = null;; localObject = paramLeaderboardScore.getScoreHolder()) {
      return localzza.zzg("Player", localObject).zzg("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.zzaGv;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzaGv, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.zzaGw;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzaGw, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.zzaGu;
  }
  
  public long getRawScore()
  {
    return this.zzaGx;
  }
  
  public Player getScoreHolder()
  {
    return this.zzaGC;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.zzaGC == null) {
      return this.zzaGz;
    }
    return this.zzaGC.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.zzaGC == null)
    {
      zznn.zzb(this.zzaGz, paramCharArrayBuffer);
      return;
    }
    this.zzaGC.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.zzaGC == null) {
      return this.zzaGB;
    }
    return this.zzaGC.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.zzaGC == null) {
      return this.zzaGF;
    }
    return this.zzaGC.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.zzaGC == null) {
      return this.zzaGA;
    }
    return this.zzaGC.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.zzaGC == null) {
      return this.zzaGE;
    }
    return this.zzaGC.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.zzaGD;
  }
  
  public long getTimestampMillis()
  {
    return this.zzaGy;
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
  
  public LeaderboardScore zzxd()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */