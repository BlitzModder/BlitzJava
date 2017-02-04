package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<DataSet> zzaub;
  private final List<DataSource> zzaul;
  private final List<Bucket> zzazl;
  private int zzazm;
  private final List<DataType> zzazn;
  
  DataReadResult(int paramInt1, List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt2, List<DataSource> paramList2, List<DataType> paramList3)
  {
    this.mVersionCode = paramInt1;
    this.zzTA = paramStatus;
    this.zzazm = paramInt2;
    this.zzaul = paramList2;
    this.zzazn = paramList3;
    this.zzaub = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawDataSet)paramList.next();
      this.zzaub.add(new DataSet(paramStatus, paramList2));
    }
    this.zzazl = new ArrayList(paramList1.size());
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawBucket)paramList.next();
      this.zzazl.add(new Bucket(paramStatus, paramList2));
    }
  }
  
  public DataReadResult(List<DataSet> paramList, List<Bucket> paramList1, Status paramStatus)
  {
    this.mVersionCode = 5;
    this.zzaub = paramList;
    this.zzTA = paramStatus;
    this.zzazl = paramList1;
    this.zzazm = 1;
    this.zzaul = new ArrayList();
    this.zzazn = new ArrayList();
  }
  
  public static DataReadResult zza(Status paramStatus, DataReadRequest paramDataReadRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramDataReadRequest.getDataSources().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(DataSet.create((DataSource)((Iterator)localObject).next()));
    }
    paramDataReadRequest = paramDataReadRequest.getDataTypes().iterator();
    while (paramDataReadRequest.hasNext())
    {
      localObject = (DataType)paramDataReadRequest.next();
      localArrayList.add(DataSet.create(new DataSource.Builder().setDataType((DataType)localObject).setType(1).setName("Default").build()));
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  private void zza(Bucket paramBucket, List<Bucket> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Bucket)localIterator.next();
      if (paramList.zzb(paramBucket))
      {
        paramBucket = paramBucket.getDataSets().iterator();
        while (paramBucket.hasNext()) {
          zza((DataSet)paramBucket.next(), paramList.getDataSets());
        }
      }
    }
    this.zzazl.add(paramBucket);
  }
  
  private void zza(DataSet paramDataSet, List<DataSet> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.zzb(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  private boolean zzc(DataReadResult paramDataReadResult)
  {
    return (this.zzTA.equals(paramDataReadResult.zzTA)) && (zzw.equal(this.zzaub, paramDataReadResult.zzaub)) && (zzw.equal(this.zzazl, paramDataReadResult.zzazl));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadResult)) && (zzc((DataReadResult)paramObject)));
  }
  
  public List<Bucket> getBuckets()
  {
    return this.zzazl;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = this.zzaub.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    return DataSet.create(paramDataSource);
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzaub.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    return DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build());
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaub;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzaub, this.zzazl });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this).zzg("status", this.zzTA);
    if (this.zzaub.size() > 5)
    {
      localObject = this.zzaub.size() + " data sets";
      localzza = localzza.zzg("dataSets", localObject);
      if (this.zzazl.size() <= 5) {
        break label123;
      }
    }
    label123:
    for (Object localObject = this.zzazl.size() + " buckets";; localObject = this.zzazl)
    {
      return localzza.zzg("buckets", localObject).toString();
      localObject = this.zzaub;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public void zzb(DataReadResult paramDataReadResult)
  {
    Iterator localIterator = paramDataReadResult.getDataSets().iterator();
    while (localIterator.hasNext()) {
      zza((DataSet)localIterator.next(), this.zzaub);
    }
    paramDataReadResult = paramDataReadResult.getBuckets().iterator();
    while (paramDataReadResult.hasNext()) {
      zza((Bucket)paramDataReadResult.next(), this.zzazl);
    }
  }
  
  List<DataSource> zztJ()
  {
    return this.zzaul;
  }
  
  public int zzuH()
  {
    return this.zzazm;
  }
  
  List<RawBucket> zzuI()
  {
    ArrayList localArrayList = new ArrayList(this.zzazl.size());
    Iterator localIterator = this.zzazl.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), this.zzaul, this.zzazn));
    }
    return localArrayList;
  }
  
  List<RawDataSet> zzuJ()
  {
    ArrayList localArrayList = new ArrayList(this.zzaub.size());
    Iterator localIterator = this.zzaub.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), this.zzaul, this.zzazn));
    }
    return localArrayList;
  }
  
  List<DataType> zzuK()
  {
    return this.zzazn;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DataReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */