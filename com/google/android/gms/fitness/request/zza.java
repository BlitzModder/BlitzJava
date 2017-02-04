package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza
  extends zzn.zza
{
  private final BleScanCallback zzaye;
  
  private zza(BleScanCallback paramBleScanCallback)
  {
    this.zzaye = ((BleScanCallback)zzx.zzy(paramBleScanCallback));
  }
  
  public void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    this.zzaye.onDeviceFound(paramBleDevice);
  }
  
  public void onScanStopped()
    throws RemoteException
  {
    this.zzaye.onScanStopped();
  }
  
  public static class zza
  {
    private static final zza zzayf = new zza();
    private final Map<BleScanCallback, zza> zzayg = new HashMap();
    
    public static zza zzug()
    {
      return zzayf;
    }
    
    public zza zza(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.zzayg)
      {
        zza localzza2 = (zza)this.zzayg.get(paramBleScanCallback);
        zza localzza1 = localzza2;
        if (localzza2 == null)
        {
          localzza1 = new zza(paramBleScanCallback, null);
          this.zzayg.put(paramBleScanCallback, localzza1);
        }
        return localzza1;
      }
    }
    
    public zza zzb(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.zzayg)
      {
        zza localzza = (zza)this.zzayg.get(paramBleScanCallback);
        if (localzza != null) {
          return localzza;
        }
        paramBleScanCallback = new zza(paramBleScanCallback, null);
        return paramBleScanCallback;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */