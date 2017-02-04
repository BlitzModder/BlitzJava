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
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpn.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzv();
  private final int mVersionCode;
  private final String zzJX;
  private final long zzQj;
  private final long zzatQ;
  private final List<DataType> zzatZ;
  private final List<DataSource> zzayl;
  private final boolean zzayw;
  private final String zzaza;
  private boolean zzazb;
  private final List<String> zzazc;
  private final zzpn zzazd;
  
  SessionReadRequest(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzaza = paramString1;
    this.zzJX = paramString2;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.zzatZ = paramList;
    this.zzayl = paramList1;
    this.zzazb = paramBoolean1;
    this.zzayw = paramBoolean2;
    this.zzazc = paramList2;
    this.zzazd = zzpn.zza.zzbP(paramIBinder);
  }
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), null);
  }
  
  public SessionReadRequest(SessionReadRequest paramSessionReadRequest, zzpn paramzzpn)
  {
    this(paramSessionReadRequest.zzaza, paramSessionReadRequest.zzJX, paramSessionReadRequest.zzQj, paramSessionReadRequest.zzatQ, paramSessionReadRequest.zzatZ, paramSessionReadRequest.zzayl, paramSessionReadRequest.zzazb, paramSessionReadRequest.zzayw, paramSessionReadRequest.zzazc, paramzzpn);
  }
  
  public SessionReadRequest(String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, zzpn paramzzpn) {}
  
  private boolean zzb(SessionReadRequest paramSessionReadRequest)
  {
    return (zzw.equal(this.zzaza, paramSessionReadRequest.zzaza)) && (this.zzJX.equals(paramSessionReadRequest.zzJX)) && (this.zzQj == paramSessionReadRequest.zzQj) && (this.zzatQ == paramSessionReadRequest.zzatQ) && (zzw.equal(this.zzatZ, paramSessionReadRequest.zzatZ)) && (zzw.equal(this.zzayl, paramSessionReadRequest.zzayl)) && (this.zzazb == paramSessionReadRequest.zzazb) && (this.zzazc.equals(paramSessionReadRequest.zzazc)) && (this.zzayw == paramSessionReadRequest.zzayw);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadRequest)) && (zzb((SessionReadRequest)paramObject)));
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
  
  public List<String> getExcludedPackages()
  {
    return this.zzazc;
  }
  
  public String getSessionId()
  {
    return this.zzJX;
  }
  
  public String getSessionName()
  {
    return this.zzaza;
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
    return zzw.hashCode(new Object[] { this.zzaza, this.zzJX, Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ) });
  }
  
  public boolean includeSessionsFromAllApps()
  {
    return this.zzazb;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("sessionName", this.zzaza).zzg("sessionId", this.zzJX).zzg("startTimeMillis", Long.valueOf(this.zzQj)).zzg("endTimeMillis", Long.valueOf(this.zzatQ)).zzg("dataTypes", this.zzatZ).zzg("dataSources", this.zzayl).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzazb)).zzg("excludedPackages", this.zzazc).zzg("useServer", Boolean.valueOf(this.zzayw)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv.zza(this, paramParcel, paramInt);
  }
  
  public long zzlx()
  {
    return this.zzQj;
  }
  
  public long zztB()
  {
    return this.zzatQ;
  }
  
  public boolean zzuC()
  {
    return this.zzazb;
  }
  
  public IBinder zzui()
  {
    if (this.zzazd == null) {
      return null;
    }
    return this.zzazd.asBinder();
  }
  
  public boolean zzun()
  {
    return this.zzayw;
  }
  
  public static class Builder
  {
    private String zzJX;
    private long zzQj = 0L;
    private long zzatQ = 0L;
    private List<DataType> zzatZ = new ArrayList();
    private List<DataSource> zzayl = new ArrayList();
    private boolean zzayw = false;
    private String zzaza;
    private boolean zzazb = false;
    private List<String> zzazc = new ArrayList();
    
    public SessionReadRequest build()
    {
      if (this.zzQj > 0L)
      {
        bool = true;
        zzx.zzb(bool, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzQj) });
        if ((this.zzatQ <= 0L) || (this.zzatQ <= this.zzQj)) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzatQ) });
        return new SessionReadRequest(this, null);
        bool = false;
        break;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.zzayw = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      zzx.zzb(paramString, "Attempting to use a null package name");
      if (!this.zzazc.contains(paramString)) {
        this.zzazc.add(paramString);
      }
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzayl.contains(paramDataSource)) {
        this.zzayl.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      zzx.zzb(paramDataType, "Attempting to use a null data type");
      if (!this.zzatZ.contains(paramDataType)) {
        this.zzatZ.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      this.zzazb = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      this.zzJX = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      this.zzaza = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzQj = paramTimeUnit.toMillis(paramLong1);
      this.zzatQ = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */