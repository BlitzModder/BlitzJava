package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
  static final long zzaMQ = TimeUnit.HOURS.toMillis(1L);
  private final int mPriority;
  final int mVersionCode;
  private final long zzaKP;
  private final long zzaLk;
  private final PlaceFilter zzaMR;
  
  public PlaceRequest(int paramInt1, PlaceFilter paramPlaceFilter, long paramLong1, int paramInt2, long paramLong2)
  {
    this.mVersionCode = paramInt1;
    this.zzaMR = paramPlaceFilter;
    this.zzaLk = paramLong1;
    this.mPriority = paramInt2;
    this.zzaKP = paramLong2;
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
      if (!(paramObject instanceof PlaceRequest)) {
        return false;
      }
      paramObject = (PlaceRequest)paramObject;
    } while ((zzw.equal(this.zzaMR, ((PlaceRequest)paramObject).zzaMR)) && (this.zzaLk == ((PlaceRequest)paramObject).zzaLk) && (this.mPriority == ((PlaceRequest)paramObject).mPriority) && (this.zzaKP == ((PlaceRequest)paramObject).zzaKP));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzaKP;
  }
  
  public long getInterval()
  {
    return this.zzaLk;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaMR, Long.valueOf(this.zzaLk), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaKP) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("filter", this.zzaMR).zzg("interval", Long.valueOf(this.zzaLk)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaKP)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public PlaceFilter zzyn()
  {
    return this.zzaMR;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlaceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */