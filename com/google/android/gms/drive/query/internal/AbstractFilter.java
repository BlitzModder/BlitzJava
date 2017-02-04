package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.zzc;

public abstract class AbstractFilter
  implements Filter
{
  public String toString()
  {
    return String.format("Filter[%s]", new Object[] { zza(new zzc()) });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/AbstractFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */