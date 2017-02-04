package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void zza(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramReferenceShiftedDetails.mVersionCode);
    zzb.zza(paramParcel, 2, paramReferenceShiftedDetails.zzatd, false);
    zzb.zza(paramParcel, 3, paramReferenceShiftedDetails.zzate, false);
    zzb.zzc(paramParcel, 4, paramReferenceShiftedDetails.zzatf);
    zzb.zzc(paramParcel, 5, paramReferenceShiftedDetails.zzatg);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ReferenceShiftedDetails zzcC(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zza.zzau(paramParcel);
    int j = 0;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, n);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ReferenceShiftedDetails(k, str2, str1, j, i);
  }
  
  public ReferenceShiftedDetails[] zzey(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */