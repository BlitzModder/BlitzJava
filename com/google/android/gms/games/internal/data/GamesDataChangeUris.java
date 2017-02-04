package com.google.android.gms.games.internal.data;

import android.net.Uri;
import android.net.Uri.Builder;

public final class GamesDataChangeUris
{
  private static final Uri zzaFq = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
  public static final Uri zzaFr = zzaFq.buildUpon().appendPath("invitations").build();
  public static final Uri zzaFs = zzaFq.buildUpon().appendEncodedPath("players").build();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/data/GamesDataChangeUris.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */