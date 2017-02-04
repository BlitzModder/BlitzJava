package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Message;

public class zzi
  implements Parcelable.Creator<MessageWrapper>
{
  static void zza(MessageWrapper paramMessageWrapper, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramMessageWrapper.zzaXn, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramMessageWrapper.mVersionCode);
    zzb.zzI(paramParcel, i);
  }
  
  public MessageWrapper zzfZ(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    Message localMessage = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localMessage = (Message)zza.zza(paramParcel, k, Message.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new MessageWrapper(i, localMessage);
  }
  
  public MessageWrapper[] zzjb(int paramInt)
  {
    return new MessageWrapper[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */