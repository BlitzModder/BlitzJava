package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator
  implements Parcelable.Creator<SnapshotContentsEntity>
{
  static void zza(SnapshotContentsEntity paramSnapshotContentsEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSnapshotContentsEntity.zzsh(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSnapshotContentsEntity.getVersionCode());
    zzb.zzI(paramParcel, i);
  }
  
  public SnapshotContentsEntity zzes(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    Contents localContents = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localContents = (Contents)zza.zza(paramParcel, k, Contents.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SnapshotContentsEntity(i, localContents);
  }
  
  public SnapshotContentsEntity[] zzgJ(int paramInt)
  {
    return new SnapshotContentsEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotContentsEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */