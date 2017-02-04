package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class PartialDriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<PartialDriveId> CREATOR = new zzm();
  final int mVersionCode;
  final String zzamR;
  final long zzamS;
  final int zzamT;
  
  PartialDriveId(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzamR = paramString;
    this.zzamS = paramLong;
    this.zzamT = paramInt2;
  }
  
  public PartialDriveId(String paramString, long paramLong, int paramInt)
  {
    this(1, paramString, paramLong, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public DriveId zzE(long paramLong)
  {
    return new DriveId(this.zzamR, this.zzamS, paramLong, this.zzamT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/PartialDriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */