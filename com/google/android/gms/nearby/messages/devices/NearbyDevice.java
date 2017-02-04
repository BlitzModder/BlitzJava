package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDevice> CREATOR = new zzf();
  public static final NearbyDevice zzaXe = new NearbyDevice(NearbyDeviceId.zzaXj);
  final int mVersionCode;
  private final String zzF;
  private final NearbyDeviceId zzaXf;
  
  NearbyDevice(int paramInt, NearbyDeviceId paramNearbyDeviceId, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaXf = paramNearbyDeviceId;
    this.zzF = paramString;
  }
  
  public NearbyDevice(NearbyDeviceId paramNearbyDeviceId)
  {
    this(1, paramNearbyDeviceId, null);
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
      if (!(paramObject instanceof NearbyDevice)) {
        return false;
      }
      paramObject = (NearbyDevice)paramObject;
    } while ((zzw.equal(this.zzaXf, ((NearbyDevice)paramObject).zzaXf)) && (zzw.equal(this.zzF, ((NearbyDevice)paramObject).zzF)));
    return false;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXf, this.zzF });
  }
  
  public String toString()
  {
    return "NearbyDevice{id=" + this.zzaXf + "url=" + this.zzF + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public NearbyDeviceId zzCI()
  {
    return this.zzaXf;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/NearbyDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */