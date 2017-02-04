package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class ContinueConnectRequest
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int versionCode;
  private final zzqv zzaVY;
  private final String zzaVZ;
  
  ContinueConnectRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaVZ = ((String)zzx.zzy(paramString));
    this.zzaVY = zzqv.zza.zzdn(paramIBinder);
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public String getToken()
  {
    return this.zzaVZ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzaVY == null) {
      return null;
    }
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/ContinueConnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */