package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zza();
  public static final int UNSPECIFIED = -1;
  private final int mVersionCode;
  private final DataSource zzatP;
  private final zzj zzayN;
  private final long zzazx;
  private final long zzazy;
  
  FitnessSensorServiceRequest(int paramInt, DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzatP = paramDataSource;
    this.zzayN = zzj.zza.zzbt(paramIBinder);
    this.zzazx = paramLong1;
    this.zzazy = paramLong2;
  }
  
  private boolean zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest)
  {
    return (zzw.equal(this.zzatP, paramFitnessSensorServiceRequest.zzatP)) && (this.zzazx == paramFitnessSensorServiceRequest.zzazx) && (this.zzazy == paramFitnessSensorServiceRequest.zzazy);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof FitnessSensorServiceRequest)) && (zza((FitnessSensorServiceRequest)paramObject)));
  }
  
  public long getBatchInterval(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzazy, TimeUnit.MICROSECONDS);
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new zzb(this.zzayN);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    if (this.zzazx == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(this.zzazx, TimeUnit.MICROSECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP, Long.valueOf(this.zzazx), Long.valueOf(this.zzazy) });
  }
  
  public String toString()
  {
    return String.format("FitnessSensorServiceRequest{%s}", new Object[] { this.zzatP });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public long zztU()
  {
    return this.zzazx;
  }
  
  public long zzuQ()
  {
    return this.zzazy;
  }
  
  IBinder zzuz()
  {
    return this.zzayN.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/service/FitnessSensorServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */