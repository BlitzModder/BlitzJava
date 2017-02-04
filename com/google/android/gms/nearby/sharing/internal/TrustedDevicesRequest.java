package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class TrustedDevicesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();
  final int versionCode;
  public zzc zzaYb;
  public String zzaYd;
  public byte[] zzaYe;
  
  TrustedDevicesRequest(int paramInt, String paramString, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaYd = ((String)zzx.zzy(paramString));
    this.zzaYe = ((byte[])zzx.zzy(paramArrayOfByte));
    this.zzaYb = zzc.zza.zzdC(paramIBinder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaYb.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/TrustedDevicesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */