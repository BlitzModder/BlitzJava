package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzha
public class zzch
{
  private final Object zzpK = new Object();
  boolean zzwK;
  private final List<zzcf> zzxb = new LinkedList();
  private final Map<String, String> zzxc = new LinkedHashMap();
  private String zzxd;
  private zzcf zzxe;
  private zzch zzxf;
  
  public zzch(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.zzwK = paramBoolean;
    this.zzxc.put("action", paramString1);
    this.zzxc.put("ad_format", paramString2);
  }
  
  public void zzR(String paramString)
  {
    if (!this.zzwK) {
      return;
    }
    synchronized (this.zzpK)
    {
      this.zzxd = paramString;
      return;
    }
  }
  
  public boolean zza(zzcf paramzzcf, long paramLong, String... paramVarArgs)
  {
    synchronized (this.zzpK)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        zzcf localzzcf = new zzcf(paramLong, paramVarArgs[i], paramzzcf);
        this.zzxb.add(localzzcf);
        i += 1;
      }
      return true;
    }
  }
  
  public boolean zza(zzcf paramzzcf, String... paramVarArgs)
  {
    if ((!this.zzwK) || (paramzzcf == null)) {
      return false;
    }
    return zza(paramzzcf, zzp.zzbB().elapsedRealtime(), paramVarArgs);
  }
  
  public zzcf zzb(long paramLong)
  {
    if (!this.zzwK) {
      return null;
    }
    return new zzcf(paramLong, null, null);
  }
  
  public void zzc(zzch paramzzch)
  {
    synchronized (this.zzpK)
    {
      this.zzxf = paramzzch;
      return;
    }
  }
  
  public void zzd(String paramString1, String paramString2)
  {
    if ((!this.zzwK) || (TextUtils.isEmpty(paramString2))) {}
    zzcb localzzcb;
    do
    {
      return;
      localzzcb = zzp.zzbA().zzgM();
    } while (localzzcb == null);
    synchronized (this.zzpK)
    {
      localzzcb.zzP(paramString1).zza(this.zzxc, paramString1, paramString2);
      return;
    }
  }
  
  public zzcf zzdu()
  {
    return zzb(zzp.zzbB().elapsedRealtime());
  }
  
  public void zzdv()
  {
    synchronized (this.zzpK)
    {
      this.zzxe = zzdu();
      return;
    }
  }
  
  public String zzdw()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.zzpK)
    {
      Iterator localIterator = this.zzxb.iterator();
      while (localIterator.hasNext())
      {
        zzcf localzzcf = (zzcf)localIterator.next();
        long l1 = localzzcf.getTime();
        String str2 = localzzcf.zzdr();
        localzzcf = localzzcf.zzds();
        if ((localzzcf != null) && (l1 > 0L))
        {
          long l2 = localzzcf.getTime();
          localStringBuilder.append(str2).append('.').append(l1 - l2).append(',');
        }
      }
    }
    this.zzxb.clear();
    if (!TextUtils.isEmpty(this.zzxd)) {
      ((StringBuilder)localObject2).append(this.zzxd);
    }
    for (;;)
    {
      String str1 = ((StringBuilder)localObject2).toString();
      return str1;
      if (str1.length() > 0) {
        str1.setLength(str1.length() - 1);
      }
    }
  }
  
  public zzcf zzdx()
  {
    synchronized (this.zzpK)
    {
      zzcf localzzcf = this.zzxe;
      return localzzcf;
    }
  }
  
  Map<String, String> zzn()
  {
    synchronized (this.zzpK)
    {
      Object localObject2 = zzp.zzbA().zzgM();
      if ((localObject2 == null) || (this.zzxf == null))
      {
        localObject2 = this.zzxc;
        return (Map<String, String>)localObject2;
      }
      localObject2 = ((zzcb)localObject2).zza(this.zzxc, this.zzxf.zzn());
      return (Map<String, String>)localObject2;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */