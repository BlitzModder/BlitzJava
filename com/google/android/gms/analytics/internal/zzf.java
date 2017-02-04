package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;

public class zzf
{
  private static zzf zzOT;
  private final Context mContext;
  private final Context zzOU;
  private final zzr zzOV;
  private final zzaf zzOW;
  private final com.google.android.gms.measurement.zzg zzOX;
  private final zzb zzOY;
  private final zzv zzOZ;
  private final zzan zzPa;
  private final zzai zzPb;
  private final GoogleAnalytics zzPc;
  private final zzn zzPd;
  private final zza zzPe;
  private final zzk zzPf;
  private final zzu zzPg;
  private final zznl zzqD;
  
  protected zzf(zzg paramzzg)
  {
    Object localObject1 = paramzzg.getApplicationContext();
    zzx.zzb(localObject1, "Application context can't be null");
    zzx.zzb(localObject1 instanceof Application, "getApplicationContext didn't return the application");
    Object localObject2 = paramzzg.zzjg();
    zzx.zzy(localObject2);
    this.mContext = ((Context)localObject1);
    this.zzOU = ((Context)localObject2);
    this.zzqD = paramzzg.zzh(this);
    this.zzOV = paramzzg.zzg(this);
    localObject2 = paramzzg.zzf(this);
    ((zzaf)localObject2).zza();
    this.zzOW = ((zzaf)localObject2);
    if (zziV().zzka()) {
      zziU().zzbc("Google Analytics " + zze.VERSION + " is starting up.");
    }
    for (;;)
    {
      localObject2 = paramzzg.zzq(this);
      ((zzai)localObject2).zza();
      this.zzPb = ((zzai)localObject2);
      localObject2 = paramzzg.zze(this);
      ((zzan)localObject2).zza();
      this.zzPa = ((zzan)localObject2);
      localObject2 = paramzzg.zzl(this);
      zzn localzzn = paramzzg.zzd(this);
      zza localzza = paramzzg.zzc(this);
      zzk localzzk = paramzzg.zzb(this);
      zzu localzzu = paramzzg.zza(this);
      localObject1 = paramzzg.zzaa((Context)localObject1);
      ((com.google.android.gms.measurement.zzg)localObject1).zza(zzjf());
      this.zzOX = ((com.google.android.gms.measurement.zzg)localObject1);
      localObject1 = paramzzg.zzi(this);
      localzzn.zza();
      this.zzPd = localzzn;
      localzza.zza();
      this.zzPe = localzza;
      localzzk.zza();
      this.zzPf = localzzk;
      localzzu.zza();
      this.zzPg = localzzu;
      paramzzg = paramzzg.zzp(this);
      paramzzg.zza();
      this.zzOZ = paramzzg;
      ((zzb)localObject2).zza();
      this.zzOY = ((zzb)localObject2);
      if (zziV().zzka()) {
        zziU().zzb("Device AnalyticsService version", zze.VERSION);
      }
      ((GoogleAnalytics)localObject1).zza();
      this.zzPc = ((GoogleAnalytics)localObject1);
      ((zzb)localObject2).start();
      return;
      zziU().zzbc("Google Analytics " + zze.VERSION + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
    }
  }
  
  public static zzf zzZ(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzOT == null) {}
    try
    {
      if (zzOT == null)
      {
        zznl localzznl = zzno.zzrM();
        long l1 = localzznl.elapsedRealtime();
        paramContext = new zzf(new zzg(paramContext.getApplicationContext()));
        zzOT = paramContext;
        GoogleAnalytics.zzin();
        l1 = localzznl.elapsedRealtime() - l1;
        long l2 = ((Long)zzy.zzRf.get()).longValue();
        if (l1 > l2) {
          paramContext.zziU().zzc("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        }
      }
      return zzOT;
    }
    finally {}
  }
  
  private void zza(zzd paramzzd)
  {
    zzx.zzb(paramzzd, "Analytics service not created/initialized");
    zzx.zzb(paramzzd.isInitialized(), "Analytics service not initialized");
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void zziS() {}
  
  public zznl zziT()
  {
    return this.zzqD;
  }
  
  public zzaf zziU()
  {
    zza(this.zzOW);
    return this.zzOW;
  }
  
  public zzr zziV()
  {
    return this.zzOV;
  }
  
  public com.google.android.gms.measurement.zzg zziW()
  {
    zzx.zzy(this.zzOX);
    return this.zzOX;
  }
  
  public zzv zziX()
  {
    zza(this.zzOZ);
    return this.zzOZ;
  }
  
  public zzai zziY()
  {
    zza(this.zzPb);
    return this.zzPb;
  }
  
  public zzb zzip()
  {
    zza(this.zzOY);
    return this.zzOY;
  }
  
  public zzan zziq()
  {
    zza(this.zzPa);
    return this.zzPa;
  }
  
  public zzk zzjb()
  {
    zza(this.zzPf);
    return this.zzPf;
  }
  
  public zzu zzjc()
  {
    return this.zzPg;
  }
  
  protected Thread.UncaughtExceptionHandler zzjf()
  {
    new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        paramAnonymousThread = zzf.this.zzjh();
        if (paramAnonymousThread != null) {
          paramAnonymousThread.zze("Job execution failed", paramAnonymousThrowable);
        }
      }
    };
  }
  
  public Context zzjg()
  {
    return this.zzOU;
  }
  
  public zzaf zzjh()
  {
    return this.zzOW;
  }
  
  public GoogleAnalytics zzji()
  {
    zzx.zzy(this.zzPc);
    zzx.zzb(this.zzPc.isInitialized(), "Analytics instance not initialized");
    return this.zzPc;
  }
  
  public zzai zzjj()
  {
    if ((this.zzPb == null) || (!this.zzPb.isInitialized())) {
      return null;
    }
    return this.zzPb;
  }
  
  public zza zzjk()
  {
    zza(this.zzPe);
    return this.zzPe;
  }
  
  public zzn zzjl()
  {
    zza(this.zzPd);
    return this.zzPd;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */