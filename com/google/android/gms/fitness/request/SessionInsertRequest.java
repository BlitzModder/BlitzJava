package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzu();
  private final int mVersionCode;
  private final Session zzatS;
  private final List<DataSet> zzaub;
  private final List<DataPoint> zzayY;
  private final zzpp zzayj;
  
  SessionInsertRequest(int paramInt, Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzatS = paramSession;
    this.zzaub = Collections.unmodifiableList(paramList);
    this.zzayY = Collections.unmodifiableList(paramList1);
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public SessionInsertRequest(Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, zzpp paramzzpp)
  {
    this.mVersionCode = 3;
    this.zzatS = paramSession;
    this.zzaub = Collections.unmodifiableList(paramList);
    this.zzayY = Collections.unmodifiableList(paramList1);
    this.zzayj = paramzzpp;
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public SessionInsertRequest(SessionInsertRequest paramSessionInsertRequest, zzpp paramzzpp)
  {
    this(paramSessionInsertRequest.zzatS, paramSessionInsertRequest.zzaub, paramSessionInsertRequest.zzayY, paramzzpp);
  }
  
  private boolean zzb(SessionInsertRequest paramSessionInsertRequest)
  {
    return (zzw.equal(this.zzatS, paramSessionInsertRequest.zzatS)) && (zzw.equal(this.zzaub, paramSessionInsertRequest.zzaub)) && (zzw.equal(this.zzayY, paramSessionInsertRequest.zzayY));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionInsertRequest)) && (zzb((SessionInsertRequest)paramObject)));
  }
  
  public List<DataPoint> getAggregateDataPoints()
  {
    return this.zzayY;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaub;
  }
  
  public Session getSession()
  {
    return this.zzatS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatS, this.zzaub, this.zzayY });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("session", this.zzatS).zzg("dataSets", this.zzaub).zzg("aggregateDataPoints", this.zzayY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public static class Builder
  {
    private Session zzatS;
    private List<DataSet> zzaub = new ArrayList();
    private List<DataPoint> zzayY = new ArrayList();
    private List<DataSource> zzayZ = new ArrayList();
    
    private void zze(DataPoint paramDataPoint)
    {
      zzg(paramDataPoint);
      zzf(paramDataPoint);
    }
    
    private void zzf(DataPoint paramDataPoint)
    {
      long l3 = this.zzatS.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = this.zzatS.getEndTime(TimeUnit.NANOSECONDS);
      long l5 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
      long l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      long l1;
      if ((l5 != 0L) && (l2 != 0L))
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        l1 = l2;
        if (l2 > l4) {
          l1 = zzol.zza(l2, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l5 < l3) || (l1 > l4)) {
          break label196;
        }
      }
      label196:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (l1 != paramDataPoint.getEndTime(TimeUnit.NANOSECONDS))
        {
          Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(l1), localTimeUnit }));
          paramDataPoint.setTimeInterval(l5, l1, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void zzg(DataPoint paramDataPoint)
    {
      long l3 = this.zzatS.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = this.zzatS.getEndTime(TimeUnit.NANOSECONDS);
      long l2 = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      long l1;
      if (l2 != 0L)
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        if (l2 >= l3)
        {
          l1 = l2;
          if (l2 <= l4) {}
        }
        else
        {
          l1 = zzol.zza(l2, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l1 < l3) || (l1 > l4)) {
          break label185;
        }
      }
      label185:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS) != l1)
        {
          Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(l1), localTimeUnit }));
          paramDataPoint.setTimestamp(l1, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void zzuB()
    {
      Iterator localIterator1 = this.zzaub.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((DataSet)localIterator1.next()).getDataPoints().iterator();
        while (localIterator2.hasNext()) {
          zze((DataPoint)localIterator2.next());
        }
      }
      localIterator1 = this.zzayY.iterator();
      while (localIterator1.hasNext()) {
        zze((DataPoint)localIterator1.next());
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      label44:
      DataSource localDataSource;
      if (paramDataPoint != null)
      {
        bool = true;
        zzx.zzb(bool, "Must specify a valid aggregate data point.");
        long l1 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
        long l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
        if ((l1 <= 0L) || (l2 <= l1)) {
          break label125;
        }
        bool = true;
        zzx.zzb(bool, "Aggregate data point should have valid start and end times: %s", new Object[] { paramDataPoint });
        localDataSource = paramDataPoint.getDataSource();
        if (this.zzayZ.contains(localDataSource)) {
          break label130;
        }
      }
      label125:
      label130:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
        this.zzayZ.add(localDataSource);
        this.zzayY.add(paramDataPoint);
        return this;
        bool = false;
        break;
        bool = false;
        break label44;
      }
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool2 = true;
      DataSource localDataSource;
      if (paramDataSet != null)
      {
        bool1 = true;
        zzx.zzb(bool1, "Must specify a valid data set.");
        localDataSource = paramDataSet.getDataSource();
        if (this.zzayZ.contains(localDataSource)) {
          break label101;
        }
        bool1 = true;
        label36:
        zzx.zza(bool1, "Data set for this data source %s is already added.", new Object[] { localDataSource });
        if (paramDataSet.getDataPoints().isEmpty()) {
          break label106;
        }
      }
      label101:
      label106:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "No data points specified in the input data set.");
        this.zzayZ.add(localDataSource);
        this.zzaub.add(paramDataSet);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label36;
      }
    }
    
    public SessionInsertRequest build()
    {
      boolean bool2 = true;
      if (this.zzatS != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must specify a valid session.");
        if (this.zzatS.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
          break label59;
        }
      }
      label59:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify a valid end time, cannot insert a continuing session.");
        zzuB();
        return new SessionInsertRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setSession(Session paramSession)
    {
      this.zzatS = paramSession;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */