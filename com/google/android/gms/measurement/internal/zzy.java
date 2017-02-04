package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurement.zza;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class zzy
  extends zzw
{
  private zza zzaUI;
  private AppMeasurement.zza zzaUJ;
  private boolean zzaUK;
  
  protected zzy(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private void zzBT()
  {
    try
    {
      zzg(Class.forName(zzBU()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzzz().zzBp().zzez("Tag Manager is not found and thus will not be used");
    }
  }
  
  private String zzBU()
  {
    return "com.google.android.gms.tagmanager.TagManagerService";
  }
  
  private void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean, String paramString3)
  {
    zzx.zzcG(paramString1);
    zzx.zzcG(paramString2);
    zzx.zzy(paramBundle);
    zziS();
    zzje();
    if (!zzAW().zzzC()) {
      zzzz().zzBp().zzez("Event not sent since app measurement is disabled");
    }
    do
    {
      return;
      if (!this.zzaUK)
      {
        this.zzaUK = true;
        zzBT();
      }
      if ((paramBoolean) && (this.zzaUJ != null))
      {
        zzzz().zzBq().zze("Passing event to registered event handler (FE)", paramString2, paramBundle);
        this.zzaUJ.zze(paramString1, paramString2, paramBundle);
        return;
      }
    } while (!this.zzaQX.zzBz());
    zzzz().zzBq().zze("Logging event (FE)", paramString2, paramBundle);
    paramString1 = new EventParcel(paramString2, new EventParams(paramBundle), paramString1, paramLong);
    zzAT().zzb(paramString1, paramString3);
  }
  
  private void zza(final String paramString1, final String paramString2, Bundle paramBundle, final boolean paramBoolean, final String paramString3)
  {
    zzx.zzcG(paramString1);
    final long l = zziT().currentTimeMillis();
    zzAU().zzeE(paramString2);
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zzAU().zzeG(str);
        Object localObject = zzAU().zzk(str, paramBundle.get(str));
        if (localObject != null) {
          zzAU().zza(localBundle, str, localObject);
        }
      }
    }
    zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this, paramString1, paramString2, l, paramBoolean, paramString3, this.zzaFm);
      }
    });
  }
  
  private void zza(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    zzx.zzcG(paramString1);
    zzx.zzcG(paramString2);
    zziS();
    zziR();
    zzje();
    if (!zzAW().zzzC()) {
      zzzz().zzBp().zzez("User attribute not set since app measurement is disabled");
    }
    while (!this.zzaQX.zzBz()) {
      return;
    }
    zzzz().zzBq().zze("Setting user attribute (FE)", paramString2, paramObject);
    paramString1 = new UserAttributeParcel(paramString2, paramLong, paramObject, paramString1);
    zzAT().zza(paramString1);
  }
  
  private void zzaq(boolean paramBoolean)
  {
    zziS();
    zziR();
    zzje();
    zzzz().zzBq().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    zzAW().setMeasurementEnabled(paramBoolean);
    zzAT().zzBV();
  }
  
  public void setMeasurementEnabled(final boolean paramBoolean)
  {
    zzje();
    zziR();
    zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this, paramBoolean);
      }
    });
  }
  
  public void zzBR()
  {
    if ((getContext().getApplicationContext() instanceof Application))
    {
      Application localApplication = (Application)getContext().getApplicationContext();
      if (this.zzaUI == null) {
        this.zzaUI = new zza(null);
      }
      localApplication.unregisterActivityLifecycleCallbacks(this.zzaUI);
      localApplication.registerActivityLifecycleCallbacks(this.zzaUI);
      zzzz().zzBr().zzez("Registered activity lifecycle callback");
    }
  }
  
  public void zzBS()
  {
    zziS();
    zziR();
    zzje();
    if (!this.zzaQX.zzBz()) {
      return;
    }
    zzAT().zzBS();
  }
  
  public void zza(final String paramString1, final String paramString2, final Object paramObject)
  {
    zzx.zzcG(paramString1);
    final long l = zziT().currentTimeMillis();
    zzAU().zzeF(paramString2);
    if (paramObject != null)
    {
      zzAU().zzl(paramString2, paramObject);
      paramObject = zzAU().zzm(paramString2, paramObject);
      if (paramObject != null) {
        zzAV().zzg(new Runnable()
        {
          public void run()
          {
            zzy.zza(zzy.this, paramString1, paramString2, paramObject, l);
          }
        });
      }
      return;
    }
    zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this, paramString1, paramString2, null, l);
      }
    });
  }
  
  public void zze(String paramString1, String paramString2, Bundle paramBundle)
  {
    zziR();
    zza(paramString1, paramString2, paramBundle, true, null);
  }
  
  public void zzg(Class<?> paramClass)
  {
    try
    {
      paramClass.getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { getContext() });
      return;
    }
    catch (Exception paramClass)
    {
      zzzz().zzBm().zzj("Failed to invoke Tag Manager's initialize() method", paramClass);
    }
  }
  
  protected void zzir() {}
  
  private class zza
    implements Application.ActivityLifecycleCallbacks
  {
    private zza() {}
    
    private boolean zzeD(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        zzy.this.zza("auto", "_ldl", paramString);
        return true;
      }
      return false;
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      try
      {
        zzy.this.zzzz().zzBr().zzez("onActivityCreated");
        paramActivity = paramActivity.getIntent();
        if (paramActivity == null) {
          return;
        }
        paramActivity = paramActivity.getData();
        if ((paramActivity == null) || (!paramActivity.isHierarchical())) {
          return;
        }
        paramActivity = paramActivity.getQueryParameter("referrer");
        if (TextUtils.isEmpty(paramActivity)) {
          return;
        }
        if (!paramActivity.contains("gclid"))
        {
          zzy.this.zzzz().zzBq().zzez("Activity created with data 'referrer' param without gclid");
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        zzy.this.zzzz().zzBl().zzj("Throwable caught in onActivityCreated", paramActivity);
        return;
      }
      zzy.this.zzzz().zzBq().zzj("Activity created with referrer", paramActivity);
      zzeD(paramActivity);
    }
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */