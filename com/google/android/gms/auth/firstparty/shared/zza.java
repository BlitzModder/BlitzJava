package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<FACLConfig>
{
  static void zza(FACLConfig paramFACLConfig, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramFACLConfig.version);
    zzb.zza(paramParcel, 2, paramFACLConfig.zzWH);
    zzb.zza(paramParcel, 3, paramFACLConfig.zzWI, false);
    zzb.zza(paramParcel, 4, paramFACLConfig.zzWJ);
    zzb.zza(paramParcel, 5, paramFACLConfig.zzWK);
    zzb.zza(paramParcel, 6, paramFACLConfig.zzWL);
    zzb.zza(paramParcel, 7, paramFACLConfig.zzWM);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public FACLConfig zzW(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    String str = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 4: 
        bool4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 6: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 7: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FACLConfig(i, bool5, str, bool4, bool3, bool2, bool1);
  }
  
  public FACLConfig[] zzaT(int paramInt)
  {
    return new FACLConfig[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/firstparty/shared/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */