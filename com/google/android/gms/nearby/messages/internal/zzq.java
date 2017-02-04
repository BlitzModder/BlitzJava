package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<UnpublishRequest>
{
  static void zza(UnpublishRequest paramUnpublishRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramUnpublishRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramUnpublishRequest.zzaXF, paramInt, false);
    zzb.zza(paramParcel, 3, paramUnpublishRequest.zzCJ(), false);
    zzb.zza(paramParcel, 4, paramUnpublishRequest.zzaWI, false);
    zzb.zza(paramParcel, 5, paramUnpublishRequest.zzaXH, false);
    zzb.zza(paramParcel, 6, paramUnpublishRequest.zzaWK);
    zzb.zzI(paramParcel, i);
  }
  
  public UnpublishRequest zzgd(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzau(paramParcel);
    String str2 = null;
    IBinder localIBinder = null;
    MessageWrapper localMessageWrapper = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localMessageWrapper = (MessageWrapper)zza.zza(paramParcel, k, MessageWrapper.CREATOR);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UnpublishRequest(i, localMessageWrapper, localIBinder, str2, str1, bool);
  }
  
  public UnpublishRequest[] zzjf(int paramInt)
  {
    return new UnpublishRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */