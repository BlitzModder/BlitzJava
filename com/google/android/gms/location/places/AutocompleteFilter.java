package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzaMs;
  final List<Integer> zzaMt;
  private final Set<Integer> zzaMu;
  
  AutocompleteFilter(int paramInt, boolean paramBoolean, Collection<Integer> paramCollection)
  {
    this.mVersionCode = paramInt;
    this.zzaMs = paramBoolean;
    if (paramCollection == null) {}
    for (paramCollection = Collections.emptyList();; paramCollection = new ArrayList(paramCollection))
    {
      this.zzaMt = paramCollection;
      if (!this.zzaMt.isEmpty()) {
        break;
      }
      this.zzaMu = Collections.emptySet();
      return;
    }
    this.zzaMu = Collections.unmodifiableSet(new HashSet(this.zzaMt));
  }
  
  public static AutocompleteFilter create(Collection<Integer> paramCollection)
  {
    return zza(true, paramCollection);
  }
  
  public static AutocompleteFilter zza(boolean paramBoolean, Collection<Integer> paramCollection)
  {
    return new AutocompleteFilter(0, paramBoolean, paramCollection);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompleteFilter)) {
        return false;
      }
      paramObject = (AutocompleteFilter)paramObject;
    } while ((this.zzaMu.equals(((AutocompleteFilter)paramObject).zzaMu)) && (this.zzaMs == ((AutocompleteFilter)paramObject).zzaMs));
    return false;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return this.zzaMu;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(this.zzaMs), this.zzaMu });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this);
    if (!this.zzaMs) {
      localzza.zzg("restrictedToPlaces", Boolean.valueOf(this.zzaMs));
    }
    localzza.zzg("placeTypes", this.zzaMu);
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzyl()
  {
    return this.zzaMs;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/AutocompleteFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */