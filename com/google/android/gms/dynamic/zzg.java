package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public abstract class zzg<T>
{
  private final String zzatD;
  private T zzatE;
  
  protected zzg(String paramString)
  {
    this.zzatD = paramString;
  }
  
  protected final T zzaA(Context paramContext)
    throws zzg.zza
  {
    if (this.zzatE == null)
    {
      zzx.zzy(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.zzatE = zzd((IBinder)paramContext.loadClass(this.zzatD).newInstance());
      return (T)this.zzatE;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  protected abstract T zzd(IBinder paramIBinder);
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/dynamic/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */