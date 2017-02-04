package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity
  implements SafeParcelable, AppContentCard
{
  public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
  private final ArrayList<AppContentActionEntity> mActions;
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzIx;
  private final ArrayList<AppContentConditionEntity> zzaAQ;
  private final String zzaAR;
  private final ArrayList<AppContentAnnotationEntity> zzaBa;
  private final int zzaBb;
  private final String zzaBc;
  private final int zzaBd;
  private final String zzank;
  private final String zzavc;
  private final String zzxX;
  
  AppContentCardEntity(int paramInt1, ArrayList<AppContentActionEntity> paramArrayList, ArrayList<AppContentAnnotationEntity> paramArrayList1, ArrayList<AppContentConditionEntity> paramArrayList2, String paramString1, int paramInt2, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    this.mVersionCode = paramInt1;
    this.mActions = paramArrayList;
    this.zzaBa = paramArrayList1;
    this.zzaAQ = paramArrayList2;
    this.zzaAR = paramString1;
    this.zzaBb = paramInt2;
    this.zzavc = paramString2;
    this.mExtras = paramBundle;
    this.zzxX = paramString6;
    this.zzaBc = paramString3;
    this.zzank = paramString4;
    this.zzaBd = paramInt3;
    this.zzIx = paramString5;
  }
  
  public AppContentCardEntity(AppContentCard paramAppContentCard)
  {
    this.mVersionCode = 4;
    this.zzaAR = paramAppContentCard.zzvk();
    this.zzaBb = paramAppContentCard.zzvv();
    this.zzavc = paramAppContentCard.getDescription();
    this.mExtras = paramAppContentCard.getExtras();
    this.zzxX = paramAppContentCard.getId();
    this.zzank = paramAppContentCard.getTitle();
    this.zzaBc = paramAppContentCard.zzvw();
    this.zzaBd = paramAppContentCard.zzvx();
    this.zzIx = paramAppContentCard.getType();
    List localList = paramAppContentCard.getActions();
    int k = localList.size();
    this.mActions = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList.get(i)).freeze());
      i += 1;
    }
    localList = paramAppContentCard.zzvu();
    k = localList.size();
    this.zzaBa = new ArrayList(k);
    i = 0;
    while (i < k)
    {
      this.zzaBa.add((AppContentAnnotationEntity)((AppContentAnnotation)localList.get(i)).freeze());
      i += 1;
    }
    paramAppContentCard = paramAppContentCard.zzvj();
    k = paramAppContentCard.size();
    this.zzaAQ = new ArrayList(k);
    i = j;
    while (i < k)
    {
      this.zzaAQ.add((AppContentConditionEntity)((AppContentCondition)paramAppContentCard.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentCard paramAppContentCard)
  {
    return zzw.hashCode(new Object[] { paramAppContentCard.getActions(), paramAppContentCard.zzvu(), paramAppContentCard.zzvj(), paramAppContentCard.zzvk(), Integer.valueOf(paramAppContentCard.zzvv()), paramAppContentCard.getDescription(), paramAppContentCard.getExtras(), paramAppContentCard.getId(), paramAppContentCard.zzvw(), paramAppContentCard.getTitle(), Integer.valueOf(paramAppContentCard.zzvx()), paramAppContentCard.getType() });
  }
  
  static boolean zza(AppContentCard paramAppContentCard, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentCard)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentCard == paramObject);
      paramObject = (AppContentCard)paramObject;
      if ((!zzw.equal(((AppContentCard)paramObject).getActions(), paramAppContentCard.getActions())) || (!zzw.equal(((AppContentCard)paramObject).zzvu(), paramAppContentCard.zzvu())) || (!zzw.equal(((AppContentCard)paramObject).zzvj(), paramAppContentCard.zzvj())) || (!zzw.equal(((AppContentCard)paramObject).zzvk(), paramAppContentCard.zzvk())) || (!zzw.equal(Integer.valueOf(((AppContentCard)paramObject).zzvv()), Integer.valueOf(paramAppContentCard.zzvv()))) || (!zzw.equal(((AppContentCard)paramObject).getDescription(), paramAppContentCard.getDescription())) || (!zzw.equal(((AppContentCard)paramObject).getExtras(), paramAppContentCard.getExtras())) || (!zzw.equal(((AppContentCard)paramObject).getId(), paramAppContentCard.getId())) || (!zzw.equal(((AppContentCard)paramObject).zzvw(), paramAppContentCard.zzvw())) || (!zzw.equal(((AppContentCard)paramObject).getTitle(), paramAppContentCard.getTitle())) || (!zzw.equal(Integer.valueOf(((AppContentCard)paramObject).zzvx()), Integer.valueOf(paramAppContentCard.zzvx())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentCard)paramObject).getType(), paramAppContentCard.getType()));
    return false;
  }
  
  static String zzb(AppContentCard paramAppContentCard)
  {
    return zzw.zzx(paramAppContentCard).zzg("Actions", paramAppContentCard.getActions()).zzg("Annotations", paramAppContentCard.zzvu()).zzg("Conditions", paramAppContentCard.zzvj()).zzg("ContentDescription", paramAppContentCard.zzvk()).zzg("CurrentSteps", Integer.valueOf(paramAppContentCard.zzvv())).zzg("Description", paramAppContentCard.getDescription()).zzg("Extras", paramAppContentCard.getExtras()).zzg("Id", paramAppContentCard.getId()).zzg("Subtitle", paramAppContentCard.zzvw()).zzg("Title", paramAppContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(paramAppContentCard.zzvx())).zzg("Type", paramAppContentCard.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public List<AppContentAction> getActions()
  {
    return new ArrayList(this.mActions);
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public String getType()
  {
    return this.zzIx;
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
    AppContentCardEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public List<AppContentCondition> zzvj()
  {
    return new ArrayList(this.zzaAQ);
  }
  
  public String zzvk()
  {
    return this.zzaAR;
  }
  
  public List<AppContentAnnotation> zzvu()
  {
    return new ArrayList(this.zzaBa);
  }
  
  public int zzvv()
  {
    return this.zzaBb;
  }
  
  public String zzvw()
  {
    return this.zzaBc;
  }
  
  public int zzvx()
  {
    return this.zzaBd;
  }
  
  public AppContentCard zzvy()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentCardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */