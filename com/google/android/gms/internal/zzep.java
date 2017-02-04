package com.google.android.gms.internal;

@zzha
public final class zzep
  extends zzey.zza
{
  private zzer.zza zzBb;
  private zzeo zzBc;
  private final Object zzpK = new Object();
  
  public void onAdClicked()
  {
    synchronized (this.zzpK)
    {
      if (this.zzBc != null) {
        this.zzBc.zzaZ();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.zzpK)
    {
      if (this.zzBc != null) {
        this.zzBc.zzba();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzBb != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.zzBb.zzr(paramInt);
            this.zzBb = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (this.zzpK)
    {
      if (this.zzBc != null) {
        this.zzBc.zzbb();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.zzpK)
    {
      if (this.zzBb != null)
      {
        this.zzBb.zzr(0);
        this.zzBb = null;
        return;
      }
      if (this.zzBc != null) {
        this.zzBc.zzbd();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.zzpK)
    {
      if (this.zzBc != null) {
        this.zzBc.zzbc();
      }
      return;
    }
  }
  
  public void zza(zzeo paramzzeo)
  {
    synchronized (this.zzpK)
    {
      this.zzBc = paramzzeo;
      return;
    }
  }
  
  public void zza(zzer.zza paramzza)
  {
    synchronized (this.zzpK)
    {
      this.zzBb = paramzza;
      return;
    }
  }
  
  public void zza(zzez paramzzez)
  {
    synchronized (this.zzpK)
    {
      if (this.zzBb != null)
      {
        this.zzBb.zza(0, paramzzez);
        this.zzBb = null;
        return;
      }
      if (this.zzBc != null) {
        this.zzBc.zzbd();
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */