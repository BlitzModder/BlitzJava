package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SensorUnregistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SensorUnregistrationRequest> CREATOR = new zzt();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final zzj zzayN;
  private final zzpp zzayj;
  
  SensorUnregistrationRequest(int paramInt, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder1 == null) {}
    for (paramIBinder1 = null;; paramIBinder1 = zzj.zza.zzbt(paramIBinder1))
    {
      this.zzayN = paramIBinder1;
      this.mPendingIntent = paramPendingIntent;
      this.zzayj = zzpp.zza.zzbR(paramIBinder2);
      return;
    }
  }
  
  public SensorUnregistrationRequest(zzj paramzzj, PendingIntent paramPendingIntent, zzpp paramzzpp)
  {
    this.mVersionCode = 4;
    this.zzayN = paramzzj;
    this.mPendingIntent = paramPendingIntent;
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
  
  public String toString()
  {
    return String.format("SensorUnregistrationRequest{%s}", new Object[] { this.zzayN });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public PendingIntent zzuu()
  {
    return this.mPendingIntent;
  }
  
  IBinder zzuz()
  {
    if (this.zzayN == null) {
      return null;
    }
    return this.zzayN.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SensorUnregistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */