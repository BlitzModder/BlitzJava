package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzmt;

public final class zzc
{
  public static zzmt<Integer> zzalG = zzmt.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
  public static zzmt<Integer> zzalH = zzmt.zza("gms:common:stats:max_chunk_size", Integer.valueOf(100));
  
  public static final class zza
  {
    public static zzmt<Integer> zzalI = zzmt.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    public static zzmt<String> zzalJ = zzmt.zzw("gms:common:stats:connections:ignored_calling_processes", "");
    public static zzmt<String> zzalK = zzmt.zzw("gms:common:stats:connections:ignored_calling_services", "");
    public static zzmt<String> zzalL = zzmt.zzw("gms:common:stats:connections:ignored_target_processes", "");
    public static zzmt<String> zzalM = zzmt.zzw("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static zzmt<Long> zzalN = zzmt.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000L));
  }
  
  public static final class zzb
  {
    public static zzmt<Integer> zzalI = zzmt.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    public static zzmt<Long> zzalN = zzmt.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000L));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */