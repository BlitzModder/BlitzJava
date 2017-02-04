package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzlh
{
  private final String zzabt;
  private final int zzabu;
  private final String zzabv;
  
  public zzlh(String paramString1, int paramInt, String paramString2)
  {
    this.zzabt = paramString1;
    this.zzabu = paramInt;
    this.zzabv = paramString2;
  }
  
  public zzlh(JSONObject paramJSONObject)
    throws JSONException
  {
    this(paramJSONObject.optString("applicationName"), paramJSONObject.optInt("maxPlayers"), paramJSONObject.optString("version"));
  }
  
  public final int getMaxPlayers()
  {
    return this.zzabu;
  }
  
  public final String getVersion()
  {
    return this.zzabv;
  }
  
  public final String zznF()
  {
    return this.zzabt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */