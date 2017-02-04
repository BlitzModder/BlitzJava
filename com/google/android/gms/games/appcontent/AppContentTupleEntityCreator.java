package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentTupleEntityCreator
  implements Parcelable.Creator<AppContentTupleEntity>
{
  static void zza(AppContentTupleEntity paramAppContentTupleEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramAppContentTupleEntity.getName(), false);
    zzb.zzc(paramParcel, 1000, paramAppContentTupleEntity.getVersionCode());
    zzb.zza(paramParcel, 2, paramAppContentTupleEntity.getValue(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AppContentTupleEntity zzec(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppContentTupleEntity(i, str1, str2);
  }
  
  public AppContentTupleEntity[] zzge(int paramInt)
  {
    return new AppContentTupleEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentTupleEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */