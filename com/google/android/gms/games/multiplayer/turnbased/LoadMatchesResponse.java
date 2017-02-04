package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer zzaHu;
  private final TurnBasedMatchBuffer zzaHv;
  private final TurnBasedMatchBuffer zzaHw;
  private final TurnBasedMatchBuffer zzaHx;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = zza(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.zzaHu = new InvitationBuffer(localDataHolder);
      localDataHolder = zza(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.zzaHv = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = zza(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.zzaHw = new TurnBasedMatchBuffer(localDataHolder);; this.zzaHw = null)
    {
      paramBundle = zza(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.zzaHx = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.zzaHu = null;
      break;
      this.zzaHv = null;
      break label48;
    }
    label117:
    this.zzaHx = null;
  }
  
  private static DataHolder zza(Bundle paramBundle, int paramInt)
  {
    String str = TurnBasedMatchTurnStatus.zzgo(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  @Deprecated
  public void close()
  {
    release();
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.zzaHx;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.zzaHu;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.zzaHv;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.zzaHw;
  }
  
  public boolean hasData()
  {
    if ((this.zzaHu != null) && (this.zzaHu.getCount() > 0)) {}
    while (((this.zzaHv != null) && (this.zzaHv.getCount() > 0)) || ((this.zzaHw != null) && (this.zzaHw.getCount() > 0)) || ((this.zzaHx != null) && (this.zzaHx.getCount() > 0))) {
      return true;
    }
    return false;
  }
  
  public void release()
  {
    if (this.zzaHu != null) {
      this.zzaHu.release();
    }
    if (this.zzaHv != null) {
      this.zzaHv.release();
    }
    if (this.zzaHw != null) {
      this.zzaHw.release();
    }
    if (this.zzaHx != null) {
      this.zzaHx.release();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */