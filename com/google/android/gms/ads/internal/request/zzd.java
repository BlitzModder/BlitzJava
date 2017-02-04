package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziv;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjg.zza;
import com.google.android.gms.internal.zzjg.zzc;

@zzha
public abstract class zzd
  implements zzc.zza, zzir<Void>
{
  private final zzjg<AdRequestInfoParcel> zzGi;
  private final zzc.zza zzGj;
  private final Object zzpK = new Object();
  
  public zzd(zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
  {
    this.zzGi = paramzzjg;
    this.zzGj = paramzza;
  }
  
  public void cancel()
  {
    zzge();
  }
  
  boolean zza(zzj paramzzj, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    try
    {
      paramzzj.zza(paramAdRequestInfoParcel, new zzg(this));
      return true;
    }
    catch (RemoteException paramzzj)
    {
      zzb.zzd("Could not fetch ad response from ad request service.", paramzzj);
      zzp.zzbA().zzb(paramzzj, true);
      this.zzGj.zzb(new AdResponseParcel(0));
      return false;
    }
    catch (NullPointerException paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzbA().zzb(paramzzj, true);
      }
    }
    catch (SecurityException paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzbA().zzb(paramzzj, true);
      }
    }
    catch (Throwable paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzbA().zzb(paramzzj, true);
      }
    }
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    synchronized (this.zzpK)
    {
      this.zzGj.zzb(paramAdResponseParcel);
      zzge();
      return;
    }
  }
  
  public Void zzfO()
  {
    final zzj localzzj = zzgf();
    if (localzzj == null)
    {
      this.zzGj.zzb(new AdResponseParcel(0));
      zzge();
      return null;
    }
    this.zzGi.zza(new zzjg.zzc()new zzjg.zza
    {
      public void zzc(AdRequestInfoParcel paramAnonymousAdRequestInfoParcel)
      {
        if (!zzd.this.zza(localzzj, paramAnonymousAdRequestInfoParcel)) {
          zzd.this.zzge();
        }
      }
    }, new zzjg.zza()
    {
      public void run()
      {
        zzd.this.zzge();
      }
    });
    return null;
  }
  
  public abstract void zzge();
  
  public abstract zzj zzgf();
  
  @zzha
  public static final class zza
    extends zzd
  {
    private final Context mContext;
    
    public zza(Context paramContext, zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
    {
      super(paramzza);
      this.mContext = paramContext;
    }
    
    public void zzge() {}
    
    public zzj zzgf()
    {
      zzbs localzzbs = new zzbs((String)zzbz.zzvg.get());
      return zzhc.zza(this.mContext, localzzbs, zzhb.zzgn());
    }
  }
  
  @zzha
  public static class zzb
    extends zzd
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private Context mContext;
    private zzjg<AdRequestInfoParcel> zzGi;
    private final zzc.zza zzGj;
    protected zze zzGm;
    private boolean zzGn;
    private VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    
    public zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
    {
      super(paramzza);
      this.mContext = paramContext;
      this.zzpI = paramVersionInfoParcel;
      this.zzGi = paramzzjg;
      this.zzGj = paramzza;
      if (((Boolean)zzbz.zzvF.get()).booleanValue()) {
        this.zzGn = true;
      }
      for (paramVersionInfoParcel = zzp.zzbJ().zzhk();; paramVersionInfoParcel = paramContext.getMainLooper())
      {
        this.zzGm = new zze(paramContext, paramVersionInfoParcel, this, this, this.zzpI.zzLG);
        connect();
        return;
      }
    }
    
    protected void connect()
    {
      this.zzGm.zzqp();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      zzfO();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
      zzgg().zzfR();
      paramConnectionResult = new Bundle();
      paramConnectionResult.putString("action", "gms_connection_failed_fallback_to_local");
      zzp.zzbx().zzb(this.mContext, this.zzpI.afmaVersion, "gmob-apps", paramConnectionResult, true);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzb.zzaF("Disconnected from remote ad request service.");
    }
    
    public void zzge()
    {
      synchronized (this.zzpK)
      {
        if ((this.zzGm.isConnected()) || (this.zzGm.isConnecting())) {
          this.zzGm.disconnect();
        }
        Binder.flushPendingCommands();
        if (this.zzGn)
        {
          zzp.zzbJ().zzhl();
          this.zzGn = false;
        }
        return;
      }
    }
    
    /* Error */
    public zzj zzgf()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	com/google/android/gms/ads/internal/request/zzd$zzb:zzpK	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 90	com/google/android/gms/ads/internal/request/zzd$zzb:zzGm	Lcom/google/android/gms/ads/internal/request/zze;
      //   11: invokevirtual 187	com/google/android/gms/ads/internal/request/zze:zzgj	()Lcom/google/android/gms/ads/internal/request/zzj;
      //   14: astore_2
      //   15: aload_1
      //   16: monitorexit
      //   17: aload_2
      //   18: areturn
      //   19: aload_1
      //   20: monitorexit
      //   21: aconst_null
      //   22: areturn
      //   23: astore_2
      //   24: aload_1
      //   25: monitorexit
      //   26: aload_2
      //   27: athrow
      //   28: astore_2
      //   29: goto -10 -> 19
      //   32: astore_2
      //   33: goto -14 -> 19
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	zzb
      //   14	4	2	localzzj	zzj
      //   23	4	2	localObject2	Object
      //   28	1	2	localDeadObjectException	android.os.DeadObjectException
      //   32	1	2	localIllegalStateException	IllegalStateException
      // Exception table:
      //   from	to	target	type
      //   7	15	23	finally
      //   15	17	23	finally
      //   19	21	23	finally
      //   24	26	23	finally
      //   7	15	28	android/os/DeadObjectException
      //   7	15	32	java/lang/IllegalStateException
    }
    
    zzir zzgg()
    {
      return new zzd.zza(this.mContext, this.zzGi, this.zzGj);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */