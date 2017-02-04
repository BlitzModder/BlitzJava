package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public final class zzoa
{
  public static String[] zzb(Scope[] paramArrayOfScope)
  {
    zzx.zzb(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    int i = 0;
    while (i < paramArrayOfScope.length)
    {
      arrayOfString[i] = paramArrayOfScope[i].zzoM();
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[] zzc(Set<Scope> paramSet)
  {
    zzx.zzb(paramSet, "scopes can't be null.");
    return zzb((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */