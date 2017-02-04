package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class DataStatsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataStatsResult> CREATOR = new zzf();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<DataSourceStatsResult> zzazr;
  
  DataStatsResult(int paramInt, Status paramStatus, List<DataSourceStatsResult> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzazr = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  List<DataSourceStatsResult> zzuL()
  {
    return this.zzazr;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DataStatsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */