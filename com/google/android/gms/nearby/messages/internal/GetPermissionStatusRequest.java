package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetPermissionStatusRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetPermissionStatusRequest> CREATOR = new zza();
  final int mVersionCode;
  public final String zzaWI;
  public final zzc zzaXm;
  
  GetPermissionStatusRequest(int paramInt, IBinder paramIBinder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaXm = zzc.zza.zzdu(paramIBinder);
    this.zzaWI = paramString;
  }
  
  GetPermissionStatusRequest(IBinder paramIBinder, String paramString)
  {
    this(1, paramIBinder, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaXm.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/GetPermissionStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */