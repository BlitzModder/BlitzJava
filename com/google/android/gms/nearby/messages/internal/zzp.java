package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzp
  implements Parcelable.Creator<SubscribeRequest>
{
  static void zza(SubscribeRequest paramSubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSubscribeRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramSubscribeRequest.zzCM(), false);
    zzb.zza(paramParcel, 3, paramSubscribeRequest.zzaXG, paramInt, false);
    zzb.zza(paramParcel, 4, paramSubscribeRequest.zzCJ(), false);
    zzb.zza(paramParcel, 5, paramSubscribeRequest.zzaXM, paramInt, false);
    zzb.zza(paramParcel, 6, paramSubscribeRequest.zzaXN, paramInt, false);
    zzb.zzc(paramParcel, 7, paramSubscribeRequest.zzaXO);
    zzb.zza(paramParcel, 8, paramSubscribeRequest.zzaWI, false);
    zzb.zza(paramParcel, 9, paramSubscribeRequest.zzaXH, false);
    zzb.zza(paramParcel, 10, paramSubscribeRequest.zzaXP, false);
    zzb.zza(paramParcel, 11, paramSubscribeRequest.zzaWJ);
    zzb.zza(paramParcel, 12, paramSubscribeRequest.zzCN(), false);
    zzb.zza(paramParcel, 13, paramSubscribeRequest.zzaWK);
    zzb.zzI(paramParcel, i);
  }
  
  public SubscribeRequest zzgc(Parcel paramParcel)
  {
    int k = zza.zzau(paramParcel);
    int j = 0;
    IBinder localIBinder3 = null;
    Strategy localStrategy = null;
    IBinder localIBinder2 = null;
    MessageFilter localMessageFilter = null;
    PendingIntent localPendingIntent = null;
    int i = 0;
    String str2 = null;
    String str1 = null;
    byte[] arrayOfByte = null;
    boolean bool2 = false;
    IBinder localIBinder1 = null;
    boolean bool1 = false;
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
        localIBinder3 = zza.zzq(paramParcel, m);
        break;
      case 3: 
        localStrategy = (Strategy)zza.zza(paramParcel, m, Strategy.CREATOR);
        break;
      case 4: 
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 5: 
        localMessageFilter = (MessageFilter)zza.zza(paramParcel, m, MessageFilter.CREATOR);
        break;
      case 6: 
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 7: 
        i = zza.zzg(paramParcel, m);
        break;
      case 8: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 9: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 10: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 11: 
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 12: 
        localIBinder1 = zza.zzq(paramParcel, m);
        break;
      case 13: 
        bool1 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new SubscribeRequest(j, localIBinder3, localStrategy, localIBinder2, localMessageFilter, localPendingIntent, i, str2, str1, arrayOfByte, bool2, localIBinder1, bool1);
  }
  
  public SubscribeRequest[] zzje(int paramInt)
  {
    return new SubscribeRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */