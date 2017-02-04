package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzp();
  final int mVersionCode;
  public final String zzaWI;
  public final boolean zzaWJ;
  public final boolean zzaWK;
  public final Strategy zzaXG;
  public final String zzaXH;
  public final zzb zzaXL;
  public final MessageFilter zzaXM;
  public final PendingIntent zzaXN;
  public final int zzaXO;
  public final byte[] zzaXP;
  public final zzg zzaXQ;
  public final zzc zzaXm;
  
  SubscribeRequest(int paramInt1, IBinder paramIBinder1, Strategy paramStrategy, IBinder paramIBinder2, MessageFilter paramMessageFilter, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean1, IBinder paramIBinder3, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaXL = zzb.zza.zzdt(paramIBinder1);
    this.zzaXG = paramStrategy;
    this.zzaXm = zzc.zza.zzdu(paramIBinder2);
    this.zzaXM = paramMessageFilter;
    this.zzaXN = paramPendingIntent;
    this.zzaXO = paramInt2;
    this.zzaWI = paramString1;
    this.zzaXH = paramString2;
    this.zzaXP = paramArrayOfByte;
    this.zzaWJ = paramBoolean1;
    if (paramIBinder3 == null) {}
    for (paramIBinder1 = null;; paramIBinder1 = zzg.zza.zzdy(paramIBinder3))
    {
      this.zzaXQ = paramIBinder1;
      this.zzaWK = paramBoolean2;
      return;
    }
  }
  
  public SubscribeRequest(IBinder paramIBinder1, Strategy paramStrategy, IBinder paramIBinder2, MessageFilter paramMessageFilter, PendingIntent paramPendingIntent, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean1, IBinder paramIBinder3, boolean paramBoolean2)
  {
    this(3, paramIBinder1, paramStrategy, paramIBinder2, paramMessageFilter, paramPendingIntent, paramInt, paramString1, paramString2, paramArrayOfByte, paramBoolean1, paramIBinder3, paramBoolean2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    if (this.zzaXm == null) {
      return null;
    }
    return this.zzaXm.asBinder();
  }
  
  IBinder zzCM()
  {
    if (this.zzaXL == null) {
      return null;
    }
    return this.zzaXL.asBinder();
  }
  
  IBinder zzCN()
  {
    if (this.zzaXQ == null) {
      return null;
    }
    return this.zzaXQ.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/SubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */