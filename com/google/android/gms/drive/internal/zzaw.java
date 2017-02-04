package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzaw
  implements Parcelable.Creator<OnContentsResponse>
{
  static void zza(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnContentsResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnContentsResponse.zzaoW, paramInt, false);
    zzb.zza(paramParcel, 3, paramOnContentsResponse.zzaqc);
    zzb.zzI(paramParcel, i);
  }
  
  public OnContentsResponse zzbw(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzau(paramParcel);
    Contents localContents = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localContents = (Contents)zza.zza(paramParcel, k, Contents.CREATOR);
        continue;
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnContentsResponse(i, localContents, bool);
  }
  
  public OnContentsResponse[] zzdr(int paramInt)
  {
    return new OnContentsResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */