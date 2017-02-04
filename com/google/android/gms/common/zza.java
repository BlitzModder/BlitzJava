package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza
  implements ServiceConnection
{
  boolean zzadP = false;
  private final BlockingQueue<IBinder> zzadQ = new LinkedBlockingQueue();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzadQ.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public IBinder zzor()
    throws InterruptedException
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
    }
    if (this.zzadP) {
      throw new IllegalStateException();
    }
    this.zzadP = true;
    return (IBinder)this.zzadQ.take();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */