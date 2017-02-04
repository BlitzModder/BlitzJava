package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zznl;

class zzbe
  implements zzcd
{
  private final String zzRA;
  private final long zzRv;
  private final int zzRw;
  private double zzRx;
  private long zzRy;
  private final Object zzRz = new Object();
  private final long zzbem;
  private final zznl zzqD;
  
  public zzbe(int paramInt, long paramLong1, long paramLong2, String paramString, zznl paramzznl)
  {
    this.zzRw = paramInt;
    this.zzRx = this.zzRw;
    this.zzRv = paramLong1;
    this.zzbem = paramLong2;
    this.zzRA = paramString;
    this.zzqD = paramzznl;
  }
  
  public boolean zzlf()
  {
    synchronized (this.zzRz)
    {
      long l = this.zzqD.currentTimeMillis();
      if (l - this.zzRy < this.zzbem)
      {
        zzbg.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
        return false;
      }
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
    }
    zzbg.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */