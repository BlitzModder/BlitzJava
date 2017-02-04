package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<ChannelEventParcelable>
{
  static void zza(ChannelEventParcelable paramChannelEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramChannelEventParcelable.mVersionCode);
    zzb.zza(paramParcel, 2, paramChannelEventParcelable.zzbmX, paramInt, false);
    zzb.zzc(paramParcel, 3, paramChannelEventParcelable.type);
    zzb.zzc(paramParcel, 4, paramChannelEventParcelable.zzbmV);
    zzb.zzc(paramParcel, 5, paramChannelEventParcelable.zzbmW);
    zzb.zzI(paramParcel, i);
  }
  
  public ChannelEventParcelable zzhR(Parcel paramParcel)
  {
    int i = 0;
    int n = zza.zzau(paramParcel);
    ChannelImpl localChannelImpl = null;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        localChannelImpl = (ChannelImpl)zza.zza(paramParcel, i1, ChannelImpl.CREATOR);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new ChannelEventParcelable(m, localChannelImpl, k, j, i);
  }
  
  public ChannelEventParcelable[] zzlr(int paramInt)
  {
    return new ChannelEventParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */