package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbn
  implements Parcelable.Creator<MessageEventParcelable>
{
  static void zza(MessageEventParcelable paramMessageEventParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramMessageEventParcelable.mVersionCode);
    zzb.zzc(paramParcel, 2, paramMessageEventParcelable.getRequestId());
    zzb.zza(paramParcel, 3, paramMessageEventParcelable.getPath(), false);
    zzb.zza(paramParcel, 4, paramMessageEventParcelable.getData(), false);
    zzb.zza(paramParcel, 5, paramMessageEventParcelable.getSourceNodeId(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public MessageEventParcelable zziv(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzau(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new MessageEventParcelable(j, i, str2, arrayOfByte, str1);
  }
  
  public MessageEventParcelable[] zzlX(int paramInt)
  {
    return new MessageEventParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */