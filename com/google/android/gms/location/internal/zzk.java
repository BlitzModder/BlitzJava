package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzc.zza;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzk
{
  private final Context mContext;
  private final zzp<zzi> zzaLF;
  private ContentProviderClient zzaLS = null;
  private boolean zzaLT = false;
  private Map<LocationCallback, zza> zzaLU = new HashMap();
  private Map<LocationListener, zzc> zzauU = new HashMap();
  
  public zzk(Context paramContext, zzp<zzi> paramzzp)
  {
    this.mContext = paramContext;
    this.zzaLF = paramzzp;
  }
  
  private zza zza(LocationCallback paramLocationCallback, Looper paramLooper)
  {
    synchronized (this.zzaLU)
    {
      zza localzza2 = (zza)this.zzaLU.get(paramLocationCallback);
      zza localzza1 = localzza2;
      if (localzza2 == null) {
        localzza1 = new zza(paramLocationCallback, paramLooper);
      }
      this.zzaLU.put(paramLocationCallback, localzza1);
      return localzza1;
    }
  }
  
  private zzc zza(LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (this.zzauU)
    {
      zzc localzzc2 = (zzc)this.zzauU.get(paramLocationListener);
      zzc localzzc1 = localzzc2;
      if (localzzc2 == null) {
        localzzc1 = new zzc(paramLocationListener, paramLooper);
      }
      this.zzauU.put(paramLocationListener, localzzc1);
      return localzzc1;
    }
  }
  
  public Location getLastLocation()
  {
    this.zzaLF.zzqr();
    try
    {
      Location localLocation = ((zzi)this.zzaLF.zzqs()).zzdS(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    Object localObject3;
    try
    {
      synchronized (this.zzauU)
      {
        Iterator localIterator1 = this.zzauU.values().iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (zzc)localIterator1.next();
          if (localObject3 != null) {
            ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza((zzd)localObject3, null));
          }
        }
      }
      this.zzauU.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
    synchronized (this.zzaLU)
    {
      Iterator localIterator2 = this.zzaLU.values().iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (zza)localIterator2.next();
        if (localObject3 != null) {
          ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza((zzc)localObject3, null));
        }
      }
    }
    this.zzaLU.clear();
  }
  
  public void zza(PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zzb(paramPendingIntent, paramzzg));
  }
  
  public void zza(LocationCallback paramLocationCallback, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    zzx.zzb(paramLocationCallback, "Invalid null callback");
    synchronized (this.zzaLU)
    {
      paramLocationCallback = (zza)this.zzaLU.remove(paramLocationCallback);
      if (paramLocationCallback != null)
      {
        paramLocationCallback.release();
        ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(paramLocationCallback, paramzzg));
      }
      return;
    }
  }
  
  public void zza(LocationListener paramLocationListener, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    zzx.zzb(paramLocationListener, "Invalid null listener");
    synchronized (this.zzauU)
    {
      paramLocationListener = (zzc)this.zzauU.remove(paramLocationListener);
      if ((this.zzaLS != null) && (this.zzauU.isEmpty()))
      {
        this.zzaLS.release();
        this.zzaLS = null;
      }
      if (paramLocationListener != null)
      {
        paramLocationListener.release();
        ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(paramLocationListener, paramzzg));
      }
      return;
    }
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(paramLocationRequest), paramPendingIntent, paramzzg));
  }
  
  public void zza(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    paramLocationListener = zza(paramLocationListener, paramLooper);
    ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(paramLocationRequest), paramLocationListener, paramzzg));
  }
  
  public void zza(LocationRequestInternal paramLocationRequestInternal, LocationCallback paramLocationCallback, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    paramLocationCallback = zza(paramLocationCallback, paramLooper);
    ((zzi)this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(paramLocationRequestInternal, paramLocationCallback, paramzzg));
  }
  
  public void zza(zzg paramzzg)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    ((zzi)this.zzaLF.zzqs()).zza(paramzzg);
  }
  
  public void zzai(boolean paramBoolean)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    ((zzi)this.zzaLF.zzqs()).zzai(paramBoolean);
    this.zzaLT = paramBoolean;
  }
  
  public void zzc(Location paramLocation)
    throws RemoteException
  {
    this.zzaLF.zzqr();
    ((zzi)this.zzaLF.zzqs()).zzc(paramLocation);
  }
  
  public LocationAvailability zzyc()
  {
    this.zzaLF.zzqr();
    try
    {
      LocationAvailability localLocationAvailability = ((zzi)this.zzaLF.zzqs()).zzdT(this.mContext.getPackageName());
      return localLocationAvailability;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzyd()
  {
    if (this.zzaLT) {}
    try
    {
      zzai(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  private static class zza
    extends zzc.zza
  {
    private Handler zzaLV;
    
    zza(final LocationCallback paramLocationCallback, Looper paramLooper)
    {
      Looper localLooper = paramLooper;
      if (paramLooper == null)
      {
        localLooper = Looper.myLooper();
        if (localLooper == null) {
          break label45;
        }
      }
      label45:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
        this.zzaLV = new Handler(localLooper)
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            case 0: 
              paramLocationCallback.onLocationResult((LocationResult)paramAnonymousMessage.obj);
              return;
            }
            paramLocationCallback.onLocationAvailability((LocationAvailability)paramAnonymousMessage.obj);
          }
        };
        return;
      }
    }
    
    private void zzb(int paramInt, Object paramObject)
    {
      if (this.zzaLV == null)
      {
        Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      this.zzaLV.sendMessage(localMessage);
    }
    
    public void onLocationAvailability(LocationAvailability paramLocationAvailability)
    {
      zzb(1, paramLocationAvailability);
    }
    
    public void onLocationResult(LocationResult paramLocationResult)
    {
      zzb(0, paramLocationResult);
    }
    
    public void release()
    {
      this.zzaLV = null;
    }
  }
  
  private static class zzb
    extends Handler
  {
    private final LocationListener zzaLX;
    
    public zzb(LocationListener paramLocationListener)
    {
      this.zzaLX = paramLocationListener;
    }
    
    public zzb(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.zzaLX = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      paramMessage = new Location((Location)paramMessage.obj);
      this.zzaLX.onLocationChanged(paramMessage);
    }
  }
  
  private static class zzc
    extends zzd.zza
  {
    private Handler zzaLV;
    
    zzc(LocationListener paramLocationListener, Looper paramLooper)
    {
      boolean bool;
      if (paramLooper == null)
      {
        if (Looper.myLooper() != null)
        {
          bool = true;
          zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
        }
      }
      else {
        if (paramLooper != null) {
          break label46;
        }
      }
      label46:
      for (paramLocationListener = new zzk.zzb(paramLocationListener);; paramLocationListener = new zzk.zzb(paramLocationListener, paramLooper))
      {
        this.zzaLV = paramLocationListener;
        return;
        bool = false;
        break;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.zzaLV == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.zzaLV.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.zzaLV = null;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */