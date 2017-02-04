package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class InFilter<T>
  extends AbstractFilter
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final MetadataBundle zzasb;
  private final zzb<T> zzaso;
  
  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzasb = paramMetadataBundle;
    this.zzaso = ((zzb)zze.zzb(paramMetadataBundle));
  }
  
  public InFilter(SearchableCollectionMetadataField<T> paramSearchableCollectionMetadataField, T paramT)
  {
    this(1, MetadataBundle.zza(paramSearchableCollectionMetadataField, Collections.singleton(paramT)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return (T)((Collection)this.zzasb.zza(this.zzaso)).iterator().next();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzb(this.zzaso, getValue());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/InFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */