package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzbl<T>
{
  private final Map<T, zzcf<T>> zzauU = new HashMap();
  
  public void zza(zzce paramzzce, zzlx.zzb<Status> paramzzb, T paramT)
    throws RemoteException
  {
    synchronized (this.zzauU)
    {
      zzcf localzzcf = (zzcf)this.zzauU.remove(paramT);
      if (localzzcf == null)
      {
        paramzzb.zzr(new Status(4002));
        return;
      }
      localzzcf.clear();
      ((zzbb)paramzzce.zzqs()).zza(new zzb(this.zzauU, paramT, paramzzb), new RemoveListenerRequest(localzzcf));
      return;
    }
  }
  
  public void zza(zzce paramzzce, zzlx.zzb<Status> paramzzb, T paramT, zzcf<T> paramzzcf)
    throws RemoteException
  {
    synchronized (this.zzauU)
    {
      if (this.zzauU.get(paramT) != null)
      {
        paramzzb.zzr(new Status(4001));
        return;
      }
      this.zzauU.put(paramT, paramzzcf);
    }
  }
  
  public void zzb(zzce paramzzce)
  {
    synchronized (this.zzauU)
    {
      zzcd.zzo localzzo = new zzcd.zzo();
      Iterator localIterator = this.zzauU.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzcf localzzcf = (zzcf)localEntry.getValue();
          if (localzzcf == null) {
            continue;
          }
          localzzcf.clear();
          boolean bool = paramzzce.isConnected();
          if (!bool) {
            continue;
          }
          try
          {
            ((zzbb)paramzzce.zzqs()).zza(localzzo, new RemoveListenerRequest(localzzcf));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "disconnect: removed: " + localEntry.getKey() + "/" + localzzcf);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableClient", "disconnect: Didn't remove: " + localEntry.getKey() + "/" + localzzcf);
          }
        }
      }
    }
    this.zzauU.clear();
  }
  
  public void zzes(IBinder paramIBinder)
  {
    synchronized (this.zzauU)
    {
      paramIBinder = zzbb.zza.zzer(paramIBinder);
      zzcd.zzo localzzo = new zzcd.zzo();
      Iterator localIterator = this.zzauU.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzcf localzzcf = (zzcf)localEntry.getValue();
          try
          {
            paramIBinder.zza(localzzo, new AddListenerRequest(localzzcf));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "onPostInitHandler: added: " + localEntry.getKey() + "/" + localzzcf);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("WearableClient", "onPostInitHandler: Didn't add: " + localEntry.getKey() + "/" + localzzcf);
          }
        }
      }
    }
  }
  
  private static class zza<T>
    extends zzcd.zzb<Status>
  {
    private WeakReference<Map<T, zzcf<T>>> zzbon;
    private WeakReference<T> zzboo;
    
    zza(Map<T, zzcf<T>> paramMap, T paramT, zzlx.zzb<Status> paramzzb)
    {
      super();
      this.zzbon = new WeakReference(paramMap);
      this.zzboo = new WeakReference(paramT);
    }
    
    public void zza(Status paramStatus)
    {
      Map localMap = (Map)this.zzbon.get();
      Object localObject = this.zzboo.get();
      if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject != null)) {}
      try
      {
        localObject = (zzcf)localMap.remove(localObject);
        if (localObject != null) {
          ((zzcf)localObject).clear();
        }
        zzX(paramStatus);
        return;
      }
      finally {}
    }
  }
  
  private static class zzb<T>
    extends zzcd.zzb<Status>
  {
    private WeakReference<Map<T, zzcf<T>>> zzbon;
    private WeakReference<T> zzboo;
    
    zzb(Map<T, zzcf<T>> paramMap, T paramT, zzlx.zzb<Status> paramzzb)
    {
      super();
      this.zzbon = new WeakReference(paramMap);
      this.zzboo = new WeakReference(paramT);
    }
    
    public void zza(Status paramStatus)
    {
      Map localMap = (Map)this.zzbon.get();
      Object localObject = this.zzboo.get();
      if ((paramStatus.getStatus().getStatusCode() == 4002) && (localMap != null) && (localObject != null)) {}
      try
      {
        localObject = (zzcf)localMap.remove(localObject);
        if (localObject != null) {
          ((zzcf)localObject).clear();
        }
        zzX(paramStatus);
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */