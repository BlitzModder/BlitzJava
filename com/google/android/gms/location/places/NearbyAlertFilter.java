package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter
  extends zza
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  final List<Integer> zzaMt;
  private final Set<Integer> zzaMu;
  final List<String> zzaMv;
  final List<UserDataType> zzaMw;
  private final Set<String> zzaMx;
  private final Set<UserDataType> zzaMy;
  
  NearbyAlertFilter(int paramInt, List<String> paramList, List<Integer> paramList1, List<UserDataType> paramList2)
  {
    this.mVersionCode = paramInt;
    if (paramList1 == null)
    {
      paramList1 = Collections.emptyList();
      this.zzaMt = paramList1;
      if (paramList2 != null) {
        break label91;
      }
      paramList1 = Collections.emptyList();
      label31:
      this.zzaMw = paramList1;
      if (paramList != null) {
        break label100;
      }
    }
    label91:
    label100:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      this.zzaMv = paramList;
      this.zzaMu = zzu(this.zzaMt);
      this.zzaMy = zzu(this.zzaMw);
      this.zzaMx = zzu(this.zzaMv);
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
      paramList1 = Collections.unmodifiableList(paramList2);
      break label31;
    }
  }
  
  public static NearbyAlertFilter zzg(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
    }
    return new NearbyAlertFilter(0, zzf(paramCollection), null, null);
  }
  
  public static NearbyAlertFilter zzh(Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
    }
    return new NearbyAlertFilter(0, null, zzf(paramCollection), null);
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertFilter)) {
        return false;
      }
      paramObject = (NearbyAlertFilter)paramObject;
    } while ((this.zzaMu.equals(((NearbyAlertFilter)paramObject).zzaMu)) && (this.zzaMy.equals(((NearbyAlertFilter)paramObject).zzaMy)) && (this.zzaMx.equals(((NearbyAlertFilter)paramObject).zzaMx)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return this.zzaMx;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaMu, this.zzaMy, this.zzaMx });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this);
    if (!this.zzaMu.isEmpty()) {
      localzza.zzg("types", this.zzaMu);
    }
    if (!this.zzaMx.isEmpty()) {
      localzza.zzg("placeIds", this.zzaMx);
    }
    if (!this.zzaMy.isEmpty()) {
      localzza.zzg("requestedUserDataTypes", this.zzaMy);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/NearbyAlertFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */