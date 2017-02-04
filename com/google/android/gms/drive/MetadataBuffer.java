package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzof;
import java.util.Collection;
import java.util.Iterator;

public final class MetadataBuffer
  extends AbstractDataBuffer<Metadata>
{
  private zza zzanf;
  
  public MetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    paramDataHolder.zzpH().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    zza localzza2 = this.zzanf;
    zza localzza1;
    if (localzza2 != null)
    {
      localzza1 = localzza2;
      if (zza.zza(localzza2) == paramInt) {}
    }
    else
    {
      localzza1 = new zza(this.zzafC, paramInt);
      this.zzanf = localzza1;
    }
    return localzza1;
  }
  
  @Deprecated
  public String getNextPageToken()
  {
    return null;
  }
  
  public void release()
  {
    if (this.zzafC != null) {
      zze.zza(this.zzafC);
    }
    super.release();
  }
  
  private static class zza
    extends Metadata
  {
    private final DataHolder zzafC;
    private final int zzahx;
    private final int zzang;
    
    public zza(DataHolder paramDataHolder, int paramInt)
    {
      this.zzafC = paramDataHolder;
      this.zzang = paramInt;
      this.zzahx = paramDataHolder.zzbI(paramInt);
    }
    
    public boolean isDataValid()
    {
      return !this.zzafC.isClosed();
    }
    
    public <T> T zza(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.zza(this.zzafC, this.zzang, this.zzahx);
    }
    
    public Metadata zzso()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.zztf();
      Iterator localIterator = zze.zztd().iterator();
      while (localIterator.hasNext())
      {
        MetadataField localMetadataField = (MetadataField)localIterator.next();
        if (localMetadataField != zzof.zzart) {
          localMetadataField.zza(this.zzafC, localMetadataBundle, this.zzang, this.zzahx);
        }
      }
      return new zzp(localMetadataBundle);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */