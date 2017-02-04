package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ParcelableIndexReference>
{
  static void zza(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableIndexReference.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableIndexReference.zzasF, false);
    zzb.zzc(paramParcel, 3, paramParcelableIndexReference.mIndex);
    zzb.zza(paramParcel, 4, paramParcelableIndexReference.zzasG);
    zzb.zzc(paramParcel, 5, paramParcelableIndexReference.zzasH);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParcelableIndexReference zzcx(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    String str = null;
    int i = -1;
    int j = 0;
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
        str = zza.zzp(paramParcel, n);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ParcelableIndexReference(k, str, j, bool, i);
  }
  
  public ParcelableIndexReference[] zzet(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */