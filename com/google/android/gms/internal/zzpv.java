package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.List;

public class zzpv
  implements HistoryApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final DataSet paramDataSet, final boolean paramBoolean)
  {
    zzx.zzb(paramDataSet, "Must set the data set");
    if (!paramDataSet.getDataPoints().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Cannot use an empty data set");
      zzx.zzb(paramDataSet.getDataSource().zztK(), "Must set the app package name for the data source");
      paramGoogleApiClient.zza(new zzou.zzc(paramGoogleApiClient)
      {
        protected void zza(zzou paramAnonymouszzou)
          throws RemoteException
        {
          zzqa localzzqa = new zzqa(this);
          ((zzpf)paramAnonymouszzou.zzqs()).zza(new DataInsertRequest(paramDataSet, localzzqa, paramBoolean));
        }
      });
    }
  }
  
  public PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, final DataDeleteRequest paramDataDeleteRequest)
  {
    paramGoogleApiClient.zza(new zzou.zzc(paramGoogleApiClient)
    {
      protected void zza(zzou paramAnonymouszzou)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpf)paramAnonymouszzou.zzqs()).zza(new DataDeleteRequest(paramDataDeleteRequest, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet)
  {
    return zza(paramGoogleApiClient, paramDataSet, false);
  }
  
  public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zza(new zzou.zza(paramGoogleApiClient)
    {
      protected DailyTotalResult zzM(Status paramAnonymousStatus)
      {
        return DailyTotalResult.zza(paramAnonymousStatus, paramDataType);
      }
      
      protected void zza(zzou paramAnonymouszzou)
        throws RemoteException
      {
        DailyTotalRequest localDailyTotalRequest = new DailyTotalRequest(new zzoz.zza()
        {
          public void zza(DailyTotalResult paramAnonymous2DailyTotalResult)
            throws RemoteException
          {
            zzpv.4.this.zzb(paramAnonymous2DailyTotalResult);
          }
        }, paramDataType);
        ((zzpf)paramAnonymouszzou.zzqs()).zza(localDailyTotalRequest);
      }
    });
  }
  
  public PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, final DataReadRequest paramDataReadRequest)
  {
    paramGoogleApiClient.zza(new zzou.zza(paramGoogleApiClient)
    {
      protected DataReadResult zzL(Status paramAnonymousStatus)
      {
        return DataReadResult.zza(paramAnonymousStatus, paramDataReadRequest);
      }
      
      protected void zza(zzou paramAnonymouszzou)
        throws RemoteException
      {
        zzpv.zza localzza = new zzpv.zza(this, null);
        ((zzpf)paramAnonymouszzou.zzqs()).zza(new DataReadRequest(paramDataReadRequest, localzza));
      }
    });
  }
  
  private static class zza
    extends zzpa.zza
  {
    private final zzlx.zzb<DataReadResult> zzakL;
    private int zzaxI = 0;
    private DataReadResult zzaxJ = null;
    
    private zza(zzlx.zzb<DataReadResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    /* Error */
    public void zza(DataReadResult paramDataReadResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 34
      //   4: iconst_2
      //   5: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   8: ifeq +31 -> 39
      //   11: ldc 34
      //   13: new 42	java/lang/StringBuilder
      //   16: dup
      //   17: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   20: ldc 45
      //   22: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: aload_0
      //   26: getfield 21	com/google/android/gms/internal/zzpv$zza:zzaxI	I
      //   29: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   32: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   35: invokestatic 60	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   38: pop
      //   39: aload_0
      //   40: getfield 23	com/google/android/gms/internal/zzpv$zza:zzaxJ	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   43: ifnonnull +48 -> 91
      //   46: aload_0
      //   47: aload_1
      //   48: putfield 23	com/google/android/gms/internal/zzpv$zza:zzaxJ	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   51: aload_0
      //   52: aload_0
      //   53: getfield 21	com/google/android/gms/internal/zzpv$zza:zzaxI	I
      //   56: iconst_1
      //   57: iadd
      //   58: putfield 21	com/google/android/gms/internal/zzpv$zza:zzaxI	I
      //   61: aload_0
      //   62: getfield 21	com/google/android/gms/internal/zzpv$zza:zzaxI	I
      //   65: aload_0
      //   66: getfield 23	com/google/android/gms/internal/zzpv$zza:zzaxJ	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   69: invokevirtual 66	com/google/android/gms/fitness/result/DataReadResult:zzuH	()I
      //   72: if_icmpne +16 -> 88
      //   75: aload_0
      //   76: getfield 25	com/google/android/gms/internal/zzpv$zza:zzakL	Lcom/google/android/gms/internal/zzlx$zzb;
      //   79: aload_0
      //   80: getfield 23	com/google/android/gms/internal/zzpv$zza:zzaxJ	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   83: invokeinterface 72 2 0
      //   88: aload_0
      //   89: monitorexit
      //   90: return
      //   91: aload_0
      //   92: getfield 23	com/google/android/gms/internal/zzpv$zza:zzaxJ	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   95: aload_1
      //   96: invokevirtual 75	com/google/android/gms/fitness/result/DataReadResult:zzb	(Lcom/google/android/gms/fitness/result/DataReadResult;)V
      //   99: goto -48 -> 51
      //   102: astore_1
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_1
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	zza
      //   0	107	1	paramDataReadResult	DataReadResult
      // Exception table:
      //   from	to	target	type
      //   2	39	102	finally
      //   39	51	102	finally
      //   51	88	102	finally
      //   88	90	102	finally
      //   91	99	102	finally
      //   103	105	102	finally
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */