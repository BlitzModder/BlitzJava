package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.zzp;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker
  extends zza
{
  public static final int RESULT_ERROR = 2;
  
  public static String getAttributions(Intent paramIntent)
  {
    return paramIntent.getStringExtra("third_party_attributions");
  }
  
  public static LatLngBounds getLatLngBounds(Intent paramIntent)
  {
    return (LatLngBounds)zzc.zza(paramIntent, "final_latlng_bounds", LatLngBounds.CREATOR);
  }
  
  public static Place getPlace(Intent paramIntent, Context paramContext)
  {
    zzx.zzb(paramContext, "context must not be null");
    paramIntent = (PlaceImpl)zzc.zza(paramIntent, "selected_place", PlaceImpl.CREATOR);
    paramIntent.zza(zzp.zzaN(paramContext));
    return paramIntent;
  }
  
  public static class IntentBuilder
    extends zza.zza
  {
    public IntentBuilder()
    {
      super();
      this.mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
    
    public Intent build(Activity paramActivity)
      throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
      Resources.Theme localTheme = paramActivity.getTheme();
      TypedValue localTypedValue1 = new TypedValue();
      TypedValue localTypedValue2 = new TypedValue();
      if ((localTheme.resolveAttribute(16843827, localTypedValue1, true)) && (!this.mIntent.hasExtra("primary_color"))) {
        this.mIntent.putExtra("primary_color", localTypedValue1.data);
      }
      if ((localTheme.resolveAttribute(16843828, localTypedValue2, true)) && (!this.mIntent.hasExtra("primary_color_dark"))) {
        this.mIntent.putExtra("primary_color_dark", localTypedValue2.data);
      }
      return super.zzaO(paramActivity);
    }
    
    public IntentBuilder setLatLngBounds(LatLngBounds paramLatLngBounds)
    {
      zzx.zzy(paramLatLngBounds);
      zzc.zza(paramLatLngBounds, this.mIntent, "latlng_bounds");
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/ui/PlacePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */