package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzj
{
  private final Map<zze, zzld> zzWf;
  
  public zzj(Activity paramActivity, List<zze> paramList, Map<zze, List<String>> paramMap)
  {
    zzx.zzy(paramActivity);
    zzx.zzy(paramList);
    zzx.zzy(paramMap);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zze localzze = (zze)localIterator.next();
      List localList = (List)paramMap.get(localzze);
      paramList = localList;
      if (localList == null) {
        paramList = Collections.emptyList();
      }
      paramList = zza(localzze, paramActivity, paramList);
      if (paramList != null) {
        localHashMap.put(localzze, paramList);
      }
    }
    this.zzWf = Collections.unmodifiableMap(localHashMap);
  }
  
  private zzld zza(zze paramzze, Activity paramActivity, List<String> paramList)
  {
    if (zze.zzVK.equals(paramzze)) {
      return new zzlf(paramActivity, paramList);
    }
    return null;
  }
  
  public zzld zza(zze paramzze)
  {
    zzx.zzy(paramzze);
    return (zzld)this.zzWf.get(paramzze);
  }
  
  public Collection<zzld> zzmO()
  {
    return this.zzWf.values();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */