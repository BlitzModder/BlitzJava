package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzpu
  implements ConfigApi
{
  public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient paramGoogleApiClient, final DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    paramGoogleApiClient.zzb(new zzot.zza(paramGoogleApiClient)
    {
      protected DataTypeResult zzK(Status paramAnonymousStatus)
      {
        return DataTypeResult.zzT(paramAnonymousStatus);
      }
      
      protected void zza(zzot paramAnonymouszzot)
        throws RemoteException
      {
        zzpu.zza localzza = new zzpu.zza(this, null);
        ((zzpe)paramAnonymouszzot.zzqs()).zza(new DataTypeCreateRequest(paramDataTypeCreateRequest, localzza));
      }
    });
  }
  
  public PendingResult<Status> disableFit(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzot.zzc(paramGoogleApiClient)
    {
      protected void zza(zzot paramAnonymouszzot)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpe)paramAnonymouszzot.zzqs()).zza(new DisableFitRequest(localzzqa));
      }
    });
  }
  
  public PendingResult<DataTypeResult> readDataType(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzot.zza(paramGoogleApiClient)
    {
      protected DataTypeResult zzK(Status paramAnonymousStatus)
      {
        return DataTypeResult.zzT(paramAnonymousStatus);
      }
      
      protected void zza(zzot paramAnonymouszzot)
        throws RemoteException
      {
        zzpu.zza localzza = new zzpu.zza(this, null);
        ((zzpe)paramAnonymouszzot.zzqs()).zza(new DataTypeReadRequest(paramString, localzza));
      }
    });
  }
  
  private static class zza
    extends zzpc.zza
  {
    private final zzlx.zzb<DataTypeResult> zzakL;
    
    private zza(zzlx.zzb<DataTypeResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(DataTypeResult paramDataTypeResult)
    {
      this.zzakL.zzr(paramDataTypeResult);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */