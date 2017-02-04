package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity
  implements SafeParcelable, AppContentSection
{
  public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
  private final ArrayList<AppContentActionEntity> mActions;
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzIx;
  private final String zzaAR;
  private final ArrayList<AppContentAnnotationEntity> zzaBa;
  private final String zzaBc;
  private final ArrayList<AppContentCardEntity> zzaBj;
  private final String zzaBk;
  private final String zzank;
  private final String zzxX;
  
  AppContentSectionEntity(int paramInt, ArrayList<AppContentActionEntity> paramArrayList, ArrayList<AppContentCardEntity> paramArrayList1, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<AppContentAnnotationEntity> paramArrayList2)
  {
    this.mVersionCode = paramInt;
    this.mActions = paramArrayList;
    this.zzaBa = paramArrayList2;
    this.zzaBj = paramArrayList1;
    this.zzaBk = paramString6;
    this.zzaAR = paramString1;
    this.mExtras = paramBundle;
    this.zzxX = paramString5;
    this.zzaBc = paramString2;
    this.zzank = paramString3;
    this.zzIx = paramString4;
  }
  
  public AppContentSectionEntity(AppContentSection paramAppContentSection)
  {
    this.mVersionCode = 5;
    this.zzaBk = paramAppContentSection.zzvF();
    this.zzaAR = paramAppContentSection.zzvk();
    this.mExtras = paramAppContentSection.getExtras();
    this.zzxX = paramAppContentSection.getId();
    this.zzaBc = paramAppContentSection.zzvw();
    this.zzank = paramAppContentSection.getTitle();
    this.zzIx = paramAppContentSection.getType();
    List localList = paramAppContentSection.getActions();
    int k = localList.size();
    this.mActions = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList.get(i)).freeze());
      i += 1;
    }
    localList = paramAppContentSection.zzvE();
    k = localList.size();
    this.zzaBj = new ArrayList(k);
    i = 0;
    while (i < k)
    {
      this.zzaBj.add((AppContentCardEntity)((AppContentCard)localList.get(i)).freeze());
      i += 1;
    }
    paramAppContentSection = paramAppContentSection.zzvu();
    k = paramAppContentSection.size();
    this.zzaBa = new ArrayList(k);
    i = j;
    while (i < k)
    {
      this.zzaBa.add((AppContentAnnotationEntity)((AppContentAnnotation)paramAppContentSection.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentSection paramAppContentSection)
  {
    return zzw.hashCode(new Object[] { paramAppContentSection.getActions(), paramAppContentSection.zzvu(), paramAppContentSection.zzvE(), paramAppContentSection.zzvF(), paramAppContentSection.zzvk(), paramAppContentSection.getExtras(), paramAppContentSection.getId(), paramAppContentSection.zzvw(), paramAppContentSection.getTitle(), paramAppContentSection.getType() });
  }
  
  static boolean zza(AppContentSection paramAppContentSection, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentSection)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentSection == paramObject);
      paramObject = (AppContentSection)paramObject;
      if ((!zzw.equal(((AppContentSection)paramObject).getActions(), paramAppContentSection.getActions())) || (!zzw.equal(((AppContentSection)paramObject).zzvu(), paramAppContentSection.zzvu())) || (!zzw.equal(((AppContentSection)paramObject).zzvE(), paramAppContentSection.zzvE())) || (!zzw.equal(((AppContentSection)paramObject).zzvF(), paramAppContentSection.zzvF())) || (!zzw.equal(((AppContentSection)paramObject).zzvk(), paramAppContentSection.zzvk())) || (!zzw.equal(((AppContentSection)paramObject).getExtras(), paramAppContentSection.getExtras())) || (!zzw.equal(((AppContentSection)paramObject).getId(), paramAppContentSection.getId())) || (!zzw.equal(((AppContentSection)paramObject).zzvw(), paramAppContentSection.zzvw())) || (!zzw.equal(((AppContentSection)paramObject).getTitle(), paramAppContentSection.getTitle()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentSection)paramObject).getType(), paramAppContentSection.getType()));
    return false;
  }
  
  static String zzb(AppContentSection paramAppContentSection)
  {
    return zzw.zzx(paramAppContentSection).zzg("Actions", paramAppContentSection.getActions()).zzg("Annotations", paramAppContentSection.zzvu()).zzg("Cards", paramAppContentSection.zzvE()).zzg("CardType", paramAppContentSection.zzvF()).zzg("ContentDescription", paramAppContentSection.zzvk()).zzg("Extras", paramAppContentSection.getExtras()).zzg("Id", paramAppContentSection.getId()).zzg("Subtitle", paramAppContentSection.zzvw()).zzg("Title", paramAppContentSection.getTitle()).zzg("Type", paramAppContentSection.getType()).toString();
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
    AppContentSectionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public List<AppContentCard> zzvE()
  {
    return new ArrayList(this.zzaBj);
  }
  
  public String zzvF()
  {
    return this.zzaBk;
  }
  
  public AppContentSection zzvG()
  {
    return this;
  }
  
  public String zzvk()
  {
    return this.zzaAR;
  }
  
  public List<AppContentAnnotation> zzvu()
  {
    return new ArrayList(this.zzaBa);
  }
  
  public String zzvw()
  {
    return this.zzaBc;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentSectionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */