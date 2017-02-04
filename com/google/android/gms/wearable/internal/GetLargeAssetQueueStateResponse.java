package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class GetLargeAssetQueueStateResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetLargeAssetQueueStateResponse> CREATOR = new zzau();
  final int mVersionCode;
  public final Status zzSE;
  public final LargeAssetQueueStateParcelable zzbnH;
  
  GetLargeAssetQueueStateResponse(int paramInt, Status paramStatus, LargeAssetQueueStateParcelable paramLargeAssetQueueStateParcelable)
  {
    this.mVersionCode = paramInt;
    this.zzSE = paramStatus;
    if (paramStatus.isSuccess()) {
      zzx.zzy(paramLargeAssetQueueStateParcelable);
    }
    this.zzbnH = paramLargeAssetQueueStateParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzau.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/GetLargeAssetQueueStateResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */