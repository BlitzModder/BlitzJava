package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

public final class PublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PublishRequest> CREATOR = new zzn();
  final int mVersionCode;
  public final String zzaWI;
  public final boolean zzaWJ;
  public final boolean zzaWK;
  public final MessageWrapper zzaXF;
  public final Strategy zzaXG;
  public final String zzaXH;
  public final zze zzaXI;
  public final zzc zzaXm;
  
  PublishRequest(int paramInt, MessageWrapper paramMessageWrapper, Strategy paramStrategy, IBinder paramIBinder1, String paramString1, String paramString2, boolean paramBoolean1, IBinder paramIBinder2, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzaXF = paramMessageWrapper;
    this.zzaXG = paramStrategy;
    this.zzaXm = zzc.zza.zzdu(paramIBinder1);
    this.zzaWI = paramString1;
    this.zzaXH = paramString2;
    this.zzaWJ = paramBoolean1;
    if (paramIBinder2 == null) {}
    for (paramMessageWrapper = null;; paramMessageWrapper = zze.zza.zzdw(paramIBinder2))
    {
      this.zzaXI = paramMessageWrapper;
      this.zzaWK = paramBoolean2;
      return;
    }
  }
  
  PublishRequest(MessageWrapper paramMessageWrapper, Strategy paramStrategy, IBinder paramIBinder1, String paramString1, String paramString2, boolean paramBoolean1, IBinder paramIBinder2, boolean paramBoolean2)
  {
    this(2, paramMessageWrapper, paramStrategy, paramIBinder1, paramString1, paramString2, paramBoolean1, paramIBinder2, paramBoolean2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaXm.asBinder();
  }
  
  IBinder zzCK()
  {
    if (this.zzaXI == null) {
      return null;
    }
    return this.zzaXI.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/PublishRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */