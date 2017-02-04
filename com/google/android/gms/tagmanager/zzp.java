package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzsf.zza;
import com.google.android.gms.internal.zzsg;
import com.google.android.gms.internal.zzsh.zzc;

public class zzp
  extends zzly<ContainerHolder>
{
  private final Context mContext;
  private final Looper zzaeK;
  private final String zzbcF;
  private long zzbcK;
  private final TagManager zzbcR;
  private final zzd zzbcU;
  private final zzcd zzbcV;
  private final int zzbcW;
  private zzf zzbcX;
  private zzsg zzbcY;
  private volatile zzo zzbcZ;
  private volatile boolean zzbda;
  private zzaf.zzj zzbdb;
  private String zzbdc;
  private zze zzbdd;
  private zza zzbde;
  private final zznl zzqD;
  
  zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzf paramzzf, zze paramzze, zzsg paramzzsg, zznl paramzznl, zzcd paramzzcd) {}
  
  public zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzs paramzzs)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new zzcn(paramContext, paramString), new zzcm(paramContext, paramString, paramzzs), new zzsg(paramContext), zzno.zzrM(), new zzbe(30, 900000L, 5000L, "refreshing", zzno.zzrM()));
    this.zzbcY.zzfN(paramzzs.zzEq());
  }
  
  private boolean zzEn()
  {
    zzcb localzzcb = zzcb.zzEY();
    return ((localzzcb.zzEZ() == zzcb.zza.zzbeO) || (localzzcb.zzEZ() == zzcb.zza.zzbeP)) && (this.zzbcF.equals(localzzcb.getContainerId()));
  }
  
  /* Error */
  private void zzV(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/google/android/gms/tagmanager/zzp:zzbdd	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   6: ifnonnull +11 -> 17
    //   9: ldc -63
    //   11: invokestatic 198	com/google/android/gms/tagmanager/zzbg:zzaH	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 87	com/google/android/gms/tagmanager/zzp:zzbdd	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   21: lload_1
    //   22: aload_0
    //   23: getfield 101	com/google/android/gms/tagmanager/zzp:zzbdb	Lcom/google/android/gms/internal/zzaf$zzj;
    //   26: getfield 201	com/google/android/gms/internal/zzaf$zzj:zzjm	Ljava/lang/String;
    //   29: invokeinterface 204 4 0
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzp
    //   0	42	1	paramLong	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   17	34	37	finally
  }
  
  private void zza(zzaf.zzj paramzzj)
  {
    try
    {
      if (this.zzbcX != null)
      {
        zzsf.zza localzza = new zzsf.zza();
        localzza.zzbgX = this.zzbcK;
        localzza.zzjl = new zzaf.zzf();
        localzza.zzbgY = paramzzj;
        this.zzbcX.zzb(localzza);
      }
      return;
    }
    finally
    {
      paramzzj = finally;
      throw paramzzj;
    }
  }
  
  private void zza(zzaf.zzj paramzzj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.zzbda;
        if (paramBoolean) {
          return;
        }
        if ((isReady()) && (this.zzbcZ == null)) {}
        this.zzbdb = paramzzj;
        this.zzbcK = paramLong;
        zzV(Math.max(0L, Math.min(43200000L, this.zzbcK + 43200000L - this.zzqD.currentTimeMillis())));
        paramzzj = new Container(this.mContext, this.zzbcR.getDataLayer(), this.zzbcF, paramLong, paramzzj);
        if (this.zzbcZ == null)
        {
          this.zzbcZ = new zzo(this.zzbcR, this.zzaeK, paramzzj, this.zzbcU);
          if ((!isReady()) && (this.zzbde.zzb(paramzzj))) {
            zzb(this.zzbcZ);
          }
        }
        else
        {
          this.zzbcZ.zza(paramzzj);
        }
      }
      finally {}
    }
  }
  
  private void zzau(final boolean paramBoolean)
  {
    this.zzbcX.zza(new zzb(null));
    this.zzbdd.zza(new zzc(null));
    zzsh.zzc localzzc = this.zzbcX.zzjN(this.zzbcW);
    if (localzzc != null) {
      this.zzbcZ = new zzo(this.zzbcR, this.zzaeK, new Container(this.mContext, this.zzbcR.getDataLayer(), this.zzbcF, 0L, localzzc), this.zzbcU);
    }
    this.zzbde = new zza()
    {
      public boolean zzb(Container paramAnonymousContainer)
      {
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + 43200000L < zzp.zzc(zzp.this).currentTimeMillis()) {}
        }
        while (!paramAnonymousContainer.isDefault())
        {
          return true;
          return false;
        }
        return false;
      }
    };
    if (zzEn())
    {
      this.zzbdd.zzf(0L, "");
      return;
    }
    this.zzbcX.zzEp();
  }
  
  String zzEh()
  {
    try
    {
      String str = this.zzbdc;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzEk()
  {
    Object localObject = this.zzbcX.zzjN(this.zzbcW);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.zzbcR.getDataLayer(), this.zzbcF, 0L, (zzsh.zzc)localObject);
      zzb(new zzo(this.zzbcR, this.zzaeK, (Container)localObject, new zzo.zza()
      {
        public String zzEh()
        {
          return zzp.this.zzEh();
        }
        
        public void zzEj()
        {
          zzbg.zzaH("Refresh ignored: container loaded as default only.");
        }
        
        public void zzff(String paramAnonymousString)
        {
          zzp.this.zzff(paramAnonymousString);
        }
      }));
    }
    for (;;)
    {
      this.zzbdd = null;
      this.zzbcX = null;
      return;
      zzbg.e("Default was requested, but no default container was found");
      zzb(zzbj(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void zzEl()
  {
    zzau(false);
  }
  
  public void zzEm()
  {
    zzau(true);
  }
  
  protected ContainerHolder zzbj(Status paramStatus)
  {
    if (this.zzbcZ != null) {
      return this.zzbcZ;
    }
    if (paramStatus == Status.zzafa) {
      zzbg.e("timer expired: setting result to failure");
    }
    return new zzo(paramStatus);
  }
  
  void zzff(String paramString)
  {
    try
    {
      this.zzbdc = paramString;
      if (this.zzbdd != null) {
        this.zzbdd.zzfi(paramString);
      }
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
    public abstract boolean zzb(Container paramContainer);
  }
  
  private class zzb
    implements zzbf<zzsf.zza>
  {
    private zzb() {}
    
    public void zzEo() {}
    
    public void zza(zzsf.zza paramzza)
    {
      zzaf.zzj localzzj;
      if (paramzza.zzbgY != null) {
        localzzj = paramzza.zzbgY;
      }
      for (;;)
      {
        zzp.zza(zzp.this, localzzj, paramzza.zzbgX, true);
        return;
        zzaf.zzf localzzf = paramzza.zzjl;
        localzzj = new zzaf.zzj();
        localzzj.zzjl = localzzf;
        localzzj.zzjk = null;
        localzzj.zzjm = localzzf.version;
      }
    }
    
    public void zza(zzbf.zza paramzza)
    {
      if (!zzp.zzd(zzp.this)) {
        zzp.zza(zzp.this, 0L);
      }
    }
  }
  
  private class zzc
    implements zzbf<zzaf.zzj>
  {
    private zzc() {}
    
    public void zzEo() {}
    
    public void zza(zzbf.zza arg1)
    {
      synchronized (zzp.this)
      {
        if (!zzp.this.isReady())
        {
          if (zzp.zzb(zzp.this) != null) {
            zzp.this.zzb(zzp.zzb(zzp.this));
          }
        }
        else
        {
          zzp.zza(zzp.this, 3600000L);
          return;
        }
        zzp.this.zzb(zzp.this.zzbj(Status.zzafa));
      }
    }
    
    public void zzb(zzaf.zzj paramzzj)
    {
      synchronized (zzp.this)
      {
        if (paramzzj.zzjl == null)
        {
          if (zzp.zze(zzp.this).zzjl == null)
          {
            zzbg.e("Current resource is null; network resource is also null");
            zzp.zza(zzp.this, 3600000L);
            return;
          }
          paramzzj.zzjl = zzp.zze(zzp.this).zzjl;
        }
        zzp.zza(zzp.this, paramzzj, zzp.zzc(zzp.this).currentTimeMillis(), false);
        zzbg.v("setting refresh time to current time: " + zzp.zzf(zzp.this));
        if (!zzp.zzg(zzp.this)) {
          zzp.zza(zzp.this, paramzzj);
        }
        return;
      }
    }
  }
  
  private class zzd
    implements zzo.zza
  {
    private zzd() {}
    
    public String zzEh()
    {
      return zzp.this.zzEh();
    }
    
    public void zzEj()
    {
      if (zzp.zza(zzp.this).zzlf()) {
        zzp.zza(zzp.this, 0L);
      }
    }
    
    public void zzff(String paramString)
    {
      zzp.this.zzff(paramString);
    }
  }
  
  static abstract interface zze
    extends Releasable
  {
    public abstract void zza(zzbf<zzaf.zzj> paramzzbf);
    
    public abstract void zzf(long paramLong, String paramString);
    
    public abstract void zzfi(String paramString);
  }
  
  static abstract interface zzf
    extends Releasable
  {
    public abstract void zzEp();
    
    public abstract void zza(zzbf<zzsf.zza> paramzzbf);
    
    public abstract void zzb(zzsf.zza paramzza);
    
    public abstract zzsh.zzc zzjN(int paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */