package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
  extends zzc
  implements Participant
{
  private final PlayerRef zzaHe;
  
  public ParticipantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.zzaHe = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.zza(this, paramObject);
  }
  
  public Participant freeze()
  {
    return new ParticipantEntity(this);
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    if (zzcv("external_player_id")) {
      return getString("default_display_name");
    }
    return this.zzaHe.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (zzcv("external_player_id"))
    {
      zza("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.zzaHe.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (zzcv("external_player_id")) {
      return zzcu("default_display_hi_res_image_uri");
    }
    return this.zzaHe.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (zzcv("external_player_id")) {
      return getString("default_display_hi_res_image_url");
    }
    return this.zzaHe.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (zzcv("external_player_id")) {
      return zzcu("default_display_image_uri");
    }
    return this.zzaHe.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (zzcv("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.zzaHe.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return getString("external_participant_id");
  }
  
  public Player getPlayer()
  {
    if (zzcv("external_player_id")) {
      return null;
    }
    return this.zzaHe;
  }
  
  public ParticipantResult getResult()
  {
    if (zzcv("result_type")) {
      return null;
    }
    int i = getInteger("result_type");
    int j = getInteger("placing");
    return new ParticipantResult(getParticipantId(), i, j);
  }
  
  public int getStatus()
  {
    return getInteger("player_status");
  }
  
  public int hashCode()
  {
    return ParticipantEntity.zza(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return getInteger("connected") > 0;
  }
  
  public String toString()
  {
    return ParticipantEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzvN()
  {
    return getString("client_address");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */