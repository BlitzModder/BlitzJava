package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzan
  implements Parcelable.Creator<GetCloudSyncOptInStatusResponse>
{
  static void zza(GetCloudSyncOptInStatusResponse paramGetCloudSyncOptInStatusResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetCloudSyncOptInStatusResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetCloudSyncOptInStatusResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetCloudSyncOptInStatusResponse.zzbnA);
    zzb.zza(paramParcel, 4, paramGetCloudSyncOptInStatusResponse.zzbnB);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetCloudSyncOptInStatusResponse zzif(Parcel paramParcel)
  {
    boolean bool2 = false;
    int k = zza.zzau(paramParcel);
    boolean bool1 = false;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetCloudSyncOptInStatusResponse(i, j, bool1, bool2);
  }
  
  public GetCloudSyncOptInStatusResponse[] zzlG(int paramInt)
  {
    return new GetCloudSyncOptInStatusResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */