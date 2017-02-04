package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbv();
  final int mVersionCode;
  public final zzba zzbmw;
  
  RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null)
    {
      this.zzbmw = zzba.zza.zzeq(paramIBinder);
      return;
    }
    this.zzbmw = null;
  }
  
  public RemoveListenerRequest(zzba paramzzba)
  {
    this.mVersionCode = 1;
    this.zzbmw = paramzzba;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbv.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzGB()
  {
    if (this.zzbmw == null) {
      return null;
    }
    return this.zzbmw.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/RemoveListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */