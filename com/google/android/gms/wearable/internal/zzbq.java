package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbq
  implements Parcelable.Creator<OpenChannelResponse>
{
  static void zza(OpenChannelResponse paramOpenChannelResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOpenChannelResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramOpenChannelResponse.statusCode);
    zzb.zza(paramParcel, 3, paramOpenChannelResponse.zzbmX, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OpenChannelResponse zzix(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    ChannelImpl localChannelImpl = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localChannelImpl = (ChannelImpl)zza.zza(paramParcel, m, ChannelImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new OpenChannelResponse(i, j, localChannelImpl);
  }
  
  public OpenChannelResponse[] zzlZ(int paramInt)
  {
    return new OpenChannelResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */