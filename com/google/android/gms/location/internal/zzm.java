package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzm
  implements Parcelable.Creator<LocationRequestInternal>
{
  static void zza(LocationRequestInternal paramLocationRequestInternal, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramLocationRequestInternal.zzayV, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramLocationRequestInternal.getVersionCode());
    zzb.zza(paramParcel, 2, paramLocationRequestInternal.zzaMb);
    zzb.zza(paramParcel, 3, paramLocationRequestInternal.zzaMc);
    zzb.zza(paramParcel, 4, paramLocationRequestInternal.zzaMd);
    zzb.zzc(paramParcel, 5, paramLocationRequestInternal.zzaMe, false);
    zzb.zza(paramParcel, 6, paramLocationRequestInternal.mTag, false);
    zzb.zza(paramParcel, 7, paramLocationRequestInternal.zzaMf);
    zzb.zzI(paramParcel, i);
  }
  
  public LocationRequestInternal zzeO(Parcel paramParcel)
  {
    String str = null;
    boolean bool2 = true;
    boolean bool1 = false;
    int j = zza.zzau(paramParcel);
    Object localObject = LocationRequestInternal.zzaMa;
    boolean bool3 = true;
    boolean bool4 = false;
    LocationRequest localLocationRequest = null;
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
        localLocationRequest = (LocationRequest)zza.zza(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        localObject = zza.zzc(paramParcel, k, ClientIdentity.CREATOR);
        break;
      case 6: 
        str = zza.zzp(paramParcel, k);
        break;
      case 7: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationRequestInternal(i, localLocationRequest, bool4, bool3, bool2, (List)localObject, str, bool1);
  }
  
  public LocationRequestInternal[] zzhu(int paramInt)
  {
    return new LocationRequestInternal[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */