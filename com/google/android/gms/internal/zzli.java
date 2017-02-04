package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzli
{
  private static final zzl zzYy = new zzl("GameManagerMessage");
  protected final zzlh zzaaX;
  protected final int zzabA;
  protected final List<zzlm> zzabB;
  protected final JSONObject zzabC;
  protected final String zzabD;
  protected final String zzabE;
  protected final String zzabq;
  protected final long zzabr;
  protected final JSONObject zzabs;
  protected final int zzabw;
  protected final int zzabx;
  protected final String zzaby;
  protected final int zzabz;
  
  public zzli(int paramInt1, int paramInt2, String paramString1, JSONObject paramJSONObject1, int paramInt3, int paramInt4, List<zzlm> paramList, JSONObject paramJSONObject2, String paramString2, String paramString3, long paramLong, String paramString4, zzlh paramzzlh)
  {
    this.zzabw = paramInt1;
    this.zzabx = paramInt2;
    this.zzaby = paramString1;
    this.zzabs = paramJSONObject1;
    this.zzabz = paramInt3;
    this.zzabA = paramInt4;
    this.zzabB = paramList;
    this.zzabC = paramJSONObject2;
    this.zzabD = paramString2;
    this.zzabq = paramString3;
    this.zzabr = paramLong;
    this.zzabE = paramString4;
    this.zzaaX = paramzzlh;
  }
  
  private static List<zzlm> zza(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        Object localObject1 = paramJSONArray.optJSONObject(i);
        if (localObject1 != null) {}
        try
        {
          localObject1 = new zzlm((JSONObject)localObject1);
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            zzYy.zzc(localJSONException, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", new Object[] { Integer.valueOf(i) });
            Object localObject2 = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static zzli zzh(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("type", -1);
    switch (i)
    {
    }
    try
    {
      zzYy.zzf("Unrecognized Game Message type %d", new Object[] { Integer.valueOf(i) });
    }
    catch (JSONException paramJSONObject)
    {
      zzYy.zzc(paramJSONObject, "Exception while parsing GameManagerMessage from json", new Object[0]);
      break label247;
      zzlh localzzlh = null;
      JSONObject localJSONObject = paramJSONObject.optJSONObject("gameManagerConfig");
      if (localJSONObject == null) {
        break label166;
      }
      localzzlh = new zzlh(localJSONObject);
      label166:
      paramJSONObject = new zzli(i, paramJSONObject.optInt("statusCode"), paramJSONObject.optString("errorDescription"), paramJSONObject.optJSONObject("extraMessageData"), paramJSONObject.optInt("gameplayState"), paramJSONObject.optInt("lobbyState"), zza(paramJSONObject.optJSONArray("players")), paramJSONObject.optJSONObject("gameData"), paramJSONObject.optString("gameStatusText"), paramJSONObject.optString("playerId"), paramJSONObject.optLong("requestId"), paramJSONObject.optString("playerToken"), localzzlh);
      return paramJSONObject;
    }
    paramJSONObject = new zzli(i, paramJSONObject.optInt("statusCode"), paramJSONObject.optString("errorDescription"), paramJSONObject.optJSONObject("extraMessageData"), paramJSONObject.optInt("gameplayState"), paramJSONObject.optInt("lobbyState"), zza(paramJSONObject.optJSONArray("players")), paramJSONObject.optJSONObject("gameData"), paramJSONObject.optString("gameStatusText"), paramJSONObject.optString("playerId"), -1L, null, null);
    return paramJSONObject;
    label247:
    return null;
  }
  
  public final JSONObject getExtraMessageData()
  {
    return this.zzabs;
  }
  
  public final JSONObject getGameData()
  {
    return this.zzabC;
  }
  
  public final int getGameplayState()
  {
    return this.zzabz;
  }
  
  public final int getLobbyState()
  {
    return this.zzabA;
  }
  
  public final String getPlayerId()
  {
    return this.zzabq;
  }
  
  public final long getRequestId()
  {
    return this.zzabr;
  }
  
  public final int getStatusCode()
  {
    return this.zzabx;
  }
  
  public final int zznG()
  {
    return this.zzabw;
  }
  
  public final String zznH()
  {
    return this.zzaby;
  }
  
  public final List<zzlm> zznI()
  {
    return this.zzabB;
  }
  
  public final String zznJ()
  {
    return this.zzabD;
  }
  
  public final String zznK()
  {
    return this.zzabE;
  }
  
  public final zzlh zznL()
  {
    return this.zzaaX;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */