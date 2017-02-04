package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzhu
  extends zzil
  implements zzhv, zzhy
{
  private final Context mContext;
  private final String zzBd;
  private final zzie.zza zzFc;
  private int zzFt = 3;
  private final String zzJg;
  private final zzht zzJo;
  private final zzhy zzJp;
  private final String zzJq;
  private int zzJr = 0;
  private final Object zzpK;
  
  public zzhu(Context paramContext, String paramString1, String paramString2, String paramString3, zzie.zza paramzza, zzht paramzzht, zzhy paramzzhy)
  {
    this.mContext = paramContext;
    this.zzBd = paramString1;
    this.zzJg = paramString2;
    this.zzJq = paramString3;
    this.zzFc = paramzza;
    this.zzJo = paramzzht;
    this.zzpK = new Object();
    this.zzJp = paramzzhy;
  }
  
  private void zzk(long paramLong)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzJr != 0) {
          return;
        }
        if (!zzf(paramLong)) {
          return;
        }
      }
    }
  }
  
  public void onStop() {}
  
  public void zzN(int paramInt)
  {
    zza(this.zzBd, 0);
  }
  
  public void zza(String arg1, int paramInt)
  {
    synchronized (this.zzpK)
    {
      this.zzJr = 2;
      this.zzFt = paramInt;
      this.zzpK.notify();
      return;
    }
  }
  
  public void zzaw(String arg1)
  {
    synchronized (this.zzpK)
    {
      this.zzJr = 1;
      this.zzpK.notify();
      return;
    }
  }
  
  public void zzbp()
  {
    if ((this.zzJo == null) || (this.zzJo.zzgB() == null) || (this.zzJo.zzgA() == null)) {
      return;
    }
    final zzhx localzzhx = this.zzJo.zzgB();
    localzzhx.zza(this);
    localzzhx.zza(this);
    final AdRequestParcel localAdRequestParcel = this.zzFc.zzJK.zzGq;
    final zzex localzzex = this.zzJo.zzgA();
    try
    {
      if (localzzex.isInitialized()) {
        zza.zzLE.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzex.zzc(localAdRequestParcel, zzhu.zza(zzhu.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to load ad from adapter.", localRemoteException);
              zzhu.this.zza(zzhu.zzb(zzhu.this), 0);
            }
          }
        });
      }
      for (;;)
      {
        zzk(zzp.zzbB().elapsedRealtime());
        localzzhx.zza(null);
        localzzhx.zza(null);
        if (this.zzJr != 1) {
          break;
        }
        this.zzJp.zzaw(this.zzBd);
        return;
        zza.zzLE.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzex.zza(zze.zzB(zzhu.zzc(zzhu.this)), localAdRequestParcel, zzhu.zzd(zzhu.this), localzzhx, zzhu.zza(zzhu.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to initialize adapter " + zzhu.zzb(zzhu.this), localRemoteException);
              zzhu.this.zza(zzhu.zzb(zzhu.this), 0);
            }
          }
        });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Fail to check if adapter is initialized.", localRemoteException);
        zza(this.zzBd, 0);
      }
      this.zzJp.zza(this.zzBd, this.zzFt);
    }
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = 20000L - (zzp.zzbB().elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.zzpK.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public void zzgC()
  {
    this.zzJo.zzgB();
    AdRequestParcel localAdRequestParcel = this.zzFc.zzJK.zzGq;
    zzex localzzex = this.zzJo.zzgA();
    try
    {
      localzzex.zzc(localAdRequestParcel, this.zzJq);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Fail to load ad from adapter.", localRemoteException);
      zza(this.zzBd, 0);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */