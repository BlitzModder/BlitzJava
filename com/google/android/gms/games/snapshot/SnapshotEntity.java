package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class SnapshotEntity
  implements SafeParcelable, Snapshot
{
  public static final Parcelable.Creator<SnapshotEntity> CREATOR = new SnapshotEntityCreator();
  private final int mVersionCode;
  private final SnapshotMetadataEntity zzaIb;
  private final SnapshotContentsEntity zzaIc;
  
  SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, SnapshotContentsEntity paramSnapshotContentsEntity)
  {
    this.mVersionCode = paramInt;
    this.zzaIb = new SnapshotMetadataEntity(paramSnapshotMetadata);
    this.zzaIc = paramSnapshotContentsEntity;
  }
  
  public SnapshotEntity(SnapshotMetadata paramSnapshotMetadata, SnapshotContentsEntity paramSnapshotContentsEntity)
  {
    this(2, paramSnapshotMetadata, paramSnapshotContentsEntity);
  }
  
  private boolean isClosed()
  {
    return this.zzaIc.isClosed();
  }
  
  static boolean zza(Snapshot paramSnapshot, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Snapshot)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSnapshot == paramObject);
      paramObject = (Snapshot)paramObject;
      if (!zzw.equal(((Snapshot)paramObject).getMetadata(), paramSnapshot.getMetadata())) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Snapshot)paramObject).getSnapshotContents(), paramSnapshot.getSnapshotContents()));
    return false;
  }
  
  static int zzb(Snapshot paramSnapshot)
  {
    return zzw.hashCode(new Object[] { paramSnapshot.getMetadata(), paramSnapshot.getSnapshotContents() });
  }
  
  static String zzc(Snapshot paramSnapshot)
  {
    zzw.zza localzza = zzw.zzx(paramSnapshot).zzg("Metadata", paramSnapshot.getMetadata());
    if (paramSnapshot.getSnapshotContents() != null) {}
    for (boolean bool = true;; bool = false) {
      return localzza.zzg("HasContents", Boolean.valueOf(bool)).toString();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Snapshot freeze()
  {
    return this;
  }
  
  public SnapshotMetadata getMetadata()
  {
    return this.zzaIb;
  }
  
  public SnapshotContents getSnapshotContents()
  {
    if (isClosed()) {
      return null;
    }
    return this.zzaIc;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzb(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */