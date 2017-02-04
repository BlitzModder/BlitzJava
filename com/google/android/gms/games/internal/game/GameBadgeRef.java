package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class GameBadgeRef
  extends zzc
  implements GameBadge
{
  public GameBadgeRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameBadgeEntity.zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("badge_description");
  }
  
  public Uri getIconImageUri()
  {
    return zzcu("badge_icon_image_uri");
  }
  
  public String getTitle()
  {
    return getString("badge_title");
  }
  
  public int getType()
  {
    return getInteger("badge_type");
  }
  
  public int hashCode()
  {
    return GameBadgeEntity.zza(this);
  }
  
  public String toString()
  {
    return GameBadgeEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameBadgeEntity)zzwF()).writeToParcel(paramParcel, paramInt);
  }
  
  public GameBadge zzwF()
  {
    return new GameBadgeEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */