package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class GameRequestBuffer
  extends zzf<GameRequest>
{
  public GameRequestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String zzpO()
  {
    return "external_request_id";
  }
  
  protected GameRequest zzt(int paramInt1, int paramInt2)
  {
    return new GameRequestRef(this.zzafC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/request/GameRequestBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */