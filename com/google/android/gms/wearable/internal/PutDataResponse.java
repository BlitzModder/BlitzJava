package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PutDataResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataResponse> CREATOR = new zzbs();
  public final int statusCode;
  public final int versionCode;
  public final DataItemParcelable zzbnF;
  
  PutDataResponse(int paramInt1, int paramInt2, DataItemParcelable paramDataItemParcelable)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.zzbnF = paramDataItemParcelable;
  }
  
  public PutDataResponse(int paramInt, DataItemParcelable paramDataItemParcelable)
  {
    this(1, paramInt, paramDataItemParcelable);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbs.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/PutDataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */