package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzqb
  implements BleApi
{
  private static final Status zzayd = new Status(5007);
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return PendingResults.zza(BleDevicesResult.zzR(zzayd), paramGoogleApiClient);
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.zza(zzayd, paramGoogleApiClient);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */