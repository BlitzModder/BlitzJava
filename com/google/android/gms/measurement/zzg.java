package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzg
{
  private static volatile zzg zzaRx;
  private final Context mContext;
  private volatile zzqh zzPD;
  private final zza zzaRA;
  private Thread.UncaughtExceptionHandler zzaRB;
  private final List<zzh> zzaRy;
  private final zzb zzaRz;
  
  zzg(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzx.zzy(paramContext);
    this.mContext = paramContext;
    this.zzaRA = new zza();
    this.zzaRy = new CopyOnWriteArrayList();
    this.zzaRz = new zzb();
  }
  
  public static zzg zzaT(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzaRx == null) {}
    try
    {
      if (zzaRx == null) {
        zzaRx = new zzg(paramContext);
      }
      return zzaRx;
    }
    finally {}
  }
  
  private void zzb(zzc paramzzc)
  {
    zzx.zzcy("deliver should be called from worker thread");
    zzx.zzb(paramzzc.zzzJ(), "Measurement must be submitted");
    Object localObject = paramzzc.zzzG();
    if (((List)localObject).isEmpty()) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzi localzzi = (zzi)((Iterator)localObject).next();
        Uri localUri = localzzi.zzii();
        if (!localHashSet.contains(localUri))
        {
          localHashSet.add(localUri);
          localzzi.zzb(paramzzc);
        }
      }
    }
  }
  
  public static void zziS()
  {
    if (!(Thread.currentThread() instanceof zzc)) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void zza(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.zzaRB = paramUncaughtExceptionHandler;
  }
  
  public <V> Future<V> zzc(Callable<V> paramCallable)
  {
    zzx.zzy(paramCallable);
    if ((Thread.currentThread() instanceof zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
      return paramCallable;
    }
    return this.zzaRA.submit(paramCallable);
  }
  
  void zze(final zzc paramzzc)
  {
    if (paramzzc.zzzN()) {
      throw new IllegalStateException("Measurement prototype can't be submitted");
    }
    if (paramzzc.zzzJ()) {
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    paramzzc = paramzzc.zzzE();
    paramzzc.zzzK();
    this.zzaRA.execute(new Runnable()
    {
      public void run()
      {
        paramzzc.zzzL().zza(paramzzc);
        Iterator localIterator = zzg.zza(zzg.this).iterator();
        while (localIterator.hasNext()) {
          ((zzh)localIterator.next()).zza(paramzzc);
        }
        zzg.zza(zzg.this, paramzzc);
      }
    });
  }
  
  public void zzf(Runnable paramRunnable)
  {
    zzx.zzy(paramRunnable);
    this.zzaRA.submit(paramRunnable);
  }
  
  public zzqh zzzR()
  {
    if (this.zzPD == null) {}
    Object localObject5;
    Object localObject3;
    try
    {
      zzqh localzzqh;
      PackageManager localPackageManager;
      String str2;
      if (this.zzPD == null)
      {
        localzzqh = new zzqh();
        localPackageManager = this.mContext.getPackageManager();
        str2 = this.mContext.getPackageName();
        localzzqh.setAppId(str2);
        localzzqh.setAppInstallerId(localPackageManager.getInstallerPackageName(str2));
        localObject5 = null;
        localObject3 = str2;
      }
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
        localObject4 = localObject5;
        str1 = str2;
        if (localPackageInfo != null)
        {
          localObject3 = str2;
          localObject4 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
          str1 = str2;
          localObject3 = str2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject3 = str2;
            str1 = ((CharSequence)localObject4).toString();
          }
          localObject3 = str1;
          localObject4 = localPackageInfo.versionName;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          String str1;
          Log.e("GAv4", "Error retrieving package info: appName set to " + (String)localObject3);
          Object localObject4 = localObject5;
          Object localObject1 = localObject3;
        }
      }
      localzzqh.setAppName(str1);
      localzzqh.setAppVersion((String)localObject4);
      this.zzPD = localzzqh;
      return this.zzPD;
    }
    finally {}
  }
  
  public zzqj zzzS()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    zzqj localzzqj = new zzqj();
    localzzqj.setLanguage(zzam.zza(Locale.getDefault()));
    localzzqj.zzip(localDisplayMetrics.widthPixels);
    localzzqj.zziq(localDisplayMetrics.heightPixels);
    return localzzqj;
  }
  
  private class zza
    extends ThreadPoolExecutor
  {
    public zza()
    {
      super(1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      setThreadFactory(new zzg.zzb(null));
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      new FutureTask(paramRunnable, paramT)
      {
        protected void setException(Throwable paramAnonymousThrowable)
        {
          Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = zzg.zzb(zzg.this);
          if (localUncaughtExceptionHandler != null) {
            localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramAnonymousThrowable);
          }
          for (;;)
          {
            super.setException(paramAnonymousThrowable);
            return;
            if (Log.isLoggable("GAv4", 6)) {
              Log.e("GAv4", "MeasurementExecutor: job failed with " + paramAnonymousThrowable);
            }
          }
        }
      };
    }
  }
  
  private static class zzb
    implements ThreadFactory
  {
    private static final AtomicInteger zzaRF = new AtomicInteger();
    
    public Thread newThread(Runnable paramRunnable)
    {
      return new zzg.zzc(paramRunnable, "measurement-" + zzaRF.incrementAndGet());
    }
  }
  
  private static class zzc
    extends Thread
  {
    zzc(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */