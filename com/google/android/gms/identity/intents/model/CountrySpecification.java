package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
  implements SafeParcelable
{
  public static final Parcelable.Creator<CountrySpecification> CREATOR = new zza();
  private final int mVersionCode;
  String zzIE;
  
  CountrySpecification(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzIE = paramString;
  }
  
  public CountrySpecification(String paramString)
  {
    this.mVersionCode = 1;
    this.zzIE = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCountryCode()
  {
    return this.zzIE;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/identity/intents/model/CountrySpecification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */