package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange
{
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
  
  public abstract Bitmap getCoverImage();
  
  public abstract String getDescription();
  
  public abstract Long getPlayedTimeMillis();
  
  public abstract Long getProgressValue();
  
  public abstract BitmapTeleporter zzxn();
  
  public static final class Builder
  {
    private Long zzaId;
    private Long zzaIe;
    private BitmapTeleporter zzaIf;
    private Uri zzaIg;
    private String zzavc;
    
    public SnapshotMetadataChange build()
    {
      return new SnapshotMetadataChangeEntity(this.zzavc, this.zzaId, this.zzaIf, this.zzaIg, this.zzaIe);
    }
    
    public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
    {
      this.zzavc = paramSnapshotMetadata.getDescription();
      this.zzaId = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
      this.zzaIe = Long.valueOf(paramSnapshotMetadata.getProgressValue());
      if (this.zzaId.longValue() == -1L) {
        this.zzaId = null;
      }
      this.zzaIg = paramSnapshotMetadata.getCoverImageUri();
      if (this.zzaIg != null) {
        this.zzaIf = null;
      }
      return this;
    }
    
    public Builder setCoverImage(Bitmap paramBitmap)
    {
      this.zzaIf = new BitmapTeleporter(paramBitmap);
      this.zzaIg = null;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzavc = paramString;
      return this;
    }
    
    public Builder setPlayedTimeMillis(long paramLong)
    {
      this.zzaId = Long.valueOf(paramLong);
      return this;
    }
    
    public Builder setProgressValue(long paramLong)
    {
      this.zzaIe = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */