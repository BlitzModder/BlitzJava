package com.google.android.gms.cast.games;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlg;
import org.json.JSONObject;

public final class GameManagerClient
{
  public static final int GAMEPLAY_STATE_LOADING = 1;
  public static final int GAMEPLAY_STATE_PAUSED = 3;
  public static final int GAMEPLAY_STATE_RUNNING = 2;
  public static final int GAMEPLAY_STATE_SHOWING_INFO_SCREEN = 4;
  public static final int GAMEPLAY_STATE_UNKNOWN = 0;
  public static final int LOBBY_STATE_CLOSED = 2;
  public static final int LOBBY_STATE_OPEN = 1;
  public static final int LOBBY_STATE_UNKNOWN = 0;
  public static final int PLAYER_STATE_AVAILABLE = 3;
  public static final int PLAYER_STATE_DROPPED = 1;
  public static final int PLAYER_STATE_IDLE = 5;
  public static final int PLAYER_STATE_PLAYING = 6;
  public static final int PLAYER_STATE_QUIT = 2;
  public static final int PLAYER_STATE_READY = 4;
  public static final int PLAYER_STATE_UNKNOWN = 0;
  public static final int STATUS_INCORRECT_VERSION = 2150;
  public static final int STATUS_TOO_MANY_PLAYERS = 2151;
  private final zzlg zzaaR;
  
  public GameManagerClient(zzlg paramzzlg)
  {
    this.zzaaR = paramzzlg;
  }
  
  public static PendingResult<GameManagerInstanceResult> getInstanceFor(GoogleApiClient paramGoogleApiClient, String paramString)
    throws IllegalArgumentException
  {
    return zza(new zzlg(paramGoogleApiClient, paramString, Cast.CastApi));
  }
  
  static PendingResult<GameManagerInstanceResult> zza(zzlg paramzzlg)
    throws IllegalArgumentException
  {
    return paramzzlg.zza(new GameManagerClient(paramzzlg));
  }
  
  private PendingResult<GameManagerResult> zza(String paramString, int paramInt, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return this.zzaaR.zza(paramString, paramInt, paramJSONObject);
  }
  
  public void dispose()
  {
    this.zzaaR.dispose();
  }
  
  public GameManagerState getCurrentState()
    throws IllegalStateException
  {
    try
    {
      GameManagerState localGameManagerState = this.zzaaR.getCurrentState();
      return localGameManagerState;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLastUsedPlayerId()
    throws IllegalStateException
  {
    return this.zzaaR.getLastUsedPlayerId();
  }
  
  public boolean isDisposed()
  {
    return this.zzaaR.isDisposed();
  }
  
  public void sendGameMessage(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    this.zzaaR.sendGameMessage(paramString, paramJSONObject);
  }
  
  public void sendGameMessage(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    sendGameMessage(getLastUsedPlayerId(), paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendGameRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return this.zzaaR.sendGameRequest(paramString, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendGameRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return sendGameRequest(getLastUsedPlayerId(), paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerAvailableRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(paramString, 3, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerAvailableRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(getLastUsedPlayerId(), 3, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerIdleRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(paramString, 5, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerIdleRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(getLastUsedPlayerId(), 5, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerPlayingRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(paramString, 6, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerPlayingRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(getLastUsedPlayerId(), 6, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerQuitRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(paramString, 2, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerQuitRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(getLastUsedPlayerId(), 2, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerReadyRequest(String paramString, JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(paramString, 4, paramJSONObject);
  }
  
  public PendingResult<GameManagerResult> sendPlayerReadyRequest(JSONObject paramJSONObject)
    throws IllegalStateException
  {
    return zza(getLastUsedPlayerId(), 4, paramJSONObject);
  }
  
  public void setListener(Listener paramListener)
  {
    this.zzaaR.setListener(paramListener);
  }
  
  public void setSessionLabel(String paramString)
  {
    this.zzaaR.setSessionLabel(paramString);
  }
  
  public static abstract interface GameManagerInstanceResult
    extends Result
  {
    public abstract GameManagerClient getGameManagerClient();
  }
  
  public static abstract interface GameManagerResult
    extends Result
  {
    public abstract JSONObject getExtraMessageData();
    
    public abstract String getPlayerId();
    
    public abstract long getRequestId();
  }
  
  public static abstract interface Listener
  {
    public abstract void onGameMessageReceived(String paramString, JSONObject paramJSONObject);
    
    public abstract void onStateChanged(GameManagerState paramGameManagerState1, GameManagerState paramGameManagerState2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/games/GameManagerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */