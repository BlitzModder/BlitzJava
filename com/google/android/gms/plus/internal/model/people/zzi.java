package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzi
  implements Parcelable.Creator<PersonEntity.PlacesLivedEntity>
{
  static void zza(PersonEntity.PlacesLivedEntity paramPlacesLivedEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    Set localSet = paramPlacesLivedEntity.zzaZA;
    if (localSet.contains(Integer.valueOf(1))) {
      zzb.zzc(paramParcel, 1, paramPlacesLivedEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzb.zza(paramParcel, 2, paramPlacesLivedEntity.zzbbe);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzb.zza(paramParcel, 3, paramPlacesLivedEntity.mValue, true);
    }
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.PlacesLivedEntity zzgB(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzau(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        bool = zza.zzc(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PersonEntity.PlacesLivedEntity(localHashSet, i, bool, str);
  }
  
  public PersonEntity.PlacesLivedEntity[] zzjE(int paramInt)
  {
    return new PersonEntity.PlacesLivedEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */