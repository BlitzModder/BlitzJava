package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public abstract interface MetadataField<T>
{
  public abstract String getName();
  
  public abstract T zza(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public abstract void zza(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2);
  
  public abstract void zza(T paramT, Bundle paramBundle);
  
  public abstract T zzm(Bundle paramBundle);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/MetadataField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */