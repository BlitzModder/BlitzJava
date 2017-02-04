package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzIE;
  String zzaJQ;
  String zzaJR;
  String zzaJS;
  String zzaJT;
  String zzaJU;
  String zzaJV;
  String zzaJW;
  String zzaJX;
  String zzaJY;
  boolean zzaJZ;
  String zzaKa;
  String zzaKb;
  
  UserAddress()
  {
    this.mVersionCode = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.mVersionCode = paramInt;
    this.name = paramString1;
    this.zzaJQ = paramString2;
    this.zzaJR = paramString3;
    this.zzaJS = paramString4;
    this.zzaJT = paramString5;
    this.zzaJU = paramString6;
    this.zzaJV = paramString7;
    this.zzaJW = paramString8;
    this.zzIE = paramString9;
    this.zzaJX = paramString10;
    this.zzaJY = paramString11;
    this.phoneNumber = paramString12;
    this.zzaJZ = paramBoolean;
    this.zzaKa = paramString13;
    this.zzaKb = paramString14;
  }
  
  public static UserAddress fromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
      return null;
    }
    return (UserAddress)paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
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
  
  public String getAddress4()
  {
    return this.zzaJT;
  }
  
  public String getAddress5()
  {
    return this.zzaJU;
  }
  
  public String getAdministrativeArea()
  {
    return this.zzaJV;
  }
  
  public String getCompanyName()
  {
    return this.zzaKa;
  }
  
  public String getCountryCode()
  {
    return this.zzIE;
  }
  
  public String getEmailAddress()
  {
    return this.zzaKb;
  }
  
  public String getLocality()
  {
    return this.zzaJW;
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
  
  public String getSortingCode()
  {
    return this.zzaJY;
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
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */