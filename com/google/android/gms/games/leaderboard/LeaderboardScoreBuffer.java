package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer
  extends AbstractDataBuffer<LeaderboardScore>
{
  private final LeaderboardScoreBufferHeader zzaGt;
  
  public LeaderboardScoreBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzaGt = new LeaderboardScoreBufferHeader(paramDataHolder.zzpH());
  }
  
  public LeaderboardScore get(int paramInt)
  {
    return new LeaderboardScoreRef(this.zzafC, paramInt);
  }
  
  public LeaderboardScoreBufferHeader zzxc()
  {
    return this.zzaGt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */