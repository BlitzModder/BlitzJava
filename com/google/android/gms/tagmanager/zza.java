package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import java.io.IOException;

public class zza
{
  private static Object zzbcs = new Object();
  private static zza zzbct;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread zzKt;
  private volatile AdvertisingIdClient.Info zzOC;
  private volatile long zzbcm = 900000L;
  private volatile long zzbcn = 30000L;
  private volatile long zzbco;
  private volatile long zzbcp;
  private final Object zzbcq = new Object();
  private zza zzbcr = new zza()
  {
    public AdvertisingIdClient.Info zzDZ()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza.zza(zza.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        zzbg.zzd("IllegalStateException getting Advertising Id Info", localIllegalStateException);
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        zzbg.zzd("GooglePlayServicesRepairableException getting Advertising Id Info", localGooglePlayServicesRepairableException);
        return null;
      }
      catch (IOException localIOException)
      {
        zzbg.zzd("IOException getting Ad Id Info", localIOException);
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        zzbg.zzd("GooglePlayServicesNotAvailableException getting Advertising Id Info", localGooglePlayServicesNotAvailableException);
        return null;
      }
      catch (Exception localException)
      {
        zzbg.zzd("Unknown exception. Could not get the Advertising Id Info.", localException);
      }
      return null;
    }
  };
  private final zznl zzqD;
  
  private zza(Context paramContext)
  {
    this(paramContext, null, zzno.zzrM());
  }
  
  public zza(Context paramContext, zza paramzza, zznl paramzznl)
  {
    this.zzqD = paramzznl;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (paramzza != null) {
        this.zzbcr = paramzza;
      }
      this.zzbco = this.zzqD.currentTimeMillis();
      this.zzKt = new Thread(new Runnable()
      {
        public void run()
        {
          zza.zzb(zza.this);
        }
      });
      return;
    }
  }
  
  /* Error */
  private void zzDV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 100	com/google/android/gms/tagmanager/zza:zzDW	()V
    //   6: aload_0
    //   7: ldc2_w 101
    //   10: invokevirtual 106	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: goto -9 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	zza
    //   16	4	1	localObject	Object
    //   21	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   13	15	16	finally
    //   17	19	16	finally
    //   2	13	21	java/lang/InterruptedException
  }
  
  private void zzDW()
  {
    if (this.zzqD.currentTimeMillis() - this.zzbco > this.zzbcn) {}
    synchronized (this.zzbcq)
    {
      this.zzbcq.notify();
      this.zzbco = this.zzqD.currentTimeMillis();
      return;
    }
  }
  
  private void zzDX()
  {
    if (this.zzqD.currentTimeMillis() - this.zzbcp > 3600000L) {
      this.zzOC = null;
    }
  }
  
  private void zzDY()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed)
    {
      ??? = this.zzbcr.zzDZ();
      if (??? != null)
      {
        this.zzOC = ((AdvertisingIdClient.Info)???);
        this.zzbcp = this.zzqD.currentTimeMillis();
        zzbg.zzaG("Obtained fresh AdvertisingId info from GmsCore.");
      }
      try
      {
        notifyAll();
        try
        {
          synchronized (this.zzbcq)
          {
            this.zzbcq.wait(this.zzbcm);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          zzbg.zzaG("sleep interrupted in AdvertiserDataPoller thread; continuing");
        }
        return;
      }
      finally {}
    }
  }
  
  public static zza zzaW(Context paramContext)
  {
    if (zzbct == null) {}
    synchronized (zzbcs)
    {
      if (zzbct == null)
      {
        zzbct = new zza(paramContext);
        zzbct.start();
      }
      return zzbct;
    }
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    if (this.zzOC == null) {
      zzDV();
    }
    for (;;)
    {
      zzDX();
      if (this.zzOC != null) {
        break;
      }
      return true;
      zzDW();
    }
    return this.zzOC.isLimitAdTrackingEnabled();
  }
  
  public void start()
  {
    this.zzKt.start();
  }
  
  public String zzDU()
  {
    if (this.zzOC == null) {
      zzDV();
    }
    for (;;)
    {
      zzDX();
      if (this.zzOC != null) {
        break;
      }
      return null;
      zzDW();
    }
    return this.zzOC.getId();
  }
  
  public static abstract interface zza
  {
    public abstract AdvertisingIdClient.Info zzDZ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */