package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class zza<T>
  implements MetadataField<T>
{
  private final String zzaqA;
  private final Set<String> zzaqB;
  private final Set<String> zzaqC;
  private final int zzaqD;
  
  protected zza(String paramString, int paramInt)
  {
    this.zzaqA = ((String)zzx.zzb(paramString, "fieldName"));
    this.zzaqB = Collections.singleton(paramString);
    this.zzaqC = Collections.emptySet();
    this.zzaqD = paramInt;
  }
  
  protected zza(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    this.zzaqA = ((String)zzx.zzb(paramString, "fieldName"));
    this.zzaqB = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.zzaqC = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.zzaqD = paramInt;
  }
  
  public final String getName()
  {
    return this.zzaqA;
  }
  
  public String toString()
  {
    return this.zzaqA;
  }
  
  public final T zza(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    if (zzb(paramDataHolder, paramInt1, paramInt2)) {
      return (T)zzc(paramDataHolder, paramInt1, paramInt2);
    }
    return null;
  }
  
  protected abstract void zza(Bundle paramBundle, T paramT);
  
  public final void zza(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    zzx.zzb(paramDataHolder, "dataHolder");
    zzx.zzb(paramMetadataBundle, "bundle");
    if (zzb(paramDataHolder, paramInt1, paramInt2)) {
      paramMetadataBundle.zzb(this, zzc(paramDataHolder, paramInt1, paramInt2));
    }
  }
  
  public final void zza(T paramT, Bundle paramBundle)
  {
    zzx.zzb(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    zza(paramBundle, paramT);
  }
  
  protected boolean zzb(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzaqB.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!paramDataHolder.zzct(str)) || (paramDataHolder.zzi(str, paramInt1, paramInt2))) {
        return false;
      }
    }
    return true;
  }
  
  protected abstract T zzc(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final T zzm(Bundle paramBundle)
  {
    zzx.zzb(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)zzn(paramBundle);
    }
    return null;
  }
  
  protected abstract T zzn(Bundle paramBundle);
  
  public final Collection<String> zzsZ()
  {
    return this.zzaqB;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */