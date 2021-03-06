package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzg
  implements Parcelable.Creator<PersonEntity.NameEntity>
{
  static void zza(PersonEntity.NameEntity paramNameEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    Set localSet = paramNameEntity.zzaZA;
    if (localSet.contains(Integer.valueOf(1))) {
      zzb.zzc(paramParcel, 1, paramNameEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzb.zza(paramParcel, 2, paramNameEntity.zzaZY, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzb.zza(paramParcel, 3, paramNameEntity.zzbaY, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      zzb.zza(paramParcel, 4, paramNameEntity.zzbab, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      zzb.zza(paramParcel, 5, paramNameEntity.zzbaZ, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      zzb.zza(paramParcel, 6, paramNameEntity.zzbba, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      zzb.zza(paramParcel, 7, paramNameEntity.zzbbb, true);
    }
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.NameEntity zzgz(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzau(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
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
        str6 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str5 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str4 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str3 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PersonEntity.NameEntity(localHashSet, i, str6, str5, str4, str3, str2, str1);
  }
  
  public PersonEntity.NameEntity[] zzjC(int paramInt)
  {
    return new PersonEntity.NameEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */