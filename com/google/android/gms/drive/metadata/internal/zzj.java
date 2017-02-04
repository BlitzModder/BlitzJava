package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzj<T extends Parcelable>
  extends zza<T>
{
  public zzj(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    super(paramString, paramCollection1, paramCollection2, paramInt);
  }
  
  protected void zza(Bundle paramBundle, T paramT)
  {
    paramBundle.putParcelable(getName(), paramT);
  }
  
  protected T zzt(Bundle paramBundle)
  {
    return paramBundle.getParcelable(getName());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */