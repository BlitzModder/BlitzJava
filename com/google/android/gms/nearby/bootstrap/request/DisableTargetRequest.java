package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class DisableTargetRequest
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int versionCode;
  private final zzqv zzaVY;
  
  DisableTargetRequest(int paramInt, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    zzx.zzy(paramIBinder);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzaVY == null) {
      return null;
    }
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/DisableTargetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */