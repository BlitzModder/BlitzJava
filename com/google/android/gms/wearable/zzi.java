package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<PutDataRequest>
{
  static void zza(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPutDataRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPutDataRequest.zzGy(), false);
    zzb.zza(paramParcel, 5, paramPutDataRequest.getData(), false);
    zzb.zza(paramParcel, 6, paramPutDataRequest.zzGz());
    zzb.zzI(paramParcel, i);
  }
  
  public PutDataRequest zzhL(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    Bundle localBundle = null;
    Uri localUri = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      case 3: 
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 4: 
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 5: 
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 6: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PutDataRequest(i, localUri, localBundle, arrayOfByte, l);
  }
  
  public PutDataRequest[] zzlj(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */