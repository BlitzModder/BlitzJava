package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  static final List<ClientIdentity> zzaMa = ;
  String mTag;
  private final int mVersionCode;
  boolean zzaMb;
  boolean zzaMc;
  boolean zzaMd;
  List<ClientIdentity> zzaMe;
  boolean zzaMf;
  LocationRequest zzayV;
  
  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ClientIdentity> paramList, String paramString, boolean paramBoolean4)
  {
    this.mVersionCode = paramInt;
    this.zzayV = paramLocationRequest;
    this.zzaMb = paramBoolean1;
    this.zzaMc = paramBoolean2;
    this.zzaMd = paramBoolean3;
    this.zzaMe = paramList;
    this.mTag = paramString;
    this.zzaMf = paramBoolean4;
  }
  
  public static LocationRequestInternal zza(String paramString, LocationRequest paramLocationRequest)
  {
    return new LocationRequestInternal(1, paramLocationRequest, false, true, true, zzaMa, paramString, false);
  }
  
  @Deprecated
  public static LocationRequestInternal zzb(LocationRequest paramLocationRequest)
  {
    return zza(null, paramLocationRequest);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal)) {}
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    } while ((!zzw.equal(this.zzayV, ((LocationRequestInternal)paramObject).zzayV)) || (this.zzaMb != ((LocationRequestInternal)paramObject).zzaMb) || (this.zzaMc != ((LocationRequestInternal)paramObject).zzaMc) || (this.zzaMd != ((LocationRequestInternal)paramObject).zzaMd) || (this.zzaMf != ((LocationRequestInternal)paramObject).zzaMf) || (!zzw.equal(this.zzaMe, ((LocationRequestInternal)paramObject).zzaMe)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.zzayV.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.zzayV.toString());
    if (this.mTag != null) {
      localStringBuilder.append(" tag=").append(this.mTag);
    }
    localStringBuilder.append(" nlpDebug=").append(this.zzaMb);
    localStringBuilder.append(" trigger=").append(this.zzaMd);
    localStringBuilder.append(" restorePIListeners=").append(this.zzaMc);
    localStringBuilder.append(" hideAppOps=").append(this.zzaMf);
    localStringBuilder.append(" clients=").append(this.zzaMe);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/LocationRequestInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */