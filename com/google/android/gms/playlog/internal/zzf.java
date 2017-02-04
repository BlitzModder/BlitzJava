package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztk;
import java.util.ArrayList;
import java.util.Iterator;

public class zzf
  extends zzj<zza>
{
  private final String zzSp;
  private final zzd zzaYG;
  private final zzb zzaYH;
  private boolean zzaYI;
  private final Object zzpK;
  
  public zzf(Context paramContext, Looper paramLooper, zzd paramzzd, com.google.android.gms.common.internal.zzf paramzzf)
  {
    super(paramContext, paramLooper, 24, paramzzf, paramzzd, paramzzd);
    this.zzSp = paramContext.getPackageName();
    this.zzaYG = ((zzd)zzx.zzy(paramzzd));
    this.zzaYG.zza(this);
    this.zzaYH = new zzb();
    this.zzpK = new Object();
    this.zzaYI = true;
  }
  
  private void zzDb()
  {
    boolean bool;
    if (!this.zzaYI)
    {
      bool = true;
      com.google.android.gms.common.internal.zzb.zzaa(bool);
      if (!this.zzaYH.isEmpty()) {
        Object localObject = null;
      }
    }
    label122:
    label195:
    label228:
    for (;;)
    {
      ArrayList localArrayList;
      zzb.zza localzza;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.zzaYH.zzCZ().iterator();
        if (!localIterator.hasNext()) {
          break label195;
        }
        localzza = (zzb.zza)localIterator.next();
        if (localzza.zzaYv == null) {
          break label122;
        }
        ((zza)zzqs()).zza(this.zzSp, localzza.zzaYt, zztk.toByteArray(localzza.zzaYv));
        continue;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
      }
      bool = false;
      break;
      if (localzza.zzaYt.equals(localRemoteException))
      {
        localArrayList.add(localzza.zzaYu);
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          ((zza)zzqs()).zza(this.zzSp, localRemoteException, localArrayList);
          localArrayList.clear();
        }
        PlayLoggerContext localPlayLoggerContext = localzza.zzaYt;
        localArrayList.add(localzza.zzaYu);
        break label228;
        if (!localArrayList.isEmpty()) {
          ((zza)zzqs()).zza(this.zzSp, localPlayLoggerContext, localArrayList);
        }
        this.zzaYH.clear();
        return;
      }
    }
  }
  
  private void zzc(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    this.zzaYH.zza(paramPlayLoggerContext, paramLogEvent);
  }
  
  private void zzd(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    try
    {
      zzDb();
      ((zza)zzqs()).zza(this.zzSp, paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  public void start()
  {
    synchronized (this.zzpK)
    {
      if ((isConnecting()) || (isConnected())) {
        return;
      }
      this.zzaYG.zzar(true);
      zzqp();
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.zzpK)
    {
      this.zzaYG.zzar(false);
      disconnect();
      return;
    }
  }
  
  void zzas(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzaYI;
      this.zzaYI = paramBoolean;
      if ((bool) && (!this.zzaYI)) {
        zzDb();
      }
      return;
    }
  }
  
  public void zzb(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    synchronized (this.zzpK)
    {
      if (this.zzaYI)
      {
        zzc(paramPlayLoggerContext, paramLogEvent);
        return;
      }
      zzd(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  protected zza zzdJ(IBinder paramIBinder)
  {
    return zza.zza.zzdI(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.playlog.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.playlog.internal.IPlayLogService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/playlog/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */