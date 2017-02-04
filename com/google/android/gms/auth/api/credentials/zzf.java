package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<PasswordSpecification>
{
  static void zza(PasswordSpecification paramPasswordSpecification, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramPasswordSpecification.zzUQ, false);
    zzb.zzc(paramParcel, 1000, paramPasswordSpecification.mVersionCode);
    zzb.zzb(paramParcel, 2, paramPasswordSpecification.zzUR, false);
    zzb.zza(paramParcel, 3, paramPasswordSpecification.zzUS, false);
    zzb.zzc(paramParcel, 4, paramPasswordSpecification.zzUT);
    zzb.zzc(paramParcel, 5, paramPasswordSpecification.zzUU);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PasswordSpecification zzJ(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int i = 0;
    int m = zza.zzau(paramParcel);
    int j = 0;
    ArrayList localArrayList2 = null;
    String str = null;
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
        str = zza.zzp(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localArrayList2 = zza.zzD(paramParcel, n);
        break;
      case 3: 
        localArrayList1 = zza.zzC(paramParcel, n);
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
    return new PasswordSpecification(k, str, localArrayList2, localArrayList1, j, i);
  }
  
  public PasswordSpecification[] zzaE(int paramInt)
  {
    return new PasswordSpecification[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */