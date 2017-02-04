package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class PlacesOptions
  implements Api.ApiOptions.Optional
{
  public final String zzaNb;
  public final int zzaNc;
  
  private PlacesOptions(Builder paramBuilder)
  {
    this.zzaNb = Builder.zza(paramBuilder);
    this.zzaNc = Builder.zzb(paramBuilder);
  }
  
  public static class Builder
  {
    private int zzaNc = 0;
    private String zzaNd;
    
    public PlacesOptions build()
    {
      return new PlacesOptions(this, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlacesOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */