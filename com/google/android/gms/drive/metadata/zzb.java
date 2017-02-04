package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

public abstract class zzb<T>
  extends zza<Collection<T>>
{
  protected zzb(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    super(paramString, paramCollection1, paramCollection2, paramInt);
  }
  
  protected Collection<T> zzd(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */