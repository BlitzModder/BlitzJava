package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer
  extends AbstractDataBuffer<ExperienceEvent>
{
  public ExperienceEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public ExperienceEvent zzgp(int paramInt)
  {
    return new ExperienceEventRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/experience/ExperienceEventBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */