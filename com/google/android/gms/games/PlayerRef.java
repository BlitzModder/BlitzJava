package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef
  extends zzc
  implements Player
{
  private final PlayerColumnNames zzaAC;
  private final MostRecentGameInfoRef zzaAD;
  private final PlayerLevelInfo zzaAn;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.zzaAC = new PlayerColumnNames(paramString);
    this.zzaAD = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.zzaAC);
    int i;
    if (zzvd())
    {
      paramInt = getInteger(this.zzaAC.zzaFS);
      i = getInteger(this.zzaAC.zzaFV);
      paramString = new PlayerLevel(paramInt, getLong(this.zzaAC.zzaFT), getLong(this.zzaAC.zzaFU));
      if (paramInt == i) {
        break label178;
      }
    }
    label178:
    for (paramDataHolder = new PlayerLevel(i, getLong(this.zzaAC.zzaFU), getLong(this.zzaAC.zzaFW));; paramDataHolder = paramString)
    {
      this.zzaAn = new PlayerLevelInfo(getLong(this.zzaAC.zzaFR), getLong(this.zzaAC.zzaFX), paramString, paramDataHolder);
      return;
      this.zzaAn = null;
      return;
    }
  }
  
  private boolean zzvd()
  {
    if (zzcv(this.zzaAC.zzaFR)) {}
    while (getLong(this.zzaAC.zzaFR) == -1L) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.zza(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public Uri getBannerImageLandscapeUri()
  {
    return zzcu(this.zzaAC.zzaGi);
  }
  
  public String getBannerImageLandscapeUrl()
  {
    return getString(this.zzaAC.zzaGj);
  }
  
  public Uri getBannerImagePortraitUri()
  {
    return zzcu(this.zzaAC.zzaGk);
  }
  
  public String getBannerImagePortraitUrl()
  {
    return getString(this.zzaAC.zzaGl);
  }
  
  public String getDisplayName()
  {
    return getString(this.zzaAC.zzaFJ);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza(this.zzaAC.zzaFJ, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return zzcu(this.zzaAC.zzaFM);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.zzaAC.zzaFN);
  }
  
  public Uri getIconImageUri()
  {
    return zzcu(this.zzaAC.zzaFK);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.zzaAC.zzaFL);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!zzct(this.zzaAC.zzaFQ)) || (zzcv(this.zzaAC.zzaFQ))) {
      return -1L;
    }
    return getLong(this.zzaAC.zzaFQ);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.zzaAn;
  }
  
  public String getName()
  {
    return getString(this.zzaAC.name);
  }
  
  public String getPlayerId()
  {
    return getString(this.zzaAC.zzaFI);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.zzaAC.zzaFO);
  }
  
  public String getTitle()
  {
    return getString(this.zzaAC.title);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    zza(this.zzaAC.title, paramCharArrayBuffer);
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return PlayerEntity.zzb(this);
  }
  
  public String toString()
  {
    return PlayerEntity.zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzuY()
  {
    return getString(this.zzaAC.zzaGh);
  }
  
  public boolean zzuZ()
  {
    return getBoolean(this.zzaAC.zzaGg);
  }
  
  public int zzva()
  {
    return getInteger(this.zzaAC.zzaFP);
  }
  
  public boolean zzvb()
  {
    return getBoolean(this.zzaAC.zzaFZ);
  }
  
  public MostRecentGameInfo zzvc()
  {
    if (zzcv(this.zzaAC.zzaGa)) {
      return null;
    }
    return this.zzaAD;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */