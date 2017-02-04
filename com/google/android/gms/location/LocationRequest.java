package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  int mPriority;
  private final int mVersionCode;
  long zzaKP;
  long zzaLk;
  long zzaLl;
  int zzaLm;
  float zzaLn;
  long zzaLo;
  boolean zzayX;
  
  public LocationRequest()
  {
    this.mVersionCode = 1;
    this.mPriority = 102;
    this.zzaLk = 3600000L;
    this.zzaLl = 600000L;
    this.zzayX = false;
    this.zzaKP = Long.MAX_VALUE;
    this.zzaLm = Integer.MAX_VALUE;
    this.zzaLn = 0.0F;
    this.zzaLo = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    this.mVersionCode = paramInt1;
    this.mPriority = paramInt2;
    this.zzaLk = paramLong1;
    this.zzaLl = paramLong2;
    this.zzayX = paramBoolean;
    this.zzaKP = paramLong3;
    this.zzaLm = paramInt3;
    this.zzaLn = paramFloat;
    this.zzaLo = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void zzL(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  private static void zzd(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  private static void zzhj(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String zzhk(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.zzaLk == ((LocationRequest)paramObject).zzaLk) && (this.zzaLl == ((LocationRequest)paramObject).zzaLl) && (this.zzayX == ((LocationRequest)paramObject).zzayX) && (this.zzaKP == ((LocationRequest)paramObject).zzaKP) && (this.zzaLm == ((LocationRequest)paramObject).zzaLm) && (this.zzaLn == ((LocationRequest)paramObject).zzaLn));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzaKP;
  }
  
  public long getFastestInterval()
  {
    return this.zzaLl;
  }
  
  public long getInterval()
  {
    return this.zzaLk;
  }
  
  public long getMaxWaitTime()
  {
    long l2 = this.zzaLo;
    long l1 = l2;
    if (l2 < this.zzaLk) {
      l1 = this.zzaLk;
    }
    return l1;
  }
  
  public int getNumUpdates()
  {
    return this.zzaLm;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.zzaLn;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.zzaLk), Long.valueOf(this.zzaLl), Boolean.valueOf(this.zzayX), Long.valueOf(this.zzaKP), Integer.valueOf(this.zzaLm), Float.valueOf(this.zzaLn) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.zzaKP = Long.MAX_VALUE;; this.zzaKP = (l + paramLong))
    {
      if (this.zzaKP < 0L) {
        this.zzaKP = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.zzaKP = paramLong;
    if (this.zzaKP < 0L) {
      this.zzaKP = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    zzL(paramLong);
    this.zzayX = true;
    this.zzaLl = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    zzL(paramLong);
    this.zzaLk = paramLong;
    if (!this.zzayX) {
      this.zzaLl = ((this.zzaLk / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setMaxWaitTime(long paramLong)
  {
    zzL(paramLong);
    this.zzaLo = paramLong;
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.zzaLm = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    zzhj(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    zzd(paramFloat);
    this.zzaLn = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(zzhk(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.zzaLk).append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.zzaLl).append("ms");
    if (this.zzaLo > this.zzaLk)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(this.zzaLo).append("ms");
    }
    if (this.zzaKP != Long.MAX_VALUE)
    {
      long l1 = this.zzaKP;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2).append("ms");
    }
    if (this.zzaLm != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.zzaLm);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */