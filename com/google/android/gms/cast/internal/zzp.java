package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp
{
  private static final zzl zzYy = new zzl("RequestTracker");
  public static final Object zzacU = new Object();
  private long zzabr;
  private long zzacR;
  private long zzacS;
  private zzo zzacT;
  
  public zzp(long paramLong)
  {
    this.zzacR = paramLong;
    this.zzabr = -1L;
    this.zzacS = 0L;
  }
  
  private void zzoh()
  {
    this.zzabr = -1L;
    this.zzacT = null;
    this.zzacS = 0L;
  }
  
  public void clear()
  {
    synchronized (zzacU)
    {
      if (this.zzabr != -1L) {
        zzoh();
      }
      return;
    }
  }
  
  public boolean zzB(long paramLong)
  {
    for (;;)
    {
      synchronized (zzacU)
      {
        if ((this.zzabr != -1L) && (this.zzabr == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zza(long paramLong, zzo paramzzo)
  {
    synchronized (zzacU)
    {
      zzo localzzo = this.zzacT;
      long l = this.zzabr;
      this.zzabr = paramLong;
      this.zzacT = paramzzo;
      this.zzacS = SystemClock.elapsedRealtime();
      if (localzzo != null) {
        localzzo.zzy(l);
      }
      return;
    }
  }
  
  public boolean zzc(long paramLong, int paramInt)
  {
    return zzc(paramLong, paramInt, null);
  }
  
  public boolean zzc(long paramLong, int paramInt, Object paramObject)
  {
    boolean bool = true;
    zzo localzzo = null;
    for (;;)
    {
      synchronized (zzacU)
      {
        if ((this.zzabr != -1L) && (this.zzabr == paramLong))
        {
          zzYy.zzb("request %d completed", new Object[] { Long.valueOf(this.zzabr) });
          localzzo = this.zzacT;
          zzoh();
          if (localzzo != null) {
            localzzo.zza(paramLong, paramInt, paramObject);
          }
          return bool;
        }
      }
      bool = false;
    }
  }
  
  public boolean zzd(long paramLong, int paramInt)
  {
    boolean bool = true;
    long l = 0L;
    for (;;)
    {
      synchronized (zzacU)
      {
        if ((this.zzabr != -1L) && (paramLong - this.zzacS >= this.zzacR))
        {
          zzYy.zzb("request %d timed out", new Object[] { Long.valueOf(this.zzabr) });
          paramLong = this.zzabr;
          zzo localzzo = this.zzacT;
          zzoh();
          if (localzzo != null) {
            localzzo.zza(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean zzoi()
  {
    for (;;)
    {
      synchronized (zzacU)
      {
        if (this.zzabr != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */