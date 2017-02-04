package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDeviceId
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDeviceId> CREATOR = new zzh();
  public static final NearbyDeviceId zzaXj = new NearbyDeviceId();
  final int mVersionCode;
  private final int zzZU;
  final byte[] zzaXb;
  private final zzb zzaXk;
  private final zzd zzaXl;
  
  private NearbyDeviceId()
  {
    this(1, 1, null);
  }
  
  NearbyDeviceId(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt1;
    this.zzZU = paramInt2;
    this.zzaXb = paramArrayOfByte;
    if (paramInt2 == 2) {}
    for (Object localObject1 = new zzb(paramArrayOfByte);; localObject1 = null)
    {
      this.zzaXk = ((zzb)localObject1);
      localObject1 = localObject2;
      if (paramInt2 == 3) {
        localObject1 = new zzd(paramArrayOfByte);
      }
      this.zzaXl = ((zzd)localObject1);
      return;
    }
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
      if (!(paramObject instanceof NearbyDeviceId)) {
        return false;
      }
      paramObject = (NearbyDeviceId)paramObject;
    } while ((zzw.equal(Integer.valueOf(this.zzZU), Integer.valueOf(((NearbyDeviceId)paramObject).zzZU))) && (zzw.equal(this.zzaXb, ((NearbyDeviceId)paramObject).zzaXb)));
    return false;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzZU), this.zzaXb });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NearbyDeviceId{");
    switch (this.zzZU)
    {
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("eddystoneUid=").append(this.zzaXk);
      continue;
      localStringBuilder.append("iBeaconId=").append(this.zzaXl);
      continue;
      localStringBuilder.append("UNKNOWN");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/NearbyDeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */