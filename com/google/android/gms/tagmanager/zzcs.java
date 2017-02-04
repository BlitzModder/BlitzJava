package com.google.android.gms.tagmanager;

class zzcs
  implements zzcd
{
  private final long zzRv;
  private final int zzRw;
  private double zzRx;
  private final Object zzRz = new Object();
  private long zzbfH;
  
  public zzcs()
  {
    this(60, 2000L);
  }
  
  public zzcs(int paramInt, long paramLong)
  {
    this.zzRw = paramInt;
    this.zzRx = this.zzRw;
    this.zzRv = paramLong;
  }
  
  public boolean zzlf()
  {
    synchronized (this.zzRz)
    {
      long l = System.currentTimeMillis();
      if (this.zzRx < this.zzRw)
      {
        double d = (l - this.zzbfH) / this.zzRv;
        if (d > 0.0D) {
          this.zzRx = Math.min(this.zzRw, d + this.zzRx);
        }
      }
      this.zzbfH = l;
      if (this.zzRx >= 1.0D)
      {
        this.zzRx -= 1.0D;
        return true;
      }
      zzbg.zzaH("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */