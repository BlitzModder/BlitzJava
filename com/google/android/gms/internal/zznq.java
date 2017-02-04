package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public final class zznq
{
  private static IntentFilter zzaml = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static long zzamm;
  private static float zzamn = NaN.0F;
  
  public static int zzaw(Context paramContext)
  {
    int k = 1;
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      return -1;
    }
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, zzaml);
    label44:
    boolean bool;
    label64:
    int j;
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0) {
        break label95;
      }
      i = 1;
      if (!zznx.zzrV()) {
        break label100;
      }
      bool = ((PowerManager)paramContext.getSystemService("power")).isInteractive();
      if (!bool) {
        break label117;
      }
      j = 1;
      label71:
      if (i == 0) {
        break label122;
      }
    }
    label95:
    label100:
    label117:
    label122:
    for (int i = k;; i = 0)
    {
      return j << 1 | i;
      i = localIntent.getIntExtra("plugged", 0);
      break;
      i = 0;
      break label44;
      bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      break label64;
      j = 0;
      break label71;
    }
  }
  
  /* Error */
  public static float zzax(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 74	android/os/SystemClock:elapsedRealtime	()J
    //   6: getstatic 76	com/google/android/gms/internal/zznq:zzamm	J
    //   9: lsub
    //   10: ldc2_w 77
    //   13: lcmp
    //   14: ifge +21 -> 35
    //   17: getstatic 25	com/google/android/gms/internal/zznq:zzamn	F
    //   20: ldc 23
    //   22: fcmpl
    //   23: ifeq +12 -> 35
    //   26: getstatic 25	com/google/android/gms/internal/zznq:zzamn	F
    //   29: fstore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: fload_1
    //   34: freturn
    //   35: aload_0
    //   36: invokevirtual 34	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   39: aconst_null
    //   40: getstatic 22	com/google/android/gms/internal/zznq:zzaml	Landroid/content/IntentFilter;
    //   43: invokevirtual 38	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +27 -> 75
    //   51: aload_0
    //   52: ldc 80
    //   54: iconst_m1
    //   55: invokevirtual 63	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: aload_0
    //   60: ldc 82
    //   62: iconst_m1
    //   63: invokevirtual 63	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   66: istore_3
    //   67: iload_2
    //   68: i2f
    //   69: iload_3
    //   70: i2f
    //   71: fdiv
    //   72: putstatic 25	com/google/android/gms/internal/zznq:zzamn	F
    //   75: invokestatic 74	android/os/SystemClock:elapsedRealtime	()J
    //   78: putstatic 76	com/google/android/gms/internal/zznq:zzamm	J
    //   81: getstatic 25	com/google/android/gms/internal/zznq:zzamn	F
    //   84: fstore_1
    //   85: goto -55 -> 30
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   29	56	1	f	float
    //   58	10	2	i	int
    //   66	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   3	30	88	finally
    //   35	47	88	finally
    //   51	75	88	finally
    //   75	85	88	finally
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zznq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */