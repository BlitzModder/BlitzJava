package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer
  extends zzf<Leaderboard>
{
  public LeaderboardBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected Leaderboard zzo(int paramInt1, int paramInt2)
  {
    return new LeaderboardRef(this.zzafC, paramInt1, paramInt2);
  }
  
  protected String zzpO()
  {
    return "external_leaderboard_id";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */