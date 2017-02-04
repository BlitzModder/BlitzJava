package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmt;

public final class zzk
{
  public static zza<Boolean> zzaSO = zza.zzi("measurement.service_enabled", true);
  public static zza<Boolean> zzaSP = zza.zzi("measurement.service_client_enabled", true);
  public static zza<String> zzaSQ = zza.zzj("measurement.log_tag", "GMPM", "GMPM-SVC");
  public static zza<Long> zzaSR = zza.zzf("measurement.ad_id_cache_time", 10000L);
  public static zza<Long> zzaSS = zza.zzf("measurement.monitoring.sample_period_millis", 86400000L);
  public static zza<Integer> zzaST = zza.zzA("measurement.upload.max_bundles", 100);
  public static zza<Integer> zzaSU = zza.zzA("measurement.upload.max_batch_size", 65536);
  public static zza<String> zzaSV = zza.zzN("measurement.upload.url", "https://app-measurement.com/a");
  public static zza<Long> zzaSW = zza.zzf("measurement.upload.backoff_period", 43200000L);
  public static zza<Long> zzaSX = zza.zzf("measurement.upload.window_interval", 3600000L);
  public static zza<Long> zzaSY = zza.zzf("measurement.upload.interval", 3600000L);
  public static zza<Long> zzaSZ = zza.zzf("measurement.upload.stale_data_deletion_interval", 86400000L);
  public static zza<Long> zzaTa = zza.zzf("measurement.upload.initial_upload_delay_time", 15000L);
  public static zza<Long> zzaTb = zza.zzf("measurement.upload.retry_time", 1800000L);
  public static zza<Integer> zzaTc = zza.zzA("measurement.upload.retry_count", 6);
  public static zza<Long> zzaTd = zza.zzf("measurement.upload.max_queue_time", 2419200000L);
  public static zza<Long> zzaTe = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000L);
  
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
    
    static zza<Integer> zzA(String paramString, int paramInt)
    {
      return zzo(paramString, paramInt, paramInt);
    }
    
    static zza<String> zzN(String paramString1, String paramString2)
    {
      return zzj(paramString1, paramString2, paramString2);
    }
    
    static zza<Long> zzb(String paramString, long paramLong1, long paramLong2)
    {
      return new zza(zzmt.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static zza<Boolean> zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new zza(zzmt.zzg(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static zza<Long> zzf(String paramString, long paramLong)
    {
      return zzb(paramString, paramLong, paramLong);
    }
    
    static zza<Boolean> zzi(String paramString, boolean paramBoolean)
    {
      return zzb(paramString, paramBoolean, paramBoolean);
    }
    
    static zza<String> zzj(String paramString1, String paramString2, String paramString3)
    {
      return new zza(zzmt.zzw(paramString1, paramString3), paramString2);
    }
    
    static zza<Integer> zzo(String paramString, int paramInt1, int paramInt2)
    {
      return new zza(zzmt.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */