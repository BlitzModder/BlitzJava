package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Set;

public final class NearbyAlertRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final int zzaKO;
  @Deprecated
  private final PlaceFilter zzaMA;
  private final NearbyAlertFilter zzaMB;
  private final boolean zzaMC;
  private final int zzaMD;
  private final int zzaMz;
  
  NearbyAlertRequest(int paramInt1, int paramInt2, int paramInt3, PlaceFilter paramPlaceFilter, NearbyAlertFilter paramNearbyAlertFilter, boolean paramBoolean, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzaKO = paramInt2;
    this.zzaMz = paramInt3;
    this.zzaMC = paramBoolean;
    if (paramNearbyAlertFilter != null) {
      this.zzaMB = paramNearbyAlertFilter;
    }
    for (;;)
    {
      this.zzaMA = null;
      this.zzaMD = paramInt4;
      return;
      if (paramPlaceFilter != null)
      {
        if ((paramPlaceFilter.getPlaceIds() != null) && (!paramPlaceFilter.getPlaceIds().isEmpty())) {
          this.zzaMB = NearbyAlertFilter.zzg(paramPlaceFilter.getPlaceIds());
        } else if ((paramPlaceFilter.getPlaceTypes() != null) && (!paramPlaceFilter.getPlaceTypes().isEmpty())) {
          this.zzaMB = NearbyAlertFilter.zzh(paramPlaceFilter.getPlaceTypes());
        } else {
          this.zzaMB = null;
        }
      }
      else {
        this.zzaMB = null;
      }
    }
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertRequest)) {
        return false;
      }
      paramObject = (NearbyAlertRequest)paramObject;
    } while ((this.zzaKO == ((NearbyAlertRequest)paramObject).zzaKO) && (this.zzaMz == ((NearbyAlertRequest)paramObject).zzaMz) && (zzw.equal(this.zzaMA, ((NearbyAlertRequest)paramObject).zzaMA)) && (zzw.equal(this.zzaMB, ((NearbyAlertRequest)paramObject).zzaMB)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaKO), Integer.valueOf(this.zzaMz) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("transitionTypes", Integer.valueOf(this.zzaKO)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaMz)).zzg("nearbyAlertFilter", this.zzaMB).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public int zzyj()
  {
    return this.zzaKO;
  }
  
  public int zzym()
  {
    return this.zzaMz;
  }
  
  @Deprecated
  public PlaceFilter zzyn()
  {
    return null;
  }
  
  public NearbyAlertFilter zzyo()
  {
    return this.zzaMB;
  }
  
  public boolean zzyp()
  {
    return this.zzaMC;
  }
  
  public int zzyq()
  {
    return this.zzaMD;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/NearbyAlertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */