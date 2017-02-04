package com.google.android.gms.measurement;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzb
  implements zzi
{
  private static final Uri zzaRh;
  private final LogPrinter zzaRi = new LogPrinter(4, "GA/LogCatTransport");
  
  static
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("local");
    zzaRh = localBuilder.build();
  }
  
  public void zzb(zzc paramzzc)
  {
    Object localObject = new ArrayList(paramzzc.zzzF());
    Collections.sort((List)localObject, new Comparator()
    {
      public int zza(zze paramAnonymouszze1, zze paramAnonymouszze2)
      {
        return paramAnonymouszze1.getClass().getCanonicalName().compareTo(paramAnonymouszze2.getClass().getCanonicalName());
      }
    });
    paramzzc = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((zze)((Iterator)localObject).next()).toString();
      if (!TextUtils.isEmpty(str))
      {
        if (paramzzc.length() != 0) {
          paramzzc.append(", ");
        }
        paramzzc.append(str);
      }
    }
    this.zzaRi.println(paramzzc.toString());
  }
  
  public Uri zzii()
  {
    return zzaRh;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */