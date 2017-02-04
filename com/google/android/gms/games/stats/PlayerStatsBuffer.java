package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerStatsBuffer
  extends AbstractDataBuffer<PlayerStats>
{
  public PlayerStatsBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public PlayerStats zzgN(int paramInt)
  {
    return new PlayerStatsRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/stats/PlayerStatsBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */