package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class Strategy
  implements SafeParcelable
{
  public static final Strategy BLE_ONLY = new Builder().zziU(2).setTtlSeconds(Integer.MAX_VALUE).build();
  public static final Parcelable.Creator<Strategy> CREATOR = new zzd();
  public static final Strategy DEFAULT = new Builder().build();
  public static final int DISCOVERY_MODE_BROADCAST = 1;
  public static final int DISCOVERY_MODE_DEFAULT = 3;
  public static final int DISCOVERY_MODE_SCAN = 2;
  public static final int DISTANCE_TYPE_DEFAULT = 0;
  public static final int DISTANCE_TYPE_EARSHOT = 1;
  public static final int TTL_SECONDS_DEFAULT = 300;
  public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
  public static final int TTL_SECONDS_MAX = 86400;
  @Deprecated
  public static final Strategy zzaWN = BLE_ONLY;
  final int mVersionCode;
  @Deprecated
  final int zzaWO;
  final int zzaWP;
  final int zzaWQ;
  @Deprecated
  final boolean zzaWR;
  final int zzaWS;
  final int zzaWT;
  
  Strategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    this.mVersionCode = paramInt1;
    this.zzaWO = paramInt2;
    if (paramInt2 == 0) {
      this.zzaWT = paramInt6;
    }
    for (;;)
    {
      this.zzaWQ = paramInt4;
      this.zzaWR = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      this.zzaWS = 2;
      this.zzaWP = Integer.MAX_VALUE;
      return;
      switch (paramInt2)
      {
      default: 
        this.zzaWT = 3;
        break;
      case 2: 
        this.zzaWT = 1;
        break;
      case 3: 
        this.zzaWT = 2;
      }
    }
    if (paramInt5 == 0)
    {
      this.zzaWS = 6;
      this.zzaWP = paramInt3;
      return;
    }
    this.zzaWS = paramInt5;
    this.zzaWP = paramInt3;
  }
  
  private static String zziR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "DEFAULT";
    }
    return "EARSHOT";
  }
  
  private static String zziS(int paramInt)
  {
    if (paramInt == 6) {
      return "DEFAULT";
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x4) > 0) {
      localArrayList.add("AUDIO");
    }
    if ((paramInt & 0x2) > 0) {
      localArrayList.add("BLE");
    }
    return localArrayList.toString();
  }
  
  private static String zziT(int paramInt)
  {
    if (paramInt == 3) {
      return "DEFAULT";
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) > 0) {
      localArrayList.add("BROADCAST");
    }
    if ((paramInt & 0x2) > 0) {
      localArrayList.add("SCAN");
    }
    return localArrayList.toString();
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
      if (!(paramObject instanceof Strategy)) {
        return false;
      }
      paramObject = (Strategy)paramObject;
    } while ((this.mVersionCode == ((Strategy)paramObject).mVersionCode) && (this.zzaWT == ((Strategy)paramObject).zzaWT) && (this.zzaWP == ((Strategy)paramObject).zzaWP) && (this.zzaWQ == ((Strategy)paramObject).zzaWQ) && (this.zzaWS == ((Strategy)paramObject).zzaWS));
    return false;
  }
  
  public int hashCode()
  {
    return (((this.mVersionCode * 31 + this.zzaWT) * 31 + this.zzaWP) * 31 + this.zzaWQ) * 31 + this.zzaWS;
  }
  
  public String toString()
  {
    return "Strategy{ttlSeconds=" + this.zzaWP + ", distanceType=" + zziR(this.zzaWQ) + ", discoveryMedium=" + zziS(this.zzaWS) + ", discoveryMode=" + zziT(this.zzaWT) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public int zzCA()
  {
    return this.zzaWS;
  }
  
  public int zzCB()
  {
    return this.zzaWT;
  }
  
  public static class Builder
  {
    private int zzaWU = 3;
    private int zzaWV = 300;
    private int zzaWW = 0;
    private int zzaWX = 6;
    
    public Strategy build()
    {
      if ((this.zzaWX == 2) && (this.zzaWW == 1)) {
        throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
      }
      return new Strategy(2, 0, this.zzaWV, this.zzaWW, false, this.zzaWX, this.zzaWU);
    }
    
    public Builder setDiscoveryMode(int paramInt)
    {
      this.zzaWU = paramInt;
      return this;
    }
    
    public Builder setDistanceType(int paramInt)
    {
      this.zzaWW = paramInt;
      return this;
    }
    
    public Builder setTtlSeconds(int paramInt)
    {
      if ((paramInt == Integer.MAX_VALUE) || ((paramInt > 0) && (paramInt <= 86400))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(86400) });
        this.zzaWV = paramInt;
        return this;
      }
    }
    
    public Builder zziU(int paramInt)
    {
      this.zzaWX = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/Strategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */