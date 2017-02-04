package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  public final String name;
  public final int versionCode;
  public final EventParams zzaSL;
  public final String zzaSM;
  public final long zzaSN;
  
  EventParcel(int paramInt, String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaSL = paramEventParams;
    this.zzaSM = paramString2;
    this.zzaSN = paramLong;
  }
  
  public EventParcel(String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    this.versionCode = 1;
    this.name = paramString1;
    this.zzaSL = paramEventParams;
    this.zzaSM = paramString2;
    this.zzaSN = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "origin=" + this.zzaSM + ",name=" + this.name + ",params=" + this.zzaSL;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/EventParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */