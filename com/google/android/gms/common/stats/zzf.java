package com.google.android.gms.common.stats;

public abstract class zzf
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    return getTimeMillis() + "\t" + getEventType() + "\t" + zzrv() + zzry();
  }
  
  public abstract long zzrv();
  
  public abstract String zzry();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */