package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk
  extends zzj.zza
{
  private final OnDataPointListener zzauS;
  
  private zzk(OnDataPointListener paramOnDataPointListener)
  {
    this.zzauS = ((OnDataPointListener)zzx.zzy(paramOnDataPointListener));
  }
  
  public void zzc(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.zzauS.onDataPoint(paramDataPoint);
  }
  
  public static class zza
  {
    private static final zza zzauT = new zza();
    private final Map<OnDataPointListener, zzk> zzauU = new HashMap();
    
    public static zza zztQ()
    {
      return zzauT;
    }
    
    public zzk zza(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzauU)
      {
        zzk localzzk2 = (zzk)this.zzauU.get(paramOnDataPointListener);
        zzk localzzk1 = localzzk2;
        if (localzzk2 == null)
        {
          localzzk1 = new zzk(paramOnDataPointListener, null);
          this.zzauU.put(paramOnDataPointListener, localzzk1);
        }
        return localzzk1;
      }
    }
    
    public zzk zzb(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzauU)
      {
        paramOnDataPointListener = (zzk)this.zzauU.get(paramOnDataPointListener);
        return paramOnDataPointListener;
      }
    }
    
    public zzk zzc(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzauU)
      {
        zzk localzzk = (zzk)this.zzauU.remove(paramOnDataPointListener);
        if (localzzk != null) {
          return localzzk;
        }
        paramOnDataPointListener = new zzk(paramOnDataPointListener, null);
        return paramOnDataPointListener;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */