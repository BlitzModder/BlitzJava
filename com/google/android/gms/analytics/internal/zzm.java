package com.google.android.gms.analytics.internal;

public enum zzm
{
  private zzm() {}
  
  public static zzm zzbj(String paramString)
  {
    if ("BATCH_BY_SESSION".equalsIgnoreCase(paramString)) {
      return zzPR;
    }
    if ("BATCH_BY_TIME".equalsIgnoreCase(paramString)) {
      return zzPS;
    }
    if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(paramString)) {
      return zzPT;
    }
    if ("BATCH_BY_COUNT".equalsIgnoreCase(paramString)) {
      return zzPU;
    }
    if ("BATCH_BY_SIZE".equalsIgnoreCase(paramString)) {
      return zzPV;
    }
    return zzPQ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */