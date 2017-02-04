package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoj;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;
  
  public String getAlternateLink()
  {
    return (String)zza(zzof.zzaqP);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)zza(zzoj.zzarN);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public Date getCreatedDate()
  {
    return (Date)zza(zzoh.zzarG);
  }
  
  public Map<CustomPropertyKey, String> getCustomProperties()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)zza(zzof.zzaqQ);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.zzta();
  }
  
  public String getDescription()
  {
    return (String)zza(zzof.zzaqR);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)zza(zzof.zzaqO);
  }
  
  public String getEmbedLink()
  {
    return (String)zza(zzof.zzaqS);
  }
  
  public String getFileExtension()
  {
    return (String)zza(zzof.zzaqT);
  }
  
  public long getFileSize()
  {
    return ((Long)zza(zzof.zzaqU)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)zza(zzoh.zzarH);
  }
  
  public String getMimeType()
  {
    return (String)zza(zzof.zzarl);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)zza(zzoh.zzarJ);
  }
  
  public Date getModifiedDate()
  {
    return (Date)zza(zzoh.zzarI);
  }
  
  public String getOriginalFilename()
  {
    return (String)zza(zzof.zzarm);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)zza(zzof.zzarr)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)zza(zzoh.zzarK);
  }
  
  public String getTitle()
  {
    return (String)zza(zzof.zzaru);
  }
  
  public String getWebContentLink()
  {
    return (String)zza(zzof.zzarw);
  }
  
  public String getWebViewLink()
  {
    return (String)zza(zzof.zzarx);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzara);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isExplicitlyTrashed()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzarb);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isInAppFolder()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzaqY);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)zza(zzoj.zzarO);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzard);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzarf);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzarg);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzars);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashable()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzarj);
    if (localBoolean == null) {
      return true;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzarv);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)zza(zzof.zzark);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public abstract <T> T zza(MetadataField<T> paramMetadataField);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */