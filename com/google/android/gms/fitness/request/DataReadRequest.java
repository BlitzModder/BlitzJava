package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpa.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DataReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();
  public static final int NO_LIMIT = 0;
  private final int mVersionCode;
  private final long zzQj;
  private final long zzatQ;
  private final List<DataType> zzatZ;
  private final int zzauc;
  private final List<DataSource> zzayl;
  private final List<DataType> zzayq;
  private final List<DataSource> zzayr;
  private final long zzays;
  private final DataSource zzayt;
  private final int zzayu;
  private final boolean zzayv;
  private final boolean zzayw;
  private final zzpa zzayx;
  private final List<Device> zzayy;
  
  DataReadRequest(int paramInt1, List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt2, long paramLong3, DataSource paramDataSource, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder, List<Device> paramList)
  {
    this.mVersionCode = paramInt1;
    this.zzatZ = paramList1;
    this.zzayl = paramList2;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzayq = paramList3;
    this.zzayr = paramList4;
    this.zzauc = paramInt2;
    this.zzays = paramLong3;
    this.zzayt = paramDataSource;
    this.zzayu = paramInt3;
    this.zzayv = paramBoolean1;
    this.zzayw = paramBoolean2;
    if (paramIBinder == null) {}
    for (paramList1 = null;; paramList1 = zzpa.zza.zzbC(paramIBinder))
    {
      this.zzayx = paramList1;
      paramList1 = paramList;
      if (paramList == null) {
        paramList1 = Collections.emptyList();
      }
      this.zzayy = paramList1;
      return;
    }
  }
  
  private DataReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), Builder.zzj(paramBuilder), Builder.zzk(paramBuilder), Builder.zzl(paramBuilder), null, Builder.zzm(paramBuilder));
  }
  
  public DataReadRequest(DataReadRequest paramDataReadRequest, zzpa paramzzpa)
  {
    this(paramDataReadRequest.zzatZ, paramDataReadRequest.zzayl, paramDataReadRequest.zzQj, paramDataReadRequest.zzatQ, paramDataReadRequest.zzayq, paramDataReadRequest.zzayr, paramDataReadRequest.zzauc, paramDataReadRequest.zzays, paramDataReadRequest.zzayt, paramDataReadRequest.zzayu, paramDataReadRequest.zzayv, paramDataReadRequest.zzayw, paramzzpa, paramDataReadRequest.zzayy);
  }
  
  public DataReadRequest(List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt1, long paramLong3, DataSource paramDataSource, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, zzpa paramzzpa, List<Device> paramList) {}
  
  private boolean zzb(DataReadRequest paramDataReadRequest)
  {
    return (this.zzatZ.equals(paramDataReadRequest.zzatZ)) && (this.zzayl.equals(paramDataReadRequest.zzayl)) && (this.zzQj == paramDataReadRequest.zzQj) && (this.zzatQ == paramDataReadRequest.zzatQ) && (this.zzauc == paramDataReadRequest.zzauc) && (this.zzayr.equals(paramDataReadRequest.zzayr)) && (this.zzayq.equals(paramDataReadRequest.zzayq)) && (zzw.equal(this.zzayt, paramDataReadRequest.zzayt)) && (this.zzays == paramDataReadRequest.zzays) && (this.zzayw == paramDataReadRequest.zzayw);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadRequest)) && (zzb((DataReadRequest)paramObject)));
  }
  
  public DataSource getActivityDataSource()
  {
    return this.zzayt;
  }
  
  public List<DataSource> getAggregatedDataSources()
  {
    return this.zzayr;
  }
  
  public List<DataType> getAggregatedDataTypes()
  {
    return this.zzayq;
  }
  
  public long getBucketDuration(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzays, TimeUnit.MILLISECONDS);
  }
  
  public int getBucketType()
  {
    return this.zzauc;
  }
  
  public List<DataSource> getDataSources()
  {
    return this.zzayl;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzatZ;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
  }
  
  public int getLimit()
  {
    return this.zzayu;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzauc), Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReadRequest{");
    Iterator localIterator;
    if (!this.zzatZ.isEmpty())
    {
      localIterator = this.zzatZ.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).zztM()).append(" ");
      }
    }
    if (!this.zzayl.isEmpty())
    {
      localIterator = this.zzayl.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    if (this.zzauc != 0)
    {
      localStringBuilder.append("bucket by ").append(Bucket.zzeI(this.zzauc));
      if (this.zzays > 0L) {
        localStringBuilder.append(" >").append(this.zzays).append("ms");
      }
      localStringBuilder.append(": ");
    }
    if (!this.zzayq.isEmpty())
    {
      localIterator = this.zzayq.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).zztM()).append(" ");
      }
    }
    if (!this.zzayr.isEmpty())
    {
      localIterator = this.zzayr.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    localStringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[] { Long.valueOf(this.zzQj), Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Long.valueOf(this.zzatQ) }));
    if (this.zzayt != null) {
      localStringBuilder.append("activities: ").append(this.zzayt.toDebugString());
    }
    if (this.zzayw) {
      localStringBuilder.append(" +server");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public long zzlx()
  {
    return this.zzQj;
  }
  
  public long zztB()
  {
    return this.zzatQ;
  }
  
  public IBinder zzui()
  {
    if (this.zzayx == null) {
      return null;
    }
    return this.zzayx.asBinder();
  }
  
  public boolean zzun()
  {
    return this.zzayw;
  }
  
  public boolean zzuo()
  {
    return this.zzayv;
  }
  
  public long zzup()
  {
    return this.zzays;
  }
  
  public List<Device> zzuq()
  {
    return this.zzayy;
  }
  
  public static class Builder
  {
    private long zzQj;
    private long zzatQ;
    private List<DataType> zzatZ = new ArrayList();
    private int zzauc = 0;
    private List<DataSource> zzayl = new ArrayList();
    private List<DataType> zzayq = new ArrayList();
    private List<DataSource> zzayr = new ArrayList();
    private long zzays = 0L;
    private DataSource zzayt;
    private int zzayu = 0;
    private boolean zzayv = false;
    private boolean zzayw = false;
    private List<Device> zzayy = new ArrayList();
    
    public Builder aggregate(DataSource paramDataSource, DataType paramDataType)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzayl.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data source for aggregated and detailed");
        DataType localDataType = paramDataSource.getDataType();
        zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(localDataType), "Unsupported input data type specified for aggregation: %s", new Object[] { localDataType });
        zzx.zzb(DataType.getAggregatesForInput(localDataType).contains(paramDataType), "Invalid output aggregate data type specified: %s -> %s", new Object[] { localDataType, paramDataType });
        if (!this.zzayr.contains(paramDataSource)) {
          this.zzayr.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder aggregate(DataType paramDataType1, DataType paramDataType2)
    {
      zzx.zzb(paramDataType1, "Attempting to use a null data type");
      if (!this.zzatZ.contains(paramDataType1)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data type as aggregated and detailed");
        zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(paramDataType1), "Unsupported input data type specified for aggregation: %s", new Object[] { paramDataType1 });
        zzx.zzb(DataType.getAggregatesForInput(paramDataType1).contains(paramDataType2), "Invalid output aggregate data type specified: %s -> %s", new Object[] { paramDataType1, paramDataType2 });
        if (!this.zzayq.contains(paramDataType1)) {
          this.zzayq.add(paramDataType1);
        }
        return this;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzauc = 4;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid activity data source specified");
        zzx.zzb(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.zzayt = paramDataSource;
        this.zzauc = 4;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzauc = 3;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid activity data source specified");
        zzx.zzb(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.zzayt = paramDataSource;
        this.zzauc = 3;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketBySession(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzauc = 2;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByTime(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzauc == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzauc) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzauc = 1;
        this.zzays = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public DataReadRequest build()
    {
      boolean bool2 = true;
      label69:
      label112:
      int i;
      if ((!this.zzayl.isEmpty()) || (!this.zzatZ.isEmpty()) || (!this.zzayr.isEmpty()) || (!this.zzayq.isEmpty()))
      {
        bool1 = true;
        zzx.zza(bool1, "Must add at least one data source (aggregated or detailed)");
        if (this.zzQj <= 0L) {
          break label205;
        }
        bool1 = true;
        zzx.zza(bool1, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzQj) });
        if ((this.zzatQ <= 0L) || (this.zzatQ <= this.zzQj)) {
          break label210;
        }
        bool1 = true;
        zzx.zza(bool1, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzatQ) });
        if ((!this.zzayr.isEmpty()) || (!this.zzayq.isEmpty())) {
          break label215;
        }
        i = 1;
        label158:
        if (i != 0)
        {
          bool1 = bool2;
          if (this.zzauc == 0) {}
        }
        else
        {
          if ((i != 0) || (this.zzauc == 0)) {
            break label220;
          }
        }
      }
      label205:
      label210:
      label215:
      label220:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
        return new DataReadRequest(this, null);
        bool1 = false;
        break;
        bool1 = false;
        break label69;
        bool1 = false;
        break label112;
        i = 0;
        break label158;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.zzayw = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzayr.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot add the same data source as aggregated and detailed");
        if (!this.zzayl.contains(paramDataSource)) {
          this.zzayl.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder read(DataType paramDataType)
    {
      zzx.zzb(paramDataType, "Attempting to use a null data type");
      if (!this.zzayq.contains(paramDataType)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data type as aggregated and detailed");
        if (!this.zzatZ.contains(paramDataType)) {
          this.zzatZ.add(paramDataType);
        }
        return this;
      }
    }
    
    public Builder setLimit(int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid limit %d is specified", new Object[] { Integer.valueOf(paramInt) });
        this.zzayu = paramInt;
        return this;
      }
    }
    
    public Builder setTimeRange(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzQj = paramTimeUnit.toMillis(paramLong1);
      this.zzatQ = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */