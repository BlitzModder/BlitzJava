package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnFetchThumbnailResponse> CREATOR = new zzbc();
  final int mVersionCode;
  final ParcelFileDescriptor zzaqo;
  
  OnFetchThumbnailResponse(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mVersionCode = paramInt;
    this.zzaqo = paramParcelFileDescriptor;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbc.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnFetchThumbnailResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */