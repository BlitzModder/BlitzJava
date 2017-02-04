package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<PlacePhotoResult>
{
  static void zza(PlacePhotoResult paramPlacePhotoResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramPlacePhotoResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramPlacePhotoResult.mVersionCode);
    zzb.zza(paramParcel, 2, paramPlacePhotoResult.zzaMN, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlacePhotoResult zzeX(Parcel paramParcel)
  {
    BitmapTeleporter localBitmapTeleporter = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Status localStatus = null;
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
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localBitmapTeleporter = (BitmapTeleporter)zza.zza(paramParcel, k, BitmapTeleporter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlacePhotoResult(i, localStatus, localBitmapTeleporter);
  }
  
  public PlacePhotoResult[] zzhG(int paramInt)
  {
    return new PlacePhotoResult[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */