package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer
  extends AbstractDataBuffer<GameNotification>
{
  public GameNotification zzgv(int paramInt)
  {
    return new GameNotificationRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */