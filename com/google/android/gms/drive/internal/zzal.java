package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

public class zzal
  implements Parcelable.Creator<GetPermissionsResponse>
{
  static void zza(GetPermissionsResponse paramGetPermissionsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetPermissionsResponse.mVersionCode);
    zzb.zzc(paramParcel, 2, paramGetPermissionsResponse.zzapL, false);
    zzb.zzc(paramParcel, 3, paramGetPermissionsResponse.zzyX);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetPermissionsResponse zzbs(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, m, Permission.CREATOR);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetPermissionsResponse(i, localArrayList, j);
  }
  
  public GetPermissionsResponse[] zzdn(int paramInt)
  {
    return new GetPermissionsResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */