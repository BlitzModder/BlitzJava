package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat
  extends Thread
  implements zzas
{
  private static zzat zzbdU;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zzQk = false;
  private final LinkedBlockingQueue<Runnable> zzbdT = new LinkedBlockingQueue();
  private volatile zzau zzbdV;
  
  private zzat(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static zzat zzaZ(Context paramContext)
  {
    if (zzbdU == null) {
      zzbdU = new zzat(paramContext);
    }
    return zzbdU;
  }
  
  private String zzd(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.zzbdT.take();
        if (!this.zzQk) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        zzbg.zzaG(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        zzbg.e("Error on Google TagManager Thread: " + zzd(localThrowable));
        zzbg.e("Google TagManager is shutting down.");
        this.zzQk = true;
      }
    }
  }
  
  public void zzfs(String paramString)
  {
    zzk(paramString, System.currentTimeMillis());
  }
  
  public void zzj(Runnable paramRunnable)
  {
    this.zzbdT.add(paramRunnable);
  }
  
  void zzk(String paramString, final long paramLong)
  {
    zzj(new Runnable()
    {
      public void run()
      {
        if (zzat.zza(zzat.this) == null)
        {
          zzcu localzzcu = zzcu.zzFs();
          localzzcu.zza(zzat.zzb(zzat.this), jdField_this);
          zzat.zza(zzat.this, localzzcu.zzFv());
        }
        zzat.zza(zzat.this).zzg(paramLong, this.zzzn);
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */