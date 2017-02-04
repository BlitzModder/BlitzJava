package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class FitnessUnregistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessUnregistrationRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final DataSource zzatP;
  
  FitnessUnregistrationRequest(int paramInt, DataSource paramDataSource)
  {
    this.mVersionCode = paramInt;
    this.zzatP = paramDataSource;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return String.format("ApplicationUnregistrationRequest{%s}", new Object[] { this.zzatP });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/internal/service/FitnessUnregistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */