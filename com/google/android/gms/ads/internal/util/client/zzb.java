package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzb
{
  public static void e(String paramString)
  {
    if (zzQ(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void v(String paramString)
  {
    if (zzQ(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static boolean zzQ(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && ((paramInt != 2) || (zzhs()));
  }
  
  public static void zza(String paramString, Throwable paramThrowable)
  {
    if (zzQ(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzaF(String paramString)
  {
    if (zzQ(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void zzaG(String paramString)
  {
    if (zzQ(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void zzaH(String paramString)
  {
    if (zzQ(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void zzb(String paramString, Throwable paramThrowable)
  {
    if (zzQ(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzc(String paramString, Throwable paramThrowable)
  {
    if (zzQ(4)) {
      Log.i("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzd(String paramString, Throwable paramThrowable)
  {
    if (zzQ(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean zzhs()
  {
    return ((Boolean)zzbz.zzwp.get()).booleanValue();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/util/client/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */