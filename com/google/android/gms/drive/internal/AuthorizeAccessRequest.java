package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new zzc();
  final int mVersionCode;
  final DriveId zzamF;
  final long zzaoc;
  
  AuthorizeAccessRequest(int paramInt, long paramLong, DriveId paramDriveId)
  {
    this.mVersionCode = paramInt;
    this.zzaoc = paramLong;
    this.zzamF = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/AuthorizeAccessRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */