package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

@zzha
public class zzei
{
  private final Context mContext;
  private final String zzAg;
  private zzb<zzbb> zzAh;
  private zzb<zzbb> zzAi;
  private zze zzAj;
  private int zzAk = 1;
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  
  public zzei(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    this.zzAg = paramString;
    this.mContext = paramContext.getApplicationContext();
    this.zzpI = paramVersionInfoParcel;
    this.zzAh = new zzc();
    this.zzAi = new zzc();
  }
  
  public zzei(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzb<zzbb> paramzzb1, zzb<zzbb> paramzzb2)
  {
    this(paramContext, paramVersionInfoParcel, paramString);
    this.zzAh = paramzzb1;
    this.zzAi = paramzzb2;
  }
  
  private zze zzeg()
  {
    final zze localzze = new zze(this.zzAi);
    zzip.runOnUiThread(new Runnable()
    {
      public void run()
      {
        final zzbb localzzbb = zzei.this.zza(zzei.zza(zzei.this), zzei.zzb(zzei.this));
        localzzbb.zza(new zzbb.zza()
        {
          public void zzcr()
          {
            zzip.zzKO.postDelayed(new Runnable()
            {
              public void run()
              {
                synchronized (zzei.zzc(zzei.this))
                {
                  if ((zzei.1.this.zzAl.getStatus() == -1) || (zzei.1.this.zzAl.getStatus() == 1)) {
                    return;
                  }
                  zzei.1.this.zzAl.reject();
                  zzip.runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzei.1.1.this.zzAn.destroy();
                    }
                  });
                  zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
                  return;
                }
              }
            }, zzei.zza.zzAv);
          }
        });
        localzzbb.zza("/jsLoaded", new zzdl()
        {
          public void zza(zzjn arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzei.zzc(zzei.this))
            {
              if ((zzei.1.this.zzAl.getStatus() == -1) || (zzei.1.this.zzAl.getStatus() == 1)) {
                return;
              }
              zzei.zza(zzei.this, 0);
              zzei.zzd(zzei.this).zzc(localzzbb);
              zzei.1.this.zzAl.zzg(localzzbb);
              zzei.zza(zzei.this, zzei.1.this.zzAl);
              zzb.v("Successfully loaded JS Engine.");
              return;
            }
          }
        });
        final zziy localzziy = new zziy();
        zzdl local3 = new zzdl()
        {
          public void zza(zzjn arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzei.zzc(zzei.this))
            {
              zzb.zzaG("JS Engine is requesting an update");
              if (zzei.zze(zzei.this) == 0)
              {
                zzb.zzaG("Starting reload.");
                zzei.zza(zzei.this, 2);
                zzei.this.zzeh();
              }
              localzzbb.zzb("/requestReload", (zzdl)localzziy.get());
              return;
            }
          }
        };
        localzziy.set(local3);
        localzzbb.zza("/requestReload", local3);
        if (zzei.zzf(zzei.this).endsWith(".js")) {
          localzzbb.zzs(zzei.zzf(zzei.this));
        }
        for (;;)
        {
          zzip.zzKO.postDelayed(new Runnable()
          {
            public void run()
            {
              synchronized (zzei.zzc(zzei.this))
              {
                if ((zzei.1.this.zzAl.getStatus() == -1) || (zzei.1.this.zzAl.getStatus() == 1)) {
                  return;
                }
                zzei.1.this.zzAl.reject();
                zzip.runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    zzei.1.4.this.zzAn.destroy();
                  }
                });
                zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
                return;
              }
            }
          }, zzei.zza.zzAu);
          return;
          if (zzei.zzf(zzei.this).startsWith("<html>")) {
            localzzbb.zzu(zzei.zzf(zzei.this));
          } else {
            localzzbb.zzt(zzei.zzf(zzei.this));
          }
        }
      }
    });
    return localzze;
  }
  
  protected zzbb zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    return new zzbd(paramContext, paramVersionInfoParcel, null);
  }
  
  protected zze zzeh()
  {
    final zze localzze = zzeg();
    localzze.zza(new zzjg.zzc()new zzjg.zza
    {
      public void zza(zzbb arg1)
      {
        synchronized (zzei.zzc(zzei.this))
        {
          zzei.zza(zzei.this, 0);
          if ((zzei.zzg(zzei.this) != null) && (localzze != zzei.zzg(zzei.this)))
          {
            zzb.v("New JS engine is loaded, marking previous one as destroyable.");
            zzei.zzg(zzei.this).zzel();
          }
          zzei.zza(zzei.this, localzze);
          return;
        }
      }
    }, new zzjg.zza()
    {
      public void run()
      {
        synchronized (zzei.zzc(zzei.this))
        {
          zzei.zza(zzei.this, 1);
          zzb.v("Failed loading new engine. Marking new engine destroyable.");
          localzze.zzel();
          return;
        }
      }
    });
    return localzze;
  }
  
  public zzd zzei()
  {
    synchronized (this.zzpK)
    {
      zzd localzzd1;
      if ((this.zzAj == null) || (this.zzAj.getStatus() == -1))
      {
        this.zzAk = 2;
        this.zzAj = zzeh();
        localzzd1 = this.zzAj.zzej();
        return localzzd1;
      }
      if (this.zzAk == 0)
      {
        localzzd1 = this.zzAj.zzej();
        return localzzd1;
      }
    }
    if (this.zzAk == 1)
    {
      this.zzAk = 2;
      zzeh();
      localzzd2 = this.zzAj.zzej();
      return localzzd2;
    }
    if (this.zzAk == 2)
    {
      localzzd2 = this.zzAj.zzej();
      return localzzd2;
    }
    zzd localzzd2 = this.zzAj.zzej();
    return localzzd2;
  }
  
  static class zza
  {
    static int zzAu = 60000;
    static int zzAv = 10000;
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzc(T paramT);
  }
  
  public static class zzc<T>
    implements zzei.zzb<T>
  {
    public void zzc(T paramT) {}
  }
  
  public static class zzd
    extends zzjh<zzbe>
  {
    private final zzei.zze zzAw;
    private boolean zzAx;
    private final Object zzpK = new Object();
    
    public zzd(zzei.zze paramzze)
    {
      this.zzAw = paramzze;
    }
    
    public void release()
    {
      synchronized (this.zzpK)
      {
        if (this.zzAx) {
          return;
        }
        this.zzAx = true;
        zza(new zzjg.zzc()new zzjg.zzb
        {
          public void zzb(zzbe paramAnonymouszzbe)
          {
            zzb.v("Ending javascript session.");
            ((zzbf)paramAnonymouszzbe).zzcs();
          }
        }, new zzjg.zzb());
        zza(new zzjg.zzc()new zzjg.zza
        {
          public void zzb(zzbe paramAnonymouszzbe)
          {
            zzb.v("Releasing engine reference.");
            zzei.zzd.zza(zzei.zzd.this).zzek();
          }
        }, new zzjg.zza()
        {
          public void run()
          {
            zzei.zzd.zza(zzei.zzd.this).zzek();
          }
        });
        return;
      }
    }
  }
  
  public static class zze
    extends zzjh<zzbb>
  {
    private int zzAA;
    private zzei.zzb<zzbb> zzAi;
    private boolean zzAz;
    private final Object zzpK = new Object();
    
    public zze(zzei.zzb<zzbb> paramzzb)
    {
      this.zzAi = paramzzb;
      this.zzAz = false;
      this.zzAA = 0;
    }
    
    public zzei.zzd zzej()
    {
      final zzei.zzd localzzd = new zzei.zzd(this);
      for (;;)
      {
        synchronized (this.zzpK)
        {
          zza(new zzjg.zzc()new zzjg.zza
          {
            public void zza(zzbb paramAnonymouszzbb)
            {
              zzb.v("Getting a new session for JS Engine.");
              localzzd.zzg(paramAnonymouszzbb.zzcq());
            }
          }, new zzjg.zza()
          {
            public void run()
            {
              zzb.v("Rejecting reference for JS Engine.");
              localzzd.reject();
            }
          });
          if (this.zzAA >= 0)
          {
            bool = true;
            zzx.zzaa(bool);
            this.zzAA += 1;
            return localzzd;
          }
        }
        boolean bool = false;
      }
    }
    
    protected void zzek()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (this.zzpK)
        {
          if (this.zzAA >= 1)
          {
            zzx.zzaa(bool);
            zzb.v("Releasing 1 reference for JS Engine");
            this.zzAA -= 1;
            zzem();
            return;
          }
        }
      }
    }
    
    public void zzel()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (this.zzpK)
        {
          if (this.zzAA >= 0)
          {
            zzx.zzaa(bool);
            zzb.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzAz = true;
            zzem();
            return;
          }
        }
      }
    }
    
    protected void zzem()
    {
      for (;;)
      {
        synchronized (this.zzpK)
        {
          if (this.zzAA >= 0)
          {
            bool = true;
            zzx.zzaa(bool);
            if ((this.zzAz) && (this.zzAA == 0))
            {
              zzb.v("No reference is left (including root). Cleaning up engine.");
              zza(new zzjg.zzc()new zzjg.zzb
              {
                public void zza(final zzbb paramAnonymouszzbb)
                {
                  zzip.runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzei.zze.zza(zzei.zze.this).zzc(paramAnonymouszzbb);
                      paramAnonymouszzbb.destroy();
                    }
                  });
                }
              }, new zzjg.zzb());
              return;
            }
            zzb.v("There are still references to the engine. Not destroying.");
          }
        }
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */