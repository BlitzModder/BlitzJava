package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<Contents>
{
  static void zza(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramContents.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramContents.zzaid, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramContents.zzamD);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, paramContents.zzamE);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramContents.zzamF, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramContents.zzamG);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, paramContents.zzsL, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public Contents zzaI(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    DriveId localDriveId = null;
    int i = 0;
    int j = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      case 6: 
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, n, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        i = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        break;
      case 7: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 8: 
        str = zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new Contents(k, localParcelFileDescriptor, j, i, localDriveId, bool, str);
  }
  
  public Contents[] zzct(int paramInt)
  {
    return new Contents[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */