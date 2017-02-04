package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzah
  implements Parcelable.Creator<GetChangesRequest>
{
  static void zza(GetChangesRequest paramGetChangesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetChangesRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramGetChangesRequest.zzapF, paramInt, false);
    zzb.zzc(paramParcel, 3, paramGetChangesRequest.zzapG);
    zzb.zzc(paramParcel, 4, paramGetChangesRequest.zzanF, false);
    zzb.zza(paramParcel, 5, paramGetChangesRequest.zzapH);
    zzb.zzI(paramParcel, i);
  }
  
  public GetChangesRequest zzbo(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    boolean bool = false;
    int k = zza.zzau(paramParcel);
    int i = 0;
    ChangeSequenceNumber localChangeSequenceNumber = null;
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
        localChangeSequenceNumber = (ChangeSequenceNumber)zza.zza(paramParcel, m, ChangeSequenceNumber.CREATOR);
        break;
      case 3: 
        i = zza.zzg(paramParcel, m);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, m, DriveSpace.CREATOR);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetChangesRequest(j, localChangeSequenceNumber, i, localArrayList, bool);
  }
  
  public GetChangesRequest[] zzdj(int paramInt)
  {
    return new GetChangesRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */