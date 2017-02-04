package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzno
  implements zznl
{
  private static zzno zzamk;
  
  public static zznl zzrM()
  {
    try
    {
      if (zzamk == null) {
        zzamk = new zzno();
      }
      zzno localzzno = zzamk;
      return localzzno;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */