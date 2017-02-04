package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.analytics.internal.zzy.zza;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends zza
{
  private static List<Runnable> zzNK = new ArrayList();
  private boolean zzNL;
  private Set<zza> zzNM = new HashSet();
  private boolean zzNN;
  private boolean zzNO;
  private volatile boolean zzNP;
  private boolean zzNQ;
  private boolean zzqh;
  
  public GoogleAnalytics(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzf.zzZ(paramContext).zzji();
  }
  
  public static void zzin()
  {
    try
    {
      if (zzNK != null)
      {
        Iterator localIterator = zzNK.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        zzNK = null;
      }
    }
    finally {}
  }
  
  private zzb zzip()
  {
    return zzif().zzip();
  }
  
  private zzan zziq()
  {
    return zzif().zziq();
  }
  
  public void dispatchLocalHits()
  {
    zzip().zziL();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.zzNN))
    {
      paramApplication.registerActivityLifecycleCallbacks(new zzb());
      this.zzNN = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    return this.zzNP;
  }
  
  public String getClientId()
  {
    zzx.zzcy("getClientId can not be called from the main thread");
    return zzif().zzjl().zzjT();
  }
  
  @Deprecated
  public Logger getLogger()
  {
    return zzae.getLogger();
  }
  
  public boolean isDryRunEnabled()
  {
    return this.zzNO;
  }
  
  public boolean isInitialized()
  {
    return (this.zzqh) && (!this.zzNL);
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new Tracker(zzif(), null, null);
      if (paramInt > 0)
      {
        zzal localzzal = (zzal)new zzak(zzif()).zzah(paramInt);
        if (localzzal != null) {
          localTracker.zza(localzzal);
        }
      }
      localTracker.zza();
      return localTracker;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      paramString = new Tracker(zzif(), paramString, null);
      paramString.zza();
      return paramString;
    }
    finally {}
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.zzNN) {
      zzl(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.zzNN) {
      zzm(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    this.zzNP = paramBoolean;
    if (this.zzNP) {
      zzip().zziK();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.zzNO = paramBoolean;
  }
  
  public void setLocalDispatchPeriod(int paramInt)
  {
    zzip().setLocalDispatchPeriod(paramInt);
  }
  
  @Deprecated
  public void setLogger(Logger paramLogger)
  {
    zzae.setLogger(paramLogger);
    if (!this.zzNQ)
    {
      Log.i((String)zzy.zzQr.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + (String)zzy.zzQr.get() + " DEBUG");
      this.zzNQ = true;
    }
  }
  
  public void zza()
  {
    zzim();
    this.zzqh = true;
  }
  
  void zza(zza paramzza)
  {
    this.zzNM.add(paramzza);
    paramzza = zzif().getContext();
    if ((paramzza instanceof Application)) {
      enableAutoActivityReports((Application)paramzza);
    }
  }
  
  void zzb(zza paramzza)
  {
    this.zzNM.remove(paramzza);
  }
  
  void zzim()
  {
    zzan localzzan = zziq();
    if (localzzan.zzkS()) {
      getLogger().setLogLevel(localzzan.getLogLevel());
    }
    if (localzzan.zzkW()) {
      setDryRun(localzzan.zzkX());
    }
    if (localzzan.zzkS())
    {
      Logger localLogger = zzae.getLogger();
      if (localLogger != null) {
        localLogger.setLogLevel(localzzan.getLogLevel());
      }
    }
  }
  
  void zzio()
  {
    zzip().zziM();
  }
  
  void zzl(Activity paramActivity)
  {
    Iterator localIterator = this.zzNM.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzn(paramActivity);
    }
  }
  
  void zzm(Activity paramActivity)
  {
    Iterator localIterator = this.zzNM.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzo(paramActivity);
    }
  }
  
  static abstract interface zza
  {
    public abstract void zzn(Activity paramActivity);
    
    public abstract void zzo(Activity paramActivity);
  }
  
  class zzb
    implements Application.ActivityLifecycleCallbacks
  {
    zzb() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.this.zzl(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.this.zzm(paramActivity);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */