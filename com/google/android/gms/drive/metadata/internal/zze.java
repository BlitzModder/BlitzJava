package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoj;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zze
{
  private static final Map<String, MetadataField<?>> zzaqJ = new HashMap();
  private static final Map<String, zza> zzaqK = new HashMap();
  
  static
  {
    zzb(zzof.zzaqO);
    zzb(zzof.zzaru);
    zzb(zzof.zzarl);
    zzb(zzof.zzars);
    zzb(zzof.zzarv);
    zzb(zzof.zzarb);
    zzb(zzof.zzara);
    zzb(zzof.zzarc);
    zzb(zzof.zzard);
    zzb(zzof.zzare);
    zzb(zzof.zzaqY);
    zzb(zzof.zzarg);
    zzb(zzof.zzarh);
    zzb(zzof.zzari);
    zzb(zzof.zzarq);
    zzb(zzof.zzaqP);
    zzb(zzof.zzarn);
    zzb(zzof.zzaqR);
    zzb(zzof.zzaqZ);
    zzb(zzof.zzaqS);
    zzb(zzof.zzaqT);
    zzb(zzof.zzaqU);
    zzb(zzof.zzaqV);
    zzb(zzof.zzark);
    zzb(zzof.zzarf);
    zzb(zzof.zzarm);
    zzb(zzof.zzaro);
    zzb(zzof.zzarp);
    zzb(zzof.zzarr);
    zzb(zzof.zzarw);
    zzb(zzof.zzarx);
    zzb(zzof.zzaqX);
    zzb(zzof.zzaqW);
    zzb(zzof.zzart);
    zzb(zzof.zzarj);
    zzb(zzof.zzaqQ);
    zzb(zzof.zzary);
    zzb(zzof.zzarz);
    zzb(zzof.zzarA);
    zzb(zzof.zzarB);
    zzb(zzof.zzarC);
    zzb(zzof.zzarD);
    zzb(zzof.zzarE);
    zzb(zzoh.zzarG);
    zzb(zzoh.zzarI);
    zzb(zzoh.zzarJ);
    zzb(zzoh.zzarK);
    zzb(zzoh.zzarH);
    zzb(zzoh.zzarL);
    zzb(zzoj.zzarN);
    zzb(zzoj.zzarO);
    zzl localzzl = zzof.zzarq;
    zza(zzl.zzaqN);
    zza(zzog.zzarF);
  }
  
  public static void zza(DataHolder paramDataHolder)
  {
    Iterator localIterator = zzaqK.values().iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzb(paramDataHolder);
    }
  }
  
  private static void zza(zza paramzza)
  {
    if (zzaqK.put(paramzza.zzte(), paramzza) != null) {
      throw new IllegalStateException("A cleaner for key " + paramzza.zzte() + " has already been registered");
    }
  }
  
  private static void zzb(MetadataField<?> paramMetadataField)
  {
    if (zzaqJ.containsKey(paramMetadataField.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    }
    zzaqJ.put(paramMetadataField.getName(), paramMetadataField);
  }
  
  public static MetadataField<?> zzcU(String paramString)
  {
    return (MetadataField)zzaqJ.get(paramString);
  }
  
  public static Collection<MetadataField<?>> zztd()
  {
    return Collections.unmodifiableCollection(zzaqJ.values());
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(DataHolder paramDataHolder);
    
    public abstract String zzte();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */