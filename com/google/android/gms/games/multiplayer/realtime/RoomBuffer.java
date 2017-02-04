package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer
  extends zzf<Room>
{
  public RoomBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String zzpO()
  {
    return "external_match_id";
  }
  
  protected Room zzq(int paramInt1, int paramInt2)
  {
    return new RoomRef(this.zzafC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */