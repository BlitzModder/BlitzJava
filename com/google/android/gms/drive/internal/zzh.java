package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzh
  implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest>
{
  static void zza(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCloseContentsAndUpdateMetadataRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCloseContentsAndUpdateMetadataRequest.zzaoh, paramInt, false);
    zzb.zza(paramParcel, 3, paramCloseContentsAndUpdateMetadataRequest.zzaoi, paramInt, false);
    zzb.zza(paramParcel, 4, paramCloseContentsAndUpdateMetadataRequest.zzaoj, paramInt, false);
    zzb.zza(paramParcel, 5, paramCloseContentsAndUpdateMetadataRequest.zzand);
    zzb.zza(paramParcel, 6, paramCloseContentsAndUpdateMetadataRequest.zzanc, false);
    zzb.zzc(paramParcel, 7, paramCloseContentsAndUpdateMetadataRequest.zzaok);
    zzb.zzc(paramParcel, 8, paramCloseContentsAndUpdateMetadataRequest.zzaol);
    zzb.zza(paramParcel, 9, paramCloseContentsAndUpdateMetadataRequest.zzaom);
    zzb.zzI(paramParcel, i);
  }
  
  public CloseContentsAndUpdateMetadataRequest zzbc(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int m = zza.zzau(paramParcel);
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, n, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)zza.zza(paramParcel, n, Contents.CREATOR);
        break;
      case 5: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 6: 
        str = zza.zzp(paramParcel, n);
        break;
      case 7: 
        j = zza.zzg(paramParcel, n);
        break;
      case 8: 
        i = zza.zzg(paramParcel, n);
        break;
      case 9: 
        bool1 = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new CloseContentsAndUpdateMetadataRequest(k, localDriveId, localMetadataBundle, localContents, bool2, str, j, i, bool1);
  }
  
  public CloseContentsAndUpdateMetadataRequest[] zzcS(int paramInt)
  {
    return new CloseContentsAndUpdateMetadataRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */