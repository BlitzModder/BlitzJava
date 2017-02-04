package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzay();
  private static final List<DriveFileRange> zzaqe = ;
  final int mVersionCode;
  final int zzAk;
  final long zzaqf;
  final long zzaqg;
  final List<DriveFileRange> zzaqh;
  
  OnDownloadProgressResponse(int paramInt1, long paramLong1, long paramLong2, int paramInt2, List<DriveFileRange> paramList)
  {
    this.mVersionCode = paramInt1;
    this.zzaqf = paramLong1;
    this.zzaqg = paramLong2;
    this.zzAk = paramInt2;
    this.zzaqh = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzay.zza(this, paramParcel, paramInt);
  }
  
  public long zzsR()
  {
    return this.zzaqf;
  }
  
  public long zzsS()
  {
    return this.zzaqg;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */