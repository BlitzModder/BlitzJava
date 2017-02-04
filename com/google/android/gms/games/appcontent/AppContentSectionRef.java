package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionRef
  extends MultiDataBufferRef
  implements AppContentSection
{
  private final int zzaBl;
  
  AppContentSectionRef(ArrayList<DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    super(paramArrayList, 0, paramInt1);
    this.zzaBl = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentSectionEntity.zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return AppContentUtils.zzd(this.zzafC, this.zzaBi, "section_data", this.zzahw);
  }
  
  public String getId()
  {
    return getString("section_id");
  }
  
  public String getTitle()
  {
    return getString("section_title");
  }
  
  public String getType()
  {
    return getString("section_type");
  }
  
  public int hashCode()
  {
    return AppContentSectionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentSectionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentSectionEntity)zzvG()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzvF()
  {
    return getString("section_card_type");
  }
  
  public AppContentSection zzvG()
  {
    return new AppContentSectionEntity(this);
  }
  
  public ArrayList<AppContentAction> zzvH()
  {
    return AppContentUtils.zza(this.zzafC, this.zzaBi, "section_actions", this.zzahw);
  }
  
  public ArrayList<AppContentAnnotation> zzvI()
  {
    return AppContentUtils.zzb(this.zzafC, this.zzaBi, "section_annotations", this.zzahw);
  }
  
  public ArrayList<AppContentCard> zzvJ()
  {
    ArrayList localArrayList = new ArrayList(this.zzaBl);
    int i = 0;
    while (i < this.zzaBl)
    {
      localArrayList.add(new AppContentCardRef(this.zzaBi, this.zzahw + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public String zzvk()
  {
    return getString("section_content_description");
  }
  
  public String zzvw()
  {
    return getString("section_subtitle");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentSectionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */