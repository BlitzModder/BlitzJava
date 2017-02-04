package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<Tile>
{
  static void zza(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramTile.getVersionCode());
    zzb.zzc(paramParcel, 2, paramTile.width);
    zzb.zzc(paramParcel, 3, paramTile.height);
    zzb.zza(paramParcel, 4, paramTile.data, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Tile zzfz(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzau(paramParcel);
    byte[] arrayOfByte = null;
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
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new Tile(i, j, k, arrayOfByte);
  }
  
  public Tile[] zzik(int paramInt)
  {
    return new Tile[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */