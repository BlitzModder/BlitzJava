package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zznn;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final Parcelable.Creator<QuestEntity> CREATOR = new QuestEntityCreator();
  private final String mName;
  private final int mState;
  private final int mVersionCode;
  private final int zzZU;
  private final long zzaAO;
  private final GameEntity zzaGU;
  private final String zzaHM;
  private final long zzaHN;
  private final Uri zzaHO;
  private final String zzaHP;
  private final long zzaHQ;
  private final Uri zzaHR;
  private final String zzaHS;
  private final long zzaHT;
  private final long zzaHU;
  private final ArrayList<MilestoneEntity> zzaHV;
  private final String zzavc;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.mVersionCode = paramInt1;
    this.zzaGU = paramGameEntity;
    this.zzaHM = paramString1;
    this.zzaHN = paramLong1;
    this.zzaHO = paramUri1;
    this.zzaHP = paramString2;
    this.zzavc = paramString3;
    this.zzaHQ = paramLong2;
    this.zzaAO = paramLong3;
    this.zzaHR = paramUri2;
    this.zzaHS = paramString4;
    this.mName = paramString5;
    this.zzaHT = paramLong4;
    this.zzaHU = paramLong5;
    this.mState = paramInt2;
    this.zzZU = paramInt3;
    this.zzaHV = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.mVersionCode = 2;
    this.zzaGU = new GameEntity(paramQuest.getGame());
    this.zzaHM = paramQuest.getQuestId();
    this.zzaHN = paramQuest.getAcceptedTimestamp();
    this.zzavc = paramQuest.getDescription();
    this.zzaHO = paramQuest.getBannerImageUri();
    this.zzaHP = paramQuest.getBannerImageUrl();
    this.zzaHQ = paramQuest.getEndTimestamp();
    this.zzaHR = paramQuest.getIconImageUri();
    this.zzaHS = paramQuest.getIconImageUrl();
    this.zzaAO = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.zzaHT = paramQuest.zzxl();
    this.zzaHU = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.zzZU = paramQuest.getType();
    paramQuest = paramQuest.zzxk();
    int j = paramQuest.size();
    this.zzaHV = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzaHV.add((MilestoneEntity)((Milestone)paramQuest.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(Quest paramQuest)
  {
    return zzw.hashCode(new Object[] { paramQuest.getGame(), paramQuest.getQuestId(), Long.valueOf(paramQuest.getAcceptedTimestamp()), paramQuest.getBannerImageUri(), paramQuest.getDescription(), Long.valueOf(paramQuest.getEndTimestamp()), paramQuest.getIconImageUri(), Long.valueOf(paramQuest.getLastUpdatedTimestamp()), paramQuest.zzxk(), paramQuest.getName(), Long.valueOf(paramQuest.zzxl()), Long.valueOf(paramQuest.getStartTimestamp()), Integer.valueOf(paramQuest.getState()) });
  }
  
  static boolean zza(Quest paramQuest, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Quest)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramQuest == paramObject);
      paramObject = (Quest)paramObject;
      if ((!zzw.equal(((Quest)paramObject).getGame(), paramQuest.getGame())) || (!zzw.equal(((Quest)paramObject).getQuestId(), paramQuest.getQuestId())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!zzw.equal(((Quest)paramObject).getBannerImageUri(), paramQuest.getBannerImageUri())) || (!zzw.equal(((Quest)paramObject).getDescription(), paramQuest.getDescription())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!zzw.equal(((Quest)paramObject).getIconImageUri(), paramQuest.getIconImageUri())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!zzw.equal(((Quest)paramObject).zzxk(), paramQuest.zzxk())) || (!zzw.equal(((Quest)paramObject).getName(), paramQuest.getName())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).zzxl()), Long.valueOf(paramQuest.zzxl()))) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Integer.valueOf(((Quest)paramObject).getState()), Integer.valueOf(paramQuest.getState())));
    return false;
  }
  
  static String zzb(Quest paramQuest)
  {
    return zzw.zzx(paramQuest).zzg("Game", paramQuest.getGame()).zzg("QuestId", paramQuest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).zzg("BannerImageUri", paramQuest.getBannerImageUri()).zzg("BannerImageUrl", paramQuest.getBannerImageUrl()).zzg("Description", paramQuest.getDescription()).zzg("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).zzg("IconImageUri", paramQuest.getIconImageUri()).zzg("IconImageUrl", paramQuest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).zzg("Milestones", paramQuest.zzxk()).zzg("Name", paramQuest.getName()).zzg("NotifyTimestamp", Long.valueOf(paramQuest.zzxl())).zzg("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).zzg("State", Integer.valueOf(paramQuest.getState())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Quest freeze()
  {
    return this;
  }
  
  public long getAcceptedTimestamp()
  {
    return this.zzaHN;
  }
  
  public Uri getBannerImageUri()
  {
    return this.zzaHO;
  }
  
  public String getBannerImageUrl()
  {
    return this.zzaHP;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)zzxk().get(0);
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.zzaHQ;
  }
  
  public Game getGame()
  {
    return this.zzaGU;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzaHR;
  }
  
  public String getIconImageUrl()
  {
    return this.zzaHS;
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
  
  public String getQuestId()
  {
    return this.zzaHM;
  }
  
  public long getStartTimestamp()
  {
    return this.zzaHU;
  }
  
  public int getState()
  {
    return this.mState;
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
  
  public boolean isEndingSoon()
  {
    return this.zzaHT <= System.currentTimeMillis() + 1800000L;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QuestEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public List<Milestone> zzxk()
  {
    return new ArrayList(this.zzaHV);
  }
  
  public long zzxl()
  {
    return this.zzaHT;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/quest/QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */