package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

abstract class zza
{
  public static final int RESULT_ERROR = 2;
  
  protected static abstract class zza
  {
    protected final Intent mIntent;
    
    public zza(String paramString)
    {
      this.mIntent = new Intent(paramString);
      this.mIntent.setPackage("com.google.android.gms");
    }
    
    protected Intent zzaO(Context paramContext)
      throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
      GoogleApiAvailability.getInstance().zzai(paramContext);
      return this.mIntent;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/ui/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */