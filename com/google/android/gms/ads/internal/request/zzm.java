package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzei.zzb;
import com.google.android.gms.internal.zzei.zzd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjg.zza;
import com.google.android.gms.internal.zzjg.zzc;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zznl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzm
  extends zzil
{
  static final long zzHl = TimeUnit.SECONDS.toMillis(10L);
  private static boolean zzHm = false;
  private static zzei zzHn = null;
  private static zzdm zzHo = null;
  private static zzdq zzHp = null;
  private static zzdl zzHq = null;
  private static final Object zzqf = new Object();
  private final Context mContext;
  private final Object zzFf = new Object();
  private final zza.zza zzGd;
  private final AdRequestInfoParcel.zza zzGe;
  private zzei.zzd zzHr;
  
  public zzm(Context paramContext, AdRequestInfoParcel.zza paramzza, zza.zza arg3)
  {
    super(true);
    this.zzGd = ???;
    this.mContext = paramContext;
    this.zzGe = paramzza;
    synchronized (zzqf)
    {
      if (!zzHm)
      {
        zzHp = new zzdq();
        zzHo = new zzdm(paramContext.getApplicationContext(), paramzza.zzqR);
        zzHq = new zzc();
        zzHn = new zzei(this.mContext.getApplicationContext(), this.zzGe.zzqR, (String)zzbz.zzvg.get(), new zzb(), new zza());
        zzHm = true;
      }
      return;
    }
  }
  
  private JSONObject zza(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    Bundle localBundle = paramAdRequestInfoParcel.zzGq.extras.getBundle("sdk_less_server_data");
    String str = paramAdRequestInfoParcel.zzGq.extras.getString("sdk_less_network_id");
    if (localBundle == null) {}
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = zzhd.zza(this.mContext, paramAdRequestInfoParcel, zzp.zzbD().zzE(this.mContext), null, null, new zzbs((String)zzbz.zzvg.get()), null, null, new ArrayList(), null);
    } while (localJSONObject == null);
    try
    {
      paramAdRequestInfoParcel = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
      localHashMap = new HashMap();
      localHashMap.put("request_id", paramString);
      localHashMap.put("network_id", str);
      localHashMap.put("request_param", localJSONObject);
      localHashMap.put("data", localBundle);
      if (paramAdRequestInfoParcel != null)
      {
        localHashMap.put("adid", paramAdRequestInfoParcel.getId());
        if (!paramAdRequestInfoParcel.isLimitAdTrackingEnabled()) {
          break label204;
        }
        i = 1;
        localHashMap.put("lat", Integer.valueOf(i));
      }
    }
    catch (IOException paramAdRequestInfoParcel)
    {
      for (;;)
      {
        try
        {
          HashMap localHashMap;
          paramAdRequestInfoParcel = zzp.zzbx().zzz(localHashMap);
          return paramAdRequestInfoParcel;
        }
        catch (JSONException paramAdRequestInfoParcel)
        {
          int i;
          return null;
        }
        paramAdRequestInfoParcel = paramAdRequestInfoParcel;
        zzb.zzd("Cannot get advertising id info", paramAdRequestInfoParcel);
        paramAdRequestInfoParcel = null;
        continue;
        i = 0;
      }
    }
    catch (IllegalStateException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesNotAvailableException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesRepairableException paramAdRequestInfoParcel)
    {
      label204:
      for (;;) {}
    }
  }
  
  protected static void zzc(zzbb paramzzbb)
  {
    paramzzbb.zza("/loadAd", zzHp);
    paramzzbb.zza("/fetchHttpRequest", zzHo);
    paramzzbb.zza("/invalidRequest", zzHq);
  }
  
  protected static void zzd(zzbb paramzzbb)
  {
    paramzzbb.zzb("/loadAd", zzHp);
    paramzzbb.zzb("/fetchHttpRequest", zzHo);
    paramzzbb.zzb("/invalidRequest", zzHq);
  }
  
  private AdResponseParcel zze(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    final Object localObject = UUID.randomUUID().toString();
    final JSONObject localJSONObject = zza(paramAdRequestInfoParcel, (String)localObject);
    if (localJSONObject == null) {
      paramAdRequestInfoParcel = new AdResponseParcel(0);
    }
    for (;;)
    {
      return paramAdRequestInfoParcel;
      long l1 = zzp.zzbB().elapsedRealtime();
      Future localFuture = zzHp.zzW((String)localObject);
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          zzm.zza(zzm.this, zzm.zzgl().zzei());
          zzm.zzb(zzm.this).zza(new zzjg.zzc()new zzjg.zza
          {
            public void zzb(zzbe paramAnonymous2zzbe)
            {
              try
              {
                paramAnonymous2zzbe.zza("AFMA_getAdapterLessMediationAd", zzm.2.this.zzHt);
                return;
              }
              catch (Exception paramAnonymous2zzbe)
              {
                zzb.zzb("Error requesting an ad url", paramAnonymous2zzbe);
                zzm.zzgk().zzX(zzm.2.this.zzHu);
              }
            }
          }, new zzjg.zza()
          {
            public void run()
            {
              zzm.zzgk().zzX(zzm.2.this.zzHu);
            }
          });
        }
      });
      long l2 = zzHl;
      long l3 = zzp.zzbB().elapsedRealtime();
      try
      {
        localObject = (JSONObject)localFuture.get(l2 - (l3 - l1), TimeUnit.MILLISECONDS);
        if (localObject == null) {
          return new AdResponseParcel(-1);
        }
      }
      catch (CancellationException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(-1);
      }
      catch (TimeoutException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(2);
      }
      catch (ExecutionException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(0);
        localObject = zzhd.zza(this.mContext, paramAdRequestInfoParcel, ((JSONObject)localObject).toString());
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (((AdResponseParcel)localObject).errorCode == -3) {
          continue;
        }
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (!TextUtils.isEmpty(((AdResponseParcel)localObject).body)) {
          continue;
        }
        return new AdResponseParcel(3);
      }
      catch (InterruptedException paramAdRequestInfoParcel)
      {
        for (;;) {}
      }
    }
  }
  
  public void onStop()
  {
    synchronized (this.zzFf)
    {
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          if (zzm.zzb(zzm.this) != null)
          {
            zzm.zzb(zzm.this).release();
            zzm.zza(zzm.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzbp()
  {
    zzb.zzaF("SdkLessAdLoaderBackgroundTask started.");
    final Object localObject = new AdRequestInfoParcel(this.zzGe, null, -1L);
    AdResponseParcel localAdResponseParcel = zze((AdRequestInfoParcel)localObject);
    long l = zzp.zzbB().elapsedRealtime();
    localObject = new zzie.zza((AdRequestInfoParcel)localObject, localAdResponseParcel, null, null, localAdResponseParcel.errorCode, l, localAdResponseParcel.zzGR, null);
    zza.zzLE.post(new Runnable()
    {
      public void run()
      {
        zzm.zza(zzm.this).zza(localObject);
        if (zzm.zzb(zzm.this) != null)
        {
          zzm.zzb(zzm.this).release();
          zzm.zza(zzm.this, null);
        }
      }
    });
  }
  
  public static class zza
    implements zzei.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzd(paramzzbb);
    }
  }
  
  public static class zzb
    implements zzei.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzc(paramzzbb);
    }
  }
  
  public static class zzc
    implements zzdl
  {
    public void zza(zzjn paramzzjn, Map<String, String> paramMap)
    {
      paramzzjn = (String)paramMap.get("request_id");
      paramMap = (String)paramMap.get("errors");
      zzb.zzaH("Invalid request: " + paramMap);
      zzm.zzgk().zzX(paramzzjn);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */