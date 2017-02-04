package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;

public class zzc
  extends zzv
{
  static final String zzaSt = String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  private Boolean zzQe;
  
  zzc(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  long zzAA()
  {
    return 3600000L;
  }
  
  long zzAB()
  {
    return 60000L;
  }
  
  long zzAC()
  {
    return 61000L;
  }
  
  long zzAD()
  {
    return ((Long)zzk.zzaSR.get()).longValue();
  }
  
  public long zzAE()
  {
    return GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000;
  }
  
  public long zzAF()
  {
    return ((Long)zzk.zzaTd.get()).longValue();
  }
  
  public long zzAG()
  {
    return ((Long)zzk.zzaSZ.get()).longValue();
  }
  
  public long zzAH()
  {
    return 20L;
  }
  
  public int zzAI()
  {
    return ((Integer)zzk.zzaST.get()).intValue();
  }
  
  public int zzAJ()
  {
    return Math.max(0, ((Integer)zzk.zzaSU.get()).intValue());
  }
  
  public String zzAK()
  {
    return (String)zzk.zzaSV.get();
  }
  
  public long zzAL()
  {
    return Math.max(0L, ((Long)zzk.zzaSW.get()).longValue());
  }
  
  public long zzAM()
  {
    return Math.max(0L, ((Long)zzk.zzaSY.get()).longValue());
  }
  
  public long zzAN()
  {
    return ((Long)zzk.zzaSX.get()).longValue();
  }
  
  public long zzAO()
  {
    return Math.max(0L, ((Long)zzk.zzaTa.get()).longValue());
  }
  
  public long zzAP()
  {
    return Math.max(0L, ((Long)zzk.zzaTb.get()).longValue());
  }
  
  public int zzAQ()
  {
    return Math.min(20, Math.max(0, ((Integer)zzk.zzaTc.get()).intValue()));
  }
  
  String zzAs()
  {
    return (String)zzk.zzaSQ.get();
  }
  
  int zzAt()
  {
    return 32;
  }
  
  public int zzAu()
  {
    return 24;
  }
  
  int zzAv()
  {
    return 36;
  }
  
  int zzAw()
  {
    return 256;
  }
  
  int zzAx()
  {
    return 36;
  }
  
  int zzAy()
  {
    return 2048;
  }
  
  int zzAz()
  {
    return 20;
  }
  
  public String zzkA()
  {
    return "google_app_measurement.db";
  }
  
  public String zzkB()
  {
    return "google_app_measurement2.db";
  }
  
  public long zzkG()
  {
    return Math.max(0L, ((Long)zzk.zzaSS.get()).longValue());
  }
  
  public boolean zzka()
  {
    return zzd.zzaiU;
  }
  
  /* Error */
  public boolean zzkb()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   4: ifnonnull +90 -> 94
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   13: ifnonnull +79 -> 92
    //   16: aload_0
    //   17: invokevirtual 206	com/google/android/gms/measurement/internal/zzc:getContext	()Landroid/content/Context;
    //   20: invokevirtual 212	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 206	com/google/android/gms/measurement/internal/zzc:getContext	()Landroid/content/Context;
    //   28: invokestatic 217	android/os/Process:myPid	()I
    //   31: invokestatic 223	com/google/android/gms/internal/zzny:zzj	(Landroid/content/Context;I)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +30 -> 66
    //   39: aload_3
    //   40: getfield 228	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +57 -> 102
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +49 -> 102
    //   56: iconst_1
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 237	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   63: putfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   66: aload_0
    //   67: getfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   70: ifnonnull +22 -> 92
    //   73: aload_0
    //   74: getstatic 240	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   77: putfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   80: aload_0
    //   81: invokevirtual 244	com/google/android/gms/measurement/internal/zzc:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   84: invokevirtual 250	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   87: ldc -4
    //   89: invokevirtual 258	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 205	com/google/android/gms/measurement/internal/zzc:zzQe	Ljava/lang/Boolean;
    //   98: invokevirtual 261	java/lang/Boolean:booleanValue	()Z
    //   101: ireturn
    //   102: iconst_0
    //   103: istore_1
    //   104: goto -46 -> 58
    //   107: astore_2
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	zzc
    //   57	47	1	bool	boolean
    //   34	16	2	str	String
    //   107	4	2	localObject1	Object
    //   23	26	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	35	107	finally
    //   39	44	107	finally
    //   48	56	107	finally
    //   58	66	107	finally
    //   66	92	107	finally
    //   92	94	107	finally
    //   108	110	107	finally
  }
  
  long zzkv()
  {
    return ((Long)zzk.zzaTe.get()).longValue();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */