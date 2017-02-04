package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzab
{
  private final List<Command> zzRp;
  private final long zzRq;
  private final long zzRr;
  private final int zzRs;
  private final boolean zzRt;
  private final String zzRu;
  private final Map<String, String> zzxc;
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong, boolean paramBoolean)
  {
    this(paramzzc, paramMap, paramLong, paramBoolean, 0L, 0, null);
  }
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    this(paramzzc, paramMap, paramLong1, paramBoolean, paramLong2, paramInt, null);
  }
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt, List<Command> paramList)
  {
    zzx.zzy(paramzzc);
    zzx.zzy(paramMap);
    this.zzRr = paramLong1;
    this.zzRt = paramBoolean;
    this.zzRq = paramLong2;
    this.zzRs = paramInt;
    if (paramList != null) {}
    Object localObject2;
    for (Object localObject1 = paramList;; localObject1 = Collections.EMPTY_LIST)
    {
      this.zzRp = ((List)localObject1);
      this.zzRu = zzn(paramList);
      paramList = new HashMap();
      localObject1 = paramMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (zzj(((Map.Entry)localObject2).getKey()))
        {
          String str = zza(paramzzc, ((Map.Entry)localObject2).getKey());
          if (str != null) {
            paramList.put(str, zzb(paramzzc, ((Map.Entry)localObject2).getValue()));
          }
        }
      }
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      if (!zzj(((Map.Entry)localObject1).getKey()))
      {
        localObject2 = zza(paramzzc, ((Map.Entry)localObject1).getKey());
        if (localObject2 != null) {
          paramList.put(localObject2, zzb(paramzzc, ((Map.Entry)localObject1).getValue()));
        }
      }
    }
    if (!TextUtils.isEmpty(this.zzRu))
    {
      zzam.zzc(paramList, "_v", this.zzRu);
      if ((this.zzRu.equals("ma4.0.0")) || (this.zzRu.equals("ma4.0.1"))) {
        paramList.remove("adid");
      }
    }
    this.zzxc = Collections.unmodifiableMap(paramList);
  }
  
  public static zzab zza(zzc paramzzc, zzab paramzzab, Map<String, String> paramMap)
  {
    return new zzab(paramzzc, paramMap, paramzzab.zzla(), paramzzab.zzlc(), paramzzab.zzkZ(), paramzzab.zzkY(), paramzzab.zzlb());
  }
  
  private static String zza(zzc paramzzc, Object paramObject)
  {
    if (paramObject == null) {
      paramzzc = null;
    }
    Object localObject;
    do
    {
      return paramzzc;
      localObject = paramObject.toString();
      paramObject = localObject;
      if (((String)localObject).startsWith("&")) {
        paramObject = ((String)localObject).substring(1);
      }
      int i = ((String)paramObject).length();
      localObject = paramObject;
      if (i > 256)
      {
        localObject = ((String)paramObject).substring(0, 256);
        paramzzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(i), localObject);
      }
      paramzzc = (zzc)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return null;
  }
  
  private static String zzb(zzc paramzzc, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      int i = ((String)paramObject).length();
      Object localObject = paramObject;
      if (i > 8192)
      {
        localObject = ((String)paramObject).substring(0, 8192);
        paramzzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(i), localObject);
      }
      return (String)localObject;
    }
  }
  
  private static boolean zzj(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return paramObject.toString().startsWith("&");
  }
  
  private String zzn(String paramString1, String paramString2)
  {
    zzx.zzcG(paramString1);
    if (!paramString1.startsWith("&")) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Short param name required");
      paramString1 = (String)this.zzxc.get(paramString1);
      if (paramString1 == null) {
        break;
      }
      return paramString1;
    }
    return paramString2;
  }
  
  private static String zzn(List<Command> paramList)
  {
    Command localCommand;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localCommand = (Command)paramList.next();
      } while (!"appendVersion".equals(localCommand.getId()));
    }
    for (paramList = localCommand.getValue();; paramList = null)
    {
      if (TextUtils.isEmpty(paramList)) {
        return null;
      }
      return paramList;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ht=").append(this.zzRr);
    if (this.zzRq != 0L) {
      localStringBuffer.append(", dbId=").append(this.zzRq);
    }
    if (this.zzRs != 0L) {
      localStringBuffer.append(", appUID=").append(this.zzRs);
    }
    Object localObject = new ArrayList(this.zzxc.keySet());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append(", ");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)this.zzxc.get(str));
    }
    return localStringBuffer.toString();
  }
  
  public int zzkY()
  {
    return this.zzRs;
  }
  
  public long zzkZ()
  {
    return this.zzRq;
  }
  
  public long zzla()
  {
    return this.zzRr;
  }
  
  public List<Command> zzlb()
  {
    return this.zzRp;
  }
  
  public boolean zzlc()
  {
    return this.zzRt;
  }
  
  public long zzld()
  {
    return zzam.zzbq(zzn("_s", "0"));
  }
  
  public String zzle()
  {
    return zzn("_m", "");
  }
  
  public Map<String, String> zzn()
  {
    return this.zzxc;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */