package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef
  extends MultiDataBufferRef
  implements AppContentCondition
{
  AppContentConditionRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 4, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentConditionEntity.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return AppContentConditionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentConditionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentConditionEntity)zzvD()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzvA()
  {
    return getString("condition_expected_value");
  }
  
  public String zzvB()
  {
    return getString("condition_predicate");
  }
  
  public Bundle zzvC()
  {
    return AppContentUtils.zzd(this.zzafC, this.zzaBi, "condition_predicate_parameters", this.zzahw);
  }
  
  public AppContentCondition zzvD()
  {
    return new AppContentConditionEntity(this);
  }
  
  public String zzvz()
  {
    return getString("condition_default_value");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentConditionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */