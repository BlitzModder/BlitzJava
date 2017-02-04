package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataSet> CREATOR = new zzo();
  final int mVersionCode;
  public final int zzauX;
  public final int zzauZ;
  public final boolean zzaud;
  public final List<RawDataPoint> zzava;
  
  public RawDataSet(int paramInt1, int paramInt2, int paramInt3, List<RawDataPoint> paramList, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzauX = paramInt2;
    this.zzauZ = paramInt3;
    this.zzava = paramList;
    this.zzaud = paramBoolean;
  }
  
  public RawDataSet(DataSet paramDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = 3;
    this.zzava = paramDataSet.zzt(paramList);
    this.zzaud = paramDataSet.zztA();
    this.zzauX = zzs.zza(paramDataSet.getDataSource(), paramList);
    this.zzauZ = zzs.zza(paramDataSet.getDataType(), paramList1);
  }
  
  private boolean zza(RawDataSet paramRawDataSet)
  {
    return (this.zzauX == paramRawDataSet.zzauX) && (this.zzaud == paramRawDataSet.zzaud) && (zzw.equal(this.zzava, paramRawDataSet.zzava));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataSet)) && (zza((RawDataSet)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzauX) });
  }
  
  public String toString()
  {
    return String.format("RawDataSet{%s@[%s]}", new Object[] { Integer.valueOf(this.zzauX), this.zzava });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */