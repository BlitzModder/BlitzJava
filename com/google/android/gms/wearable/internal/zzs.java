package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs
  implements Parcelable.Creator<ChannelSendFileResponse>
{
  static void zza(ChannelSendFileResponse paramChannelSendFileResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramChannelSendFileResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramChannelSendFileResponse.statusCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ChannelSendFileResponse zzhU(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ChannelSendFileResponse(i, j);
  }
  
  public ChannelSendFileResponse[] zzlv(int paramInt)
  {
    return new ChannelSendFileResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */