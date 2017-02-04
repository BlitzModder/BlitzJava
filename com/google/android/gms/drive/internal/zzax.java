package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzax
  implements Parcelable.Creator<OnDeviceUsagePreferenceResponse>
{
  static void zza(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnDeviceUsagePreferenceResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnDeviceUsagePreferenceResponse.zzaqd, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnDeviceUsagePreferenceResponse zzbx(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    FileUploadPreferencesImpl localFileUploadPreferencesImpl = null;
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
        localFileUploadPreferencesImpl = (FileUploadPreferencesImpl)zza.zza(paramParcel, k, FileUploadPreferencesImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDeviceUsagePreferenceResponse(i, localFileUploadPreferencesImpl);
  }
  
  public OnDeviceUsagePreferenceResponse[] zzds(int paramInt)
  {
    return new OnDeviceUsagePreferenceResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */