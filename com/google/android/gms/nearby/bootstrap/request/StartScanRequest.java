package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqx.zza;

public class StartScanRequest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int versionCode;
  private final zzqv zzaVY;
  private final zzqx zzaWb;
  
  StartScanRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this.versionCode = paramInt;
    zzx.zzy(paramIBinder1);
    this.zzaWb = zzqx.zza.zzdp(paramIBinder1);
    zzx.zzy(paramIBinder2);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder2);
  }
  
  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzCr()
  {
    if (this.zzaWb == null) {
      return null;
    }
    return this.zzaWb.asBinder();
  }
  
  public IBinder zzui()
  {
    if (this.zzaVY == null) {
      return null;
    }
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/StartScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */