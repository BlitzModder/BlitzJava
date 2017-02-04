package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzon
{
  public static final Set<String> AGGREGATE_INPUT_TYPES;
  public static final zzto.zza TYPE_DISTANCE_CUMULATIVE;
  public static final zzto.zza TYPE_STEP_COUNT_CUMULATIVE;
  private static final Map<String, List<zzto.zza>> zzaux;
  public static final zzto.zza zzawA;
  public static final zzto.zza zzawB;
  public static final zzto.zza zzawC;
  public static final zzto.zza zzawD;
  public static final zzto.zza zzawE;
  public static final zzto.zza zzawF;
  public static final zzto.zza zzawG;
  public static final zzto.zza zzawH;
  public static final zzto.zza zzawI;
  public static final zzto.zza zzawJ;
  public static final zzto.zza zzawK;
  public static final zzto.zza zzawL;
  public static final zzto.zza zzawM;
  public static final zzto.zza zzawN;
  public static final zzto.zza zzawO;
  public static final zzto.zza zzawP;
  public static final zzto.zza zzawQ;
  public static final zzto.zza zzawR;
  public static final zzto.zza zzawS;
  public static final zzto.zza zzawT;
  public static final zzto.zza zzawU;
  public static final zzto.zza zzawV;
  public static final zzto.zza zzawW;
  public static final zzto.zza zzawX;
  public static final zzto.zza zzawY;
  public static final zzto.zza zzawZ;
  public static final zzto.zza zzawl = zza("com.google.step_count.delta", new zzto.zzb[] { zzom.zzavq });
  public static final zzto.zza zzawm;
  public static final zzto.zza zzawn;
  public static final zzto.zza zzawo;
  public static final zzto.zza zzawp;
  public static final zzto.zza zzawq;
  public static final zzto.zza zzawr;
  public static final zzto.zza zzaws;
  public static final zzto.zza zzawt;
  public static final zzto.zza zzawu;
  public static final zzto.zza zzawv;
  public static final zzto.zza zzaww;
  public static final zzto.zza zzawx;
  public static final zzto.zza zzawy;
  public static final zzto.zza zzawz;
  public static final zzto.zza zzaxa;
  public static final zzto.zza zzaxb;
  public static final String[] zzaxc;
  private static final Map<zzto.zza, zza> zzaxd;
  
  static
  {
    TYPE_STEP_COUNT_CUMULATIVE = zza("com.google.step_count.cumulative", new zzto.zzb[] { zzom.zzavq });
    zzawm = zza("com.google.step_count.cadence", new zzto.zzb[] { zzom.zzavG });
    zzawn = zza("com.google.activity.segment", new zzto.zzb[] { zzom.zzavn });
    zzawo = zza("com.google.floor_change", new zzto.zzb[] { zzom.zzavn, zzom.zzavo, zzom.zzavN, zzom.zzavQ });
    zzawp = zza("com.google.calories.consumed", new zzto.zzb[] { zzom.zzavI });
    zzawq = zza("com.google.calories.expended", new zzto.zzb[] { zzom.zzavI });
    zzawr = zza("com.google.calories.bmr", new zzto.zzb[] { zzom.zzavI });
    zzaws = zza("com.google.power.sample", new zzto.zzb[] { zzom.zzavJ });
    zzawt = zza("com.google.activity.sample", new zzto.zzb[] { zzom.zzavn, zzom.zzavo });
    zzawu = zza("com.google.accelerometer", new zzto.zzb[] { zzom.zzawf, zzom.zzawg, zzom.zzawh });
    zzawv = zza("com.google.sensor.events", new zzto.zzb[] { zzom.zzawk, zzom.zzawi, zzom.zzawj });
    zzaww = zza("com.google.heart_rate.bpm", new zzto.zzb[] { zzom.zzavv });
    zzawx = zza("com.google.location.sample", new zzto.zzb[] { zzom.zzavw, zzom.zzavx, zzom.zzavy, zzom.zzavz });
    zzawy = zza("com.google.location.track", new zzto.zzb[] { zzom.zzavw, zzom.zzavx, zzom.zzavy, zzom.zzavz });
    zzawz = zza("com.google.distance.delta", new zzto.zzb[] { zzom.zzavA });
    TYPE_DISTANCE_CUMULATIVE = zza("com.google.distance.cumulative", new zzto.zzb[] { zzom.zzavA });
    zzawA = zza("com.google.speed", new zzto.zzb[] { zzom.zzavF });
    zzawB = zza("com.google.cycling.wheel_revolution.cumulative", new zzto.zzb[] { zzom.zzavH });
    zzawC = zza("com.google.cycling.wheel_revolution.rpm", new zzto.zzb[] { zzom.zzavG });
    zzawD = zza("com.google.cycling.pedaling.cumulative", new zzto.zzb[] { zzom.zzavH });
    zzawE = zza("com.google.cycling.pedaling.cadence", new zzto.zzb[] { zzom.zzavG });
    zzawF = zza("com.google.height", new zzto.zzb[] { zzom.zzavB });
    zzawG = zza("com.google.weight", new zzto.zzb[] { zzom.zzavC });
    zzawH = zza("com.google.body.fat.percentage", new zzto.zzb[] { zzom.zzavE });
    zzawI = zza("com.google.body.waist.circumference", new zzto.zzb[] { zzom.zzavD });
    zzawJ = zza("com.google.body.hip.circumference", new zzto.zzb[] { zzom.zzavD });
    zzawK = zza("com.google.nutrition", new zzto.zzb[] { zzom.zzavM, zzom.zzavK, zzom.zzavL });
    zzawL = zza("com.google.activity.exercise", new zzto.zzb[] { zzom.zzavT, zzom.zzavU, zzom.zzavr, zzom.zzavW, zzom.zzavV });
    AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { zzawn.name, zzawp.name, zzawq.name, zzawz.name, zzawo.name, zzaww.name, zzawx.name, zzawK.name, zzawA.name, zzawl.name, zzawG.name })));
    zzawM = zza("com.google.activity.summary", new zzto.zzb[] { zzom.zzavn, zzom.zzavr, zzom.zzavX });
    zzawN = zza("com.google.floor_change.summary", new zzto.zzb[] { zzom.zzavt, zzom.zzavu, zzom.zzavO, zzom.zzavP, zzom.zzavR, zzom.zzavS });
    zzawO = zzawl;
    zzawP = zzawz;
    zzawQ = zzawp;
    zzawR = zzawq;
    zzawS = zza("com.google.heart_rate.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawT = zza("com.google.location.bounding_box", new zzto.zzb[] { zzom.zzawb, zzom.zzawc, zzom.zzawd, zzom.zzawe });
    zzawU = zza("com.google.power.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawV = zza("com.google.speed.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawW = zza("com.google.weight.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawX = zza("com.google.calories.bmr.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawY = zza("com.google.body.fat.percentage.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzawZ = zza("com.google.body.hip.circumference.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzaxa = zza("com.google.body.waist.circumference.summary", new zzto.zzb[] { zzom.zzavY, zzom.zzavZ, zzom.zzawa });
    zzaxb = zza("com.google.nutrition.summary", new zzto.zzb[] { zzom.zzavM, zzom.zzavK });
    zzaux = zzuc();
    zzaxc = new String[] { "com.google.accelerometer", "com.google.activity.exercise", "com.google.activity.sample", "com.google.activity.segment", "com.google.activity.summary", "com.google.body.fat.percentage", "com.google.body.fat.percentage.summary", "com.google.body.hip.circumference", "com.google.body.hip.circumference.summary", "com.google.body.waist.circumference", "com.google.body.waist.circumference.summary", "com.google.calories.bmr", "com.google.calories.bmr.summary", "com.google.calories.consumed", "com.google.calories.expended", "com.google.cycling.pedaling.cadence", "com.google.cycling.pedaling.cumulative", "com.google.cycling.wheel_revolution.cumulative", "com.google.cycling.wheel_revolution.rpm", "com.google.distance.cumulative", "com.google.distance.delta", "com.google.floor_change", "com.google.floor_change.summary", "com.google.heart_rate.bpm", "com.google.heart_rate.summary", "com.google.height", "com.google.location.bounding_box", "com.google.location.sample", "com.google.location.track", "com.google.nutrition", "com.google.nutrition.summary", "com.google.power.sample", "com.google.power.summary", "com.google.sensor.events", "com.google.speed", "com.google.speed.summary", "com.google.step_count.cadence", "com.google.step_count.cumulative", "com.google.step_count.delta", "com.google.weight", "com.google.weight.summary" };
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add(TYPE_STEP_COUNT_CUMULATIVE);
    localHashSet1.add(TYPE_DISTANCE_CUMULATIVE);
    localHashSet1.add(zzawD);
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(zzawz);
    localHashSet2.add(zzawl);
    localHashSet2.add(zzawq);
    localHashSet2.add(zzawp);
    localHashSet2.add(zzawo);
    HashSet localHashSet3 = new HashSet();
    localHashSet3.add(zzawH);
    localHashSet3.add(zzawJ);
    localHashSet3.add(zzawI);
    localHashSet3.add(zzawK);
    localHashSet3.add(zzawF);
    localHashSet3.add(zzawG);
    localHashSet3.add(zzaww);
    HashMap localHashMap = new HashMap();
    zza(localHashMap, localHashSet1, zza.zzaxe);
    zza(localHashMap, localHashSet2, zza.zzaxf);
    zza(localHashMap, localHashSet3, zza.zzaxg);
    zzaxd = Collections.unmodifiableMap(localHashMap);
  }
  
  public static zzto.zza zza(String paramString, zzto.zzb... paramVarArgs)
  {
    zzto.zza localzza = new zzto.zza();
    localzza.name = paramString;
    localzza.zzbqj = paramVarArgs;
    return localzza;
  }
  
  private static void zza(Map<zzto.zza, zza> paramMap, Collection<zzto.zza> paramCollection, zza paramzza)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramMap.put((zzto.zza)paramCollection.next(), paramzza);
    }
  }
  
  public static boolean zzdp(String paramString)
  {
    return Arrays.binarySearch(zzaxc, paramString) >= 0;
  }
  
  private static Map<String, List<zzto.zza>> zzuc()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(zzawn.name, Collections.singletonList(zzawM));
    localHashMap.put(zzawp.name, Collections.singletonList(zzawQ));
    localHashMap.put(zzawq.name, Collections.singletonList(zzawR));
    localHashMap.put(zzawz.name, Collections.singletonList(zzawP));
    localHashMap.put(zzawo.name, Collections.singletonList(zzawN));
    localHashMap.put(zzawx.name, Collections.singletonList(zzawT));
    localHashMap.put(zzaws.name, Collections.singletonList(zzawU));
    localHashMap.put(zzaww.name, Collections.singletonList(zzawS));
    localHashMap.put(zzawA.name, Collections.singletonList(zzawV));
    localHashMap.put(zzawl.name, Collections.singletonList(zzawO));
    localHashMap.put(zzawG.name, Collections.singletonList(zzawW));
    return localHashMap;
  }
  
  public static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */