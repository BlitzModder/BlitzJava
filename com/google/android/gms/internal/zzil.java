package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzha
public abstract class zzil
  implements zzir<Future>
{
  private volatile Thread zzKt;
  private boolean zzKu;
  private final Runnable zzx = new Runnable()
  {
    public final void run()
    {
      zzil.zza(zzil.this, Thread.currentThread());
      zzil.this.zzbp();
    }
  };
  
  public zzil()
  {
    this.zzKu = false;
  }
  
  public zzil(boolean paramBoolean)
  {
    this.zzKu = paramBoolean;
  }
  
  public final void cancel()
  {
    onStop();
    if (this.zzKt != null) {
      this.zzKt.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public abstract void zzbp();
  
  public final Future zzgX()
  {
    if (this.zzKu) {
      return zzio.zza(1, this.zzx);
    }
    return zzio.zza(this.zzx);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */