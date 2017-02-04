package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@zzha
public final class zzbz
{
  public static final zzbv<String> zzvA;
  public static final zzbv<Long> zzvB;
  public static final zzbv<String> zzvC;
  public static final zzbv<Boolean> zzvD;
  public static final zzbv<String> zzvE;
  public static final zzbv<Boolean> zzvF;
  public static final zzbv<Boolean> zzvG;
  public static final zzbv<Boolean> zzvH;
  public static final zzbv<String> zzvI;
  public static final zzbv<String> zzvJ;
  public static final zzbv<String> zzvK;
  public static final zzbv<Boolean> zzvL;
  public static final zzbv<String> zzvM;
  public static final zzbv<Boolean> zzvN;
  public static final zzbv<Boolean> zzvO;
  public static final zzbv<Integer> zzvP;
  public static final zzbv<Integer> zzvQ;
  public static final zzbv<Integer> zzvR;
  public static final zzbv<Integer> zzvS;
  public static final zzbv<Integer> zzvT;
  public static final zzbv<Boolean> zzvU;
  public static final zzbv<Boolean> zzvV;
  public static final zzbv<Long> zzvW;
  public static final zzbv<String> zzvX;
  public static final zzbv<String> zzvY;
  public static final zzbv<Boolean> zzvZ;
  public static final zzbv<String> zzvf = zzbv.zzc(0, "gads:sdk_core_experiment_id");
  public static final zzbv<String> zzvg = zzbv.zza(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
  public static final zzbv<Boolean> zzvh = zzbv.zza(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
  public static final zzbv<String> zzvi = zzbv.zzc(0, "gads:request_builder:singleton_webview_experiment_id");
  public static final zzbv<Boolean> zzvj = zzbv.zza(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(false));
  public static final zzbv<String> zzvk = zzbv.zzc(0, "gads:sdk_use_dynamic_module_experiment_id");
  public static final zzbv<Boolean> zzvl = zzbv.zza(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
  public static final zzbv<Boolean> zzvm = zzbv.zza(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
  public static final zzbv<Boolean> zzvn = zzbv.zza(0, "gads:block_autoclicks", Boolean.valueOf(false));
  public static final zzbv<String> zzvo = zzbv.zzc(0, "gads:block_autoclicks_experiment_id");
  public static final zzbv<String> zzvp = zzbv.zzd(0, "gads:prefetch:experiment_id");
  public static final zzbv<String> zzvq = zzbv.zzc(0, "gads:spam_app_context:experiment_id");
  public static final zzbv<Boolean> zzvr = zzbv.zza(0, "gads:spam_app_context:enabled", Boolean.valueOf(false));
  public static final zzbv<String> zzvs = zzbv.zzc(0, "gads:video_stream_cache:experiment_id");
  public static final zzbv<Integer> zzvt = zzbv.zza(0, "gads:video_stream_cache:limit_count", 5);
  public static final zzbv<Integer> zzvu = zzbv.zza(0, "gads:video_stream_cache:limit_space", 8388608);
  public static final zzbv<Integer> zzvv = zzbv.zza(0, "gads:video_stream_exo_cache:buffer_size", 8388608);
  public static final zzbv<Long> zzvw = zzbv.zza(0, "gads:video_stream_cache:limit_time_sec", 300L);
  public static final zzbv<Long> zzvx = zzbv.zza(0, "gads:video_stream_cache:notify_interval_millis", 1000L);
  public static final zzbv<Integer> zzvy = zzbv.zza(0, "gads:video_stream_cache:connect_timeout_millis", 10000);
  public static final zzbv<Boolean> zzvz = zzbv.zza(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
  public static final zzbv<Boolean> zzwA = zzbv.zza(0, "gads:mediation:dynamite_first", Boolean.valueOf(true));
  public static final zzbv<Long> zzwB = zzbv.zza(0, "gads:ad_loader:timeout_ms", 60000L);
  public static final zzbv<Long> zzwC = zzbv.zza(0, "gads:rendering:timeout_ms", 60000L);
  public static final zzbv<Boolean> zzwD = zzbv.zza(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
  public static final zzbv<Boolean> zzwE = zzbv.zza(0, "gass:enabled", Boolean.valueOf(false));
  public static final zzbv<Boolean> zzwF = zzbv.zza(0, "gass:enable_int_signal", Boolean.valueOf(true));
  public static final zzbv<Boolean> zzwG = zzbv.zza(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
  public static final zzbv<Boolean> zzwH = zzbv.zza(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
  public static final zzbv<Boolean> zzwI = zzbv.zza(0, "gads:support_screen_shot", Boolean.valueOf(true));
  public static final zzbv<Long> zzwJ = zzbv.zza(0, "gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12L));
  public static final zzbv<Boolean> zzwa;
  public static final zzbv<Boolean> zzwb;
  public static final zzbv<String> zzwc;
  public static final zzbv<Boolean> zzwd;
  public static final zzbv<Boolean> zzwe;
  public static final zzbv<Integer> zzwf;
  public static final zzbv<String> zzwg;
  public static final zzbv<String> zzwh;
  public static final zzbv<Boolean> zzwi;
  public static final zzbv<Boolean> zzwj;
  public static final zzbv<String> zzwk;
  public static final zzbv<Integer> zzwl;
  public static final zzbv<Integer> zzwm;
  public static final zzbv<Integer> zzwn;
  public static final zzbv<String> zzwo;
  public static final zzbv<Boolean> zzwp;
  public static final zzbv<Boolean> zzwq;
  public static final zzbv<Long> zzwr;
  public static final zzbv<Boolean> zzws;
  public static final zzbv<Boolean> zzwt;
  public static final zzbv<Boolean> zzwu;
  public static final zzbv<Boolean> zzwv;
  public static final zzbv<Boolean> zzww;
  public static final zzbv<Boolean> zzwx;
  public static final zzbv<Boolean> zzwy;
  public static final zzbv<Long> zzwz;
  
  static
  {
    zzvA = zzbv.zza(0, "gads:video:metric_frame_hash_times", "");
    zzvB = zzbv.zza(0, "gads:video:metric_frame_hash_time_leniency", 500L);
    zzvC = zzbv.zzd(0, "gads:spam_ad_id_decorator:experiment_id");
    zzvD = zzbv.zza(0, "gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    zzvE = zzbv.zzd(0, "gads:looper_for_gms_client:experiment_id");
    zzvF = zzbv.zza(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    zzvG = zzbv.zza(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    zzvH = zzbv.zza(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
    zzvI = zzbv.zza(0, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    zzvJ = zzbv.zza(0, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    zzvK = zzbv.zza(0, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    zzvL = zzbv.zza(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
    zzvM = zzbv.zza(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    zzvN = zzbv.zza(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    zzvO = zzbv.zza(0, "gads:enable_content_fetching", Boolean.valueOf(true));
    zzvP = zzbv.zza(0, "gads:content_length_weight", 1);
    zzvQ = zzbv.zza(0, "gads:content_age_weight", 1);
    zzvR = zzbv.zza(0, "gads:min_content_len", 11);
    zzvS = zzbv.zza(0, "gads:fingerprint_number", 10);
    zzvT = zzbv.zza(0, "gads:sleep_sec", 10);
    zzvU = zzbv.zza(0, "gad:app_index_enabled", Boolean.valueOf(true));
    zzvV = zzbv.zza(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
    zzvW = zzbv.zza(0, "gads:app_index:timeout_ms", 1000L);
    zzvX = zzbv.zzc(0, "gads:app_index:experiment_id");
    zzvY = zzbv.zzc(0, "gads:kitkat_interstitial_workaround:experiment_id");
    zzvZ = zzbv.zza(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    zzwa = zzbv.zza(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
    zzwb = zzbv.zza(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    zzwc = zzbv.zzc(0, "gads:interstitial_follow_url:experiment_id");
    zzwd = zzbv.zza(0, "gads:analytics_enabled", Boolean.valueOf(true));
    zzwe = zzbv.zza(0, "gads:ad_key_enabled", Boolean.valueOf(false));
    zzwf = zzbv.zza(0, "gads:webview_cache_version", 0);
    zzwg = zzbv.zzd(0, "gads:pan:experiment_id");
    zzwh = zzbv.zza(0, "gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    zzwi = zzbv.zza(0, "gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    zzwj = zzbv.zza(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
    zzwk = zzbv.zza(1, "gads:interstitial_ad_pool:schema", "customTargeting");
    zzwl = zzbv.zza(1, "gads:interstitial_ad_pool:max_pools", 3);
    zzwm = zzbv.zza(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
    zzwn = zzbv.zza(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
    zzwo = zzbv.zzc(1, "gads:interstitial_ad_pool:experiment_id");
    zzwp = zzbv.zza(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
    zzwq = zzbv.zza(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
    zzwr = zzbv.zza(0, "gads:device_info_caching_expiry_ms:expiry", 300000L);
    zzws = zzbv.zza(0, "gads:gen204_signals:enabled", Boolean.valueOf(false));
    zzwt = zzbv.zza(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    zzwu = zzbv.zza(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
    zzwv = zzbv.zza(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
    zzww = zzbv.zza(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
    zzwx = zzbv.zza(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
    zzwy = zzbv.zza(0, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
    zzwz = zzbv.zza(0, "gads:network:cache_prediction_duration_s", 300L);
  }
  
  public static void initialize(Context paramContext)
  {
    zziz.zzb(new Callable()
    {
      public Void zzdm()
      {
        zzp.zzbG().initialize(this.zzsm);
        return null;
      }
    });
  }
  
  public static List<String> zzdl()
  {
    return zzp.zzbF().zzdl();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */