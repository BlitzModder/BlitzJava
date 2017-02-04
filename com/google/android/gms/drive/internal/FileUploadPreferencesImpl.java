package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl
  implements SafeParcelable, FileUploadPreferences
{
  public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
  final int mVersionCode;
  int zzapC;
  int zzapD;
  boolean zzapE;
  
  FileUploadPreferencesImpl(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzapC = paramInt2;
    this.zzapD = paramInt3;
    this.zzapE = paramBoolean;
  }
  
  public static boolean zzdg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzdh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getBatteryUsagePreference()
  {
    if (!zzdh(this.zzapD)) {
      return 0;
    }
    return this.zzapD;
  }
  
  public int getNetworkTypePreference()
  {
    if (!zzdg(this.zzapC)) {
      return 0;
    }
    return this.zzapC;
  }
  
  public boolean isRoamingAllowed()
  {
    return this.zzapE;
  }
  
  public void setBatteryUsagePreference(int paramInt)
  {
    if (!zzdh(paramInt)) {
      throw new IllegalArgumentException("Invalid battery usage preference value.");
    }
    this.zzapD = paramInt;
  }
  
  public void setNetworkTypePreference(int paramInt)
  {
    if (!zzdg(paramInt)) {
      throw new IllegalArgumentException("Invalid data connection preference value.");
    }
    this.zzapC = paramInt;
  }
  
  public void setRoamingAllowed(boolean paramBoolean)
  {
    this.zzapE = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/FileUploadPreferencesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */