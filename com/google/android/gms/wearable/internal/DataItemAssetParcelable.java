package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable
  implements SafeParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzab();
  final int mVersionCode;
  private final String zzuX;
  private final String zzxX;
  
  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzxX = paramString1;
    this.zzuX = paramString2;
  }
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    this.mVersionCode = 1;
    this.zzxX = ((String)zzx.zzy(paramDataItemAsset.getId()));
    this.zzuX = ((String)zzx.zzy(paramDataItemAsset.getDataItemKey()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDataItemKey()
  {
    return this.zzuX;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzxX == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.zzuX);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.zzxX);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
  
  public DataItemAsset zzGN()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/DataItemAssetParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */