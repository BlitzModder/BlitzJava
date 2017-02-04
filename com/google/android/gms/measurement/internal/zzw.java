package com.google.android.gms.measurement.internal;

abstract class zzw
  extends zzv
{
  private boolean zzOQ;
  private boolean zzOR;
  private boolean zzaUH;
  
  zzw(zzt paramzzt)
  {
    super(paramzzt);
    this.zzaQX.zzb(this);
  }
  
  boolean isInitialized()
  {
    return (this.zzOQ) && (!this.zzOR);
  }
  
  boolean zzBP()
  {
    return this.zzaUH;
  }
  
  public final void zza()
  {
    if (this.zzOQ) {
      throw new IllegalStateException("Can't initialize twice");
    }
    zzir();
    this.zzaQX.zzBO();
    this.zzOQ = true;
  }
  
  protected abstract void zzir();
  
  protected void zzje()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */