package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm
  implements zzp.zze
{
  private boolean mClosed;
  private final Context mContext;
  private final String zzbcF;
  private String zzbdc;
  private zzbf<zzaf.zzj> zzbeZ;
  private zzs zzbfa;
  private final ScheduledExecutorService zzbfc;
  private final zza zzbfd;
  private ScheduledFuture<?> zzbfe;
  
  public zzcm(Context paramContext, String paramString, zzs paramzzs)
  {
    this(paramContext, paramString, paramzzs, null, null);
  }
  
  zzcm(Context paramContext, String paramString, zzs paramzzs, zzb paramzzb, zza paramzza)
  {
    this.zzbfa = paramzzs;
    this.mContext = paramContext;
    this.zzbcF = paramString;
    paramContext = paramzzb;
    if (paramzzb == null) {
      paramContext = new zzb()
      {
        public ScheduledExecutorService zzFf()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.zzbfc = paramContext.zzFf();
    if (paramzza == null)
    {
      this.zzbfd = new zza()
      {
        public zzcl zza(zzs paramAnonymouszzs)
        {
          return new zzcl(zzcm.zza(zzcm.this), zzcm.zzb(zzcm.this), paramAnonymouszzs);
        }
      };
      return;
    }
    this.zzbfd = paramzza;
  }
  
  private void zzFe()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  private zzcl zzfy(String paramString)
  {
    zzcl localzzcl = this.zzbfd.zza(this.zzbfa);
    localzzcl.zza(this.zzbeZ);
    localzzcl.zzfi(this.zzbdc);
    localzzcl.zzfx(paramString);
    return localzzcl;
  }
  
  public void release()
  {
    try
    {
      zzFe();
      if (this.zzbfe != null) {
        this.zzbfe.cancel(false);
      }
      this.zzbfc.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void zza(zzbf<zzaf.zzj> paramzzbf)
  {
    try
    {
      zzFe();
      this.zzbeZ = paramzzbf;
      return;
    }
    finally
    {
      paramzzbf = finally;
      throw paramzzbf;
    }
  }
  
  public void zzf(long paramLong, String paramString)
  {
    try
    {
      zzbg.v("loadAfterDelay: containerId=" + this.zzbcF + " delay=" + paramLong);
      zzFe();
      if (this.zzbeZ == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.zzbfe != null) {
      this.zzbfe.cancel(false);
    }
    this.zzbfe = this.zzbfc.schedule(zzfy(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void zzfi(String paramString)
  {
    try
    {
      zzFe();
      this.zzbdc = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract zzcl zza(zzs paramzzs);
  }
  
  static abstract interface zzb
  {
    public abstract ScheduledExecutorService zzFf();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */