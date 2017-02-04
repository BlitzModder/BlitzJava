package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqq.zza;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zzd;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzt
{
  private static zzx zzaUg;
  private static volatile zzt zzaUh;
  private final Context mContext;
  private final boolean zzOQ;
  private final zzc zzaUi;
  private final zzr zzaUj;
  private final zzo zzaUk;
  private final zzs zzaUl;
  private final AppMeasurement zzaUm;
  private final zzae zzaUn;
  private final zzd zzaUo;
  private final zzp zzaUp;
  private final zzz zzaUq;
  private final zzf zzaUr;
  private final zzy zzaUs;
  private final zzm zzaUt;
  private final zzq zzaUu;
  private final zzab zzaUv;
  private Boolean zzaUw;
  private List<Long> zzaUx;
  private int zzaUy;
  private int zzaUz;
  private final zznl zzqD;
  
  zzt(zzx paramzzx)
  {
    com.google.android.gms.common.internal.zzx.zzy(paramzzx);
    this.mContext = paramzzx.mContext;
    this.zzqD = paramzzx.zzj(this);
    this.zzaUi = paramzzx.zza(this);
    Object localObject = paramzzx.zzb(this);
    ((zzr)localObject).zza();
    this.zzaUj = ((zzr)localObject);
    localObject = paramzzx.zzc(this);
    ((zzo)localObject).zza();
    this.zzaUk = ((zzo)localObject);
    this.zzaUn = paramzzx.zzg(this);
    localObject = paramzzx.zzl(this);
    ((zzf)localObject).zza();
    this.zzaUr = ((zzf)localObject);
    localObject = paramzzx.zzm(this);
    ((zzm)localObject).zza();
    this.zzaUt = ((zzm)localObject);
    localObject = paramzzx.zzh(this);
    ((zzd)localObject).zza();
    this.zzaUo = ((zzd)localObject);
    localObject = paramzzx.zzi(this);
    ((zzp)localObject).zza();
    this.zzaUp = ((zzp)localObject);
    localObject = paramzzx.zzk(this);
    ((zzz)localObject).zza();
    this.zzaUq = ((zzz)localObject);
    localObject = paramzzx.zzf(this);
    ((zzy)localObject).zza();
    this.zzaUs = ((zzy)localObject);
    localObject = paramzzx.zzo(this);
    ((zzab)localObject).zza();
    this.zzaUv = ((zzab)localObject);
    this.zzaUu = paramzzx.zzn(this);
    this.zzaUm = paramzzx.zze(this);
    paramzzx = paramzzx.zzd(this);
    paramzzx.zza();
    this.zzaUl = paramzzx;
    if (this.zzaUy != this.zzaUz) {
      zzzz().zzBl().zze("Not all components initialized", Integer.valueOf(this.zzaUy), Integer.valueOf(this.zzaUz));
    }
    this.zzOQ = true;
    if ((!this.zzaUi.zzka()) && (!zzBI()))
    {
      if (!(this.mContext.getApplicationContext() instanceof Application)) {
        break label331;
      }
      if (Build.VERSION.SDK_INT < 14) {
        break label315;
      }
      zzBB().zzBR();
    }
    for (;;)
    {
      this.zzaUl.zzg(new Runnable()
      {
        public void run()
        {
          zzt.this.start();
        }
      });
      return;
      label315:
      zzzz().zzBq().zzez("Not tracking deep linking pre-ICS");
      continue;
      label331:
      zzzz().zzBm().zzez("Application context is not an Application");
    }
  }
  
  private boolean zzBJ()
  {
    zziS();
    return this.zzaUx != null;
  }
  
  private boolean zzBL()
  {
    return !TextUtils.isEmpty(zzBD().zzAY());
  }
  
  private void zzBM()
  {
    zziS();
    zzje();
    if ((!zzBz()) || (!zzBL()))
    {
      zzBG().unregister();
      zzBH().cancel();
      return;
    }
    long l2 = zzBN();
    if (l2 == 0L)
    {
      zzBG().unregister();
      zzBH().cancel();
      return;
    }
    if (!zzBE().zzlk())
    {
      zzBG().zzlh();
      zzBH().cancel();
      return;
    }
    long l3 = zzAW().zzaTH.get();
    long l4 = zzAX().zzAL();
    long l1 = l2;
    if (!zzAU().zzc(l3, l4)) {
      l1 = Math.max(l2, l3 + l4);
    }
    zzBG().unregister();
    l1 -= zziT().currentTimeMillis();
    if (l1 <= 0L)
    {
      zzBH().zzt(1L);
      return;
    }
    zzzz().zzBr().zzj("Upload scheduled in approximately ms", Long.valueOf(l1));
    zzBH().zzt(l1);
  }
  
  private long zzBN()
  {
    long l5 = zziT().currentTimeMillis();
    long l1 = zzAX().zzAO();
    long l2 = zzAX().zzAM();
    long l4 = zzAW().zzaTF.get();
    long l3 = zzAW().zzaTG.get();
    long l6 = zzBD().zzBb();
    if (l6 == 0L) {
      l2 = 0L;
    }
    do
    {
      do
      {
        return l2;
        l5 -= Math.abs(l6 - l5);
        l1 = l5 + l1;
        if (!zzAU().zzc(l4, l2)) {
          l1 = l4 + l2;
        }
        l2 = l1;
      } while (l3 == 0L);
      l2 = l1;
    } while (l3 < l5);
    int i = 0;
    for (;;)
    {
      if (i >= zzAX().zzAQ()) {
        break label178;
      }
      l1 += (1 << i) * zzAX().zzAP();
      l2 = l1;
      if (l1 > l3) {
        break;
      }
      i += 1;
    }
    label178:
    return 0L;
  }
  
  private void zza(zzv paramzzv)
  {
    if (paramzzv == null) {
      throw new IllegalStateException("Component not created");
    }
  }
  
  private void zza(zzw paramzzw)
  {
    if (paramzzw == null) {
      throw new IllegalStateException("Component not created");
    }
    if (!paramzzw.isInitialized()) {
      throw new IllegalStateException("Component not initialized");
    }
  }
  
  /* Error */
  public static zzt zzaU(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 65	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   9: invokestatic 65	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: getstatic 438	com/google/android/gms/measurement/internal/zzt:zzaUh	Lcom/google/android/gms/measurement/internal/zzt;
    //   16: ifnonnull +32 -> 48
    //   19: ldc 2
    //   21: monitorenter
    //   22: getstatic 438	com/google/android/gms/measurement/internal/zzt:zzaUh	Lcom/google/android/gms/measurement/internal/zzt;
    //   25: ifnonnull +20 -> 45
    //   28: getstatic 440	com/google/android/gms/measurement/internal/zzt:zzaUg	Lcom/google/android/gms/measurement/internal/zzx;
    //   31: ifnull +21 -> 52
    //   34: getstatic 440	com/google/android/gms/measurement/internal/zzt:zzaUg	Lcom/google/android/gms/measurement/internal/zzx;
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 444	com/google/android/gms/measurement/internal/zzx:zzBQ	()Lcom/google/android/gms/measurement/internal/zzt;
    //   42: putstatic 438	com/google/android/gms/measurement/internal/zzt:zzaUh	Lcom/google/android/gms/measurement/internal/zzt;
    //   45: ldc 2
    //   47: monitorexit
    //   48: getstatic 438	com/google/android/gms/measurement/internal/zzt:zzaUh	Lcom/google/android/gms/measurement/internal/zzt;
    //   51: areturn
    //   52: new 67	com/google/android/gms/measurement/internal/zzx
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 447	com/google/android/gms/measurement/internal/zzx:<init>	(Landroid/content/Context;)V
    //   60: astore_0
    //   61: goto -23 -> 38
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   22	38	64	finally
    //   38	45	64	finally
    //   45	48	64	finally
    //   52	61	64	finally
    //   65	68	64	finally
  }
  
  private void zzb(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    int i = 0;
    zziS();
    zzje();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = this.zzaUx;
    this.zzaUx = null;
    if (((paramInt == 200) || (paramInt == 204)) && (paramThrowable == null))
    {
      zzAW().zzaTF.set(zziT().currentTimeMillis());
      zzAW().zzaTG.set(0L);
      zzBM();
      zzzz().zzBr().zze("Successful upload. Got network response. code, size", Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length));
      zzBD().beginTransaction();
      try
      {
        paramThrowable = paramArrayOfByte.iterator();
        while (paramThrowable.hasNext())
        {
          paramArrayOfByte = (Long)paramThrowable.next();
          zzBD().zzP(paramArrayOfByte.longValue());
        }
      }
      finally
      {
        zzBD().endTransaction();
      }
      zzBD().endTransaction();
      if ((zzBE().zzlk()) && (zzBL()))
      {
        zzBK();
        return;
      }
      zzBM();
      return;
    }
    zzzz().zzBr().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(paramInt), paramThrowable);
    zzAW().zzaTG.set(zziT().currentTimeMillis());
    if ((paramInt == 503) || (paramInt == 429)) {
      i = 1;
    }
    if (i != 0) {
      zzAW().zzaTH.set(zziT().currentTimeMillis());
    }
    zzBM();
  }
  
  private void zze(AppMetadata paramAppMetadata)
  {
    zziS();
    zzje();
    com.google.android.gms.common.internal.zzx.zzy(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzcG(paramAppMetadata.packageName);
    Object localObject2 = zzBD().zzew(paramAppMetadata.packageName);
    String str = zzAW().zzBu();
    int i = 0;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new zza(paramAppMetadata.packageName, zzAW().zzBv(), paramAppMetadata.zzaSn, str, 0L, 0L, paramAppMetadata.zzaKi, paramAppMetadata.zzaSo, paramAppMetadata.zzaSp, paramAppMetadata.zzaSq, paramAppMetadata.zzaSs);
      i = 1;
    }
    for (;;)
    {
      int j = i;
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramAppMetadata.zzaSn)) {
        if (paramAppMetadata.zzaSn.equals(((zza)localObject1).zzaSf))
        {
          j = i;
          localObject2 = localObject1;
          if (paramAppMetadata.zzaSp == ((zza)localObject1).zzaSk) {}
        }
        else
        {
          localObject2 = ((zza)localObject1).zze(paramAppMetadata.zzaSn, paramAppMetadata.zzaSp);
          j = 1;
        }
      }
      i = j;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramAppMetadata.zzaKi)) {
        if (paramAppMetadata.zzaKi.equals(((zza)localObject2).zzRl))
        {
          i = j;
          localObject1 = localObject2;
          if (paramAppMetadata.zzaSo.equals(((zza)localObject2).zzaSj)) {}
        }
        else
        {
          localObject1 = ((zza)localObject2).zzK(paramAppMetadata.zzaKi, paramAppMetadata.zzaSo);
          i = 1;
        }
      }
      localObject2 = localObject1;
      if (paramAppMetadata.zzaSq != ((zza)localObject1).zzaSl)
      {
        localObject2 = ((zza)localObject1).zzO(paramAppMetadata.zzaSq);
        i = 1;
      }
      localObject1 = localObject2;
      if (paramAppMetadata.zzaSs != ((zza)localObject2).zzaSm)
      {
        localObject1 = ((zza)localObject2).zzao(paramAppMetadata.zzaSs);
        i = 1;
      }
      if (i != 0) {
        zzBD().zza((zza)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (!str.equals(((zza)localObject2).zzaSg))
      {
        localObject1 = ((zza)localObject2).zzJ(zzAW().zzBv(), str);
        i = 1;
      }
    }
  }
  
  private void zzx(List<Long> paramList)
  {
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzx.zzab(bool);
      if (this.zzaUx == null) {
        break;
      }
      zzzz().zzBl().zzez("Set uploading progress before finishing the previous upload");
      return;
    }
    this.zzaUx = new ArrayList(paramList);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  protected void start()
  {
    zziS();
    zzzz().zzBp().zzez("App measurement is starting up");
    zzzz().zzBq().zzez("Debug logging enabled");
    if ((zzBI()) && ((!this.zzaUl.isInitialized()) || (this.zzaUl.zzBP())))
    {
      zzzz().zzBl().zzez("Scheduler shutting down before Scion.start() called");
      return;
    }
    zzBD().zzAZ();
    if (!zzBz())
    {
      if (!zzAU().zzbh("android.permission.INTERNET")) {
        zzzz().zzBl().zzez("App is missing INTERNET permission");
      }
      if (!zzAU().zzbh("android.permission.ACCESS_NETWORK_STATE")) {
        zzzz().zzBl().zzez("App is missing ACCESS_NETWORK_STATE permission");
      }
      if (!AppMeasurementReceiver.zzX(getContext())) {
        zzzz().zzBl().zzez("AppMeasurementReceiver not registered/enabled");
      }
      if (!AppMeasurementService.zzY(getContext())) {
        zzzz().zzBl().zzez("AppMeasurementService not registered/enabled");
      }
      zzzz().zzBl().zzez("Uploading is not possible. App measurement disabled");
    }
    for (;;)
    {
      zzBM();
      return;
      if ((!zzAX().zzka()) && (!zzBI()) && (!TextUtils.isEmpty(zzAS().zzBi()))) {
        zzBB().zzBS();
      }
    }
  }
  
  public zzm zzAS()
  {
    zza(this.zzaUt);
    return this.zzaUt;
  }
  
  public zzz zzAT()
  {
    zza(this.zzaUq);
    return this.zzaUq;
  }
  
  public zzae zzAU()
  {
    zza(this.zzaUn);
    return this.zzaUn;
  }
  
  public zzs zzAV()
  {
    zza(this.zzaUl);
    return this.zzaUl;
  }
  
  public zzr zzAW()
  {
    zza(this.zzaUj);
    return this.zzaUj;
  }
  
  public zzc zzAX()
  {
    return this.zzaUi;
  }
  
  zzs zzBA()
  {
    return this.zzaUl;
  }
  
  public zzy zzBB()
  {
    zza(this.zzaUs);
    return this.zzaUs;
  }
  
  public AppMeasurement zzBC()
  {
    return this.zzaUm;
  }
  
  public zzd zzBD()
  {
    zza(this.zzaUo);
    return this.zzaUo;
  }
  
  public zzp zzBE()
  {
    zza(this.zzaUp);
    return this.zzaUp;
  }
  
  public zzf zzBF()
  {
    zza(this.zzaUr);
    return this.zzaUr;
  }
  
  public zzq zzBG()
  {
    if (this.zzaUu == null) {
      throw new IllegalStateException("Network broadcast receiver not created");
    }
    return this.zzaUu;
  }
  
  public zzab zzBH()
  {
    zza(this.zzaUv);
    return this.zzaUv;
  }
  
  protected boolean zzBI()
  {
    return false;
  }
  
  public void zzBK()
  {
    int j = 0;
    zziS();
    zzje();
    if (!zzAX().zzka())
    {
      localObject1 = zzAW().zzBx();
      if (localObject1 == null) {
        zzzz().zzBm().zzez("Upload data called on the client side before use of service was decided");
      }
    }
    long l;
    int i;
    Object localObject2;
    do
    {
      do
      {
        return;
        if (((Boolean)localObject1).booleanValue())
        {
          zzzz().zzBl().zzez("Upload called in the client side when service should be used");
          return;
        }
        if (zzBJ())
        {
          zzzz().zzBm().zzez("Uploading requested multiple times");
          return;
        }
        if (!zzBE().zzlk())
        {
          zzzz().zzBm().zzez("Network not connected, ignoring upload request");
          zzBM();
          return;
        }
        l = zzAW().zzaTF.get();
        if (l != 0L) {
          zzzz().zzBq().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(zziT().currentTimeMillis() - l)));
        }
        localObject1 = zzBD().zzAY();
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      i = zzAX().zzAI();
      int k = zzAX().zzAJ();
      localObject2 = zzBD().zzn((String)localObject1, i, k);
    } while (((List)localObject2).isEmpty());
    Object localObject1 = ((List)localObject2).iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = (zzqq.zzd)((Pair)((Iterator)localObject1).next()).first;
    } while (TextUtils.isEmpty(((zzqq.zzd)localObject3).zzaVF));
    for (localObject1 = ((zzqq.zzd)localObject3).zzaVF;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((List)localObject2).size())
        {
          localObject3 = (zzqq.zzd)((Pair)((List)localObject2).get(i)).first;
          if (TextUtils.isEmpty(((zzqq.zzd)localObject3).zzaVF)) {}
          while (((zzqq.zzd)localObject3).zzaVF.equals(localObject1))
          {
            i += 1;
            break;
          }
        }
      }
      for (localObject1 = ((List)localObject2).subList(0, i);; localObject1 = localMalformedURLException)
      {
        localObject3 = new zzqq.zzc();
        ((zzqq.zzc)localObject3).zzaVp = new zzqq.zzd[((List)localObject1).size()];
        localObject2 = new ArrayList(((List)localObject1).size());
        l = zziT().currentTimeMillis();
        i = j;
        while (i < ((zzqq.zzc)localObject3).zzaVp.length)
        {
          ((zzqq.zzc)localObject3).zzaVp[i] = ((zzqq.zzd)((Pair)((List)localObject1).get(i)).first);
          ((List)localObject2).add(((Pair)((List)localObject1).get(i)).second);
          localObject3.zzaVp[i].zzaVE = Long.valueOf(zzAX().zzAE());
          localObject3.zzaVp[i].zzaVu = Long.valueOf(l);
          localObject3.zzaVp[i].zzaVK = Boolean.valueOf(zzAX().zzka());
          i += 1;
        }
        localObject3 = zzAU().zza((zzqq.zzc)localObject3);
        localObject1 = zzAX().zzAK();
        try
        {
          URL localURL = new URL((String)localObject1);
          zzx((List)localObject2);
          zzAW().zzaTG.set(zziT().currentTimeMillis());
          zzBE().zza(localURL, (byte[])localObject3, new zzp.zza()
          {
            public void zza(int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte)
            {
              zzt.zza(zzt.this, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte);
            }
          });
          return;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          zzzz().zzBl().zzj("Failed to parse upload URL. Not uploading", localObject1);
          return;
        }
      }
    }
  }
  
  void zzBO()
  {
    this.zzaUz += 1;
  }
  
  protected boolean zzBz()
  {
    boolean bool2 = true;
    zzje();
    zziS();
    if (this.zzaUw == null)
    {
      if ((!zzAU().zzbh("android.permission.INTERNET")) || (!zzAU().zzbh("android.permission.ACCESS_NETWORK_STATE")) || (!AppMeasurementReceiver.zzX(getContext())) || (!AppMeasurementService.zzY(getContext()))) {
        break label124;
      }
      bool1 = true;
      this.zzaUw = Boolean.valueOf(bool1);
      if ((this.zzaUw.booleanValue()) && (!zzAX().zzka())) {
        if (TextUtils.isEmpty(zzAS().zzBi())) {
          break label129;
        }
      }
    }
    label124:
    label129:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzaUw = Boolean.valueOf(bool1);
      return this.zzaUw.booleanValue();
      bool1 = false;
      break;
    }
  }
  
  public void zzJ(boolean paramBoolean)
  {
    zzBM();
  }
  
  zzqq.zzd zza(zzg[] paramArrayOfzzg, AppMetadata paramAppMetadata)
  {
    com.google.android.gms.common.internal.zzx.zzy(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzy(paramArrayOfzzg);
    zziS();
    zzqq.zzd localzzd = new zzqq.zzd();
    localzzd.zzaVr = Integer.valueOf(1);
    localzzd.zzaVz = "android";
    localzzd.appId = paramAppMetadata.packageName;
    localzzd.zzaSo = paramAppMetadata.zzaSo;
    localzzd.zzaKi = paramAppMetadata.zzaKi;
    localzzd.zzaVD = Long.valueOf(paramAppMetadata.zzaSp);
    localzzd.zzaSn = paramAppMetadata.zzaSn;
    if (paramAppMetadata.zzaSq == 0L) {}
    for (Object localObject1 = null;; localObject1 = Long.valueOf(paramAppMetadata.zzaSq))
    {
      localzzd.zzaVI = ((Long)localObject1);
      localObject1 = zzAW().zzBt();
      if ((localObject1 != null) && (((Pair)localObject1).first != null) && (((Pair)localObject1).second != null))
      {
        localzzd.zzaVF = ((String)((Pair)localObject1).first);
        localzzd.zzaVG = ((Boolean)((Pair)localObject1).second);
      }
      localzzd.zzaVA = zzBF().zzhb();
      localzzd.osVersion = zzBF().zzBe();
      localzzd.zzaVC = Integer.valueOf((int)zzBF().zzBf());
      localzzd.zzaVB = zzBF().zzBg();
      localzzd.zzaVE = null;
      localzzd.zzaVu = null;
      localzzd.zzaVv = Long.valueOf(paramArrayOfzzg[0].zzacS);
      localzzd.zzaVw = Long.valueOf(paramArrayOfzzg[0].zzacS);
      i = 1;
      while (i < paramArrayOfzzg.length)
      {
        localzzd.zzaVv = Long.valueOf(Math.min(localzzd.zzaVv.longValue(), paramArrayOfzzg[i].zzacS));
        localzzd.zzaVw = Long.valueOf(Math.max(localzzd.zzaVw.longValue(), paramArrayOfzzg[i].zzacS));
        i += 1;
      }
    }
    Object localObject2 = zzBD().zzew(paramAppMetadata.packageName);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new zza(paramAppMetadata.packageName, zzAW().zzBv(), paramAppMetadata.zzaSn, zzAW().zzBu(), 0L, 0L, paramAppMetadata.zzaKi, paramAppMetadata.zzaSo, paramAppMetadata.zzaSp, paramAppMetadata.zzaSq, paramAppMetadata.zzaSs);
    }
    localObject2 = ((zza)localObject1).zza(zzzz(), localzzd.zzaVw.longValue());
    zzBD().zza((zza)localObject2);
    localzzd.zzaVH = ((zza)localObject2).zzaSe;
    localzzd.zzaVJ = Integer.valueOf((int)((zza)localObject2).zzaSh);
    if (((zza)localObject1).zzaSi == 0L) {}
    for (localObject1 = null;; localObject1 = Long.valueOf(((zza)localObject1).zzaSi))
    {
      localzzd.zzaVy = ((Long)localObject1);
      localzzd.zzaVx = localzzd.zzaVy;
      paramAppMetadata = zzBD().zzev(paramAppMetadata.packageName);
      localzzd.zzaVt = new zzqq.zze[paramAppMetadata.size()];
      i = 0;
      while (i < paramAppMetadata.size())
      {
        localObject1 = new zzqq.zze();
        localzzd.zzaVt[i] = localObject1;
        ((zzqq.zze)localObject1).name = ((zzac)paramAppMetadata.get(i)).mName;
        ((zzqq.zze)localObject1).zzaVM = Long.valueOf(((zzac)paramAppMetadata.get(i)).zzaVf);
        zzAU().zza((zzqq.zze)localObject1, ((zzac)paramAppMetadata.get(i)).zzLI);
        i += 1;
      }
    }
    localzzd.zzaVs = new zzqq.zza[paramArrayOfzzg.length];
    int i = 0;
    while (i < paramArrayOfzzg.length)
    {
      paramAppMetadata = new zzqq.zza();
      localzzd.zzaVs[i] = paramAppMetadata;
      paramAppMetadata.name = paramArrayOfzzg[i].mName;
      paramAppMetadata.zzaVl = Long.valueOf(paramArrayOfzzg[i].zzacS);
      paramAppMetadata.zzaVk = new zzqq.zzb[paramArrayOfzzg[i].zzaSE.size()];
      localObject1 = paramArrayOfzzg[i].zzaSE.iterator();
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new zzqq.zzb();
        paramAppMetadata.zzaVk[j] = localObject2;
        ((zzqq.zzb)localObject2).name = ((String)localObject3);
        localObject3 = paramArrayOfzzg[i].zzaSE.get((String)localObject3);
        zzAU().zza((zzqq.zzb)localObject2, localObject3);
        j += 1;
      }
      i += 1;
    }
    localzzd.zzaSr = zzzz().zzBs();
    return localzzd;
  }
  
  void zza(EventParcel paramEventParcel, String paramString)
  {
    zza localzza = zzBD().zzew(paramString);
    if ((localzza == null) || (TextUtils.isEmpty(localzza.zzRl)))
    {
      zzzz().zzBq().zzj("No app data available; dropping event", paramString);
      return;
    }
    zzb(paramEventParcel, new AppMetadata(paramString, localzza.zzaSf, localzza.zzRl, localzza.zzaSj, localzza.zzaSk, localzza.zzaSl, null, localzza.zzaSm));
  }
  
  /* Error */
  void zzb(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 272	com/google/android/gms/measurement/internal/zzt:zziS	()V
    //   4: aload_0
    //   5: invokevirtual 293	com/google/android/gms/measurement/internal/zzt:zzje	()V
    //   8: aload_2
    //   9: getfield 496	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   12: invokestatic 500	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_2
    //   17: getfield 515	com/google/android/gms/measurement/internal/AppMetadata:zzaSn	Ljava/lang/String;
    //   20: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +4 -> 27
    //   26: return
    //   27: aload_0
    //   28: invokevirtual 199	com/google/android/gms/measurement/internal/zzt:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   31: invokevirtual 379	com/google/android/gms/measurement/internal/zzo:zzBr	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   34: ldc_w 954
    //   37: aload_1
    //   38: invokevirtual 389	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   41: new 836	com/google/android/gms/measurement/internal/zzg
    //   44: dup
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 959	com/google/android/gms/measurement/internal/EventParcel:zzaSM	Ljava/lang/String;
    //   50: aload_2
    //   51: getfield 496	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   54: aload_1
    //   55: getfield 960	com/google/android/gms/measurement/internal/EventParcel:name	Ljava/lang/String;
    //   58: aload_1
    //   59: getfield 963	com/google/android/gms/measurement/internal/EventParcel:zzaSN	J
    //   62: lconst_0
    //   63: aload_1
    //   64: getfield 966	com/google/android/gms/measurement/internal/EventParcel:zzaSL	Lcom/google/android/gms/measurement/internal/EventParams;
    //   67: invokevirtual 970	com/google/android/gms/measurement/internal/EventParams:zzBh	()Landroid/os/Bundle;
    //   70: invokespecial 973	com/google/android/gms/measurement/internal/zzg:<init>	(Lcom/google/android/gms/measurement/internal/zzt;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLandroid/os/Bundle;)V
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   78: invokevirtual 457	com/google/android/gms/measurement/internal/zzd:beginTransaction	()V
    //   81: aload_0
    //   82: aload_2
    //   83: invokespecial 975	com/google/android/gms/measurement/internal/zzt:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   86: aload_0
    //   87: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   90: aload_2
    //   91: getfield 496	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   94: aload_1
    //   95: getfield 911	com/google/android/gms/measurement/internal/zzg:mName	Ljava/lang/String;
    //   98: invokevirtual 979	com/google/android/gms/measurement/internal/zzd:zzL	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zzh;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +88 -> 191
    //   106: new 981	com/google/android/gms/measurement/internal/zzh
    //   109: dup
    //   110: aload_2
    //   111: getfield 496	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   114: aload_1
    //   115: getfield 911	com/google/android/gms/measurement/internal/zzg:mName	Ljava/lang/String;
    //   118: lconst_1
    //   119: lconst_1
    //   120: aload_1
    //   121: getfield 839	com/google/android/gms/measurement/internal/zzg:zzacS	J
    //   124: invokespecial 984	com/google/android/gms/measurement/internal/zzh:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   127: astore_3
    //   128: aload_0
    //   129: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   132: aload_3
    //   133: invokevirtual 987	com/google/android/gms/measurement/internal/zzd:zza	(Lcom/google/android/gms/measurement/internal/zzh;)V
    //   136: aload_0
    //   137: iconst_1
    //   138: anewarray 836	com/google/android/gms/measurement/internal/zzg
    //   141: dup
    //   142: iconst_0
    //   143: aload_1
    //   144: aastore
    //   145: aload_2
    //   146: invokevirtual 989	com/google/android/gms/measurement/internal/zzt:zza	([Lcom/google/android/gms/measurement/internal/zzg;Lcom/google/android/gms/measurement/internal/AppMetadata;)Lcom/google/android/gms/internal/zzqq$zzd;
    //   149: astore_2
    //   150: aload_0
    //   151: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   154: aload_2
    //   155: invokevirtual 992	com/google/android/gms/measurement/internal/zzd:zza	(Lcom/google/android/gms/internal/zzqq$zzd;)V
    //   158: aload_0
    //   159: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   162: invokevirtual 484	com/google/android/gms/measurement/internal/zzd:setTransactionSuccessful	()V
    //   165: aload_0
    //   166: invokevirtual 199	com/google/android/gms/measurement/internal/zzt:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   169: invokevirtual 256	com/google/android/gms/measurement/internal/zzo:zzBq	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   172: ldc_w 994
    //   175: aload_1
    //   176: invokevirtual 389	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   179: aload_0
    //   180: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   183: invokevirtual 481	com/google/android/gms/measurement/internal/zzd:endTransaction	()V
    //   186: aload_0
    //   187: invokespecial 452	com/google/android/gms/measurement/internal/zzt:zzBM	()V
    //   190: return
    //   191: aload_1
    //   192: aload_0
    //   193: aload_3
    //   194: getfield 997	com/google/android/gms/measurement/internal/zzh:zzaSH	J
    //   197: invokevirtual 1000	com/google/android/gms/measurement/internal/zzg:zza	(Lcom/google/android/gms/measurement/internal/zzt;J)Lcom/google/android/gms/measurement/internal/zzg;
    //   200: astore_1
    //   201: aload_3
    //   202: aload_1
    //   203: getfield 839	com/google/android/gms/measurement/internal/zzg:zzacS	J
    //   206: invokevirtual 1004	com/google/android/gms/measurement/internal/zzh:zzQ	(J)Lcom/google/android/gms/measurement/internal/zzh;
    //   209: astore_3
    //   210: goto -82 -> 128
    //   213: astore_1
    //   214: aload_0
    //   215: invokevirtual 279	com/google/android/gms/measurement/internal/zzt:zzBD	()Lcom/google/android/gms/measurement/internal/zzd;
    //   218: invokevirtual 481	com/google/android/gms/measurement/internal/zzd:endTransaction	()V
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	zzt
    //   0	223	1	paramEventParcel	EventParcel
    //   0	223	2	paramAppMetadata	AppMetadata
    //   101	109	3	localzzh	zzh
    // Exception table:
    //   from	to	target	type
    //   81	102	213	finally
    //   106	128	213	finally
    //   128	179	213	finally
    //   191	210	213	finally
  }
  
  void zzb(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    zziS();
    zzje();
    if (TextUtils.isEmpty(paramAppMetadata.zzaSn)) {}
    Object localObject;
    do
    {
      return;
      zzAU().zzeF(paramUserAttributeParcel.name);
      localObject = zzAU().zzm(paramUserAttributeParcel.name, paramUserAttributeParcel.getValue());
    } while (localObject == null);
    paramUserAttributeParcel = new zzac(paramAppMetadata.packageName, paramUserAttributeParcel.name, paramUserAttributeParcel.zzaVg, localObject);
    zzzz().zzBq().zze("Setting user attribute", paramUserAttributeParcel.mName, localObject);
    zzBD().beginTransaction();
    try
    {
      zze(paramAppMetadata);
      zzBD().zza(paramUserAttributeParcel);
      zzBD().setTransactionSuccessful();
      zzzz().zzBq().zze("User attribute set", paramUserAttributeParcel.mName, paramUserAttributeParcel.zzLI);
      return;
    }
    finally
    {
      zzBD().endTransaction();
    }
  }
  
  void zzb(zzw paramzzw)
  {
    this.zzaUy += 1;
  }
  
  void zzc(AppMetadata paramAppMetadata)
  {
    zziS();
    zzje();
    com.google.android.gms.common.internal.zzx.zzcG(paramAppMetadata.packageName);
    zze(paramAppMetadata);
  }
  
  void zzc(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    zziS();
    zzje();
    if (TextUtils.isEmpty(paramAppMetadata.zzaSn)) {
      return;
    }
    zzzz().zzBq().zzj("Removing user attribute", paramUserAttributeParcel.name);
    zzBD().beginTransaction();
    try
    {
      zze(paramAppMetadata);
      zzBD().zzM(paramAppMetadata.packageName, paramUserAttributeParcel.name);
      zzBD().setTransactionSuccessful();
      zzzz().zzBq().zzj("User attribute removed", paramUserAttributeParcel.name);
      return;
    }
    finally
    {
      zzBD().endTransaction();
    }
  }
  
  public void zzd(AppMetadata paramAppMetadata)
  {
    zziS();
    zzje();
    com.google.android.gms.common.internal.zzx.zzy(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzcG(paramAppMetadata.packageName);
    if (TextUtils.isEmpty(paramAppMetadata.zzaSn)) {}
    do
    {
      return;
      zze(paramAppMetadata);
    } while (zzBD().zzL(paramAppMetadata.packageName, "_f") != null);
    long l = zziT().currentTimeMillis();
    zzb(new UserAttributeParcel("_fot", l, Long.valueOf(3600000L * (l / 3600000L + 1L)), "auto"), paramAppMetadata);
    Bundle localBundle = new Bundle();
    localBundle.putLong("_c", 1L);
    zzb(new EventParcel("_f", new EventParams(localBundle), "auto", l), paramAppMetadata);
  }
  
  void zziR()
  {
    if (zzAX().zzka()) {
      throw new IllegalStateException("Unexpected call on package side");
    }
  }
  
  public void zziS()
  {
    zzAV().zziS();
  }
  
  public zznl zziT()
  {
    return this.zzqD;
  }
  
  void zzje()
  {
    if (!this.zzOQ) {
      throw new IllegalStateException("AppMeasurement is not initialized");
    }
  }
  
  public zzo zzzz()
  {
    zza(this.zzaUk);
    return this.zzaUk;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */