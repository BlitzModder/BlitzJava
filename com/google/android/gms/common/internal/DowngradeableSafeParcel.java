package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel
  implements SafeParcelable
{
  private static final Object zzajw = new Object();
  private static ClassLoader zzajx = null;
  private static Integer zzajy = null;
  private boolean zzajz = false;
  
  private static boolean zza(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      return false;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  protected static boolean zzcz(String paramString)
  {
    ClassLoader localClassLoader = zzqi();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = zza(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  protected static ClassLoader zzqi()
  {
    synchronized (zzajw)
    {
      ClassLoader localClassLoader = zzajx;
      return localClassLoader;
    }
  }
  
  protected static Integer zzqj()
  {
    synchronized (zzajw)
    {
      Integer localInteger = zzajy;
      return localInteger;
    }
  }
  
  protected boolean zzqk()
  {
    return this.zzajz;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */