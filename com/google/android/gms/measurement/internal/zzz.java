package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzz
  extends zzw
{
  private final zza zzaUS;
  private zzl zzaUT;
  private Boolean zzaUU;
  private final zze zzaUV;
  private final zzaa zzaUW;
  private final List<Runnable> zzaUX = new ArrayList();
  private final zze zzaUY;
  
  protected zzz(zzt paramzzt)
  {
    super(paramzzt);
    this.zzaUW = new zzaa(paramzzt.zziT());
    this.zzaUS = new zza();
    this.zzaUV = new zze(paramzzt)
    {
      public void run()
      {
        zzz.zzb(zzz.this);
      }
    };
    this.zzaUY = new zze(paramzzt)
    {
      public void run()
      {
        zzz.this.zzzz().zzBm().zzez("Tasks have been queued for a long time");
      }
    };
  }
  
  private void onServiceDisconnected(ComponentName paramComponentName)
  {
    zziS();
    if (this.zzaUT != null)
    {
      this.zzaUT = null;
      zzzz().zzBr().zzj("Disconnected from device MeasurementService", paramComponentName);
      zzBY();
    }
  }
  
  private boolean zzBW()
  {
    List localList = getContext().getPackageManager().queryIntentServices(new Intent(getContext(), AppMeasurementService.class), 65536);
    return (localList != null) && (localList.size() > 0);
  }
  
  private boolean zzBX()
  {
    zziS();
    zzje();
    if (zzAX().zzka()) {
      return true;
    }
    Intent localIntent = new Intent("com.google.android.gms.measurement.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
    zzb localzzb = zzb.zzrz();
    zzzz().zzBr().zzez("Checking service availability");
    if (localzzb.zza(getContext(), localIntent, new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    }, 0))
    {
      zzzz().zzBr().zzez("Service available");
      return true;
    }
    return false;
  }
  
  private void zzBY()
  {
    zziS();
    zzjG();
  }
  
  private void zzBZ()
  {
    zziS();
    zzzz().zzBr().zzj("Processing queued up service tasks", Integer.valueOf(this.zzaUX.size()));
    Iterator localIterator = this.zzaUX.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      zzAV().zzg(localRunnable);
    }
    this.zzaUX.clear();
    this.zzaUY.cancel();
  }
  
  private void zza(zzl paramzzl)
  {
    zziS();
    zzx.zzy(paramzzl);
    this.zzaUT = paramzzl;
    zzjr();
    zzBZ();
  }
  
  private void zzi(Runnable paramRunnable)
    throws IllegalStateException
  {
    zziS();
    if (isConnected())
    {
      paramRunnable.run();
      return;
    }
    if (this.zzaUX.size() >= zzAX().zzAH())
    {
      zzzz().zzBl().zzez("Discarding data. Max runnable queue size reached");
      return;
    }
    this.zzaUX.add(paramRunnable);
    if (!this.zzaQX.zzBI()) {
      this.zzaUY.zzt(60000L);
    }
    zzjG();
  }
  
  private void zzjG()
  {
    zziS();
    zzje();
    if (isConnected()) {
      return;
    }
    if (this.zzaUU == null)
    {
      this.zzaUU = zzAW().zzBx();
      if (this.zzaUU == null)
      {
        zzzz().zzBr().zzez("State of service unknown");
        this.zzaUU = Boolean.valueOf(zzBX());
        zzAW().zzap(this.zzaUU.booleanValue());
      }
    }
    if (this.zzaUU.booleanValue())
    {
      zzzz().zzBr().zzez("Using measurement service");
      this.zzaUS.zzCa();
      return;
    }
    if ((zzBW()) && (!this.zzaQX.zzBI()))
    {
      zzzz().zzBr().zzez("Using local app measurement service");
      Intent localIntent = new Intent("com.google.android.gms.measurement.START");
      localIntent.setComponent(new ComponentName(getContext(), AppMeasurementService.class));
      this.zzaUS.zzA(localIntent);
      return;
    }
    if (zzAX().zzkb())
    {
      zzzz().zzBr().zzez("Using direct local measurement implementation");
      zza(new zzu(this.zzaQX, true));
      return;
    }
    zzzz().zzBl().zzez("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
  }
  
  private void zzjr()
  {
    zziS();
    this.zzaUW.start();
    if (!this.zzaQX.zzBI()) {
      this.zzaUV.zzt(zzAX().zzkv());
    }
  }
  
  private void zzjs()
  {
    zziS();
    if (!isConnected()) {
      return;
    }
    zzzz().zzBr().zzez("Inactivity, disconnecting from AppMeasurementService");
    disconnect();
  }
  
  public void disconnect()
  {
    zziS();
    zzje();
    try
    {
      zzb.zzrz().zza(getContext(), this.zzaUS);
      this.zzaUT = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public boolean isConnected()
  {
    zziS();
    zzje();
    return this.zzaUT != null;
  }
  
  protected void zzBS()
  {
    zziS();
    zzje();
    zzi(new Runnable()
    {
      public void run()
      {
        zzl localzzl = zzz.zzc(zzz.this);
        if (localzzl == null)
        {
          zzz.this.zzzz().zzBl().zzez("Discarding data. Failed to send app launch");
          return;
        }
        try
        {
          localzzl.zza(zzz.this.zzAS().zzex(zzz.this.zzzz().zzBs()));
          zzz.zzd(zzz.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzz.this.zzzz().zzBl().zzj("Failed to send app launch to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected void zzBV()
  {
    zziS();
    zzje();
    zzi(new Runnable()
    {
      public void run()
      {
        zzl localzzl = zzz.zzc(zzz.this);
        if (localzzl == null)
        {
          zzz.this.zzzz().zzBl().zzez("Failed to send measurementEnabled to service");
          return;
        }
        try
        {
          localzzl.zzb(zzz.this.zzAS().zzex(zzz.this.zzzz().zzBs()));
          zzz.zzd(zzz.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzz.this.zzzz().zzBl().zzj("Failed to send measurementEnabled to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected void zza(final UserAttributeParcel paramUserAttributeParcel)
  {
    zziS();
    zzje();
    zzi(new Runnable()
    {
      public void run()
      {
        zzl localzzl = zzz.zzc(zzz.this);
        if (localzzl == null)
        {
          zzz.this.zzzz().zzBl().zzez("Discarding data. Failed to set user attribute");
          return;
        }
        try
        {
          localzzl.zza(paramUserAttributeParcel, zzz.this.zzAS().zzex(zzz.this.zzzz().zzBs()));
          zzz.zzd(zzz.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzz.this.zzzz().zzBl().zzj("Failed to send attribute to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected void zzb(final EventParcel paramEventParcel, final String paramString)
  {
    zzx.zzy(paramEventParcel);
    zziS();
    zzje();
    zzi(new Runnable()
    {
      public void run()
      {
        zzl localzzl = zzz.zzc(zzz.this);
        if (localzzl == null)
        {
          zzz.this.zzzz().zzBl().zzez("Discarding data. Failed to send event to service");
          return;
        }
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty(paramString))
            {
              localzzl.zza(paramEventParcel, zzz.this.zzAS().zzex(zzz.this.zzzz().zzBs()));
              zzz.zzd(zzz.this);
              return;
            }
          }
          catch (RemoteException localRemoteException)
          {
            zzz.this.zzzz().zzBl().zzj("Failed to send event to AppMeasurementService", localRemoteException);
            return;
          }
          localRemoteException.zza(paramEventParcel, paramString, zzz.this.zzzz().zzBs());
        }
      }
    });
  }
  
  protected void zzir() {}
  
  protected class zza
    implements ServiceConnection, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private volatile boolean zzaVa;
    private volatile zzn zzaVb;
    
    protected zza() {}
    
    public void onConnected(final Bundle paramBundle)
    {
      zzx.zzcx("MeasurementServiceConnection.onConnected");
      for (;;)
      {
        try
        {
          this.zzaVa = false;
        }
        finally {}
        try
        {
          paramBundle = (zzl)this.zzaVb.zzqs();
          this.zzaVb = null;
          zzz.this.zzAV().zzg(new Runnable()
          {
            public void run()
            {
              if (!zzz.this.isConnected())
              {
                zzz.this.zzzz().zzBq().zzez("Connected to remote service");
                zzz.zza(zzz.this, paramBundle);
              }
            }
          });
          return;
        }
        catch (IllegalStateException paramBundle)
        {
          continue;
        }
        catch (DeadObjectException paramBundle)
        {
          continue;
        }
        this.zzaVb = null;
      }
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzx.zzcx("MeasurementServiceConnection.onConnectionFailed");
      zzz.this.zzzz().zzBm().zzj("Service connection failed", paramConnectionResult);
      try
      {
        this.zzaVa = false;
        this.zzaVb = null;
        return;
      }
      finally {}
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzx.zzcx("MeasurementServiceConnection.onConnectionSuspended");
      zzz.this.zzzz().zzBq().zzez("Service connection suspended");
      zzz.this.zzAV().zzg(new Runnable()
      {
        public void run()
        {
          zzz.zza(zzz.this, new ComponentName(zzz.this.getContext(), AppMeasurementService.class));
        }
      });
    }
    
    /* Error */
    public void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
    {
      // Byte code:
      //   0: ldc 119
      //   2: invokestatic 49	com/google/android/gms/common/internal/zzx:zzcx	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: iconst_0
      //   9: putfield 51	com/google/android/gms/measurement/internal/zzz$zza:zzaVa	Z
      //   12: aload_2
      //   13: ifnonnull +21 -> 34
      //   16: aload_0
      //   17: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   20: invokevirtual 82	com/google/android/gms/measurement/internal/zzz:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   23: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   26: ldc 124
      //   28: invokevirtual 108	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: aconst_null
      //   35: astore 4
      //   37: aconst_null
      //   38: astore_3
      //   39: aload 4
      //   41: astore_1
      //   42: aload_2
      //   43: invokeinterface 130 1 0
      //   48: astore 5
      //   50: aload 4
      //   52: astore_1
      //   53: ldc -124
      //   55: aload 5
      //   57: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   60: ifeq +62 -> 122
      //   63: aload 4
      //   65: astore_1
      //   66: aload_2
      //   67: invokestatic 144	com/google/android/gms/measurement/internal/zzl$zza:zzdi	(Landroid/os/IBinder;)Lcom/google/android/gms/measurement/internal/zzl;
      //   70: astore_2
      //   71: aload_2
      //   72: astore_1
      //   73: aload_0
      //   74: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   77: invokevirtual 82	com/google/android/gms/measurement/internal/zzz:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   80: invokevirtual 147	com/google/android/gms/measurement/internal/zzo:zzBr	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   83: ldc -107
      //   85: invokevirtual 108	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
      //   88: aload_2
      //   89: astore_1
      //   90: aload_1
      //   91: ifnonnull +75 -> 166
      //   94: invokestatic 155	com/google/android/gms/common/stats/zzb:zzrz	()Lcom/google/android/gms/common/stats/zzb;
      //   97: aload_0
      //   98: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   101: invokevirtual 159	com/google/android/gms/measurement/internal/zzz:getContext	()Landroid/content/Context;
      //   104: aload_0
      //   105: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   108: invokestatic 162	com/google/android/gms/measurement/internal/zzz:zza	(Lcom/google/android/gms/measurement/internal/zzz;)Lcom/google/android/gms/measurement/internal/zzz$zza;
      //   111: invokevirtual 165	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
      //   114: aload_0
      //   115: monitorexit
      //   116: return
      //   117: astore_1
      //   118: aload_0
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: aload 4
      //   124: astore_1
      //   125: aload_0
      //   126: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   129: invokevirtual 82	com/google/android/gms/measurement/internal/zzz:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   132: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   135: ldc -89
      //   137: aload 5
      //   139: invokevirtual 96	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   142: aload_3
      //   143: astore_1
      //   144: goto -54 -> 90
      //   147: astore_2
      //   148: aload_0
      //   149: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   152: invokevirtual 82	com/google/android/gms/measurement/internal/zzz:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   155: invokevirtual 122	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   158: ldc -87
      //   160: invokevirtual 108	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
      //   163: goto -73 -> 90
      //   166: aload_0
      //   167: getfield 31	com/google/android/gms/measurement/internal/zzz$zza:zzaUZ	Lcom/google/android/gms/measurement/internal/zzz;
      //   170: invokevirtual 65	com/google/android/gms/measurement/internal/zzz:zzAV	()Lcom/google/android/gms/measurement/internal/zzs;
      //   173: new 15	com/google/android/gms/measurement/internal/zzz$zza$1
      //   176: dup
      //   177: aload_0
      //   178: aload_1
      //   179: invokespecial 170	com/google/android/gms/measurement/internal/zzz$zza$1:<init>	(Lcom/google/android/gms/measurement/internal/zzz$zza;Lcom/google/android/gms/measurement/internal/zzl;)V
      //   182: invokevirtual 74	com/google/android/gms/measurement/internal/zzs:zzg	(Ljava/lang/Runnable;)V
      //   185: goto -71 -> 114
      //   188: astore_1
      //   189: goto -75 -> 114
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	192	0	this	zza
      //   0	192	1	paramComponentName	ComponentName
      //   0	192	2	paramIBinder	IBinder
      //   38	105	3	localObject1	Object
      //   35	88	4	localObject2	Object
      //   48	90	5	str	String
      // Exception table:
      //   from	to	target	type
      //   7	12	117	finally
      //   16	33	117	finally
      //   42	50	117	finally
      //   53	63	117	finally
      //   66	71	117	finally
      //   73	88	117	finally
      //   94	114	117	finally
      //   114	116	117	finally
      //   118	120	117	finally
      //   125	142	117	finally
      //   148	163	117	finally
      //   166	185	117	finally
      //   42	50	147	android/os/RemoteException
      //   53	63	147	android/os/RemoteException
      //   66	71	147	android/os/RemoteException
      //   73	88	147	android/os/RemoteException
      //   125	142	147	android/os/RemoteException
      //   94	114	188	java/lang/IllegalArgumentException
    }
    
    public void onServiceDisconnected(final ComponentName paramComponentName)
    {
      zzx.zzcx("MeasurementServiceConnection.onServiceDisconnected");
      zzz.this.zzzz().zzBq().zzez("Service disconnected");
      zzz.this.zzAV().zzg(new Runnable()
      {
        public void run()
        {
          zzz.zza(zzz.this, paramComponentName);
        }
      });
    }
    
    public void zzA(Intent paramIntent)
    {
      zzz.this.zziS();
      Context localContext = zzz.this.getContext();
      zzb localzzb = zzb.zzrz();
      try
      {
        if (this.zzaVa)
        {
          zzz.this.zzzz().zzBr().zzez("Connection attempt already in progress");
          return;
        }
        this.zzaVa = true;
        localzzb.zza(localContext, paramIntent, zzz.zza(zzz.this), 129);
        return;
      }
      finally {}
    }
    
    public void zzCa()
    {
      zzz.this.zziS();
      Context localContext1 = zzz.this.getContext();
      try
      {
        if (this.zzaVa)
        {
          zzz.this.zzzz().zzBr().zzez("Connection attempt already in progress");
          return;
        }
        if (this.zzaVb != null)
        {
          zzz.this.zzzz().zzBr().zzez("Already awaiting connection attempt");
          return;
        }
      }
      finally {}
      this.zzaVb = new zzn(localContext2, Looper.getMainLooper(), zzf.zzas(localContext2), this, this);
      zzz.this.zzzz().zzBr().zzez("Connecting to remote service");
      this.zzaVa = true;
      this.zzaVb.zzqp();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */