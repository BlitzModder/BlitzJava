package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class DeviceStatus
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeviceStatus> CREATOR = new zzg();
  private final int mVersionCode;
  private double zzZL;
  private boolean zzZM;
  private int zzabZ;
  private int zzaca;
  private ApplicationMetadata zzack;
  
  public DeviceStatus()
  {
    this(3, NaN.0D, false, -1, null, -1);
  }
  
  DeviceStatus(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2, ApplicationMetadata paramApplicationMetadata, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzZL = paramDouble;
    this.zzZM = paramBoolean;
    this.zzabZ = paramInt2;
    this.zzack = paramApplicationMetadata;
    this.zzaca = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof DeviceStatus)) {
        return false;
      }
      paramObject = (DeviceStatus)paramObject;
    } while ((this.zzZL == ((DeviceStatus)paramObject).zzZL) && (this.zzZM == ((DeviceStatus)paramObject).zzZM) && (this.zzabZ == ((DeviceStatus)paramObject).zzabZ) && (zzf.zza(this.zzack, ((DeviceStatus)paramObject).zzack)) && (this.zzaca == ((DeviceStatus)paramObject).zzaca));
    return false;
  }
  
  public ApplicationMetadata getApplicationMetadata()
  {
    return this.zzack;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Double.valueOf(this.zzZL), Boolean.valueOf(this.zzZM), Integer.valueOf(this.zzabZ), this.zzack, Integer.valueOf(this.zzaca) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public double zznS()
  {
    return this.zzZL;
  }
  
  public int zznT()
  {
    return this.zzabZ;
  }
  
  public int zznU()
  {
    return this.zzaca;
  }
  
  public boolean zzob()
  {
    return this.zzZM;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/DeviceStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */