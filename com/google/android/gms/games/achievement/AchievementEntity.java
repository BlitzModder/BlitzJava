package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class AchievementEntity
  implements SafeParcelable, Achievement
{
  public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
  private final String mName;
  private final int mState;
  private final int mVersionCode;
  private final int zzZU;
  private final String zzaAE;
  private final Uri zzaAF;
  private final String zzaAG;
  private final Uri zzaAH;
  private final String zzaAI;
  private final int zzaAJ;
  private final String zzaAK;
  private final PlayerEntity zzaAL;
  private final int zzaAM;
  private final String zzaAN;
  private final long zzaAO;
  private final long zzaAP;
  private final String zzavc;
  
  AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt1;
    this.zzaAE = paramString1;
    this.zzZU = paramInt2;
    this.mName = paramString2;
    this.zzavc = paramString3;
    this.zzaAF = paramUri1;
    this.zzaAG = paramString4;
    this.zzaAH = paramUri2;
    this.zzaAI = paramString5;
    this.zzaAJ = paramInt3;
    this.zzaAK = paramString6;
    this.zzaAL = paramPlayerEntity;
    this.mState = paramInt4;
    this.zzaAM = paramInt5;
    this.zzaAN = paramString7;
    this.zzaAO = paramLong1;
    this.zzaAP = paramLong2;
  }
  
  public AchievementEntity(Achievement paramAchievement)
  {
    this.mVersionCode = 1;
    this.zzaAE = paramAchievement.getAchievementId();
    this.zzZU = paramAchievement.getType();
    this.mName = paramAchievement.getName();
    this.zzavc = paramAchievement.getDescription();
    this.zzaAF = paramAchievement.getUnlockedImageUri();
    this.zzaAG = paramAchievement.getUnlockedImageUrl();
    this.zzaAH = paramAchievement.getRevealedImageUri();
    this.zzaAI = paramAchievement.getRevealedImageUrl();
    this.zzaAL = ((PlayerEntity)paramAchievement.getPlayer().freeze());
    this.mState = paramAchievement.getState();
    this.zzaAO = paramAchievement.getLastUpdatedTimestamp();
    this.zzaAP = paramAchievement.getXpValue();
    if (paramAchievement.getType() == 1)
    {
      this.zzaAJ = paramAchievement.getTotalSteps();
      this.zzaAK = paramAchievement.getFormattedTotalSteps();
      this.zzaAM = paramAchievement.getCurrentSteps();
    }
    for (this.zzaAN = paramAchievement.getFormattedCurrentSteps();; this.zzaAN = null)
    {
      zzb.zzu(this.zzaAE);
      zzb.zzu(this.zzavc);
      return;
      this.zzaAJ = 0;
      this.zzaAK = null;
      this.zzaAM = 0;
    }
  }
  
  static int zza(Achievement paramAchievement)
  {
    int j;
    int i;
    if (paramAchievement.getType() == 1)
    {
      j = paramAchievement.getCurrentSteps();
      i = paramAchievement.getTotalSteps();
    }
    for (;;)
    {
      return zzw.hashCode(new Object[] { paramAchievement.getAchievementId(), paramAchievement.getName(), Integer.valueOf(paramAchievement.getType()), paramAchievement.getDescription(), Long.valueOf(paramAchievement.getXpValue()), Integer.valueOf(paramAchievement.getState()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()), paramAchievement.getPlayer(), Integer.valueOf(j), Integer.valueOf(i) });
      i = 0;
      j = 0;
    }
  }
  
  static boolean zza(Achievement paramAchievement, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2;
    if (!(paramObject instanceof Achievement)) {
      bool2 = false;
    }
    do
    {
      return bool2;
      bool2 = bool3;
    } while (paramAchievement == paramObject);
    paramObject = (Achievement)paramObject;
    boolean bool1;
    if (paramAchievement.getType() == 1)
    {
      bool2 = zzw.equal(Integer.valueOf(((Achievement)paramObject).getCurrentSteps()), Integer.valueOf(paramAchievement.getCurrentSteps()));
      bool1 = zzw.equal(Integer.valueOf(((Achievement)paramObject).getTotalSteps()), Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    for (;;)
    {
      if ((zzw.equal(((Achievement)paramObject).getAchievementId(), paramAchievement.getAchievementId())) && (zzw.equal(((Achievement)paramObject).getName(), paramAchievement.getName())) && (zzw.equal(Integer.valueOf(((Achievement)paramObject).getType()), Integer.valueOf(paramAchievement.getType()))) && (zzw.equal(((Achievement)paramObject).getDescription(), paramAchievement.getDescription())) && (zzw.equal(Long.valueOf(((Achievement)paramObject).getXpValue()), Long.valueOf(paramAchievement.getXpValue()))) && (zzw.equal(Integer.valueOf(((Achievement)paramObject).getState()), Integer.valueOf(paramAchievement.getState()))) && (zzw.equal(Long.valueOf(((Achievement)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()))) && (zzw.equal(((Achievement)paramObject).getPlayer(), paramAchievement.getPlayer())) && (bool2))
      {
        bool2 = bool3;
        if (bool1) {
          break;
        }
      }
      return false;
      bool1 = true;
      bool2 = true;
    }
  }
  
  static String zzb(Achievement paramAchievement)
  {
    zzw.zza localzza = zzw.zzx(paramAchievement).zzg("Id", paramAchievement.getAchievementId()).zzg("Type", Integer.valueOf(paramAchievement.getType())).zzg("Name", paramAchievement.getName()).zzg("Description", paramAchievement.getDescription()).zzg("Player", paramAchievement.getPlayer()).zzg("State", Integer.valueOf(paramAchievement.getState()));
    if (paramAchievement.getType() == 1)
    {
      localzza.zzg("CurrentSteps", Integer.valueOf(paramAchievement.getCurrentSteps()));
      localzza.zzg("TotalSteps", Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    return localzza.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Achievement freeze()
  {
    return this;
  }
  
  public String getAchievementId()
  {
    return this.zzaAE;
  }
  
  public int getCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return zzvg();
      bool = false;
    }
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return zzvh();
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
      zznn.zzb(this.zzaAN, paramCharArrayBuffer);
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
      return zzvf();
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
      zznn.zzb(this.zzaAK, paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.zzaAO;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.zzaAL;
  }
  
  public Uri getRevealedImageUri()
  {
    return this.zzaAH;
  }
  
  public String getRevealedImageUrl()
  {
    return this.zzaAI;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzaa(bool);
      return zzve();
      bool = false;
    }
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public Uri getUnlockedImageUri()
  {
    return this.zzaAF;
  }
  
  public String getUnlockedImageUrl()
  {
    return this.zzaAG;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public long getXpValue()
  {
    return this.zzaAP;
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
    AchievementEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public int zzve()
  {
    return this.zzaAJ;
  }
  
  public String zzvf()
  {
    return this.zzaAK;
  }
  
  public int zzvg()
  {
    return this.zzaAM;
  }
  
  public String zzvh()
  {
    return this.zzaAN;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */