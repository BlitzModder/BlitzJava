package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class StopBleScanRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StopBleScanRequest> CREATOR = new zzab();
  private final int mVersionCode;
  private final zzpp zzayj;
  private final zzn zzazg;
  
  StopBleScanRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt;
    this.zzazg = zzn.zza.zzbU(paramIBinder1);
    this.zzayj = zzpp.zza.zzbR(paramIBinder2);
  }
  
  public StopBleScanRequest(BleScanCallback paramBleScanCallback, zzpp paramzzpp)
  {
    this(zza.zza.zzug().zzb(paramBleScanCallback), paramzzpp);
  }
  
  public StopBleScanRequest(zzn paramzzn, zzpp paramzzpp)
  {
    this.mVersionCode = 3;
    this.zzazg = paramzzn;
    this.zzayj = paramzzpp;
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
    zzab.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzuE()
  {
    return this.zzazg.asBinder();
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/StopBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */