package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsh.zza;
import com.google.android.gms.internal.zzsh.zzc;
import com.google.android.gms.internal.zzsh.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcp
{
  private static final zzbw<zzag.zza> zzbfj = new zzbw(zzdf.zzFJ(), true);
  private final DataLayer zzbcG;
  private final zzsh.zzc zzbfk;
  private final zzah zzbfl;
  private final Map<String, zzak> zzbfm;
  private final Map<String, zzak> zzbfn;
  private final Map<String, zzak> zzbfo;
  private final zzl<zzsh.zza, zzbw<zzag.zza>> zzbfp;
  private final zzl<String, zzb> zzbfq;
  private final Set<zzsh.zze> zzbfr;
  private final Map<String, zzc> zzbfs;
  private volatile String zzbft;
  private int zzbfu;
  
  public zzcp(Context paramContext, zzsh.zzc paramzzc, DataLayer paramDataLayer, zzt.zza paramzza1, zzt.zza paramzza2, zzah paramzzah)
  {
    if (paramzzc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.zzbfk = paramzzc;
    this.zzbfr = new HashSet(paramzzc.zzFP());
    this.zzbcG = paramDataLayer;
    this.zzbfl = paramzzah;
    paramzzc = new zzm.zza()
    {
      public int zza(zzsh.zza paramAnonymouszza, zzbw<zzag.zza> paramAnonymouszzbw)
      {
        return ((zzag.zza)paramAnonymouszzbw.getObject()).getCachedSize();
      }
    };
    this.zzbfp = new zzm().zza(1048576, paramzzc);
    paramzzc = new zzm.zza()
    {
      public int zza(String paramAnonymousString, zzcp.zzb paramAnonymouszzb)
      {
        return paramAnonymousString.length() + paramAnonymouszzb.getSize();
      }
    };
    this.zzbfq = new zzm().zza(1048576, paramzzc);
    this.zzbfm = new HashMap();
    zzb(new zzj(paramContext));
    zzb(new zzt(paramzza2));
    zzb(new zzx(paramDataLayer));
    zzb(new zzdg(paramContext, paramDataLayer));
    zzb(new zzdb(paramContext, paramDataLayer));
    this.zzbfn = new HashMap();
    zzc(new zzr());
    zzc(new zzae());
    zzc(new zzaf());
    zzc(new zzam());
    zzc(new zzan());
    zzc(new zzbc());
    zzc(new zzbd());
    zzc(new zzcf());
    zzc(new zzcy());
    this.zzbfo = new HashMap();
    zza(new zzb(paramContext));
    zza(new zzc(paramContext));
    zza(new zze(paramContext));
    zza(new zzf(paramContext));
    zza(new zzg(paramContext));
    zza(new zzh(paramContext));
    zza(new zzi(paramContext));
    zza(new zzn());
    zza(new zzq(this.zzbfk.getVersion()));
    zza(new zzt(paramzza1));
    zza(new zzv(paramDataLayer));
    zza(new zzaa(paramContext));
    zza(new zzab());
    zza(new zzad());
    zza(new zzai(this));
    zza(new zzao());
    zza(new zzap());
    zza(new zzaw(paramContext));
    zza(new zzay());
    zza(new zzbb());
    zza(new zzbi());
    zza(new zzbk(paramContext));
    zza(new zzbx());
    zza(new zzbz());
    zza(new zzcc());
    zza(new zzce());
    zza(new zzcg(paramContext));
    zza(new zzcq());
    zza(new zzcr());
    zza(new zzda());
    zza(new zzdh());
    this.zzbfs = new HashMap();
    paramDataLayer = this.zzbfr.iterator();
    while (paramDataLayer.hasNext())
    {
      paramzza1 = (zzsh.zze)paramDataLayer.next();
      if (paramzzah.zzEE())
      {
        zza(paramzza1.zzFX(), paramzza1.zzFY(), "add macro");
        zza(paramzza1.zzGc(), paramzza1.zzFZ(), "remove macro");
        zza(paramzza1.zzFV(), paramzza1.zzGa(), "add tag");
        zza(paramzza1.zzFW(), paramzza1.zzGb(), "remove tag");
      }
      int i = 0;
      while (i < paramzza1.zzFX().size())
      {
        paramzza2 = (zzsh.zza)paramzza1.zzFX().get(i);
        paramzzc = "Unknown";
        paramContext = paramzzc;
        if (paramzzah.zzEE())
        {
          paramContext = paramzzc;
          if (i < paramzza1.zzFY().size()) {
            paramContext = (String)paramzza1.zzFY().get(i);
          }
        }
        paramzzc = zzi(this.zzbfs, zza(paramzza2));
        paramzzc.zza(paramzza1);
        paramzzc.zza(paramzza1, paramzza2);
        paramzzc.zza(paramzza1, paramContext);
        i += 1;
      }
      i = 0;
      while (i < paramzza1.zzGc().size())
      {
        paramzza2 = (zzsh.zza)paramzza1.zzGc().get(i);
        paramzzc = "Unknown";
        paramContext = paramzzc;
        if (paramzzah.zzEE())
        {
          paramContext = paramzzc;
          if (i < paramzza1.zzFZ().size()) {
            paramContext = (String)paramzza1.zzFZ().get(i);
          }
        }
        paramzzc = zzi(this.zzbfs, zza(paramzza2));
        paramzzc.zza(paramzza1);
        paramzzc.zzb(paramzza1, paramzza2);
        paramzzc.zzb(paramzza1, paramContext);
        i += 1;
      }
    }
    paramContext = this.zzbfk.zzFQ().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramzzc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramzza1 = (zzsh.zza)paramDataLayer.next();
        if (!zzdf.zzk((zzag.zza)paramzza1.zzFM().get(com.google.android.gms.internal.zzae.zzgk.toString())).booleanValue()) {
          zzi(this.zzbfs, (String)paramzzc.getKey()).zzb(paramzza1);
        }
      }
    }
  }
  
  private String zzFj()
  {
    if (this.zzbfu <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.zzbfu));
    int i = 2;
    while (i < this.zzbfu)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  private zzbw<zzag.zza> zza(zzag.zza paramzza, Set<String> paramSet, zzdi paramzzdi)
  {
    if (!paramzza.zzjy) {
      return new zzbw(paramzza, true);
    }
    zzbw localzzbw1;
    switch (paramzza.type)
    {
    case 5: 
    case 6: 
    default: 
      zzbg.e("Unknown type: " + paramzza.type);
      return zzbfj;
    case 2: 
      localzza = zzsh.zzo(paramzza);
      localzza.zzjp = new zzag.zza[paramzza.zzjp.length];
      i = 0;
      while (i < paramzza.zzjp.length)
      {
        localzzbw1 = zza(paramzza.zzjp[i], paramSet, paramzzdi.zzjQ(i));
        if (localzzbw1 == zzbfj) {
          return zzbfj;
        }
        localzza.zzjp[i] = ((zzag.zza)localzzbw1.getObject());
        i += 1;
      }
      return new zzbw(localzza, false);
    case 3: 
      localzza = zzsh.zzo(paramzza);
      if (paramzza.zzjq.length != paramzza.zzjr.length)
      {
        zzbg.e("Invalid serving value: " + paramzza.toString());
        return zzbfj;
      }
      localzza.zzjq = new zzag.zza[paramzza.zzjq.length];
      localzza.zzjr = new zzag.zza[paramzza.zzjq.length];
      i = 0;
      while (i < paramzza.zzjq.length)
      {
        localzzbw1 = zza(paramzza.zzjq[i], paramSet, paramzzdi.zzjR(i));
        zzbw localzzbw2 = zza(paramzza.zzjr[i], paramSet, paramzzdi.zzjS(i));
        if ((localzzbw1 == zzbfj) || (localzzbw2 == zzbfj)) {
          return zzbfj;
        }
        localzza.zzjq[i] = ((zzag.zza)localzzbw1.getObject());
        localzza.zzjr[i] = ((zzag.zza)localzzbw2.getObject());
        i += 1;
      }
      return new zzbw(localzza, false);
    case 4: 
      if (paramSet.contains(paramzza.zzjs))
      {
        zzbg.e("Macro cycle detected.  Current macro reference: " + paramzza.zzjs + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return zzbfj;
      }
      paramSet.add(paramzza.zzjs);
      paramzzdi = zzdj.zza(zza(paramzza.zzjs, paramSet, paramzzdi.zzES()), paramzza.zzjx);
      paramSet.remove(paramzza.zzjs);
      return paramzzdi;
    }
    zzag.zza localzza = zzsh.zzo(paramzza);
    localzza.zzjw = new zzag.zza[paramzza.zzjw.length];
    int i = 0;
    while (i < paramzza.zzjw.length)
    {
      localzzbw1 = zza(paramzza.zzjw[i], paramSet, paramzzdi.zzjT(i));
      if (localzzbw1 == zzbfj) {
        return zzbfj;
      }
      localzza.zzjw[i] = ((zzag.zza)localzzbw1.getObject());
      i += 1;
    }
    return new zzbw(localzza, false);
  }
  
  private zzbw<zzag.zza> zza(String paramString, Set<String> paramSet, zzbj paramzzbj)
  {
    this.zzbfu += 1;
    Object localObject = (zzb)this.zzbfq.get(paramString);
    if ((localObject != null) && (!this.zzbfl.zzEE()))
    {
      zza(((zzb)localObject).zzFl(), paramSet);
      this.zzbfu -= 1;
      return ((zzb)localObject).zzFk();
    }
    localObject = (zzc)this.zzbfs.get(paramString);
    if (localObject == null)
    {
      zzbg.e(zzFj() + "Invalid macro: " + paramString);
      this.zzbfu -= 1;
      return zzbfj;
    }
    zzbw localzzbw = zza(paramString, ((zzc)localObject).zzFm(), ((zzc)localObject).zzFn(), ((zzc)localObject).zzFo(), ((zzc)localObject).zzFq(), ((zzc)localObject).zzFp(), paramSet, paramzzbj.zzEu());
    if (((Set)localzzbw.getObject()).isEmpty()) {}
    for (localObject = ((zzc)localObject).zzFr(); localObject == null; localObject = (zzsh.zza)((Set)localzzbw.getObject()).iterator().next())
    {
      this.zzbfu -= 1;
      return zzbfj;
      if (((Set)localzzbw.getObject()).size() > 1) {
        zzbg.zzaH(zzFj() + "Multiple macros active for macroName " + paramString);
      }
    }
    paramzzbj = zza(this.zzbfo, (zzsh.zza)localObject, paramSet, paramzzbj.zzEK());
    boolean bool;
    if ((localzzbw.zzET()) && (paramzzbj.zzET()))
    {
      bool = true;
      if (paramzzbj != zzbfj) {
        break label392;
      }
    }
    label392:
    for (paramzzbj = zzbfj;; paramzzbj = new zzbw(paramzzbj.getObject(), bool))
    {
      localObject = ((zzsh.zza)localObject).zzFl();
      if (paramzzbj.zzET()) {
        this.zzbfq.zzh(paramString, new zzb(paramzzbj, (zzag.zza)localObject));
      }
      zza((zzag.zza)localObject, paramSet);
      this.zzbfu -= 1;
      return paramzzbj;
      bool = false;
      break;
    }
  }
  
  private zzbw<zzag.zza> zza(Map<String, zzak> paramMap, zzsh.zza paramzza, Set<String> paramSet, zzch paramzzch)
  {
    boolean bool = true;
    Object localObject1 = (zzag.zza)paramzza.zzFM().get(com.google.android.gms.internal.zzae.zzfx.toString());
    if (localObject1 == null)
    {
      zzbg.e("No function id in properties");
      paramMap = zzbfj;
    }
    zzak localzzak;
    do
    {
      return paramMap;
      localObject1 = ((zzag.zza)localObject1).zzjt;
      localzzak = (zzak)paramMap.get(localObject1);
      if (localzzak == null)
      {
        zzbg.e((String)localObject1 + " has no backing implementation.");
        return zzbfj;
      }
      paramMap = (zzbw)this.zzbfp.get(paramzza);
    } while ((paramMap != null) && (!this.zzbfl.zzEE()));
    paramMap = new HashMap();
    Iterator localIterator = paramzza.zzFM().entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramzzch.zzfv((String)localEntry.getKey());
      localObject2 = zza((zzag.zza)localEntry.getValue(), paramSet, ((zzcj)localObject2).zze((zzag.zza)localEntry.getValue()));
      if (localObject2 == zzbfj) {
        return zzbfj;
      }
      if (((zzbw)localObject2).zzET()) {
        paramzza.zza((String)localEntry.getKey(), (zzag.zza)((zzbw)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((zzbw)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localzzak.zzf(paramMap.keySet()))
    {
      zzbg.e("Incorrect keys for function " + (String)localObject1 + " required " + localzzak.zzEG() + " had " + paramMap.keySet());
      return zzbfj;
    }
    if ((i != 0) && (localzzak.zzEa())) {}
    for (;;)
    {
      paramMap = new zzbw(localzzak.zzI(paramMap), bool);
      if (bool) {
        this.zzbfp.zzh(paramzza, paramMap);
      }
      paramzzch.zzd((zzag.zza)paramMap.getObject());
      return paramMap;
      bool = false;
    }
  }
  
  private zzbw<Set<zzsh.zza>> zza(Set<zzsh.zze> paramSet, Set<String> paramSet1, zza paramzza, zzco paramzzco)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      zzsh.zze localzze = (zzsh.zze)paramSet.next();
      zzck localzzck = paramzzco.zzER();
      zzbw localzzbw = zza(localzze, paramSet1, localzzck);
      if (((Boolean)localzzbw.getObject()).booleanValue()) {
        paramzza.zza(localzze, localHashSet1, localHashSet2, localzzck);
      }
      if ((bool) && (localzzbw.zzET())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramzzco.zzg(localHashSet1);
    return new zzbw(localHashSet1, bool);
  }
  
  private static String zza(zzsh.zza paramzza)
  {
    return zzdf.zzg((zzag.zza)paramzza.zzFM().get(com.google.android.gms.internal.zzae.zzfI.toString()));
  }
  
  private void zza(zzag.zza paramzza, Set<String> paramSet)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      paramzza = zza(paramzza, paramSet, new zzbu());
      if (paramzza != zzbfj)
      {
        paramzza = zzdf.zzl((zzag.zza)paramzza.getObject());
        if ((paramzza instanceof Map))
        {
          paramzza = (Map)paramzza;
          this.zzbcG.push(paramzza);
          return;
        }
        if (!(paramzza instanceof List)) {
          break;
        }
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          paramSet = paramzza.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.zzbcG.push(paramSet);
          }
          else
          {
            zzbg.zzaH("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    zzbg.zzaH("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void zza(List<zzsh.zza> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      zzbg.zzaG("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void zza(Map<String, zzak> paramMap, zzak paramzzak)
  {
    if (paramMap.containsKey(paramzzak.zzEF())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramzzak.zzEF());
    }
    paramMap.put(paramzzak.zzEF(), paramzzak);
  }
  
  private static zzc zzi(Map<String, zzc> paramMap, String paramString)
  {
    zzc localzzc2 = (zzc)paramMap.get(paramString);
    zzc localzzc1 = localzzc2;
    if (localzzc2 == null)
    {
      localzzc1 = new zzc();
      paramMap.put(paramString, localzzc1);
    }
    return localzzc1;
  }
  
  public void zzC(List<zzaf.zzi> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        zzaf.zzi localzzi = (zzaf.zzi)paramList.next();
        if ((localzzi.name == null) || (!localzzi.name.startsWith("gaExperiment:"))) {
          zzbg.v("Ignored supplemental: " + localzzi);
        } else {
          zzaj.zza(this.zzbcG, localzzi);
        }
      }
      finally {}
    }
  }
  
  String zzFi()
  {
    try
    {
      String str = this.zzbft;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  zzbw<Boolean> zza(zzsh.zza paramzza, Set<String> paramSet, zzch paramzzch)
  {
    paramzza = zza(this.zzbfn, paramzza, paramSet, paramzzch);
    paramSet = zzdf.zzk((zzag.zza)paramzza.getObject());
    paramzzch.zzd(zzdf.zzR(paramSet));
    return new zzbw(paramSet, paramzza.zzET());
  }
  
  zzbw<Boolean> zza(zzsh.zze paramzze, Set<String> paramSet, zzck paramzzck)
  {
    Object localObject = paramzze.zzFU().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      zzbw localzzbw = zza((zzsh.zza)((Iterator)localObject).next(), paramSet, paramzzck.zzEL());
      if (((Boolean)localzzbw.getObject()).booleanValue())
      {
        paramzzck.zzf(zzdf.zzR(Boolean.valueOf(false)));
        return new zzbw(Boolean.valueOf(false), localzzbw.zzET());
      }
      if ((bool) && (localzzbw.zzET())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramzze = paramzze.zzFT().iterator();
    while (paramzze.hasNext())
    {
      localObject = zza((zzsh.zza)paramzze.next(), paramSet, paramzzck.zzEM());
      if (!((Boolean)((zzbw)localObject).getObject()).booleanValue())
      {
        paramzzck.zzf(zzdf.zzR(Boolean.valueOf(false)));
        return new zzbw(Boolean.valueOf(false), ((zzbw)localObject).zzET());
      }
      if ((bool) && (((zzbw)localObject).zzET())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramzzck.zzf(zzdf.zzR(Boolean.valueOf(true)));
    return new zzbw(Boolean.valueOf(true), bool);
  }
  
  zzbw<Set<zzsh.zza>> zza(String paramString, Set<zzsh.zze> paramSet, final Map<zzsh.zze, List<zzsh.zza>> paramMap1, final Map<zzsh.zze, List<String>> paramMap2, final Map<zzsh.zze, List<zzsh.zza>> paramMap3, final Map<zzsh.zze, List<String>> paramMap4, Set<String> paramSet1, zzco paramzzco)
  {
    zza(paramSet, paramSet1, new zza()
    {
      public void zza(zzsh.zze paramAnonymouszze, Set<zzsh.zza> paramAnonymousSet1, Set<zzsh.zza> paramAnonymousSet2, zzck paramAnonymouszzck)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouszze);
        List localList2 = (List)paramMap2.get(paramAnonymouszze);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouszzck.zzEN().zzc(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouszze);
        paramAnonymouszze = (List)paramMap4.get(paramAnonymouszze);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouszzck.zzEO().zzc(paramAnonymousSet1, paramAnonymouszze);
        }
      }
    }, paramzzco);
  }
  
  zzbw<Set<zzsh.zza>> zza(Set<zzsh.zze> paramSet, zzco paramzzco)
  {
    zza(paramSet, new HashSet(), new zza()
    {
      public void zza(zzsh.zze paramAnonymouszze, Set<zzsh.zza> paramAnonymousSet1, Set<zzsh.zza> paramAnonymousSet2, zzck paramAnonymouszzck)
      {
        paramAnonymousSet1.addAll(paramAnonymouszze.zzFV());
        paramAnonymousSet2.addAll(paramAnonymouszze.zzFW());
        paramAnonymouszzck.zzEP().zzc(paramAnonymouszze.zzFV(), paramAnonymouszze.zzGa());
        paramAnonymouszzck.zzEQ().zzc(paramAnonymouszze.zzFW(), paramAnonymouszze.zzGb());
      }
    }, paramzzco);
  }
  
  void zza(zzak paramzzak)
  {
    zza(this.zzbfo, paramzzak);
  }
  
  void zzb(zzak paramzzak)
  {
    zza(this.zzbfm, paramzzak);
  }
  
  void zzc(zzak paramzzak)
  {
    zza(this.zzbfn, paramzzak);
  }
  
  void zzfA(String paramString)
  {
    try
    {
      this.zzbft = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zzfd(String paramString)
  {
    try
    {
      zzfA(paramString);
      paramString = this.zzbfl.zzfq(paramString);
      zzu localzzu = paramString.zzEC();
      Iterator localIterator = ((Set)zza(this.zzbfr, localzzu.zzEu()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        zzsh.zza localzza = (zzsh.zza)localIterator.next();
        zza(this.zzbfm, localzza, new HashSet(), localzzu.zzEt());
      }
      paramString.zzED();
    }
    finally {}
    zzfA(null);
  }
  
  public zzbw<zzag.zza> zzfz(String paramString)
  {
    this.zzbfu = 0;
    zzag localzzag = this.zzbfl.zzfp(paramString);
    paramString = zza(paramString, new HashSet(), localzzag.zzEB());
    localzzag.zzED();
    return paramString;
  }
  
  static abstract interface zza
  {
    public abstract void zza(zzsh.zze paramzze, Set<zzsh.zza> paramSet1, Set<zzsh.zza> paramSet2, zzck paramzzck);
  }
  
  private static class zzb
  {
    private zzbw<zzag.zza> zzbfA;
    private zzag.zza zzbfB;
    
    public zzb(zzbw<zzag.zza> paramzzbw, zzag.zza paramzza)
    {
      this.zzbfA = paramzzbw;
      this.zzbfB = paramzza;
    }
    
    public int getSize()
    {
      int j = ((zzag.zza)this.zzbfA.getObject()).getCachedSize();
      if (this.zzbfB == null) {}
      for (int i = 0;; i = this.zzbfB.getCachedSize()) {
        return i + j;
      }
    }
    
    public zzbw<zzag.zza> zzFk()
    {
      return this.zzbfA;
    }
    
    public zzag.zza zzFl()
    {
      return this.zzbfB;
    }
  }
  
  private static class zzc
  {
    private final Map<zzsh.zze, List<zzsh.zza>> zzbfC = new HashMap();
    private final Map<zzsh.zze, List<zzsh.zza>> zzbfD = new HashMap();
    private final Map<zzsh.zze, List<String>> zzbfE = new HashMap();
    private final Map<zzsh.zze, List<String>> zzbfF = new HashMap();
    private zzsh.zza zzbfG;
    private final Set<zzsh.zze> zzbfr = new HashSet();
    
    public Set<zzsh.zze> zzFm()
    {
      return this.zzbfr;
    }
    
    public Map<zzsh.zze, List<zzsh.zza>> zzFn()
    {
      return this.zzbfC;
    }
    
    public Map<zzsh.zze, List<String>> zzFo()
    {
      return this.zzbfE;
    }
    
    public Map<zzsh.zze, List<String>> zzFp()
    {
      return this.zzbfF;
    }
    
    public Map<zzsh.zze, List<zzsh.zza>> zzFq()
    {
      return this.zzbfD;
    }
    
    public zzsh.zza zzFr()
    {
      return this.zzbfG;
    }
    
    public void zza(zzsh.zze paramzze)
    {
      this.zzbfr.add(paramzze);
    }
    
    public void zza(zzsh.zze paramzze, zzsh.zza paramzza)
    {
      List localList = (List)this.zzbfC.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbfC.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zza(zzsh.zze paramzze, String paramString)
    {
      List localList = (List)this.zzbfE.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbfE.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void zzb(zzsh.zza paramzza)
    {
      this.zzbfG = paramzza;
    }
    
    public void zzb(zzsh.zze paramzze, zzsh.zza paramzza)
    {
      List localList = (List)this.zzbfD.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbfD.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zzb(zzsh.zze paramzze, String paramString)
    {
      List localList = (List)this.zzbfF.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbfF.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */