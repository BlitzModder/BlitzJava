package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long zzalW;
  private final int zzalX;
  private final SimpleArrayMap<String, Long> zzalY;
  
  public zze()
  {
    this.zzalW = 60000L;
    this.zzalX = 10;
    this.zzalY = new SimpleArrayMap(10);
  }
  
  public zze(int paramInt, long paramLong)
  {
    this.zzalW = paramLong;
    this.zzalX = paramInt;
    this.zzalY = new SimpleArrayMap();
  }
  
  private void zzb(long paramLong1, long paramLong2)
  {
    int i = this.zzalY.size() - 1;
    while (i >= 0)
    {
      if (paramLong2 - ((Long)this.zzalY.valueAt(i)).longValue() > paramLong1) {
        this.zzalY.removeAt(i);
      }
      i -= 1;
    }
  }
  
  public Long zzcM(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.zzalW;
    try
    {
      while (this.zzalY.size() >= this.zzalX)
      {
        zzb(l1, l2);
        l1 /= 2L;
        Log.w("ConnectionTracker", "The max capacity " + this.zzalX + " is not enough. Current durationThreshold is: " + l1);
      }
      paramString = (Long)this.zzalY.put(paramString, Long.valueOf(l2));
    }
    finally {}
    return paramString;
  }
  
  public boolean zzcN(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.zzalY.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */