package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<CapabilityInfoParcelable>
{
  static void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCapabilityInfoParcelable.mVersionCode);
    zzb.zza(paramParcel, 2, paramCapabilityInfoParcelable.getName(), false);
    zzb.zzc(paramParcel, 3, paramCapabilityInfoParcelable.zzGK(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CapabilityInfoParcelable zzhQ(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
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
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CapabilityInfoParcelable(i, str, localArrayList);
  }
  
  public CapabilityInfoParcelable[] zzlo(int paramInt)
  {
    return new CapabilityInfoParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */