package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class zzb
{
  public static void zza(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void zzaa(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void zzcx(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzcy(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzu(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null reference");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */