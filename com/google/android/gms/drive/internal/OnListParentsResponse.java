package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new zzbe();
  final int mVersionCode;
  final DataHolder zzaqq;
  
  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    this.mVersionCode = paramInt;
    this.zzaqq = paramDataHolder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void zzJ(Parcel paramParcel, int paramInt)
  {
    zzbe.zza(this, paramParcel, paramInt);
  }
  
  public DataHolder zzsW()
  {
    return this.zzaqq;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnListParentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */