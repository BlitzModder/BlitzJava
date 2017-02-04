package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class FitnessDataSourcesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessDataSourcesRequest> CREATOR = new zza();
  private final int mVersionCode;
  private final List<DataType> zzatZ;
  
  FitnessDataSourcesRequest(int paramInt, List<DataType> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzatZ = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.zzatZ);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("dataTypes", this.zzatZ).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/internal/service/FitnessDataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */