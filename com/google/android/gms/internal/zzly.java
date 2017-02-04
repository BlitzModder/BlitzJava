package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzly<R extends Result>
  extends PendingResult<R>
{
  private boolean zzL;
  private volatile R zzaeT;
  private final Object zzafd = new Object();
  protected final zza<R> zzafe;
  private final ArrayList<PendingResult.zza> zzaff = new ArrayList();
  private ResultCallback<? super R> zzafg;
  private volatile boolean zzafh;
  private boolean zzafi;
  private zzq zzafj;
  private Integer zzafk;
  private volatile zzms<R> zzafl;
  private final CountDownLatch zzpy = new CountDownLatch(1);
  
  @Deprecated
  protected zzly(Looper paramLooper)
  {
    this.zzafe = new zza(paramLooper);
  }
  
  protected zzly(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (paramGoogleApiClient = paramGoogleApiClient.getLooper();; paramGoogleApiClient = Looper.getMainLooper())
    {
      this.zzafe = new zza(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (this.zzafd)
    {
      if (!this.zzafh)
      {
        zzx.zza(bool, "Result has already been consumed.");
        zzx.zza(isReady(), "Result is not ready.");
        Result localResult = this.zzaeT;
        this.zzaeT = null;
        this.zzafg = null;
        this.zzafh = true;
        zzoR();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzc(R paramR)
  {
    this.zzaeT = paramR;
    this.zzafj = null;
    this.zzpy.countDown();
    paramR = this.zzaeT.getStatus();
    if (this.zzafg != null)
    {
      this.zzafe.zzoS();
      if (!this.zzL) {
        this.zzafe.zza(this.zzafg, get());
      }
    }
    Iterator localIterator = this.zzaff.iterator();
    while (localIterator.hasNext()) {
      ((PendingResult.zza)localIterator.next()).zzu(paramR);
    }
    this.zzaff.clear();
  }
  
  public static void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("BasePendingResult", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzx.zza(bool1, "await must not be called on the UI thread");
      if (!this.zzafh)
      {
        bool1 = true;
        label28:
        zzx.zza(bool1, "Result has already been consumed");
        if (this.zzafl != null) {
          break label80;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        this.zzpy.await();
        zzx.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzy(Status.zzaeY);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      zzx.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.zzafh)
      {
        bool1 = true;
        label38:
        zzx.zza(bool1, "Result has already been consumed.");
        if (this.zzafl != null) {
          break label108;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.zzpy.await(paramLong, paramTimeUnit)) {
          zzy(Status.zzafa);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label38;
        label108:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzy(Status.zzaeY);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (this.zzafd)
    {
      if ((this.zzL) || (this.zzafh)) {
        return;
      }
      zzq localzzq = this.zzafj;
      if (localzzq == null) {}
    }
    try
    {
      this.zzafj.cancel();
      zzd(this.zzaeT);
      this.zzafg = null;
      this.zzL = true;
      zzc(zzc(Status.zzafb));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (this.zzafd)
    {
      boolean bool = this.zzL;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.zzpy.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.zzafh)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (this.zzafd)
      {
        if (this.zzafl != null) {
          break label94;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if (isReady())
        {
          this.zzafe.zza(paramResultCallback, get());
          return;
        }
      }
      this.zzafg = paramResultCallback;
      continue;
      bool1 = false;
      break;
      label94:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.zzafh)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (this.zzafd)
      {
        if (this.zzafl != null) {
          break label115;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if (isReady())
        {
          this.zzafe.zza(paramResultCallback, get());
          return;
        }
      }
      this.zzafg = paramResultCallback;
      this.zzafe.zza(this, paramTimeUnit.toMillis(paramLong));
      continue;
      bool1 = false;
      break;
      label115:
      bool1 = false;
    }
  }
  
  public final void zza(PendingResult.zza paramzza)
  {
    boolean bool2 = true;
    if (!this.zzafh)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
      if (paramzza == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Callback cannot be null.");
      synchronized (this.zzafd)
      {
        if (isReady())
        {
          paramzza.zzu(this.zzaeT.getStatus());
          return;
        }
        this.zzaff.add(paramzza);
      }
      bool1 = false;
      break;
    }
  }
  
  protected final void zza(zzq paramzzq)
  {
    synchronized (this.zzafd)
    {
      this.zzafj = paramzzq;
      return;
    }
  }
  
  public final void zzb(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzafd)
      {
        if ((this.zzafi) || (this.zzL))
        {
          zzd(paramR);
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          zzx.zza(bool1, "Results have already been set");
          if (this.zzafh) {
            break label84;
          }
          bool1 = bool2;
          zzx.zza(bool1, "Result has already been consumed");
          zzc(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label84:
      bool1 = false;
    }
  }
  
  protected abstract R zzc(Status paramStatus);
  
  public Integer zzoL()
  {
    return this.zzafk;
  }
  
  protected void zzoR() {}
  
  public final void zzy(Status paramStatus)
  {
    synchronized (this.zzafd)
    {
      if (!isReady())
      {
        zzb(zzc(paramStatus));
        this.zzafi = true;
      }
      return;
    }
  }
  
  public static class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("BasePendingResult", "Don't know how to handle message: " + paramMessage.what, new Exception());
        return;
      case 1: 
        paramMessage = (Pair)paramMessage.obj;
        zzb((ResultCallback)paramMessage.first, (Result)paramMessage.second);
        return;
      }
      ((zzly)paramMessage.obj).zzy(Status.zzafa);
    }
    
    public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void zza(zzly<R> paramzzly, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramzzly), paramLong);
    }
    
    protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        zzly.zzd(paramR);
        throw paramResultCallback;
      }
    }
    
    public void zzoS()
    {
      removeMessages(2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */