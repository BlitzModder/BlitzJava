package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef
  extends zzc
  implements ExperienceEvent
{
  private final GameRef zzaFA;
  
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    if (zzcv("external_game_id"))
    {
      this.zzaFA = null;
      return;
    }
    this.zzaFA = new GameRef(this.zzafC, this.zzahw);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/experience/ExperienceEventRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */