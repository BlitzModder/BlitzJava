package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<FaceSettingsParcel>
{
  static void zza(FaceSettingsParcel paramFaceSettingsParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramFaceSettingsParcel.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramFaceSettingsParcel.mode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramFaceSettingsParcel.zzbiO);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, paramFaceSettingsParcel.zzbiP);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramFaceSettingsParcel.zzbiQ);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramFaceSettingsParcel.zzbiR);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public FaceSettingsParcel zzgY(Parcel paramParcel)
  {
    boolean bool1 = false;
    int n = zza.zzau(paramParcel);
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 6: 
        bool1 = zza.zzc(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new FaceSettingsParcel(m, k, j, i, bool2, bool1);
  }
  
  public FaceSettingsParcel[] zzkr(int paramInt)
  {
    return new FaceSettingsParcel[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/internal/client/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */