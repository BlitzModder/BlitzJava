package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzme
  implements zzmh
{
  private final Context mContext;
  private final GoogleApiAvailability zzaeL;
  private final Api.zza<? extends zzsc, zzsd> zzaeM;
  private final zzmi zzafD;
  private ConnectionResult zzafF;
  private int zzafG;
  private int zzafH = 0;
  private boolean zzafI = false;
  private int zzafJ;
  private final Bundle zzafK = new Bundle();
  private final Set<Api.zzc> zzafL = new HashSet();
  private zzsc zzafM;
  private int zzafN;
  private boolean zzafO;
  private boolean zzafP;
  private zzp zzafQ;
  private boolean zzafR;
  private boolean zzafS;
  private final zzf zzafT;
  private final Map<Api<?>, Integer> zzafU;
  private ArrayList<Future<?>> zzafV = new ArrayList();
  private final Lock zzafz;
  
  public zzme(zzmi paramzzmi, zzf paramzzf, Map<Api<?>, Integer> paramMap, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzsc, zzsd> paramzza, Lock paramLock, Context paramContext)
  {
    this.zzafD = paramzzmi;
    this.zzafT = paramzzf;
    this.zzafU = paramMap;
    this.zzaeL = paramGoogleApiAvailability;
    this.zzaeM = paramzza;
    this.zzafz = paramLock;
    this.mContext = paramContext;
  }
  
  private void zzZ(boolean paramBoolean)
  {
    if (this.zzafM != null)
    {
      if ((this.zzafM.isConnected()) && (paramBoolean)) {
        this.zzafM.zzDL();
      }
      this.zzafM.disconnect();
      this.zzafQ = null;
    }
  }
  
  private void zza(ResolveAccountResponse paramResolveAccountResponse)
  {
    if (!zzbA(0)) {
      return;
    }
    ConnectionResult localConnectionResult = paramResolveAccountResponse.zzqI();
    if (localConnectionResult.isSuccess())
    {
      this.zzafQ = paramResolveAccountResponse.zzqH();
      this.zzafP = true;
      this.zzafR = paramResolveAccountResponse.zzqJ();
      this.zzafS = paramResolveAccountResponse.zzqK();
      zzpe();
      return;
    }
    if (zzh(localConnectionResult))
    {
      zzpj();
      zzpe();
      return;
    }
    zzi(localConnectionResult);
  }
  
  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zzg(paramConnectionResult))) {}
    while ((this.zzafF != null) && (paramInt1 >= this.zzafG)) {
      return false;
    }
    return true;
  }
  
  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zzoy().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        this.zzafF = paramConnectionResult;
        this.zzafG = i;
      }
    }
    this.zzafD.zzagJ.put(paramApi.zzoA(), paramConnectionResult);
  }
  
  private boolean zzbA(int paramInt)
  {
    if (this.zzafH != paramInt)
    {
      Log.i("GoogleApiClientConnecting", this.zzafD.zzafp.zzpt());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbB(this.zzafH) + " but received callback for step " + zzbB(paramInt), new Exception());
      zzi(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private String zzbB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_GETTING_SERVICE_BINDINGS";
    case 1: 
      return "STEP_VALIDATING_ACCOUNT";
    case 2: 
      return "STEP_AUTHENTICATING";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private void zzf(ConnectionResult paramConnectionResult)
  {
    if (!zzbA(2)) {
      return;
    }
    if (paramConnectionResult.isSuccess())
    {
      zzph();
      return;
    }
    if (zzh(paramConnectionResult))
    {
      zzpj();
      zzph();
      return;
    }
    zzi(paramConnectionResult);
  }
  
  private boolean zzg(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {}
    while (this.zzaeL.zzbu(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean zzh(ConnectionResult paramConnectionResult)
  {
    return (this.zzafN == 2) || ((this.zzafN == 1) && (!paramConnectionResult.hasResolution()));
  }
  
  private void zzi(ConnectionResult paramConnectionResult)
  {
    zzpk();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzZ(bool);
      this.zzafD.zzj(paramConnectionResult);
      if (!this.zzafI) {
        this.zzafD.zzagN.zze(paramConnectionResult);
      }
      this.zzafI = false;
      return;
    }
  }
  
  private boolean zzpd()
  {
    this.zzafJ -= 1;
    if (this.zzafJ > 0) {
      return false;
    }
    if (this.zzafJ < 0)
    {
      Log.i("GoogleApiClientConnecting", this.zzafD.zzafp.zzpt());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzi(new ConnectionResult(8, null));
      return false;
    }
    if (this.zzafF != null)
    {
      this.zzafD.zzagM = this.zzafG;
      zzi(this.zzafF);
      return false;
    }
    return true;
  }
  
  private void zzpe()
  {
    if (this.zzafJ != 0) {}
    do
    {
      return;
      if (!this.zzafO) {
        break;
      }
    } while (!this.zzafP);
    zzpf();
    return;
    zzph();
  }
  
  private void zzpf()
  {
    ArrayList localArrayList = new ArrayList();
    this.zzafH = 1;
    this.zzafJ = this.zzafD.zzagp.size();
    Iterator localIterator = this.zzafD.zzagp.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zzafD.zzagJ.containsKey(localzzc))
      {
        if (zzpd()) {
          zzpg();
        }
      }
      else {
        localArrayList.add(this.zzafD.zzagp.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      this.zzafV.add(zzmj.zzpz().submit(new zzh(localArrayList)));
    }
  }
  
  private void zzpg()
  {
    this.zzafH = 2;
    this.zzafD.zzafp.zzagq = zzpl();
    this.zzafV.add(zzmj.zzpz().submit(new zzc(null)));
  }
  
  private void zzph()
  {
    ArrayList localArrayList = new ArrayList();
    this.zzafH = 3;
    this.zzafJ = this.zzafD.zzagp.size();
    Iterator localIterator = this.zzafD.zzagp.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zzafD.zzagJ.containsKey(localzzc))
      {
        if (zzpd()) {
          zzpi();
        }
      }
      else {
        localArrayList.add(this.zzafD.zzagp.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      this.zzafV.add(zzmj.zzpz().submit(new zzf(localArrayList)));
    }
  }
  
  private void zzpi()
  {
    this.zzafD.zzpx();
    zzmj.zzpz().execute(new Runnable()
    {
      public void run()
      {
        zzme.zzb(zzme.this).zzaj(zzme.zza(zzme.this));
      }
    });
    if (this.zzafM != null)
    {
      if (this.zzafR) {
        this.zzafM.zza(this.zzafQ, this.zzafS);
      }
      zzZ(false);
    }
    Object localObject = this.zzafD.zzagJ.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localzzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zzb)this.zzafD.zzagp.get(localzzc)).disconnect();
    }
    if (this.zzafK.isEmpty()) {}
    for (localObject = null;; localObject = this.zzafK)
    {
      this.zzafD.zzagN.zzi((Bundle)localObject);
      if (this.zzafI)
      {
        this.zzafI = false;
        disconnect();
      }
      return;
    }
  }
  
  private void zzpj()
  {
    this.zzafO = false;
    this.zzafD.zzafp.zzagq = Collections.emptySet();
    Iterator localIterator = this.zzafL.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (!this.zzafD.zzagJ.containsKey(localzzc)) {
        this.zzafD.zzagJ.put(localzzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private void zzpk()
  {
    Iterator localIterator = this.zzafV.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.zzafV.clear();
  }
  
  private Set<Scope> zzpl()
  {
    if (this.zzafT == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(this.zzafT.zzqa());
    Map localMap = this.zzafT.zzqc();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zzafD.zzagJ.containsKey(localApi.zzoA())) {
        localHashSet.addAll(((zzf.zza)localMap.get(localApi)).zzVH);
      }
    }
    return localHashSet;
  }
  
  public void begin()
  {
    this.zzafD.zzagJ.clear();
    this.zzafI = false;
    this.zzafO = false;
    this.zzafF = null;
    this.zzafH = 0;
    this.zzafN = 2;
    this.zzafP = false;
    this.zzafR = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.zzafU.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zzb localzzb = (Api.zzb)this.zzafD.zzagp.get(localApi.zzoA());
      int k = ((Integer)this.zzafU.get(localApi)).intValue();
      if (localApi.zzoy().getPriority() == 1) {}
      for (int j = 1;; j = 0)
      {
        if (localzzb.zzmn())
        {
          this.zzafO = true;
          if (k < this.zzafN) {
            this.zzafN = k;
          }
          if (k != 0) {
            this.zzafL.add(localApi.zzoA());
          }
        }
        localHashMap.put(localzzb, new zzd(this, localApi, k));
        i = j | i;
        break;
      }
    }
    if (i != 0) {
      this.zzafO = false;
    }
    if (this.zzafO)
    {
      this.zzafT.zza(Integer.valueOf(this.zzafD.zzafp.getSessionId()));
      localObject = new zzg(null);
      this.zzafM = ((zzsc)this.zzaeM.zza(this.mContext, this.zzafD.zzafp.getLooper(), this.zzafT, this.zzafT.zzqg(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    this.zzafJ = this.zzafD.zzagp.size();
    this.zzafV.add(zzmj.zzpz().submit(new zze(localHashMap)));
  }
  
  public void connect()
  {
    this.zzafI = false;
  }
  
  public void disconnect()
  {
    Iterator localIterator = this.zzafD.zzafp.zzagj.iterator();
    while (localIterator.hasNext())
    {
      zzmg.zze localzze = (zzmg.zze)localIterator.next();
      if (localzze.zzoQ() != 1)
      {
        localzze.cancel();
        localIterator.remove();
      }
    }
    if ((this.zzafF == null) && (!this.zzafD.zzafp.zzagj.isEmpty()))
    {
      this.zzafI = true;
      return;
    }
    zzpk();
    zzZ(true);
    this.zzafD.zzj(null);
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (!zzbA(3)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.zzafK.putAll(paramBundle);
      }
    } while (!zzpd());
    zzpi();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzi(new ConnectionResult(8, null));
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    this.zzafD.zzafp.zzagj.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzbA(3)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    } while (!zzpd());
    zzpi();
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  private static class zza
    extends zzb
  {
    private final WeakReference<zzme> zzafX;
    
    zza(zzme paramzzme)
    {
      this.zzafX = new WeakReference(paramzzme);
    }
    
    public void zza(final ConnectionResult paramConnectionResult, final AuthAccountResult paramAuthAccountResult)
    {
      paramAuthAccountResult = (zzme)this.zzafX.get();
      if (paramAuthAccountResult == null) {
        return;
      }
      zzme.zzd(paramAuthAccountResult).zza(new zzmi.zza(paramAuthAccountResult)
      {
        public void zzpc()
        {
          zzme.zzc(paramAuthAccountResult, paramConnectionResult);
        }
      });
    }
  }
  
  private static class zzb
    extends zzt.zza
  {
    private final WeakReference<zzme> zzafX;
    
    zzb(zzme paramzzme)
    {
      this.zzafX = new WeakReference(paramzzme);
    }
    
    public void zzb(final ResolveAccountResponse paramResolveAccountResponse)
    {
      final zzme localzzme = (zzme)this.zzafX.get();
      if (localzzme == null) {
        return;
      }
      zzme.zzd(localzzme).zza(new zzmi.zza(localzzme)
      {
        public void zzpc()
        {
          zzme.zza(localzzme, paramResolveAccountResponse);
        }
      });
    }
  }
  
  private class zzc
    extends zzme.zzi
  {
    private zzc()
    {
      super(null);
    }
    
    public void zzpc()
    {
      zzme.zzf(zzme.this).zza(zzme.zzg(zzme.this), zzme.zzd(zzme.this).zzafp.zzagq, new zzme.zza(zzme.this));
    }
  }
  
  private static class zzd
    implements GoogleApiClient.zza
  {
    private final WeakReference<zzme> zzafX;
    private final Api<?> zzafm;
    private final int zzafn;
    
    public zzd(zzme paramzzme, Api<?> paramApi, int paramInt)
    {
      this.zzafX = new WeakReference(paramzzme);
      this.zzafm = paramApi;
      this.zzafn = paramInt;
    }
    
    public void zza(ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzme localzzme = (zzme)this.zzafX.get();
      if (localzzme == null) {
        return;
      }
      if (Looper.myLooper() == zzme.zzd(localzzme).zzafp.getLooper()) {
        bool = true;
      }
      zzx.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzme.zzc(localzzme).lock();
      try
      {
        bool = zzme.zza(localzzme, 0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzme.zza(localzzme, paramConnectionResult, this.zzafm, this.zzafn);
        }
        if (zzme.zzk(localzzme)) {
          zzme.zzl(localzzme);
        }
        return;
      }
      finally
      {
        zzme.zzc(localzzme).unlock();
      }
    }
    
    public void zzb(ConnectionResult paramConnectionResult)
    {
      boolean bool = true;
      zzme localzzme = (zzme)this.zzafX.get();
      if (localzzme == null) {
        return;
      }
      if (Looper.myLooper() == zzme.zzd(localzzme).zzafp.getLooper()) {}
      for (;;)
      {
        zzx.zza(bool, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        zzme.zzc(localzzme).lock();
        try
        {
          bool = zzme.zza(localzzme, 1);
          if (!bool)
          {
            return;
            bool = false;
            continue;
          }
          if (!paramConnectionResult.isSuccess()) {
            zzme.zza(localzzme, paramConnectionResult, this.zzafm, this.zzafn);
          }
          if (zzme.zzk(localzzme)) {
            zzme.zzm(localzzme);
          }
          return;
        }
        finally
        {
          zzme.zzc(localzzme).unlock();
        }
      }
    }
  }
  
  private class zze
    extends zzme.zzi
  {
    private final Map<Api.zzb, GoogleApiClient.zza> zzagd;
    
    public zze()
    {
      super(null);
      Map localMap;
      this.zzagd = localMap;
    }
    
    public void zzpc()
    {
      int i = zzme.zzb(zzme.this).isGooglePlayServicesAvailable(zzme.zza(zzme.this));
      final Object localObject;
      if (i != 0)
      {
        localObject = new ConnectionResult(i, null);
        zzme.zzd(zzme.this).zza(new zzmi.zza(zzme.this)
        {
          public void zzpc()
          {
            zzme.zza(zzme.this, localObject);
          }
        });
      }
      for (;;)
      {
        return;
        if (zzme.zze(zzme.this)) {
          zzme.zzf(zzme.this).connect();
        }
        localObject = this.zzagd.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Api.zzb localzzb = (Api.zzb)((Iterator)localObject).next();
          localzzb.zza((GoogleApiClient.zza)this.zzagd.get(localzzb));
        }
      }
    }
  }
  
  private class zzf
    extends zzme.zzi
  {
    private final ArrayList<Api.zzb> zzagg;
    
    public zzf()
    {
      super(null);
      ArrayList localArrayList;
      this.zzagg = localArrayList;
    }
    
    public void zzpc()
    {
      if (zzme.zzd(zzme.this).zzafp.zzagq.isEmpty()) {
        zzme.zzd(zzme.this).zzafp.zzagq = zzme.zzh(zzme.this);
      }
      Iterator localIterator = this.zzagg.iterator();
      while (localIterator.hasNext()) {
        ((Api.zzb)localIterator.next()).zza(zzme.zzg(zzme.this), zzme.zzd(zzme.this).zzafp.zzagq);
      }
    }
  }
  
  private class zzg
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zzg() {}
    
    public void onConnected(Bundle paramBundle)
    {
      zzme.zzf(zzme.this).zza(new zzme.zzb(zzme.this));
    }
    
    /* Error */
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   4: invokestatic 45	com/google/android/gms/internal/zzme:zzc	(Lcom/google/android/gms/internal/zzme;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 50 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   16: aload_1
      //   17: invokestatic 54	com/google/android/gms/internal/zzme:zzb	(Lcom/google/android/gms/internal/zzme;Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   27: invokestatic 57	com/google/android/gms/internal/zzme:zzi	(Lcom/google/android/gms/internal/zzme;)V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   34: invokestatic 60	com/google/android/gms/internal/zzme:zzj	(Lcom/google/android/gms/internal/zzme;)V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   41: invokestatic 45	com/google/android/gms/internal/zzme:zzc	(Lcom/google/android/gms/internal/zzme;)Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 63 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   54: aload_1
      //   55: invokestatic 66	com/google/android/gms/internal/zzme:zza	(Lcom/google/android/gms/internal/zzme;Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/internal/zzme$zzg:zzafW	Lcom/google/android/gms/internal/zzme;
      //   66: invokestatic 45	com/google/android/gms/internal/zzme:zzc	(Lcom/google/android/gms/internal/zzme;)Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 63 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zzg
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public void onConnectionSuspended(int paramInt) {}
  }
  
  private class zzh
    extends zzme.zzi
  {
    private final ArrayList<Api.zzb> zzagg;
    
    public zzh()
    {
      super(null);
      ArrayList localArrayList;
      this.zzagg = localArrayList;
    }
    
    public void zzpc()
    {
      Iterator localIterator = this.zzagg.iterator();
      while (localIterator.hasNext()) {
        ((Api.zzb)localIterator.next()).zza(zzme.zzg(zzme.this));
      }
    }
  }
  
  private abstract class zzi
    implements Runnable
  {
    private zzi() {}
    
    public void run()
    {
      zzme.zzc(zzme.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zzpc();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzme.zzd(zzme.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzme.zzc(zzme.this).unlock();
      }
    }
    
    protected abstract void zzpc();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */