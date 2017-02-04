package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourceQueryParams> CREATOR = new zzg();
  final int mVersionCode;
  public final long zzTC;
  public final DataSource zzatP;
  public final long zzauf;
  public final int zzayA;
  public final int zzayu;
  public final long zzayz;
  
  DataSourceQueryParams(int paramInt1, DataSource paramDataSource, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzatP = paramDataSource;
    this.zzTC = paramLong1;
    this.zzauf = paramLong2;
    this.zzayz = paramLong3;
    this.zzayu = paramInt2;
    this.zzayA = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataSourceQueryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */