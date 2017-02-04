package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DisableFitRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DisableFitRequest> CREATOR = new zzl();
  private final int mVersionCode;
  private final zzpp zzayj;
  
  DisableFitRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public DisableFitRequest(zzpp paramzzpp)
  {
    this.mVersionCode = 2;
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
    return String.format("DisableFitRequest", new Object[0]);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DisableFitRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */