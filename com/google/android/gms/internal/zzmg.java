package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzk.zza;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzmg
  extends GoogleApiClient
  implements zzmm.zza
{
  private final Context mContext;
  private final int zzaeI;
  private final Looper zzaeK;
  private final GoogleApiAvailability zzaeL;
  final Api.zza<? extends zzsc, zzsd> zzaeM;
  final zzf zzafT;
  final Map<Api<?>, Integer> zzafU;
  private final Lock zzafz;
  private final zzk zzagh;
  private zzmm zzagi = null;
  final Queue<zzlx.zza<?, ?>> zzagj = new LinkedList();
  private volatile boolean zzagk;
  private long zzagl = 120000L;
  private long zzagm = 5000L;
  private final zza zzagn;
  zzc zzago;
  final Map<Api.zzc<?>, Api.zzb> zzagp;
  Set<Scope> zzagq = new HashSet();
  private final Set<zzmn<?>> zzagr = Collections.newSetFromMap(new WeakHashMap());
  final Set<zze<?>> zzags = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  private zza zzagt;
  private final ArrayList<zzlz> zzagu;
  private Integer zzagv = null;
  private final zzd zzagw = new zzd()
  {
    public void zzc(zzmg.zze<?> paramAnonymouszze)
    {
      zzmg.this.zzags.remove(paramAnonymouszze);
      if ((paramAnonymouszze.zzoL() != null) && (zzmg.zza(zzmg.this) != null)) {
        zzmg.zza(zzmg.this).remove(paramAnonymouszze.zzoL().intValue());
      }
    }
  };
  private final zzk.zza zzagx = new zzk.zza()
  {
    public boolean isConnected()
    {
      return zzmg.this.isConnected();
    }
    
    public Bundle zznQ()
    {
      return null;
    }
  };
  
  public zzmg(Context paramContext, Lock paramLock, Looper paramLooper, zzf paramzzf, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzsc, zzsd> paramzza, Map<Api<?>, Integer> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.zzc<?>, Api.zzb> paramMap1, int paramInt1, int paramInt2, ArrayList<zzlz> paramArrayList)
  {
    this.mContext = paramContext;
    this.zzafz = paramLock;
    this.zzagh = new zzk(paramLooper, this.zzagx);
    this.zzaeK = paramLooper;
    this.zzagn = new zza(paramLooper);
    this.zzaeL = paramGoogleApiAvailability;
    this.zzaeI = paramInt1;
    if (this.zzaeI >= 0) {
      this.zzagv = Integer.valueOf(paramInt2);
    }
    this.zzafU = paramMap;
    this.zzagp = paramMap1;
    this.zzagu = paramArrayList;
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.zzagh.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      this.zzagh.registerConnectionFailedListener(paramLock);
    }
    this.zzafT = paramzzf;
    this.zzaeM = paramzza;
  }
  
  private void resume()
  {
    this.zzafz.lock();
    try
    {
      if (zzpo()) {
        zzpp();
      }
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public static int zza(Iterable<Api.zzb> paramIterable, boolean paramBoolean)
  {
    int k = 1;
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.zzb localzzb = (Api.zzb)paramIterable.next();
      if (localzzb.zzmn()) {
        j = 1;
      }
      if (!localzzb.zzmJ()) {
        break label85;
      }
      i = 1;
    }
    label85:
    for (;;)
    {
      break;
      if (j != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (paramBoolean) {
            j = 2;
          }
        }
        return j;
      }
      return 3;
    }
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzmq paramzzmq, final boolean paramBoolean)
  {
    zzmz.zzakJ.zze(paramGoogleApiClient).setResultCallback(new ResultCallback()
    {
      public void zzp(Status paramAnonymousStatus)
      {
        zzn.zzae(zzmg.zzd(zzmg.this)).zzmZ();
        if ((paramAnonymousStatus.isSuccess()) && (zzmg.this.isConnected())) {
          zzmg.this.reconnect();
        }
        paramzzmq.zzb(paramAnonymousStatus);
        if (paramBoolean) {
          paramGoogleApiClient.disconnect();
        }
      }
    });
  }
  
  private static void zza(zze<?> paramzze, zza paramzza, IBinder paramIBinder)
  {
    if (paramzze.isReady())
    {
      paramzze.zza(new zzb(paramzze, paramzza, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zzb localzzb = new zzb(paramzze, paramzza, paramIBinder, null);
      paramzze.zza(localzzb);
      try
      {
        paramIBinder.linkToDeath(localzzb, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramzze.cancel();
        paramzza.remove(paramzze.zzoL().intValue());
        return;
      }
    }
    paramzze.zza(null);
    paramzze.cancel();
    paramzza.remove(paramzze.zzoL().intValue());
  }
  
  private void zzbC(int paramInt)
  {
    if (this.zzagv == null) {
      this.zzagv = Integer.valueOf(paramInt);
    }
    while (this.zzagi != null)
    {
      return;
      if (this.zzagv.intValue() != paramInt) {
        throw new IllegalStateException("Cannot use sign-in mode: " + zzbD(paramInt) + ". Mode was already set to " + zzbD(this.zzagv.intValue()));
      }
    }
    Iterator localIterator = this.zzagp.values().iterator();
    paramInt = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      Api.zzb localzzb = (Api.zzb)localIterator.next();
      if (localzzb.zzmn()) {
        i = 1;
      }
      if (!localzzb.zzmJ()) {
        break label317;
      }
      paramInt = 1;
    }
    label317:
    for (;;)
    {
      break;
      switch (this.zzagv.intValue())
      {
      }
      do
      {
        do
        {
          this.zzagi = new zzmi(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu, this);
          return;
          if (i == 0) {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          }
        } while (paramInt == 0);
        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } while (i == 0);
      this.zzagi = new zzma(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu);
      return;
    }
  }
  
  static String zzbD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  private void zzpp()
  {
    this.zzagh.zzqB();
    this.zzagi.connect();
  }
  
  private void zzpq()
  {
    this.zzafz.lock();
    try
    {
      if (zzps()) {
        zzpp();
      }
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzx.zza(bool1, "blockingConnect must not be called on the UI thread");
      this.zzafz.lock();
      try
      {
        if (this.zzaeI >= 0) {
          if (this.zzagv != null)
          {
            bool1 = bool2;
            label45:
            zzx.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzbC(this.zzagv.intValue());
            this.zzagh.zzqB();
            ConnectionResult localConnectionResult = this.zzagi.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label45;
            if (this.zzagv != null) {
              break label143;
            }
            this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
          }
        } while (this.zzagv.intValue() != 2);
      }
      finally
      {
        this.zzafz.unlock();
      }
    }
    label143:
    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    zzx.zza(bool, "blockingConnect must not be called on the UI thread");
    zzx.zzb(paramTimeUnit, "TimeUnit must not be null");
    this.zzafz.lock();
    try
    {
      if (this.zzagv == null) {
        this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
      }
      while (this.zzagv.intValue() != 2)
      {
        zzbC(this.zzagv.intValue());
        this.zzagh.zzqB();
        paramTimeUnit = this.zzagi.blockingConnect(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
    if (this.zzagv.intValue() != 2) {}
    final zzmq localzzmq;
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localzzmq = new zzmq(this);
      if (!this.zzagp.containsKey(zzmz.zzTo)) {
        break;
      }
      zza(this, localzzmq, false);
      return localzzmq;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        zzmg.zza(zzmg.this, (GoogleApiClient)localAtomicReference.get(), localzzmq, true);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt) {}
    };
    GoogleApiClient.OnConnectionFailedListener local4 = new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        localzzmq.zzb(new Status(8));
      }
    };
    localObject = new GoogleApiClient.Builder(this.mContext).addApi(zzmz.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(local4).setHandler(this.zzagn).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localzzmq;
  }
  
  public void connect()
  {
    boolean bool = false;
    this.zzafz.lock();
    try
    {
      if (this.zzaeI >= 0)
      {
        if (this.zzagv != null) {
          bool = true;
        }
        zzx.zza(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      do
      {
        for (;;)
        {
          connect(this.zzagv.intValue());
          return;
          if (this.zzagv != null) {
            break;
          }
          this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
        }
      } while (this.zzagv.intValue() != 2);
    }
    finally
    {
      this.zzafz.unlock();
    }
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  /* Error */
  public void connect(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 145	com/google/android/gms/internal/zzmg:zzafz	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 216 1 0
    //   11: iload_3
    //   12: istore_2
    //   13: iload_1
    //   14: iconst_3
    //   15: if_icmpeq +17 -> 32
    //   18: iload_3
    //   19: istore_2
    //   20: iload_1
    //   21: iconst_1
    //   22: if_icmpeq +10 -> 32
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +48 -> 75
    //   30: iload_3
    //   31: istore_2
    //   32: iload_2
    //   33: new 311	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 486
    //   43: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 491	com/google/android/gms/common/internal/zzx:zzb	(ZLjava/lang/Object;)V
    //   56: aload_0
    //   57: iload_1
    //   58: invokespecial 400	com/google/android/gms/internal/zzmg:zzbC	(I)V
    //   61: aload_0
    //   62: invokespecial 222	com/google/android/gms/internal/zzmg:zzpp	()V
    //   65: aload_0
    //   66: getfield 145	com/google/android/gms/internal/zzmg:zzafz	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 225 1 0
    //   74: return
    //   75: iconst_0
    //   76: istore_2
    //   77: goto -45 -> 32
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 145	com/google/android/gms/internal/zzmg:zzafz	Ljava/util/concurrent/locks/Lock;
    //   86: invokeinterface 225 1 0
    //   91: aload 4
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	zzmg
    //   0	94	1	paramInt	int
    //   12	65	2	bool1	boolean
    //   1	30	3	bool2	boolean
    //   80	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	65	80	finally
  }
  
  public void disconnect()
  {
    this.zzafz.lock();
    try
    {
      zzpm();
      if (this.zzagi == null)
      {
        zzpn();
        return;
      }
      zzps();
      this.zzagi.disconnect();
      this.zzagh.zzqA();
      return;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zzagk);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zzagj.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(this.zzags.size());
    if (this.zzagi != null) {
      this.zzagi.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    this.zzafz.lock();
    try
    {
      if ((!isConnected()) && (!zzpo())) {
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      }
    }
    finally
    {
      this.zzafz.unlock();
    }
    if (this.zzagp.containsKey(paramApi.zzoA()))
    {
      ConnectionResult localConnectionResult = this.zzagi.getConnectionResult(paramApi);
      if (localConnectionResult == null)
      {
        if (zzpo())
        {
          paramApi = ConnectionResult.zzadR;
          this.zzafz.unlock();
          return paramApi;
        }
        Log.i("GoogleApiClientImpl", zzpt());
        Log.wtf("GoogleApiClientImpl", paramApi.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed " + " connections map", new Exception());
        paramApi = new ConnectionResult(8, null);
        this.zzafz.unlock();
        return paramApi;
      }
      this.zzafz.unlock();
      return localConnectionResult;
    }
    throw new IllegalArgumentException(paramApi.getName() + " was never registered with GoogleApiClient");
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public Looper getLooper()
  {
    return this.zzaeK;
  }
  
  public int getSessionId()
  {
    return System.identityHashCode(this);
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    paramApi = (Api.zzb)this.zzagp.get(paramApi.zzoA());
    return (paramApi != null) && (paramApi.isConnected());
  }
  
  public boolean isConnected()
  {
    return (this.zzagi != null) && (this.zzagi.isConnected());
  }
  
  public boolean isConnecting()
  {
    return (this.zzagi != null) && (this.zzagi.isConnecting());
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zzagh.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zzagh.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzagh.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzagh.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(final FragmentActivity paramFragmentActivity)
  {
    if (this.zzaeI >= 0)
    {
      zzmr localzzmr = zzmr.zza(paramFragmentActivity);
      if (localzzmr == null)
      {
        new Handler(this.mContext.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            if ((paramFragmentActivity.isFinishing()) || (paramFragmentActivity.getSupportFragmentManager().isDestroyed())) {
              return;
            }
            zzmr.zzb(paramFragmentActivity).zzbE(zzmg.zze(zzmg.this));
          }
        });
        return;
      }
      localzzmr.zzbE(this.zzaeI);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzagh.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzagh.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public <C extends Api.zzb> C zza(Api.zzc<C> paramzzc)
  {
    paramzzc = (Api.zzb)this.zzagp.get(paramzzc);
    zzx.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    boolean bool;
    if (paramT.zzoA() != null) {
      bool = true;
    }
    for (;;)
    {
      zzx.zzb(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      zzx.zzb(this.zzagp.containsKey(paramT.zzoA()), "GoogleApiClient is not configured to use the API required for this call.");
      this.zzafz.lock();
      try
      {
        if (this.zzagi == null)
        {
          this.zzagj.add(paramT);
          return paramT;
          bool = false;
          continue;
        }
        paramT = this.zzagi.zza(paramT);
        return paramT;
      }
      finally
      {
        this.zzafz.unlock();
      }
    }
  }
  
  public boolean zza(Api<?> paramApi)
  {
    return this.zzagp.containsKey(paramApi.zzoA());
  }
  
  public boolean zza(zzmp paramzzmp)
  {
    return (this.zzagi != null) && (this.zzagi.zza(paramzzmp));
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    if (paramT.zzoA() != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      this.zzafz.lock();
      try
      {
        if (this.zzagi != null) {
          break;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.zzafz.unlock();
      }
    }
    if (zzpo())
    {
      this.zzagj.add(paramT);
      while (!this.zzagj.isEmpty())
      {
        zze localzze = (zze)this.zzagj.remove();
        zzb(localzze);
        localzze.zzx(Status.zzaeZ);
      }
      this.zzafz.unlock();
      return paramT;
    }
    paramT = this.zzagi.zzb(paramT);
    this.zzafz.unlock();
    return paramT;
  }
  
  <A extends Api.zzb> void zzb(zze<A> paramzze)
  {
    this.zzags.add(paramzze);
    paramzze.zza(this.zzagw);
  }
  
  public void zzbz(int paramInt)
  {
    if (paramInt == 1) {
      zzpr();
    }
    Iterator localIterator = this.zzags.iterator();
    while (localIterator.hasNext()) {
      ((zze)localIterator.next()).zzy(new Status(8, "The connection to Google Play services was lost"));
    }
    this.zzagh.zzbV(paramInt);
    this.zzagh.zzqA();
    if (paramInt == 2) {
      zzpp();
    }
  }
  
  public void zze(ConnectionResult paramConnectionResult)
  {
    if (!this.zzaeL.zzd(this.mContext, paramConnectionResult.getErrorCode())) {
      zzps();
    }
    if (!zzpo())
    {
      this.zzagh.zzl(paramConnectionResult);
      this.zzagh.zzqA();
    }
  }
  
  public void zzi(Bundle paramBundle)
  {
    while (!this.zzagj.isEmpty()) {
      zzb((zzlx.zza)this.zzagj.remove());
    }
    this.zzagh.zzk(paramBundle);
  }
  
  public void zzoF()
  {
    if (this.zzagi != null) {
      this.zzagi.zzoF();
    }
  }
  
  void zzpm()
  {
    Iterator localIterator = this.zzags.iterator();
    while (localIterator.hasNext())
    {
      zze localzze = (zze)localIterator.next();
      localzze.zza(null);
      if (localzze.zzoL() == null)
      {
        localzze.cancel();
      }
      else
      {
        localzze.zzoP();
        IBinder localIBinder = zza(localzze.zzoA()).zzoC();
        zza(localzze, this.zzagt, localIBinder);
      }
    }
    this.zzags.clear();
    localIterator = this.zzagr.iterator();
    while (localIterator.hasNext()) {
      ((zzmn)localIterator.next()).clear();
    }
    this.zzagr.clear();
  }
  
  void zzpn()
  {
    Iterator localIterator = this.zzagj.iterator();
    while (localIterator.hasNext())
    {
      zze localzze = (zze)localIterator.next();
      localzze.zza(null);
      localzze.cancel();
    }
    this.zzagj.clear();
  }
  
  boolean zzpo()
  {
    return this.zzagk;
  }
  
  void zzpr()
  {
    if (zzpo()) {
      return;
    }
    this.zzagk = true;
    if (this.zzago == null) {
      this.zzago = ((zzc)zzmk.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzaeL));
    }
    this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(1), this.zzagl);
    this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(2), this.zzagm);
  }
  
  boolean zzps()
  {
    if (!zzpo()) {
      return false;
    }
    this.zzagk = false;
    this.zzagn.removeMessages(2);
    this.zzagn.removeMessages(1);
    if (this.zzago != null)
    {
      this.zzago.unregister();
      this.zzago = null;
    }
    return true;
  }
  
  String zzpt()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  public <L> zzmn<L> zzq(L paramL)
  {
    zzx.zzb(paramL, "Listener must not be null");
    this.zzafz.lock();
    try
    {
      paramL = new zzmn(this.zzaeK, paramL);
      this.zzagr.add(paramL);
      return paramL;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.w("GoogleApiClientImpl", "Unknown message id: " + paramMessage.what);
        return;
      case 1: 
        zzmg.zzc(zzmg.this);
        return;
      }
      zzmg.zzb(zzmg.this);
    }
  }
  
  private static class zzb
    implements IBinder.DeathRecipient, zzmg.zzd
  {
    private final WeakReference<zzmg.zze<?>> zzagD;
    private final WeakReference<zza> zzagE;
    private final WeakReference<IBinder> zzagF;
    
    private zzb(zzmg.zze paramzze, zza paramzza, IBinder paramIBinder)
    {
      this.zzagE = new WeakReference(paramzza);
      this.zzagD = new WeakReference(paramzze);
      this.zzagF = new WeakReference(paramIBinder);
    }
    
    private void zzpu()
    {
      Object localObject = (zzmg.zze)this.zzagD.get();
      zza localzza = (zza)this.zzagE.get();
      if ((localzza != null) && (localObject != null)) {
        localzza.remove(((zzmg.zze)localObject).zzoL().intValue());
      }
      localObject = (IBinder)this.zzagF.get();
      if (this.zzagF != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public void binderDied()
    {
      zzpu();
    }
    
    public void zzc(zzmg.zze<?> paramzze)
    {
      zzpu();
    }
  }
  
  static class zzc
    extends zzmk
  {
    private WeakReference<zzmg> zzagG;
    
    zzc(zzmg paramzzmg)
    {
      this.zzagG = new WeakReference(paramzzmg);
    }
    
    public void zzpv()
    {
      zzmg localzzmg = (zzmg)this.zzagG.get();
      if (localzzmg == null) {
        return;
      }
      zzmg.zzb(localzzmg);
    }
  }
  
  static abstract interface zzd
  {
    public abstract void zzc(zzmg.zze<?> paramzze);
  }
  
  static abstract interface zze<A extends Api.zzb>
  {
    public abstract void cancel();
    
    public abstract boolean isReady();
    
    public abstract void zza(zzmg.zzd paramzzd);
    
    public abstract void zzb(A paramA)
      throws DeadObjectException;
    
    public abstract Api.zzc<A> zzoA();
    
    public abstract Integer zzoL();
    
    public abstract void zzoP();
    
    public abstract int zzoQ();
    
    public abstract void zzx(Status paramStatus);
    
    public abstract void zzy(Status paramStatus);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */