package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

public final class RoomConfigImpl
  extends RoomConfig
{
  private final String zzTr;
  private final int zzaGZ;
  private final RoomUpdateListener zzaHk;
  private final RoomStatusUpdateListener zzaHl;
  private final RealTimeMessageReceivedListener zzaHm;
  private final Bundle zzaHp;
  private final String[] zzaHq;
  
  RoomConfigImpl(RoomConfig.Builder paramBuilder)
  {
    this.zzaHk = paramBuilder.zzaHk;
    this.zzaHl = paramBuilder.zzaHl;
    this.zzaHm = paramBuilder.zzaHm;
    this.zzTr = paramBuilder.zzaHn;
    this.zzaGZ = paramBuilder.zzaGZ;
    this.zzaHp = paramBuilder.zzaHp;
    int i = paramBuilder.zzaHo.size();
    this.zzaHq = ((String[])paramBuilder.zzaHo.toArray(new String[i]));
    zzx.zzb(this.zzaHm, "Must specify a message listener");
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaHp;
  }
  
  public String getInvitationId()
  {
    return this.zzTr;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.zzaHq;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.zzaHm;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.zzaHl;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.zzaHk;
  }
  
  public int getVariant()
  {
    return this.zzaGZ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */