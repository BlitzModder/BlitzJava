package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzj;
import java.util.Iterator;
import java.util.List;

class zzb
  implements SensorEventDispatcher
{
  private final zzj zzayN;
  
  zzb(zzj paramzzj)
  {
    this.zzayN = ((zzj)zzx.zzy(paramzzj));
  }
  
  public void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    paramDataPoint.zztG();
    this.zzayN.zzc(paramDataPoint);
  }
  
  public void publish(List<DataPoint> paramList)
    throws RemoteException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      publish((DataPoint)paramList.next());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/service/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */