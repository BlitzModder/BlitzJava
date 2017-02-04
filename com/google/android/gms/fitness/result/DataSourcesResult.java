package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zze();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<DataSource> zzayl;
  
  DataSourcesResult(int paramInt, List<DataSource> paramList, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzayl = Collections.unmodifiableList(paramList);
    this.zzTA = paramStatus;
  }
  
  public DataSourcesResult(List<DataSource> paramList, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzayl = Collections.unmodifiableList(paramList);
    this.zzTA = paramStatus;
  }
  
  public static DataSourcesResult zzS(Status paramStatus)
  {
    return new DataSourcesResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean zzb(DataSourcesResult paramDataSourcesResult)
  {
    return (this.zzTA.equals(paramDataSourcesResult.zzTA)) && (zzw.equal(this.zzayl, paramDataSourcesResult.zzayl));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSourcesResult)) && (zzb((DataSourcesResult)paramObject)));
  }
  
  public List<DataSource> getDataSources()
  {
    return this.zzayl;
  }
  
  public List<DataSource> getDataSources(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzayl.iterator();
    while (localIterator.hasNext())
    {
      DataSource localDataSource = (DataSource)localIterator.next();
      if (localDataSource.getDataType().equals(paramDataType)) {
        localArrayList.add(localDataSource);
      }
    }
    return Collections.unmodifiableList(localArrayList);
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
    return zzw.hashCode(new Object[] { this.zzTA, this.zzayl });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataSets", this.zzayl).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/DataSourcesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */