package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzf
  implements Parcelable.Creator<PersonEntity.ImageEntity>
{
  static void zza(PersonEntity.ImageEntity paramImageEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    Set localSet = paramImageEntity.zzaZA;
    if (localSet.contains(Integer.valueOf(1))) {
      zzb.zzc(paramParcel, 1, paramImageEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzb.zza(paramParcel, 2, paramImageEntity.zzF, true);
    }
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.ImageEntity zzgy(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PersonEntity.ImageEntity(localHashSet, i, str);
  }
  
  public PersonEntity.ImageEntity[] zzjB(int paramInt)
  {
    return new PersonEntity.ImageEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */