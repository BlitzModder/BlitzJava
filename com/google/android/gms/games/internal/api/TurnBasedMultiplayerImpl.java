package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl
  implements TurnBasedMultiplayer
{
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new InitiateMatchImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zzd(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new CancelMatchImpl(paramString, paramGoogleApiClient)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zzf(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient paramGoogleApiClient, final TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    paramGoogleApiClient.zzb(new InitiateMatchImpl(paramGoogleApiClient, paramTurnBasedMatchConfig)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramTurnBasedMatchConfig);
      }
    });
  }
  
  public void declineInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzr(paramString, 1);
    }
  }
  
  public void dismissInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzq(paramString, 1);
    }
  }
  
  public void dismissMatch(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzdt(paramString);
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return finishMatch(paramGoogleApiClient, paramString, null, (ParticipantResult[])null);
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString, byte[] paramArrayOfByte, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()])) {
      return finishMatch(paramGoogleApiClient, paramString, paramArrayOfByte, paramList);
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, final String paramString, final byte[] paramArrayOfByte, final ParticipantResult... paramVarArgs)
  {
    paramGoogleApiClient.zzb(new UpdateMatchImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramString, paramArrayOfByte, paramVarArgs);
      }
    });
  }
  
  public Intent getInboxIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.zzf(paramGoogleApiClient).zzvX();
  }
  
  public int getMaxMatchDataSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.zzf(paramGoogleApiClient).zzwh();
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return Games.zzf(paramGoogleApiClient).zzb(paramInt1, paramInt2, true);
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return Games.zzf(paramGoogleApiClient).zzb(paramInt1, paramInt2, paramBoolean);
  }
  
  public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new LeaveMatchImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zze(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.zzb(new LeaveMatchImpl(paramGoogleApiClient, paramString1)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramString1, paramString2);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new LoadMatchImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zzg(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient paramGoogleApiClient, final int paramInt, final int[] paramArrayOfInt)
  {
    paramGoogleApiClient.zza(new LoadMatchesImpl(paramGoogleApiClient, paramInt)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramInt, paramArrayOfInt);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient paramGoogleApiClient, int[] paramArrayOfInt)
  {
    return loadMatchesByStatus(paramGoogleApiClient, 0, paramArrayOfInt);
  }
  
  public void registerMatchUpdateListener(GoogleApiClient paramGoogleApiClient, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    GamesClientImpl localGamesClientImpl = Games.zzb(paramGoogleApiClient, false);
    if (localGamesClientImpl != null) {
      localGamesClientImpl.zzb(paramGoogleApiClient.zzq(paramOnTurnBasedMatchUpdateReceivedListener));
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new InitiateMatchImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zzc(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    return takeTurn(paramGoogleApiClient, paramString1, paramArrayOfByte, paramString2, (ParticipantResult[])null);
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()])) {
      return takeTurn(paramGoogleApiClient, paramString1, paramArrayOfByte, paramString2, paramList);
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, final String paramString1, final byte[] paramArrayOfByte, final String paramString2, final ParticipantResult... paramVarArgs)
  {
    paramGoogleApiClient.zzb(new UpdateMatchImpl(paramGoogleApiClient, paramString1)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramString1, paramArrayOfByte, paramString2, paramVarArgs);
      }
    });
  }
  
  public void unregisterMatchUpdateListener(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzwa();
    }
  }
  
  private static abstract class CancelMatchImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult>
  {
    private final String zzxX;
    
    public CancelMatchImpl(String paramString, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzxX = paramString;
    }
    
    public TurnBasedMultiplayer.CancelMatchResult zzaH(final Status paramStatus)
    {
      new TurnBasedMultiplayer.CancelMatchResult()
      {
        public String getMatchId()
        {
          return TurnBasedMultiplayerImpl.CancelMatchImpl.zza(TurnBasedMultiplayerImpl.CancelMatchImpl.this);
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class InitiateMatchImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult>
  {
    private InitiateMatchImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public TurnBasedMultiplayer.InitiateMatchResult zzaI(final Status paramStatus)
    {
      new TurnBasedMultiplayer.InitiateMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LeaveMatchImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult>
  {
    private LeaveMatchImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public TurnBasedMultiplayer.LeaveMatchResult zzaJ(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LeaveMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadMatchImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult>
  {
    private LoadMatchImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public TurnBasedMultiplayer.LoadMatchResult zzaK(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LoadMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadMatchesImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult>
  {
    private LoadMatchesImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public TurnBasedMultiplayer.LoadMatchesResult zzaL(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LoadMatchesResult()
      {
        public LoadMatchesResponse getMatches()
        {
          return new LoadMatchesResponse(new Bundle());
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class UpdateMatchImpl
    extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult>
  {
    private UpdateMatchImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public TurnBasedMultiplayer.UpdateMatchResult zzaM(final Status paramStatus)
    {
      new TurnBasedMultiplayer.UpdateMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */