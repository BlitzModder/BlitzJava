package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
  private final int mVersionCode;
  private final String zzaBL;
  private final GameEntity zzaGU;
  private final Uri zzaIg;
  private final PlayerEntity zzaIj;
  private final String zzaIk;
  private final long zzaIl;
  private final long zzaIm;
  private final float zzaIn;
  private final String zzaIo;
  private final boolean zzaIp;
  private final long zzaIq;
  private final String zzaIr;
  private final String zzank;
  private final String zzavc;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5, boolean paramBoolean, long paramLong3, String paramString6)
  {
    this.mVersionCode = paramInt;
    this.zzaGU = paramGameEntity;
    this.zzaIj = paramPlayerEntity;
    this.zzaBL = paramString1;
    this.zzaIg = paramUri;
    this.zzaIk = paramString2;
    this.zzaIn = paramFloat;
    this.zzank = paramString3;
    this.zzavc = paramString4;
    this.zzaIl = paramLong1;
    this.zzaIm = paramLong2;
    this.zzaIo = paramString5;
    this.zzaIp = paramBoolean;
    this.zzaIq = paramLong3;
    this.zzaIr = paramString6;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.mVersionCode = 6;
    this.zzaGU = new GameEntity(paramSnapshotMetadata.getGame());
    this.zzaIj = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.zzaBL = paramSnapshotMetadata.getSnapshotId();
    this.zzaIg = paramSnapshotMetadata.getCoverImageUri();
    this.zzaIk = paramSnapshotMetadata.getCoverImageUrl();
    this.zzaIn = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.zzank = paramSnapshotMetadata.getTitle();
    this.zzavc = paramSnapshotMetadata.getDescription();
    this.zzaIl = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.zzaIm = paramSnapshotMetadata.getPlayedTime();
    this.zzaIo = paramSnapshotMetadata.getUniqueName();
    this.zzaIp = paramSnapshotMetadata.hasChangePending();
    this.zzaIq = paramSnapshotMetadata.getProgressValue();
    this.zzaIr = paramSnapshotMetadata.getDeviceName();
  }
  
  static int zza(SnapshotMetadata paramSnapshotMetadata)
  {
    return zzw.hashCode(new Object[] { paramSnapshotMetadata.getGame(), paramSnapshotMetadata.getOwner(), paramSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getCoverImageUri(), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()), paramSnapshotMetadata.getTitle(), paramSnapshotMetadata.getDescription(), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()), paramSnapshotMetadata.getUniqueName(), Boolean.valueOf(paramSnapshotMetadata.hasChangePending()), Long.valueOf(paramSnapshotMetadata.getProgressValue()), paramSnapshotMetadata.getDeviceName() });
  }
  
  static boolean zza(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SnapshotMetadata)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSnapshotMetadata == paramObject);
      paramObject = (SnapshotMetadata)paramObject;
      if ((!zzw.equal(((SnapshotMetadata)paramObject).getGame(), paramSnapshotMetadata.getGame())) || (!zzw.equal(((SnapshotMetadata)paramObject).getOwner(), paramSnapshotMetadata.getOwner())) || (!zzw.equal(((SnapshotMetadata)paramObject).getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) || (!zzw.equal(((SnapshotMetadata)paramObject).getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) || (!zzw.equal(Float.valueOf(((SnapshotMetadata)paramObject).getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) || (!zzw.equal(((SnapshotMetadata)paramObject).getTitle(), paramSnapshotMetadata.getTitle())) || (!zzw.equal(((SnapshotMetadata)paramObject).getDescription(), paramSnapshotMetadata.getDescription())) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()))) || (!zzw.equal(((SnapshotMetadata)paramObject).getUniqueName(), paramSnapshotMetadata.getUniqueName())) || (!zzw.equal(Boolean.valueOf(((SnapshotMetadata)paramObject).hasChangePending()), Boolean.valueOf(paramSnapshotMetadata.hasChangePending()))) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getProgressValue()), Long.valueOf(paramSnapshotMetadata.getProgressValue())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((SnapshotMetadata)paramObject).getDeviceName(), paramSnapshotMetadata.getDeviceName()));
    return false;
  }
  
  static String zzb(SnapshotMetadata paramSnapshotMetadata)
  {
    return zzw.zzx(paramSnapshotMetadata).zzg("Game", paramSnapshotMetadata.getGame()).zzg("Owner", paramSnapshotMetadata.getOwner()).zzg("SnapshotId", paramSnapshotMetadata.getSnapshotId()).zzg("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).zzg("Description", paramSnapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).zzg("UniqueName", paramSnapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(paramSnapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(paramSnapshotMetadata.getProgressValue())).zzg("DeviceName", paramSnapshotMetadata.getDeviceName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return this;
  }
  
  public float getCoverImageAspectRatio()
  {
    return this.zzaIn;
  }
  
  public Uri getCoverImageUri()
  {
    return this.zzaIg;
  }
  
  public String getCoverImageUrl()
  {
    return this.zzaIk;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public String getDeviceName()
  {
    return this.zzaIr;
  }
  
  public Game getGame()
  {
    return this.zzaGU;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.zzaIl;
  }
  
  public Player getOwner()
  {
    return this.zzaIj;
  }
  
  public long getPlayedTime()
  {
    return this.zzaIm;
  }
  
  public long getProgressValue()
  {
    return this.zzaIq;
  }
  
  public String getSnapshotId()
  {
    return this.zzaBL;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public String getUniqueName()
  {
    return this.zzaIo;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasChangePending()
  {
    return this.zzaIp;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */