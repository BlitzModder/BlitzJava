package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public class StringParcel
  implements SafeParcelable
{
  public static final Parcelable.Creator<StringParcel> CREATOR = new zzn();
  final int mVersionCode;
  String zzxi;
  
  StringParcel(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzxi = paramString;
  }
  
  public StringParcel(String paramString)
  {
    this.mVersionCode = 1;
    this.zzxi = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  public String zzgm()
  {
    return this.zzxi;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/StringParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */