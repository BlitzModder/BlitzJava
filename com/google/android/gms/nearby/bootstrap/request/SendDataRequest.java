package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final byte[] data;
  final int versionCode;
  private final Device zzaVV;
  private final zzqv zzaVY;
  
  SendDataRequest(int paramInt, Device paramDevice, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaVV = ((Device)zzx.zzy(paramDevice));
    this.data = ((byte[])zzx.zzy(paramArrayOfByte));
    zzx.zzy(paramIBinder);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder);
  }
  
  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public Device zzCm()
  {
    return this.zzaVV;
  }
  
  public IBinder zzui()
  {
    if (this.zzaVY == null) {
      return null;
    }
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/SendDataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */