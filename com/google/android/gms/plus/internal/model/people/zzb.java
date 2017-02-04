package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.HashSet;
import java.util.Set;

public class zzb
  implements Parcelable.Creator<PersonEntity.AgeRangeEntity>
{
  static void zza(PersonEntity.AgeRangeEntity paramAgeRangeEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    Set localSet = paramAgeRangeEntity.zzaZA;
    if (localSet.contains(Integer.valueOf(1))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAgeRangeEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramAgeRangeEntity.zzbaR);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramAgeRangeEntity.zzbaS);
    }
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.AgeRangeEntity zzgu(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzau(paramParcel);
    HashSet localHashSet = new HashSet();
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new PersonEntity.AgeRangeEntity(localHashSet, i, j, k);
  }
  
  public PersonEntity.AgeRangeEntity[] zzjx(int paramInt)
  {
    return new PersonEntity.AgeRangeEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */