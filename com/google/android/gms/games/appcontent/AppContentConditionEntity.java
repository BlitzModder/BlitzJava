package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class AppContentConditionEntity
  implements SafeParcelable, AppContentCondition
{
  public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
  private final int mVersionCode;
  private final String zzaBe;
  private final String zzaBf;
  private final String zzaBg;
  private final Bundle zzaBh;
  
  AppContentConditionEntity(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    this.mVersionCode = paramInt;
    this.zzaBe = paramString1;
    this.zzaBf = paramString2;
    this.zzaBg = paramString3;
    this.zzaBh = paramBundle;
  }
  
  public AppContentConditionEntity(AppContentCondition paramAppContentCondition)
  {
    this.mVersionCode = 1;
    this.zzaBe = paramAppContentCondition.zzvz();
    this.zzaBf = paramAppContentCondition.zzvA();
    this.zzaBg = paramAppContentCondition.zzvB();
    this.zzaBh = paramAppContentCondition.zzvC();
  }
  
  static int zza(AppContentCondition paramAppContentCondition)
  {
    return zzw.hashCode(new Object[] { paramAppContentCondition.zzvz(), paramAppContentCondition.zzvA(), paramAppContentCondition.zzvB(), paramAppContentCondition.zzvC() });
  }
  
  static boolean zza(AppContentCondition paramAppContentCondition, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentCondition)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentCondition == paramObject);
      paramObject = (AppContentCondition)paramObject;
      if ((!zzw.equal(((AppContentCondition)paramObject).zzvz(), paramAppContentCondition.zzvz())) || (!zzw.equal(((AppContentCondition)paramObject).zzvA(), paramAppContentCondition.zzvA())) || (!zzw.equal(((AppContentCondition)paramObject).zzvB(), paramAppContentCondition.zzvB()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentCondition)paramObject).zzvC(), paramAppContentCondition.zzvC()));
    return false;
  }
  
  static String zzb(AppContentCondition paramAppContentCondition)
  {
    return zzw.zzx(paramAppContentCondition).zzg("DefaultValue", paramAppContentCondition.zzvz()).zzg("ExpectedValue", paramAppContentCondition.zzvA()).zzg("Predicate", paramAppContentCondition.zzvB()).zzg("PredicateParameters", paramAppContentCondition.zzvC()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
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
    AppContentConditionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzvA()
  {
    return this.zzaBf;
  }
  
  public String zzvB()
  {
    return this.zzaBg;
  }
  
  public Bundle zzvC()
  {
    return this.zzaBh;
  }
  
  public AppContentCondition zzvD()
  {
    return this;
  }
  
  public String zzvz()
  {
    return this.zzaBe;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentConditionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */