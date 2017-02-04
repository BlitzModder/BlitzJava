package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzpt
  implements BleApi
{
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final BleDevice paramBleDevice)
  {
    paramGoogleApiClient.zzb(new zzos.zzc(paramGoogleApiClient)
    {
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new ClaimBleDeviceRequest(paramBleDevice.getAddress(), paramBleDevice, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new zzos.zzc(paramGoogleApiClient)
    {
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new ClaimBleDeviceRequest(paramString, null, localzzqa));
      }
    });
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzos.zza(paramGoogleApiClient)
    {
      protected BleDevicesResult zzJ(Status paramAnonymousStatus)
      {
        return BleDevicesResult.zzR(paramAnonymousStatus);
      }
      
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzpt.zza localzza = new zzpt.zza(this, null);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new ListClaimedBleDevicesRequest(localzza));
      }
    });
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, final StartBleScanRequest paramStartBleScanRequest)
  {
    paramGoogleApiClient.zza(new zzos.zzc(paramGoogleApiClient)
    {
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new StartBleScanRequest(paramStartBleScanRequest, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, final BleScanCallback paramBleScanCallback)
  {
    paramGoogleApiClient.zza(new zzos.zzc(paramGoogleApiClient)
    {
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new StopBleScanRequest(paramBleScanCallback, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new zzos.zzc(paramGoogleApiClient)
    {
      protected void zza(zzos paramAnonymouszzos)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpd)paramAnonymouszzos.zzqs()).zza(new UnclaimBleDeviceRequest(paramString, localzzqa));
      }
    });
  }
  
  private static class zza
    extends zzqc.zza
  {
    private final zzlx.zzb<BleDevicesResult> zzakL;
    
    private zza(zzlx.zzb<BleDevicesResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(BleDevicesResult paramBleDevicesResult)
    {
      this.zzakL.zzr(paramBleDevicesResult);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */