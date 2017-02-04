package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public abstract interface Player
  extends Parcelable, Freezable<Player>
{
  public static final long CURRENT_XP_UNKNOWN = -1L;
  public static final long TIMESTAMP_UNKNOWN = -1L;
  
  public abstract Uri getBannerImageLandscapeUri();
  
  @Deprecated
  public abstract String getBannerImageLandscapeUrl();
  
  public abstract Uri getBannerImagePortraitUri();
  
  @Deprecated
  public abstract String getBannerImagePortraitUrl();
  
  public abstract String getDisplayName();
  
  public abstract void getDisplayName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Uri getHiResImageUri();
  
  @Deprecated
  public abstract String getHiResImageUrl();
  
  public abstract Uri getIconImageUri();
  
  @Deprecated
  public abstract String getIconImageUrl();
  
  public abstract long getLastPlayedWithTimestamp();
  
  public abstract PlayerLevelInfo getLevelInfo();
  
  public abstract String getName();
  
  public abstract String getPlayerId();
  
  public abstract long getRetrievedTimestamp();
  
  public abstract String getTitle();
  
  public abstract void getTitle(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract boolean hasHiResImage();
  
  public abstract boolean hasIconImage();
  
  public abstract String zzuY();
  
  public abstract boolean zzuZ();
  
  public abstract int zzva();
  
  public abstract boolean zzvb();
  
  public abstract MostRecentGameInfo zzvc();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */