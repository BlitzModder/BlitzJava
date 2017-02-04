package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpq.zza;

public class GetSyncInfoRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetSyncInfoRequest> CREATOR = new zzm();
  private final int mVersionCode;
  private final zzpq zzayH;
  
  GetSyncInfoRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzayH = zzpq.zza.zzbS(paramIBinder);
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
    return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[] { Integer.valueOf(this.mVersionCode), this.zzayH });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    return this.zzayH.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/GetSyncInfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */