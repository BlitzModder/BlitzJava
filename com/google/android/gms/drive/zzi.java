package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<Permission>
{
  static void zza(Permission paramPermission, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPermission.mVersionCode);
    zzb.zza(paramParcel, 2, paramPermission.zzsr(), false);
    zzb.zzc(paramParcel, 3, paramPermission.zzss());
    zzb.zza(paramParcel, 4, paramPermission.zzst(), false);
    zzb.zza(paramParcel, 5, paramPermission.zzsu(), false);
    zzb.zzc(paramParcel, 6, paramPermission.getRole());
    zzb.zza(paramParcel, 7, paramPermission.zzsv());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Permission zzaN(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    int i = 0;
    String str2 = null;
    int j = 0;
    String str3 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
        break;
      case 7: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new Permission(k, str3, j, str2, str1, i, bool);
  }
  
  public Permission[] zzcC(int paramInt)
  {
    return new Permission[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */