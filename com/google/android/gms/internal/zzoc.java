package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzoc
{
  private static final Method zzamr = ;
  private static final Method zzams = zzsa();
  private static final Method zzamt = zzsb();
  private static final Method zzamu = zzsc();
  private static final Method zzamv = zzsd();
  
  public static int zza(WorkSource paramWorkSource)
  {
    if (zzamt != null) {
      try
      {
        int i = ((Integer)zzamt.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  public static String zza(WorkSource paramWorkSource, int paramInt)
  {
    if (zzamv != null) {
      try
      {
        paramWorkSource = (String)zzamv.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  public static void zza(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    if (zzams != null)
    {
      str = paramString;
      if (paramString == null) {
        str = "";
      }
    }
    while (zzamr == null) {
      try
      {
        String str;
        zzams.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        return;
      }
    }
    try
    {
      zzamr.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramWorkSource)
    {
      Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
    }
  }
  
  public static boolean zzaz(Context paramContext)
  {
    if (paramContext == null) {}
    PackageManager localPackageManager;
    do
    {
      return false;
      localPackageManager = paramContext.getPackageManager();
    } while ((localPackageManager == null) || (localPackageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) != 0));
    return true;
  }
  
  public static List<String> zzb(WorkSource paramWorkSource)
  {
    int j = 0;
    if (paramWorkSource == null) {}
    Object localObject;
    for (int i = 0; i == 0; i = zza(paramWorkSource))
    {
      localObject = Collections.EMPTY_LIST;
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      localObject = localArrayList;
      if (j >= i) {
        break;
      }
      localObject = zza(paramWorkSource, j);
      if (!zzob.zzcP((String)localObject)) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
  }
  
  public static WorkSource zzh(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    zza(localWorkSource, paramInt, paramString);
    return localWorkSource;
  }
  
  public static WorkSource zzk(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getPackageManager() == null)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      if (paramContext == null)
      {
        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + paramString);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("WorkSourceUtil", "Could not find package: " + paramString);
      return null;
    }
    return zzh(paramContext.uid, paramString);
  }
  
  private static Method zzrZ()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsa()
  {
    Method localMethod = null;
    if (zznx.zzrT()) {}
    try
    {
      localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsb()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsc()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsd()
  {
    Method localMethod = null;
    if (zznx.zzrT()) {}
    try
    {
      localMethod = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */