package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzol;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataPoint> CREATOR = new zzd();
  private final int mVersionCode;
  private final DataSource zzatP;
  private long zzaue;
  private long zzauf;
  private final Value[] zzaug;
  private DataSource zzauh;
  private long zzaui;
  private long zzauj;
  
  DataPoint(int paramInt, DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4)
  {
    this.mVersionCode = paramInt;
    this.zzatP = paramDataSource1;
    this.zzauh = paramDataSource2;
    this.zzaue = paramLong1;
    this.zzauf = paramLong2;
    this.zzaug = paramArrayOfValue;
    this.zzaui = paramLong3;
    this.zzauj = paramLong4;
  }
  
  private DataPoint(DataSource paramDataSource)
  {
    this.mVersionCode = 4;
    this.zzatP = ((DataSource)zzx.zzb(paramDataSource, "Data source cannot be null"));
    paramDataSource = paramDataSource.getDataType().getFields();
    this.zzaug = new Value[paramDataSource.size()];
    paramDataSource = paramDataSource.iterator();
    int i = 0;
    while (paramDataSource.hasNext())
    {
      Field localField = (Field)paramDataSource.next();
      this.zzaug[i] = new Value(localField.getFormat());
      i += 1;
    }
  }
  
  public DataPoint(DataSource paramDataSource1, DataSource paramDataSource2, RawDataPoint paramRawDataPoint)
  {
    this(4, paramDataSource1, zza(Long.valueOf(paramRawDataPoint.zzaue), 0L), zza(Long.valueOf(paramRawDataPoint.zzauf), 0L), paramRawDataPoint.zzaug, paramDataSource2, zza(Long.valueOf(paramRawDataPoint.zzaui), 0L), zza(Long.valueOf(paramRawDataPoint.zzauj), 0L));
  }
  
  DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint)
  {
    this(zza(paramList, paramRawDataPoint.zzauX), zza(paramList, paramRawDataPoint.zzauY), paramRawDataPoint);
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)zzc.zza(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  private static long zza(Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      paramLong1 = paramLong.longValue();
    }
    return paramLong1;
  }
  
  private static DataSource zza(List<DataSource> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private boolean zza(DataPoint paramDataPoint)
  {
    return (zzw.equal(this.zzatP, paramDataPoint.zzatP)) && (this.zzaue == paramDataPoint.zzaue) && (this.zzauf == paramDataPoint.zzauf) && (Arrays.equals(this.zzaug, paramDataPoint.zzaug)) && (zzw.equal(this.zzauh, paramDataPoint.zzauh));
  }
  
  private void zzeK(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    if (paramInt == i) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Attempting to insert %s values, but needed %s: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localList });
      return;
    }
  }
  
  private boolean zztC()
  {
    return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataPoint)) && (zza((DataPoint)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  public DataType getDataType()
  {
    return this.zzatP.getDataType();
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzaue, TimeUnit.NANOSECONDS);
  }
  
  public DataSource getOriginalDataSource()
  {
    return this.zzauh;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzauf, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestamp(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzaue, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestampNanos()
  {
    return this.zzaue;
  }
  
  public Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return this.zzaug[i];
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP, Long.valueOf(this.zzaue), Long.valueOf(this.zzauf) });
  }
  
  public DataPoint setFloatValues(float... paramVarArgs)
  {
    zzeK(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaug[i].setFloat(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setIntValues(int... paramVarArgs)
  {
    zzeK(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaug[i].setInt(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.zzauf = paramTimeUnit.toNanos(paramLong1);
    this.zzaue = paramTimeUnit.toNanos(paramLong2);
    return this;
  }
  
  public DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    this.zzaue = paramTimeUnit.toNanos(paramLong);
    if ((zztC()) && (zzol.zza(paramTimeUnit)))
    {
      Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
      this.zzaue = zzol.zza(this.zzaue, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
    }
    return this;
  }
  
  public String toString()
  {
    String str2 = Arrays.toString(this.zzaug);
    long l1 = this.zzauf;
    long l2 = this.zzaue;
    long l3 = this.zzaui;
    long l4 = this.zzauj;
    String str3 = this.zzatP.toDebugString();
    if (this.zzauh != null) {}
    for (String str1 = this.zzauh.toDebugString();; str1 = "N/A") {
      return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[] { str2, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), str3, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Value[] zztD()
  {
    return this.zzaug;
  }
  
  public long zztE()
  {
    return this.zzaui;
  }
  
  public long zztF()
  {
    return this.zzauj;
  }
  
  public void zztG()
  {
    DataSource localDataSource = getDataSource();
    zzx.zzb(getDataType().getName().equals(localDataSource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] { getDataType(), getDataType() });
    if (this.zzaue > 0L)
    {
      bool = true;
      zzx.zzb(bool, "Data point does not have the timestamp set: %s", new Object[] { this });
      if (this.zzauf > this.zzaue) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Data point with start time greater than end time found: %s", new Object[] { this });
      return;
      bool = false;
      break;
    }
  }
  
  public long zztH()
  {
    return this.zzauf;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */