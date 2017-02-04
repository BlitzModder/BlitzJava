package com.google.android.gms.internal;

public class zzom
{
  public static final zzto.zzb zzavA = zzdk("distance");
  public static final zzto.zzb zzavB = zzdk("height");
  public static final zzto.zzb zzavC = zzdk("weight");
  public static final zzto.zzb zzavD = zzdk("circumference");
  public static final zzto.zzb zzavE = zzdk("percentage");
  public static final zzto.zzb zzavF = zzdk("speed");
  public static final zzto.zzb zzavG = zzdk("rpm");
  public static final zzto.zzb zzavH = zzdj("revolutions");
  public static final zzto.zzb zzavI = zzdk("calories");
  public static final zzto.zzb zzavJ = zzdk("watts");
  public static final zzto.zzb zzavK = zzdj("meal_type");
  public static final zzto.zzb zzavL = zzdl("food_item");
  public static final zzto.zzb zzavM = zzdm("nutrients");
  public static final zzto.zzb zzavN = zzdk("elevation.change");
  public static final zzto.zzb zzavO = zzdm("elevation.gain");
  public static final zzto.zzb zzavP = zzdm("elevation.loss");
  public static final zzto.zzb zzavQ = zzdk("floors");
  public static final zzto.zzb zzavR = zzdm("floor.gain");
  public static final zzto.zzb zzavS = zzdm("floor.loss");
  public static final zzto.zzb zzavT = zzdl("exercise");
  public static final zzto.zzb zzavU = zzdj("repetitions");
  public static final zzto.zzb zzavV = zzdk("resistance");
  public static final zzto.zzb zzavW = zzdj("resistance_type");
  public static final zzto.zzb zzavX = zzdj("num_segments");
  public static final zzto.zzb zzavY = zzdk("average");
  public static final zzto.zzb zzavZ = zzdk("max");
  public static final zzto.zzb zzavn = zzdj("activity");
  public static final zzto.zzb zzavo = zzdk("confidence");
  public static final zzto.zzb zzavp = zzdm("activity_confidence");
  public static final zzto.zzb zzavq = zzdj("steps");
  public static final zzto.zzb zzavr = zzdj("duration");
  public static final zzto.zzb zzavs = zzdm("activity_duration");
  public static final zzto.zzb zzavt = zzdm("activity_duration.ascending");
  public static final zzto.zzb zzavu = zzdm("activity_duration.descending");
  public static final zzto.zzb zzavv = zzdk("bpm");
  public static final zzto.zzb zzavw = zzdk("latitude");
  public static final zzto.zzb zzavx = zzdk("longitude");
  public static final zzto.zzb zzavy = zzdk("accuracy");
  public static final zzto.zzb zzavz = zzdk("altitude");
  public static final zzto.zzb zzawa = zzdk("min");
  public static final zzto.zzb zzawb = zzdk("low_latitude");
  public static final zzto.zzb zzawc = zzdk("low_longitude");
  public static final zzto.zzb zzawd = zzdk("high_latitude");
  public static final zzto.zzb zzawe = zzdk("high_longitude");
  public static final zzto.zzb zzawf = zzdk("x");
  public static final zzto.zzb zzawg = zzdk("y");
  public static final zzto.zzb zzawh = zzdk("z");
  public static final zzto.zzb zzawi = zzdn("timestamps");
  public static final zzto.zzb zzawj = zzdo("sensor_values");
  public static final zzto.zzb zzawk = zzdj("sensor_type");
  
  private static zzto.zzb zza(String paramString, int paramInt, Boolean paramBoolean)
  {
    zzto.zzb localzzb = new zzto.zzb();
    localzzb.name = paramString;
    localzzb.zzbql = Integer.valueOf(paramInt);
    if (paramBoolean != null) {
      localzzb.zzbqm = paramBoolean;
    }
    return localzzb;
  }
  
  private static zzto.zzb zzdj(String paramString)
  {
    return zzo(paramString, 1);
  }
  
  private static zzto.zzb zzdk(String paramString)
  {
    return zzo(paramString, 2);
  }
  
  private static zzto.zzb zzdl(String paramString)
  {
    return zzo(paramString, 3);
  }
  
  private static zzto.zzb zzdm(String paramString)
  {
    return zzo(paramString, 4);
  }
  
  private static zzto.zzb zzdn(String paramString)
  {
    return zzo(paramString, 5);
  }
  
  private static zzto.zzb zzdo(String paramString)
  {
    return zzo(paramString, 6);
  }
  
  public static zzto.zzb zzo(String paramString, int paramInt)
  {
    return zza(paramString, paramInt, null);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */