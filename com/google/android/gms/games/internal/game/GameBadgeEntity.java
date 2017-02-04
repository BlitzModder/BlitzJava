package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity
  extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
  private final int mVersionCode;
  private int zzZU;
  private String zzank;
  private String zzavc;
  private Uri zzazC;
  
  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.mVersionCode = paramInt1;
    this.zzZU = paramInt2;
    this.zzank = paramString1;
    this.zzavc = paramString2;
    this.zzazC = paramUri;
  }
  
  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.mVersionCode = 1;
    this.zzZU = paramGameBadge.getType();
    this.zzank = paramGameBadge.getTitle();
    this.zzavc = paramGameBadge.getDescription();
    this.zzazC = paramGameBadge.getIconImageUri();
  }
  
  static int zza(GameBadge paramGameBadge)
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(paramGameBadge.getType()), paramGameBadge.getTitle(), paramGameBadge.getDescription(), paramGameBadge.getIconImageUri() });
  }
  
  static boolean zza(GameBadge paramGameBadge, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof GameBadge)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGameBadge == paramObject);
      paramObject = (GameBadge)paramObject;
      if (!zzw.equal(Integer.valueOf(((GameBadge)paramObject).getType()), paramGameBadge.getTitle())) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((GameBadge)paramObject).getDescription(), paramGameBadge.getIconImageUri()));
    return false;
  }
  
  static String zzb(GameBadge paramGameBadge)
  {
    return zzw.zzx(paramGameBadge).zzg("Type", Integer.valueOf(paramGameBadge.getType())).zzg("Title", paramGameBadge.getTitle()).zzg("Description", paramGameBadge.getDescription()).zzg("IconImageUri", paramGameBadge.getIconImageUri()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzazC;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!zzqk())
    {
      GameBadgeEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(this.zzZU);
    paramParcel.writeString(this.zzank);
    paramParcel.writeString(this.zzavc);
    if (this.zzazC == null) {}
    for (String str = null;; str = this.zzazC.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
  
  public GameBadge zzwF()
  {
    return this;
  }
  
  static final class GameBadgeEntityCreatorCompat
    extends GameBadgeEntityCreator
  {
    public GameBadgeEntity zzef(Parcel paramParcel)
    {
      if ((GameBadgeEntity.zzc(GameBadgeEntity.zzuW())) || (GameBadgeEntity.zzds(GameBadgeEntity.class.getCanonicalName()))) {
        return super.zzef(paramParcel);
      }
      int i = paramParcel.readInt();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (paramParcel == null) {}
      for (paramParcel = null;; paramParcel = Uri.parse(paramParcel)) {
        return new GameBadgeEntity(1, i, str1, str2, paramParcel);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */