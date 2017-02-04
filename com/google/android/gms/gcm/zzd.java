package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzd
{
  public static final zzd zzaJo = new zzd(0, 30, 3600);
  public static final zzd zzaJp = new zzd(1, 30, 3600);
  private final int zzaJq;
  private final int zzaJr;
  private final int zzaJs;
  
  private zzd(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzaJq = paramInt1;
    this.zzaJr = paramInt2;
    this.zzaJs = paramInt3;
  }
  
  public Bundle zzE(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", this.zzaJq);
    paramBundle.putInt("initial_backoff_seconds", this.zzaJr);
    paramBundle.putInt("maximum_backoff_seconds", this.zzaJs);
    return paramBundle;
  }
  
  public int zzxA()
  {
    return this.zzaJq;
  }
  
  public int zzxB()
  {
    return this.zzaJr;
  }
  
  public int zzxC()
  {
    return this.zzaJs;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */