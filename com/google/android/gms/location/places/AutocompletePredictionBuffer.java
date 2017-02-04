package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.internal.zzb;

public class AutocompletePredictionBuffer
  extends AbstractDataBuffer<AutocompletePrediction>
  implements Result
{
  public AutocompletePredictionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public AutocompletePrediction get(int paramInt)
  {
    return new zzb(this.zzafC, paramInt);
  }
  
  public Status getStatus()
  {
    return PlacesStatusCodes.zzhJ(this.zzafC.getStatusCode());
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", getStatus()).toString();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/AutocompletePredictionBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */