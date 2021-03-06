package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentConditionEntityCreator
  implements Parcelable.Creator<AppContentConditionEntity>
{
  static void zza(AppContentConditionEntity paramAppContentConditionEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramAppContentConditionEntity.zzvz(), false);
    zzb.zzc(paramParcel, 1000, paramAppContentConditionEntity.getVersionCode());
    zzb.zza(paramParcel, 2, paramAppContentConditionEntity.zzvA(), false);
    zzb.zza(paramParcel, 3, paramAppContentConditionEntity.zzvB(), false);
    zzb.zza(paramParcel, 4, paramAppContentConditionEntity.zzvC(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AppContentConditionEntity zzea(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localBundle = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppContentConditionEntity(i, str3, str2, str1, localBundle);
  }
  
  public AppContentConditionEntity[] zzgc(int paramInt)
  {
    return new AppContentConditionEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentConditionEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */