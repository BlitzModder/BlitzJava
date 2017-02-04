package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

public class PlacePhotoMetadataBuffer
  extends AbstractDataBuffer<PlacePhotoMetadata>
{
  public PlacePhotoMetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public PlacePhotoMetadata get(int paramInt)
  {
    return new zzr(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlacePhotoMetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */