package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<PlaceAliasResult>
{
  static void zza(PlaceAliasResult paramPlaceAliasResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceAliasResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramPlaceAliasResult.mVersionCode);
    zzb.zza(paramParcel, 2, paramPlaceAliasResult.zzyP(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlaceAliasResult zzfi(Parcel paramParcel)
  {
    PlaceUserData localPlaceUserData = null;
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
        localPlaceUserData = (PlaceUserData)zza.zza(paramParcel, k, PlaceUserData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceAliasResult(i, localStatus, localPlaceUserData);
  }
  
  public PlaceAliasResult[] zzhT(int paramInt)
  {
    return new PlaceAliasResult[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/personalized/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */