package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbx
  implements Parcelable.Creator<SendMessageResponse>
{
  static void zza(SendMessageResponse paramSendMessageResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSendMessageResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramSendMessageResponse.statusCode);
    zzb.zzc(paramParcel, 3, paramSendMessageResponse.zzaKw);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public SendMessageResponse zziD(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzau(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new SendMessageResponse(i, j, k);
  }
  
  public SendMessageResponse[] zzmi(int paramInt)
  {
    return new SendMessageResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */