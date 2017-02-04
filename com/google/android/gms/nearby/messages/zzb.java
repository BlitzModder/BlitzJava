package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<MessageFilter>
{
  static void zza(MessageFilter paramMessageFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramMessageFilter.zzCx(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramMessageFilter.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramMessageFilter.zzCz(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramMessageFilter.zzCy());
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public MessageFilter zzfS(Parcel paramParcel)
  {
    ArrayList localArrayList2 = null;
    boolean bool = false;
    int j = zza.zzau(paramParcel);
    ArrayList localArrayList1 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList1 = zza.zzc(paramParcel, k, MessageType.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = zza.zzc(paramParcel, k, NearbyDeviceFilter.CREATOR);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new MessageFilter(i, localArrayList1, localArrayList2, bool);
  }
  
  public MessageFilter[] zziQ(int paramInt)
  {
    return new MessageFilter[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */