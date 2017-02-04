package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzr
  extends zzu
  implements PlacePhotoMetadata
{
  private final String zzaOg = getString("photo_fife_url");
  
  public zzr(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public CharSequence getAttributions()
  {
    return zzI("photo_attributions", null);
  }
  
  public int getMaxHeight()
  {
    return zzz("photo_max_height", 0);
  }
  
  public int getMaxWidth()
  {
    return zzz("photo_max_width", 0);
  }
  
  public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient)
  {
    return getScaledPhoto(paramGoogleApiClient, getMaxWidth(), getMaxHeight());
  }
  
  public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return zzyN().getScaledPhoto(paramGoogleApiClient, paramInt1, paramInt2);
  }
  
  public PlacePhotoMetadata zzyN()
  {
    return new zzq(this.zzaOg, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzahw);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */