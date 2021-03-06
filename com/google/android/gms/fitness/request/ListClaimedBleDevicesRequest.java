package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqc.zza;

public class ListClaimedBleDevicesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();
  private final int mVersionCode;
  private final zzqc zzayI;
  
  ListClaimedBleDevicesRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzayI = zzqc.zza.zzbT(paramIBinder);
  }
  
  public ListClaimedBleDevicesRequest(zzqc paramzzqc)
  {
    this.mVersionCode = 2;
    this.zzayI = paramzzqc;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    return this.zzayI.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/ListClaimedBleDevicesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */