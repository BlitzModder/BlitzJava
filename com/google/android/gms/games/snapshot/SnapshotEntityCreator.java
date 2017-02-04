package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotEntityCreator
  implements Parcelable.Creator<SnapshotEntity>
{
  static void zza(SnapshotEntity paramSnapshotEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSnapshotEntity.getMetadata(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSnapshotEntity.getVersionCode());
    zzb.zza(paramParcel, 3, paramSnapshotEntity.getSnapshotContents(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SnapshotEntity zzet(Parcel paramParcel)
  {
    SnapshotContentsEntity localSnapshotContentsEntity = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    SnapshotMetadataEntity localSnapshotMetadataEntity = null;
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
        localSnapshotMetadataEntity = (SnapshotMetadataEntity)zza.zza(paramParcel, k, SnapshotMetadataEntity.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localSnapshotContentsEntity = (SnapshotContentsEntity)zza.zza(paramParcel, k, SnapshotContentsEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SnapshotEntity(i, localSnapshotMetadataEntity, localSnapshotContentsEntity);
  }
  
  public SnapshotEntity[] zzgK(int paramInt)
  {
    return new SnapshotEntity[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */