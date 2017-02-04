package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzba
  implements Parcelable.Creator<OnDrivePreferencesResponse>
{
  static void zza(OnDrivePreferencesResponse paramOnDrivePreferencesResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnDrivePreferencesResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnDrivePreferencesResponse.zzaqi, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnDrivePreferencesResponse zzbA(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    DrivePreferences localDrivePreferences = null;
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
        localDrivePreferences = (DrivePreferences)zza.zza(paramParcel, k, DrivePreferences.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDrivePreferencesResponse(i, localDrivePreferences);
  }
  
  public OnDrivePreferencesResponse[] zzdv(int paramInt)
  {
    return new OnDrivePreferencesResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */