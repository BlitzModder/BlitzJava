package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.zzd;
import java.util.Date;

public class zzoh
{
  public static final zza zzarG = new zza("created", 4100000);
  public static final zzb zzarH = new zzb("lastOpenedTime", 4300000);
  public static final zzd zzarI = new zzd("modified", 4100000);
  public static final zzc zzarJ = new zzc("modifiedByMe", 4100000);
  public static final zzf zzarK = new zzf("sharedWithMe", 4100000);
  public static final zze zzarL = new zze("recency", 8000000);
  
  public static class zza
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zza(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzb
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzb(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzc
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zzc(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzd
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzd(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zze
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zze(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzf
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzf(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */