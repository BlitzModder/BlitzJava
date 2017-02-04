package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ApplicationStatus
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationStatus> CREATOR = new zza();
  private final int mVersionCode;
  private String zzabI;
  
  public ApplicationStatus()
  {
    this(1, null);
  }
  
  ApplicationStatus(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzabI = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ApplicationStatus)) {
      return false;
    }
    paramObject = (ApplicationStatus)paramObject;
    return zzf.zza(this.zzabI, ((ApplicationStatus)paramObject).zzabI);
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzabI });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zznM()
  {
    return this.zzabI;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/ApplicationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */