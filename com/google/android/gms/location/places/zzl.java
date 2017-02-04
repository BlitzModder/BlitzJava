package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.location.places.internal.zzi.zza;
import com.google.android.gms.location.places.personalized.zzd;

public class zzl
  extends zzi.zza
{
  private static final String TAG = zzl.class.getSimpleName();
  private final Context mContext;
  private final zzd zzaMW;
  private final zza zzaMX;
  private final zze zzaMY;
  private final zzf zzaMZ;
  private final zzc zzaNa;
  
  public zzl(zza paramzza)
  {
    this.zzaMW = null;
    this.zzaMX = paramzza;
    this.zzaMY = null;
    this.zzaMZ = null;
    this.zzaNa = null;
    this.mContext = null;
  }
  
  public zzl(zzc paramzzc, Context paramContext)
  {
    this.zzaMW = null;
    this.zzaMX = null;
    this.zzaMY = null;
    this.zzaMZ = null;
    this.zzaNa = paramzzc;
    this.mContext = paramContext.getApplicationContext();
  }
  
  public zzl(zzd paramzzd, Context paramContext)
  {
    this.zzaMW = paramzzd;
    this.zzaMX = null;
    this.zzaMY = null;
    this.zzaMZ = null;
    this.zzaNa = null;
    this.mContext = paramContext.getApplicationContext();
  }
  
  public zzl(zzf paramzzf)
  {
    this.zzaMW = null;
    this.zzaMX = null;
    this.zzaMY = null;
    this.zzaMZ = paramzzf;
    this.zzaNa = null;
    this.mContext = null;
  }
  
  public void zzaR(Status paramStatus)
    throws RemoteException
  {
    this.zzaMZ.zzb(paramStatus);
  }
  
  public void zzac(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (this.zzaMW != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "placeEstimator cannot be null");
      if (paramDataHolder != null) {
        break;
      }
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zznz.zzrY());
      }
      this.zzaMW.zzx(Status.zzaeZ);
      return;
    }
    paramDataHolder = new PlaceLikelihoodBuffer(paramDataHolder, 100, this.mContext);
    this.zzaMW.zzb(paramDataHolder);
  }
  
  public void zzad(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zznz.zzrY());
      }
      this.zzaMX.zzx(Status.zzaeZ);
      return;
    }
    this.zzaMX.zzb(new AutocompletePredictionBuffer(paramDataHolder));
  }
  
  public void zzae(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zznz.zzrY());
      }
      this.zzaMY.zzx(Status.zzaeZ);
      return;
    }
    this.zzaMY.zzb(new zzd(paramDataHolder));
  }
  
  public void zzaf(DataHolder paramDataHolder)
    throws RemoteException
  {
    paramDataHolder = new PlaceBuffer(paramDataHolder, this.mContext);
    this.zzaNa.zzb(paramDataHolder);
  }
  
  public static abstract class zza<A extends Api.zzb>
    extends zzl.zzb<AutocompletePredictionBuffer, A>
  {
    public zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected AutocompletePredictionBuffer zzaS(Status paramStatus)
    {
      return new AutocompletePredictionBuffer(DataHolder.zzbJ(paramStatus.getStatusCode()));
    }
  }
  
  public static abstract class zzb<R extends Result, A extends Api.zzb>
    extends zzlx.zza<R, A>
  {
    public zzb(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static abstract class zzc<A extends Api.zzb>
    extends zzl.zzb<PlaceBuffer, A>
  {
    public zzc(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceBuffer zzaT(Status paramStatus)
    {
      return new PlaceBuffer(DataHolder.zzbJ(paramStatus.getStatusCode()), null);
    }
  }
  
  public static abstract class zzd<A extends Api.zzb>
    extends zzl.zzb<PlaceLikelihoodBuffer, A>
  {
    public zzd(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceLikelihoodBuffer zzaU(Status paramStatus)
    {
      return new PlaceLikelihoodBuffer(DataHolder.zzbJ(paramStatus.getStatusCode()), 100, null);
    }
  }
  
  public static abstract class zze<A extends Api.zzb>
    extends zzl.zzb<zzd, A>
  {
    protected zzd zzaV(Status paramStatus)
    {
      return zzd.zzaW(paramStatus);
    }
  }
  
  public static abstract class zzf<A extends Api.zzb>
    extends zzl.zzb<Status, A>
  {
    public zzf(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */