package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer
  extends zzf<Invitation>
{
  public InvitationBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected Invitation zzp(int paramInt1, int paramInt2)
  {
    return new InvitationRef(this.zzafC, paramInt1, paramInt2);
  }
  
  protected String zzpO()
  {
    return "external_invitation_id";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */