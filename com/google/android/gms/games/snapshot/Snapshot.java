package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Snapshot
  extends Parcelable, Freezable<Snapshot>
{
  public abstract SnapshotMetadata getMetadata();
  
  public abstract SnapshotContents getSnapshotContents();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/Snapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */