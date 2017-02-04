package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<ParcelableEventList>
{
  static void zza(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableEventList.mVersionCode);
    zzb.zzc(paramParcel, 2, paramParcelableEventList.zzpw, false);
    zzb.zza(paramParcel, 3, paramParcelableEventList.zzasZ, paramInt, false);
    zzb.zza(paramParcel, 4, paramParcelableEventList.zzata);
    zzb.zzb(paramParcel, 5, paramParcelableEventList.zzatb, false);
    zzb.zza(paramParcel, 6, paramParcelableEventList.zzatc, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ParcelableEventList zzcB(Parcel paramParcel)
  {
    boolean bool = false;
    ParcelableChangeInfo localParcelableChangeInfo = null;
    int j = zza.zzau(paramParcel);
    ArrayList localArrayList1 = null;
    DataHolder localDataHolder = null;
    ArrayList localArrayList2 = null;
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
        localArrayList2 = zza.zzc(paramParcel, k, ParcelableEvent.CREATOR);
        break;
      case 3: 
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 5: 
        localArrayList1 = zza.zzD(paramParcel, k);
        break;
      case 6: 
        localParcelableChangeInfo = (ParcelableChangeInfo)zza.zza(paramParcel, k, ParcelableChangeInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEventList(i, localArrayList2, localDataHolder, bool, localArrayList1, localParcelableChangeInfo);
  }
  
  public ParcelableEventList[] zzex(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */