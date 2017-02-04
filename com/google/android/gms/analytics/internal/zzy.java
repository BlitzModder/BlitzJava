package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmt;

public final class zzy
{
  public static zza<Long> zzQA = zza.zzb("analytics.max_local_dispatch_millis", 7200000L);
  public static zza<Long> zzQB = zza.zzb("analytics.dispatch_alarm_millis", 7200000L);
  public static zza<Long> zzQC = zza.zzb("analytics.max_dispatch_alarm_millis", 32400000L);
  public static zza<Integer> zzQD = zza.zzd("analytics.max_hits_per_dispatch", 20);
  public static zza<Integer> zzQE = zza.zzd("analytics.max_hits_per_batch", 20);
  public static zza<String> zzQF = zza.zzm("analytics.insecure_host", "http://www.google-analytics.com");
  public static zza<String> zzQG = zza.zzm("analytics.secure_host", "https://ssl.google-analytics.com");
  public static zza<String> zzQH = zza.zzm("analytics.simple_endpoint", "/collect");
  public static zza<String> zzQI = zza.zzm("analytics.batching_endpoint", "/batch");
  public static zza<Integer> zzQJ = zza.zzd("analytics.max_get_length", 2036);
  public static zza<String> zzQK = zza.zzd("analytics.batching_strategy.k", zzm.zzPU.name(), zzm.zzPU.name());
  public static zza<String> zzQL = zza.zzm("analytics.compression_strategy.k", zzo.zzQb.name());
  public static zza<Integer> zzQM = zza.zzd("analytics.max_hits_per_request.k", 20);
  public static zza<Integer> zzQN = zza.zzd("analytics.max_hit_length.k", 8192);
  public static zza<Integer> zzQO = zza.zzd("analytics.max_post_length.k", 8192);
  public static zza<Integer> zzQP = zza.zzd("analytics.max_batch_post_length", 8192);
  public static zza<String> zzQQ = zza.zzm("analytics.fallback_responses.k", "404,502");
  public static zza<Integer> zzQR = zza.zzd("analytics.batch_retry_interval.seconds.k", 3600);
  public static zza<Long> zzQS = zza.zzb("analytics.service_monitor_interval", 86400000L);
  public static zza<Integer> zzQT = zza.zzd("analytics.http_connection.connect_timeout_millis", 60000);
  public static zza<Integer> zzQU = zza.zzd("analytics.http_connection.read_timeout_millis", 61000);
  public static zza<Long> zzQV = zza.zzb("analytics.campaigns.time_limit", 86400000L);
  public static zza<String> zzQW = zza.zzm("analytics.first_party_experiment_id", "");
  public static zza<Integer> zzQX = zza.zzd("analytics.first_party_experiment_variant", 0);
  public static zza<Boolean> zzQY = zza.zzd("analytics.test.disable_receiver", false);
  public static zza<Long> zzQZ = zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
  public static zza<Boolean> zzQp = zza.zzd("analytics.service_enabled", false);
  public static zza<Boolean> zzQq = zza.zzd("analytics.service_client_enabled", true);
  public static zza<String> zzQr = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
  public static zza<Long> zzQs = zza.zzb("analytics.max_tokens", 60L);
  public static zza<Float> zzQt = zza.zza("analytics.tokens_per_sec", 0.5F);
  public static zza<Integer> zzQu = zza.zza("analytics.max_stored_hits", 2000, 20000);
  public static zza<Integer> zzQv = zza.zzd("analytics.max_stored_hits_per_app", 2000);
  public static zza<Integer> zzQw = zza.zzd("analytics.max_stored_properties_per_app", 100);
  public static zza<Long> zzQx = zza.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
  public static zza<Long> zzQy = zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
  public static zza<Long> zzQz = zza.zzb("analytics.min_local_dispatch_millis", 120000L);
  public static zza<Long> zzRa = zza.zzb("analytics.service_client.connect_timeout_millis", 5000L);
  public static zza<Long> zzRb = zza.zzb("analytics.service_client.second_connect_delay_millis", 5000L);
  public static zza<Long> zzRc = zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000L);
  public static zza<Long> zzRd = zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000L);
  public static zza<Long> zzRe = zza.zzb("analytics.monitoring.sample_period_millis", 86400000L);
  public static zza<Long> zzRf = zza.zzb("analytics.initialization_warning_threshold", 5000L);
  
  public static final class zza<V>
  {
    private final V zzRg;
    private final zzmt<V> zzRh;
    private V zzRi;
    
    private zza(zzmt<V> paramzzmt, V paramV)
    {
      zzx.zzy(paramzzmt);
      this.zzRh = paramzzmt;
      this.zzRg = paramV;
    }
    
    static zza<Float> zza(String paramString, float paramFloat)
    {
      return zza(paramString, paramFloat, paramFloat);
    }
    
    static zza<Float> zza(String paramString, float paramFloat1, float paramFloat2)
    {
      return new zza(zzmt.zza(paramString, Float.valueOf(paramFloat2)), Float.valueOf(paramFloat1));
    }
    
    static zza<Integer> zza(String paramString, int paramInt1, int paramInt2)
    {
      return new zza(zzmt.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
    }
    
    static zza<Long> zza(String paramString, long paramLong1, long paramLong2)
    {
      return new zza(zzmt.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static zza<Boolean> zza(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new zza(zzmt.zzg(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static zza<Long> zzb(String paramString, long paramLong)
    {
      return zza(paramString, paramLong, paramLong);
    }
    
    static zza<Integer> zzd(String paramString, int paramInt)
    {
      return zza(paramString, paramInt, paramInt);
    }
    
    static zza<String> zzd(String paramString1, String paramString2, String paramString3)
    {
      return new zza(zzmt.zzw(paramString1, paramString3), paramString2);
    }
    
    static zza<Boolean> zzd(String paramString, boolean paramBoolean)
    {
      return zza(paramString, paramBoolean, paramBoolean);
    }
    
    static zza<String> zzm(String paramString1, String paramString2)
    {
      return zzd(paramString1, paramString2, paramString2);
    }
    
    public V get()
    {
      if (this.zzRi != null) {
        return (V)this.zzRi;
      }
      if ((zzd.zzaiU) && (zzmt.isInitialized())) {
        return (V)this.zzRh.zzpF();
      }
      return (V)this.zzRg;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */