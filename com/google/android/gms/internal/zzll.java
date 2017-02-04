package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

public final class zzll
  implements PlayerInfo
{
  private final int zzZH;
  private final JSONObject zzabG;
  private final boolean zzabH;
  private final String zzabq;
  
  public zzll(String paramString, int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.zzabq = paramString;
    this.zzZH = paramInt;
    this.zzabG = paramJSONObject;
    this.zzabH = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PlayerInfo))) {}
    do
    {
      return false;
      paramObject = (PlayerInfo)paramObject;
    } while ((this.zzabH != ((PlayerInfo)paramObject).isControllable()) || (this.zzZH != ((PlayerInfo)paramObject).getPlayerState()) || (!zzf.zza(this.zzabq, ((PlayerInfo)paramObject).getPlayerId())) || (!zznu.zze(this.zzabG, ((PlayerInfo)paramObject).getPlayerData())));
    return true;
  }
  
  public JSONObject getPlayerData()
  {
    return this.zzabG;
  }
  
  public String getPlayerId()
  {
    return this.zzabq;
  }
  
  public int getPlayerState()
  {
    return this.zzZH;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzabq, Integer.valueOf(this.zzZH), this.zzabG, Boolean.valueOf(this.zzabH) });
  }
  
  public boolean isConnected()
  {
    switch (this.zzZH)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isControllable()
  {
    return this.zzabH;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */