package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class zzs
  extends zzw
{
  private zzc zzaTT;
  private zzc zzaTU;
  private final BlockingQueue<FutureTask<?>> zzaTV = new LinkedBlockingQueue();
  private final BlockingQueue<FutureTask<?>> zzaTW = new LinkedBlockingQueue();
  private final Thread.UncaughtExceptionHandler zzaTX = new zzb("Thread death: Uncaught exception on worker thread");
  private final Thread.UncaughtExceptionHandler zzaTY = new zzb("Thread death: Uncaught exception on network thread");
  private final Object zzaTZ = new Object();
  private final Semaphore zzaUa = new Semaphore(2);
  private volatile boolean zzaUb;
  
  zzs(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private void zza(FutureTask<?> paramFutureTask)
  {
    synchronized (this.zzaTZ)
    {
      this.zzaTV.add(paramFutureTask);
      if (this.zzaTT == null)
      {
        this.zzaTT = new zzc("Measurement Worker", this.zzaTV);
        this.zzaTT.setUncaughtExceptionHandler(this.zzaTX);
        this.zzaTT.start();
        return;
      }
      this.zzaTT.zzeQ();
    }
  }
  
  private void zzb(FutureTask<?> paramFutureTask)
  {
    synchronized (this.zzaTZ)
    {
      this.zzaTW.add(paramFutureTask);
      if (this.zzaTU == null)
      {
        this.zzaTU = new zzc("Measurement Network", this.zzaTW);
        this.zzaTU.setUncaughtExceptionHandler(this.zzaTY);
        this.zzaTU.start();
        return;
      }
      this.zzaTU.zzeQ();
    }
  }
  
  public void zzAR()
  {
    if (Thread.currentThread() != this.zzaTU) {
      throw new IllegalStateException("Call expected from network thread");
    }
  }
  
  public void zzg(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzje();
    zzx.zzy(paramRunnable);
    zza(new zza(paramRunnable, "Task exception on worker thread"));
  }
  
  public void zzh(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzje();
    zzx.zzy(paramRunnable);
    zzb(new zza(paramRunnable, "Task exception on network thread"));
  }
  
  public void zziS()
  {
    if (Thread.currentThread() != this.zzaTT) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  protected void zzir() {}
  
  private final class zza<V>
    extends FutureTask<V>
  {
    private final String zzaUc;
    
    zza(Runnable paramRunnable, String paramString)
    {
      super(null);
      zzx.zzy(paramString);
      this.zzaUc = paramString;
    }
    
    protected void setException(Throwable paramThrowable)
    {
      zzs.this.zzzz().zzBl().zzj(this.zzaUc, paramThrowable);
      super.setException(paramThrowable);
    }
  }
  
  private final class zzb
    implements Thread.UncaughtExceptionHandler
  {
    private final String zzaUc;
    
    public zzb(String paramString)
    {
      zzx.zzy(paramString);
      this.zzaUc = paramString;
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      try
      {
        zzs.this.zzzz().zzBl().zzj(this.zzaUc, paramThrowable);
        return;
      }
      finally
      {
        paramThread = finally;
        throw paramThread;
      }
    }
  }
  
  private final class zzc
    extends Thread
  {
    private final Object zzaUe;
    private final BlockingQueue<FutureTask<?>> zzaUf;
    
    public zzc(BlockingQueue<FutureTask<?>> paramBlockingQueue)
    {
      zzx.zzy(paramBlockingQueue);
      this.zzaUe = new Object();
      BlockingQueue localBlockingQueue;
      this.zzaUf = localBlockingQueue;
      setName(paramBlockingQueue);
    }
    
    private void zza(InterruptedException paramInterruptedException)
    {
      zzs.this.zzzz().zzBm().zzj(getName() + " was interrupted", paramInterruptedException);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	com/google/android/gms/measurement/internal/zzs$zzc:zzaUf	Ljava/util/concurrent/BlockingQueue;
      //   4: invokeinterface 84 1 0
      //   9: checkcast 86	java/util/concurrent/FutureTask
      //   12: astore_2
      //   13: aload_2
      //   14: ifnull +10 -> 24
      //   17: aload_2
      //   18: invokevirtual 88	java/util/concurrent/FutureTask:run	()V
      //   21: goto -21 -> 0
      //   24: aload_0
      //   25: getfield 32	com/google/android/gms/measurement/internal/zzs$zzc:zzaUe	Ljava/lang/Object;
      //   28: astore_2
      //   29: aload_2
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield 34	com/google/android/gms/measurement/internal/zzs$zzc:zzaUf	Ljava/util/concurrent/BlockingQueue;
      //   35: invokeinterface 91 1 0
      //   40: ifnonnull +25 -> 65
      //   43: aload_0
      //   44: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   47: invokestatic 94	com/google/android/gms/measurement/internal/zzs:zza	(Lcom/google/android/gms/measurement/internal/zzs;)Z
      //   50: istore_1
      //   51: iload_1
      //   52: ifne +13 -> 65
      //   55: aload_0
      //   56: getfield 32	com/google/android/gms/measurement/internal/zzs$zzc:zzaUe	Ljava/lang/Object;
      //   59: ldc2_w 95
      //   62: invokevirtual 100	java/lang/Object:wait	(J)V
      //   65: aload_2
      //   66: monitorexit
      //   67: aload_0
      //   68: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   71: invokestatic 104	com/google/android/gms/measurement/internal/zzs:zzb	(Lcom/google/android/gms/measurement/internal/zzs;)Ljava/lang/Object;
      //   74: astore_2
      //   75: aload_2
      //   76: monitorenter
      //   77: aload_0
      //   78: getfield 34	com/google/android/gms/measurement/internal/zzs$zzc:zzaUf	Ljava/util/concurrent/BlockingQueue;
      //   81: invokeinterface 91 1 0
      //   86: ifnonnull +106 -> 192
      //   89: aload_0
      //   90: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   93: invokestatic 107	com/google/android/gms/measurement/internal/zzs:zzc	(Lcom/google/android/gms/measurement/internal/zzs;)Ljava/util/concurrent/Semaphore;
      //   96: invokevirtual 112	java/util/concurrent/Semaphore:release	()V
      //   99: aload_0
      //   100: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   103: invokestatic 104	com/google/android/gms/measurement/internal/zzs:zzb	(Lcom/google/android/gms/measurement/internal/zzs;)Ljava/lang/Object;
      //   106: invokevirtual 115	java/lang/Object:notifyAll	()V
      //   109: aload_0
      //   110: aload_0
      //   111: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   114: invokestatic 119	com/google/android/gms/measurement/internal/zzs:zzd	(Lcom/google/android/gms/measurement/internal/zzs;)Lcom/google/android/gms/measurement/internal/zzs$zzc;
      //   117: if_acmpne +29 -> 146
      //   120: aload_0
      //   121: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   124: aconst_null
      //   125: invokestatic 122	com/google/android/gms/measurement/internal/zzs:zza	(Lcom/google/android/gms/measurement/internal/zzs;Lcom/google/android/gms/measurement/internal/zzs$zzc;)Lcom/google/android/gms/measurement/internal/zzs$zzc;
      //   128: pop
      //   129: aload_2
      //   130: monitorexit
      //   131: return
      //   132: astore_3
      //   133: aload_0
      //   134: aload_3
      //   135: invokespecial 124	com/google/android/gms/measurement/internal/zzs$zzc:zza	(Ljava/lang/InterruptedException;)V
      //   138: goto -73 -> 65
      //   141: astore_3
      //   142: aload_2
      //   143: monitorexit
      //   144: aload_3
      //   145: athrow
      //   146: aload_0
      //   147: aload_0
      //   148: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   151: invokestatic 127	com/google/android/gms/measurement/internal/zzs:zze	(Lcom/google/android/gms/measurement/internal/zzs;)Lcom/google/android/gms/measurement/internal/zzs$zzc;
      //   154: if_acmpne +20 -> 174
      //   157: aload_0
      //   158: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   161: aconst_null
      //   162: invokestatic 129	com/google/android/gms/measurement/internal/zzs:zzb	(Lcom/google/android/gms/measurement/internal/zzs;Lcom/google/android/gms/measurement/internal/zzs$zzc;)Lcom/google/android/gms/measurement/internal/zzs$zzc;
      //   165: pop
      //   166: goto -37 -> 129
      //   169: astore_3
      //   170: aload_2
      //   171: monitorexit
      //   172: aload_3
      //   173: athrow
      //   174: aload_0
      //   175: getfield 18	com/google/android/gms/measurement/internal/zzs$zzc:zzaUd	Lcom/google/android/gms/measurement/internal/zzs;
      //   178: invokevirtual 47	com/google/android/gms/measurement/internal/zzs:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   181: invokevirtual 132	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   184: ldc -122
      //   186: invokevirtual 137	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
      //   189: goto -60 -> 129
      //   192: aload_2
      //   193: monitorexit
      //   194: goto -194 -> 0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	zzc
      //   50	2	1	bool	boolean
      //   132	3	3	localInterruptedException	InterruptedException
      //   141	4	3	localObject2	Object
      //   169	4	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   55	65	132	java/lang/InterruptedException
      //   31	51	141	finally
      //   55	65	141	finally
      //   65	67	141	finally
      //   133	138	141	finally
      //   142	144	141	finally
      //   77	129	169	finally
      //   129	131	169	finally
      //   146	166	169	finally
      //   170	172	169	finally
      //   174	189	169	finally
      //   192	194	169	finally
    }
    
    public void zzeQ()
    {
      synchronized (this.zzaUe)
      {
        this.zzaUe.notifyAll();
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */