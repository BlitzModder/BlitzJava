package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

class zzaa
{
  private long zzBv;
  private final zznl zzqD;
  
  public zzaa(zznl paramzznl)
  {
    zzx.zzy(paramzznl);
    this.zzqD = paramzznl;
  }
  
  public void clear()
  {
    this.zzBv = 0L;
  }
  
  public void start()
  {
    this.zzBv = this.zzqD.elapsedRealtime();
  }
  
  public boolean zzv(long paramLong)
  {
    if (this.zzBv == 0L) {}
    while (this.zzqD.elapsedRealtime() - this.zzBv >= paramLong) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */