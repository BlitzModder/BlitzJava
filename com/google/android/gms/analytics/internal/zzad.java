package com.google.android.gms.analytics.internal;

public class zzad
{
  private final String zzRA;
  private final long zzRv;
  private final int zzRw;
  private double zzRx;
  private long zzRy;
  private final Object zzRz = new Object();
  
  public zzad(int paramInt, long paramLong, String paramString)
  {
    this.zzRw = paramInt;
    this.zzRx = this.zzRw;
    this.zzRv = paramLong;
    this.zzRA = paramString;
  }
  
  public zzad(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean zzlf()
  {
    synchronized (this.zzRz)
    {
      long l = System.currentTimeMillis();
      if (this.zzRx < this.zzRw)
      {
        double d = (l - this.zzRy) / this.zzRv;
        if (d > 0.0D) {
          this.zzRx = Math.min(this.zzRw, d + this.zzRx);
        }
      }
      this.zzRy = l;
      if (this.zzRx >= 1.0D)
      {
        this.zzRx -= 1.0D;
        return true;
      }
      zzae.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */