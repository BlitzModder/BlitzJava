package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<UnsubscribeRequest>
{
  static void zza(UnsubscribeRequest paramUnsubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramUnsubscribeRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramUnsubscribeRequest.zzCM(), false);
    zzb.zza(paramParcel, 3, paramUnsubscribeRequest.zzCJ(), false);
    zzb.zza(paramParcel, 4, paramUnsubscribeRequest.zzaXN, paramInt, false);
    zzb.zzc(paramParcel, 5, paramUnsubscribeRequest.zzaXO);
    zzb.zza(paramParcel, 6, paramUnsubscribeRequest.zzaWI, false);
    zzb.zza(paramParcel, 7, paramUnsubscribeRequest.zzaXH, false);
    zzb.zza(paramParcel, 8, paramUnsubscribeRequest.zzaWK);
    zzb.zzI(paramParcel, i);
  }
  
  public UnsubscribeRequest zzge(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int k = zza.zzau(paramParcel);
    String str2 = null;
    int i = 0;
    PendingIntent localPendingIntent = null;
    IBinder localIBinder1 = null;
    IBinder localIBinder2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 3: 
        localIBinder1 = zza.zzq(paramParcel, m);
        break;
      case 4: 
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 5: 
        i = zza.zzg(paramParcel, m);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 8: 
        bool = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new UnsubscribeRequest(j, localIBinder2, localIBinder1, localPendingIntent, i, str2, str1, bool);
  }
  
  public UnsubscribeRequest[] zzjg(int paramInt)
  {
    return new UnsubscribeRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */