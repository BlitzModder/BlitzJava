package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.measurement.zzc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzl
  extends zzd
{
  private boolean mStarted;
  private final zzj zzPE;
  private final zzah zzPF;
  private final zzag zzPG;
  private final zzi zzPH;
  private long zzPI;
  private final zzt zzPJ;
  private final zzt zzPK;
  private final zzaj zzPL;
  private long zzPM;
  private boolean zzPN;
  
  protected zzl(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzx.zzy(paramzzg);
    this.zzPI = Long.MIN_VALUE;
    this.zzPG = paramzzg.zzk(paramzzf);
    this.zzPE = paramzzg.zzm(paramzzf);
    this.zzPF = paramzzg.zzn(paramzzf);
    this.zzPH = paramzzg.zzo(paramzzf);
    this.zzPL = new zzaj(zziT());
    this.zzPJ = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zza(zzl.this);
      }
    };
    this.zzPK = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zzb(zzl.this);
      }
    };
  }
  
  private void zza(zzh paramzzh, zzqi paramzzqi)
  {
    zzx.zzy(paramzzh);
    zzx.zzy(paramzzqi);
    Object localObject1 = new zza(zziQ());
    ((zza)localObject1).zzaP(paramzzh.zzjn());
    ((zza)localObject1).enableAdvertisingIdCollection(paramzzh.zzjo());
    localObject1 = ((zza)localObject1).zzig();
    zzkc localzzkc = (zzkc)((zzc)localObject1).zze(zzkc.class);
    localzzkc.zzaU("data");
    localzzkc.zzI(true);
    ((zzc)localObject1).zzb(paramzzqi);
    zzkb localzzkb = (zzkb)((zzc)localObject1).zze(zzkb.class);
    zzqh localzzqh = (zzqh)((zzc)localObject1).zze(zzqh.class);
    Iterator localIterator = paramzzh.zzn().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        localzzqh.setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        localzzqh.setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        localzzqh.setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        localzzqh.setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localzzkc.setUserId((String)localObject2);
      } else {
        localzzkb.set(str, (String)localObject2);
      }
    }
    zzb("Sending installation campaign to", paramzzh.zzjn(), paramzzqi);
    ((zzc)localObject1).zzM(zziY().zzlo());
    ((zzc)localObject1).zzzI();
  }
  
  private boolean zzbh(String paramString)
  {
    return getContext().checkCallingOrSelfPermission(paramString) == 0;
  }
  
  private void zzjC()
  {
    Context localContext = zziQ().getContext();
    if (!AnalyticsReceiver.zzX(localContext)) {
      zzbd("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    }
    do
    {
      while (!CampaignTrackingReceiver.zzX(localContext))
      {
        zzbd("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        return;
        if (!AnalyticsService.zzY(localContext)) {
          zzbe("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    } while (CampaignTrackingService.zzY(localContext));
    zzbd("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
  }
  
  private void zzjE()
  {
    zzb(new zzw()
    {
      public void zzc(Throwable paramAnonymousThrowable)
      {
        zzl.this.zzjK();
      }
    });
  }
  
  private void zzjF()
  {
    try
    {
      this.zzPE.zzjw();
      zzjK();
      this.zzPK.zzt(zziV().zzkC());
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete stale hits", localSQLiteException);
      }
    }
  }
  
  private boolean zzjL()
  {
    if (this.zzPN) {}
    while (((zziV().zzka()) && (!zziV().zzkb())) || (zzjR() <= 0L)) {
      return false;
    }
    return true;
  }
  
  private void zzjM()
  {
    zzv localzzv = zziX();
    if (!localzzv.zzkK()) {}
    long l;
    do
    {
      do
      {
        return;
      } while (localzzv.zzbr());
      l = zzjx();
    } while ((l == 0L) || (Math.abs(zziT().currentTimeMillis() - l) > zziV().zzkk()));
    zza("Dispatch alarm scheduled (ms)", Long.valueOf(zziV().zzkj()));
    localzzv.zzkL();
  }
  
  private void zzjN()
  {
    zzjM();
    long l2 = zzjR();
    long l1 = zziY().zzlq();
    if (l1 != 0L)
    {
      l1 = l2 - Math.abs(zziT().currentTimeMillis() - l1);
      if (l1 <= 0L) {}
    }
    for (;;)
    {
      zza("Dispatch scheduled (ms)", Long.valueOf(l1));
      if (!this.zzPJ.zzbr()) {
        break;
      }
      l1 = Math.max(1L, l1 + this.zzPJ.zzkH());
      this.zzPJ.zzu(l1);
      return;
      l1 = Math.min(zziV().zzkh(), l2);
      continue;
      l1 = Math.min(zziV().zzkh(), l2);
    }
    this.zzPJ.zzt(l1);
  }
  
  private void zzjO()
  {
    zzjP();
    zzjQ();
  }
  
  private void zzjP()
  {
    if (this.zzPJ.zzbr()) {
      zzba("All hits dispatched or no network/service. Going to power save mode");
    }
    this.zzPJ.cancel();
  }
  
  private void zzjQ()
  {
    zzv localzzv = zziX();
    if (localzzv.zzbr()) {
      localzzv.cancel();
    }
  }
  
  protected void onServiceConnected()
  {
    zziS();
    if (!zziV().zzka()) {
      zzjH();
    }
  }
  
  void start()
  {
    zzje();
    if (!this.mStarted) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Analytics backend already started");
      this.mStarted = true;
      if (!zziV().zzka()) {
        zzjC();
      }
      zziW().zzf(new Runnable()
      {
        public void run()
        {
          zzl.this.zzjD();
        }
      });
      return;
    }
  }
  
  public void zzJ(boolean paramBoolean)
  {
    zzjK();
  }
  
  public long zza(zzh paramzzh, boolean paramBoolean)
  {
    zzx.zzy(paramzzh);
    zzje();
    zziS();
    long l;
    for (;;)
    {
      try
      {
        this.zzPE.beginTransaction();
        this.zzPE.zza(paramzzh.zzjm(), paramzzh.getClientId());
        l = this.zzPE.zza(paramzzh.zzjm(), paramzzh.getClientId(), paramzzh.zzjn());
        if (!paramBoolean)
        {
          paramzzh.zzn(l);
          this.zzPE.zzb(paramzzh);
          this.zzPE.setTransactionSuccessful();
        }
      }
      catch (SQLiteException paramzzh)
      {
        paramzzh = paramzzh;
        zze("Failed to update Analytics property", paramzzh);
        try
        {
          this.zzPE.endTransaction();
          return -1L;
        }
        catch (SQLiteException paramzzh)
        {
          zze("Failed to end transaction", paramzzh);
          return -1L;
        }
      }
      finally {}
      try
      {
        this.zzPE.endTransaction();
        return l;
      }
      catch (SQLiteException paramzzh)
      {
        zze("Failed to end transaction", paramzzh);
        return l;
      }
      paramzzh.zzn(1L + l);
    }
    try
    {
      this.zzPE.endTransaction();
      throw paramzzh;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zze("Failed to end transaction", localSQLiteException);
      }
    }
  }
  
  public void zza(zzab paramzzab)
  {
    zzx.zzy(paramzzab);
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    if (this.zzPN) {
      zzbb("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
    }
    for (;;)
    {
      paramzzab = zzf(paramzzab);
      zzjG();
      if (!this.zzPH.zzb(paramzzab)) {
        break;
      }
      zzbb("Hit sent to the device AnalyticsService for delivery");
      return;
      zza("Delivering hit", paramzzab);
    }
    if (zziV().zzka())
    {
      zziU().zza(paramzzab, "Service unavailable on package side");
      return;
    }
    try
    {
      this.zzPE.zzc(paramzzab);
      zzjK();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Delivery failed to save hit to a database", localSQLiteException);
      zziU().zza(paramzzab, "deliver: failed to insert hit to database");
    }
  }
  
  public void zza(final zzw paramzzw, final long paramLong)
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    long l1 = -1L;
    long l2 = zziY().zzlq();
    if (l2 != 0L) {
      l1 = Math.abs(zziT().currentTimeMillis() - l2);
    }
    zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    if (!zziV().zzka()) {
      zzjG();
    }
    try
    {
      if (zzjI())
      {
        zziW().zzf(new Runnable()
        {
          public void run()
          {
            zzl.this.zza(paramzzw, paramLong);
          }
        });
        return;
      }
      zziY().zzlr();
      zzjK();
      if (paramzzw != null) {
        paramzzw.zzc(null);
      }
      if (this.zzPM != paramLong)
      {
        this.zzPG.zzlj();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      zze("Local dispatch failed", localThrowable);
      zziY().zzlr();
      zzjK();
      if (paramzzw != null) {
        paramzzw.zzc(localThrowable);
      }
    }
  }
  
  public void zzb(zzw paramzzw)
  {
    zza(paramzzw, this.zzPM);
  }
  
  public void zzbi(String paramString)
  {
    zzx.zzcG(paramString);
    zziS();
    zziR();
    zzqi localzzqi = zzam.zza(zziU(), paramString);
    if (localzzqi == null) {
      zzd("Parsing failed. Ignoring invalid campaign data", paramString);
    }
    for (;;)
    {
      return;
      String str = zziY().zzls();
      if (paramString.equals(str))
      {
        zzbd("Ignoring duplicate install campaign");
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        zzd("Ignoring multiple install campaigns. original, new", str, paramString);
        return;
      }
      zziY().zzbm(paramString);
      if (zziY().zzlp().zzv(zziV().zzkF()))
      {
        zzd("Campaign received too late, ignoring", localzzqi);
        return;
      }
      zzb("Received installation campaign", localzzqi);
      paramString = this.zzPE.zzr(0L).iterator();
      while (paramString.hasNext()) {
        zza((zzh)paramString.next(), localzzqi);
      }
    }
  }
  
  protected void zzc(zzh paramzzh)
  {
    zziS();
    zzb("Sending first hit to property", paramzzh.zzjn());
    if (zziY().zzlp().zzv(zziV().zzkF())) {}
    do
    {
      return;
      localObject = zziY().zzls();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = zzam.zza(zziU(), (String)localObject);
    zzb("Found relevant installation campaign", localObject);
    zza(paramzzh, (zzqi)localObject);
  }
  
  zzab zzf(zzab paramzzab)
  {
    if (!TextUtils.isEmpty(paramzzab.zzle())) {}
    do
    {
      return paramzzab;
      localObject2 = zziY().zzlt().zzlw();
    } while (localObject2 == null);
    Object localObject1 = (Long)((Pair)localObject2).second;
    Object localObject2 = (String)((Pair)localObject2).first;
    localObject1 = localObject1 + ":" + (String)localObject2;
    localObject2 = new HashMap(paramzzab.zzn());
    ((Map)localObject2).put("_m", localObject1);
    return zzab.zza(this, paramzzab, (Map)localObject2);
  }
  
  public void zziK()
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    if (!zziV().zzka()) {
      zzba("Delete all hits from local store");
    }
    try
    {
      this.zzPE.zzju();
      this.zzPE.zzjv();
      zzjK();
      zzjG();
      if (this.zzPH.zzjq()) {
        zzba("Device service unavailable. Can't clear hits stored on the device service.");
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete hits from store", localSQLiteException);
      }
    }
  }
  
  public void zziN()
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    zzba("Service disconnected");
  }
  
  void zziP()
  {
    zziS();
    this.zzPM = zziT().currentTimeMillis();
  }
  
  protected void zzir()
  {
    this.zzPE.zza();
    this.zzPF.zza();
    this.zzPH.zza();
  }
  
  protected void zzjD()
  {
    zzje();
    zziY().zzlo();
    if (!zzbh("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzbe("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzjS();
    }
    if (!zzbh("android.permission.INTERNET"))
    {
      zzbe("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzjS();
    }
    if (AnalyticsService.zzY(getContext())) {
      zzba("AnalyticsService registered in the app manifest and enabled");
    }
    for (;;)
    {
      if ((!this.zzPN) && (!zziV().zzka()) && (!this.zzPE.isEmpty())) {
        zzjG();
      }
      zzjK();
      return;
      if (zziV().zzka()) {
        zzbe("Device AnalyticsService not registered! Hits will not be delivered reliably.");
      } else {
        zzbd("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  protected void zzjG()
  {
    if (this.zzPN) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while ((!zziV().zzkc()) || (this.zzPH.isConnected()));
        l = zziV().zzkx();
      } while (!this.zzPL.zzv(l));
      this.zzPL.start();
      zzba("Connecting to service");
    } while (!this.zzPH.connect());
    zzba("Connected to service");
    this.zzPL.clear();
    onServiceConnected();
  }
  
  public void zzjH()
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    zziR();
    if (!zziV().zzkc()) {
      zzbd("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!this.zzPH.isConnected()) {
      zzba("Service not connected");
    }
    while (this.zzPE.isEmpty()) {
      return;
    }
    zzba("Dispatching local hits to device AnalyticsService");
    for (;;)
    {
      try
      {
        List localList = this.zzPE.zzp(zziV().zzkl());
        if (!localList.isEmpty()) {
          break label126;
        }
        zzjK();
        return;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze("Failed to read hits from store", localSQLiteException1);
        zzjO();
        return;
      }
      label107:
      Object localObject;
      localSQLiteException1.remove(localObject);
      try
      {
        this.zzPE.zzq(((zzab)localObject).zzkZ());
        label126:
        if (!localSQLiteException1.isEmpty())
        {
          localObject = (zzab)localSQLiteException1.get(0);
          if (this.zzPH.zzb((zzab)localObject)) {
            break label107;
          }
          zzjK();
          return;
        }
      }
      catch (SQLiteException localSQLiteException2)
      {
        zze("Failed to remove hit that was send for delivery", localSQLiteException2);
        zzjO();
      }
    }
  }
  
  protected boolean zzjI()
  {
    int j = 1;
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    zzba("Dispatching a batch of local hits");
    int i;
    if ((!this.zzPH.isConnected()) && (!zziV().zzka()))
    {
      i = 1;
      if (this.zzPF.zzlk()) {
        break label70;
      }
    }
    for (;;)
    {
      if ((i == 0) || (j == 0)) {
        break label75;
      }
      zzba("No network or service available. Will retry later");
      return false;
      i = 0;
      break;
      label70:
      j = 0;
    }
    label75:
    long l3 = Math.max(zziV().zzkl(), zziV().zzkm());
    ArrayList localArrayList = new ArrayList();
    l1 = 0L;
    for (;;)
    {
      try
      {
        this.zzPE.beginTransaction();
        localArrayList.clear();
        try
        {
          localList = this.zzPE.zzp(l3);
          if (localList.isEmpty())
          {
            zzba("Store is empty, nothing to dispatch");
            zzjO();
            try
            {
              this.zzPE.setTransactionSuccessful();
              this.zzPE.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException1)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException1);
              zzjO();
              return false;
            }
          }
          zza("Hits loaded from store. count", Integer.valueOf(localList.size()));
          localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (((zzab)((Iterator)localObject2).next()).zzkZ() != l1) {
              continue;
            }
            zzd("Database contains successfully uploaded hit", Long.valueOf(l1), Integer.valueOf(localList.size()));
            zzjO();
            try
            {
              this.zzPE.setTransactionSuccessful();
              this.zzPE.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException2)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException2);
              zzjO();
              return false;
            }
          }
          l2 = l1;
        }
        catch (SQLiteException localSQLiteException3)
        {
          zzd("Failed to read hits from persisted store", localSQLiteException3);
          zzjO();
          try
          {
            this.zzPE.setTransactionSuccessful();
            this.zzPE.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException4)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException4);
            zzjO();
            return false;
          }
          l2 = l1;
          if (!this.zzPH.isConnected()) {
            continue;
          }
        }
        if (zziV().zzka()) {
          continue;
        }
        zzba("Service connected, sending hits to the service");
        l2 = l1;
        if (localList.isEmpty()) {
          continue;
        }
        localObject2 = (zzab)localList.get(0);
        if (this.zzPH.zzb((zzab)localObject2)) {
          continue;
        }
      }
      finally
      {
        long l2;
        try
        {
          List localList;
          Object localObject2;
          Iterator localIterator;
          this.zzPE.setTransactionSuccessful();
          this.zzPE.endTransaction();
          throw ((Throwable)localObject1);
        }
        catch (SQLiteException localSQLiteException11)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException11);
          zzjO();
          return false;
        }
        l1 = l2;
        continue;
      }
      l2 = l1;
      if (this.zzPF.zzlk())
      {
        localObject2 = this.zzPF.zzo(localList);
        localIterator = ((List)localObject2).iterator();
        if (localIterator.hasNext())
        {
          l1 = Math.max(l1, ((Long)localIterator.next()).longValue());
          continue;
          l1 = Math.max(l1, ((zzab)localObject2).zzkZ());
          localList.remove(localObject2);
          zzb("Hit sent do device AnalyticsService for delivery", localObject2);
          try
          {
            this.zzPE.zzq(((zzab)localObject2).zzkZ());
            localSQLiteException4.add(Long.valueOf(((zzab)localObject2).zzkZ()));
          }
          catch (SQLiteException localSQLiteException5)
          {
            zze("Failed to remove hit that was send for delivery", localSQLiteException5);
            zzjO();
            try
            {
              this.zzPE.setTransactionSuccessful();
              this.zzPE.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException6)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException6);
              zzjO();
              return false;
            }
          }
        }
        localList.removeAll((Collection)localObject2);
      }
      try
      {
        this.zzPE.zzm((List)localObject2);
        localSQLiteException6.addAll((Collection)localObject2);
        l2 = l1;
        boolean bool = localSQLiteException6.isEmpty();
        if (bool) {
          try
          {
            this.zzPE.setTransactionSuccessful();
            this.zzPE.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException7)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException7);
            zzjO();
            return false;
          }
        }
      }
      catch (SQLiteException localSQLiteException8)
      {
        zze("Failed to remove successfully uploaded hits", localSQLiteException8);
        zzjO();
        try
        {
          this.zzPE.setTransactionSuccessful();
          this.zzPE.endTransaction();
          return false;
        }
        catch (SQLiteException localSQLiteException9)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException9);
          zzjO();
          return false;
        }
        try
        {
          this.zzPE.setTransactionSuccessful();
          this.zzPE.endTransaction();
          l1 = l2;
        }
        catch (SQLiteException localSQLiteException10)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException10);
          zzjO();
          return false;
        }
      }
    }
  }
  
  public void zzjJ()
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    zzbb("Sync dispatching local hits");
    long l = this.zzPM;
    if (!zziV().zzka()) {
      zzjG();
    }
    try
    {
      while (zzjI()) {}
      zziY().zzlr();
      zzjK();
      if (this.zzPM != l) {
        this.zzPG.zzlj();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      zze("Sync local dispatch failed", localThrowable);
      zzjK();
    }
  }
  
  public void zzjK()
  {
    zziQ().zziS();
    zzje();
    if (!zzjL())
    {
      this.zzPG.unregister();
      zzjO();
      return;
    }
    if (this.zzPE.isEmpty())
    {
      this.zzPG.unregister();
      zzjO();
      return;
    }
    if (!((Boolean)zzy.zzQY.get()).booleanValue()) {
      this.zzPG.zzlh();
    }
    for (boolean bool = this.zzPG.isConnected(); bool; bool = true)
    {
      zzjN();
      return;
    }
    zzjO();
    zzjM();
  }
  
  public long zzjR()
  {
    long l;
    if (this.zzPI != Long.MIN_VALUE) {
      l = this.zzPI;
    }
    do
    {
      return l;
      l = zziV().zzki();
    } while (!zziq().zzkU());
    return zziq().zzlL() * 1000L;
  }
  
  public void zzjS()
  {
    zzje();
    zziS();
    this.zzPN = true;
    this.zzPH.disconnect();
    zzjK();
  }
  
  public long zzjx()
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    try
    {
      long l = this.zzPE.zzjx();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Failed to get min/max hit times from local store", localSQLiteException);
    }
    return 0L;
  }
  
  public void zzs(long paramLong)
  {
    com.google.android.gms.measurement.zzg.zziS();
    zzje();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.zzPI = l;
    zzjK();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */