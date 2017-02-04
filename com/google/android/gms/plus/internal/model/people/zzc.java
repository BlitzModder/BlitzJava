package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzc
  implements Parcelable.Creator<PersonEntity.CoverEntity>
{
  static void zza(PersonEntity.CoverEntity paramCoverEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    Set localSet = paramCoverEntity.zzaZA;
    if (localSet.contains(Integer.valueOf(1))) {
      zzb.zzc(paramParcel, 1, paramCoverEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzb.zza(paramParcel, 2, paramCoverEntity.zzbaT, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzb.zza(paramParcel, 3, paramCoverEntity.zzbaU, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      zzb.zzc(paramParcel, 4, paramCoverEntity.zzbaV);
    }
    zzb.zzI(paramParcel, i);
  }
  
  public PersonEntity.CoverEntity zzgv(Parcel paramParcel)
  {
    PersonEntity.CoverEntity.CoverPhotoEntity localCoverPhotoEntity = null;
    int i = 0;
    int k = zza.zzau(paramParcel);
    HashSet localHashSet = new HashSet();
    PersonEntity.CoverEntity.CoverInfoEntity localCoverInfoEntity = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        localCoverInfoEntity = (PersonEntity.CoverEntity.CoverInfoEntity)zza.zza(paramParcel, m, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localCoverPhotoEntity = (PersonEntity.CoverEntity.CoverPhotoEntity)zza.zza(paramParcel, m, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PersonEntity.CoverEntity(localHashSet, j, localCoverInfoEntity, localCoverPhotoEntity, i);
  }
  
  public PersonEntity.CoverEntity[] zzjy(int paramInt)
  {
    return new PersonEntity.CoverEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */