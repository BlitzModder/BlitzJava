package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzha;

@zzha
public class zzl
{
  private static final Object zzqf = new Object();
  private static zzl zzud;
  private final zza zzue = new zza();
  private final zze zzuf = new zze();
  private final zzad zzug = new zzad();
  private final zzdb zzuh = new zzdb();
  private final zzf zzui = new zzf();
  
  static
  {
    zza(new zzl());
  }
  
  protected static void zza(zzl paramzzl)
  {
    synchronized (zzqf)
    {
      zzud = paramzzl;
      return;
    }
  }
  
  private static zzl zzcM()
  {
    synchronized (zzqf)
    {
      zzl localzzl = zzud;
      return localzzl;
    }
  }
  
  public static zza zzcN()
  {
    return zzcM().zzue;
  }
  
  public static zze zzcO()
  {
    return zzcM().zzuf;
  }
  
  public static zzad zzcP()
  {
    return zzcM().zzug;
  }
  
  public static zzdb zzcQ()
  {
    return zzcM().zzuh;
  }
  
  public static zzf zzcR()
  {
    return zzcM().zzui;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */