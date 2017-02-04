package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg
  implements zzf<Boolean>
{
  private Boolean zzasn = Boolean.valueOf(false);
  
  public static boolean zza(Filter paramFilter)
  {
    if (paramFilter == null) {
      return false;
    }
    return ((Boolean)paramFilter.zza(new zzg())).booleanValue();
  }
  
  public <T> Boolean zzc(zzb<T> paramzzb, T paramT)
  {
    return this.zzasn;
  }
  
  public <T> Boolean zzc(Operator paramOperator, MetadataField<T> paramMetadataField, T paramT)
  {
    return this.zzasn;
  }
  
  public Boolean zzc(Operator paramOperator, List<Boolean> paramList)
  {
    return this.zzasn;
  }
  
  public Boolean zzd(Boolean paramBoolean)
  {
    return this.zzasn;
  }
  
  public Boolean zzdb(String paramString)
  {
    if (!paramString.isEmpty()) {
      this.zzasn = Boolean.valueOf(true);
    }
    return this.zzasn;
  }
  
  public <T> Boolean zze(MetadataField<T> paramMetadataField, T paramT)
  {
    return this.zzasn;
  }
  
  public Boolean zzf(MetadataField<?> paramMetadataField)
  {
    return this.zzasn;
  }
  
  public Boolean zztp()
  {
    return this.zzasn;
  }
  
  public Boolean zztq()
  {
    return this.zzasn;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */