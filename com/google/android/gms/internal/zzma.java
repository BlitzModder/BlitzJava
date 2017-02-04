package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class zzma
  implements zzmm
{
  private final Context mContext;
  private final Looper zzaeK;
  private int zzafA = 0;
  private final zzmg zzafp;
  private final zzmi zzafq;
  private final zzmi zzafr;
  private final Map<Api.zzc<?>, zzmi> zzafs = new ArrayMap();
  private final Set<zzmp> zzaft = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zzb zzafu;
  private Bundle zzafv;
  private ConnectionResult zzafw = null;
  private ConnectionResult zzafx = null;
  private final AtomicInteger zzafy = new AtomicInteger(0);
  private final Lock zzafz;
  
  public zzma(Context paramContext, zzmg paramzzmg, Lock paramLock, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability, Map<Api.zzc<?>, Api.zzb> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzsc, zzsd> paramzza, ArrayList<zzlz> paramArrayList)
  {
    this.mContext = paramContext;
    this.zzafp = paramzzmg;
    this.zzafz = paramLock;
    this.zzaeK = paramLooper;
    paramzzmg = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.keySet().iterator();
    Api.zzc localzzc;
    while (((Iterator)localObject2).hasNext())
    {
      localzzc = (Api.zzc)((Iterator)localObject2).next();
      localObject1 = (Api.zzb)paramMap.get(localzzc);
      if (((Api.zzb)localObject1).zzmJ()) {
        paramzzmg = (zzmg)localObject1;
      }
      if (((Api.zzb)localObject1).zzmn()) {
        localArrayMap1.put(localzzc, localObject1);
      } else {
        localArrayMap2.put(localzzc, localObject1);
      }
    }
    this.zzafu = paramzzmg;
    if (localArrayMap1.isEmpty()) {
      throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    }
    paramzzmg = new ArrayMap();
    paramMap = new ArrayMap();
    Object localObject1 = paramMap1.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api)((Iterator)localObject1).next();
      localzzc = ((Api)localObject2).zzoA();
      if (localArrayMap1.containsKey(localzzc)) {
        paramzzmg.put(localObject2, paramMap1.get(localObject2));
      } else if (localArrayMap2.containsKey(localzzc)) {
        paramMap.put(localObject2, paramMap1.get(localObject2));
      } else {
        throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
      }
    }
    paramMap1 = new ArrayList();
    localObject1 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject2 = (zzlz)paramArrayList.next();
      if (paramzzmg.containsKey(((zzlz)localObject2).zzafm)) {
        paramMap1.add(localObject2);
      } else if (paramMap.containsKey(((zzlz)localObject2).zzafm)) {
        ((ArrayList)localObject1).add(localObject2);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    paramArrayList = new zzmm.zza()
    {
      public void zzbz(int paramAnonymousInt)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, zzma.zzc(zzma.this), paramAnonymousInt);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zze(ConnectionResult paramAnonymousConnectionResult)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, paramAnonymousConnectionResult);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zzi(Bundle paramAnonymousBundle)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, paramAnonymousBundle);
          zzma.zza(zzma.this, ConnectionResult.zzadR);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
    };
    this.zzafq = new zzmi(paramContext, this.zzafp, paramLock, paramLooper, paramGoogleApiAvailability, localArrayMap2, null, paramMap, null, (ArrayList)localObject1, paramArrayList);
    paramMap = new zzmm.zza()
    {
      public void zzbz(int paramAnonymousInt)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, zzma.zzd(zzma.this), paramAnonymousInt);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zze(ConnectionResult paramAnonymousConnectionResult)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zzb(zzma.this, paramAnonymousConnectionResult);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zzi(Bundle paramAnonymousBundle)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zzb(zzma.this, ConnectionResult.zzadR);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
    };
    this.zzafr = new zzmi(paramContext, this.zzafp, paramLock, paramLooper, paramGoogleApiAvailability, localArrayMap1, paramzzf, paramzzmg, paramzza, paramMap1, paramMap);
    paramContext = localArrayMap2.keySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzmg = (Api.zzc)paramContext.next();
      this.zzafs.put(paramzzmg, this.zzafq);
    }
    paramContext = localArrayMap1.keySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzmg = (Api.zzc)paramContext.next();
      this.zzafs.put(paramzzmg, this.zzafr);
    }
  }
  
  private void zza(zzmi paramzzmi, int paramInt)
  {
    if (this.zzafy.getAndIncrement() % 2 == 1) {
      this.zzafp.zzbz(paramInt);
    }
    paramzzmi.onConnectionSuspended(paramInt);
    this.zzafx = null;
    this.zzafw = null;
  }
  
  private void zzc(ConnectionResult paramConnectionResult)
  {
    switch (this.zzafA)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzafA = 0;
      return;
      this.zzafp.zze(paramConnectionResult);
      zzoY();
    }
  }
  
  private boolean zzc(zzlx.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = paramzza.zzoA();
    zzx.zzb(this.zzafs.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzmi)this.zzafs.get(paramzza)).equals(this.zzafr);
  }
  
  private static boolean zzd(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private void zzh(Bundle paramBundle)
  {
    if (this.zzafv == null) {
      this.zzafv = paramBundle;
    }
    while (paramBundle == null) {
      return;
    }
    this.zzafv.putAll(paramBundle);
  }
  
  private void zzoV()
  {
    this.zzafx = null;
    this.zzafw = null;
    this.zzafq.connect();
    this.zzafr.connect();
  }
  
  private void zzoW()
  {
    if (zzd(this.zzafw)) {
      if ((zzd(this.zzafx)) || (zzoZ())) {
        zzoX();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.zzafx == null);
      if (this.zzafA == 1)
      {
        zzoY();
        return;
      }
      zzc(this.zzafx);
      this.zzafq.disconnect();
      return;
      if ((this.zzafw != null) && (zzd(this.zzafx)))
      {
        this.zzafr.disconnect();
        zzc(this.zzafw);
        return;
      }
    } while ((this.zzafw == null) || (this.zzafx == null));
    ConnectionResult localConnectionResult = this.zzafw;
    if (this.zzafr.zzagM < this.zzafq.zzagM) {
      localConnectionResult = this.zzafx;
    }
    zzc(localConnectionResult);
  }
  
  private void zzoX()
  {
    switch (this.zzafA)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzafA = 0;
      return;
      this.zzafp.zzi(this.zzafv);
      zzoY();
    }
  }
  
  private void zzoY()
  {
    Iterator localIterator = this.zzaft.iterator();
    while (localIterator.hasNext()) {
      ((zzmp)localIterator.next()).zzmI();
    }
    this.zzaft.clear();
  }
  
  private boolean zzoZ()
  {
    return (this.zzafx != null) && (this.zzafx.getErrorCode() == 4);
  }
  
  private PendingIntent zzpa()
  {
    if (this.zzafu == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, this.zzafp.getSessionId(), this.zzafu.zzmK(), 134217728);
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void connect()
  {
    this.zzafA = 2;
    zzoV();
  }
  
  public void disconnect()
  {
    this.zzafx = null;
    this.zzafw = null;
    this.zzafA = 0;
    this.zzafq.disconnect();
    this.zzafr.disconnect();
    zzoY();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zzafr.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("unauthClient").println(":");
    this.zzafq.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    if (((zzmi)this.zzafs.get(paramApi.zzoA())).equals(this.zzafr))
    {
      if (zzoZ()) {
        return new ConnectionResult(4, zzpa());
      }
      return this.zzafr.getConnectionResult(paramApi);
    }
    return this.zzafq.getConnectionResult(paramApi);
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 363 1 0
    //   11: aload_0
    //   12: getfield 171	com/google/android/gms/internal/zzma:zzafq	Lcom/google/android/gms/internal/zzmi;
    //   15: invokevirtual 365	com/google/android/gms/internal/zzmi:isConnected	()Z
    //   18: ifeq +44 -> 62
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 368	com/google/android/gms/internal/zzma:zzoU	()Z
    //   27: ifne +24 -> 51
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: invokespecial 265	com/google/android/gms/internal/zzma:zzoZ	()Z
    //   36: ifne +15 -> 51
    //   39: aload_0
    //   40: getfield 74	com/google/android/gms/internal/zzma:zzafA	I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +16 -> 62
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 371 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -13 -> 51
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 371 1 0
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzma
    //   43	4	1	i	int
    //   22	42	2	bool1	boolean
    //   1	49	3	bool2	boolean
    //   67	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	67	finally
    //   23	30	67	finally
    //   32	44	67	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 363 1 0
    //   9: aload_0
    //   10: getfield 171	com/google/android/gms/internal/zzma:zzafq	Lcom/google/android/gms/internal/zzmi;
    //   13: invokevirtual 374	com/google/android/gms/internal/zzmi:isConnecting	()Z
    //   16: ifne +23 -> 39
    //   19: aload_0
    //   20: getfield 174	com/google/android/gms/internal/zzma:zzafr	Lcom/google/android/gms/internal/zzmi;
    //   23: invokevirtual 374	com/google/android/gms/internal/zzmi:isConnecting	()Z
    //   26: ifeq +26 -> 52
    //   29: aload_0
    //   30: getfield 74	com/google/android/gms/internal/zzma:zzafA	I
    //   33: istore_1
    //   34: iload_1
    //   35: iconst_2
    //   36: if_icmpne +16 -> 52
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   45: invokeinterface 371 1 0
    //   50: iload_2
    //   51: ireturn
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -13 -> 41
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   62: invokeinterface 371 1 0
    //   67: aload_3
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	zzma
    //   33	4	1	i	int
    //   40	14	2	bool	boolean
    //   57	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	34	57	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    if (paramT.zzoQ() == 1) {
      throw new IllegalStateException("ReportingServices.getReportingState is not supported with SIGN_IN_MODE_OPTIONAL.");
    }
    if (zzc(paramT))
    {
      if (zzoZ())
      {
        paramT.zzx(new Status(4, null, zzpa()));
        return paramT;
      }
      return this.zzafr.zza(paramT);
    }
    return this.zzafq.zza(paramT);
  }
  
  public boolean zza(zzmp paramzzmp)
  {
    this.zzafz.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzoU()))
      {
        this.zzaft.add(paramzzmp);
        if (this.zzafA == 0) {
          this.zzafA = 1;
        }
        this.zzafx = null;
        this.zzafr.connect();
        return true;
      }
      return false;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    if (zzc(paramT))
    {
      if (zzoZ())
      {
        paramT.zzx(new Status(4, null, zzpa()));
        return paramT;
      }
      return this.zzafr.zzb(paramT);
    }
    return this.zzafq.zzb(paramT);
  }
  
  /* Error */
  public void zzoF()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 363 1 0
    //   9: aload_0
    //   10: invokevirtual 396	com/google/android/gms/internal/zzma:isConnecting	()Z
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 174	com/google/android/gms/internal/zzma:zzafr	Lcom/google/android/gms/internal/zzmi;
    //   18: invokevirtual 273	com/google/android/gms/internal/zzmi:disconnect	()V
    //   21: aload_0
    //   22: new 246	com/google/android/gms/common/ConnectionResult
    //   25: dup
    //   26: iconst_4
    //   27: invokespecial 403	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   30: putfield 65	com/google/android/gms/internal/zzma:zzafx	Lcom/google/android/gms/common/ConnectionResult;
    //   33: iload_1
    //   34: ifeq +36 -> 70
    //   37: new 405	android/os/Handler
    //   40: dup
    //   41: aload_0
    //   42: getfield 82	com/google/android/gms/internal/zzma:zzaeK	Landroid/os/Looper;
    //   45: invokespecial 408	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   48: new 12	com/google/android/gms/internal/zzma$3
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 409	com/google/android/gms/internal/zzma$3:<init>	(Lcom/google/android/gms/internal/zzma;)V
    //   56: invokevirtual 413	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 371 1 0
    //   69: return
    //   70: aload_0
    //   71: invokespecial 227	com/google/android/gms/internal/zzma:zzoY	()V
    //   74: goto -14 -> 60
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 80	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 371 1 0
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzma
    //   13	21	1	bool	boolean
    //   77	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	33	77	finally
    //   37	60	77	finally
    //   70	74	77	finally
  }
  
  public boolean zzoU()
  {
    return this.zzafr.isConnected();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */