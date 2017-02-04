package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
  private final int mVersionCode;
  private final boolean zzaLA;
  private final boolean zzaLv;
  private final boolean zzaLw;
  private final boolean zzaLx;
  private final boolean zzaLy;
  private final boolean zzaLz;
  
  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.mVersionCode = paramInt;
    this.zzaLv = paramBoolean1;
    this.zzaLw = paramBoolean2;
    this.zzaLx = paramBoolean3;
    this.zzaLy = paramBoolean4;
    this.zzaLz = paramBoolean5;
    this.zzaLA = paramBoolean6;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)zzc.zza(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isBlePresent()
  {
    return this.zzaLA;
  }
  
  public boolean isBleUsable()
  {
    return this.zzaLx;
  }
  
  public boolean isGpsPresent()
  {
    return this.zzaLy;
  }
  
  public boolean isGpsUsable()
  {
    return this.zzaLv;
  }
  
  public boolean isLocationPresent()
  {
    return (this.zzaLy) || (this.zzaLz);
  }
  
  public boolean isLocationUsable()
  {
    return (this.zzaLv) || (this.zzaLw);
  }
  
  public boolean isNetworkLocationPresent()
  {
    return this.zzaLz;
  }
  
  public boolean isNetworkLocationUsable()
  {
    return this.zzaLw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/LocationSettingsStates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */