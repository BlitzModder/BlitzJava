package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnpublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzq();
  final int mVersionCode;
  public final String zzaWI;
  public final boolean zzaWK;
  public final MessageWrapper zzaXF;
  public final String zzaXH;
  public final zzc zzaXm;
  
  UnpublishRequest(int paramInt, MessageWrapper paramMessageWrapper, IBinder paramIBinder, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaXF = paramMessageWrapper;
    this.zzaXm = zzc.zza.zzdu(paramIBinder);
    this.zzaWI = paramString1;
    this.zzaXH = paramString2;
    this.zzaWK = paramBoolean;
  }
  
  UnpublishRequest(MessageWrapper paramMessageWrapper, IBinder paramIBinder, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(1, paramMessageWrapper, paramIBinder, paramString1, paramString2, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaXm.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/UnpublishRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */