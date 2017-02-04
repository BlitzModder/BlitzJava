package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<ReadRawResult> CREATOR = new zzi();
  private final int mVersionCode;
  private final DataHolder zzafC;
  private final List<DataHolder> zzazt;
  
  ReadRawResult(int paramInt, DataHolder paramDataHolder, List<DataHolder> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzafC = paramDataHolder;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.singletonList(paramDataHolder);
    }
    this.zzazt = ((List)localObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return new Status(this.zzafC.getStatusCode());
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  DataHolder zzsA()
  {
    return this.zzafC;
  }
  
  List<DataHolder> zzuM()
  {
    return this.zzazt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/ReadRawResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */