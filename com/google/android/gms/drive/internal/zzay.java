package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;

public class zzay
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnDownloadProgressResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnDownloadProgressResponse.zzaqf);
    zzb.zza(paramParcel, 3, paramOnDownloadProgressResponse.zzaqg);
    zzb.zzc(paramParcel, 4, paramOnDownloadProgressResponse.zzAk);
    zzb.zzc(paramParcel, 5, paramOnDownloadProgressResponse.zzaqh, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public OnDownloadProgressResponse zzby(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int k = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
    long l2 = 0L;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        localArrayList = zza.zzc(paramParcel, m, DriveFileRange.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new OnDownloadProgressResponse(j, l2, l1, i, localArrayList);
  }
  
  public OnDownloadProgressResponse[] zzdt(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */