package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.zza;
import com.google.android.gms.clearcut.zza.zzb;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlt
  implements zzb
{
  private static final Object zzadD = new Object();
  private static final zze zzadE = new zze(null);
  private static final long zzadF = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
  private GoogleApiClient zzYC = null;
  private final zza zzadG;
  private final Object zzadH = new Object();
  private long zzadI = 0L;
  private final long zzadJ;
  private ScheduledFuture<?> zzadK = null;
  private final Runnable zzadL = new Runnable()
  {
    public void run()
    {
      synchronized (zzlt.zza(zzlt.this))
      {
        if ((zzlt.zzb(zzlt.this) <= zzlt.zzc(zzlt.this).elapsedRealtime()) && (zzlt.zzd(zzlt.this) != null))
        {
          Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
          zzlt.zzd(zzlt.this).disconnect();
          zzlt.zza(zzlt.this, null);
        }
        return;
      }
    }
  };
  private final zznl zzqD;
  
  public zzlt()
  {
    this(new zzno(), zzadF, new zzb());
  }
  
  public zzlt(zznl paramzznl, long paramLong, zza paramzza)
  {
    this.zzqD = paramzznl;
    this.zzadJ = paramLong;
    this.zzadG = paramzza;
  }
  
  private static void zza(LogEventParcelable paramLogEventParcelable)
  {
    if ((paramLogEventParcelable.zzadB != null) && (paramLogEventParcelable.zzadA.zzbqD.length == 0)) {
      paramLogEventParcelable.zzadA.zzbqD = paramLogEventParcelable.zzadB.zzon();
    }
    if ((paramLogEventParcelable.zzadC != null) && (paramLogEventParcelable.zzadA.zzbqK.length == 0)) {
      paramLogEventParcelable.zzadA.zzbqK = paramLogEventParcelable.zzadC.zzon();
    }
    paramLogEventParcelable.zzady = zztk.toByteArray(paramLogEventParcelable.zzadA);
  }
  
  private zzd zzb(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable)
  {
    zzadE.zzop();
    paramGoogleApiClient = new zzd(paramLogEventParcelable, paramGoogleApiClient);
    paramGoogleApiClient.zza(new PendingResult.zza()
    {
      public void zzu(Status paramAnonymousStatus)
      {
        zzlt.zzoo().zzoq();
      }
    });
    return paramGoogleApiClient;
  }
  
  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable)
  {
    zza(paramLogEventParcelable);
    return paramGoogleApiClient.zza(zzb(paramGoogleApiClient, paramLogEventParcelable));
  }
  
  public boolean zza(GoogleApiClient paramGoogleApiClient, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = zzadE.zza(paramLong, paramTimeUnit);
      return bool;
    }
    catch (InterruptedException paramGoogleApiClient)
    {
      Log.e("ClearcutLoggerApiImpl", "flush interrupted");
      Thread.currentThread().interrupt();
    }
    return false;
  }
  
  public static abstract interface zza {}
  
  public static class zzb
    implements zzlt.zza
  {}
  
  static abstract class zzc<R extends Result>
    extends zzlx.zza<R, zzlu>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  final class zzd
    extends zzlt.zzc<Status>
  {
    private final LogEventParcelable zzadN;
    
    zzd(LogEventParcelable paramLogEventParcelable, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzadN = paramLogEventParcelable;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
      return this.zzadN.equals(((zzd)paramObject).zzadN);
    }
    
    public String toString()
    {
      return "MethodImpl(" + this.zzadN + ")";
    }
    
    protected void zza(zzlu paramzzlu)
      throws RemoteException
    {
      zzlv.zza local1 = new zzlv.zza()
      {
        public void zzv(Status paramAnonymousStatus)
        {
          zzlt.zzd.this.zzb(paramAnonymousStatus);
        }
      };
      try
      {
        zzlt.zzb(this.zzadN);
        paramzzlu.zza(local1, this.zzadN);
        return;
      }
      catch (Throwable paramzzlu)
      {
        Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzadN.zzadB.toString() + " threw: " + paramzzlu.toString());
      }
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static final class zze
  {
    private int mSize = 0;
    
    public boolean zza(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      long l1 = System.currentTimeMillis();
      paramLong = TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit);
      for (;;)
      {
        try
        {
          if (this.mSize == 0) {
            return true;
          }
          if (paramLong <= 0L) {
            return false;
          }
        }
        finally {}
        wait(paramLong);
        long l2 = System.currentTimeMillis();
        paramLong -= l2 - l1;
      }
    }
    
    public void zzop()
    {
      try
      {
        this.mSize += 1;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void zzoq()
    {
      try
      {
        if (this.mSize == 0) {
          throw new RuntimeException("too many decrements");
        }
      }
      finally {}
      this.mSize -= 1;
      if (this.mSize == 0) {
        notifyAll();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */