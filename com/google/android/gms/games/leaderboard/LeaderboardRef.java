package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef
  extends zzc
  implements Leaderboard
{
  private final int zzaBl;
  private final Game zzaGs;
  
  LeaderboardRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzaBl = paramInt2;
    this.zzaGs = new GameRef(paramDataHolder, paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardEntity.zza(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString("name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("name", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.zzaGs;
  }
  
  public Uri getIconImageUri()
  {
    return zzcu("board_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("board_icon_image_url");
  }
  
  public String getLeaderboardId()
  {
    return getString("external_leaderboard_id");
  }
  
  public int getScoreOrder()
  {
    return getInteger("score_order");
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    ArrayList localArrayList = new ArrayList(this.zzaBl);
    int i = 0;
    while (i < this.zzaBl)
    {
      localArrayList.add(new LeaderboardVariantRef(this.zzafC, this.zzahw + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return LeaderboardEntity.zza(this);
  }
  
  public String toString()
  {
    return LeaderboardEntity.zzb(this);
  }
  
  public Leaderboard zzxb()
  {
    return new LeaderboardEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */