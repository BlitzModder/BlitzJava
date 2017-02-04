package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import java.util.Date;

public class SortableField
{
  public static final SortableMetadataField<Date> CREATED_DATE;
  public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
  public static final SortableMetadataField<Date> MODIFIED_DATE;
  public static final SortableMetadataField<Long> QUOTA_USED = zzof.zzarr;
  public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
  public static final SortableMetadataField<String> TITLE = zzof.zzaru;
  public static final SortableMetadataField<Date> zzarZ = zzoh.zzarL;
  
  static
  {
    CREATED_DATE = zzoh.zzarG;
    MODIFIED_DATE = zzoh.zzarI;
    MODIFIED_BY_ME_DATE = zzoh.zzarJ;
    LAST_VIEWED_BY_ME = zzoh.zzarH;
    SHARED_WITH_ME_DATE = zzoh.zzarK;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/SortableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */