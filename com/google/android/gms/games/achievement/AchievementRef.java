package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class AchievementRef
  extends zzc
  implements Achievement
{
  AchievementRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Achievement freeze()
  {
    return new AchievementEntity(this);
  }
  
  public String getAchievementId()
  {
    return getString("external_achievement_id");
  }
  
  public int getCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return getInteger("current_steps");
      bool = false;
    }
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("description", paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return getString("formatted_current_steps");
      bool = false;
    }
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      zza("formatted_current_steps", paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public String getFormattedTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return getString("formatted_total_steps");
      bool = false;
    }
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      zza("formatted_total_steps", paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("last_updated_timestamp");
  }
  
  public String getName()
  {
    return getString("name");
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("name", paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return new PlayerRef(this.zzafC, this.zzahw);
  }
  
  public Uri getRevealedImageUri()
  {
    return zzcu("revealed_icon_image_uri");
  }
  
  public String getRevealedImageUrl()
  {
    return getString("revealed_icon_image_url");
  }
  
  public int getState()
  {
    return getInteger("state");
  }
  
  public int getTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return getInteger("total_steps");
      bool = false;
    }
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public Uri getUnlockedImageUri()
  {
    return zzcu("unlocked_icon_image_uri");
  }
  
  public String getUnlockedImageUrl()
  {
    return getString("unlocked_icon_image_url");
  }
  
  public long getXpValue()
  {
    if ((!zzct("instance_xp_value")) || (zzcv("instance_xp_value"))) {
      return getLong("definition_xp_value");
    }
    return getLong("instance_xp_value");
  }
  
  public String toString()
  {
    return AchievementEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AchievementEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */