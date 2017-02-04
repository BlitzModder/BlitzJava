package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences
  implements SafeParcelable
{
  public static final Parcelable.Creator<DrivePreferences> CREATOR = new zzf();
  final int mVersionCode;
  final boolean zzamV;
  
  DrivePreferences(int paramInt, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzamV = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DrivePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */