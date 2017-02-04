package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawBucket> CREATOR = new zzm();
  final int mVersionCode;
  public final long zzQj;
  public final long zzatQ;
  public final Session zzatS;
  public final int zzauW;
  public final List<RawDataSet> zzaub;
  public final int zzauc;
  public final boolean zzaud;
  
  public RawBucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<RawDataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzatS = paramSession;
    this.zzauW = paramInt2;
    this.zzaub = paramList;
    this.zzauc = paramInt3;
    this.zzaud = paramBoolean;
  }
  
  public RawBucket(Bucket paramBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = 2;
    this.zzQj = paramBucket.getStartTime(TimeUnit.MILLISECONDS);
    this.zzatQ = paramBucket.getEndTime(TimeUnit.MILLISECONDS);
    this.zzatS = paramBucket.getSession();
    this.zzauW = paramBucket.zztz();
    this.zzauc = paramBucket.getBucketType();
    this.zzaud = paramBucket.zztA();
    paramBucket = paramBucket.getDataSets();
    this.zzaub = new ArrayList(paramBucket.size());
    paramBucket = paramBucket.iterator();
    while (paramBucket.hasNext())
    {
      DataSet localDataSet = (DataSet)paramBucket.next();
      this.zzaub.add(new RawDataSet(localDataSet, paramList, paramList1));
    }
  }
  
  private boolean zza(RawBucket paramRawBucket)
  {
    return (this.zzQj == paramRawBucket.zzQj) && (this.zzatQ == paramRawBucket.zzatQ) && (this.zzauW == paramRawBucket.zzauW) && (zzw.equal(this.zzaub, paramRawBucket.zzaub)) && (this.zzauc == paramRawBucket.zzauc) && (this.zzaud == paramRawBucket.zzaud);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawBucket)) && (zza((RawBucket)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Integer.valueOf(this.zzauc) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("activity", Integer.valueOf(this.zzauW)).zzg("dataSets", this.zzaub).zzg("bucketType", Integer.valueOf(this.zzauc)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaud)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/RawBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */