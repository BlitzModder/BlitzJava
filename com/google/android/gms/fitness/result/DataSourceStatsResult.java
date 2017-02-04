package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourceStatsResult> CREATOR = new zzd();
  final int mVersionCode;
  public final long zzTC;
  public final DataSource zzatP;
  public final boolean zzazo;
  public final long zzazp;
  public final long zzazq;
  
  DataSourceStatsResult(int paramInt, DataSource paramDataSource, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.mVersionCode = paramInt;
    this.zzatP = paramDataSource;
    this.zzTC = paramLong1;
    this.zzazo = paramBoolean;
    this.zzazp = paramLong2;
    this.zzazq = paramLong3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DataSourceStatsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */