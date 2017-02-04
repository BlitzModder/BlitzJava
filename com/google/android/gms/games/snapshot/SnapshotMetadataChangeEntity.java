package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity
  extends SnapshotMetadataChange
  implements SafeParcelable
{
  public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
  private final int mVersionCode;
  private final Long zzaIe;
  private final Uri zzaIg;
  private final Long zzaIh;
  private BitmapTeleporter zzaIi;
  private final String zzavc;
  
  SnapshotMetadataChangeEntity()
  {
    this(5, null, null, null, null, null);
  }
  
  SnapshotMetadataChangeEntity(int paramInt, String paramString, Long paramLong1, BitmapTeleporter paramBitmapTeleporter, Uri paramUri, Long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzavc = paramString;
    this.zzaIh = paramLong1;
    this.zzaIi = paramBitmapTeleporter;
    this.zzaIg = paramUri;
    this.zzaIe = paramLong2;
    if (this.zzaIi != null) {
      if (this.zzaIg == null) {
        zzx.zza(bool1, "Cannot set both a URI and an image");
      }
    }
    while (this.zzaIg == null) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    if (this.zzaIi == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      zzx.zza(bool1, "Cannot set both a URI and an image");
      return;
    }
  }
  
  SnapshotMetadataChangeEntity(String paramString, Long paramLong1, BitmapTeleporter paramBitmapTeleporter, Uri paramUri, Long paramLong2)
  {
    this(5, paramString, paramLong1, paramBitmapTeleporter, paramUri, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getCoverImage()
  {
    if (this.zzaIi == null) {
      return null;
    }
    return this.zzaIi.zzpI();
  }
  
  public Uri getCoverImageUri()
  {
    return this.zzaIg;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public Long getPlayedTimeMillis()
  {
    return this.zzaIh;
  }
  
  public Long getProgressValue()
  {
    return this.zzaIe;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataChangeCreator.zza(this, paramParcel, paramInt);
  }
  
  public BitmapTeleporter zzxn()
  {
    return this.zzaIi;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChangeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */