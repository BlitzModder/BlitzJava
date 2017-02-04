package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlaceAlias
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public static final PlaceAlias zzaOr = new PlaceAlias(0, "Home");
  public static final PlaceAlias zzaOs = new PlaceAlias(0, "Work");
  final int mVersionCode;
  private final String zzaOt;
  
  PlaceAlias(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaOt = paramString;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PlaceAlias)) {
      return false;
    }
    paramObject = (PlaceAlias)paramObject;
    return zzw.equal(this.zzaOt, ((PlaceAlias)paramObject).zzaOt);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaOt });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("alias", this.zzaOt).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzyO()
  {
    return this.zzaOt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/personalized/PlaceAlias.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */