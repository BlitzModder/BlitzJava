package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.lang.ref.WeakReference;

@zzha
public class zzo
{
  private final zza zzqn;
  private AdRequestParcel zzqo;
  private boolean zzqp = false;
  private boolean zzqq = false;
  private long zzqr = 0L;
  private final Runnable zzx;
  
  public zzo(zza paramzza)
  {
    this(paramzza, new zza(zzip.zzKO));
  }
  
  zzo(zza paramzza, zza paramzza1)
  {
    this.zzqn = paramzza1;
    this.zzx = new Runnable()
    {
      public void run()
      {
        zzo.zza(zzo.this, false);
        zza localzza = (zza)this.zzqs.get();
        if (localzza != null) {
          localzza.zzd(zzo.zza(zzo.this));
        }
      }
    };
  }
  
  public void cancel()
  {
    this.zzqp = false;
    this.zzqn.removeCallbacks(this.zzx);
  }
  
  public void pause()
  {
    this.zzqq = true;
    if (this.zzqp) {
      this.zzqn.removeCallbacks(this.zzx);
    }
  }
  
  public void resume()
  {
    this.zzqq = false;
    if (this.zzqp)
    {
      this.zzqp = false;
      zza(this.zzqo, this.zzqr);
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    if (this.zzqp) {
      zzb.zzaH("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      this.zzqo = paramAdRequestParcel;
      this.zzqp = true;
      this.zzqr = paramLong;
    } while (this.zzqq);
    zzb.zzaG("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    this.zzqn.postDelayed(this.zzx, paramLong);
  }
  
  public boolean zzbr()
  {
    return this.zzqp;
  }
  
  public void zzg(AdRequestParcel paramAdRequestParcel)
  {
    zza(paramAdRequestParcel, 60000L);
  }
  
  public static class zza
  {
    private final Handler mHandler;
    
    public zza(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return this.mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      this.mHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */