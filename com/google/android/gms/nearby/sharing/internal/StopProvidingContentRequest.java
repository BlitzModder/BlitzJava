package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StopProvidingContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
  final int versionCode;
  public long zzaYa;
  public zzc zzaYb;
  
  StopProvidingContentRequest()
  {
    this.versionCode = 1;
  }
  
  StopProvidingContentRequest(int paramInt, long paramLong, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaYa = paramLong;
    this.zzaYb = zzc.zza.zzdC(paramIBinder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaYb.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/StopProvidingContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */