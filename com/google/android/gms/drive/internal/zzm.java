package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void zza(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCreateFileIntentSenderRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCreateFileIntentSenderRequest.zzaot, paramInt, false);
    zzb.zzc(paramParcel, 3, paramCreateFileIntentSenderRequest.zzamD);
    zzb.zza(paramParcel, 4, paramCreateFileIntentSenderRequest.zzank, false);
    zzb.zza(paramParcel, 5, paramCreateFileIntentSenderRequest.zzann, paramInt, false);
    zzb.zza(paramParcel, 6, paramCreateFileIntentSenderRequest.zzaou, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest zzbg(Parcel paramParcel)
  {
    int i = 0;
    Integer localInteger = null;
    int k = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
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
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 3: 
        i = zza.zzg(paramParcel, m);
        break;
      case 4: 
        str = zza.zzp(paramParcel, m);
        break;
      case 5: 
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        break;
      case 6: 
        localInteger = zza.zzh(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CreateFileIntentSenderRequest(j, localMetadataBundle, i, str, localDriveId, localInteger);
  }
  
  public CreateFileIntentSenderRequest[] zzcX(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */