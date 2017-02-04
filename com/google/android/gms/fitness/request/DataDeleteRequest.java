package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzd();
  private final int mVersionCode;
  private final long zzQj;
  private final long zzatQ;
  private final List<DataType> zzatZ;
  private final zzpp zzayj;
  private final List<DataSource> zzayl;
  private final List<Session> zzaym;
  private final boolean zzayn;
  private final boolean zzayo;
  
  DataDeleteRequest(int paramInt, long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzayl = Collections.unmodifiableList(paramList);
    this.zzatZ = Collections.unmodifiableList(paramList1);
    this.zzaym = paramList2;
    this.zzayn = paramBoolean1;
    this.zzayo = paramBoolean2;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public DataDeleteRequest(long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, zzpp paramzzpp)
  {
    this.mVersionCode = 3;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzayl = Collections.unmodifiableList(paramList);
    this.zzatZ = Collections.unmodifiableList(paramList1);
    this.zzaym = paramList2;
    this.zzayn = paramBoolean1;
    this.zzayo = paramBoolean2;
    this.zzayj = paramzzpp;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), null);
  }
  
  public DataDeleteRequest(DataDeleteRequest paramDataDeleteRequest, zzpp paramzzpp)
  {
    this(paramDataDeleteRequest.zzQj, paramDataDeleteRequest.zzatQ, paramDataDeleteRequest.zzayl, paramDataDeleteRequest.zzatZ, paramDataDeleteRequest.zzaym, paramDataDeleteRequest.zzayn, paramDataDeleteRequest.zzayo, paramzzpp);
  }
  
  private boolean zzb(DataDeleteRequest paramDataDeleteRequest)
  {
    return (this.zzQj == paramDataDeleteRequest.zzQj) && (this.zzatQ == paramDataDeleteRequest.zzatQ) && (zzw.equal(this.zzayl, paramDataDeleteRequest.zzayl)) && (zzw.equal(this.zzatZ, paramDataDeleteRequest.zzatZ)) && (zzw.equal(this.zzaym, paramDataDeleteRequest.zzaym)) && (this.zzayn == paramDataDeleteRequest.zzayn) && (this.zzayo == paramDataDeleteRequest.zzayo);
  }
  
  public boolean deleteAllData()
  {
    return this.zzayn;
  }
  
  public boolean deleteAllSessions()
  {
    return this.zzayo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataDeleteRequest)) && (zzb((DataDeleteRequest)paramObject)));
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
  
  public List<Session> getSessions()
  {
    return this.zzaym;
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
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("startTimeMillis", Long.valueOf(this.zzQj)).zzg("endTimeMillis", Long.valueOf(this.zzatQ)).zzg("dataSources", this.zzayl).zzg("dateTypes", this.zzatZ).zzg("sessions", this.zzaym).zzg("deleteAllData", Boolean.valueOf(this.zzayn)).zzg("deleteAllSessions", Boolean.valueOf(this.zzayo)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
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
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public boolean zzuj()
  {
    return this.zzayn;
  }
  
  public boolean zzuk()
  {
    return this.zzayo;
  }
  
  public static class Builder
  {
    private long zzQj;
    private long zzatQ;
    private List<DataType> zzatZ = new ArrayList();
    private List<DataSource> zzayl = new ArrayList();
    private List<Session> zzaym = new ArrayList();
    private boolean zzayn = false;
    private boolean zzayo = false;
    
    private void zzul()
    {
      if (this.zzaym.isEmpty()) {
        return;
      }
      Iterator localIterator = this.zzaym.iterator();
      label23:
      Session localSession;
      if (localIterator.hasNext())
      {
        localSession = (Session)localIterator.next();
        if ((localSession.getStartTime(TimeUnit.MILLISECONDS) < this.zzQj) || (localSession.getEndTime(TimeUnit.MILLISECONDS) > this.zzatQ)) {
          break label111;
        }
      }
      label111:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Session %s is outside the time interval [%d, %d]", new Object[] { localSession, Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ) });
        break label23;
        break;
      }
    }
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool2 = true;
      if (!this.zzayn)
      {
        bool1 = true;
        zzx.zzb(bool1, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
        if (paramDataSource == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Must specify a valid data source");
        if (!this.zzayl.contains(paramDataSource)) {
          this.zzayl.add(paramDataSource);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool2 = true;
      if (!this.zzayn)
      {
        bool1 = true;
        zzx.zzb(bool1, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
        if (paramDataType == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Must specify a valid data type");
        if (!this.zzatZ.contains(paramDataType)) {
          this.zzatZ.add(paramDataType);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool2 = true;
      if (!this.zzayo)
      {
        bool1 = true;
        zzx.zzb(bool1, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
        if (paramSession == null) {
          break label67;
        }
        bool1 = true;
        label23:
        zzx.zzb(bool1, "Must specify a valid session");
        if (paramSession.getEndTime(TimeUnit.MILLISECONDS) <= 0L) {
          break label72;
        }
      }
      label67:
      label72:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
        this.zzaym.add(paramSession);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label23;
      }
    }
    
    public DataDeleteRequest build()
    {
      boolean bool2 = false;
      boolean bool1;
      int i;
      if ((this.zzQj > 0L) && (this.zzatQ > this.zzQj))
      {
        bool1 = true;
        zzx.zza(bool1, "Must specify a valid time interval");
        if ((!this.zzayn) && (this.zzayl.isEmpty()) && (this.zzatZ.isEmpty())) {
          break label124;
        }
        i = 1;
        label65:
        if ((!this.zzayo) && (this.zzaym.isEmpty())) {
          break label129;
        }
      }
      label124:
      label129:
      for (int j = 1;; j = 0)
      {
        if (i == 0)
        {
          bool1 = bool2;
          if (j == 0) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "No data or session marked for deletion");
        zzul();
        return new DataDeleteRequest(this, null);
        bool1 = false;
        break;
        i = 0;
        break label65;
      }
    }
    
    public Builder deleteAllData()
    {
      zzx.zzb(this.zzatZ.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
      zzx.zzb(this.zzayl.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
      this.zzayn = true;
      return this;
    }
    
    public Builder deleteAllSessions()
    {
      zzx.zzb(this.zzaym.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
      this.zzayo = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      if (paramLong1 > 0L)
      {
        bool = true;
        zzx.zzb(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 <= paramLong1) {
          break label82;
        }
      }
      label82:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
        this.zzQj = paramTimeUnit.toMillis(paramLong1);
        this.zzatQ = paramTimeUnit.toMillis(paramLong2);
        return this;
        bool = false;
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataDeleteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */