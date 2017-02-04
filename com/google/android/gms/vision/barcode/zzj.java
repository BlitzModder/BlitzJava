package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<Barcode.Phone>
{
  static void zza(Barcode.Phone paramPhone, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPhone.versionCode);
    zzb.zzc(paramParcel, 2, paramPhone.type);
    zzb.zza(paramParcel, 3, paramPhone.number, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.Phone zzgS(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Barcode.Phone(i, j, str);
  }
  
  public Barcode.Phone[] zzkl(int paramInt)
  {
    return new Barcode.Phone[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/barcode/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */