package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzy
{
  private static Context zzaPW;
  private static zzc zzaPX;
  
  private static Context getRemoteContext(Context paramContext)
  {
    if (zzaPW == null) {
      if (!zzzr()) {
        break label23;
      }
    }
    label23:
    for (zzaPW = paramContext.getApplicationContext();; zzaPW = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return zzaPW;
    }
  }
  
  private static <T> T zza(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = zzc(((ClassLoader)zzx.zzy(paramClassLoader)).loadClass(paramString));
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  public static zzc zzaP(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    zzx.zzy(paramContext);
    if (zzaPX != null) {
      return zzaPX;
    }
    zzaQ(paramContext);
    zzaPX = zzaR(paramContext);
    try
    {
      zzaPX.zzd(zze.zzB(getRemoteContext(paramContext).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
      return zzaPX;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void zzaQ(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static zzc zzaR(Context paramContext)
  {
    if (zzzr())
    {
      Log.i(zzy.class.getSimpleName(), "Making Creator statically");
      return (zzc)zzc(zzzs());
    }
    Log.i(zzy.class.getSimpleName(), "Making Creator dynamically");
    return zzc.zza.zzcu((IBinder)zza(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
  
  private static <T> T zzc(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
    }
  }
  
  public static boolean zzzr()
  {
    return false;
  }
  
  private static Class<?> zzzs()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/internal/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */