package com.immersion.hapticmediasdk.controllers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus;
import com.immersion.hapticmediasdk.MediaTaskManager;
import com.immersion.hapticmediasdk.models.HttpUnsuccessfulException;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.Profiler;
import java.util.concurrent.atomic.AtomicInteger;
import rrrrrr.crrrrr;
import rrrrrr.rcrrrr;

public class MediaController
{
  private static final String a = "MediaController";
  private static final int b = 1000;
  private static final int c = 200;
  private AtomicInteger d = new AtomicInteger();
  private AtomicInteger e = new AtomicInteger();
  private Handler f;
  private HapticPlaybackThread g;
  private Profiler h = new Profiler();
  private MediaTaskManager i;
  private Runnable j = new rcrrrr(this);
  
  public MediaController(Looper paramLooper, MediaTaskManager paramMediaTaskManager)
  {
    this.i = paramMediaTaskManager;
    this.f = new crrrrr(this, paramLooper);
  }
  
  private int a()
  {
    this.g.pauseHapticPlayback();
    return 0;
  }
  
  private void a(int paramInt)
  {
    this.d.set(paramInt);
    this.i.transitToState(HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING);
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.g.playHapticForPlaybackPosition(paramInt, paramLong);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Exception)paramMessage.getData().getSerializable("haptic_download_exception");
    if ((paramMessage instanceof HttpUnsuccessfulException))
    {
      HttpUnsuccessfulException localHttpUnsuccessfulException = (HttpUnsuccessfulException)paramMessage;
      Log.e("MediaController", "caught HttpUnsuccessfulExcetion http status code = " + localHttpUnsuccessfulException.getHttpStatusCode());
    }
    Log.e("MediaController", "HapticDownloadError: " + paramMessage.getMessage());
    this.i.transitToState(HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR);
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    boolean bool1 = this.g.isStarted();
    for (;;)
    {
      if ((!paramBoolean) || (!bool1)) {}
      try
      {
        synchronized (this.g)
        {
          this.g.wait(200L);
          boolean bool2 = this.g.isStarted();
          int m = k + 1;
          bool1 = bool2;
          k = m;
          if (paramBoolean) {
            continue;
          }
          bool1 = bool2;
          k = m;
          if (m < 5) {
            continue;
          }
          do
          {
            return;
          } while (!bool1);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public Handler getControlHandler()
  {
    return this.f;
  }
  
  public int getCurrentPosition()
  {
    return (int)this.i.getMediaTimestamp();
  }
  
  public long getReferenceTimeForCurrentPosition()
  {
    return this.i.getMediaReferenceTime();
  }
  
  public void initHapticPlayback(HapticPlaybackThread paramHapticPlaybackThread)
  {
    this.g = paramHapticPlaybackThread;
    this.g.start();
    a(true);
  }
  
  public boolean isPlaying()
  {
    return this.i.getSDKStatus() == HapticContentSDK.SDKStatus.PLAYING;
  }
  
  public void onDestroy(Handler paramHandler)
  {
    if (this.g != null)
    {
      this.g.quitHapticPlayback();
      a(false);
      this.g = null;
    }
    paramHandler.removeCallbacks(this.i);
  }
  
  public int onPause()
  {
    return a();
  }
  
  public int onPrepared()
  {
    return prepareHapticPlayback();
  }
  
  public void playbackStarted()
  {
    if (this.g != null)
    {
      this.g.getHandler().postDelayed(this.j, 200L);
      return;
    }
    Log.e("MediaController", "Can't start periodic sync since haptic playback thread stopped.");
  }
  
  public int prepareHapticPlayback()
  {
    this.h.startTiming();
    this.g.prepareHapticPlayback(this.d.get(), this.e.incrementAndGet());
    return 0;
  }
  
  public void seekTo(int paramInt)
  {
    AtomicInteger localAtomicInteger = this.d;
    if (paramInt > 0) {}
    for (;;)
    {
      localAtomicInteger.set(paramInt);
      if (this.g != null)
      {
        this.g.getHandler().removeCallbacks(this.j);
        this.g.removePlaybackCallbacks();
      }
      return;
      paramInt = 0;
    }
  }
  
  public void setRequestBufferPosition(int paramInt)
  {
    this.d.set(paramInt);
  }
  
  public int stopHapticPlayback()
  {
    this.d.set(0);
    this.g.stopHapticPlayback();
    this.g.getHandler().removeCallbacks(this.j);
    return 0;
  }
  
  public void waitHapticStopped()
  {
    boolean bool = this.g.isStopped();
    int k = 0;
    if ((!bool) && (k < 5)) {}
    try
    {
      synchronized (this.g)
      {
        this.g.wait(200L);
        bool = this.g.isStopped();
        k += 1;
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/MediaController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */