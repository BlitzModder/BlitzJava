package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class ClaimBleDeviceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final String zzayh;
  private final BleDevice zzayi;
  private final zzpp zzayj;
  
  ClaimBleDeviceRequest(int paramInt, String paramString, BleDevice paramBleDevice, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzayh = paramString;
    this.zzayi = paramBleDevice;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public ClaimBleDeviceRequest(String paramString, BleDevice paramBleDevice, zzpp paramzzpp)
  {
    this.mVersionCode = 4;
    this.zzayh = paramString;
    this.zzayi = paramBleDevice;
    this.zzayj = paramzzpp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceAddress()
  {
    return this.zzayh;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] { this.zzayh, this.zzayi });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public BleDevice zzuh()
  {
    return this.zzayi;
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/ClaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */