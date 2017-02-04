package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzeq
  implements zzer.zza
{
  private final Context mContext;
  private final String zzBd;
  private final long zzBe;
  private final zzen zzBf;
  private final zzem zzBg;
  private final AdSizeParcel zzBh;
  private zzex zzBi;
  private int zzBj = -2;
  private zzez zzBk;
  private final NativeAdOptionsParcel zzpE;
  private final List<String> zzpF;
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private final zzew zzpd;
  private final AdRequestParcel zzqo;
  private final boolean zzrF;
  
  public zzeq(Context paramContext, String paramString, zzew paramzzew, zzen paramzzen, zzem paramzzem, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    this.mContext = paramContext;
    this.zzpd = paramzzew;
    this.zzBg = paramzzem;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.zzBd = zzen();
      this.zzBf = paramzzen;
      if (paramzzen.zzAP == -1L) {
        break label130;
      }
    }
    label130:
    for (long l = paramzzen.zzAP;; l = 10000L)
    {
      this.zzBe = l;
      this.zzqo = paramAdRequestParcel;
      this.zzBh = paramAdSizeParcel;
      this.zzpI = paramVersionInfoParcel;
      this.zzrF = paramBoolean;
      this.zzpE = paramNativeAdOptionsParcel;
      this.zzpF = paramList;
      return;
      this.zzBd = paramString;
      break;
    }
  }
  
  private void zza(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.zzBj != -2) {
        return;
      }
      zzb(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void zza(zzep paramzzep)
  {
    if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzBd))
    {
      Bundle localBundle = this.zzqo.zztA.getBundle(this.zzBd);
      localObject = localBundle;
      if (localBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putString("sdk_less_network_id", this.zzBg.zzAF);
      this.zzqo.zztA.putBundle(this.zzBd, (Bundle)localObject);
    }
    Object localObject = zzae(this.zzBg.zzAL);
    try
    {
      if (this.zzpI.zzLG < 4100000)
      {
        if (this.zzBh.zztW)
        {
          this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, (String)localObject, paramzzep);
          return;
        }
        this.zzBi.zza(zze.zzB(this.mContext), this.zzBh, this.zzqo, (String)localObject, paramzzep);
        return;
      }
    }
    catch (RemoteException paramzzep)
    {
      zzb.zzd("Could not request ad from mediation adapter.", paramzzep);
      zzr(5);
      return;
    }
    if (this.zzrF)
    {
      this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, (String)localObject, this.zzBg.zzAE, paramzzep, this.zzpE, this.zzpF);
      return;
    }
    if (this.zzBh.zztW)
    {
      this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, (String)localObject, this.zzBg.zzAE, paramzzep);
      return;
    }
    this.zzBi.zza(zze.zzB(this.mContext), this.zzBh, this.zzqo, (String)localObject, this.zzBg.zzAE, paramzzep);
  }
  
  private String zzae(String paramString)
  {
    if ((paramString == null) || (!zzeq()) || (zzs(2))) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).remove("cpm_floor_cents");
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzaH("Could not remove field. Returning the original value");
    }
    return paramString;
  }
  
  private void zzb(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      zzb.zzaG("Timed out waiting for adapter.");
      this.zzBj = 3;
      return;
    }
    try
    {
      this.zzpK.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzBj = -1;
    }
  }
  
  private String zzen()
  {
    try
    {
      if (!TextUtils.isEmpty(this.zzBg.zzAI))
      {
        if (this.zzpd.zzag(this.zzBg.zzAI)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private zzez zzeo()
  {
    if ((this.zzBj != 0) || (!zzeq())) {
      return null;
    }
    try
    {
      if ((zzs(4)) && (this.zzBk != null) && (this.zzBk.zzes() != 0))
      {
        zzez localzzez = this.zzBk;
        return localzzez;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Could not get cpm value from MediationResponseMetadata");
    }
    return zzt(zzer());
  }
  
  private zzex zzep()
  {
    zzb.zzaG("Instantiating mediation adapter: " + this.zzBd);
    if (((Boolean)zzbz.zzwA.get()).booleanValue())
    {
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzBd)) {
        return new zzfd(new AdMobAdapter());
      }
      if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzBd)) {
        return new zzfd(new AdUrlAdapter());
      }
    }
    try
    {
      zzex localzzex = this.zzpd.zzaf(this.zzBd);
      return localzzex;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zza("Could not instantiate mediation adapter: " + this.zzBd, localRemoteException);
    }
    return null;
  }
  
  private boolean zzeq()
  {
    return this.zzBf.zzAX != -1;
  }
  
  private int zzer()
  {
    int j;
    if (this.zzBg.zzAL == null)
    {
      j = 0;
      return j;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.zzBg.zzAL);
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzBd)) {
        return localJSONObject.optInt("cpm_cents", 0);
      }
    }
    catch (JSONException localJSONException)
    {
      zzb.zzaH("Could not convert to json. Returning 0");
      return 0;
    }
    if (zzs(2)) {}
    for (int i = localJSONException.optInt("cpm_floor_cents", 0);; i = 0)
    {
      j = i;
      if (i != 0) {
        break;
      }
      return localJSONException.optInt("penalized_average_cpm_cents", 0);
    }
  }
  
  private boolean zzs(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Bundle localBundle;
        if (this.zzrF)
        {
          localBundle = this.zzBi.zzex();
          if (localBundle != null)
          {
            if ((localBundle.getInt("capabilities", 0) & paramInt) == paramInt) {
              bool = true;
            }
          }
          else {
            return bool;
          }
        }
        else
        {
          if (this.zzBh.zztW)
          {
            localBundle = this.zzBi.getInterstitialAdapterInfo();
            continue;
          }
          localBundle = this.zzBi.zzew();
          continue;
        }
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzaH("Could not get adapter info. Returning false");
        return false;
      }
    }
  }
  
  private static zzez zzt(int paramInt)
  {
    new zzez.zza()
    {
      public int zzes()
        throws RemoteException
      {
        return this.zzBn;
      }
    };
  }
  
  public void cancel()
  {
    synchronized (this.zzpK)
    {
      try
      {
        if (this.zzBi != null) {
          this.zzBi.destroy();
        }
        this.zzBj = -1;
        this.zzpK.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public zzer zza(long paramLong1, long paramLong2)
  {
    synchronized (this.zzpK)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new zzep();
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          synchronized (zzeq.zza(zzeq.this))
          {
            if (zzeq.zzb(zzeq.this) != -2) {
              return;
            }
            zzeq.zza(zzeq.this, zzeq.zzc(zzeq.this));
            if (zzeq.zzd(zzeq.this) == null)
            {
              zzeq.this.zzr(4);
              return;
            }
          }
          if ((zzeq.zze(zzeq.this)) && (!zzeq.zza(zzeq.this, 1)))
          {
            zzb.zzaH("Ignoring adapter " + zzeq.zzf(zzeq.this) + " as delayed" + " impression is not supported");
            zzeq.this.zzr(2);
            return;
          }
          localObject2.zza(zzeq.this);
          zzeq.zza(zzeq.this, localObject2);
        }
      });
      zza(l, this.zzBe, paramLong1, paramLong2);
      localObject2 = new zzer(this.zzBg, this.zzBi, this.zzBd, (zzep)localObject2, this.zzBj, zzeo());
      return (zzer)localObject2;
    }
  }
  
  public void zza(int paramInt, zzez paramzzez)
  {
    synchronized (this.zzpK)
    {
      this.zzBj = paramInt;
      this.zzBk = paramzzez;
      this.zzpK.notify();
      return;
    }
  }
  
  public void zzr(int paramInt)
  {
    synchronized (this.zzpK)
    {
      this.zzBj = paramInt;
      this.zzpK.notify();
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */