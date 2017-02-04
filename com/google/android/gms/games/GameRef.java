package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class GameRef
  extends zzc
  implements Game
{
  public GameRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public boolean areSnapshotsEnabled()
  {
    return getInteger("snapshots_enabled") > 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameEntity.zza(this, paramObject);
  }
  
  public Game freeze()
  {
    return new GameEntity(this);
  }
  
  public int getAchievementTotalCount()
  {
    return getInteger("achievement_total_count");
  }
  
  public String getApplicationId()
  {
    return getString("external_game_id");
  }
  
  public String getDescription()
  {
    return getString("game_description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("game_description", paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return getString("developer_name");
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("developer_name", paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return getString("display_name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("display_name", paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return zzcu("featured_image_uri");
  }
  
  public String getFeaturedImageUrl()
  {
    return getString("featured_image_url");
  }
  
  public Uri getHiResImageUri()
  {
    return zzcu("game_hi_res_image_uri");
  }
  
  public String getHiResImageUrl()
  {
    return getString("game_hi_res_image_url");
  }
  
  public Uri getIconImageUri()
  {
    return zzcu("game_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("game_icon_image_url");
  }
  
  public int getLeaderboardCount()
  {
    return getInteger("leaderboard_count");
  }
  
  public String getPrimaryCategory()
  {
    return getString("primary_category");
  }
  
  public String getSecondaryCategory()
  {
    return getString("secondary_category");
  }
  
  public String getThemeColor()
  {
    return getString("theme_color");
  }
  
  public boolean hasGamepadSupport()
  {
    return getInteger("gamepad_support") > 0;
  }
  
  public int hashCode()
  {
    return GameEntity.zza(this);
  }
  
  public boolean isMuted()
  {
    return getBoolean("muted");
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return getInteger("real_time_support") > 0;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return getInteger("turn_based_support") > 0;
  }
  
  public String toString()
  {
    return GameEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public boolean zzuR()
  {
    return getBoolean("play_enabled_game");
  }
  
  public boolean zzuS()
  {
    return getBoolean("identity_sharing_confirmed");
  }
  
  public boolean zzuT()
  {
    return getInteger("installed") > 0;
  }
  
  public String zzuU()
  {
    return getString("package_name");
  }
  
  public int zzuV()
  {
    return getInteger("gameplay_acl_status");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/GameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */