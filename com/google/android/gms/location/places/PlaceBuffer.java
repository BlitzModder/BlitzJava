package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

public class PlaceBuffer
  extends AbstractDataBuffer<Place>
  implements Result
{
  private final Context mContext;
  private final Status zzTA;
  private final String zzaMG;
  
  public PlaceBuffer(DataHolder paramDataHolder, Context paramContext)
  {
    super(paramDataHolder);
    this.mContext = paramContext;
    this.zzTA = PlacesStatusCodes.zzhJ(paramDataHolder.getStatusCode());
    if ((paramDataHolder != null) && (paramDataHolder.zzpH() != null))
    {
      this.zzaMG = paramDataHolder.zzpH().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    this.zzaMG = null;
  }
  
  public Place get(int paramInt)
  {
    return new zzs(this.zzafC, paramInt, this.mContext);
  }
  
  public CharSequence getAttributions()
  {
    return this.zzaMG;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlaceBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */