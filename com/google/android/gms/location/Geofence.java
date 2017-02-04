package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String zzDX = null;
    private int zzaKO = 0;
    private long zzaKP = Long.MIN_VALUE;
    private short zzaKQ = -1;
    private double zzaKR;
    private double zzaKS;
    private float zzaKT;
    private int zzaKU = 0;
    private int zzaKV = -1;
    
    public Geofence build()
    {
      if (this.zzDX == null) {
        throw new IllegalArgumentException("Request ID not set.");
      }
      if (this.zzaKO == 0) {
        throw new IllegalArgumentException("Transitions types not set.");
      }
      if (((this.zzaKO & 0x4) != 0) && (this.zzaKV < 0)) {
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      }
      if (this.zzaKP == Long.MIN_VALUE) {
        throw new IllegalArgumentException("Expiration not set.");
      }
      if (this.zzaKQ == -1) {
        throw new IllegalArgumentException("Geofence region not set.");
      }
      if (this.zzaKU < 0) {
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      }
      return new ParcelableGeofence(this.zzDX, this.zzaKO, (short)1, this.zzaKR, this.zzaKS, this.zzaKT, this.zzaKP, this.zzaKU, this.zzaKV);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.zzaKQ = 1;
      this.zzaKR = paramDouble1;
      this.zzaKS = paramDouble2;
      this.zzaKT = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.zzaKP = -1L;
        return this;
      }
      this.zzaKP = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.zzaKV = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.zzaKU = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.zzDX = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.zzaKO = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */