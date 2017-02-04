package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.internal.service.zzc.zza;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpp;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
  private zza zzazv;
  
  public IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3)) {
        Log.d("FitnessSensorService", "Intent " + paramIntent + " received by " + getClass().getName());
      }
      return this.zzazv.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzazv = new zza(this, null);
  }
  
  public abstract List<DataSource> onFindDataSources(List<DataType> paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  protected void zzuP()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (zznx.zzrU())
    {
      ((AppOpsManager)getSystemService("appops")).checkPackage(i, "com.google.android.gms");
      return;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(i);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label67;
        }
        if (arrayOfString[i].equals("com.google.android.gms")) {
          break;
        }
        i += 1;
      }
    }
    label67:
    throw new SecurityException("Unauthorized caller");
  }
  
  private static class zza
    extends zzc.zza
  {
    private final FitnessSensorService zzazw;
    
    private zza(FitnessSensorService paramFitnessSensorService)
    {
      this.zzazw = paramFitnessSensorService;
    }
    
    public void zza(FitnessDataSourcesRequest paramFitnessDataSourcesRequest, zzpb paramzzpb)
      throws RemoteException
    {
      this.zzazw.zzuP();
      paramzzpb.zza(new DataSourcesResult(this.zzazw.onFindDataSources(paramFitnessDataSourcesRequest.getDataTypes()), Status.zzaeX));
    }
    
    public void zza(FitnessUnregistrationRequest paramFitnessUnregistrationRequest, zzpp paramzzpp)
      throws RemoteException
    {
      this.zzazw.zzuP();
      if (this.zzazw.onUnregister(paramFitnessUnregistrationRequest.getDataSource()))
      {
        paramzzpp.zzp(Status.zzaeX);
        return;
      }
      paramzzpp.zzp(new Status(13));
    }
    
    public void zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzpp paramzzpp)
      throws RemoteException
    {
      this.zzazw.zzuP();
      if (this.zzazw.onRegister(paramFitnessSensorServiceRequest))
      {
        paramzzpp.zzp(Status.zzaeX);
        return;
      }
      paramzzpp.zzp(new Status(13));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/service/FitnessSensorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */