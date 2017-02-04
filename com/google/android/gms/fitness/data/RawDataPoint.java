package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzn();
  final int mVersionCode;
  public final int zzauX;
  public final int zzauY;
  public final long zzaue;
  public final long zzauf;
  public final Value[] zzaug;
  public final long zzaui;
  public final long zzauj;
  
  public RawDataPoint(int paramInt1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.mVersionCode = paramInt1;
    this.zzaue = paramLong1;
    this.zzauf = paramLong2;
    this.zzauX = paramInt2;
    this.zzauY = paramInt3;
    this.zzaui = paramLong3;
    this.zzauj = paramLong4;
    this.zzaug = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList)
  {
    this.mVersionCode = 4;
    this.zzaue = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
    this.zzauf = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
    this.zzaug = paramDataPoint.zztD();
    this.zzauX = zzs.zza(paramDataPoint.getDataSource(), paramList);
    this.zzauY = zzs.zza(paramDataPoint.getOriginalDataSource(), paramList);
    this.zzaui = paramDataPoint.zztE();
    this.zzauj = paramDataPoint.zztF();
  }
  
  private boolean zza(RawDataPoint paramRawDataPoint)
  {
    return (this.zzaue == paramRawDataPoint.zzaue) && (this.zzauf == paramRawDataPoint.zzauf) && (Arrays.equals(this.zzaug, paramRawDataPoint.zzaug)) && (this.zzauX == paramRawDataPoint.zzauX) && (this.zzauY == paramRawDataPoint.zzauY) && (this.zzaui == paramRawDataPoint.zzaui);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataPoint)) && (zza((RawDataPoint)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzaue), Long.valueOf(this.zzauf) });
  }
  
  public String toString()
  {
    return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] { Arrays.toString(this.zzaug), Long.valueOf(this.zzauf), Long.valueOf(this.zzaue), Integer.valueOf(this.zzauX), Integer.valueOf(this.zzauY) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */