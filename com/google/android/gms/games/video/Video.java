package com.google.android.gms.games.video;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Video
  extends Parcelable, Freezable<Video>
{
  public abstract int getDuration();
  
  public abstract long getFileSize();
  
  public abstract String getPackageName();
  
  public abstract long getStartTime();
  
  public abstract String zzxq();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/video/Video.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */