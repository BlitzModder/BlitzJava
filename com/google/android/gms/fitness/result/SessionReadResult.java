package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzj();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<Session> zzaym;
  private final List<SessionDataSet> zzazu;
  
  SessionReadResult(int paramInt, List<Session> paramList, List<SessionDataSet> paramList1, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzaym = paramList;
    this.zzazu = Collections.unmodifiableList(paramList1);
    this.zzTA = paramStatus;
  }
  
  public SessionReadResult(List<Session> paramList, List<SessionDataSet> paramList1, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzaym = paramList;
    this.zzazu = Collections.unmodifiableList(paramList1);
    this.zzTA = paramStatus;
  }
  
  public static SessionReadResult zzV(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  private boolean zzb(SessionReadResult paramSessionReadResult)
  {
    return (this.zzTA.equals(paramSessionReadResult.zzTA)) && (zzw.equal(this.zzaym, paramSessionReadResult.zzaym)) && (zzw.equal(this.zzazu, paramSessionReadResult.zzazu));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadResult)) && (zzb((SessionReadResult)paramObject)));
  }
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    zzx.zzb(this.zzaym.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzazu.iterator();
    while (localIterator.hasNext())
    {
      SessionDataSet localSessionDataSet = (SessionDataSet)localIterator.next();
      if (zzw.equal(paramSession, localSessionDataSet.getSession())) {
        localArrayList.add(localSessionDataSet.zztT());
      }
    }
    return localArrayList;
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    zzx.zzb(this.zzaym.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzazu.iterator();
    while (localIterator.hasNext())
    {
      SessionDataSet localSessionDataSet = (SessionDataSet)localIterator.next();
      if ((zzw.equal(paramSession, localSessionDataSet.getSession())) && (paramDataType.equals(localSessionDataSet.zztT().getDataType()))) {
        localArrayList.add(localSessionDataSet.zztT());
      }
    }
    return localArrayList;
  }
  
  public List<Session> getSessions()
  {
    return this.zzaym;
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
    return zzw.hashCode(new Object[] { this.zzTA, this.zzaym, this.zzazu });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("sessions", this.zzaym).zzg("sessionDataSets", this.zzazu).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public List<SessionDataSet> zzuN()
  {
    return this.zzazu;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/SessionReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */