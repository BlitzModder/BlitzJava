package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class Subscription
  implements SafeParcelable
{
  public static final Parcelable.Creator<Subscription> CREATOR = new zzr();
  private final int mVersionCode;
  private final DataType zzatO;
  private final DataSource zzatP;
  private final long zzavf;
  private final int zzavg;
  
  Subscription(int paramInt1, DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzatP = paramDataSource;
    this.zzatO = paramDataType;
    this.zzavf = paramLong;
    this.zzavg = paramInt2;
  }
  
  private Subscription(zza paramzza)
  {
    this.mVersionCode = 1;
    this.zzatO = zza.zza(paramzza);
    this.zzatP = zza.zzb(paramzza);
    this.zzavf = zza.zzc(paramzza);
    this.zzavg = zza.zzd(paramzza);
  }
  
  private boolean zza(Subscription paramSubscription)
  {
    return (zzw.equal(this.zzatP, paramSubscription.zzatP)) && (zzw.equal(this.zzatO, paramSubscription.zzatO)) && (this.zzavf == paramSubscription.zzavf) && (this.zzavg == paramSubscription.zzavg);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Subscription)) && (zza((Subscription)paramObject)));
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
    return zzw.hashCode(new Object[] { this.zzatP, this.zzatP, Long.valueOf(this.zzavf), Integer.valueOf(this.zzavg) });
  }
  
  public String toDebugString()
  {
    if (this.zzatP == null) {}
    for (String str = this.zzatO.getName();; str = this.zzatP.toDebugString()) {
      return String.format("Subscription{%s}", new Object[] { str });
    }
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("dataSource", this.zzatP).zzg("dataType", this.zzatO).zzg("samplingIntervalMicros", Long.valueOf(this.zzavf)).zzg("accuracyMode", Integer.valueOf(this.zzavg)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  public long zztU()
  {
    return this.zzavf;
  }
  
  public DataType zztV()
  {
    if (this.zzatO == null) {
      return this.zzatP.getDataType();
    }
    return this.zzatO;
  }
  
  public static class zza
  {
    private DataType zzatO;
    private DataSource zzatP;
    private long zzavf = -1L;
    private int zzavg = 2;
    
    public zza zzb(DataSource paramDataSource)
    {
      this.zzatP = paramDataSource;
      return this;
    }
    
    public zza zzb(DataType paramDataType)
    {
      this.zzatO = paramDataType;
      return this;
    }
    
    public Subscription zztW()
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
        return new Subscription(this, null);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */