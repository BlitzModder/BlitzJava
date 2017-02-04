package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NearbyDeviceFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDeviceFilter> CREATOR = new zzg();
  final int mVersionCode;
  final int zzaXg;
  final byte[] zzaXh;
  final boolean zzaXi;
  
  NearbyDeviceFilter(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzaXg = paramInt2;
    this.zzaXh = paramArrayOfByte;
    this.zzaXi = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/NearbyDeviceFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */