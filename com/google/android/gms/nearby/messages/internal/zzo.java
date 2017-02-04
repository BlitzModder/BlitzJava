package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<RegisterStatusCallbackRequest>
{
  static void zza(RegisterStatusCallbackRequest paramRegisterStatusCallbackRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRegisterStatusCallbackRequest.versionCode);
    zzb.zza(paramParcel, 2, paramRegisterStatusCallbackRequest.zzCJ(), false);
    zzb.zza(paramParcel, 3, paramRegisterStatusCallbackRequest.zzCL(), false);
    zzb.zza(paramParcel, 4, paramRegisterStatusCallbackRequest.zzaXK);
    zzb.zza(paramParcel, 5, paramRegisterStatusCallbackRequest.zzaWI, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RegisterStatusCallbackRequest zzgb(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int j = zza.zzau(paramParcel);
    IBinder localIBinder1 = null;
    IBinder localIBinder2 = null;
    int i = 0;
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
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 5: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RegisterStatusCallbackRequest(i, localIBinder2, localIBinder1, bool, str);
  }
  
  public RegisterStatusCallbackRequest[] zzjd(int paramInt)
  {
    return new RegisterStatusCallbackRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */