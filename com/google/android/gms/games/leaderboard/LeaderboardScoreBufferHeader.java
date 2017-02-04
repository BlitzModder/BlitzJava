package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader
{
  private final Bundle zzTn;
  
  public LeaderboardScoreBufferHeader(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzTn = localBundle;
  }
  
  public Bundle asBundle()
  {
    return this.zzTn;
  }
  
  public static final class Builder {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreBufferHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */