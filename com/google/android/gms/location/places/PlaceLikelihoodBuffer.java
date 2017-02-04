package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer
  extends AbstractDataBuffer<PlaceLikelihood>
  implements Result
{
  private final Context mContext;
  private final Status zzTA;
  private final String zzaMG;
  private final int zzuW;
  
  public PlaceLikelihoodBuffer(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder);
    this.mContext = paramContext;
    this.zzTA = PlacesStatusCodes.zzhJ(paramDataHolder.getStatusCode());
    this.zzuW = zza.zzhE(paramInt);
    if ((paramDataHolder != null) && (paramDataHolder.zzpH() != null))
    {
      this.zzaMG = paramDataHolder.zzpH().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    this.zzaMG = null;
  }
  
  public PlaceLikelihood get(int paramInt)
  {
    return new zzn(this.zzafC, paramInt, this.mContext);
  }
  
  public CharSequence getAttributions()
  {
    return this.zzaMG;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", getStatus()).zzg("attributions", this.zzaMG).toString();
  }
  
  public static class zza
  {
    static int zzhE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid source: " + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlaceLikelihoodBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */