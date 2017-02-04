package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzk
  extends zzj<zzf>
{
  private final PlacesParams zzaNx;
  private final Locale zzaNy = Locale.getDefault();
  
  public zzk(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 67, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzf.getAccount() != null) {
      paramContext = paramzzf.getAccount().name;
    }
    this.zzaNx = new PlacesParams(paramString, this.zzaNy, paramContext, paramPlacesOptions.zzaNb, paramPlacesOptions.zzaNc);
  }
  
  public void zza(zzl paramzzl, PlaceFilter paramPlaceFilter)
    throws RemoteException
  {
    PlaceFilter localPlaceFilter = paramPlaceFilter;
    if (paramPlaceFilter == null) {
      localPlaceFilter = PlaceFilter.zzyr();
    }
    ((zzf)zzqs()).zza(localPlaceFilter, this.zzaNx, paramzzl);
  }
  
  public void zza(zzl paramzzl, PlaceReport paramPlaceReport)
    throws RemoteException
  {
    zzx.zzy(paramPlaceReport);
    ((zzf)zzqs()).zza(paramPlaceReport, this.zzaNx, paramzzl);
  }
  
  protected zzf zzcq(IBinder paramIBinder)
  {
    return zzf.zza.zzcm(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.location.places.PlaceDetectionApi";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
  }
  
  public static class zza
    extends Api.zza<zzk, PlacesOptions>
  {
    private final String zzaNz;
    
    public zza(String paramString)
    {
      this.zzaNz = paramString;
    }
    
    public zzk zzb(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      String str;
      if (this.zzaNz != null)
      {
        str = this.zzaNz;
        if (paramPlacesOptions != null) {
          break label58;
        }
        paramPlacesOptions = new PlacesOptions.Builder().build();
      }
      label58:
      for (;;)
      {
        return new zzk(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener, str, paramPlacesOptions);
        str = paramContext.getPackageName();
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */