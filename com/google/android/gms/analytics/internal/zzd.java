package com.google.android.gms.analytics.internal;

public abstract class zzd
  extends zzc
{
  private boolean zzOQ;
  private boolean zzOR;
  
  protected zzd(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public boolean isInitialized()
  {
    return (this.zzOQ) && (!this.zzOR);
  }
  
  public void zza()
  {
    zzir();
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */