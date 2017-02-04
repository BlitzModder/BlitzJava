package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef
  extends MultiDataBufferRef
  implements AppContentAnnotation
{
  AppContentAnnotationRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 2, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentAnnotationEntity.zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("annotation_description");
  }
  
  public String getId()
  {
    return getString("annotation_id");
  }
  
  public String getTitle()
  {
    return getString("annotation_title");
  }
  
  public int hashCode()
  {
    return AppContentAnnotationEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentAnnotationEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentAnnotationEntity)zzvt()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzvn()
  {
    return getString("annotation_image_default_id");
  }
  
  public int zzvo()
  {
    return getInteger("annotation_image_height");
  }
  
  public Uri zzvp()
  {
    return zzcu("annotation_image_uri");
  }
  
  public Bundle zzvq()
  {
    return AppContentUtils.zzd(this.zzafC, this.zzaBi, "annotation_modifiers", this.zzahw);
  }
  
  public int zzvr()
  {
    return getInteger("annotation_image_width");
  }
  
  public String zzvs()
  {
    return getString("annotation_layout_slot");
  }
  
  public AppContentAnnotation zzvt()
  {
    return new AppContentAnnotationEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentAnnotationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */