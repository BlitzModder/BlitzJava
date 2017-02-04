package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<Bucket> CREATOR = new zzc();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  private final int mVersionCode;
  private final long zzQj;
  private final long zzatQ;
  private final Session zzatS;
  private final int zzaua;
  private final List<DataSet> zzaub;
  private final int zzauc;
  private boolean zzaud = false;
  
  Bucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<DataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzatS = paramSession;
    this.zzaua = paramInt2;
    this.zzaub = paramList;
    this.zzauc = paramInt3;
    this.zzaud = paramBoolean;
  }
  
  public Bucket(RawBucket paramRawBucket, List<DataSource> paramList)
  {
    this(2, paramRawBucket.zzQj, paramRawBucket.zzatQ, paramRawBucket.zzatS, paramRawBucket.zzauW, zza(paramRawBucket.zzaub, paramList), paramRawBucket.zzauc, paramRawBucket.zzaud);
  }
  
  private static List<DataSet> zza(Collection<RawDataSet> paramCollection, List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new DataSet((RawDataSet)paramCollection.next(), paramList));
    }
    return localArrayList;
  }
  
  private boolean zza(Bucket paramBucket)
  {
    return (this.zzQj == paramBucket.zzQj) && (this.zzatQ == paramBucket.zzatQ) && (this.zzaua == paramBucket.zzaua) && (zzw.equal(this.zzaub, paramBucket.zzaub)) && (this.zzauc == paramBucket.zzauc) && (this.zzaud == paramBucket.zzaud);
  }
  
  public static String zzeI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bug";
    case 1: 
      return "time";
    case 3: 
      return "type";
    case 4: 
      return "segment";
    case 2: 
      return "session";
    }
    return "unknown";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Bucket)) && (zza((Bucket)paramObject)));
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.zzaua);
  }
  
  public int getBucketType()
  {
    return this.zzauc;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzaub.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaub;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
  }
  
  public Session getSession()
  {
    return this.zzatS;
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
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Integer.valueOf(this.zzaua), Integer.valueOf(this.zzauc) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("activity", Integer.valueOf(this.zzaua)).zzg("dataSets", this.zzaub).zzg("bucketType", zzeI(this.zzauc)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaud)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzb(Bucket paramBucket)
  {
    return (this.zzQj == paramBucket.zzQj) && (this.zzatQ == paramBucket.zzatQ) && (this.zzaua == paramBucket.zzaua) && (this.zzauc == paramBucket.zzauc);
  }
  
  public long zzlx()
  {
    return this.zzQj;
  }
  
  public boolean zztA()
  {
    if (this.zzaud) {
      return true;
    }
    Iterator localIterator = this.zzaub.iterator();
    while (localIterator.hasNext()) {
      if (((DataSet)localIterator.next()).zztA()) {
        return true;
      }
    }
    return false;
  }
  
  public long zztB()
  {
    return this.zzatQ;
  }
  
  public int zztz()
  {
    return this.zzaua;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */