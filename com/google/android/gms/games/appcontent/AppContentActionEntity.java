package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity
  implements SafeParcelable, AppContentAction
{
  public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzIx;
  private final ArrayList<AppContentConditionEntity> zzaAQ;
  private final String zzaAR;
  private final AppContentAnnotationEntity zzaAS;
  private final String zzaAT;
  private final String zzxX;
  
  AppContentActionEntity(int paramInt, ArrayList<AppContentConditionEntity> paramArrayList, String paramString1, Bundle paramBundle, String paramString2, String paramString3, AppContentAnnotationEntity paramAppContentAnnotationEntity, String paramString4)
  {
    this.mVersionCode = paramInt;
    this.zzaAS = paramAppContentAnnotationEntity;
    this.zzaAQ = paramArrayList;
    this.zzaAR = paramString1;
    this.mExtras = paramBundle;
    this.zzxX = paramString3;
    this.zzaAT = paramString4;
    this.zzIx = paramString2;
  }
  
  public AppContentActionEntity(AppContentAction paramAppContentAction)
  {
    this.mVersionCode = 5;
    this.zzaAS = ((AppContentAnnotationEntity)paramAppContentAction.zzvi().freeze());
    this.zzaAR = paramAppContentAction.zzvk();
    this.mExtras = paramAppContentAction.getExtras();
    this.zzxX = paramAppContentAction.getId();
    this.zzaAT = paramAppContentAction.zzvl();
    this.zzIx = paramAppContentAction.getType();
    paramAppContentAction = paramAppContentAction.zzvj();
    int j = paramAppContentAction.size();
    this.zzaAQ = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzaAQ.add((AppContentConditionEntity)((AppContentCondition)paramAppContentAction.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentAction paramAppContentAction)
  {
    return zzw.hashCode(new Object[] { paramAppContentAction.zzvi(), paramAppContentAction.zzvj(), paramAppContentAction.zzvk(), paramAppContentAction.getExtras(), paramAppContentAction.getId(), paramAppContentAction.zzvl(), paramAppContentAction.getType() });
  }
  
  static boolean zza(AppContentAction paramAppContentAction, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentAction)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentAction == paramObject);
      paramObject = (AppContentAction)paramObject;
      if ((!zzw.equal(((AppContentAction)paramObject).zzvi(), paramAppContentAction.zzvi())) || (!zzw.equal(((AppContentAction)paramObject).zzvj(), paramAppContentAction.zzvj())) || (!zzw.equal(((AppContentAction)paramObject).zzvk(), paramAppContentAction.zzvk())) || (!zzw.equal(((AppContentAction)paramObject).getExtras(), paramAppContentAction.getExtras())) || (!zzw.equal(((AppContentAction)paramObject).getId(), paramAppContentAction.getId())) || (!zzw.equal(((AppContentAction)paramObject).zzvl(), paramAppContentAction.zzvl()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentAction)paramObject).getType(), paramAppContentAction.getType()));
    return false;
  }
  
  static String zzb(AppContentAction paramAppContentAction)
  {
    return zzw.zzx(paramAppContentAction).zzg("Annotation", paramAppContentAction.zzvi()).zzg("Conditions", paramAppContentAction.zzvj()).zzg("ContentDescription", paramAppContentAction.zzvk()).zzg("Extras", paramAppContentAction.getExtras()).zzg("Id", paramAppContentAction.getId()).zzg("OverflowText", paramAppContentAction.zzvl()).zzg("Type", paramAppContentAction.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getId()
  {
    return this.zzxX;
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
    AppContentActionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public AppContentAnnotation zzvi()
  {
    return this.zzaAS;
  }
  
  public List<AppContentCondition> zzvj()
  {
    return new ArrayList(this.zzaAQ);
  }
  
  public String zzvk()
  {
    return this.zzaAR;
  }
  
  public String zzvl()
  {
    return this.zzaAT;
  }
  
  public AppContentAction zzvm()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentActionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */