package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity
  implements SafeParcelable, PlaceLikelihood
{
  public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
  final int mVersionCode;
  final PlaceImpl zzaNV;
  final float zzaNW;
  
  PlaceLikelihoodEntity(int paramInt, PlaceImpl paramPlaceImpl, float paramFloat)
  {
    this.mVersionCode = paramInt;
    this.zzaNV = paramPlaceImpl;
    this.zzaNW = paramFloat;
  }
  
  public static PlaceLikelihoodEntity zza(PlaceImpl paramPlaceImpl, float paramFloat)
  {
    return new PlaceLikelihoodEntity(0, (PlaceImpl)zzx.zzy(paramPlaceImpl), paramFloat);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLikelihoodEntity)) {
        return false;
      }
      paramObject = (PlaceLikelihoodEntity)paramObject;
    } while ((this.zzaNV.equals(((PlaceLikelihoodEntity)paramObject).zzaNV)) && (this.zzaNW == ((PlaceLikelihoodEntity)paramObject).zzaNW));
    return false;
  }
  
  public float getLikelihood()
  {
    return this.zzaNW;
  }
  
  public Place getPlace()
  {
    return this.zzaNV;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaNV, Float.valueOf(this.zzaNW) });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("place", this.zzaNV).zzg("likelihood", Float.valueOf(this.zzaNW)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public PlaceLikelihood zzyM()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/PlaceLikelihoodEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */