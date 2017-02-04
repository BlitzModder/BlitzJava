package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.QueueState;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LargeAssetQueueStateParcelable
  implements SafeParcelable, LargeAssetApi.QueueState
{
  public static final Parcelable.Creator<LargeAssetQueueStateParcelable> CREATOR = new zzbh();
  final int mVersionCode;
  final int zzbnZ;
  final String zzboa;
  final Map<String, Integer> zzbob;
  final int zzboc;
  final int zzbod;
  
  LargeAssetQueueStateParcelable(int paramInt1, int paramInt2, String paramString, Bundle paramBundle, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzbnZ = zzlT(paramInt2);
    this.zzboa = ((String)zzx.zzy(paramString));
    this.zzbob = zzJ(paramBundle);
    this.zzboc = paramInt3;
    this.zzbod = paramInt4;
  }
  
  private static Map<String, Integer> zzJ(Bundle paramBundle)
  {
    Object localObject = paramBundle.keySet();
    ArrayMap localArrayMap = new ArrayMap(((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localArrayMap.put(str, Integer.valueOf(zzlT(paramBundle.getInt(str))));
    }
    return localArrayMap;
  }
  
  private static int zzlT(int paramInt)
  {
    return paramInt & 0xF;
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
      if (!(paramObject instanceof LargeAssetQueueStateParcelable)) {
        return false;
      }
      paramObject = (LargeAssetQueueStateParcelable)paramObject;
    } while ((this.mVersionCode == ((LargeAssetQueueStateParcelable)paramObject).mVersionCode) && (this.zzbnZ == ((LargeAssetQueueStateParcelable)paramObject).zzbnZ) && (this.zzboc == ((LargeAssetQueueStateParcelable)paramObject).zzboc) && (this.zzbod == ((LargeAssetQueueStateParcelable)paramObject).zzbod) && (this.zzboa.equals(((LargeAssetQueueStateParcelable)paramObject).zzboa)) && (this.zzbob.equals(((LargeAssetQueueStateParcelable)paramObject).zzbob)));
    return false;
  }
  
  public int hashCode()
  {
    return ((((this.mVersionCode * 31 + this.zzbnZ) * 31 + this.zzboa.hashCode()) * 31 + this.zzbob.hashCode()) * 31 + this.zzboc) * 31 + this.zzbod;
  }
  
  public String toString()
  {
    return "QueueState{localNodeFlags=" + this.zzbnZ + ", localNodeId='" + this.zzboa + "'" + ", remoteNodeFlags=" + this.zzbob + ", pausedCount=" + this.zzboc + ", runningCount=" + this.zzbod + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbh.zza(this, paramParcel, paramInt);
  }
  
  Bundle zzGW()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.zzbob.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putInt((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
    }
    return localBundle;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetQueueStateParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */