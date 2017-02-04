package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.ListVideosResult;

public final class VideosImpl
  implements Videos
{
  private static abstract class ListImpl
    extends Games.BaseGamesApiMethodImpl<Videos.ListVideosResult>
  {
    public Videos.ListVideosResult zzaN(final Status paramStatus)
    {
      new Videos.ListVideosResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/api/VideosImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */