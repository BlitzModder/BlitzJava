package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
  private final int mVersionCode;
  private final Status zzTA;
  private final DataSet zzave;
  
  DailyTotalResult(int paramInt, Status paramStatus, DataSet paramDataSet)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzave = paramDataSet;
  }
  
  public DailyTotalResult(DataSet paramDataSet, Status paramStatus)
  {
    this.mVersionCode = 1;
    this.zzTA = paramStatus;
    this.zzave = paramDataSet;
  }
  
  public static DailyTotalResult zza(Status paramStatus, DataType paramDataType)
  {
    return new DailyTotalResult(DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build()), paramStatus);
  }
  
  private boolean zzb(DailyTotalResult paramDailyTotalResult)
  {
    return (this.zzTA.equals(paramDailyTotalResult.zzTA)) && (zzw.equal(this.zzave, paramDailyTotalResult.zzave));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DailyTotalResult)) && (zzb((DailyTotalResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public DataSet getTotal()
  {
    return this.zzave;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzave });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataPoint", this.zzave).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DailyTotalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */