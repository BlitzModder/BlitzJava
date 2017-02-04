package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import java.util.Date;

public class SearchableField
{
  public static final SearchableMetadataField<Boolean> IS_PINNED = zzof.zzard;
  public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SearchableMetadataField<String> MIME_TYPE;
  public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
  public static final SearchableCollectionMetadataField<DriveId> PARENTS;
  public static final SearchableMetadataField<Boolean> STARRED;
  public static final SearchableMetadataField<String> TITLE = zzof.zzaru;
  public static final SearchableMetadataField<Boolean> TRASHED;
  public static final SearchableOrderedMetadataField<Date> zzarV;
  public static final SearchableMetadataField<AppVisibleCustomProperties> zzarW = zzof.zzaqQ;
  
  static
  {
    MIME_TYPE = zzof.zzarl;
    TRASHED = zzof.zzarv;
    PARENTS = zzof.zzarq;
    zzarV = zzoh.zzarK;
    STARRED = zzof.zzars;
    MODIFIED_DATE = zzoh.zzarI;
    LAST_VIEWED_BY_ME = zzoh.zzarH;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/SearchableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */