package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zznn;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final String mName;
  private final int mVersionCode;
  private final String zzVu;
  private final long zzaAj;
  private final int zzaAk;
  private final long zzaAl;
  private final MostRecentGameInfoEntity zzaAm;
  private final PlayerLevelInfo zzaAn;
  private final boolean zzaAo;
  private final boolean zzaAp;
  private final String zzaAq;
  private final Uri zzaAr;
  private final String zzaAs;
  private final Uri zzaAt;
  private final String zzaAu;
  private final String zzabq;
  private final String zzank;
  private final Uri zzazC;
  private final Uri zzazD;
  private final String zzazN;
  private final String zzazO;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString6, String paramString7, Uri paramUri3, String paramString8, Uri paramUri4, String paramString9)
  {
    this.mVersionCode = paramInt1;
    this.zzabq = paramString1;
    this.zzVu = paramString2;
    this.zzazC = paramUri1;
    this.zzazN = paramString3;
    this.zzazD = paramUri2;
    this.zzazO = paramString4;
    this.zzaAj = paramLong1;
    this.zzaAk = paramInt2;
    this.zzaAl = paramLong2;
    this.zzank = paramString5;
    this.zzaAo = paramBoolean1;
    this.zzaAm = paramMostRecentGameInfoEntity;
    this.zzaAn = paramPlayerLevelInfo;
    this.zzaAp = paramBoolean2;
    this.zzaAq = paramString6;
    this.mName = paramString7;
    this.zzaAr = paramUri3;
    this.zzaAs = paramString8;
    this.zzaAt = paramUri4;
    this.zzaAu = paramString9;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this(paramPlayer, true);
  }
  
  public PlayerEntity(Player paramPlayer, boolean paramBoolean)
  {
    this.mVersionCode = 13;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramPlayer.getPlayerId();
      this.zzabq = ((String)localObject1);
      this.zzVu = paramPlayer.getDisplayName();
      this.zzazC = paramPlayer.getIconImageUri();
      this.zzazN = paramPlayer.getIconImageUrl();
      this.zzazD = paramPlayer.getHiResImageUri();
      this.zzazO = paramPlayer.getHiResImageUrl();
      this.zzaAj = paramPlayer.getRetrievedTimestamp();
      this.zzaAk = paramPlayer.zzva();
      this.zzaAl = paramPlayer.getLastPlayedWithTimestamp();
      this.zzank = paramPlayer.getTitle();
      this.zzaAo = paramPlayer.zzvb();
      localObject1 = paramPlayer.zzvc();
      if (localObject1 != null) {
        break label267;
      }
      localObject1 = localObject2;
      label143:
      this.zzaAm = ((MostRecentGameInfoEntity)localObject1);
      this.zzaAn = paramPlayer.getLevelInfo();
      this.zzaAp = paramPlayer.zzuZ();
      this.zzaAq = paramPlayer.zzuY();
      this.mName = paramPlayer.getName();
      this.zzaAr = paramPlayer.getBannerImageLandscapeUri();
      this.zzaAs = paramPlayer.getBannerImageLandscapeUrl();
      this.zzaAt = paramPlayer.getBannerImagePortraitUri();
      this.zzaAu = paramPlayer.getBannerImagePortraitUrl();
      if (paramBoolean) {
        zzb.zzu(this.zzabq);
      }
      zzb.zzu(this.zzVu);
      if (this.zzaAj <= 0L) {
        break label279;
      }
    }
    label267:
    label279:
    for (paramBoolean = true;; paramBoolean = false)
    {
      zzb.zzaa(paramBoolean);
      return;
      localObject1 = null;
      break;
      localObject1 = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject1);
      break label143;
    }
  }
  
  static boolean zza(Player paramPlayer, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Player)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayer == paramObject);
      paramObject = (Player)paramObject;
      if ((!zzw.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!zzw.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!zzw.equal(Boolean.valueOf(((Player)paramObject).zzuZ()), Boolean.valueOf(paramPlayer.zzuZ()))) || (!zzw.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!zzw.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!zzw.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!zzw.equal(((Player)paramObject).getTitle(), paramPlayer.getTitle())) || (!zzw.equal(((Player)paramObject).getLevelInfo(), paramPlayer.getLevelInfo())) || (!zzw.equal(((Player)paramObject).zzuY(), paramPlayer.zzuY())) || (!zzw.equal(((Player)paramObject).getName(), paramPlayer.getName())) || (!zzw.equal(((Player)paramObject).getBannerImageLandscapeUri(), paramPlayer.getBannerImageLandscapeUri()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Player)paramObject).getBannerImagePortraitUri(), paramPlayer.getBannerImagePortraitUri()));
    return false;
  }
  
  static int zzb(Player paramPlayer)
  {
    return zzw.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), Boolean.valueOf(paramPlayer.zzuZ()), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()), paramPlayer.getTitle(), paramPlayer.getLevelInfo(), paramPlayer.zzuY(), paramPlayer.getName(), paramPlayer.getBannerImageLandscapeUri(), paramPlayer.getBannerImagePortraitUri() });
  }
  
  static String zzc(Player paramPlayer)
  {
    return zzw.zzx(paramPlayer).zzg("PlayerId", paramPlayer.getPlayerId()).zzg("DisplayName", paramPlayer.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(paramPlayer.zzuZ())).zzg("IconImageUri", paramPlayer.getIconImageUri()).zzg("IconImageUrl", paramPlayer.getIconImageUrl()).zzg("HiResImageUri", paramPlayer.getHiResImageUri()).zzg("HiResImageUrl", paramPlayer.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).zzg("Title", paramPlayer.getTitle()).zzg("LevelInfo", paramPlayer.getLevelInfo()).zzg("GamerTag", paramPlayer.zzuY()).zzg("Name", paramPlayer.getName()).zzg("BannerImageLandscapeUri", paramPlayer.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", paramPlayer.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", paramPlayer.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", paramPlayer.getBannerImagePortraitUrl()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public Uri getBannerImageLandscapeUri()
  {
    return this.zzaAr;
  }
  
  public String getBannerImageLandscapeUrl()
  {
    return this.zzaAs;
  }
  
  public Uri getBannerImagePortraitUri()
  {
    return this.zzaAt;
  }
  
  public String getBannerImagePortraitUrl()
  {
    return this.zzaAu;
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzVu, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.zzazD;
  }
  
  public String getHiResImageUrl()
  {
    return this.zzazO;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzazC;
  }
  
  public String getIconImageUrl()
  {
    return this.zzazN;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.zzaAl;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.zzaAn;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPlayerId()
  {
    return this.zzabq;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.zzaAj;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzank, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
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
    return zzb(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!zzqk())
    {
      PlayerEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzabq);
    paramParcel.writeString(this.zzVu);
    if (this.zzazC == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.zzazD != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.zzazD.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.zzaAj);
      return;
      localObject1 = this.zzazC.toString();
      break;
    }
  }
  
  public String zzuY()
  {
    return this.zzaAq;
  }
  
  public boolean zzuZ()
  {
    return this.zzaAp;
  }
  
  public int zzva()
  {
    return this.zzaAk;
  }
  
  public boolean zzvb()
  {
    return this.zzaAo;
  }
  
  public MostRecentGameInfo zzvc()
  {
    return this.zzaAm;
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity zzdT(Parcel paramParcel)
    {
      if ((PlayerEntity.zzc(PlayerEntity.zzuW())) || (PlayerEntity.zzds(PlayerEntity.class.getCanonicalName()))) {
        return super.zzdT(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2 = paramParcel.readString();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label111;
        }
      }
      label111:
      for (localObject2 = null;; localObject2 = Uri.parse((String)localObject2))
      {
        return new PlayerEntity(13, str1, str2, (Uri)localObject1, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true, false, paramParcel.readString(), paramParcel.readString(), null, null, null, null);
        localObject1 = Uri.parse((String)localObject1);
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */