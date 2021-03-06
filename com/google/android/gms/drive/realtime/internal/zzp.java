package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

public class zzp
  implements Parcelable.Creator<ParcelableChangeInfo>
{
  static void zza(ParcelableChangeInfo paramParcelableChangeInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableChangeInfo.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableChangeInfo.zzacS);
    zzb.zzc(paramParcel, 3, paramParcelableChangeInfo.zzpw, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParcelableChangeInfo zzcv(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    ArrayList localArrayList = null;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, ParcelableEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableChangeInfo(i, l, localArrayList);
  }
  
  public ParcelableChangeInfo[] zzer(int paramInt)
  {
    return new ParcelableChangeInfo[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */