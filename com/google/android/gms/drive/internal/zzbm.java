package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void zza(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOpenFileIntentSenderRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramOpenFileIntentSenderRequest.zzank, false);
    zzb.zza(paramParcel, 3, paramOpenFileIntentSenderRequest.zzanl, false);
    zzb.zza(paramParcel, 4, paramOpenFileIntentSenderRequest.zzann, paramInt, false);
    zzb.zza(paramParcel, 5, paramOpenFileIntentSenderRequest.zzaqv, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OpenFileIntentSenderRequest zzbL(Parcel paramParcel)
  {
    FilterHolder localFilterHolder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    String[] arrayOfString = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        arrayOfString = zza.zzB(paramParcel, k);
        break;
      case 4: 
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        break;
      case 5: 
        localFilterHolder = (FilterHolder)zza.zza(paramParcel, k, FilterHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId, localFilterHolder);
  }
  
  public OpenFileIntentSenderRequest[] zzdG(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */