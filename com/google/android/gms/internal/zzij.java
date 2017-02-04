package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzij
{
  private final String zzJO;
  private int zzKq;
  private int zzKr;
  private final Object zzpK = new Object();
  private final zzig zzqC;
  
  zzij(zzig paramzzig, String paramString)
  {
    this.zzqC = paramzzig;
    this.zzJO = paramString;
  }
  
  public zzij(String paramString)
  {
    this(zzp.zzbA(), paramString);
  }
  
  public Bundle toBundle()
  {
    synchronized (this.zzpK)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.zzKq);
      localBundle.putInt("pmnll", this.zzKr);
      return localBundle;
    }
  }
  
  public void zzg(int paramInt1, int paramInt2)
  {
    synchronized (this.zzpK)
    {
      this.zzKq = paramInt1;
      this.zzKr = paramInt2;
      this.zzqC.zza(this.zzJO, this);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */