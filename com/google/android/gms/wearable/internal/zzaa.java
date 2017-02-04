package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa
  implements DataItemAsset
{
  private final String zzuX;
  private final String zzxX;
  
  public zzaa(DataItemAsset paramDataItemAsset)
  {
    this.zzxX = paramDataItemAsset.getId();
    this.zzuX = paramDataItemAsset.getDataItemKey();
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
    localStringBuilder.append("DataItemAssetEntity[");
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
  
  public DataItemAsset zzGN()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */