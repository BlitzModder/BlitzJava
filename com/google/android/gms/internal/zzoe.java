package com.google.android.gms.internal;

import android.os.Process;

class zzoe
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzx;
  
  public zzoe(Runnable paramRunnable, int paramInt)
  {
    this.zzx = paramRunnable;
    this.mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(this.mPriority);
    this.zzx.run();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */