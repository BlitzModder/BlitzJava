package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzly;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzly<BatchResult>
{
  private int zzaes;
  private boolean zzaet;
  private boolean zzaeu;
  private final PendingResult<?>[] zzaev;
  private final Object zzpK = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.zzaes = paramList.size();
    this.zzaev = new PendingResult[this.zzaes];
    int i = 0;
    while (i < paramList.size())
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      this.zzaev[i] = paramGoogleApiClient;
      paramGoogleApiClient.zza(new PendingResult.zza()
      {
        public void zzu(Status paramAnonymousStatus)
        {
          for (;;)
          {
            synchronized (Batch.zza(Batch.this))
            {
              if (Batch.this.isCanceled()) {
                return;
              }
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.zza(Batch.this, true);
                Batch.zzb(Batch.this);
                if (Batch.zzc(Batch.this) == 0)
                {
                  if (!Batch.zzd(Batch.this)) {
                    break;
                  }
                  Batch.zze(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess()) {
              Batch.zzb(Batch.this, true);
            }
          }
          if (Batch.zzf(Batch.this)) {}
          for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.zzaeX)
          {
            Batch.this.zzb(new BatchResult(paramAnonymousStatus, Batch.zzg(Batch.this)));
            break;
          }
        }
      });
      i += 1;
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzaev;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zzaev);
  }
  
  public static final class Builder
  {
    private GoogleApiClient zzYC;
    private List<PendingResult<?>> zzaex = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.zzYC = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zzaex.size());
      this.zzaex.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.zzaex, this.zzYC, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/api/Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */