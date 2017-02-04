package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zznn;
import java.util.ArrayList;

public final class LeaderboardEntity
  implements Leaderboard
{
  private final String zzVu;
  private final String zzaGp;
  private final int zzaGq;
  private final ArrayList<LeaderboardVariantEntity> zzaGr;
  private final Game zzaGs;
  private final Uri zzazC;
  private final String zzazN;
  
  public LeaderboardEntity(Leaderboard paramLeaderboard)
  {
    this.zzaGp = paramLeaderboard.getLeaderboardId();
    this.zzVu = paramLeaderboard.getDisplayName();
    this.zzazC = paramLeaderboard.getIconImageUri();
    this.zzazN = paramLeaderboard.getIconImageUrl();
    this.zzaGq = paramLeaderboard.getScoreOrder();
    Object localObject = paramLeaderboard.getGame();
    if (localObject == null) {}
    for (localObject = null;; localObject = new GameEntity((Game)localObject))
    {
      this.zzaGs = ((Game)localObject);
      paramLeaderboard = paramLeaderboard.getVariants();
      int j = paramLeaderboard.size();
      this.zzaGr = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.zzaGr.add((LeaderboardVariantEntity)((LeaderboardVariant)paramLeaderboard.get(i)).freeze());
        i += 1;
      }
    }
  }
  
  static int zza(Leaderboard paramLeaderboard)
  {
    return zzw.hashCode(new Object[] { paramLeaderboard.getLeaderboardId(), paramLeaderboard.getDisplayName(), paramLeaderboard.getIconImageUri(), Integer.valueOf(paramLeaderboard.getScoreOrder()), paramLeaderboard.getVariants() });
  }
  
  static boolean zza(Leaderboard paramLeaderboard, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Leaderboard)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboard == paramObject);
      paramObject = (Leaderboard)paramObject;
      if ((!zzw.equal(((Leaderboard)paramObject).getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!zzw.equal(((Leaderboard)paramObject).getDisplayName(), paramLeaderboard.getDisplayName())) || (!zzw.equal(((Leaderboard)paramObject).getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!zzw.equal(Integer.valueOf(((Leaderboard)paramObject).getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Leaderboard)paramObject).getVariants(), paramLeaderboard.getVariants()));
    return false;
  }
  
  static String zzb(Leaderboard paramLeaderboard)
  {
    return zzw.zzx(paramLeaderboard).zzg("LeaderboardId", paramLeaderboard.getLeaderboardId()).zzg("DisplayName", paramLeaderboard.getDisplayName()).zzg("IconImageUri", paramLeaderboard.getIconImageUri()).zzg("IconImageUrl", paramLeaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).zzg("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzVu, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.zzaGs;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzazC;
  }
  
  public String getIconImageUrl()
  {
    return this.zzazN;
  }
  
  public String getLeaderboardId()
  {
    return this.zzaGp;
  }
  
  public int getScoreOrder()
  {
    return this.zzaGq;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.zzaGr);
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
  
  public Leaderboard zzxb()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */