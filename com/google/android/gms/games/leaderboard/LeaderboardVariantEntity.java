package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int zzaGH;
  private final int zzaGI;
  private final boolean zzaGJ;
  private final long zzaGK;
  private final String zzaGL;
  private final long zzaGM;
  private final String zzaGN;
  private final String zzaGO;
  private final long zzaGP;
  private final String zzaGQ;
  private final String zzaGR;
  private final String zzaGS;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.zzaGH = paramLeaderboardVariant.getTimeSpan();
    this.zzaGI = paramLeaderboardVariant.getCollection();
    this.zzaGJ = paramLeaderboardVariant.hasPlayerInfo();
    this.zzaGK = paramLeaderboardVariant.getRawPlayerScore();
    this.zzaGL = paramLeaderboardVariant.getDisplayPlayerScore();
    this.zzaGM = paramLeaderboardVariant.getPlayerRank();
    this.zzaGN = paramLeaderboardVariant.getDisplayPlayerRank();
    this.zzaGO = paramLeaderboardVariant.getPlayerScoreTag();
    this.zzaGP = paramLeaderboardVariant.getNumScores();
    this.zzaGQ = paramLeaderboardVariant.zzxe();
    this.zzaGR = paramLeaderboardVariant.zzxf();
    this.zzaGS = paramLeaderboardVariant.zzxg();
  }
  
  static int zza(LeaderboardVariant paramLeaderboardVariant)
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.zzxe(), paramLeaderboardVariant.zzxg(), paramLeaderboardVariant.zzxf() });
  }
  
  static boolean zza(LeaderboardVariant paramLeaderboardVariant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardVariant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardVariant == paramObject);
      paramObject = (LeaderboardVariant)paramObject;
      if ((!zzw.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!zzw.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!zzw.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!zzw.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!zzw.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!zzw.equal(((LeaderboardVariant)paramObject).zzxe(), paramLeaderboardVariant.zzxe())) || (!zzw.equal(((LeaderboardVariant)paramObject).zzxg(), paramLeaderboardVariant.zzxg()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((LeaderboardVariant)paramObject).zzxf(), paramLeaderboardVariant.zzxf()));
    return false;
  }
  
  static String zzb(LeaderboardVariant paramLeaderboardVariant)
  {
    zzw.zza localzza = zzw.zzx(paramLeaderboardVariant).zzg("TimeSpan", TimeSpan.zzgo(paramLeaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzgo(paramLeaderboardVariant.getCollection()));
    if (paramLeaderboardVariant.hasPlayerInfo())
    {
      localObject = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
      localzza = localzza.zzg("RawPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label191;
      }
      localObject = paramLeaderboardVariant.getDisplayPlayerScore();
      label76:
      localzza = localzza.zzg("DisplayPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label197;
      }
      localObject = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
      label103:
      localzza = localzza.zzg("PlayerRank", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label203;
      }
    }
    label191:
    label197:
    label203:
    for (Object localObject = paramLeaderboardVariant.getDisplayPlayerRank();; localObject = "none")
    {
      return localzza.zzg("DisplayPlayerRank", localObject).zzg("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).zzg("TopPageNextToken", paramLeaderboardVariant.zzxe()).zzg("WindowPageNextToken", paramLeaderboardVariant.zzxg()).zzg("WindowPagePrevToken", paramLeaderboardVariant.zzxf()).toString();
      localObject = "none";
      break;
      localObject = "none";
      break label76;
      localObject = "none";
      break label103;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.zzaGI;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.zzaGN;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.zzaGL;
  }
  
  public long getNumScores()
  {
    return this.zzaGP;
  }
  
  public long getPlayerRank()
  {
    return this.zzaGM;
  }
  
  public String getPlayerScoreTag()
  {
    return this.zzaGO;
  }
  
  public long getRawPlayerScore()
  {
    return this.zzaGK;
  }
  
  public int getTimeSpan()
  {
    return this.zzaGH;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.zzaGJ;
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
  
  public String zzxe()
  {
    return this.zzaGQ;
  }
  
  public String zzxf()
  {
    return this.zzaGR;
  }
  
  public String zzxg()
  {
    return this.zzaGS;
  }
  
  public LeaderboardVariant zzxh()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */