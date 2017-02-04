package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

public class zzr
{
  private final zzf zzNq;
  private volatile Boolean zzQe;
  private String zzQf;
  private Set<Integer> zzQg;
  
  protected zzr(zzf paramzzf)
  {
    zzx.zzy(paramzzf);
    this.zzNq = paramzzf;
  }
  
  public String zzkA()
  {
    return "google_analytics_v4.db";
  }
  
  public String zzkB()
  {
    return "google_analytics2_v4.db";
  }
  
  public long zzkC()
  {
    return 86400000L;
  }
  
  public int zzkD()
  {
    return ((Integer)zzy.zzQT.get()).intValue();
  }
  
  public int zzkE()
  {
    return ((Integer)zzy.zzQU.get()).intValue();
  }
  
  public long zzkF()
  {
    return ((Long)zzy.zzQV.get()).longValue();
  }
  
  public long zzkG()
  {
    return ((Long)zzy.zzRe.get()).longValue();
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
    //   1: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   4: ifnonnull +129 -> 133
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   13: ifnonnull +118 -> 131
    //   16: aload_0
    //   17: getfield 26	com/google/android/gms/analytics/internal/zzr:zzNq	Lcom/google/android/gms/analytics/internal/zzf;
    //   20: invokevirtual 91	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   23: invokevirtual 97	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 26	com/google/android/gms/analytics/internal/zzr:zzNq	Lcom/google/android/gms/analytics/internal/zzf;
    //   31: invokevirtual 91	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   34: invokestatic 102	android/os/Process:myPid	()I
    //   37: invokestatic 108	com/google/android/gms/internal/zzny:zzj	(Landroid/content/Context;I)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: getfield 113	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +90 -> 141
    //   54: aload_3
    //   55: aload_2
    //   56: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +82 -> 141
    //   62: iconst_1
    //   63: istore_1
    //   64: aload_0
    //   65: iload_1
    //   66: invokestatic 125	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: putfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   72: aload_0
    //   73: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   76: ifnull +13 -> 89
    //   79: aload_0
    //   80: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   83: invokevirtual 128	java/lang/Boolean:booleanValue	()Z
    //   86: ifne +19 -> 105
    //   89: ldc -126
    //   91: aload_2
    //   92: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +10 -> 105
    //   98: aload_0
    //   99: getstatic 133	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   102: putfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   105: aload_0
    //   106: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   109: ifnonnull +22 -> 131
    //   112: aload_0
    //   113: getstatic 133	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   116: putfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   119: aload_0
    //   120: getfield 26	com/google/android/gms/analytics/internal/zzr:zzNq	Lcom/google/android/gms/analytics/internal/zzf;
    //   123: invokevirtual 137	com/google/android/gms/analytics/internal/zzf:zziU	()Lcom/google/android/gms/analytics/internal/zzaf;
    //   126: ldc -117
    //   128: invokevirtual 145	com/google/android/gms/analytics/internal/zzaf:zzbe	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_0
    //   134: getfield 85	com/google/android/gms/analytics/internal/zzr:zzQe	Ljava/lang/Boolean;
    //   137: invokevirtual 128	java/lang/Boolean:booleanValue	()Z
    //   140: ireturn
    //   141: iconst_0
    //   142: istore_1
    //   143: goto -79 -> 64
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	zzr
    //   63	80	1	bool	boolean
    //   40	52	2	str	String
    //   146	4	2	localObject1	Object
    //   26	29	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	41	146	finally
    //   45	50	146	finally
    //   54	62	146	finally
    //   64	72	146	finally
    //   72	89	146	finally
    //   89	105	146	finally
    //   105	131	146	finally
    //   131	133	146	finally
    //   147	149	146	finally
  }
  
  public boolean zzkc()
  {
    return ((Boolean)zzy.zzQq.get()).booleanValue();
  }
  
  public int zzkd()
  {
    return ((Integer)zzy.zzQJ.get()).intValue();
  }
  
  public int zzke()
  {
    return ((Integer)zzy.zzQN.get()).intValue();
  }
  
  public int zzkf()
  {
    return ((Integer)zzy.zzQO.get()).intValue();
  }
  
  public int zzkg()
  {
    return ((Integer)zzy.zzQP.get()).intValue();
  }
  
  public long zzkh()
  {
    return ((Long)zzy.zzQy.get()).longValue();
  }
  
  public long zzki()
  {
    return ((Long)zzy.zzQx.get()).longValue();
  }
  
  public long zzkj()
  {
    return ((Long)zzy.zzQB.get()).longValue();
  }
  
  public long zzkk()
  {
    return ((Long)zzy.zzQC.get()).longValue();
  }
  
  public int zzkl()
  {
    return ((Integer)zzy.zzQD.get()).intValue();
  }
  
  public int zzkm()
  {
    return ((Integer)zzy.zzQE.get()).intValue();
  }
  
  public long zzkn()
  {
    return ((Integer)zzy.zzQR.get()).intValue();
  }
  
  public String zzko()
  {
    return (String)zzy.zzQG.get();
  }
  
  public String zzkp()
  {
    return (String)zzy.zzQF.get();
  }
  
  public String zzkq()
  {
    return (String)zzy.zzQH.get();
  }
  
  public String zzkr()
  {
    return (String)zzy.zzQI.get();
  }
  
  public zzm zzks()
  {
    return zzm.zzbj((String)zzy.zzQK.get());
  }
  
  public zzo zzkt()
  {
    return zzo.zzbk((String)zzy.zzQL.get());
  }
  
  public Set<Integer> zzku()
  {
    String str1 = (String)zzy.zzQQ.get();
    String[] arrayOfString;
    HashSet localHashSet;
    int j;
    int i;
    if ((this.zzQg == null) || (this.zzQf == null) || (!this.zzQf.equals(str1)))
    {
      arrayOfString = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = arrayOfString[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        i += 1;
        continue;
        this.zzQf = str1;
        this.zzQg = localHashSet;
        return this.zzQg;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  public long zzkv()
  {
    return ((Long)zzy.zzQZ.get()).longValue();
  }
  
  public long zzkw()
  {
    return ((Long)zzy.zzRa.get()).longValue();
  }
  
  public long zzkx()
  {
    return ((Long)zzy.zzRd.get()).longValue();
  }
  
  public int zzky()
  {
    return ((Integer)zzy.zzQu.get()).intValue();
  }
  
  public int zzkz()
  {
    return ((Integer)zzy.zzQw.get()).intValue();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */