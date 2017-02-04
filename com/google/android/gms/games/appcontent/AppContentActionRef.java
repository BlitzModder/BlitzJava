package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef
  extends MultiDataBufferRef
  implements AppContentAction
{
  AppContentActionRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 1, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentActionEntity.zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return AppContentUtils.zzd(this.zzafC, this.zzaBi, "action_data", this.zzahw);
  }
  
  public String getId()
  {
    return getString("action_id");
  }
  
  public String getType()
  {
    return getString("action_type");
  }
  
  public int hashCode()
  {
    return AppContentActionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentActionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentActionEntity)zzvm()).writeToParcel(paramParcel, paramInt);
  }
  
  public AppContentAnnotation zzvi()
  {
    ArrayList localArrayList = AppContentUtils.zzb(this.zzafC, this.zzaBi, "action_annotation", this.zzahw);
    if (localArrayList.size() == 1) {
      return (AppContentAnnotation)localArrayList.get(0);
    }
    return null;
  }
  
  public List<AppContentCondition> zzvj()
  {
    return AppContentUtils.zzc(this.zzafC, this.zzaBi, "action_conditions", this.zzahw);
  }
  
  public String zzvk()
  {
    return getString("action_content_description");
  }
  
  public String zzvl()
  {
    return getString("overflow_text");
  }
  
  public AppContentAction zzvm()
  {
    return new AppContentActionEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentActionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */