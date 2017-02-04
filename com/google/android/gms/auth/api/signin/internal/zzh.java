package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzh
{
  public static void zza(SignInConfiguration paramSignInConfiguration, List<zze> paramList, Map<zze, List<String>> paramMap)
  {
    zzx.zzy(paramSignInConfiguration);
    zzx.zzy(paramList);
    zzx.zzy(paramMap);
    Object localObject = paramSignInConfiguration.zzmR();
    if (localObject != null)
    {
      paramList.add(zze.zzVJ);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((GoogleSignInOptions)localObject).zzmu().iterator();
      while (((Iterator)localObject).hasNext()) {
        localLinkedList.add(((Scope)((Iterator)localObject).next()).zzoM());
      }
      paramMap.put(zze.zzVJ, localLinkedList);
    }
    paramSignInConfiguration = paramSignInConfiguration.zzmS();
    if (paramSignInConfiguration != null)
    {
      paramList.add(zze.zzVK);
      paramList = new LinkedList();
      paramSignInConfiguration = paramSignInConfiguration.zzmu().iterator();
      while (paramSignInConfiguration.hasNext()) {
        paramList.add((String)paramSignInConfiguration.next());
      }
      paramMap.put(zze.zzVK, paramList);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */