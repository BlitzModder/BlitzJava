package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter
  extends zza
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int mVersionCode;
  final boolean zzaMH;
  final List<Integer> zzaMt;
  private final Set<Integer> zzaMu;
  final List<String> zzaMv;
  final List<UserDataType> zzaMw;
  private final Set<String> zzaMx;
  private final Set<UserDataType> zzaMy;
  
  public PlaceFilter()
  {
    this(false, null);
  }
  
  PlaceFilter(int paramInt, List<Integer> paramList, boolean paramBoolean, List<String> paramList1, List<UserDataType> paramList2)
  {
    this.mVersionCode = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      this.zzaMt = paramList;
      this.zzaMH = paramBoolean;
      if (paramList2 != null) {
        break label97;
      }
      paramList = Collections.emptyList();
      label36:
      this.zzaMw = paramList;
      if (paramList1 != null) {
        break label106;
      }
    }
    label97:
    label106:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList1))
    {
      this.zzaMv = paramList;
      this.zzaMu = zzu(this.zzaMt);
      this.zzaMy = zzu(this.zzaMw);
      this.zzaMx = zzu(this.zzaMv);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList2);
      break label36;
    }
  }
  
  public PlaceFilter(Collection<Integer> paramCollection, boolean paramBoolean, Collection<String> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    this(0, zzf(paramCollection), paramBoolean, zzf(paramCollection1), zzf(paramCollection2));
  }
  
  public PlaceFilter(boolean paramBoolean, Collection<String> paramCollection)
  {
    this(null, paramBoolean, paramCollection, null);
  }
  
  @Deprecated
  public static PlaceFilter zzyr()
  {
    return new zza(null).zzys();
  }
  
  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceFilter)) {
        return false;
      }
      paramObject = (PlaceFilter)paramObject;
    } while ((this.zzaMu.equals(((PlaceFilter)paramObject).zzaMu)) && (this.zzaMH == ((PlaceFilter)paramObject).zzaMH) && (this.zzaMy.equals(((PlaceFilter)paramObject).zzaMy)) && (this.zzaMx.equals(((PlaceFilter)paramObject).zzaMx)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return this.zzaMx;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return this.zzaMu;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaMu, Boolean.valueOf(this.zzaMH), this.zzaMy, this.zzaMx });
  }
  
  public boolean isRestrictedToPlacesOpenNow()
  {
    return this.zzaMH;
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this);
    if (!this.zzaMu.isEmpty()) {
      localzza.zzg("types", this.zzaMu);
    }
    localzza.zzg("requireOpenNow", Boolean.valueOf(this.zzaMH));
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
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
  
  @Deprecated
  public static final class zza
  {
    private boolean zzaMH = false;
    private Collection<Integer> zzaMI = null;
    private Collection<UserDataType> zzaMJ = null;
    private String[] zzaMK = null;
    
    public PlaceFilter zzys()
    {
      List localList = null;
      ArrayList localArrayList1;
      if (this.zzaMI != null)
      {
        localArrayList1 = new ArrayList(this.zzaMI);
        if (this.zzaMJ == null) {
          break label75;
        }
      }
      label75:
      for (ArrayList localArrayList2 = new ArrayList(this.zzaMJ);; localArrayList2 = null)
      {
        if (this.zzaMK != null) {
          localList = Arrays.asList(this.zzaMK);
        }
        return new PlaceFilter(localArrayList1, this.zzaMH, localList, localArrayList2);
        localArrayList1 = null;
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlaceFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */