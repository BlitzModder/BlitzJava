package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
  private final int mVersionCode;
  private final boolean zzaLr;
  private final boolean zzaLs;
  private final List<LocationRequest> zzayS;
  
  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzayS = paramList;
    this.zzaLr = paramBoolean1;
    this.zzaLs = paramBoolean2;
  }
  
  private LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public List<LocationRequest> zzux()
  {
    return Collections.unmodifiableList(this.zzayS);
  }
  
  public boolean zzxY()
  {
    return this.zzaLr;
  }
  
  public boolean zzxZ()
  {
    return this.zzaLs;
  }
  
  public static final class Builder
  {
    private boolean zzaLr = false;
    private boolean zzaLs = false;
    private final ArrayList<LocationRequest> zzaLt = new ArrayList();
    
    public Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      this.zzaLt.addAll(paramCollection);
      return this;
    }
    
    public Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      this.zzaLt.add(paramLocationRequest);
      return this;
    }
    
    public LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(this.zzaLt, this.zzaLr, this.zzaLs, null);
    }
    
    public Builder setAlwaysShow(boolean paramBoolean)
    {
      this.zzaLr = paramBoolean;
      return this;
    }
    
    public Builder setNeedBle(boolean paramBoolean)
    {
      this.zzaLs = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/LocationSettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */