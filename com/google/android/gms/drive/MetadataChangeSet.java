package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet
{
  public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
  public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
  public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
  public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
  public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
  public static final MetadataChangeSet zzanh = new MetadataChangeSet(MetadataBundle.zztf());
  private final MetadataBundle zzani;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.zzani = MetadataBundle.zza(paramMetadataBundle);
  }
  
  public Map<CustomPropertyKey, String> getCustomPropertyChangeMap()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)this.zzani.zza(zzof.zzaqQ);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.zzta();
  }
  
  public String getDescription()
  {
    return (String)this.zzani.zza(zzof.zzaqR);
  }
  
  public String getIndexableText()
  {
    return (String)this.zzani.zza(zzof.zzaqX);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.zzani.zza(zzoh.zzarH);
  }
  
  public String getMimeType()
  {
    return (String)this.zzani.zza(zzof.zzarl);
  }
  
  public String getTitle()
  {
    return (String)this.zzani.zza(zzof.zzaru);
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.zzani.zza(zzof.zzard);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.zzani.zza(zzof.zzars);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.zzani.zza(zzof.zzark);
  }
  
  public MetadataBundle zzsp()
  {
    return this.zzani;
  }
  
  public static class Builder
  {
    private final MetadataBundle zzani = MetadataBundle.zztf();
    private AppVisibleCustomProperties.zza zzanj;
    
    private int zzcS(String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      return paramString.getBytes().length;
    }
    
    private String zzj(String paramString, int paramInt1, int paramInt2)
    {
      return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    
    private void zzk(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 <= paramInt1) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, zzj(paramString, paramInt1, paramInt2));
        return;
      }
    }
    
    private AppVisibleCustomProperties.zza zzsq()
    {
      if (this.zzanj == null) {
        this.zzanj = new AppVisibleCustomProperties.zza();
      }
      return this.zzanj;
    }
    
    public MetadataChangeSet build()
    {
      if (this.zzanj != null) {
        this.zzani.zzb(zzof.zzaqQ, this.zzanj.zztb());
      }
      return new MetadataChangeSet(this.zzani);
    }
    
    public Builder deleteCustomProperty(CustomPropertyKey paramCustomPropertyKey)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      zzsq().zza(paramCustomPropertyKey, null);
      return this;
    }
    
    public Builder setCustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      zzx.zzb(paramString, "value");
      zzk("The total size of key string and value string of a custom property", 124, zzcS(paramCustomPropertyKey.getKey()) + zzcS(paramString));
      zzsq().zza(paramCustomPropertyKey, paramString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzani.zzb(zzof.zzaqR, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      zzk("Indexable text size", 131072, zzcS(paramString));
      this.zzani.zzb(zzof.zzaqX, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.zzani.zzb(zzoh.zzarH, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.zzani.zzb(zzof.zzarl, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.zzani.zzb(zzof.zzard, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.zzani.zzb(zzof.zzars, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.zzani.zzb(zzof.zzaru, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.zzani.zzb(zzof.zzark, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */