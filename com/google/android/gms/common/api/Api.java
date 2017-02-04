package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final zzc<?> zzacX;
  private final zza<?, O> zzaep;
  private final zze<?, O> zzaeq;
  private final zzf<?> zzaer;
  
  public <C extends zzb> Api(String paramString, zza<C, O> paramzza, zzc<C> paramzzc)
  {
    zzx.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzx.zzb(paramzzc, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zzaep = paramzza;
    this.zzaeq = null;
    this.zzacX = paramzzc;
    this.zzaer = null;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public zzc<?> zzoA()
  {
    if (this.zzacX != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return this.zzacX;
    }
  }
  
  public boolean zzoB()
  {
    return this.zzaer != null;
  }
  
  public zza<?, O> zzoy()
  {
    if (this.zzaep != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.zzaep;
    }
  }
  
  public zze<?, O> zzoz()
  {
    if (this.zzaeq != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
      return this.zzaeq;
    }
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class zza<T extends Api.zzb, O>
  {
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public abstract T zza(Context paramContext, Looper paramLooper, zzf paramzzf, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public List<Scope> zzn(O paramO)
    {
      return Collections.emptyList();
    }
  }
  
  public static abstract interface zzb
  {
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract boolean isConnected();
    
    public abstract void zza(GoogleApiClient.zza paramzza);
    
    public abstract void zza(zzp paramzzp);
    
    public abstract void zza(zzp paramzzp, Set<Scope> paramSet);
    
    public abstract boolean zzmJ();
    
    public abstract Intent zzmK();
    
    public abstract boolean zzmn();
    
    public abstract IBinder zzoC();
  }
  
  public static final class zzc<C extends Api.zzb> {}
  
  public static abstract interface zzd<T extends IInterface>
  {
    public abstract T zzW(IBinder paramIBinder);
    
    public abstract void zza(int paramInt, T paramT);
    
    public abstract String zzgh();
    
    public abstract String zzgi();
  }
  
  public static abstract interface zze<T extends Api.zzd, O>
  {
    public abstract int getPriority();
    
    public abstract int zzoD();
    
    public abstract T zzp(O paramO);
  }
  
  public static final class zzf<C extends Api.zzd> {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/api/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */