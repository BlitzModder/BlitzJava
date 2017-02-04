package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ReceiveContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
  public String packageName;
  final int versionCode;
  public IBinder zzaXX;
  public zzc zzaYb;
  public zza zzaYc;
  
  ReceiveContentRequest()
  {
    this.versionCode = 1;
  }
  
  ReceiveContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, String paramString, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.zzaXX = paramIBinder1;
    this.zzaYc = zza.zza.zzdA(paramIBinder2);
    this.packageName = paramString;
    this.zzaYb = zzc.zza.zzdC(paramIBinder3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaYb.asBinder();
  }
  
  IBinder zzCV()
  {
    if (this.zzaYc == null) {
      return null;
    }
    return this.zzaYc.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/ReceiveContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */