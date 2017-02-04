package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd
  implements Parcelable.Creator<LargeAssetEnqueueRequest>
{
  static void zza(LargeAssetEnqueueRequest paramLargeAssetEnqueueRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetEnqueueRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramLargeAssetEnqueueRequest.zzbnJ, false);
    zzb.zza(paramParcel, 3, paramLargeAssetEnqueueRequest.zzbnK, false);
    zzb.zza(paramParcel, 4, paramLargeAssetEnqueueRequest.zzaXR, paramInt, false);
    zzb.zza(paramParcel, 5, paramLargeAssetEnqueueRequest.zzbnL, false);
    zzb.zza(paramParcel, 6, paramLargeAssetEnqueueRequest.zzbnM);
    zzb.zza(paramParcel, 7, paramLargeAssetEnqueueRequest.zzbnN);
    zzb.zza(paramParcel, 8, paramLargeAssetEnqueueRequest.zzbnO);
    zzb.zzI(paramParcel, i);
  }
  
  public LargeAssetEnqueueRequest zzio(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int j = zza.zzau(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    Uri localUri = null;
    String str2 = null;
    String str3 = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 7: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 8: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LargeAssetEnqueueRequest(i, str3, str2, localUri, str1, bool3, bool2, bool1);
  }
  
  public LargeAssetEnqueueRequest[] zzlP(int paramInt)
  {
    return new LargeAssetEnqueueRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */