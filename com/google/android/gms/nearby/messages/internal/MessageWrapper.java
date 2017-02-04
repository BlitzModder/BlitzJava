package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  final int mVersionCode;
  public final Message zzaXn;
  
  MessageWrapper(int paramInt, Message paramMessage)
  {
    this.mVersionCode = paramInt;
    this.zzaXn = ((Message)zzx.zzy(paramMessage));
  }
  
  public static final MessageWrapper zza(Message paramMessage)
  {
    return new MessageWrapper(1, paramMessage);
  }
  
  public int describeContents()
  {
    zzi localzzi = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MessageWrapper)) {
      return false;
    }
    paramObject = (MessageWrapper)paramObject;
    return zzw.equal(this.zzaXn, ((MessageWrapper)paramObject).zzaXn);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXn });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi localzzi = CREATOR;
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/MessageWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */