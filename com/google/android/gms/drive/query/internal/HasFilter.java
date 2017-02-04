package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T>
  extends AbstractFilter
{
  public static final zzi CREATOR = new zzi();
  final int mVersionCode;
  final MetadataBundle zzasb;
  final MetadataField<T> zzasc;
  
  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzasb = paramMetadataBundle;
    this.zzasc = zze.zzb(paramMetadataBundle);
  }
  
  public HasFilter(SearchableMetadataField<T> paramSearchableMetadataField, T paramT)
  {
    this(1, MetadataBundle.zza(paramSearchableMetadataField, paramT));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return (T)this.zzasb.zza(this.zzasc);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzd(this.zzasc, getValue());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/HasFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */