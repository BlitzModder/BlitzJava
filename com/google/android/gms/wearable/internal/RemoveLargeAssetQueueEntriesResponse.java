package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class RemoveLargeAssetQueueEntriesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveLargeAssetQueueEntriesResponse> CREATOR = new zzbu();
  public final int versionCode;
  public final Status zzSE;
  public final int zzbnu;
  
  RemoveLargeAssetQueueEntriesResponse(int paramInt1, Status paramStatus, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzSE = ((Status)zzx.zzb(paramStatus, "status"));
    this.zzbnu = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbu.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/RemoveLargeAssetQueueEntriesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */