package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class RegisterStatusCallbackRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RegisterStatusCallbackRequest> CREATOR = new zzo();
  final int versionCode;
  public String zzaWI;
  public final zzf zzaXJ;
  public boolean zzaXK;
  public final zzc zzaXm;
  
  RegisterStatusCallbackRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, boolean paramBoolean, String paramString)
  {
    this.versionCode = paramInt;
    this.zzaXm = zzc.zza.zzdu(paramIBinder1);
    this.zzaXJ = zzf.zza.zzdx(paramIBinder2);
    this.zzaXK = paramBoolean;
    this.zzaWI = paramString;
  }
  
  RegisterStatusCallbackRequest(IBinder paramIBinder1, IBinder paramIBinder2, String paramString)
  {
    this(1, paramIBinder1, paramIBinder2, false, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaXm.asBinder();
  }
  
  IBinder zzCL()
  {
    return this.zzaXJ.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/RegisterStatusCallbackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */