package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class EnqueueLargeAssetResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<EnqueueLargeAssetResponse> CREATOR = new zzah();
  final int mVersionCode;
  public final int statusCode;
  public final LargeAssetQueueEntryParcelable zzbnv;
  
  EnqueueLargeAssetResponse(int paramInt1, int paramInt2, LargeAssetQueueEntryParcelable paramLargeAssetQueueEntryParcelable)
  {
    this.mVersionCode = paramInt1;
    this.statusCode = paramInt2;
    if (paramInt2 == 0)
    {
      if (paramLargeAssetQueueEntryParcelable != null) {}
      for (;;)
      {
        zzx.zzb(bool, "Expecting non-null queueEntry");
        this.zzbnv = paramLargeAssetQueueEntryParcelable;
        return;
        bool = false;
      }
    }
    if (paramLargeAssetQueueEntryParcelable == null) {}
    for (bool = true;; bool = false)
    {
      zzx.zzb(bool, "Expecting null queueEntry: %s", new Object[] { paramLargeAssetQueueEntryParcelable });
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/EnqueueLargeAssetResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */