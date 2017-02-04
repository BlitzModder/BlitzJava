package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveFileRange
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveFileRange> CREATOR = new zzc();
  final int mVersionCode;
  final long zzamP;
  final long zzamQ;
  
  DriveFileRange(int paramInt, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzamP = paramLong1;
    this.zzamQ = paramLong2;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DriveFileRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */