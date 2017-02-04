package com.google.android.gms.games.video;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class VideoBuffer
  extends AbstractDataBuffer<Video>
{
  public VideoBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public VideoRef zzgP(int paramInt)
  {
    return new VideoRef(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/video/VideoBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */