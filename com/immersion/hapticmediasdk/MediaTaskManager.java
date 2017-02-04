package com.immersion.hapticmediasdk;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import com.immersion.hapticmediasdk.controllers.MediaController;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;

public class MediaTaskManager
  implements Runnable
{
  private static final String a = "MediaTaskManager";
  private final Object b = new Object();
  private final Object c = new Object();
  private long d;
  private long e;
  private Handler f;
  private volatile HapticContentSDK.SDKStatus g = HapticContentSDK.SDKStatus.NOT_INITIALIZED;
  private MediaController h;
  private String i;
  private boolean j;
  private Context k;
  private RuntimeInfo l;
  
  public MediaTaskManager(Handler paramHandler, Context paramContext, RuntimeInfo paramRuntimeInfo)
  {
    this.f = paramHandler;
    this.k = paramContext;
    this.l = paramRuntimeInfo;
  }
  
  private int a()
  {
    this.f.removeCallbacks(this);
    if ((this.h != null) && (d() != 0)) {
      Log.e("MediaTaskManager", "Could not dispose haptics, reset anyway.");
    }
    this.i = null;
    this.d = 0L;
    this.g = HapticContentSDK.SDKStatus.NOT_INITIALIZED;
    return 0;
  }
  
  private int a(HapticContentSDK.SDKStatus paramSDKStatus)
  {
    this.f.removeCallbacks(this);
    this.g = paramSDKStatus;
    if (this.i != null)
    {
      this.h = new MediaController(this.f.getLooper(), this);
      paramSDKStatus = this.h.getControlHandler();
      paramSDKStatus = new HapticPlaybackThread(this.k, this.i, paramSDKStatus, this.j, this.l);
      this.h.initHapticPlayback(paramSDKStatus);
      return 0;
    }
    return -4;
  }
  
  private int b()
  {
    this.f.removeCallbacks(this);
    int m = this.h.onPrepared();
    if (m == 0)
    {
      this.g = HapticContentSDK.SDKStatus.PLAYING;
      this.f.postDelayed(this, 1500L);
    }
    return m;
  }
  
  private int c()
  {
    this.f.removeCallbacks(this);
    this.d = 0L;
    int m = this.h.stopHapticPlayback();
    if (m == 0) {
      this.g = HapticContentSDK.SDKStatus.STOPPED;
    }
    return m;
  }
  
  private int d()
  {
    int m = c();
    if (m == 0)
    {
      this.h.onDestroy(this.f);
      this.h = null;
    }
    return m;
  }
  
  private int e()
  {
    this.f.removeCallbacks(this);
    int m = this.h.onPause();
    if (m == 0) {
      this.g = HapticContentSDK.SDKStatus.PAUSED;
    }
    return m;
  }
  
  private int f()
  {
    this.f.removeCallbacks(this);
    if (this.f.postDelayed(this, 1500L)) {
      return 0;
    }
    return -1;
  }
  
  private int g()
  {
    int m = this.h.onPause();
    if (m == 0) {
      this.g = HapticContentSDK.SDKStatus.PAUSED_DUE_TO_TIMEOUT;
    }
    return m;
  }
  
  private int h()
  {
    int m = this.h.onPause();
    if (m == 0) {
      this.g = HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING;
    }
    return m;
  }
  
  private int i()
  {
    int n = b();
    int m = n;
    if (n == 0) {
      m = f();
    }
    return m;
  }
  
  public int SeekTo(int paramInt)
  {
    setMediaTimestamp(paramInt);
    this.h.seekTo(paramInt);
    if (getSDKStatus() == HapticContentSDK.SDKStatus.PLAYING) {
      return this.h.prepareHapticPlayback();
    }
    return 0;
  }
  
  public long getMediaReferenceTime()
  {
    synchronized (this.c)
    {
      long l1 = this.e;
      return l1;
    }
  }
  
  public long getMediaTimestamp()
  {
    synchronized (this.c)
    {
      long l1 = this.d;
      return l1;
    }
  }
  
  public HapticContentSDK.SDKStatus getSDKStatus()
  {
    synchronized (this.b)
    {
      HapticContentSDK.SDKStatus localSDKStatus = this.g;
      return localSDKStatus;
    }
  }
  
  public void run()
  {
    System.currentTimeMillis();
    transitToState(HapticContentSDK.SDKStatus.PAUSED_DUE_TO_TIMEOUT);
  }
  
  public void setHapticsUrl(String paramString, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      this.i = paramString;
      this.j = paramBoolean;
      return;
    }
  }
  
  public void setMediaReferenceTime()
  {
    synchronized (this.c)
    {
      if (this.g == HapticContentSDK.SDKStatus.STOPPED) {
        this.h.waitHapticStopped();
      }
      this.e = SystemClock.uptimeMillis();
      return;
    }
  }
  
  public void setMediaTimestamp(long paramLong)
  {
    synchronized (this.c)
    {
      if (this.g == HapticContentSDK.SDKStatus.STOPPED) {
        this.h.waitHapticStopped();
      }
      this.e = SystemClock.uptimeMillis();
      this.d = paramLong;
      return;
    }
  }
  
  public int transitToState(HapticContentSDK.SDKStatus paramSDKStatus)
  {
    int m = -1;
    for (;;)
    {
      synchronized (this.b)
      {
        if (paramSDKStatus == HapticContentSDK.SDKStatus.NOT_INITIALIZED)
        {
          m = a();
          return m;
        }
        switch (rrrrrr.crccrr.b042704270427ЧЧ0427[this.g.ordinal()])
        {
        case 1: 
          return m;
        }
      }
      if (paramSDKStatus == HapticContentSDK.SDKStatus.INITIALIZED)
      {
        m = a(paramSDKStatus);
        continue;
        if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
        {
          m = i();
        }
        else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED)
        {
          m = c();
        }
        else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR)
        {
          m = c();
          this.g = HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
          continue;
          if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
          {
            m = f();
          }
          else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED)
          {
            m = e();
          }
          else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED_DUE_TO_TIMEOUT)
          {
            Log.w("MediaTaskManager", "Haptic playback is paused due to update time-out. Call update() to resume playback");
            m = g();
          }
          else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING)
          {
            m = h();
            Log.w("MediaTaskManager", "Haptic playback is paused due to slow data buffering...");
          }
          else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED)
          {
            m = c();
          }
          else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR)
          {
            m = c();
            this.g = HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
            continue;
            if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
            {
              this.h.setRequestBufferPosition((int)this.d);
              m = i();
            }
            else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED)
            {
              m = 0;
            }
            else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED)
            {
              m = c();
            }
            else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR)
            {
              m = c();
              this.g = HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
              continue;
              if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED_DUE_TO_TIMEOUT)
              {
                m = 0;
              }
              else if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
              {
                this.h.setRequestBufferPosition((int)this.d);
                m = i();
              }
              else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED)
              {
                this.g = HapticContentSDK.SDKStatus.PAUSED;
                m = 0;
              }
              else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED)
              {
                m = c();
              }
              else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR)
              {
                m = c();
                this.g = HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
                continue;
                if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING)
                {
                  m = 0;
                }
                else if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
                {
                  this.h.setRequestBufferPosition((int)this.d);
                  m = i();
                }
                else if (paramSDKStatus == HapticContentSDK.SDKStatus.PAUSED)
                {
                  this.g = HapticContentSDK.SDKStatus.PAUSED;
                  m = 0;
                }
                else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED)
                {
                  m = c();
                }
                else if (paramSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR)
                {
                  m = c();
                  this.g = HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
                  continue;
                  if (paramSDKStatus == HapticContentSDK.SDKStatus.PLAYING)
                  {
                    m = i();
                  }
                  else
                  {
                    HapticContentSDK.SDKStatus localSDKStatus = HapticContentSDK.SDKStatus.STOPPED;
                    if (paramSDKStatus == localSDKStatus) {
                      m = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/MediaTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */