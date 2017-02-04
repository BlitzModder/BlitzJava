package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzf
  extends zza<Integer>
{
  public zzf(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void zza(Bundle paramBundle, Integer paramInteger)
  {
    paramBundle.putInt(getName(), paramInteger.intValue());
  }
  
  protected Integer zzg(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramDataHolder.zzc(getName(), paramInt1, paramInt2));
  }
  
  protected Integer zzq(Bundle paramBundle)
  {
    return Integer.valueOf(paramBundle.getInt(getName()));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */