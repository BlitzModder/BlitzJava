package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class VideoEntity
  implements SafeParcelable, Video
{
  public static final Parcelable.Creator<VideoEntity> CREATOR = new VideoEntityCreator();
  private final int mVersionCode;
  private final long zzBv;
  private final String zzSp;
  private final String zzaIF;
  private final long zzaIG;
  private final int zzaiv;
  
  VideoEntity(int paramInt1, int paramInt2, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzaiv = paramInt2;
    this.zzaIF = paramString1;
    this.zzaIG = paramLong1;
    this.zzBv = paramLong2;
    this.zzSp = paramString2;
  }
  
  public VideoEntity(Video paramVideo)
  {
    this.mVersionCode = 1;
    this.zzaiv = paramVideo.getDuration();
    this.zzaIF = paramVideo.zzxq();
    this.zzaIG = paramVideo.getFileSize();
    this.zzBv = paramVideo.getStartTime();
    this.zzSp = paramVideo.getPackageName();
    zzb.zzu(this.zzaIF);
    zzb.zzu(this.zzSp);
  }
  
  static int zza(Video paramVideo)
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(paramVideo.getDuration()), paramVideo.zzxq(), Long.valueOf(paramVideo.getFileSize()), Long.valueOf(paramVideo.getStartTime()), paramVideo.getPackageName() });
  }
  
  static boolean zza(Video paramVideo, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Video)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramVideo == paramObject);
      paramObject = (Video)paramObject;
      if ((!zzw.equal(Integer.valueOf(((Video)paramObject).getDuration()), Integer.valueOf(paramVideo.getDuration()))) || (!zzw.equal(((Video)paramObject).zzxq(), paramVideo.zzxq())) || (!zzw.equal(Long.valueOf(((Video)paramObject).getFileSize()), Long.valueOf(paramVideo.getFileSize()))) || (!zzw.equal(Long.valueOf(((Video)paramObject).getStartTime()), Long.valueOf(paramVideo.getStartTime())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Video)paramObject).getPackageName(), paramVideo.getPackageName()));
    return false;
  }
  
  static String zzb(Video paramVideo)
  {
    return zzw.zzx(paramVideo).zzg("Duration", Integer.valueOf(paramVideo.getDuration())).zzg("File path", paramVideo.zzxq()).zzg("File size", Long.valueOf(paramVideo.getFileSize())).zzg("Start time", Long.valueOf(paramVideo.getStartTime())).zzg("Package name", paramVideo.getPackageName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public int getDuration()
  {
    return this.zzaiv;
  }
  
  public long getFileSize()
  {
    return this.zzaIG;
  }
  
  public String getPackageName()
  {
    return this.zzSp;
  }
  
  public long getStartTime()
  {
    return this.zzBv;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
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
    VideoEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzxq()
  {
    return this.zzaIF;
  }
  
  public Video zzxu()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/video/VideoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */