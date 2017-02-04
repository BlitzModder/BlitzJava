package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int versionCode;
  private final Device zzaVV;
  private final zzqv zzaVY;
  
  DisconnectRequest(int paramInt, Device paramDevice, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaVV = ((Device)zzx.zzy(paramDevice));
    zzx.zzy(paramIBinder);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder);
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Device zzCm()
  {
    return this.zzaVV;
  }
  
  public IBinder zzui()
  {
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/DisconnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */