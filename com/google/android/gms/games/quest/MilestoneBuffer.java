package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class MilestoneBuffer
  extends AbstractDataBuffer<Milestone>
{
  public Milestone get(int paramInt)
  {
    return new MilestoneRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */