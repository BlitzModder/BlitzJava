package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzof;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
  final int mVersionCode;
  final Bundle zzaqL;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.mVersionCode = paramInt;
    this.zzaqL = ((Bundle)zzx.zzy(paramBundle));
    this.zzaqL.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = this.zzaqL.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (zze.zzcU(str) == null)
      {
        paramBundle.add(str);
        zzz.zzA("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      this.zzaqL.remove((String)localObject);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle zza(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = zztf();
    localMetadataBundle.zzb(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle zza(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.zzaqL));
  }
  
  public static MetadataBundle zztf()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    paramObject = (MetadataBundle)paramObject;
    Object localObject = this.zzaqL.keySet();
    if (!((Set)localObject).equals(((MetadataBundle)paramObject).zzaqL.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!zzw.equal(this.zzaqL.get(str), ((MetadataBundle)paramObject).zzaqL.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.zzaqL.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = this.zzaqL.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public void setContext(Context paramContext)
  {
    BitmapTeleporter localBitmapTeleporter = (BitmapTeleporter)zza(zzof.zzart);
    if (localBitmapTeleporter != null) {
      localBitmapTeleporter.zzc(paramContext.getCacheDir());
    }
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.zzaqL + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(MetadataField<T> paramMetadataField)
  {
    return (T)paramMetadataField.zzm(this.zzaqL);
  }
  
  public <T> void zzb(MetadataField<T> paramMetadataField, T paramT)
  {
    if (zze.zzcU(paramMetadataField.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
    }
    paramMetadataField.zza(paramT, this.zzaqL);
  }
  
  public boolean zzc(MetadataField<?> paramMetadataField)
  {
    return this.zzaqL.containsKey(paramMetadataField.getName());
  }
  
  public Set<MetadataField<?>> zztg()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.zzaqL.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(zze.zzcU((String)localIterator.next()));
    }
    return localHashSet;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */