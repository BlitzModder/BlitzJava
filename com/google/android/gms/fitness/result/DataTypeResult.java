package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataTypeResult> CREATOR = new zzg();
  private final int mVersionCode;
  private final Status zzTA;
  private final DataType zzatO;
  
  DataTypeResult(int paramInt, Status paramStatus, DataType paramDataType)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzatO = paramDataType;
  }
  
  public DataTypeResult(Status paramStatus, DataType paramDataType)
  {
    this.mVersionCode = 2;
    this.zzTA = paramStatus;
    this.zzatO = paramDataType;
  }
  
  public static DataTypeResult zzT(Status paramStatus)
  {
    return new DataTypeResult(paramStatus, null);
  }
  
  private boolean zzb(DataTypeResult paramDataTypeResult)
  {
    return (this.zzTA.equals(paramDataTypeResult.zzTA)) && (zzw.equal(this.zzatO, paramDataTypeResult.zzatO));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataTypeResult)) && (zzb((DataTypeResult)paramObject)));
  }
  
  public DataType getDataType()
  {
    return this.zzatO;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzatO });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataType", this.zzatO).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DataTypeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */