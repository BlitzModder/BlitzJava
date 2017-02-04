package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzix
{
  private long zzLv;
  private long zzLw = Long.MIN_VALUE;
  private Object zzpK = new Object();
  
  public zzix(long paramLong)
  {
    this.zzLv = paramLong;
  }
  
  public boolean tryAcquire()
  {
    synchronized (this.zzpK)
    {
      long l = zzp.zzbB().elapsedRealtime();
      if (this.zzLw + this.zzLv > l) {
        return false;
      }
      this.zzLw = l;
      return true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */