package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp
  extends Metadata
{
  private final MetadataBundle zzaoy;
  
  public zzp(MetadataBundle paramMetadataBundle)
  {
    this.zzaoy = paramMetadataBundle;
  }
  
  public boolean isDataValid()
  {
    return this.zzaoy != null;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.zzaoy + "]";
  }
  
  public <T> T zza(MetadataField<T> paramMetadataField)
  {
    return (T)this.zzaoy.zza(paramMetadataField);
  }
  
  public Metadata zzso()
  {
    return new zzp(MetadataBundle.zza(this.zzaoy));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */