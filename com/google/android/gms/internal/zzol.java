package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zzol
{
  private static final List<TimeUnit> zzatU = Arrays.asList(new TimeUnit[] { TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS });
  
  public static long zza(long paramLong, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return paramTimeUnit1.convert(paramTimeUnit2.convert(paramLong, paramTimeUnit1), paramTimeUnit2);
  }
  
  public static boolean zza(TimeUnit paramTimeUnit)
  {
    return zza(paramTimeUnit, TimeUnit.MILLISECONDS);
  }
  
  private static boolean zza(TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return zzatU.indexOf(paramTimeUnit1) < zzatU.indexOf(paramTimeUnit2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */