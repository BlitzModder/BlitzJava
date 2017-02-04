package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class zzl
  extends zzb
{
  private final zzk zzaLY = new zzk(paramContext, this.zzaLF);
  
  public zzl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, zzf.zzas(paramContext));
  }
  
  public zzl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzf);
  }
  
  public void disconnect()
  {
    synchronized (this.zzaLY)
    {
      boolean bool = isConnected();
      if (bool) {}
      try
      {
        this.zzaLY.removeAllListeners();
        this.zzaLY.zzyd();
        super.disconnect();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
    }
  }
  
  public Location getLastLocation()
  {
    return this.zzaLY.getLastLocation();
  }
  
  public void zza(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzqr();
    zzx.zzy(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "detectionIntervalMillis must be >= 0");
      ((zzi)zzqs()).zza(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void zza(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzqr();
    zzx.zzy(paramPendingIntent);
    ((zzi)zzqs()).zza(paramPendingIntent);
  }
  
  public void zza(PendingIntent paramPendingIntent, zzlx.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzqr();
    zzx.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzx.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzb(paramzzb);
    ((zzi)zzqs()).zza(paramPendingIntent, paramzzb, getContext().getPackageName());
  }
  
  public void zza(PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLY.zza(paramPendingIntent, paramzzg);
  }
  
  public void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzlx.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzqr();
    zzx.zzb(paramGeofencingRequest, "geofencingRequest can't be null.");
    zzx.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzx.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zza(paramzzb);
    ((zzi)zzqs()).zza(paramGeofencingRequest, paramPendingIntent, paramzzb);
  }
  
  public void zza(LocationCallback paramLocationCallback, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLY.zza(paramLocationCallback, paramzzg);
  }
  
  public void zza(LocationListener paramLocationListener, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLY.zza(paramLocationListener, paramzzg);
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaLY.zza(paramLocationRequest, paramPendingIntent, paramzzg);
  }
  
  public void zza(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    synchronized (this.zzaLY)
    {
      this.zzaLY.zza(paramLocationRequest, paramLocationListener, paramLooper, paramzzg);
      return;
    }
  }
  
  public void zza(LocationSettingsRequest paramLocationSettingsRequest, zzlx.zzb<LocationSettingsResult> paramzzb, String paramString)
    throws RemoteException
  {
    boolean bool2 = true;
    zzqr();
    if (paramLocationSettingsRequest != null)
    {
      bool1 = true;
      zzx.zzb(bool1, "locationSettingsRequest can't be null nor empty.");
      if (paramzzb == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "listener can't be null.");
      paramzzb = new zzc(paramzzb);
      ((zzi)zzqs()).zza(paramLocationSettingsRequest, paramzzb, paramString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void zza(LocationRequestInternal paramLocationRequestInternal, LocationCallback paramLocationCallback, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    synchronized (this.zzaLY)
    {
      this.zzaLY.zza(paramLocationRequestInternal, paramLocationCallback, paramLooper, paramzzg);
      return;
    }
  }
  
  public void zza(zzg paramzzg)
    throws RemoteException
  {
    this.zzaLY.zza(paramzzg);
  }
  
  public void zza(List<String> paramList, zzlx.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzqr();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "geofenceRequestIds can't be null nor empty.");
      zzx.zzb(paramzzb, "ResultHolder not provided.");
      paramList = (String[])paramList.toArray(new String[0]);
      paramzzb = new zzb(paramzzb);
      ((zzi)zzqs()).zza(paramList, paramzzb, getContext().getPackageName());
      return;
    }
  }
  
  public void zzai(boolean paramBoolean)
    throws RemoteException
  {
    this.zzaLY.zzai(paramBoolean);
  }
  
  public void zzc(Location paramLocation)
    throws RemoteException
  {
    this.zzaLY.zzc(paramLocation);
  }
  
  public LocationAvailability zzyc()
  {
    return this.zzaLY.zzyc();
  }
  
  private static final class zza
    extends zzh.zza
  {
    private zzlx.zzb<Status> zzaLZ;
    
    public zza(zzlx.zzb<Status> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      if (this.zzaLZ == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      paramArrayOfString = LocationStatusCodes.zzhq(LocationStatusCodes.zzhp(paramInt));
      this.zzaLZ.zzr(paramArrayOfString);
      this.zzaLZ = null;
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
  }
  
  private static final class zzb
    extends zzh.zza
  {
    private zzlx.zzb<Status> zzaLZ;
    
    public zzb(zzlx.zzb<Status> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    private void zzht(int paramInt)
    {
      if (this.zzaLZ == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
        return;
      }
      Status localStatus = LocationStatusCodes.zzhq(LocationStatusCodes.zzhp(paramInt));
      this.zzaLZ.zzr(localStatus);
      this.zzaLZ = null;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      zzht(paramInt);
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      zzht(paramInt);
    }
  }
  
  private static final class zzc
    extends zzj.zza
  {
    private zzlx.zzb<LocationSettingsResult> zzaLZ;
    
    public zzc(zzlx.zzb<LocationSettingsResult> paramzzb)
    {
      if (paramzzb != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "listener can't be null.");
        this.zzaLZ = paramzzb;
        return;
      }
    }
    
    public void zza(LocationSettingsResult paramLocationSettingsResult)
      throws RemoteException
    {
      this.zzaLZ.zzr(paramLocationSettingsResult);
      this.zzaLZ = null;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */