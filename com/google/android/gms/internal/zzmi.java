package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzmi
  implements zzmm
{
  private final Context mContext;
  private final GoogleApiAvailability zzaeL;
  final Api.zza<? extends zzsc, zzsd> zzaeM;
  final zzf zzafT;
  final Map<Api<?>, Integer> zzafU;
  final zzmg zzafp;
  private final Lock zzafz;
  private final Condition zzagH;
  private final zzb zzagI;
  final Map<Api.zzc<?>, ConnectionResult> zzagJ = new HashMap();
  private volatile zzmh zzagK;
  private ConnectionResult zzagL = null;
  int zzagM;
  final zzmm.zza zzagN;
  final Map<Api.zzc<?>, Api.zzb> zzagp;
  
  public zzmi(Context paramContext, zzmg paramzzmg, Lock paramLock, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability, Map<Api.zzc<?>, Api.zzb> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzsc, zzsd> paramzza, ArrayList<zzlz> paramArrayList, zzmm.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zzafz = paramLock;
    this.zzaeL = paramGoogleApiAvailability;
    this.zzagp = paramMap;
    this.zzafT = paramzzf;
    this.zzafU = paramMap1;
    this.zzaeM = paramzza;
    this.zzafp = paramzzmg;
    this.zzagN = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzlz)paramContext.next()).zza(this);
    }
    this.zzagI = new zzb(paramLooper);
    this.zzagH = paramLock.newCondition();
    this.zzagK = new zzmf(this);
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zzagH.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzadR;
    }
    if (this.zzagL != null) {
      return this.zzagL;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzagH.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzadR;
    }
    if (this.zzagL != null) {
      return this.zzagL;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    this.zzagK.connect();
  }
  
  public void disconnect()
  {
    this.zzagJ.clear();
    this.zzagK.disconnect();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString + "  ";
    Iterator localIterator = this.zzafU.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zzb)this.zzagp.get(localApi.zzoA())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    paramApi = paramApi.zzoA();
    if (this.zzagp.containsKey(paramApi))
    {
      if (((Api.zzb)this.zzagp.get(paramApi)).isConnected()) {
        return ConnectionResult.zzadR;
      }
      if (this.zzagJ.containsKey(paramApi)) {
        return (ConnectionResult)this.zzagJ.get(paramApi);
      }
    }
    return null;
  }
  
  public boolean isConnected()
  {
    return this.zzagK instanceof zzmd;
  }
  
  public boolean isConnecting()
  {
    return this.zzagK instanceof zzme;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.zzafz.lock();
    try
    {
      this.zzagK.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzafz.lock();
    try
    {
      this.zzagK.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    return this.zzagK.zza(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    this.zzafz.lock();
    try
    {
      this.zzagK.zza(paramConnectionResult, paramApi, paramInt);
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  void zza(zza paramzza)
  {
    paramzza = this.zzagI.obtainMessage(1, paramzza);
    this.zzagI.sendMessage(paramzza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zzagI.obtainMessage(2, paramRuntimeException);
    this.zzagI.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(zzmp paramzzmp)
  {
    return false;
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    return this.zzagK.zzb(paramT);
  }
  
  void zzj(ConnectionResult paramConnectionResult)
  {
    this.zzafz.lock();
    try
    {
      this.zzagL = paramConnectionResult;
      this.zzagK = new zzmf(this);
      this.zzagK.begin();
      this.zzagH.signalAll();
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public void zzoF() {}
  
  void zzpw()
  {
    this.zzafz.lock();
    try
    {
      this.zzagK = new zzme(this, this.zzafT, this.zzafU, this.zzaeL, this.zzaeM, this.zzafz, this.mContext);
      this.zzagK.begin();
      this.zzagH.signalAll();
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  void zzpx()
  {
    this.zzafz.lock();
    try
    {
      this.zzafp.zzps();
      this.zzagK = new zzmd(this);
      this.zzagK.begin();
      this.zzagH.signalAll();
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  void zzpy()
  {
    Iterator localIterator = this.zzagp.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zzb)localIterator.next()).disconnect();
    }
  }
  
  static abstract class zza
  {
    private final zzmh zzagO;
    
    protected zza(zzmh paramzzmh)
    {
      this.zzagO = paramzzmh;
    }
    
    public final void zzd(zzmi paramzzmi)
    {
      zzmi.zzb(paramzzmi).lock();
      try
      {
        zzmh localzzmh1 = zzmi.zzc(paramzzmi);
        zzmh localzzmh2 = this.zzagO;
        if (localzzmh1 != localzzmh2) {
          return;
        }
        zzpc();
        return;
      }
      finally
      {
        zzmi.zzb(paramzzmi).unlock();
      }
    }
    
    protected abstract void zzpc();
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.w("GACStateManager", "Unknown message id: " + paramMessage.what);
        return;
      case 1: 
        ((zzmi.zza)paramMessage.obj).zzd(zzmi.this);
        return;
      }
      throw ((RuntimeException)paramMessage.obj);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */