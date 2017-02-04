package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbp();
  final int mVersionCode;
  private final String zzVu;
  private final boolean zzboA;
  private final int zzboz;
  private final String zzxX;
  
  NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzxX = paramString1;
    this.zzVu = paramString2;
    this.zzboz = paramInt2;
    this.zzboA = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable)) {
      return false;
    }
    return ((NodeParcelable)paramObject).zzxX.equals(this.zzxX);
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public int getHopCount()
  {
    return this.zzboz;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public int hashCode()
  {
    return this.zzxX.hashCode();
  }
  
  public boolean isNearby()
  {
    return this.zzboA;
  }
  
  public String toString()
  {
    return "Node{" + this.zzVu + ", id=" + this.zzxX + ", hops=" + this.zzboz + ", isNearby=" + this.zzboA + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/NodeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */