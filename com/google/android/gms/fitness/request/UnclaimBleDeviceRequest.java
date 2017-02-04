package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class UnclaimBleDeviceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();
  private final int mVersionCode;
  private final String zzayh;
  private final zzpp zzayj;
  
  UnclaimBleDeviceRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzayh = paramString;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public UnclaimBleDeviceRequest(String paramString, zzpp paramzzpp)
  {
    this.mVersionCode = 5;
    this.zzayh = paramString;
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
    return String.format("UnclaimBleDeviceRequest{%s}", new Object[] { this.zzayh });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/UnclaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */