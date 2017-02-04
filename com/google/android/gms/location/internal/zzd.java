package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.zza;

public class zzd
  implements FusedLocationProviderApi
{
  public PendingResult<Status> flushLocations(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(new zzd.zzb(this));
      }
    });
  }
  
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzg(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzg(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.zzyc();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramPendingIntent, localzzb);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationCallback paramLocationCallback)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramLocationCallback, localzzb);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramLocationListener, localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramLocationRequest, paramPendingIntent, localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationCallback paramLocationCallback, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(LocationRequestInternal.zzb(paramLocationRequest), paramLocationCallback, paramLooper, localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramLocationRequest, paramLocationListener, null, localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzd.zzb localzzb = new zzd.zzb(this);
        paramAnonymouszzl.zza(paramLocationRequest, paramLocationListener, paramLooper, localzzb);
      }
    });
  }
  
  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zzc(paramLocation);
        zzb(Status.zzaeX);
      }
    });
  }
  
  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zzai(paramBoolean);
        zzb(Status.zzaeX);
      }
    });
  }
  
  private static abstract class zza
    extends LocationServices.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static class zzb
    extends zzg.zza
  {
    private final zzlx.zzb<Status> zzakL;
    
    public zzb(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(FusedLocationProviderResult paramFusedLocationProviderResult)
    {
      this.zzakL.zzr(paramFusedLocationProviderResult.getStatus());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */