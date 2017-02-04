package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzlm
{
  private final int zzZH;
  private final JSONObject zzabG;
  private final String zzabq;
  
  public zzlm(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    this.zzabq = paramString;
    this.zzZH = paramInt;
    this.zzabG = paramJSONObject;
  }
  
  public zzlm(JSONObject paramJSONObject)
    throws JSONException
  {
    this(paramJSONObject.optString("playerId"), paramJSONObject.optInt("playerState"), paramJSONObject.optJSONObject("playerData"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzlm))) {}
    do
    {
      return false;
      paramObject = (zzlm)paramObject;
    } while ((this.zzZH != ((zzlm)paramObject).getPlayerState()) || (!zzf.zza(this.zzabq, ((zzlm)paramObject).getPlayerId())) || (!zznu.zze(this.zzabG, ((zzlm)paramObject).getPlayerData())));
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
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */