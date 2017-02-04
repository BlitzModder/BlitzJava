package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public class zzb
  extends zza<Boolean>
{
  public zzb(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public zzb(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    super(paramString, paramCollection1, paramCollection2, paramInt);
  }
  
  protected void zza(Bundle paramBundle, Boolean paramBoolean)
  {
    paramBundle.putBoolean(getName(), paramBoolean.booleanValue());
  }
  
  protected Boolean zze(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Boolean.valueOf(paramDataHolder.zze(getName(), paramInt1, paramInt2));
  }
  
  protected Boolean zzo(Bundle paramBundle)
  {
    return Boolean.valueOf(paramBundle.getBoolean(getName()));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */