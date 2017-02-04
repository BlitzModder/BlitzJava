package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zznn;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final int mVersionCode;
  private final boolean zzCZ;
  private final String zzVu;
  private final String zzXW;
  private final String zzavc;
  private final String zzazA;
  private final String zzazB;
  private final Uri zzazC;
  private final Uri zzazD;
  private final Uri zzazE;
  private final boolean zzazF;
  private final boolean zzazG;
  private final String zzazH;
  private final int zzazI;
  private final int zzazJ;
  private final int zzazK;
  private final boolean zzazL;
  private final boolean zzazM;
  private final String zzazN;
  private final String zzazO;
  private final String zzazP;
  private final boolean zzazQ;
  private final boolean zzazR;
  private final String zzazS;
  private final boolean zzazT;
  private final String zzazz;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11, boolean paramBoolean8)
  {
    this.mVersionCode = paramInt1;
    this.zzXW = paramString1;
    this.zzVu = paramString2;
    this.zzazz = paramString3;
    this.zzazA = paramString4;
    this.zzavc = paramString5;
    this.zzazB = paramString6;
    this.zzazC = paramUri1;
    this.zzazN = paramString8;
    this.zzazD = paramUri2;
    this.zzazO = paramString9;
    this.zzazE = paramUri3;
    this.zzazP = paramString10;
    this.zzazF = paramBoolean1;
    this.zzazG = paramBoolean2;
    this.zzazH = paramString7;
    this.zzazI = paramInt2;
    this.zzazJ = paramInt3;
    this.zzazK = paramInt4;
    this.zzazL = paramBoolean3;
    this.zzazM = paramBoolean4;
    this.zzCZ = paramBoolean5;
    this.zzazQ = paramBoolean6;
    this.zzazR = paramBoolean7;
    this.zzazS = paramString11;
    this.zzazT = paramBoolean8;
  }
  
  public GameEntity(Game paramGame)
  {
    this.mVersionCode = 7;
    this.zzXW = paramGame.getApplicationId();
    this.zzazz = paramGame.getPrimaryCategory();
    this.zzazA = paramGame.getSecondaryCategory();
    this.zzavc = paramGame.getDescription();
    this.zzazB = paramGame.getDeveloperName();
    this.zzVu = paramGame.getDisplayName();
    this.zzazC = paramGame.getIconImageUri();
    this.zzazN = paramGame.getIconImageUrl();
    this.zzazD = paramGame.getHiResImageUri();
    this.zzazO = paramGame.getHiResImageUrl();
    this.zzazE = paramGame.getFeaturedImageUri();
    this.zzazP = paramGame.getFeaturedImageUrl();
    this.zzazF = paramGame.zzuR();
    this.zzazG = paramGame.zzuT();
    this.zzazH = paramGame.zzuU();
    this.zzazI = paramGame.zzuV();
    this.zzazJ = paramGame.getAchievementTotalCount();
    this.zzazK = paramGame.getLeaderboardCount();
    this.zzazL = paramGame.isRealTimeMultiplayerEnabled();
    this.zzazM = paramGame.isTurnBasedMultiplayerEnabled();
    this.zzCZ = paramGame.isMuted();
    this.zzazQ = paramGame.zzuS();
    this.zzazR = paramGame.areSnapshotsEnabled();
    this.zzazS = paramGame.getThemeColor();
    this.zzazT = paramGame.hasGamepadSupport();
  }
  
  static int zza(Game paramGame)
  {
    return zzw.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.zzuR()), Boolean.valueOf(paramGame.zzuT()), paramGame.zzuU(), Integer.valueOf(paramGame.zzuV()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.zzuS()), Boolean.valueOf(paramGame.areSnapshotsEnabled()), paramGame.getThemeColor(), Boolean.valueOf(paramGame.hasGamepadSupport()) });
  }
  
  static boolean zza(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramGame == paramObject);
    paramObject = (Game)paramObject;
    boolean bool3;
    if ((zzw.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (zzw.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (zzw.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (zzw.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (zzw.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (zzw.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (zzw.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (zzw.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (zzw.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (zzw.equal(Boolean.valueOf(((Game)paramObject).zzuR()), Boolean.valueOf(paramGame.zzuR()))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).zzuT()), Boolean.valueOf(paramGame.zzuT()))) && (zzw.equal(((Game)paramObject).zzuU(), paramGame.zzuU())) && (zzw.equal(Integer.valueOf(((Game)paramObject).zzuV()), Integer.valueOf(paramGame.zzuV()))) && (zzw.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (zzw.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool3 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!zzw.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!zzw.equal(Boolean.valueOf(((Game)paramObject).zzuS()), Boolean.valueOf(paramGame.zzuS())))) {
        break label501;
      }
    }
    label501:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((zzw.equal(Boolean.valueOf(bool3), Boolean.valueOf(bool1))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))) && (zzw.equal(((Game)paramObject).getThemeColor(), paramGame.getThemeColor())))
      {
        bool1 = bool2;
        if (zzw.equal(Boolean.valueOf(((Game)paramObject).hasGamepadSupport()), Boolean.valueOf(paramGame.hasGamepadSupport()))) {
          break;
        }
      }
      return false;
    }
  }
  
  static String zzb(Game paramGame)
  {
    return zzw.zzx(paramGame).zzg("ApplicationId", paramGame.getApplicationId()).zzg("DisplayName", paramGame.getDisplayName()).zzg("PrimaryCategory", paramGame.getPrimaryCategory()).zzg("SecondaryCategory", paramGame.getSecondaryCategory()).zzg("Description", paramGame.getDescription()).zzg("DeveloperName", paramGame.getDeveloperName()).zzg("IconImageUri", paramGame.getIconImageUri()).zzg("IconImageUrl", paramGame.getIconImageUrl()).zzg("HiResImageUri", paramGame.getHiResImageUri()).zzg("HiResImageUrl", paramGame.getHiResImageUrl()).zzg("FeaturedImageUri", paramGame.getFeaturedImageUri()).zzg("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(paramGame.zzuR())).zzg("InstanceInstalled", Boolean.valueOf(paramGame.zzuT())).zzg("InstancePackageName", paramGame.zzuU()).zzg("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).zzg("ThemeColor", paramGame.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(paramGame.hasGamepadSupport())).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.zzazR;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Game freeze()
  {
    return this;
  }
  
  public int getAchievementTotalCount()
  {
    return this.zzazJ;
  }
  
  public String getApplicationId()
  {
    return this.zzXW;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.zzazB;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzazB, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzVu, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.zzazE;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.zzazP;
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
  
  public int getLeaderboardCount()
  {
    return this.zzazK;
  }
  
  public String getPrimaryCategory()
  {
    return this.zzazz;
  }
  
  public String getSecondaryCategory()
  {
    return this.zzazA;
  }
  
  public String getThemeColor()
  {
    return this.zzazS;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasGamepadSupport()
  {
    return this.zzazT;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isMuted()
  {
    return this.zzCZ;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.zzazL;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.zzazM;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!zzqk())
    {
      GameEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzXW);
    paramParcel.writeString(this.zzVu);
    paramParcel.writeString(this.zzazz);
    paramParcel.writeString(this.zzazA);
    paramParcel.writeString(this.zzavc);
    paramParcel.writeString(this.zzazB);
    Object localObject1;
    if (this.zzazC == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.zzazD != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.zzazE != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.zzazF) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.zzazG) {
        break label218;
      }
    }
    label189:
    label201:
    label213:
    label218:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.zzazH);
      paramParcel.writeInt(this.zzazI);
      paramParcel.writeInt(this.zzazJ);
      paramParcel.writeInt(this.zzazK);
      return;
      localObject1 = this.zzazC.toString();
      break;
      localObject1 = this.zzazD.toString();
      break label93;
      localObject1 = this.zzazE.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  public boolean zzuR()
  {
    return this.zzazF;
  }
  
  public boolean zzuS()
  {
    return this.zzazQ;
  }
  
  public boolean zzuT()
  {
    return this.zzazG;
  }
  
  public String zzuU()
  {
    return this.zzazH;
  }
  
  public int zzuV()
  {
    return this.zzazI;
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity zzdS(Parcel paramParcel)
    {
      if ((GameEntity.zzc(GameEntity.zzuW())) || (GameEntity.zzds(GameEntity.class.getCanonicalName()))) {
        return super.zzdS(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      String str5 = paramParcel.readString();
      String str6 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label90:
      Object localObject3;
      label104:
      boolean bool1;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label188;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label198;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label208;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label213;
        }
      }
      label188:
      label198:
      label208:
      label213:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(7, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label90;
        localObject3 = Uri.parse((String)localObject3);
        break label104;
        bool1 = false;
        break label113;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */