package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzha
public class zzet
  implements zzel
{
  private final Context mContext;
  private final zzen zzBf;
  private final AdRequestInfoParcel zzBu;
  private final long zzBv;
  private final long zzBw;
  private final int zzBx;
  private boolean zzBy = false;
  private final Map<zzje<zzer>, zzeq> zzBz = new HashMap();
  private final Object zzpK = new Object();
  private final zzew zzpd;
  private final boolean zzrF;
  
  public zzet(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzew paramzzew, zzen paramzzen, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    this.mContext = paramContext;
    this.zzBu = paramAdRequestInfoParcel;
    this.zzpd = paramzzew;
    this.zzBf = paramzzen;
    this.zzrF = paramBoolean;
    this.zzBv = paramLong1;
    this.zzBw = paramLong2;
    this.zzBx = paramInt;
  }
  
  private void zza(final zzje<zzer> paramzzje)
  {
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = zzet.zze(zzet.this).keySet().iterator();
        while (localIterator.hasNext())
        {
          zzje localzzje = (zzje)localIterator.next();
          if (localzzje != paramzzje) {
            ((zzeq)zzet.zze(zzet.this).get(localzzje)).cancel();
          }
        }
      }
    });
  }
  
  private zzer zzd(List<zzje<zzer>> paramList)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzBy)
        {
          paramList = new zzer(-1);
          return paramList;
        }
        ??? = paramList.iterator();
        if (((Iterator)???).hasNext()) {
          paramList = (zzje)((Iterator)???).next();
        }
      }
      try
      {
        zzer localzzer = (zzer)paramList.get();
        if ((localzzer == null) || (localzzer.zzBo != 0)) {
          continue;
        }
        zza(paramList);
        return localzzer;
      }
      catch (InterruptedException paramList)
      {
        zzb.zzd("Exception while processing an adapter; continuing with other adapters", paramList);
        continue;
        paramList = finally;
        throw paramList;
        zza(null);
        return new zzer(1);
      }
      catch (ExecutionException paramList)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private zzer zze(List<zzje<zzer>> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/internal/zzet:zzpK	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 41	com/google/android/gms/internal/zzet:zzBy	Z
    //   13: ifeq +17 -> 30
    //   16: new 95	com/google/android/gms/internal/zzer
    //   19: dup
    //   20: iconst_m1
    //   21: invokespecial 98	com/google/android/gms/internal/zzer:<init>	(I)V
    //   24: astore_1
    //   25: aload 8
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload 8
    //   32: monitorexit
    //   33: iconst_m1
    //   34: istore_2
    //   35: aconst_null
    //   36: astore 8
    //   38: aconst_null
    //   39: astore 9
    //   41: aload_0
    //   42: getfield 54	com/google/android/gms/internal/zzet:zzBf	Lcom/google/android/gms/internal/zzen;
    //   45: getfield 142	com/google/android/gms/internal/zzen:zzAY	J
    //   48: ldc2_w 143
    //   51: lcmp
    //   52: ifeq +159 -> 211
    //   55: aload_0
    //   56: getfield 54	com/google/android/gms/internal/zzet:zzBf	Lcom/google/android/gms/internal/zzen;
    //   59: getfield 142	com/google/android/gms/internal/zzen:zzAY	J
    //   62: lstore 4
    //   64: aload_1
    //   65: invokeinterface 104 1 0
    //   70: astore 11
    //   72: aload 11
    //   74: invokeinterface 110 1 0
    //   79: ifeq +214 -> 293
    //   82: aload 11
    //   84: invokeinterface 114 1 0
    //   89: checkcast 116	com/google/android/gms/internal/zzje
    //   92: astore 10
    //   94: invokestatic 150	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   97: invokeinterface 156 1 0
    //   102: lstore 6
    //   104: lload 4
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +111 -> 219
    //   111: aload 10
    //   113: invokeinterface 159 1 0
    //   118: ifeq +101 -> 219
    //   121: aload 10
    //   123: invokeinterface 119 1 0
    //   128: checkcast 95	com/google/android/gms/internal/zzer
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +192 -> 325
    //   136: aload_1
    //   137: getfield 122	com/google/android/gms/internal/zzer:zzBo	I
    //   140: ifne +185 -> 325
    //   143: aload_1
    //   144: getfield 163	com/google/android/gms/internal/zzer:zzBt	Lcom/google/android/gms/internal/zzez;
    //   147: astore 12
    //   149: aload 12
    //   151: ifnull +174 -> 325
    //   154: aload 12
    //   156: invokeinterface 169 1 0
    //   161: iload_2
    //   162: if_icmple +163 -> 325
    //   165: aload 12
    //   167: invokeinterface 169 1 0
    //   172: istore_3
    //   173: iload_3
    //   174: istore_2
    //   175: aload 10
    //   177: astore 8
    //   179: lload 4
    //   181: invokestatic 150	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   184: invokeinterface 156 1 0
    //   189: lload 6
    //   191: lsub
    //   192: lsub
    //   193: lconst_0
    //   194: invokestatic 175	java/lang/Math:max	(JJ)J
    //   197: lstore 4
    //   199: aload_1
    //   200: astore 9
    //   202: goto -130 -> 72
    //   205: astore_1
    //   206: aload 8
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: ldc2_w 176
    //   214: lstore 4
    //   216: goto -152 -> 64
    //   219: aload 10
    //   221: lload 4
    //   223: getstatic 183	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   226: invokeinterface 186 4 0
    //   231: checkcast 95	com/google/android/gms/internal/zzer
    //   234: astore_1
    //   235: goto -103 -> 132
    //   238: astore_1
    //   239: ldc 126
    //   241: aload_1
    //   242: invokestatic 131	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: lload 4
    //   247: invokestatic 150	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   250: invokeinterface 156 1 0
    //   255: lload 6
    //   257: lsub
    //   258: lsub
    //   259: lconst_0
    //   260: invokestatic 175	java/lang/Math:max	(JJ)J
    //   263: lstore 4
    //   265: aload 9
    //   267: astore_1
    //   268: goto -69 -> 199
    //   271: astore_1
    //   272: lload 4
    //   274: invokestatic 150	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   277: invokeinterface 156 1 0
    //   282: lload 6
    //   284: lsub
    //   285: lsub
    //   286: lconst_0
    //   287: invokestatic 175	java/lang/Math:max	(JJ)J
    //   290: pop2
    //   291: aload_1
    //   292: athrow
    //   293: aload_0
    //   294: aload 8
    //   296: invokespecial 124	com/google/android/gms/internal/zzet:zza	(Lcom/google/android/gms/internal/zzje;)V
    //   299: aload 9
    //   301: ifnonnull +30 -> 331
    //   304: new 95	com/google/android/gms/internal/zzer
    //   307: dup
    //   308: iconst_1
    //   309: invokespecial 98	com/google/android/gms/internal/zzer:<init>	(I)V
    //   312: areturn
    //   313: astore_1
    //   314: goto -75 -> 239
    //   317: astore_1
    //   318: goto -79 -> 239
    //   321: astore_1
    //   322: goto -83 -> 239
    //   325: aload 9
    //   327: astore_1
    //   328: goto -149 -> 179
    //   331: aload 9
    //   333: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	zzet
    //   0	334	1	paramList	List<zzje<zzer>>
    //   34	141	2	i	int
    //   172	2	3	j	int
    //   62	211	4	l1	long
    //   102	181	6	l2	long
    //   4	291	8	localObject	Object
    //   39	293	9	localList	List<zzje<zzer>>
    //   92	128	10	localzzje	zzje
    //   70	13	11	localIterator	Iterator
    //   147	19	12	localzzez	zzez
    // Exception table:
    //   from	to	target	type
    //   9	28	205	finally
    //   30	33	205	finally
    //   206	209	205	finally
    //   111	132	238	java/lang/InterruptedException
    //   136	149	238	java/lang/InterruptedException
    //   154	173	238	java/lang/InterruptedException
    //   219	235	238	java/lang/InterruptedException
    //   111	132	271	finally
    //   136	149	271	finally
    //   154	173	271	finally
    //   219	235	271	finally
    //   239	245	271	finally
    //   111	132	313	java/util/concurrent/TimeoutException
    //   136	149	313	java/util/concurrent/TimeoutException
    //   154	173	313	java/util/concurrent/TimeoutException
    //   219	235	313	java/util/concurrent/TimeoutException
    //   111	132	317	java/util/concurrent/ExecutionException
    //   136	149	317	java/util/concurrent/ExecutionException
    //   154	173	317	java/util/concurrent/ExecutionException
    //   219	235	317	java/util/concurrent/ExecutionException
    //   111	132	321	android/os/RemoteException
    //   136	149	321	android/os/RemoteException
    //   154	173	321	android/os/RemoteException
    //   219	235	321	android/os/RemoteException
  }
  
  public void cancel()
  {
    synchronized (this.zzpK)
    {
      this.zzBy = true;
      Iterator localIterator = this.zzBz.values().iterator();
      if (localIterator.hasNext()) {
        ((zzeq)localIterator.next()).cancel();
      }
    }
  }
  
  public zzer zzc(List<zzem> paramList)
  {
    zzb.zzaF("Starting mediation.");
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzem localzzem = (zzem)paramList.next();
      zzb.zzaG("Trying mediation network: " + localzzem.zzAF);
      Iterator localIterator = localzzem.zzAG.iterator();
      while (localIterator.hasNext())
      {
        final Object localObject = (String)localIterator.next();
        localObject = new zzeq(this.mContext, (String)localObject, this.zzpd, this.zzBf, localzzem, this.zzBu.zzGq, this.zzBu.zzqV, this.zzBu.zzqR, this.zzrF, this.zzBu.zzrj, this.zzBu.zzrl);
        zzje localzzje = zzio.zza(localExecutorService, new Callable()
        {
          public zzer zzet()
            throws Exception
          {
            synchronized (zzet.zza(zzet.this))
            {
              if (zzet.zzb(zzet.this)) {
                return null;
              }
              return localObject.zza(zzet.zzc(zzet.this), zzet.zzd(zzet.this));
            }
          }
        });
        this.zzBz.put(localzzje, localObject);
        localArrayList.add(localzzje);
      }
    }
    switch (this.zzBx)
    {
    default: 
      return zzd(localArrayList);
    }
    return zze(localArrayList);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */