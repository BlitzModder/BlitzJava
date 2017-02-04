package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzof
{
  public static final MetadataField<DriveId> zzaqO = zzoi.zzarM;
  public static final MetadataField<String> zzaqP = new zzo("alternateLink", 4300000);
  public static final zza zzaqQ = new zza(5000000);
  public static final MetadataField<String> zzaqR = new zzo("description", 4300000);
  public static final MetadataField<String> zzaqS = new zzo("embedLink", 4300000);
  public static final MetadataField<String> zzaqT = new zzo("fileExtension", 4300000);
  public static final MetadataField<Long> zzaqU = new zzg("fileSize", 4300000);
  public static final MetadataField<String> zzaqV = new zzo("folderColorRgb", 7500000);
  public static final MetadataField<Boolean> zzaqW = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
  public static final MetadataField<String> zzaqX = new zzo("indexableText", 4300000);
  public static final MetadataField<Boolean> zzaqY = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
  public static final MetadataField<Boolean> zzaqZ = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
  public static final MetadataField<String> zzarA = new zzo("role", 6000000);
  public static final MetadataField<String> zzarB = new zzo("md5Checksum", 7000000);
  public static final zze zzarC = new zze(7000000);
  public static final MetadataField<String> zzarD = new zzo("recencyReason", 8000000);
  public static final MetadataField<Boolean> zzarE = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);
  public static final MetadataField<Boolean> zzara = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
  public static final MetadataField<Boolean> zzarb = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000)
  {
    protected Boolean zze(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousDataHolder.zzc("trashed", paramAnonymousInt1, paramAnonymousInt2) == 2) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  };
  public static final MetadataField<Boolean> zzarc = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
  public static final zzb zzard = new zzb("isPinned", 4100000);
  public static final MetadataField<Boolean> zzare = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
  public static final MetadataField<Boolean> zzarf = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
  public static final MetadataField<Boolean> zzarg = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
  public static final MetadataField<Boolean> zzarh = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
  public static final MetadataField<Boolean> zzari = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
  public static final MetadataField<Boolean> zzarj = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
  public static final MetadataField<Boolean> zzark = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
  public static final zzc zzarl = new zzc(4100000);
  public static final MetadataField<String> zzarm = new zzo("originalFilename", 4300000);
  public static final com.google.android.gms.drive.metadata.zzb<String> zzarn = new zzn("ownerNames", 4300000);
  public static final zzp zzaro = new zzp("lastModifyingUser", 6000000);
  public static final zzp zzarp = new zzp("sharingUser", 6000000);
  public static final zzl zzarq = new zzl(4100000);
  public static final zzd zzarr = new zzd("quotaBytesUsed", 4300000);
  public static final zzf zzars = new zzf("starred", 4100000);
  public static final MetadataField<BitmapTeleporter> zzart = new zzj("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000)
  {
    protected BitmapTeleporter zzk(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final zzg zzaru = new zzg("title", 4100000);
  public static final zzh zzarv = new zzh("trashed", 4100000);
  public static final MetadataField<String> zzarw = new zzo("webContentLink", 4300000);
  public static final MetadataField<String> zzarx = new zzo("webViewLink", 4300000);
  public static final MetadataField<String> zzary = new zzo("uniqueIdentifier", 5000000);
  public static final com.google.android.gms.drive.metadata.internal.zzb zzarz = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
  
  public static class zza
    extends zzog
    implements SearchableMetadataField<AppVisibleCustomProperties>
  {
    public zza(int paramInt)
    {
      super();
    }
  }
  
  public static class zzb
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzb(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzc
    extends zzo
    implements SearchableMetadataField<String>
  {
    public zzc(int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzd
    extends zzg
    implements SortableMetadataField<Long>
  {
    public zzd(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zze
    extends zzi<DriveSpace>
  {
    public zze(int paramInt)
    {
      super(Arrays.asList(new String[] { "inDriveSpace", "isAppData", "inGooglePhotosSpace" }), Collections.emptySet(), paramInt);
    }
    
    protected Collection<DriveSpace> zzd(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramDataHolder.zze("inDriveSpace", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzamW);
      }
      if (paramDataHolder.zze("isAppData", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzamX);
      }
      if (paramDataHolder.zze("inGooglePhotosSpace", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzamY);
      }
      return localArrayList;
    }
  }
  
  public static class zzf
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzf(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzg
    extends zzo
    implements SearchableMetadataField<String>, SortableMetadataField<String>
  {
    public zzg(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzh
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzh(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    protected Boolean zze(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      if (paramDataHolder.zzc(getName(), paramInt1, paramInt2) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */