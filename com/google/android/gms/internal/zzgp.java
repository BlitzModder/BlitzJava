package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public abstract class zzgp
  extends zzil
{
  protected final Context mContext;
  protected final zzgq.zza zzFb;
  protected final zzie.zza zzFc;
  protected AdResponseParcel zzFd;
  protected final Object zzFf = new Object();
  protected final Object zzpK = new Object();
  
  protected zzgp(Context paramContext, zzie.zza paramzza, zzgq.zza paramzza1)
  {
    super(true);
    this.mContext = paramContext;
    this.zzFc = paramzza;
    this.zzFd = paramzza.zzJL;
    this.zzFb = paramzza1;
  }
  
  public void onStop() {}
  
  protected abstract zzie zzD(int paramInt);
  
  public void zzbp()
  {
    for (;;)
    {
      int i;
      synchronized (this.zzpK)
      {
        zzb.zzaF("AdRendererBackgroundTask started.");
        i = this.zzFc.errorCode;
        try
        {
          zzh(SystemClock.elapsedRealtime());
          final zzie localzzie = zzD(i);
          zzip.zzKO.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzgp.this.zzpK)
              {
                zzgp.this.zzi(localzzie);
                return;
              }
            }
          });
          return;
        }
        catch (zza localzza)
        {
          i = localzza.getErrorCode();
          if (i == 3) {
            continue;
          }
        }
        if (i == -1)
        {
          zzb.zzaG(localzza.getMessage());
          if (this.zzFd == null)
          {
            this.zzFd = new AdResponseParcel(i);
            zzip.zzKO.post(new Runnable()
            {
              public void run()
              {
                zzgp.this.onStop();
              }
            });
          }
        }
        else
        {
          zzb.zzaH(localzza.getMessage());
        }
      }
      this.zzFd = new AdResponseParcel(i, this.zzFd.zzAU);
    }
  }
  
  protected abstract void zzh(long paramLong)
    throws zzgp.zza;
  
  protected void zzi(zzie paramzzie)
  {
    this.zzFb.zzb(paramzzie);
  }
  
  protected static final class zza
    extends Exception
  {
    private final int zzFt;
    
    public zza(String paramString, int paramInt)
    {
      super();
      this.zzFt = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.zzFt;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */