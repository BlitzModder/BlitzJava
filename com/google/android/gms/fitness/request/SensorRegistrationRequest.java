package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SensorRegistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzs();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private DataType zzatO;
  private DataSource zzatP;
  private final long zzavf;
  private final int zzavg;
  private zzj zzayN;
  int zzayO;
  int zzayP;
  private final long zzayQ;
  private final long zzayR;
  private final List<LocationRequest> zzayS;
  private final long zzayT;
  private final List<Object> zzayU;
  private final zzpp zzayj;
  
  SensorRegistrationRequest(int paramInt1, DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt4, List<LocationRequest> paramList, long paramLong4, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt1;
    this.zzatP = paramDataSource;
    this.zzatO = paramDataType;
    if (paramIBinder1 == null) {}
    for (paramDataSource = null;; paramDataSource = zzj.zza.zzbt(paramIBinder1))
    {
      this.zzayN = paramDataSource;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = paramInt2;
      }
      this.zzavf = l;
      this.zzayR = paramLong3;
      paramLong1 = paramLong2;
      if (paramLong2 == 0L) {
        paramLong1 = paramInt3;
      }
      this.zzayQ = paramLong1;
      this.zzayS = paramList;
      this.mPendingIntent = paramPendingIntent;
      this.zzavg = paramInt4;
      this.zzayU = Collections.emptyList();
      this.zzayT = paramLong4;
      this.zzayj = zzpp.zza.zzbR(paramIBinder2);
      return;
    }
  }
  
  public SensorRegistrationRequest(DataSource paramDataSource, DataType paramDataType, zzj paramzzj, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List<LocationRequest> paramList, List<Object> paramList1, long paramLong4, zzpp paramzzpp)
  {
    this.mVersionCode = 6;
    this.zzatP = paramDataSource;
    this.zzatO = paramDataType;
    this.zzayN = paramzzj;
    this.mPendingIntent = paramPendingIntent;
    this.zzavf = paramLong1;
    this.zzayR = paramLong2;
    this.zzayQ = paramLong3;
    this.zzavg = paramInt;
    this.zzayS = paramList;
    this.zzayU = paramList1;
    this.zzayT = paramLong4;
    this.zzayj = paramzzpp;
  }
  
  public SensorRegistrationRequest(SensorRequest paramSensorRequest, zzj paramzzj, PendingIntent paramPendingIntent, zzpp paramzzpp)
  {
    this(paramSensorRequest.getDataSource(), paramSensorRequest.getDataType(), paramzzj, paramPendingIntent, paramSensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), paramSensorRequest.getFastestRate(TimeUnit.MICROSECONDS), paramSensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), paramSensorRequest.getAccuracyMode(), null, Collections.emptyList(), paramSensorRequest.zzuA(), paramzzpp);
  }
  
  private boolean zzb(SensorRegistrationRequest paramSensorRegistrationRequest)
  {
    return (zzw.equal(this.zzatP, paramSensorRegistrationRequest.zzatP)) && (zzw.equal(this.zzatO, paramSensorRegistrationRequest.zzatO)) && (this.zzavf == paramSensorRegistrationRequest.zzavf) && (this.zzayR == paramSensorRegistrationRequest.zzayR) && (this.zzayQ == paramSensorRegistrationRequest.zzayQ) && (this.zzavg == paramSensorRegistrationRequest.zzavg) && (zzw.equal(this.zzayS, paramSensorRegistrationRequest.zzayS));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRegistrationRequest)) && (zzb((SensorRegistrationRequest)paramObject)));
  }
  
  public int getAccuracyMode()
  {
    return this.zzavg;
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  public DataType getDataType()
  {
    return this.zzatO;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP, this.zzatO, this.zzayN, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ), Integer.valueOf(this.zzavg), this.zzayS });
  }
  
  public String toString()
  {
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] { this.zzatO, this.zzatP, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
  
  public long zztU()
  {
    return this.zzavf;
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public PendingIntent zzuu()
  {
    return this.mPendingIntent;
  }
  
  public long zzuv()
  {
    return this.zzayR;
  }
  
  public long zzuw()
  {
    return this.zzayQ;
  }
  
  public List<LocationRequest> zzux()
  {
    return this.zzayS;
  }
  
  public long zzuy()
  {
    return this.zzayT;
  }
  
  IBinder zzuz()
  {
    if (this.zzayN == null) {
      return null;
    }
    return this.zzayN.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SensorRegistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */