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
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zze
  extends zzj<zzg>
{
  private final PlacesParams zzaNx;
  private final Locale zzaNy = Locale.getDefault();
  
  public zze(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 65, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzf.getAccount() != null) {
      paramContext = paramzzf.getAccount().name;
    }
    this.zzaNx = new PlacesParams(paramString, this.zzaNy, paramContext, paramPlacesOptions.zzaNb, paramPlacesOptions.zzaNc);
  }
  
  public void zza(com.google.android.gms.location.places.zzf paramzzf, String paramString)
    throws RemoteException
  {
    zzx.zzb(paramString, "placeId cannot be null");
    ((zzg)zzqs()).zza(paramString, this.zzaNx, paramzzf);
  }
  
  public void zza(com.google.android.gms.location.places.zzf paramzzf, String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    boolean bool2 = true;
    zzx.zzb(paramString, "fifeUrl cannot be null");
    if (paramInt1 > 0)
    {
      bool1 = true;
      zzx.zzb(bool1, "width should be > 0");
      if (paramInt1 <= 0) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "height should be > 0");
      ((zzg)zzqs()).zza(paramString, paramInt1, paramInt2, paramInt3, this.zzaNx, paramzzf);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void zza(zzl paramzzl, AddPlaceRequest paramAddPlaceRequest)
    throws RemoteException
  {
    zzx.zzb(paramAddPlaceRequest, "userAddedPlace == null");
    ((zzg)zzqs()).zza(paramAddPlaceRequest, this.zzaNx, paramzzl);
  }
  
  public void zza(zzl paramzzl, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter)
    throws RemoteException
  {
    zzx.zzb(paramString, "query == null");
    zzx.zzb(paramzzl, "callback == null");
    if (paramAutocompleteFilter == null) {
      paramAutocompleteFilter = AutocompleteFilter.create(null);
    }
    for (;;)
    {
      ((zzg)zzqs()).zza(paramString, paramLatLngBounds, paramAutocompleteFilter, this.zzaNx, paramzzl);
      return;
    }
  }
  
  public void zza(zzl paramzzl, List<String> paramList)
    throws RemoteException
  {
    ((zzg)zzqs()).zzb(paramList, this.zzaNx, paramzzl);
  }
  
  protected zzg zzcl(IBinder paramIBinder)
  {
    return zzg.zza.zzcn(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.location.places.GeoDataApi";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlacesService";
  }
  
  public static class zza
    extends Api.zza<zze, PlacesOptions>
  {
    private final String zzaNz;
    
    public zza(String paramString)
    {
      this.zzaNz = paramString;
    }
    
    public zze zza(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
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
        return new zze(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener, str, paramPlacesOptions);
        str = paramContext.getPackageName();
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */