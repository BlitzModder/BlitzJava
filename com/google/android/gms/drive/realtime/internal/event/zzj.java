package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<ValuesRemovedDetails>
{
  static void zza(ValuesRemovedDetails paramValuesRemovedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramValuesRemovedDetails.mVersionCode);
    zzb.zzc(paramParcel, 2, paramValuesRemovedDetails.mIndex);
    zzb.zzc(paramParcel, 3, paramValuesRemovedDetails.zzasJ);
    zzb.zzc(paramParcel, 4, paramValuesRemovedDetails.zzasK);
    zzb.zza(paramParcel, 5, paramValuesRemovedDetails.zzatk, false);
    zzb.zzc(paramParcel, 6, paramValuesRemovedDetails.zzatl);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ValuesRemovedDetails zzcH(Parcel paramParcel)
  {
    int i = 0;
    int i1 = zza.zzau(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzat(paramParcel);
      switch (zza.zzcc(i2))
      {
      default: 
        zza.zzb(paramParcel, i2);
        break;
      case 1: 
        n = zza.zzg(paramParcel, i2);
        break;
      case 2: 
        m = zza.zzg(paramParcel, i2);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i2);
        break;
      case 4: 
        j = zza.zzg(paramParcel, i2);
        break;
      case 5: 
        str = zza.zzp(paramParcel, i2);
        break;
      case 6: 
        i = zza.zzg(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new zza.zza("Overread allowed size end=" + i1, paramParcel);
    }
    return new ValuesRemovedDetails(n, m, k, j, str, i);
  }
  
  public ValuesRemovedDetails[] zzeD(int paramInt)
  {
    return new ValuesRemovedDetails[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */