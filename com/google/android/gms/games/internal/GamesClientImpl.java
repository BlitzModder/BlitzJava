package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GetTokenResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;
import com.google.android.gms.signin.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl
  extends zzj<IGamesService>
{
  private boolean zzaBA = false;
  private final Binder zzaBB;
  private final long zzaBC;
  private final Games.GamesOptions zzaBD;
  EventIncrementManager zzaBv = new EventIncrementManager()
  {
    public EventIncrementCache zzwo()
    {
      return new GamesClientImpl.GameClientEventIncrementCache(GamesClientImpl.this);
    }
  };
  private final String zzaBw;
  private PlayerEntity zzaBx;
  private GameEntity zzaBy;
  private final PopupManager zzaBz;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, zzf paramzzf, Games.GamesOptions paramGamesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 1, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzaBw = paramzzf.zzqd();
    this.zzaBB = new Binder();
    this.zzaBz = PopupManager.zza(this, paramzzf.zzpZ());
    zzo(paramzzf.zzqf());
    this.zzaBC = hashCode();
    this.zzaBD = paramGamesOptions;
  }
  
  private static Room zzY(DataHolder paramDataHolder)
  {
    RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localRoomBuffer.getCount() > 0) {
        paramDataHolder = (Room)((Room)localRoomBuffer.get(0)).freeze();
      }
      return paramDataHolder;
    }
    finally
    {
      localRoomBuffer.release();
    }
  }
  
  private void zzb(RemoteException paramRemoteException)
  {
    GamesLog.zzb("GamesClientImpl", "service died", paramRemoteException);
  }
  
  private void zzvP()
  {
    this.zzaBx = null;
    this.zzaBy = null;
  }
  
  public void disconnect()
  {
    this.zzaBA = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)zzqs();
      localIGamesService.zzwn();
      this.zzaBv.flush();
      localIGamesService.zzF(this.zzaBC);
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.zzA("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    this.zzaBA = false;
  }
  
  public int zza(zzmn<RealTimeMultiplayer.ReliableMessageSentCallback> paramzzmn, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((IGamesService)zzqs()).zza(new RealTimeReliableMessageBinderCallbacks(paramzzmn), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
    return -1;
  }
  
  public int zza(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    zzx.zzb(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((IGamesService)zzqs()).zzb(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return -1;
  }
  
  public Intent zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      paramArrayOfByte = ((IGamesService)zzqs()).zza(paramInt1, paramArrayOfByte, paramInt2, paramString);
      zzx.zzb(paramBitmap, "Must provide a non null icon");
      paramArrayOfByte.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return paramArrayOfByte;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return null;
  }
  
  public Intent zza(PlayerEntity paramPlayerEntity)
  {
    try
    {
      paramPlayerEntity = ((IGamesService)zzqs()).zza(paramPlayerEntity);
      return paramPlayerEntity;
    }
    catch (RemoteException paramPlayerEntity)
    {
      zzb(paramPlayerEntity);
    }
    return null;
  }
  
  public Intent zza(Room paramRoom, int paramInt)
  {
    try
    {
      paramRoom = ((IGamesService)zzqs()).zza((RoomEntity)paramRoom.freeze(), paramInt);
      return paramRoom;
    }
    catch (RemoteException paramRoom)
    {
      zzb(paramRoom);
    }
    return null;
  }
  
  public Intent zza(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      paramString = ((IGamesService)zzqs()).zza(paramString, paramBoolean1, paramBoolean2, paramInt);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null))
    {
      paramBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      this.zzaBA = paramBundle.getBoolean("show_welcome_popup");
      this.zzaBx = ((PlayerEntity)paramBundle.getParcelable("com.google.android.gms.games.current_player"));
      this.zzaBy = ((GameEntity)paramBundle.getParcelable("com.google.android.gms.games.current_game"));
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)zzqs()).zza(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      zzb(paramIBinder);
    }
  }
  
  public void zza(GoogleApiClient.zza paramzza)
  {
    zzvP();
    super.zza(paramzza);
  }
  
  public void zza(Games.BaseGamesApiMethodImpl<Status> paramBaseGamesApiMethodImpl, String paramString1, String paramString2, VideoConfiguration paramVideoConfiguration)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new StartRecordingBinderCallback(paramBaseGamesApiMethodImpl), paramString1, paramString2, paramVideoConfiguration);
  }
  
  public void zza(Snapshot paramSnapshot)
  {
    paramSnapshot = paramSnapshot.getSnapshotContents();
    if (!paramSnapshot.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Snapshot already closed");
      Contents localContents = paramSnapshot.zzsh();
      paramSnapshot.close();
      try
      {
        ((IGamesService)zzqs()).zza(localContents);
        return;
      }
      catch (RemoteException paramSnapshot)
      {
        zzb(paramSnapshot);
      }
    }
  }
  
  public void zza(zzlx.zzb<Invitations.LoadInvitationsResult> paramzzb, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new InvitationsLoadedBinderCallback(paramzzb), paramInt);
  }
  
  public void zza(zzlx.zzb<Requests.LoadRequestsResult> paramzzb, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestsLoadedBinderCallbacks(paramzzb), paramInt1, paramInt2, paramInt3);
  }
  
  public void zza(zzlx.zzb<AppContents.LoadAppContentResult> paramzzb, int paramInt, String paramString, String[] paramArrayOfString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new AppContentLoadedBinderCallbacks(paramzzb), paramInt, paramString, paramArrayOfString, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb, int paramInt, int[] paramArrayOfInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new TurnBasedMatchesLoadedBinderCallbacks(paramzzb), paramInt, paramArrayOfInt);
  }
  
  public void zza(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramLeaderboardScoreBuffer.zzxc().asBundle(), paramInt1, paramInt2);
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, TurnBasedMatchConfig paramTurnBasedMatchConfig)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.zzxi(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
  }
  
  public void zza(zzlx.zzb<Snapshots.CommitSnapshotResult> paramzzb, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
    throws RemoteException
  {
    SnapshotContents localSnapshotContents = paramSnapshot.getSnapshotContents();
    if (!localSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Snapshot already closed");
      Object localObject = paramSnapshotMetadataChange.zzxn();
      if (localObject != null) {
        ((BitmapTeleporter)localObject).zzc(getContext().getCacheDir());
      }
      localObject = localSnapshotContents.zzsh();
      localSnapshotContents.close();
      ((IGamesService)zzqs()).zza(new SnapshotCommittedBinderCallbacks(paramzzb), paramSnapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, (Contents)localObject);
      return;
    }
  }
  
  public void zza(zzlx.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzqs()).zza(paramzzb, paramString, this.zzaBz.zzwC(), this.zzaBz.zzwB());
      return;
    }
  }
  
  public void zza(zzlx.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzqs()).zza(paramzzb, paramString, paramInt, this.zzaBz.zzwC(), this.zzaBz.zzwB());
      return;
    }
  }
  
  public void zza(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString);
        if (paramString.equals("played_with")) {
          i = 0;
        }
        break;
      }
    }
    ((IGamesService)zzqs()).zzd(new PlayersLoadedBinderCallback(paramzzb), paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb, String paramString, int paramInt, int[] paramArrayOfInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new TurnBasedMatchesLoadedBinderCallbacks(paramzzb), paramString, paramInt, paramArrayOfInt);
  }
  
  public void zza(zzlx.zzb<Leaderboards.SubmitScoreResult> paramzzb, String paramString1, long paramLong, String paramString2)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new SubmitScoreBinderCallbacks(paramzzb))
    {
      ((IGamesService)zzqs()).zza(paramzzb, paramString1, paramLong, paramString2);
      return;
    }
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new TurnBasedMatchLeftBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zza(zzlx.zzb<Leaderboards.LoadPlayerScoreResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void zza(zzlx.zzb<Requests.LoadRequestsResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void zza(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString1);
        if (paramString1.equals("circled"))
        {
          i = 0;
          continue;
          if (paramString1.equals("played_with"))
          {
            i = 1;
            continue;
            if (paramString1.equals("nearby")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    ((IGamesService)zzqs()).zza(new PlayersLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlx.zzb<Snapshots.OpenSnapshotResult> paramzzb, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, SnapshotContents paramSnapshotContents)
    throws RemoteException
  {
    if (!paramSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "SnapshotContents already closed");
      Object localObject = paramSnapshotMetadataChange.zzxn();
      if (localObject != null) {
        ((BitmapTeleporter)localObject).zzc(getContext().getCacheDir());
      }
      localObject = paramSnapshotContents.zzsh();
      paramSnapshotContents.close();
      ((IGamesService)zzqs()).zza(new SnapshotOpenedBinderCallbacks(paramzzb), paramString1, paramString2, (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, (Contents)localObject);
      return;
    }
  }
  
  public void zza(zzlx.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new LeaderboardsLoadedBinderCallback(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Quests.LoadQuestsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfString, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Quests.LoadQuestsResult> paramzzb, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Requests.UpdateRequestsResult> paramzzb, String paramString1, String paramString2, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestsUpdatedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfString);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzf(new PlayersLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Snapshots.OpenSnapshotResult> paramzzb, String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new SnapshotOpenedBinderCallbacks(paramzzb), paramString, paramBoolean, paramInt);
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new TurnBasedMatchUpdatedBinderCallbacks(paramzzb), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
  }
  
  public void zza(zzlx.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new TurnBasedMatchUpdatedBinderCallbacks(paramzzb), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
  }
  
  public void zza(zzlx.zzb<Requests.SendRequestResult> paramzzb, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestSentBinderCallbacks(paramzzb), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new ContactSettingsUpdatedBinderCallback(paramzzb), paramBoolean, paramBundle);
  }
  
  public void zza(zzlx.zzb<Events.LoadEventsResult> paramzzb, boolean paramBoolean, String... paramVarArgs)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new EventsLoadedBinderCallback(paramzzb), paramBoolean, paramVarArgs);
  }
  
  public void zza(zzlx.zzb<Quests.LoadQuestsResult> paramzzb, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramArrayOfInt, paramInt, paramBoolean);
  }
  
  public void zza(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramArrayOfString);
  }
  
  public void zza(zzmn<OnInvitationReceivedListener> paramzzmn)
  {
    try
    {
      paramzzmn = new InvitationReceivedBinderCallback(paramzzmn);
      ((IGamesService)zzqs()).zza(paramzzmn, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public void zza(zzmn<RoomUpdateListener> paramzzmn, zzmn<RoomStatusUpdateListener> paramzzmn1, zzmn<RealTimeMessageReceivedListener> paramzzmn2, RoomConfig paramRoomConfig)
  {
    try
    {
      paramzzmn = new RoomBinderCallbacks(paramzzmn, paramzzmn1, paramzzmn2);
      ((IGamesService)zzqs()).zza(paramzzmn, this.zzaBB, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), false, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public void zza(zzmn<RoomUpdateListener> paramzzmn, String paramString)
  {
    try
    {
      ((IGamesService)zzqs()).zzc(new RoomBinderCallbacks(paramzzmn), paramString);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public Intent zzb(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzb(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzb(int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt = ((IGamesService)zzqs()).zzb(paramArrayOfInt);
      return paramArrayOfInt;
    }
    catch (RemoteException paramArrayOfInt)
    {
      zzb(paramArrayOfInt);
    }
    return null;
  }
  
  protected Set<Scope> zzb(Set<Scope> paramSet)
  {
    Scope localScope1 = new Scope("https://www.googleapis.com/auth/games");
    Scope localScope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    boolean bool = false;
    Scope localScope3;
    if (localIterator.hasNext())
    {
      localScope3 = (Scope)localIterator.next();
      if (localScope3.equals(localScope1)) {
        bool = true;
      }
    }
    for (;;)
    {
      break;
      if (localScope3.equals(localScope2))
      {
        i = 1;
        continue;
        if (i != 0)
        {
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            zzx.zza(bool, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
            return paramSet;
          }
        }
        zzx.zza(bool, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
        return paramSet;
      }
    }
  }
  
  public void zzb(zzlx.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlx.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzqs()).zzb(paramzzb, paramString, this.zzaBz.zzwC(), this.zzaBz.zzwB());
      return;
    }
  }
  
  public void zzb(zzlx.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzqs()).zzb(paramzzb, paramString, paramInt, this.zzaBz.zzwC(), this.zzaBz.zzwB());
      return;
    }
  }
  
  public void zzb(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlx.zzb<Quests.ClaimMilestoneResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zzf(new QuestMilestoneClaimBinderCallbacks(paramzzb, paramString2), paramString1, paramString2);
  }
  
  public void zzb(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Players.LoadPlayersResult> paramzzb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlx.zzb<Achievements.LoadAchievementsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new AchievementsLoadedBinderCallback(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new LeaderboardsLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new LeaderboardsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Quests.LoadQuestsResult> paramzzb, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramArrayOfString, paramBoolean);
  }
  
  public void zzb(zzlx.zzb<Requests.UpdateRequestsResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestsUpdatedBinderCallbacks(paramzzb), paramArrayOfString);
  }
  
  public void zzb(zzmn<OnTurnBasedMatchUpdateReceivedListener> paramzzmn)
  {
    try
    {
      paramzzmn = new MatchUpdateReceivedBinderCallback(paramzzmn);
      ((IGamesService)zzqs()).zzb(paramzzmn, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public void zzb(zzmn<RoomUpdateListener> paramzzmn, zzmn<RoomStatusUpdateListener> paramzzmn1, zzmn<RealTimeMessageReceivedListener> paramzzmn2, RoomConfig paramRoomConfig)
  {
    try
    {
      paramzzmn = new RoomBinderCallbacks(paramzzmn, paramzzmn1, paramzzmn2);
      ((IGamesService)zzqs()).zza(paramzzmn, this.zzaBB, paramRoomConfig.getInvitationId(), false, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  protected IGamesService zzbV(IBinder paramIBinder)
  {
    return IGamesService.Stub.zzbY(paramIBinder);
  }
  
  public Intent zzc(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzc(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzc(zzlx.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzc(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzc(zzlx.zzb<Players.LoadXpStreamResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new PlayerXpStreamLoadedBinderCallback(paramzzb), paramString, paramInt);
  }
  
  public void zzc(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zzc(zzlx.zzb<Snapshots.LoadSnapshotsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new SnapshotsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zzc(zzlx.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzd(new LeaderboardsLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzc(zzlx.zzb<Achievements.LoadAchievementsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new AchievementsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzc(zzlx.zzb<Requests.UpdateRequestsResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new RequestsUpdatedBinderCallbacks(paramzzb), paramArrayOfString);
  }
  
  public void zzc(zzmn<QuestUpdateListener> paramzzmn)
  {
    try
    {
      paramzzmn = new QuestUpdateBinderCallback(paramzzmn);
      ((IGamesService)zzqs()).zzd(paramzzmn, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public int zzd(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzb(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return -1;
  }
  
  public void zzd(zzlx.zzb<Games.GetTokenResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzk(new GetAuthTokenBinderCallbacks(paramzzb));
  }
  
  public void zzd(zzlx.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zze(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzd(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzd(zzlx.zzb<Players.LoadXpStreamResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzc(new PlayerXpStreamLoadedBinderCallback(paramzzb), paramString, paramInt);
  }
  
  public void zzd(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zze(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zzd(zzlx.zzb<Notifications.GameMuteStatusChangeResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new GameMuteStatusChangedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzd(zzlx.zzb<Events.LoadEventsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zzf(new EventsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzd(zzmn<OnRequestReceivedListener> paramzzmn)
  {
    try
    {
      paramzzmn = new RequestReceivedBinderCallback(paramzzmn);
      ((IGamesService)zzqs()).zzc(paramzzmn, this.zzaBC);
      return;
    }
    catch (RemoteException paramzzmn)
    {
      zzb(paramzzmn);
    }
  }
  
  public void zzdt(String paramString)
  {
    try
    {
      ((IGamesService)zzqs()).zzdB(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public Intent zzdu(String paramString)
  {
    try
    {
      paramString = ((IGamesService)zzqs()).zzdu(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  public void zzdv(String paramString)
  {
    try
    {
      ((IGamesService)zzqs()).zza(paramString, this.zzaBz.zzwC(), this.zzaBz.zzwB());
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public void zze(zzlx.zzb<GamesMetadata.LoadGamesResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzd(new GamesLoadedBinderCallback(paramzzb));
  }
  
  public void zze(zzlx.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzo(new TurnBasedMatchLeftBinderCallbacks(paramzzb), paramString);
  }
  
  public void zze(zzlx.zzb<Invitations.LoadInvitationsResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzb(new InvitationsLoadedBinderCallback(paramzzb), paramString, paramInt, false);
  }
  
  public void zze(zzlx.zzb<Stats.LoadPlayerStatsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzi(new PlayerStatsLoadedBinderCallbacks(paramzzb), paramBoolean);
  }
  
  public void zzf(zzlx.zzb<Status> paramzzb)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zza(new SignOutCompleteBinderCallbacks(paramzzb));
  }
  
  public void zzf(zzlx.zzb<TurnBasedMultiplayer.CancelMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzn(new TurnBasedMatchCanceledBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzf(zzlx.zzb<Requests.LoadRequestSummariesResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zza(new RequestSummariesLoadedBinderCallbacks(paramzzb), paramString, paramInt);
  }
  
  public void zzf(zzlx.zzb<Snapshots.LoadSnapshotsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzd(new SnapshotsLoadedBinderCallbacks(paramzzb), paramBoolean);
  }
  
  public void zzg(zzlx.zzb<Videos.ListVideosResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzl(new ListVideosBinderCallback(paramzzb));
  }
  
  public void zzg(zzlx.zzb<TurnBasedMultiplayer.LoadMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzp(new TurnBasedMatchLoadedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzg(zzlx.zzb<Players.LoadProfileSettingsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzg(new ProfileSettingsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void zzgk(int paramInt)
  {
    this.zzaBz.setGravity(paramInt);
  }
  
  public void zzgl(int paramInt)
  {
    try
    {
      ((IGamesService)zzqs()).zzgl(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzh(zzlx.zzb<Acls.LoadAclResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzh(new NotifyAclLoadedBinderCallback(paramzzb));
  }
  
  public void zzh(zzlx.zzb<Quests.AcceptQuestResult> paramzzb, String paramString)
    throws RemoteException
  {
    this.zzaBv.flush();
    ((IGamesService)zzqs()).zzu(new QuestAcceptedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzh(zzlx.zzb<Status> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzh(new ProfileSettingsUpdatedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzi(zzlx.zzb<Notifications.InboxCountResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzt(new InboxCountsLoadedBinderCallback(paramzzb), null);
  }
  
  public void zzi(zzlx.zzb<Snapshots.DeleteSnapshotResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzr(new SnapshotDeletedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzi(zzlx.zzb<Notifications.ContactSettingLoadResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zze(new ContactSettingsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzj(zzlx.zzb<GamesMetadata.LoadGameInstancesResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzf(new GameInstancesLoadedBinderCallback(paramzzb), paramString);
  }
  
  public void zzk(zzlx.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzq(new GameSearchSuggestionsLoadedBinderCallback(paramzzb), paramString);
  }
  
  public Intent zzl(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = ((IGamesService)zzqs()).zzm(paramString, paramInt1, paramInt2);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  public void zzl(zzlx.zzb<Players.LoadXpForGameCategoriesResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(paramzzb), paramString);
  }
  
  protected Bundle zzlU()
  {
    Object localObject = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = this.zzaBD.zzuX();
    localBundle.putString("com.google.android.gms.games.key.gamePackageName", this.zzaBw);
    localBundle.putString("com.google.android.gms.games.key.desiredLocale", (String)localObject);
    localBundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaBz.zzwC()));
    localBundle.putInt("com.google.android.gms.games.key.API_VERSION", 2);
    localObject = zzqq();
    if (((zzf)localObject).zzqg() != null) {
      localBundle.putBundle("com.google.android.gms.games.key.signInOptions", zzi.zza(((zzf)localObject).zzqg(), ((zzf)localObject).zzqh(), Executors.newSingleThreadExecutor()));
    }
    return localBundle;
  }
  
  public void zzm(zzlx.zzb<Invitations.LoadInvitationsResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzk(new InvitationsLoadedBinderCallback(paramzzb), paramString);
  }
  
  public boolean zzmn()
  {
    return true;
  }
  
  public void zzn(zzlx.zzb<Status> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzj(new NotifyAclUpdatedBinderCallback(paramzzb), paramString);
  }
  
  public Bundle zznQ()
  {
    try
    {
      Bundle localBundle = ((IGamesService)zzqs()).zznQ();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzo(View paramView)
  {
    this.zzaBz.zzp(paramView);
  }
  
  public void zzo(zzlx.zzb<Notifications.GameMuteStatusLoadResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzqs()).zzi(new GameMuteStatusLoadedBinderCallback(paramzzb), paramString);
  }
  
  public void zzp(String paramString, int paramInt)
  {
    this.zzaBv.zzp(paramString, paramInt);
  }
  
  public void zzq(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)zzqs()).zzq(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public void zzqm()
  {
    super.zzqm();
    if (this.zzaBA)
    {
      this.zzaBz.zzwA();
      this.zzaBA = false;
    }
    if (!this.zzaBD.zzaAb) {
      zzvQ();
    }
  }
  
  public void zzr(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)zzqs()).zzr(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public void zzvQ()
  {
    try
    {
      PopupLocationInfoBinderCallbacks localPopupLocationInfoBinderCallbacks = new PopupLocationInfoBinderCallbacks(this.zzaBz);
      ((IGamesService)zzqs()).zza(localPopupLocationInfoBinderCallbacks, this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public String zzvR()
  {
    try
    {
      String str = ((IGamesService)zzqs()).zzvR();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public String zzvS()
  {
    if (this.zzaBx != null) {
      return this.zzaBx.getPlayerId();
    }
    try
    {
      String str = ((IGamesService)zzqs()).zzvS();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  /* Error */
  public Player zzvT()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1385	com/google/android/gms/games/internal/GamesClientImpl:zzqr	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 503	com/google/android/gms/games/internal/GamesClientImpl:zzaBx	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1387	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 516	com/google/android/gms/games/internal/GamesClientImpl:zzqs	()Landroid/os/IInterface;
    //   23: checkcast 518	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1391 1 0
    //   31: invokespecial 1392	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1393	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1396	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1399 1 0
    //   53: checkcast 620	com/google/android/gms/games/PlayerEntity
    //   56: putfield 503	com/google/android/gms/games/internal/GamesClientImpl:zzaBx	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_1
    //   60: invokevirtual 1400	com/google/android/gms/games/PlayerBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 503	com/google/android/gms/games/internal/GamesClientImpl:zzaBx	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1400	com/google/android/gms/games/PlayerBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: aload_1
    //   80: invokespecial 491	com/google/android/gms/games/internal/GamesClientImpl:zzb	(Landroid/os/RemoteException;)V
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	3	1	localRemoteException	RemoteException
    //   86	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	86	finally
    //   15	35	86	finally
    //   59	63	86	finally
    //   63	65	86	finally
    //   71	77	86	finally
    //   78	83	86	finally
    //   87	89	86	finally
  }
  
  /* Error */
  public com.google.android.gms.games.Game zzvU()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1385	com/google/android/gms/games/internal/GamesClientImpl:zzqr	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 505	com/google/android/gms/games/internal/GamesClientImpl:zzaBy	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1404	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 516	com/google/android/gms/games/internal/GamesClientImpl:zzqs	()Landroid/os/IInterface;
    //   23: checkcast 518	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1407 1 0
    //   31: invokespecial 1408	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1409	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1412	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1415 1 0
    //   53: checkcast 624	com/google/android/gms/games/GameEntity
    //   56: putfield 505	com/google/android/gms/games/internal/GamesClientImpl:zzaBy	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 1416	com/google/android/gms/games/GameBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 505	com/google/android/gms/games/internal/GamesClientImpl:zzaBy	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1416	com/google/android/gms/games/GameBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: aload_1
    //   80: invokespecial 491	com/google/android/gms/games/internal/GamesClientImpl:zzb	(Landroid/os/RemoteException;)V
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	3	1	localRemoteException	RemoteException
    //   86	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	86	finally
    //   15	35	86	finally
    //   59	63	86	finally
    //   63	65	86	finally
    //   71	77	86	finally
    //   78	83	86	finally
    //   87	89	86	finally
  }
  
  public Intent zzvV()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzvV();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzvW()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzvW();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzvX()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzvX();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzvY()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzvY();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzvZ()
  {
    try
    {
      ((IGamesService)zzqs()).zzG(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzwa()
  {
    try
    {
      ((IGamesService)zzqs()).zzH(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzwb()
  {
    try
    {
      ((IGamesService)zzqs()).zzJ(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzwc()
  {
    try
    {
      ((IGamesService)zzqs()).zzI(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public Intent zzwd()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzwd();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzwe()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzwe();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzwf()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwf();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return 4368;
  }
  
  public String zzwg()
  {
    try
    {
      String str = ((IGamesService)zzqs()).zzwg();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzwh()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwh();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public Intent zzwi()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzqs()).zzwi();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzwj()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwj();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzwk()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwk();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzwl()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwl();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzwm()
  {
    try
    {
      int i = ((IGamesService)zzqs()).zzwm();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public void zzwn()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)zzqs()).zzwn();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  private static abstract class AbstractPeerStatusNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    private final ArrayList<String> zzaBF = new ArrayList();
    
    AbstractPeerStatusNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super();
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        this.zzaBF.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      zza(paramRoomStatusUpdateListener, paramRoom, this.zzaBF);
    }
    
    protected abstract void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  private static abstract class AbstractRoomNotifier
    extends zzmb<RoomUpdateListener>
  {
    AbstractRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void zza(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      zza(paramRoomUpdateListener, GamesClientImpl.zzZ(paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  private static abstract class AbstractRoomStatusNotifier
    extends zzmb<RoomStatusUpdateListener>
  {
    AbstractRoomStatusNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      zza(paramRoomStatusUpdateListener, GamesClientImpl.zzZ(paramDataHolder));
    }
    
    protected abstract void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  private static final class AcceptQuestResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.AcceptQuestResult
  {
    private final Quest zzaBG;
    
    /* Error */
    AcceptQuestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/quest/QuestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   18: ifle +27 -> 45
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/quest/QuestEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   31: checkcast 30	com/google/android/gms/games/quest/Quest
      //   34: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   37: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:zzaBG	Lcom/google/android/gms/games/quest/Quest;
      //   40: aload_1
      //   41: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:zzaBG	Lcom/google/android/gms/games/quest/Quest;
      //   50: goto -10 -> 40
      //   53: astore_2
      //   54: aload_1
      //   55: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   58: aload_2
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	AcceptQuestResultImpl
      //   0	60	1	paramDataHolder	DataHolder
      //   53	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	40	53	finally
      //   45	50	53	finally
    }
    
    public Quest getQuest()
    {
      return this.zzaBG;
    }
  }
  
  private static final class AchievementUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Achievements.UpdateAchievementResult> zzakL;
    
    AchievementUpdatedBinderCallback(zzlx.zzb<Achievements.UpdateAchievementResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzj(int paramInt, String paramString)
    {
      this.zzakL.zzr(new GamesClientImpl.UpdateAchievementResultImpl(paramInt, paramString));
    }
  }
  
  private static final class AchievementsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Achievements.LoadAchievementsResult> zzakL;
    
    AchievementsLoadedBinderCallback(zzlx.zzb<Achievements.LoadAchievementsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzh(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadAchievementsResultImpl(paramDataHolder));
    }
  }
  
  private static final class AppContentLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<AppContents.LoadAppContentResult> zzaBH;
    
    public AppContentLoadedBinderCallbacks(zzlx.zzb<AppContents.LoadAppContentResult> paramzzb)
    {
      this.zzaBH = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder[] paramArrayOfDataHolder)
    {
      this.zzaBH.zzr(new GamesClientImpl.LoadAppContentsResultImpl(paramArrayOfDataHolder));
    }
  }
  
  private static final class CancelMatchResultImpl
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final Status zzTA;
    private final String zzaBI;
    
    CancelMatchResultImpl(Status paramStatus, String paramString)
    {
      this.zzTA = paramStatus;
      this.zzaBI = paramString;
    }
    
    public String getMatchId()
    {
      return this.zzaBI;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class ClaimMilestoneResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.ClaimMilestoneResult
  {
    private final Quest zzaBG;
    private final Milestone zzaBJ;
    
    /* Error */
    ClaimMilestoneResultImpl(DataHolder paramDataHolder, String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial 18	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   7: new 20	com/google/android/gms/games/quest/QuestBuffer
      //   10: dup
      //   11: aload_1
      //   12: invokespecial 21	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   15: astore_1
      //   16: aload_1
      //   17: invokevirtual 25	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   20: ifle +108 -> 128
      //   23: aload_0
      //   24: new 27	com/google/android/gms/games/quest/QuestEntity
      //   27: dup
      //   28: aload_1
      //   29: iconst_0
      //   30: invokevirtual 31	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   33: checkcast 33	com/google/android/gms/games/quest/Quest
      //   36: invokespecial 36	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBG	Lcom/google/android/gms/games/quest/Quest;
      //   42: aload_0
      //   43: getfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBG	Lcom/google/android/gms/games/quest/Quest;
      //   46: invokeinterface 42 1 0
      //   51: astore 5
      //   53: aload 5
      //   55: invokeinterface 47 1 0
      //   60: istore 4
      //   62: iload_3
      //   63: iload 4
      //   65: if_icmpge +53 -> 118
      //   68: aload 5
      //   70: iload_3
      //   71: invokeinterface 48 2 0
      //   76: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   79: invokeinterface 54 1 0
      //   84: aload_2
      //   85: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   88: ifeq +23 -> 111
      //   91: aload_0
      //   92: aload 5
      //   94: iload_3
      //   95: invokeinterface 48 2 0
      //   100: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   103: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBJ	Lcom/google/android/gms/games/quest/Milestone;
      //   106: aload_1
      //   107: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   110: return
      //   111: iload_3
      //   112: iconst_1
      //   113: iadd
      //   114: istore_3
      //   115: goto -53 -> 62
      //   118: aload_0
      //   119: aconst_null
      //   120: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBJ	Lcom/google/android/gms/games/quest/Milestone;
      //   123: aload_1
      //   124: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   127: return
      //   128: aload_0
      //   129: aconst_null
      //   130: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBJ	Lcom/google/android/gms/games/quest/Milestone;
      //   133: aload_0
      //   134: aconst_null
      //   135: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzaBG	Lcom/google/android/gms/games/quest/Quest;
      //   138: goto -15 -> 123
      //   141: astore_2
      //   142: aload_1
      //   143: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   146: aload_2
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	ClaimMilestoneResultImpl
      //   0	148	1	paramDataHolder	DataHolder
      //   0	148	2	paramString	String
      //   1	114	3	i	int
      //   60	6	4	j	int
      //   51	42	5	localList	List
      // Exception table:
      //   from	to	target	type
      //   16	62	141	finally
      //   68	106	141	finally
      //   118	123	141	finally
      //   128	138	141	finally
    }
    
    public Milestone getMilestone()
    {
      return this.zzaBJ;
    }
    
    public Quest getQuest()
    {
      return this.zzaBG;
    }
  }
  
  private static final class CommitSnapshotResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.CommitSnapshotResult
  {
    private final SnapshotMetadata zzaBK;
    
    /* Error */
    CommitSnapshotResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   31: invokespecial 31	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:zzaBK	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   37: aload_1
      //   38: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:zzaBK	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   47: goto -10 -> 37
      //   50: astore_2
      //   51: aload_1
      //   52: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	CommitSnapshotResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   50	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public SnapshotMetadata getSnapshotMetadata()
    {
      return this.zzaBK;
    }
  }
  
  private static final class ConnectedToRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    ConnectedToRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  private static final class ContactSettingLoadResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Notifications.ContactSettingLoadResult
  {
    ContactSettingLoadResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class ContactSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Notifications.ContactSettingLoadResult> zzakL;
    
    ContactSettingsLoadedBinderCallback(zzlx.zzb<Notifications.ContactSettingLoadResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzI(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.ContactSettingLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class ContactSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Status> zzakL;
    
    ContactSettingsUpdatedBinderCallback(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzgg(int paramInt)
    {
      this.zzakL.zzr(GamesStatusCodes.zzfU(paramInt));
    }
  }
  
  private static final class DeleteSnapshotResultImpl
    implements Snapshots.DeleteSnapshotResult
  {
    private final Status zzTA;
    private final String zzaBL;
    
    DeleteSnapshotResultImpl(int paramInt, String paramString)
    {
      this.zzTA = GamesStatusCodes.zzfU(paramInt);
      this.zzaBL = paramString;
    }
    
    public String getSnapshotId()
    {
      return this.zzaBL;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class DisconnectedFromRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    DisconnectedFromRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  private static final class EventsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Events.LoadEventsResult> zzakL;
    
    EventsLoadedBinderCallback(zzlx.zzb<Events.LoadEventsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzi(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadEventResultImpl(paramDataHolder));
    }
  }
  
  private class GameClientEventIncrementCache
    extends EventIncrementCache
  {
    public GameClientEventIncrementCache()
    {
      super(1000);
    }
    
    protected void zzs(String paramString, int paramInt)
    {
      try
      {
        if (GamesClientImpl.this.isConnected())
        {
          ((IGamesService)GamesClientImpl.this.zzqs()).zzp(paramString, paramInt);
          return;
        }
        GamesLog.zzB("GamesClientImpl", "Unable to increment event " + paramString + " by " + paramInt + " because the games client is no longer connected");
        return;
      }
      catch (RemoteException paramString)
      {
        GamesClientImpl.zza(GamesClientImpl.this, paramString);
      }
    }
  }
  
  private static final class GameInstancesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<GamesMetadata.LoadGameInstancesResult> zzakL;
    
    GameInstancesLoadedBinderCallback(zzlx.zzb<GamesMetadata.LoadGameInstancesResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzp(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadGameInstancesResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameMuteStatusChangeResultImpl
    implements Notifications.GameMuteStatusChangeResult
  {
    private final Status zzTA;
    private final String zzaBM;
    private final boolean zzaBN;
    
    public GameMuteStatusChangeResultImpl(int paramInt, String paramString, boolean paramBoolean)
    {
      this.zzTA = GamesStatusCodes.zzfU(paramInt);
      this.zzaBM = paramString;
      this.zzaBN = paramBoolean;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class GameMuteStatusChangedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Notifications.GameMuteStatusChangeResult> zzakL;
    
    GameMuteStatusChangedBinderCallback(zzlx.zzb<Notifications.GameMuteStatusChangeResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(int paramInt, String paramString, boolean paramBoolean)
    {
      this.zzakL.zzr(new GamesClientImpl.GameMuteStatusChangeResultImpl(paramInt, paramString, paramBoolean));
    }
  }
  
  private static final class GameMuteStatusLoadResultImpl
    implements Notifications.GameMuteStatusLoadResult
  {
    private final Status zzTA;
    private final String zzaBM;
    private final boolean zzaBN;
    
    /* Error */
    public GameMuteStatusLoadResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 20	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: aload_1
      //   6: invokevirtual 26	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   9: invokestatic 32	com/google/android/gms/games/GamesStatusCodes:zzfU	(I)Lcom/google/android/gms/common/api/Status;
      //   12: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzTA	Lcom/google/android/gms/common/api/Status;
      //   15: aload_1
      //   16: invokevirtual 37	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   19: ifle +32 -> 51
      //   22: aload_0
      //   23: aload_1
      //   24: ldc 39
      //   26: iconst_0
      //   27: iconst_0
      //   28: invokevirtual 43	com/google/android/gms/common/data/DataHolder:zzd	(Ljava/lang/String;II)Ljava/lang/String;
      //   31: putfield 45	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzaBM	Ljava/lang/String;
      //   34: aload_0
      //   35: aload_1
      //   36: ldc 47
      //   38: iconst_0
      //   39: iconst_0
      //   40: invokevirtual 51	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   43: putfield 53	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzaBN	Z
      //   46: aload_1
      //   47: invokevirtual 56	com/google/android/gms/common/data/DataHolder:close	()V
      //   50: return
      //   51: aload_0
      //   52: aconst_null
      //   53: putfield 45	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzaBM	Ljava/lang/String;
      //   56: aload_0
      //   57: iconst_0
      //   58: putfield 53	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzaBN	Z
      //   61: goto -15 -> 46
      //   64: astore_2
      //   65: aload_1
      //   66: invokevirtual 56	com/google/android/gms/common/data/DataHolder:close	()V
      //   69: aload_2
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	GameMuteStatusLoadResultImpl
      //   0	71	1	paramDataHolder	DataHolder
      //   64	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	46	64	finally
      //   51	61	64	finally
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class GameMuteStatusLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Notifications.GameMuteStatusLoadResult> zzakL;
    
    GameMuteStatusLoadedBinderCallback(zzlx.zzb<Notifications.GameMuteStatusLoadResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzG(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.GameMuteStatusLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameSearchSuggestionsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzakL;
    
    GameSearchSuggestionsLoadedBinderCallback(zzlx.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzq(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class GamesDataHolderResult
    extends zzmc
  {
    protected GamesDataHolderResult(DataHolder paramDataHolder)
    {
      super(GamesStatusCodes.zzfU(paramDataHolder.getStatusCode()));
    }
  }
  
  private static final class GamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<GamesMetadata.LoadGamesResult> zzakL;
    
    GamesLoadedBinderCallback(zzlx.zzb<GamesMetadata.LoadGamesResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzn(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadGamesResultImpl(paramDataHolder));
    }
  }
  
  private static final class GetAuthTokenBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Games.GetTokenResult> zzakL;
    
    public GetAuthTokenBinderCallbacks(zzlx.zzb<Games.GetTokenResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzi(int paramInt, String paramString)
    {
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzakL.zzr(new GamesClientImpl.GetTokenResultImpl(localStatus, paramString));
    }
  }
  
  private static final class GetTokenResultImpl
    implements Games.GetTokenResult
  {
    private final Status zzTA;
    private final String zzTR;
    
    GetTokenResultImpl(Status paramStatus, String paramString)
    {
      this.zzTA = paramStatus;
      this.zzTR = paramString;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class InboxCountResultImpl
    implements Notifications.InboxCountResult
  {
    private final Status zzTA;
    private final Bundle zzaBO;
    
    InboxCountResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzTA = paramStatus;
      this.zzaBO = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class InboxCountsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Notifications.InboxCountResult> zzakL;
    
    InboxCountsLoadedBinderCallback(zzlx.zzb<Notifications.InboxCountResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzg(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzakL.zzr(new GamesClientImpl.InboxCountResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class InitiateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    InitiateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class InvitationReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzmn<OnInvitationReceivedListener> zzape;
    
    InvitationReceivedBinderCallback(zzmn<OnInvitationReceivedListener> paramzzmn)
    {
      this.zzape = paramzzmn;
    }
    
    public void onInvitationRemoved(String paramString)
    {
      this.zzape.zza(new GamesClientImpl.InvitationRemovedNotifier(paramString));
    }
    
    public void zzs(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localInvitationBuffer.getCount() > 0) {
          paramDataHolder = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.release();
        if (paramDataHolder != null) {
          this.zzape.zza(new GamesClientImpl.InvitationReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.release();
      }
    }
  }
  
  private static final class InvitationReceivedNotifier
    implements zzmn.zzb<OnInvitationReceivedListener>
  {
    private final Invitation zzaBP;
    
    InvitationReceivedNotifier(Invitation paramInvitation)
    {
      this.zzaBP = paramInvitation;
    }
    
    public void zza(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.zzaBP);
    }
    
    public void zzpb() {}
  }
  
  private static final class InvitationRemovedNotifier
    implements zzmn.zzb<OnInvitationReceivedListener>
  {
    private final String zzTr;
    
    InvitationRemovedNotifier(String paramString)
    {
      this.zzTr = paramString;
    }
    
    public void zza(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.zzTr);
    }
    
    public void zzpb() {}
  }
  
  private static final class InvitationsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Invitations.LoadInvitationsResult> zzakL;
    
    InvitationsLoadedBinderCallback(zzlx.zzb<Invitations.LoadInvitationsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzr(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadInvitationsResultImpl(paramDataHolder));
    }
  }
  
  private static final class JoinedRoomNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public JoinedRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  private static final class LeaderboardMetadataResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer zzaBQ;
    
    LeaderboardMetadataResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBQ = new LeaderboardBuffer(paramDataHolder);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.zzaBQ;
    }
  }
  
  private static final class LeaderboardScoresLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Leaderboards.LoadScoresResult> zzakL;
    
    LeaderboardScoresLoadedBinderCallback(zzlx.zzb<Leaderboards.LoadScoresResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadScoresResultImpl(paramDataHolder1, paramDataHolder2));
    }
  }
  
  private static final class LeaderboardsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Leaderboards.LeaderboardMetadataResult> zzakL;
    
    LeaderboardsLoadedBinderCallback(zzlx.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzj(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LeaderboardMetadataResultImpl(paramDataHolder));
    }
  }
  
  private static final class LeaveMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    LeaveMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LeftRoomNotifier
    implements zzmn.zzb<RoomUpdateListener>
  {
    private final String zzaBR;
    private final int zzabx;
    
    LeftRoomNotifier(int paramInt, String paramString)
    {
      this.zzabx = paramInt;
      this.zzaBR = paramString;
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.zzabx, this.zzaBR);
    }
    
    public void zzpb() {}
  }
  
  private static final class ListVideosBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Videos.ListVideosResult> zzakL;
    
    ListVideosBinderCallback(zzlx.zzb<Videos.ListVideosResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzX(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.ListVideosResultImpl(paramDataHolder));
    }
  }
  
  public static final class ListVideosResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Videos.ListVideosResult
  {
    private final VideoBuffer zzaBS;
    
    public ListVideosResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBS = new VideoBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadAchievementsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer zzaBT;
    
    LoadAchievementsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBT = new AchievementBuffer(paramDataHolder);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.zzaBT;
    }
  }
  
  private static final class LoadAclResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Acls.LoadAclResult
  {
    LoadAclResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadAppContentsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements AppContents.LoadAppContentResult
  {
    private final ArrayList<DataHolder> zzaBU;
    
    LoadAppContentsResultImpl(DataHolder[] paramArrayOfDataHolder)
    {
      super();
      this.zzaBU = new ArrayList(Arrays.asList(paramArrayOfDataHolder));
    }
  }
  
  private static final class LoadEventResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Events.LoadEventsResult
  {
    private final EventBuffer zzaBV;
    
    LoadEventResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBV = new EventBuffer(paramDataHolder);
    }
    
    public EventBuffer getEvents()
    {
      return this.zzaBV;
    }
  }
  
  private static final class LoadGameInstancesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGameInstancesResult
  {
    private final GameInstanceBuffer zzaBW;
    
    LoadGameInstancesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBW = new GameInstanceBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameSearchSuggestionsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGameSearchSuggestionsResult
  {
    private final GameSearchSuggestionBuffer zzaBX;
    
    LoadGameSearchSuggestionsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBX = new GameSearchSuggestionBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGamesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer zzaBY;
    
    LoadGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBY = new GameBuffer(paramDataHolder);
    }
    
    public GameBuffer getGames()
    {
      return this.zzaBY;
    }
  }
  
  private static final class LoadInvitationsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer zzaBZ;
    
    LoadInvitationsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaBZ = new InvitationBuffer(paramDataHolder);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.zzaBZ;
    }
  }
  
  private static final class LoadMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    LoadMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadMatchesResultImpl
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final Status zzTA;
    private final LoadMatchesResponse zzaCa;
    
    LoadMatchesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzTA = paramStatus;
      this.zzaCa = new LoadMatchesResponse(paramBundle);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.zzaCa;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      this.zzaCa.release();
    }
  }
  
  private static final class LoadPlayerScoreResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final LeaderboardScoreEntity zzaCb;
    
    /* Error */
    LoadPlayerScoreResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   18: ifle +25 -> 43
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   27: invokeinterface 32 1 0
      //   32: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
      //   35: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:zzaCb	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   38: aload_1
      //   39: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:zzaCb	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   48: goto -10 -> 38
      //   51: astore_2
      //   52: aload_1
      //   53: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   56: aload_2
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	LoadPlayerScoreResultImpl
      //   0	58	1	paramDataHolder	DataHolder
      //   51	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	38	51	finally
      //   43	48	51	finally
    }
    
    public LeaderboardScore getScore()
    {
      return this.zzaCb;
    }
  }
  
  private static final class LoadPlayerStatsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Stats.LoadPlayerStatsResult
  {
    private final PlayerStats zzaCc;
    
    /* Error */
    LoadPlayerStatsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/stats/PlayerStatsBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/stats/PlayerStatsBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/stats/PlayerStatsBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/stats/PlayerStatsEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/stats/PlayerStatsBuffer:zzgN	(I)Lcom/google/android/gms/games/stats/PlayerStats;
      //   31: invokespecial 31	com/google/android/gms/games/stats/PlayerStatsEntity:<init>	(Lcom/google/android/gms/games/stats/PlayerStats;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerStatsResultImpl:zzaCc	Lcom/google/android/gms/games/stats/PlayerStats;
      //   37: aload_1
      //   38: invokevirtual 37	com/google/android/gms/games/stats/PlayerStatsBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerStatsResultImpl:zzaCc	Lcom/google/android/gms/games/stats/PlayerStats;
      //   47: goto -10 -> 37
      //   50: astore_2
      //   51: aload_1
      //   52: invokevirtual 37	com/google/android/gms/games/stats/PlayerStatsBuffer:release	()V
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	LoadPlayerStatsResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   50	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public PlayerStats getPlayerStats()
    {
      return this.zzaCc;
    }
  }
  
  private static final class LoadPlayersResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer zzaCd;
    
    LoadPlayersResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaCd = new PlayerBuffer(paramDataHolder);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.zzaCd;
    }
  }
  
  private static final class LoadProfileSettingsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadProfileSettingsResult
  {
    private final boolean zzaBs;
    private final boolean zzaCe;
    
    /* Error */
    LoadProfileSettingsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 16	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: aload_1
      //   6: invokevirtual 22	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   9: ifle +38 -> 47
      //   12: aload_1
      //   13: iconst_0
      //   14: invokevirtual 26	com/google/android/gms/common/data/DataHolder:zzbI	(I)I
      //   17: istore_2
      //   18: aload_0
      //   19: aload_1
      //   20: ldc 28
      //   22: iconst_0
      //   23: iload_2
      //   24: invokevirtual 32	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   27: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzaBs	Z
      //   30: aload_0
      //   31: aload_1
      //   32: ldc 36
      //   34: iconst_0
      //   35: iload_2
      //   36: invokevirtual 32	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzaCe	Z
      //   42: aload_1
      //   43: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   46: return
      //   47: aload_0
      //   48: iconst_1
      //   49: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzaBs	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzaCe	Z
      //   57: goto -15 -> 42
      //   60: astore_3
      //   61: aload_1
      //   62: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   65: aload_3
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	LoadProfileSettingsResultImpl
      //   0	67	1	paramDataHolder	DataHolder
      //   17	19	2	i	int
      //   60	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	42	60	finally
      //   47	57	60	finally
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class LoadQuestsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.LoadQuestsResult
  {
    private final DataHolder zzafC;
    
    LoadQuestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzafC = paramDataHolder;
    }
    
    public QuestBuffer getQuests()
    {
      return new QuestBuffer(this.zzafC);
    }
  }
  
  private static final class LoadRequestSummariesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.LoadRequestSummariesResult
  {
    LoadRequestSummariesResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadRequestsResultImpl
    implements Requests.LoadRequestsResult
  {
    private final Status zzTA;
    private final Bundle zzaCf;
    
    LoadRequestsResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzTA = paramStatus;
      this.zzaCf = paramBundle;
    }
    
    public GameRequestBuffer getRequests(int paramInt)
    {
      String str = RequestType.zzgo(paramInt);
      if (!this.zzaCf.containsKey(str)) {
        return null;
      }
      return new GameRequestBuffer((DataHolder)this.zzaCf.get(str));
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      Iterator localIterator = this.zzaCf.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (DataHolder)this.zzaCf.getParcelable((String)localObject);
        if (localObject != null) {
          ((DataHolder)localObject).close();
        }
      }
    }
  }
  
  private static final class LoadScoresResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LoadScoresResult
  {
    private final LeaderboardEntity zzaCg;
    private final LeaderboardScoreBuffer zzaCh;
    
    /* Error */
    LoadScoresResultImpl(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: invokespecial 18	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 20	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 21	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 25	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   18: ifle +40 -> 58
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 29	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 31	com/google/android/gms/games/leaderboard/Leaderboard
      //   30: invokeinterface 35 1 0
      //   35: checkcast 37	com/google/android/gms/games/leaderboard/LeaderboardEntity
      //   38: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzaCg	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   41: aload_1
      //   42: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   45: aload_0
      //   46: new 45	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   49: dup
      //   50: aload_2
      //   51: invokespecial 46	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   54: putfield 48	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzaCh	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   57: return
      //   58: aload_0
      //   59: aconst_null
      //   60: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzaCg	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   63: goto -22 -> 41
      //   66: astore_2
      //   67: aload_1
      //   68: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   71: aload_2
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	LoadScoresResultImpl
      //   0	73	1	paramDataHolder1	DataHolder
      //   0	73	2	paramDataHolder2	DataHolder
      // Exception table:
      //   from	to	target	type
      //   14	41	66	finally
      //   58	63	66	finally
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.zzaCg;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.zzaCh;
    }
  }
  
  private static final class LoadSnapshotsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.LoadSnapshotsResult
  {
    LoadSnapshotsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
    
    public SnapshotMetadataBuffer getSnapshots()
    {
      return new SnapshotMetadataBuffer(this.zzafC);
    }
  }
  
  private static final class LoadXpForGameCategoriesResultImpl
    implements Players.LoadXpForGameCategoriesResult
  {
    private final Status zzTA;
    private final List<String> zzaCi;
    private final Bundle zzaCj;
    
    LoadXpForGameCategoriesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzTA = paramStatus;
      this.zzaCi = paramBundle.getStringArrayList("game_category_list");
      this.zzaCj = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class LoadXpStreamResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadXpStreamResult
  {
    private final ExperienceEventBuffer zzaCk;
    
    LoadXpStreamResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaCk = new ExperienceEventBuffer(paramDataHolder);
    }
  }
  
  private static final class MatchRemovedNotifier
    implements zzmn.zzb<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String zzaCl;
    
    MatchRemovedNotifier(String paramString)
    {
      this.zzaCl = paramString;
    }
    
    public void zza(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaCl);
    }
    
    public void zzpb() {}
  }
  
  private static final class MatchUpdateReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzmn<OnTurnBasedMatchUpdateReceivedListener> zzape;
    
    MatchUpdateReceivedBinderCallback(zzmn<OnTurnBasedMatchUpdateReceivedListener> paramzzmn)
    {
      this.zzape = paramzzmn;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      this.zzape.zza(new GamesClientImpl.MatchRemovedNotifier(paramString));
    }
    
    public void zzy(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localTurnBasedMatchBuffer.getCount() > 0) {
          paramDataHolder = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.release();
        if (paramDataHolder != null) {
          this.zzape.zza(new GamesClientImpl.MatchUpdateReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.release();
      }
    }
  }
  
  private static final class MatchUpdateReceivedNotifier
    implements zzmn.zzb<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch zzaCm;
    
    MatchUpdateReceivedNotifier(TurnBasedMatch paramTurnBasedMatch)
    {
      this.zzaCm = paramTurnBasedMatch;
    }
    
    public void zza(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaCm);
    }
    
    public void zzpb() {}
  }
  
  private static final class MessageReceivedNotifier
    implements zzmn.zzb<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage zzaCn;
    
    MessageReceivedNotifier(RealTimeMessage paramRealTimeMessage)
    {
      this.zzaCn = paramRealTimeMessage;
    }
    
    public void zza(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaCn);
    }
    
    public void zzpb() {}
  }
  
  private static final class NearbyPlayerDetectedNotifier
    implements zzmn.zzb<OnNearbyPlayerDetectedListener>
  {
    private final Player zzaCo;
    
    public void zza(OnNearbyPlayerDetectedListener paramOnNearbyPlayerDetectedListener)
    {
      paramOnNearbyPlayerDetectedListener.zza(this.zzaCo);
    }
    
    public void zzpb() {}
  }
  
  private static final class NotifyAclLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Acls.LoadAclResult> zzakL;
    
    NotifyAclLoadedBinderCallback(zzlx.zzb<Acls.LoadAclResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzH(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadAclResultImpl(paramDataHolder));
    }
  }
  
  private static final class NotifyAclUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Status> zzakL;
    
    NotifyAclUpdatedBinderCallback(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzgf(int paramInt)
    {
      this.zzakL.zzr(GamesStatusCodes.zzfU(paramInt));
    }
  }
  
  private static final class OpenSnapshotResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.OpenSnapshotResult
  {
    private final Snapshot zzaCp;
    private final String zzaCq;
    private final Snapshot zzaCr;
    private final Contents zzaCs;
    private final SnapshotContents zzaCt;
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, Contents paramContents)
    {
      this(paramDataHolder, null, paramContents, null, null);
    }
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      super();
      SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
      for (;;)
      {
        try
        {
          if (localSnapshotMetadataBuffer.getCount() == 0)
          {
            this.zzaCp = null;
            this.zzaCr = null;
            localSnapshotMetadataBuffer.release();
            this.zzaCq = paramString;
            this.zzaCs = paramContents3;
            this.zzaCt = new SnapshotContentsEntity(paramContents3);
            return;
          }
          if (localSnapshotMetadataBuffer.getCount() != 1) {
            break label144;
          }
          if (paramDataHolder.getStatusCode() != 4004)
          {
            zzb.zzaa(bool);
            this.zzaCp = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
            this.zzaCr = null;
            continue;
          }
          bool = false;
        }
        finally
        {
          localSnapshotMetadataBuffer.release();
        }
        continue;
        label144:
        this.zzaCp = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
        this.zzaCr = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(paramContents2));
      }
    }
    
    public String getConflictId()
    {
      return this.zzaCq;
    }
    
    public Snapshot getConflictingSnapshot()
    {
      return this.zzaCr;
    }
    
    public SnapshotContents getResolutionSnapshotContents()
    {
      return this.zzaCt;
    }
    
    public Snapshot getSnapshot()
    {
      return this.zzaCp;
    }
  }
  
  private static final class P2PConnectedNotifier
    implements zzmn.zzb<RoomStatusUpdateListener>
  {
    private final String zzaCu;
    
    P2PConnectedNotifier(String paramString)
    {
      this.zzaCu = paramString;
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PConnected(this.zzaCu);
    }
    
    public void zzpb() {}
  }
  
  private static final class P2PDisconnectedNotifier
    implements zzmn.zzb<RoomStatusUpdateListener>
  {
    private final String zzaCu;
    
    P2PDisconnectedNotifier(String paramString)
    {
      this.zzaCu = paramString;
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PDisconnected(this.zzaCu);
    }
    
    public void zzpb() {}
  }
  
  private static final class PeerConnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerConnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDeclinedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDeclinedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDisconnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDisconnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerInvitedToRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerInvitedToRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerJoinedRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerJoinedRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerLeftRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerLeftRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  private static final class PlayerLeaderboardScoreLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Leaderboards.LoadPlayerScoreResult> zzakL;
    
    PlayerLeaderboardScoreLoadedBinderCallback(zzlx.zzb<Leaderboards.LoadPlayerScoreResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzJ(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadPlayerScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayerStatsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Stats.LoadPlayerStatsResult> zzakL;
    
    public PlayerStatsLoadedBinderCallbacks(zzlx.zzb<Stats.LoadPlayerStatsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzW(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadPlayerStatsResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayerXpForGameCategoriesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Players.LoadXpForGameCategoriesResult> zzakL;
    
    PlayerXpForGameCategoriesLoadedBinderCallback(zzlx.zzb<Players.LoadXpForGameCategoriesResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzf(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzakL.zzr(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(localStatus, paramBundle));
    }
  }
  
  static final class PlayerXpStreamLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Players.LoadXpStreamResult> zzakL;
    
    PlayerXpStreamLoadedBinderCallback(zzlx.zzb<Players.LoadXpStreamResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzU(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadXpStreamResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayersLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Players.LoadPlayersResult> zzakL;
    
    PlayersLoadedBinderCallback(zzlx.zzb<Players.LoadPlayersResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzl(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
    
    public void zzm(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
  }
  
  private static final class PopupLocationInfoBinderCallbacks
    extends AbstractGamesClient
  {
    private final PopupManager zzaBz;
    
    public PopupLocationInfoBinderCallbacks(PopupManager paramPopupManager)
    {
      this.zzaBz = paramPopupManager;
    }
    
    public PopupLocationInfoParcelable zzvM()
    {
      return new PopupLocationInfoParcelable(this.zzaBz.zzwD());
    }
  }
  
  static final class ProfileSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Players.LoadProfileSettingsResult> zzakL;
    
    ProfileSettingsLoadedBinderCallback(zzlx.zzb<Players.LoadProfileSettingsResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzV(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.LoadProfileSettingsResultImpl(paramDataHolder));
    }
  }
  
  private static final class ProfileSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Status> zzakL;
    
    ProfileSettingsUpdatedBinderCallback(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzgh(int paramInt)
    {
      this.zzakL.zzr(GamesStatusCodes.zzfU(paramInt));
    }
  }
  
  private static final class QuestAcceptedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Quests.AcceptQuestResult> zzaCv;
    
    public QuestAcceptedBinderCallbacks(zzlx.zzb<Quests.AcceptQuestResult> paramzzb)
    {
      this.zzaCv = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzQ(DataHolder paramDataHolder)
    {
      this.zzaCv.zzr(new GamesClientImpl.AcceptQuestResultImpl(paramDataHolder));
    }
  }
  
  private static final class QuestCompletedNotifier
    implements zzmn.zzb<QuestUpdateListener>
  {
    private final Quest zzaBG;
    
    QuestCompletedNotifier(Quest paramQuest)
    {
      this.zzaBG = paramQuest;
    }
    
    public void zza(QuestUpdateListener paramQuestUpdateListener)
    {
      paramQuestUpdateListener.onQuestCompleted(this.zzaBG);
    }
    
    public void zzpb() {}
  }
  
  private static final class QuestMilestoneClaimBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Quests.ClaimMilestoneResult> zzaCw;
    private final String zzaCx;
    
    public QuestMilestoneClaimBinderCallbacks(zzlx.zzb<Quests.ClaimMilestoneResult> paramzzb, String paramString)
    {
      this.zzaCw = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
      this.zzaCx = ((String)zzx.zzb(paramString, "MilestoneId must not be null"));
    }
    
    public void zzP(DataHolder paramDataHolder)
    {
      this.zzaCw.zzr(new GamesClientImpl.ClaimMilestoneResultImpl(paramDataHolder, this.zzaCx));
    }
  }
  
  private static final class QuestUpdateBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzmn<QuestUpdateListener> zzape;
    
    QuestUpdateBinderCallback(zzmn<QuestUpdateListener> paramzzmn)
    {
      this.zzape = paramzzmn;
    }
    
    private Quest zzaa(DataHolder paramDataHolder)
    {
      QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localQuestBuffer.getCount() > 0) {
          paramDataHolder = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
        }
        return paramDataHolder;
      }
      finally
      {
        localQuestBuffer.release();
      }
    }
    
    public void zzR(DataHolder paramDataHolder)
    {
      paramDataHolder = zzaa(paramDataHolder);
      if (paramDataHolder != null) {
        this.zzape.zza(new GamesClientImpl.QuestCompletedNotifier(paramDataHolder));
      }
    }
  }
  
  private static final class QuestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Quests.LoadQuestsResult> zzaCy;
    
    public QuestsLoadedBinderCallbacks(zzlx.zzb<Quests.LoadQuestsResult> paramzzb)
    {
      this.zzaCy = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzT(DataHolder paramDataHolder)
    {
      this.zzaCy.zzr(new GamesClientImpl.LoadQuestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RealTimeMessageSentNotifier
    implements zzmn.zzb<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int zzaCA;
    private final String zzaCz;
    private final int zzabx;
    
    RealTimeMessageSentNotifier(int paramInt1, int paramInt2, String paramString)
    {
      this.zzabx = paramInt1;
      this.zzaCA = paramInt2;
      this.zzaCz = paramString;
    }
    
    public void zza(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.zzabx, this.zzaCA, this.zzaCz);
      }
    }
    
    public void zzpb() {}
  }
  
  private static final class RealTimeReliableMessageBinderCallbacks
    extends AbstractGamesCallbacks
  {
    final zzmn<RealTimeMultiplayer.ReliableMessageSentCallback> zzaCB;
    
    public RealTimeReliableMessageBinderCallbacks(zzmn<RealTimeMultiplayer.ReliableMessageSentCallback> paramzzmn)
    {
      this.zzaCB = paramzzmn;
    }
    
    public void zzb(int paramInt1, int paramInt2, String paramString)
    {
      if (this.zzaCB != null) {
        this.zzaCB.zza(new GamesClientImpl.RealTimeMessageSentNotifier(paramInt1, paramInt2, paramString));
      }
    }
  }
  
  private static final class RequestReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzmn<OnRequestReceivedListener> zzape;
    
    RequestReceivedBinderCallback(zzmn<OnRequestReceivedListener> paramzzmn)
    {
      this.zzape = paramzzmn;
    }
    
    public void onRequestRemoved(String paramString)
    {
      this.zzape.zza(new GamesClientImpl.RequestRemovedNotifier(paramString));
    }
    
    public void zzt(DataHolder paramDataHolder)
    {
      GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localGameRequestBuffer.getCount() > 0) {
          paramDataHolder = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
        }
        localGameRequestBuffer.release();
        if (paramDataHolder != null) {
          this.zzape.zza(new GamesClientImpl.RequestReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localGameRequestBuffer.release();
      }
    }
  }
  
  private static final class RequestReceivedNotifier
    implements zzmn.zzb<OnRequestReceivedListener>
  {
    private final GameRequest zzaCC;
    
    RequestReceivedNotifier(GameRequest paramGameRequest)
    {
      this.zzaCC = paramGameRequest;
    }
    
    public void zza(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestReceived(this.zzaCC);
    }
    
    public void zzpb() {}
  }
  
  private static final class RequestRemovedNotifier
    implements zzmn.zzb<OnRequestReceivedListener>
  {
    private final String zzDX;
    
    RequestRemovedNotifier(String paramString)
    {
      this.zzDX = paramString;
    }
    
    public void zza(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestRemoved(this.zzDX);
    }
    
    public void zzpb() {}
  }
  
  private static final class RequestSentBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Requests.SendRequestResult> zzaCD;
    
    public RequestSentBinderCallbacks(zzlx.zzb<Requests.SendRequestResult> paramzzb)
    {
      this.zzaCD = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzL(DataHolder paramDataHolder)
    {
      this.zzaCD.zzr(new GamesClientImpl.SendRequestResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestSummariesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Requests.LoadRequestSummariesResult> zzaCE;
    
    public RequestSummariesLoadedBinderCallbacks(zzlx.zzb<Requests.LoadRequestSummariesResult> paramzzb)
    {
      this.zzaCE = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzM(DataHolder paramDataHolder)
    {
      this.zzaCE.zzr(new GamesClientImpl.LoadRequestSummariesResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Requests.LoadRequestsResult> zzaCF;
    
    public RequestsLoadedBinderCallbacks(zzlx.zzb<Requests.LoadRequestsResult> paramzzb)
    {
      this.zzaCF = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzd(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzaCF.zzr(new GamesClientImpl.LoadRequestsResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class RequestsUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Requests.UpdateRequestsResult> zzaCG;
    
    public RequestsUpdatedBinderCallbacks(zzlx.zzb<Requests.UpdateRequestsResult> paramzzb)
    {
      this.zzaCG = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzK(DataHolder paramDataHolder)
    {
      this.zzaCG.zzr(new GamesClientImpl.UpdateRequestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RoomAutoMatchingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomAutoMatchingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  private static final class RoomBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzmn<? extends RoomUpdateListener> zzaCH;
    private final zzmn<? extends RoomStatusUpdateListener> zzaCI;
    private final zzmn<RealTimeMessageReceivedListener> zzaCJ;
    
    public RoomBinderCallbacks(zzmn<RoomUpdateListener> paramzzmn)
    {
      this.zzaCH = ((zzmn)zzx.zzb(paramzzmn, "Callbacks must not be null"));
      this.zzaCI = null;
      this.zzaCJ = null;
    }
    
    public RoomBinderCallbacks(zzmn<? extends RoomUpdateListener> paramzzmn, zzmn<? extends RoomStatusUpdateListener> paramzzmn1, zzmn<RealTimeMessageReceivedListener> paramzzmn2)
    {
      this.zzaCH = ((zzmn)zzx.zzb(paramzzmn, "Callbacks must not be null"));
      this.zzaCI = paramzzmn1;
      this.zzaCJ = paramzzmn2;
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      this.zzaCH.zza(new GamesClientImpl.LeftRoomNotifier(paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.P2PConnectedNotifier(paramString));
      }
    }
    
    public void onP2PDisconnected(String paramString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.P2PDisconnectedNotifier(paramString));
      }
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      if (this.zzaCJ != null) {
        this.zzaCJ.zza(new GamesClientImpl.MessageReceivedNotifier(paramRealTimeMessage));
      }
    }
    
    public void zzA(DataHolder paramDataHolder)
    {
      this.zzaCH.zza(new GamesClientImpl.JoinedRoomNotifier(paramDataHolder));
    }
    
    public void zzB(DataHolder paramDataHolder)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.RoomConnectingNotifier(paramDataHolder));
      }
    }
    
    public void zzC(DataHolder paramDataHolder)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.RoomAutoMatchingNotifier(paramDataHolder));
      }
    }
    
    public void zzD(DataHolder paramDataHolder)
    {
      this.zzaCH.zza(new GamesClientImpl.RoomConnectedNotifier(paramDataHolder));
    }
    
    public void zzE(DataHolder paramDataHolder)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.ConnectedToRoomNotifier(paramDataHolder));
      }
    }
    
    public void zzF(DataHolder paramDataHolder)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.DisconnectedFromRoomNotifier(paramDataHolder));
      }
    }
    
    public void zza(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerInvitedToRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzb(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerJoinedRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzc(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerLeftRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzd(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerDeclinedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zze(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerConnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzf(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzaCI != null) {
        this.zzaCI.zza(new GamesClientImpl.PeerDisconnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzz(DataHolder paramDataHolder)
    {
      this.zzaCH.zza(new GamesClientImpl.RoomCreatedNotifier(paramDataHolder));
    }
  }
  
  private static final class RoomConnectedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    RoomConnectedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  private static final class RoomConnectingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomConnectingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  private static final class RoomCreatedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public RoomCreatedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  private static final class SendRequestResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.SendRequestResult
  {
    private final GameRequest zzaCC;
    
    /* Error */
    SendRequestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/request/GameRequestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   30: invokeinterface 32 1 0
      //   35: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   38: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:zzaCC	Lcom/google/android/gms/games/request/GameRequest;
      //   41: aload_1
      //   42: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:zzaCC	Lcom/google/android/gms/games/request/GameRequest;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SendRequestResultImpl
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
  }
  
  private static final class SignOutCompleteBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Status> zzakL;
    
    public SignOutCompleteBinderCallbacks(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzvL()
    {
      Status localStatus = GamesStatusCodes.zzfU(0);
      this.zzakL.zzr(localStatus);
    }
  }
  
  private static final class SnapshotCommittedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Snapshots.CommitSnapshotResult> zzaCK;
    
    public SnapshotCommittedBinderCallbacks(zzlx.zzb<Snapshots.CommitSnapshotResult> paramzzb)
    {
      this.zzaCK = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzO(DataHolder paramDataHolder)
    {
      this.zzaCK.zzr(new GamesClientImpl.CommitSnapshotResultImpl(paramDataHolder));
    }
  }
  
  static final class SnapshotDeletedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Snapshots.DeleteSnapshotResult> zzakL;
    
    public SnapshotDeletedBinderCallbacks(zzlx.zzb<Snapshots.DeleteSnapshotResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzl(int paramInt, String paramString)
    {
      this.zzakL.zzr(new GamesClientImpl.DeleteSnapshotResultImpl(paramInt, paramString));
    }
  }
  
  private static final class SnapshotOpenedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Snapshots.OpenSnapshotResult> zzaCL;
    
    public SnapshotOpenedBinderCallbacks(zzlx.zzb<Snapshots.OpenSnapshotResult> paramzzb)
    {
      this.zzaCL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder paramDataHolder, Contents paramContents)
    {
      this.zzaCL.zzr(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramContents));
    }
    
    public void zza(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      this.zzaCL.zzr(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
    }
  }
  
  private static final class SnapshotsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Snapshots.LoadSnapshotsResult> zzaCM;
    
    public SnapshotsLoadedBinderCallbacks(zzlx.zzb<Snapshots.LoadSnapshotsResult> paramzzb)
    {
      this.zzaCM = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzN(DataHolder paramDataHolder)
    {
      this.zzaCM.zzr(new GamesClientImpl.LoadSnapshotsResultImpl(paramDataHolder));
    }
  }
  
  private static final class StartRecordingBinderCallback
    extends AbstractGamesCallbacks
  {
    private final Games.BaseGamesApiMethodImpl<Status> zzaCN;
    
    StartRecordingBinderCallback(Games.BaseGamesApiMethodImpl<Status> paramBaseGamesApiMethodImpl)
    {
      this.zzaCN = ((Games.BaseGamesApiMethodImpl)zzx.zzb(paramBaseGamesApiMethodImpl, "Holder must not be null"));
    }
    
    public void zzgi(int paramInt)
    {
      this.zzaCN.zzb(new Status(paramInt));
    }
  }
  
  private static final class SubmitScoreBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<Leaderboards.SubmitScoreResult> zzakL;
    
    public SubmitScoreBinderCallbacks(zzlx.zzb<Leaderboards.SubmitScoreResult> paramzzb)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzk(DataHolder paramDataHolder)
    {
      this.zzakL.zzr(new GamesClientImpl.SubmitScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData zzaCO;
    
    public SubmitScoreResultImpl(DataHolder paramDataHolder)
    {
      super();
      try
      {
        this.zzaCO = new ScoreSubmissionData(paramDataHolder);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.zzaCO;
    }
  }
  
  private static final class TurnBasedMatchCanceledBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.CancelMatchResult> zzaCP;
    
    public TurnBasedMatchCanceledBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.CancelMatchResult> paramzzb)
    {
      this.zzaCP = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzk(int paramInt, String paramString)
    {
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzaCP.zzr(new GamesClientImpl.CancelMatchResultImpl(localStatus, paramString));
    }
  }
  
  private static final class TurnBasedMatchInitiatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzaCQ;
    
    public TurnBasedMatchInitiatedBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb)
    {
      this.zzaCQ = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzv(DataHolder paramDataHolder)
    {
      this.zzaCQ.zzr(new GamesClientImpl.InitiateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLeftBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzaCR;
    
    public TurnBasedMatchLeftBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb)
    {
      this.zzaCR = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzx(DataHolder paramDataHolder)
    {
      this.zzaCR.zzr(new GamesClientImpl.LeaveMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.LoadMatchResult> zzaCS;
    
    public TurnBasedMatchLoadedBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.LoadMatchResult> paramzzb)
    {
      this.zzaCS = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzu(DataHolder paramDataHolder)
    {
      this.zzaCS.zzr(new GamesClientImpl.LoadMatchResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class TurnBasedMatchResult
    extends GamesClientImpl.GamesDataHolderResult
  {
    final TurnBasedMatch zzaCm;
    
    /* Error */
    TurnBasedMatchResult(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 15	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 16	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 20	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 24	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   30: invokeinterface 30 1 0
      //   35: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   38: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:zzaCm	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   41: aload_1
      //   42: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:zzaCm	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	TurnBasedMatchResult
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.zzaCm;
    }
  }
  
  private static final class TurnBasedMatchUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzaCT;
    
    public TurnBasedMatchUpdatedBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb)
    {
      this.zzaCT = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzw(DataHolder paramDataHolder)
    {
      this.zzaCT.zzr(new GamesClientImpl.UpdateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlx.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzaCU;
    
    public TurnBasedMatchesLoadedBinderCallbacks(zzlx.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb)
    {
      this.zzaCU = ((zzlx.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzc(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfU(paramInt);
      this.zzaCU.zzr(new GamesClientImpl.LoadMatchesResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class UpdateAchievementResultImpl
    implements Achievements.UpdateAchievementResult
  {
    private final Status zzTA;
    private final String zzaAE;
    
    UpdateAchievementResultImpl(int paramInt, String paramString)
    {
      this.zzTA = GamesStatusCodes.zzfU(paramInt);
      this.zzaAE = paramString;
    }
    
    public String getAchievementId()
    {
      return this.zzaAE;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class UpdateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    UpdateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class UpdateRequestsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.UpdateRequestsResult
  {
    private final RequestUpdateOutcomes zzaCV;
    
    UpdateRequestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzaCV = RequestUpdateOutcomes.zzab(paramDataHolder);
    }
    
    public Set<String> getRequestIds()
    {
      return this.zzaCV.getRequestIds();
    }
    
    public int getRequestOutcome(String paramString)
    {
      return this.zzaCV.getRequestOutcome(paramString);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/GamesClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */