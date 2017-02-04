package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.zzh.zza;

public class zzf
  extends zzh.zza
{
  private final zzb zzaME;
  private final zza zzaMF;
  
  public zzf(zza paramzza)
  {
    this.zzaME = null;
    this.zzaMF = paramzza;
  }
  
  public zzf(zzb paramzzb)
  {
    this.zzaME = paramzzb;
    this.zzaMF = null;
  }
  
  public void zza(PlacePhotoMetadataResult paramPlacePhotoMetadataResult)
    throws RemoteException
  {
    this.zzaME.zzb(paramPlacePhotoMetadataResult);
  }
  
  public void zza(PlacePhotoResult paramPlacePhotoResult)
    throws RemoteException
  {
    this.zzaMF.zzb(paramPlacePhotoResult);
  }
  
  public static abstract class zza<A extends Api.zzb>
    extends zzl.zzb<PlacePhotoResult, A>
  {
    public zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlacePhotoResult zzaP(Status paramStatus)
    {
      return new PlacePhotoResult(paramStatus, null);
    }
  }
  
  public static abstract class zzb<A extends Api.zzb>
    extends zzl.zzb<PlacePhotoMetadataResult, A>
  {
    public zzb(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlacePhotoMetadataResult zzaQ(Status paramStatus)
    {
      return new PlacePhotoMetadataResult(paramStatus, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */