package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnsubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzr();
  final int mVersionCode;
  public final String zzaWI;
  public final boolean zzaWK;
  public final String zzaXH;
  public final zzb zzaXL;
  public final PendingIntent zzaXN;
  public final int zzaXO;
  public final zzc zzaXm;
  
  UnsubscribeRequest(int paramInt1, IBinder paramIBinder1, IBinder paramIBinder2, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzaXL = zzb.zza.zzdt(paramIBinder1);
    this.zzaXm = zzc.zza.zzdu(paramIBinder2);
    this.zzaXN = paramPendingIntent;
    this.zzaXO = paramInt2;
    this.zzaWI = paramString1;
    this.zzaXH = paramString2;
    this.zzaWK = paramBoolean;
  }
  
  UnsubscribeRequest(IBinder paramIBinder1, IBinder paramIBinder2, PendingIntent paramPendingIntent, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(1, paramIBinder1, paramIBinder2, paramPendingIntent, paramInt, paramString1, paramString2, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaXm.asBinder();
  }
  
  IBinder zzCM()
  {
    if (this.zzaXL == null) {
      return null;
    }
    return this.zzaXL.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/UnsubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */