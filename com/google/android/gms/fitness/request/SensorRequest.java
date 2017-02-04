package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final DataType zzatO;
  private final DataSource zzatP;
  private final long zzavf;
  private final int zzavg;
  private final long zzayQ;
  private final long zzayR;
  private final LocationRequest zzayV;
  private final long zzayW;
  
  private SensorRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    this.zzayV = paramLocationRequest;
    this.zzavf = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getInterval());
    this.zzayR = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getFastestInterval());
    this.zzayQ = this.zzavf;
    this.zzatO = paramDataSource.getDataType();
    this.zzavg = zza(paramLocationRequest);
    this.zzatP = paramDataSource;
    long l = paramLocationRequest.getExpirationTime();
    if (l == Long.MAX_VALUE)
    {
      this.zzayW = Long.MAX_VALUE;
      return;
    }
    this.zzayW = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
  }
  
  private SensorRequest(Builder paramBuilder)
  {
    this.zzatP = Builder.zza(paramBuilder);
    this.zzatO = Builder.zzb(paramBuilder);
    this.zzavf = Builder.zzc(paramBuilder);
    this.zzayR = Builder.zzd(paramBuilder);
    this.zzayQ = Builder.zze(paramBuilder);
    this.zzavg = Builder.zzf(paramBuilder);
    this.zzayV = null;
    this.zzayW = Builder.zzg(paramBuilder);
  }
  
  public static SensorRequest fromLocationRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    return new SensorRequest(paramDataSource, paramLocationRequest);
  }
  
  private static int zza(LocationRequest paramLocationRequest)
  {
    switch (paramLocationRequest.getPriority())
    {
    default: 
      return 2;
    case 100: 
      return 3;
    }
    return 1;
  }
  
  private boolean zza(SensorRequest paramSensorRequest)
  {
    return (zzw.equal(this.zzatP, paramSensorRequest.zzatP)) && (zzw.equal(this.zzatO, paramSensorRequest.zzatO)) && (this.zzavf == paramSensorRequest.zzavf) && (this.zzayR == paramSensorRequest.zzayR) && (this.zzayQ == paramSensorRequest.zzayQ) && (this.zzavg == paramSensorRequest.zzavg) && (zzw.equal(this.zzayV, paramSensorRequest.zzayV)) && (this.zzayW == paramSensorRequest.zzayW);
  }
  
  public static int zzft(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 2;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRequest)) && (zza((SensorRequest)paramObject)));
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
  
  public long getFastestRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzayR, TimeUnit.MICROSECONDS);
  }
  
  public long getMaxDeliveryLatency(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzayQ, TimeUnit.MICROSECONDS);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzavf, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP, this.zzatO, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ), Integer.valueOf(this.zzavg), this.zzayV, Long.valueOf(this.zzayW) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("dataSource", this.zzatP).zzg("dataType", this.zzatO).zzg("samplingRateMicros", Long.valueOf(this.zzavf)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzayQ)).zzg("timeOutMicros", Long.valueOf(this.zzayW)).toString();
  }
  
  public long zzuA()
  {
    return this.zzayW;
  }
  
  public static class Builder
  {
    private DataType zzatO;
    private DataSource zzatP;
    private long zzavf = -1L;
    private int zzavg = 2;
    private long zzayQ = 0L;
    private long zzayR = 0L;
    private long zzayW = Long.MAX_VALUE;
    private boolean zzayX = false;
    
    public SensorRequest build()
    {
      boolean bool2 = false;
      if ((this.zzatP != null) || (this.zzatO != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        zzx.zza(bool1, "Must call setDataSource() or setDataType()");
        if ((this.zzatO != null) && (this.zzatP != null))
        {
          bool1 = bool2;
          if (!this.zzatO.equals(this.zzatP.getDataType())) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "Specified data type is incompatible with specified data source");
        return new SensorRequest(this, null);
      }
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      this.zzavg = SensorRequest.zzft(paramInt);
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      this.zzatP = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.zzatO = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative interval");
        this.zzayX = true;
        this.zzayR = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative delivery interval");
        this.zzayQ = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative sampling interval");
        this.zzavf = paramTimeUnit.toMicros(paramLong);
        if (!this.zzayX) {
          this.zzayR = (this.zzavf / 2L);
        }
        return this;
      }
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      if (paramLong > 0L)
      {
        bool1 = true;
        zzx.zzb(bool1, "Invalid time out value specified: %d", new Object[] { Long.valueOf(paramLong) });
        if (paramTimeUnit == null) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Invalid time unit specified");
        this.zzayW = paramTimeUnit.toMicros(paramLong);
        return this;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SensorRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */