package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzmt<T>
{
  private static zza zzahn = null;
  private static int zzaho = 0;
  private static String zzahp = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzqf = new Object();
  private T zzRi = null;
  protected final String zzuX;
  protected final T zzuY;
  
  protected zzmt(String paramString, T paramT)
  {
    this.zzuX = paramString;
    this.zzuY = paramT;
  }
  
  public static boolean isInitialized()
  {
    return zzahn != null;
  }
  
  public static zzmt<Float> zza(String paramString, Float paramFloat)
  {
    new zzmt(paramString, paramFloat)
    {
      protected Float zzcr(String paramAnonymousString)
      {
        return zzmt.zzpG().zzb(this.zzuX, (Float)this.zzuY);
      }
    };
  }
  
  public static zzmt<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzmt(paramString, paramInteger)
    {
      protected Integer zzcq(String paramAnonymousString)
      {
        return zzmt.zzpG().zzb(this.zzuX, (Integer)this.zzuY);
      }
    };
  }
  
  public static zzmt<Long> zza(String paramString, Long paramLong)
  {
    new zzmt(paramString, paramLong)
    {
      protected Long zzcp(String paramAnonymousString)
      {
        return zzmt.zzpG().getLong(this.zzuX, (Long)this.zzuY);
      }
    };
  }
  
  public static zzmt<Boolean> zzg(String paramString, boolean paramBoolean)
  {
    new zzmt(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzco(String paramAnonymousString)
      {
        return zzmt.zzpG().zza(this.zzuX, (Boolean)this.zzuY);
      }
    };
  }
  
  public static int zzpE()
  {
    return zzaho;
  }
  
  public static zzmt<String> zzw(String paramString1, String paramString2)
  {
    new zzmt(paramString1, paramString2)
    {
      protected String zzcs(String paramAnonymousString)
      {
        return zzmt.zzpG().getString(this.zzuX, (String)this.zzuY);
      }
    };
  }
  
  public final T get()
  {
    if (this.zzRi != null) {
      return (T)this.zzRi;
    }
    return (T)zzcn(this.zzuX);
  }
  
  protected abstract T zzcn(String paramString);
  
  public final T zzpF()
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = get();
      return (T)localObject1;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Float zzb(String paramString, Float paramFloat);
    
    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */