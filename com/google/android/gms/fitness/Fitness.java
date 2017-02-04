package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzos.zzb;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzot.zzb;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzou.zzb;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zzb;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzox.zzb;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zzb;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import java.util.concurrent.TimeUnit;

public class Fitness
{
  public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
  public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
  public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
  @Deprecated
  public static final Void API;
  public static final Api<Api.ApiOptions.NoOptions> BLE_API;
  public static final BleApi BleApi;
  public static final Api<Api.ApiOptions.NoOptions> CONFIG_API;
  public static final ConfigApi ConfigApi;
  public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
  public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
  public static final Api<Api.ApiOptions.NoOptions> HISTORY_API;
  public static final HistoryApi HistoryApi;
  public static final Api<Api.ApiOptions.NoOptions> RECORDING_API;
  public static final RecordingApi RecordingApi;
  public static final Scope SCOPE_ACTIVITY_READ;
  public static final Scope SCOPE_ACTIVITY_READ_WRITE;
  public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
  public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
  public static final Scope SCOPE_LOCATION_READ;
  public static final Scope SCOPE_LOCATION_READ_WRITE;
  public static final Scope SCOPE_NUTRITION_READ = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
  public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
  public static final Api<Api.ApiOptions.NoOptions> SENSORS_API;
  public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API;
  public static final SensorsApi SensorsApi;
  public static final SessionsApi SessionsApi;
  public static final Api<Api.ApiOptions.NoOptions> zzamM;
  public static final Api.zzc<zzos> zzatF = new Api.zzc();
  public static final Api.zzc<zzot> zzatG = new Api.zzc();
  public static final Api.zzc<zzou> zzatH = new Api.zzc();
  public static final Api.zzc<zzov> zzatI = new Api.zzc();
  public static final Api.zzc<zzow> zzatJ = new Api.zzc();
  public static final Api.zzc<zzox> zzatK = new Api.zzc();
  public static final Api.zzc<zzoy> zzatL = new Api.zzc();
  public static final zzpr zzatM;
  
  static
  {
    API = null;
    SENSORS_API = new Api("Fitness.SENSORS_API", new zzox.zzb(), zzatK);
    SensorsApi = new zzpy();
    RECORDING_API = new Api("Fitness.RECORDING_API", new zzow.zzb(), zzatJ);
    RecordingApi = new zzpx();
    SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzoy.zzb(), zzatL);
    SessionsApi = new zzpz();
    HISTORY_API = new Api("Fitness.HISTORY_API", new zzou.zzb(), zzatH);
    HistoryApi = new zzpv();
    CONFIG_API = new Api("Fitness.CONFIG_API", new zzot.zzb(), zzatG);
    ConfigApi = new zzpu();
    BLE_API = new Api("Fitness.BLE_API", new zzos.zzb(), zzatF);
    BleApi = zztx();
    zzamM = new Api("Fitness.INTERNAL_API", new zzov.zza(), zzatI);
    zzatM = new zzpw();
    SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
  }
  
  public static long getEndTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.end_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  public static long getStartTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.start_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  private static BleApi zztx()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new zzpt();
    }
    return new zzqb();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/Fitness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */