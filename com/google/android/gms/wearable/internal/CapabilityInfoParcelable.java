package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable
  implements SafeParcelable, CapabilityInfo
{
  public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzk();
  private final String mName;
  final int mVersionCode;
  private Set<Node> zzbmN;
  private final List<NodeParcelable> zzbmQ;
  private final Object zzpK = new Object();
  
  CapabilityInfoParcelable(int paramInt, String paramString, List<NodeParcelable> paramList)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString;
    this.zzbmQ = paramList;
    this.zzbmN = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CapabilityInfoParcelable)paramObject;
      if (this.mVersionCode != ((CapabilityInfoParcelable)paramObject).mVersionCode) {
        return false;
      }
      if (this.mName != null)
      {
        if (this.mName.equals(((CapabilityInfoParcelable)paramObject).mName)) {}
      }
      else {
        while (((CapabilityInfoParcelable)paramObject).mName != null) {
          return false;
        }
      }
      if (this.zzbmQ == null) {
        break;
      }
    } while (this.zzbmQ.equals(((CapabilityInfoParcelable)paramObject).zzbmQ));
    for (;;)
    {
      return false;
      if (((CapabilityInfoParcelable)paramObject).zzbmQ == null) {
        break;
      }
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Set<Node> getNodes()
  {
    synchronized (this.zzpK)
    {
      if (this.zzbmN == null) {
        this.zzbmN = new HashSet(this.zzbmQ);
      }
      Set localSet = this.zzbmN;
      return localSet;
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.mVersionCode;
    if (this.mName != null) {}
    for (int i = this.mName.hashCode();; i = 0)
    {
      if (this.zzbmQ != null) {
        j = this.zzbmQ.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    return "CapabilityInfo{" + this.mName + ", " + this.zzbmQ + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public List<NodeParcelable> zzGK()
  {
    return this.zzbmQ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/CapabilityInfoParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */