package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;

public final class TurnBasedMatchConfigImpl
  extends TurnBasedMatchConfig
{
  private final int zzaGZ;
  private final Bundle zzaHp;
  private final String[] zzaHq;
  private final int zzaHy;
  
  TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder paramBuilder)
  {
    this.zzaGZ = paramBuilder.zzaGZ;
    this.zzaHy = paramBuilder.zzaHy;
    this.zzaHp = paramBuilder.zzaHp;
    int i = paramBuilder.zzaHo.size();
    this.zzaHq = ((String[])paramBuilder.zzaHo.toArray(new String[i]));
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaHp;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.zzaHq;
  }
  
  public int getVariant()
  {
    return this.zzaGZ;
  }
  
  public int zzxi()
  {
    return this.zzaHy;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */