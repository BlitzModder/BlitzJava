package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzpy
  implements SensorsApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final zzj paramzzj, final PendingIntent paramPendingIntent, final zza paramzza)
  {
    paramGoogleApiClient.zzb(new zzox.zzc(paramGoogleApiClient)
    {
      protected void zza(zzox paramAnonymouszzox)
        throws RemoteException
      {
        zzpy.zzc localzzc = new zzpy.zzc(this, paramzza, null);
        ((zzpi)paramAnonymouszzox.zzqs()).zza(new SensorUnregistrationRequest(paramzzj, paramPendingIntent, localzzc));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final SensorRequest paramSensorRequest, final zzj paramzzj, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zza(new zzox.zzc(paramGoogleApiClient)
    {
      protected void zza(zzox paramAnonymouszzox)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpi)paramAnonymouszzox.zzqs()).zza(new SensorRegistrationRequest(paramSensorRequest, paramzzj, paramPendingIntent, localzzqa));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, null, paramPendingIntent);
  }
  
  public PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, zzk.zza.zztQ().zza(paramOnDataPointListener), null);
  }
  
  public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient paramGoogleApiClient, final DataSourcesRequest paramDataSourcesRequest)
  {
    paramGoogleApiClient.zza(new zzox.zza(paramGoogleApiClient)
    {
      protected DataSourcesResult zzO(Status paramAnonymousStatus)
      {
        return DataSourcesResult.zzS(paramAnonymousStatus);
      }
      
      protected void zza(zzox paramAnonymouszzox)
        throws RemoteException
      {
        zzpy.zzb localzzb = new zzpy.zzb(this, null);
        ((zzpi)paramAnonymouszzox.zzqs()).zza(new DataSourcesRequest(paramDataSourcesRequest, localzzb));
      }
    });
  }
  
  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, null, paramPendingIntent, null);
  }
  
  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, final OnDataPointListener paramOnDataPointListener)
  {
    zzk localzzk = zzk.zza.zztQ().zzb(paramOnDataPointListener);
    if (localzzk == null) {
      return PendingResults.zza(Status.zzaeX, paramGoogleApiClient);
    }
    zza(paramGoogleApiClient, localzzk, null, new zza()
    {
      public void zzuf()
      {
        zzk.zza.zztQ().zzc(paramOnDataPointListener);
      }
    });
  }
  
  private static abstract interface zza
  {
    public abstract void zzuf();
  }
  
  private static class zzb
    extends zzpb.zza
  {
    private final zzlx.zzb<DataSourcesResult> zzakL;
    
    private zzb(zzlx.zzb<DataSourcesResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(DataSourcesResult paramDataSourcesResult)
    {
      this.zzakL.zzr(paramDataSourcesResult);
    }
  }
  
  private static class zzc
    extends zzpp.zza
  {
    private final zzlx.zzb<Status> zzakL;
    private final zzpy.zza zzaxW;
    
    private zzc(zzlx.zzb<Status> paramzzb, zzpy.zza paramzza)
    {
      this.zzakL = paramzzb;
      this.zzaxW = paramzza;
    }
    
    public void zzp(Status paramStatus)
    {
      if ((this.zzaxW != null) && (paramStatus.isSuccess())) {
        this.zzaxW.zzuf();
      }
      this.zzakL.zzr(paramStatus);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */