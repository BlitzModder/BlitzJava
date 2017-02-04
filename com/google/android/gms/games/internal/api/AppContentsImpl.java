package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl
  implements AppContents
{
  private static abstract class LoadsImpl
    extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult>
  {
    public AppContents.LoadAppContentResult zzad(final Status paramStatus)
    {
      new AppContents.LoadAppContentResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/api/AppContentsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */