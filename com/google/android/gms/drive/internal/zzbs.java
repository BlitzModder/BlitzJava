package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzbs
  implements Parcelable.Creator<SetResourceParentsRequest>
{
  static void zza(SetResourceParentsRequest paramSetResourceParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSetResourceParentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramSetResourceParentsRequest.zzaod, paramInt, false);
    zzb.zzc(paramParcel, 3, paramSetResourceParentsRequest.zzaqx, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SetResourceParentsRequest zzbR(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
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
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        continue;
        localArrayList = zza.zzc(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SetResourceParentsRequest(i, localDriveId, localArrayList);
  }
  
  public SetResourceParentsRequest[] zzdM(int paramInt)
  {
    return new SetResourceParentsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */