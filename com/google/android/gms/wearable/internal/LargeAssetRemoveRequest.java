package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class LargeAssetRemoveRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeAssetRemoveRequest> CREATOR = new zzbi();
  private static final LargeAssetRemoveRequest zzboe = new LargeAssetRemoveRequest(1, null);
  final int mVersionCode;
  public final long[] zzbof;
  
  LargeAssetRemoveRequest(int paramInt, long[] paramArrayOfLong)
  {
    this.mVersionCode = paramInt;
    this.zzbof = paramArrayOfLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LargeAssetRemoveRequest{transferIdsToRemove=" + Arrays.toString(this.zzbof) + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetRemoveRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */