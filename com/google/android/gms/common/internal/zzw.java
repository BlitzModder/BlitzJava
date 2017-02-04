package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static zza zzx(Object paramObject)
  {
    return new zza(paramObject, null);
  }
  
  public static final class zza
  {
    private final Object zzLx;
    private final List<String> zzaky;
    
    private zza(Object paramObject)
    {
      this.zzLx = zzx.zzy(paramObject);
      this.zzaky = new ArrayList();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.zzLx.getClass().getSimpleName()).append('{');
      int j = this.zzaky.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.zzaky.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return '}';
    }
    
    public zza zzg(String paramString, Object paramObject)
    {
      this.zzaky.add((String)zzx.zzy(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */