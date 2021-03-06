package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzq.zza;

public class DriveServiceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzad();
  final int mVersionCode;
  final IBinder zzapx;
  
  DriveServiceResponse(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapx = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public zzq zzsK()
  {
    return zzq.zza.zzaQ(this.zzapx);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/DriveServiceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */