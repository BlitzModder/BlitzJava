package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzsh
{
  private static zzag.zza zza(int paramInt, zzaf.zzf paramzzf, zzag.zza[] paramArrayOfzza, Set<Integer> paramSet)
    throws zzsh.zzg
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      zzfO("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    zzag.zza localzza1 = (zzag.zza)zza(paramzzf.zziz, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null) {
      return paramArrayOfzza[paramInt];
    }
    Object localObject = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localzza1.type)
    {
    }
    for (;;)
    {
      if (localObject == null) {
        zzfO("Invalid value: " + localzza1);
      }
      paramArrayOfzza[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (zzag.zza)localObject;
      localObject = zzp(localzza1);
      zzag.zza localzza2 = zzo(localzza1);
      localzza2.zzjp = new zzag.zza[((zzaf.zzh)localObject).zzja.length];
      int[] arrayOfInt = ((zzaf.zzh)localObject).zzja;
      k = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzjp[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localzza2 = zzo(localzza1);
      localObject = zzp(localzza1);
      if (((zzaf.zzh)localObject).zzjb.length != ((zzaf.zzh)localObject).zzjc.length) {
        zzfO("Uneven map keys (" + ((zzaf.zzh)localObject).zzjb.length + ") and map values (" + ((zzaf.zzh)localObject).zzjc.length + ")");
      }
      localzza2.zzjq = new zzag.zza[((zzaf.zzh)localObject).zzjb.length];
      localzza2.zzjr = new zzag.zza[((zzaf.zzh)localObject).zzjb.length];
      arrayOfInt = ((zzaf.zzh)localObject).zzjb;
      m = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        localzza2.zzjq[i] = zza(n, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((zzaf.zzh)localObject).zzjc;
      m = arrayOfInt.length;
      i = 0;
      j = k;
      for (;;)
      {
        localObject = localzza2;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        localzza2.zzjr[i] = zza(k, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = zzo(localzza1);
      ((zzag.zza)localObject).zzjs = zzdf.zzg(zza(zzp(localzza1).zzjf, paramzzf, paramArrayOfzza, paramSet));
      continue;
      localzza2 = zzo(localzza1);
      localObject = zzp(localzza1);
      localzza2.zzjw = new zzag.zza[((zzaf.zzh)localObject).zzje.length];
      arrayOfInt = ((zzaf.zzh)localObject).zzje;
      k = arrayOfInt.length;
      i = 0;
      j = m;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzjw[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = localzza1;
    }
  }
  
  private static zza zza(zzaf.zzb paramzzb, zzaf.zzf paramzzf, zzag.zza[] paramArrayOfzza, int paramInt)
    throws zzsh.zzg
  {
    zzb localzzb = zza.zzFL();
    paramzzb = paramzzb.zzik;
    int i = paramzzb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramzzb[paramInt];
      Object localObject = (zzaf.zze)zza(paramzzf.zziA, Integer.valueOf(j).intValue(), "properties");
      String str = (String)zza(paramzzf.zziy, ((zzaf.zze)localObject).key, "keys");
      localObject = (zzag.zza)zza(paramArrayOfzza, ((zzaf.zze)localObject).value, "values");
      if (zzae.zzgL.toString().equals(str)) {
        localzzb.zzq((zzag.zza)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localzzb.zzb(str, (zzag.zza)localObject);
      }
    }
    return localzzb.zzFN();
  }
  
  private static zze zza(zzaf.zzg paramzzg, List<zza> paramList1, List<zza> paramList2, List<zza> paramList3, zzaf.zzf paramzzf)
  {
    zzf localzzf = zze.zzFS();
    int[] arrayOfInt = paramzzg.zziO;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localzzf.zzd((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramzzg.zziP;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localzzf.zze((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zziQ;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzf((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zziS;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localzzf.zzfQ(paramzzf.zziz[Integer.valueOf(k).intValue()].zzjo);
      i += 1;
    }
    paramList3 = paramzzg.zziR;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzg((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zziT;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzfR(paramzzf.zziz[Integer.valueOf(k).intValue()].zzjo);
      i += 1;
    }
    paramList1 = paramzzg.zziU;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzh((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zziW;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzfS(paramzzf.zziz[Integer.valueOf(k).intValue()].zzjo);
      i += 1;
    }
    paramList1 = paramzzg.zziV;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzi((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramzzg = paramzzg.zziX;
    j = paramzzg.length;
    i = 0;
    while (i < j)
    {
      k = paramzzg[i];
      localzzf.zzfT(paramzzf.zziz[Integer.valueOf(k).intValue()].zzjo);
      i += 1;
    }
    return localzzf.zzGd();
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
    throws zzsh.zzg
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzfO("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static zzc zzb(zzaf.zzf paramzzf)
    throws zzsh.zzg
  {
    int j = 0;
    Object localObject = new zzag.zza[paramzzf.zziz.length];
    int i = 0;
    while (i < paramzzf.zziz.length)
    {
      zza(i, paramzzf, (zzag.zza[])localObject, new HashSet(0));
      i += 1;
    }
    zzd localzzd = zzc.zzFO();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramzzf.zziC.length)
    {
      localArrayList1.add(zza(paramzzf.zziC[i], paramzzf, (zzag.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramzzf.zziD.length)
    {
      localArrayList2.add(zza(paramzzf.zziD[i], paramzzf, (zzag.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramzzf.zziB.length)
    {
      zza localzza = zza(paramzzf.zziB[i], paramzzf, (zzag.zza[])localObject, i);
      localzzd.zzc(localzza);
      localArrayList3.add(localzza);
      i += 1;
    }
    localObject = paramzzf.zziE;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      localzzd.zzb(zza(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramzzf));
      i += 1;
    }
    localzzd.zzfP(paramzzf.version);
    localzzd.zzjX(paramzzf.zziM);
    return localzzd.zzFR();
  }
  
  public static void zzb(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void zzfO(String paramString)
    throws zzsh.zzg
  {
    zzbg.e(paramString);
    throw new zzg(paramString);
  }
  
  public static zzag.zza zzo(zzag.zza paramzza)
  {
    zzag.zza localzza = new zzag.zza();
    localzza.type = paramzza.type;
    localzza.zzjx = ((int[])paramzza.zzjx.clone());
    if (paramzza.zzjy) {
      localzza.zzjy = paramzza.zzjy;
    }
    return localzza;
  }
  
  private static zzaf.zzh zzp(zzag.zza paramzza)
    throws zzsh.zzg
  {
    if ((zzaf.zzh)paramzza.zza(zzaf.zzh.zziY) == null) {
      zzfO("Expected a ServingValue and didn't get one. Value is: " + paramzza);
    }
    return (zzaf.zzh)paramzza.zza(zzaf.zzh.zziY);
  }
  
  public static class zza
  {
    private final zzag.zza zzbfB;
    private final Map<String, zzag.zza> zzbhc;
    
    private zza(Map<String, zzag.zza> paramMap, zzag.zza paramzza)
    {
      this.zzbhc = paramMap;
      this.zzbfB = paramzza;
    }
    
    public static zzsh.zzb zzFL()
    {
      return new zzsh.zzb(null);
    }
    
    public String toString()
    {
      return "Properties: " + zzFM() + " pushAfterEvaluate: " + this.zzbfB;
    }
    
    public Map<String, zzag.zza> zzFM()
    {
      return Collections.unmodifiableMap(this.zzbhc);
    }
    
    public zzag.zza zzFl()
    {
      return this.zzbfB;
    }
    
    public void zza(String paramString, zzag.zza paramzza)
    {
      this.zzbhc.put(paramString, paramzza);
    }
  }
  
  public static class zzb
  {
    private zzag.zza zzbfB;
    private final Map<String, zzag.zza> zzbhc = new HashMap();
    
    public zzsh.zza zzFN()
    {
      return new zzsh.zza(this.zzbhc, this.zzbfB, null);
    }
    
    public zzb zzb(String paramString, zzag.zza paramzza)
    {
      this.zzbhc.put(paramString, paramzza);
      return this;
    }
    
    public zzb zzq(zzag.zza paramzza)
    {
      this.zzbfB = paramzza;
      return this;
    }
  }
  
  public static class zzc
  {
    private final String zzabv;
    private final List<zzsh.zze> zzbhd;
    private final Map<String, List<zzsh.zza>> zzbhe;
    private final int zzbhf;
    
    private zzc(List<zzsh.zze> paramList, Map<String, List<zzsh.zza>> paramMap, String paramString, int paramInt)
    {
      this.zzbhd = Collections.unmodifiableList(paramList);
      this.zzbhe = Collections.unmodifiableMap(paramMap);
      this.zzabv = paramString;
      this.zzbhf = paramInt;
    }
    
    public static zzsh.zzd zzFO()
    {
      return new zzsh.zzd(null);
    }
    
    public String getVersion()
    {
      return this.zzabv;
    }
    
    public String toString()
    {
      return "Rules: " + zzFP() + "  Macros: " + this.zzbhe;
    }
    
    public List<zzsh.zze> zzFP()
    {
      return this.zzbhd;
    }
    
    public Map<String, List<zzsh.zza>> zzFQ()
    {
      return this.zzbhe;
    }
  }
  
  public static class zzd
  {
    private String zzabv = "";
    private final List<zzsh.zze> zzbhd = new ArrayList();
    private final Map<String, List<zzsh.zza>> zzbhe = new HashMap();
    private int zzbhf = 0;
    
    public zzsh.zzc zzFR()
    {
      return new zzsh.zzc(this.zzbhd, this.zzbhe, this.zzabv, this.zzbhf, null);
    }
    
    public zzd zzb(zzsh.zze paramzze)
    {
      this.zzbhd.add(paramzze);
      return this;
    }
    
    public zzd zzc(zzsh.zza paramzza)
    {
      String str = zzdf.zzg((zzag.zza)paramzza.zzFM().get(zzae.zzfI.toString()));
      List localList = (List)this.zzbhe.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbhe.put(str, localObject);
      }
      ((List)localObject).add(paramzza);
      return this;
    }
    
    public zzd zzfP(String paramString)
    {
      this.zzabv = paramString;
      return this;
    }
    
    public zzd zzjX(int paramInt)
    {
      this.zzbhf = paramInt;
      return this;
    }
  }
  
  public static class zze
  {
    private final List<zzsh.zza> zzbhg;
    private final List<zzsh.zza> zzbhh;
    private final List<zzsh.zza> zzbhi;
    private final List<zzsh.zza> zzbhj;
    private final List<zzsh.zza> zzbhk;
    private final List<zzsh.zza> zzbhl;
    private final List<String> zzbhm;
    private final List<String> zzbhn;
    private final List<String> zzbho;
    private final List<String> zzbhp;
    
    private zze(List<zzsh.zza> paramList1, List<zzsh.zza> paramList2, List<zzsh.zza> paramList3, List<zzsh.zza> paramList4, List<zzsh.zza> paramList5, List<zzsh.zza> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.zzbhg = Collections.unmodifiableList(paramList1);
      this.zzbhh = Collections.unmodifiableList(paramList2);
      this.zzbhi = Collections.unmodifiableList(paramList3);
      this.zzbhj = Collections.unmodifiableList(paramList4);
      this.zzbhk = Collections.unmodifiableList(paramList5);
      this.zzbhl = Collections.unmodifiableList(paramList6);
      this.zzbhm = Collections.unmodifiableList(paramList7);
      this.zzbhn = Collections.unmodifiableList(paramList8);
      this.zzbho = Collections.unmodifiableList(paramList9);
      this.zzbhp = Collections.unmodifiableList(paramList10);
    }
    
    public static zzsh.zzf zzFS()
    {
      return new zzsh.zzf(null);
    }
    
    public String toString()
    {
      return "Positive predicates: " + zzFT() + "  Negative predicates: " + zzFU() + "  Add tags: " + zzFV() + "  Remove tags: " + zzFW() + "  Add macros: " + zzFX() + "  Remove macros: " + zzGc();
    }
    
    public List<zzsh.zza> zzFT()
    {
      return this.zzbhg;
    }
    
    public List<zzsh.zza> zzFU()
    {
      return this.zzbhh;
    }
    
    public List<zzsh.zza> zzFV()
    {
      return this.zzbhi;
    }
    
    public List<zzsh.zza> zzFW()
    {
      return this.zzbhj;
    }
    
    public List<zzsh.zza> zzFX()
    {
      return this.zzbhk;
    }
    
    public List<String> zzFY()
    {
      return this.zzbhm;
    }
    
    public List<String> zzFZ()
    {
      return this.zzbhn;
    }
    
    public List<String> zzGa()
    {
      return this.zzbho;
    }
    
    public List<String> zzGb()
    {
      return this.zzbhp;
    }
    
    public List<zzsh.zza> zzGc()
    {
      return this.zzbhl;
    }
  }
  
  public static class zzf
  {
    private final List<zzsh.zza> zzbhg = new ArrayList();
    private final List<zzsh.zza> zzbhh = new ArrayList();
    private final List<zzsh.zza> zzbhi = new ArrayList();
    private final List<zzsh.zza> zzbhj = new ArrayList();
    private final List<zzsh.zza> zzbhk = new ArrayList();
    private final List<zzsh.zza> zzbhl = new ArrayList();
    private final List<String> zzbhm = new ArrayList();
    private final List<String> zzbhn = new ArrayList();
    private final List<String> zzbho = new ArrayList();
    private final List<String> zzbhp = new ArrayList();
    
    public zzsh.zze zzGd()
    {
      return new zzsh.zze(this.zzbhg, this.zzbhh, this.zzbhi, this.zzbhj, this.zzbhk, this.zzbhl, this.zzbhm, this.zzbhn, this.zzbho, this.zzbhp, null);
    }
    
    public zzf zzd(zzsh.zza paramzza)
    {
      this.zzbhg.add(paramzza);
      return this;
    }
    
    public zzf zze(zzsh.zza paramzza)
    {
      this.zzbhh.add(paramzza);
      return this;
    }
    
    public zzf zzf(zzsh.zza paramzza)
    {
      this.zzbhi.add(paramzza);
      return this;
    }
    
    public zzf zzfQ(String paramString)
    {
      this.zzbho.add(paramString);
      return this;
    }
    
    public zzf zzfR(String paramString)
    {
      this.zzbhp.add(paramString);
      return this;
    }
    
    public zzf zzfS(String paramString)
    {
      this.zzbhm.add(paramString);
      return this;
    }
    
    public zzf zzfT(String paramString)
    {
      this.zzbhn.add(paramString);
      return this;
    }
    
    public zzf zzg(zzsh.zza paramzza)
    {
      this.zzbhj.add(paramzza);
      return this;
    }
    
    public zzf zzh(zzsh.zza paramzza)
    {
      this.zzbhk.add(paramzza);
      return this;
    }
    
    public zzf zzi(zzsh.zza paramzza)
    {
      this.zzbhl.add(paramzza);
      return this;
    }
  }
  
  public static class zzg
    extends Exception
  {
    public zzg(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */