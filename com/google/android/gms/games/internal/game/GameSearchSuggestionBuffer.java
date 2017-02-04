package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer
  extends AbstractDataBuffer<GameSearchSuggestion>
{
  public GameSearchSuggestionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public GameSearchSuggestion zzgt(int paramInt)
  {
    return new GameSearchSuggestionRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/game/GameSearchSuggestionBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */