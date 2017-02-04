package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzha
public final class zzin
{
  public static Future zza(Context paramContext, final int paramInt)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences.Editor localEditor = zzin.zzI(this.zzsm).edit();
        localEditor.putInt("webview_cache_version", paramInt);
        localEditor.apply();
      }
    }.zzgX();
  }
  
  public static Future zza(Context paramContext, final zzb paramzzb)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences localSharedPreferences = zzin.zzI(this.zzsm);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("use_https", localSharedPreferences.getBoolean("use_https", true));
        if (paramzzb != null) {
          paramzzb.zze(localBundle);
        }
      }
    }.zzgX();
  }
  
  public static Future zza(Context paramContext, final boolean paramBoolean)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences.Editor localEditor = zzin.zzI(this.zzsm).edit();
        localEditor.putBoolean("use_https", paramBoolean);
        localEditor.apply();
      }
    }.zzgX();
  }
  
  public static Future zzb(Context paramContext, final zzb paramzzb)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences localSharedPreferences = zzin.zzI(this.zzsm);
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_cache_version", localSharedPreferences.getInt("webview_cache_version", 0));
        if (paramzzb != null) {
          paramzzb.zze(localBundle);
        }
      }
    }.zzgX();
  }
  
  public static Future zzb(Context paramContext, final boolean paramBoolean)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences.Editor localEditor = zzin.zzI(this.zzsm).edit();
        localEditor.putBoolean("content_url_opted_out", paramBoolean);
        localEditor.apply();
      }
    }.zzgX();
  }
  
  public static Future zzc(Context paramContext, final zzb paramzzb)
  {
    new zza(paramContext)
    {
      public void zzbp()
      {
        SharedPreferences localSharedPreferences = zzin.zzI(this.zzsm);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("content_url_opted_out", localSharedPreferences.getBoolean("content_url_opted_out", true));
        if (paramzzb != null) {
          paramzzb.zze(localBundle);
        }
      }
    }.zzgX();
  }
  
  private static SharedPreferences zzw(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }
  
  private static abstract class zza
    extends zzil
  {
    public void onStop() {}
  }
  
  public static abstract interface zzb
  {
    public abstract void zze(Bundle paramBundle);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */