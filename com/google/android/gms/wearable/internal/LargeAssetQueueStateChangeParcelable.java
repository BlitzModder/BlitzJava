package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzd;

public final class LargeAssetQueueStateChangeParcelable
  implements SafeParcelable, LargeAssetApi.zzd
{
  public static final Parcelable.Creator<LargeAssetQueueStateChangeParcelable> CREATOR = new zzbg();
  final int mVersionCode;
  private final zzbt zzbnW;
  final DataHolder zzbnX;
  private final LargeAssetQueueStateParcelable zzbnY;
  
  LargeAssetQueueStateChangeParcelable(int paramInt, DataHolder paramDataHolder, LargeAssetQueueStateParcelable paramLargeAssetQueueStateParcelable)
  {
    this.mVersionCode = paramInt;
    this.zzbnX = ((DataHolder)zzx.zzy(paramDataHolder));
    this.zzbnW = new zzbt(paramDataHolder);
    this.zzbnY = ((LargeAssetQueueStateParcelable)zzx.zzy(paramLargeAssetQueueStateParcelable));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void release()
  {
    this.zzbnW.release();
  }
  
  public String toString()
  {
    return "LargeAssetQueueStateChangeParcelable{queueEntryBuffer=" + this.zzbnW + ", queueState=" + this.zzbnY + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbg.zza(this, paramParcel, paramInt);
  }
  
  public LargeAssetQueueStateParcelable zzGV()
  {
    return this.zzbnY;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetQueueStateChangeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */