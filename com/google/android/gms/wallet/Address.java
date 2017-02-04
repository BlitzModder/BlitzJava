package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new zza();
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzIE;
  String zzaJQ;
  String zzaJR;
  String zzaJS;
  String zzaJX;
  boolean zzaJZ;
  String zzaKa;
  String zzbiX;
  String zzbiY;
  
  Address()
  {
    this.mVersionCode = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.mVersionCode = paramInt;
    this.name = paramString1;
    this.zzaJQ = paramString2;
    this.zzaJR = paramString3;
    this.zzaJS = paramString4;
    this.zzIE = paramString5;
    this.zzbiX = paramString6;
    this.zzbiY = paramString7;
    this.zzaJX = paramString8;
    this.phoneNumber = paramString9;
    this.zzaJZ = paramBoolean;
    this.zzaKa = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.zzaJQ;
  }
  
  public String getAddress2()
  {
    return this.zzaJR;
  }
  
  public String getAddress3()
  {
    return this.zzaJS;
  }
  
  public String getCity()
  {
    return this.zzbiX;
  }
  
  public String getCompanyName()
  {
    return this.zzaKa;
  }
  
  public String getCountryCode()
  {
    return this.zzIE;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getPostalCode()
  {
    return this.zzaJX;
  }
  
  public String getState()
  {
    return this.zzbiY;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isPostBox()
  {
    return this.zzaJZ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */