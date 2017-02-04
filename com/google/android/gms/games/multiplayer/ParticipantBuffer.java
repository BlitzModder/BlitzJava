package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class ParticipantBuffer
  extends AbstractDataBuffer<Participant>
{
  public Participant get(int paramInt)
  {
    return new ParticipantRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */