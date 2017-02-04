package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LargeAssetQuery
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeAssetQuery> CREATOR = new zzbe();
  final int mVersionCode;
  public final Uri zzaXR;
  public final int zzbnP;
  
  LargeAssetQuery(int paramInt1, int paramInt2, Uri paramUri)
  {
    this.mVersionCode = paramInt1;
    this.zzbnP = paramInt2;
    this.zzaXR = paramUri;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LargeAssetQuery{stateFlags=" + this.zzbnP + ", destinationUri=" + this.zzaXR + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbe.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */