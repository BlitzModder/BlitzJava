package com.immersion.hapticmediasdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;

public abstract class HapticContentSDK
{
  public static final int INACCESSIBLE_URL = -2;
  public static final int INVALID = -1;
  public static final int MALFORMED_URL = -4;
  public static final int PERMISSION_DENIED = -3;
  public static final int SDKMODE_MEDIAPLAYBACK = 0;
  public static final int SUCCESS = 0;
  public static final int UNSUPPORTED_PROTOCOL = -5;
  private static final String a = "HapticContentSDK";
  public static final int b0415ЕЕ041504150415 = 10000;
  public static final int bЕЕЕ041504150415 = 1500;
  private HandlerThread b;
  private Handler c;
  private Context d;
  private RuntimeInfo e;
  public boolean mDisposed = false;
  public MediaTaskManager mMediaTaskManager;
  public SDKStatus mSDKStatus = SDKStatus.NOT_INITIALIZED;
  
  public HapticContentSDK(int paramInt, Context paramContext)
  {
    this.d = paramContext;
    this.e = new RuntimeInfo();
  }
  
  public int bц04460446ц04460446()
  {
    if (this.d.getPackageManager().checkPermission("android.permission.VIBRATE", this.d.getPackageName()) == 0)
    {
      this.b = new HandlerThread("SDK Monitor");
      this.b.start();
      this.c = new Handler(this.b.getLooper());
      this.mMediaTaskManager = new MediaTaskManager(this.c, this.d, this.e);
      return 0;
    }
    Log.e("HapticContentSDK", "Failed to create a Haptic Content SDK instance.Vibrate permission denied.");
    return -3;
  }
  
  public final void dispose()
  {
    if (getSDKStatus() != SDKStatus.DISPOSED)
    {
      this.mMediaTaskManager.transitToState(SDKStatus.NOT_INITIALIZED);
      this.b.quit();
      this.b = null;
      this.mMediaTaskManager = null;
      this.mDisposed = true;
    }
  }
  
  public void finalize()
    throws Throwable
  {
    try
    {
      dispose();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final SDKStatus getSDKStatus()
  {
    if (this.mDisposed) {
      return SDKStatus.DISPOSED;
    }
    return this.mMediaTaskManager.getSDKStatus();
  }
  
  public final String getVersion()
  {
    return "v2.0.68.12";
  }
  
  public final int mute()
  {
    if (getSDKStatus() != SDKStatus.DISPOSED)
    {
      this.e.mute();
      return 0;
    }
    return -1;
  }
  
  public abstract int openHaptics(String paramString);
  
  public final int pause()
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.DISPOSED) || (localSDKStatus == SDKStatus.STOPPED_DUE_TO_ERROR)) {
      return -1;
    }
    return this.mMediaTaskManager.transitToState(SDKStatus.PAUSED);
  }
  
  public final int play()
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.INITIALIZED) || (localSDKStatus == SDKStatus.STOPPED))
    {
      this.mMediaTaskManager.setMediaTimestamp(0L);
      return this.mMediaTaskManager.transitToState(SDKStatus.PLAYING);
    }
    return -1;
  }
  
  public final int resume()
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.PAUSED) || (localSDKStatus == SDKStatus.PLAYING) || (localSDKStatus == SDKStatus.STOPPED))
    {
      this.mMediaTaskManager.setMediaReferenceTime();
      return this.mMediaTaskManager.transitToState(SDKStatus.PLAYING);
    }
    return -1;
  }
  
  public final int seek(int paramInt)
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.DISPOSED) || (localSDKStatus == SDKStatus.NOT_INITIALIZED) || (localSDKStatus == SDKStatus.STOPPED_DUE_TO_ERROR)) {
      return -1;
    }
    return this.mMediaTaskManager.SeekTo(paramInt);
  }
  
  public final int stop()
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.DISPOSED) || (localSDKStatus == SDKStatus.NOT_INITIALIZED)) {
      return -1;
    }
    return this.mMediaTaskManager.transitToState(SDKStatus.STOPPED);
  }
  
  public final int unmute()
  {
    if (getSDKStatus() != SDKStatus.DISPOSED)
    {
      this.e.unmute();
      return 0;
    }
    return -1;
  }
  
  public final int update(long paramLong)
  {
    SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == SDKStatus.PLAYING) || (localSDKStatus == SDKStatus.PAUSED_DUE_TO_TIMEOUT))
    {
      this.mMediaTaskManager.setMediaTimestamp(paramLong);
      return this.mMediaTaskManager.transitToState(SDKStatus.PLAYING);
    }
    if ((localSDKStatus == SDKStatus.PAUSED) || (localSDKStatus == SDKStatus.PAUSED_DUE_TO_BUFFERING))
    {
      this.mMediaTaskManager.setMediaTimestamp(paramLong);
      return 0;
    }
    return -1;
  }
  
  public static enum SDKStatus
  {
    static
    {
      INITIALIZED = new SDKStatus("INITIALIZED", 1);
      PLAYING = new SDKStatus("PLAYING", 2);
      STOPPED = new SDKStatus("STOPPED", 3);
      STOPPED_DUE_TO_ERROR = new SDKStatus("STOPPED_DUE_TO_ERROR", 4);
      PAUSED = new SDKStatus("PAUSED", 5);
      PAUSED_DUE_TO_TIMEOUT = new SDKStatus("PAUSED_DUE_TO_TIMEOUT", 6);
      PAUSED_DUE_TO_BUFFERING = new SDKStatus("PAUSED_DUE_TO_BUFFERING", 7);
    }
    
    public static SDKStatus valueOfCaseInsensitive(String paramString)
    {
      SDKStatus[] arrayOfSDKStatus = values();
      int j = arrayOfSDKStatus.length;
      int i = 0;
      while (i < j)
      {
        SDKStatus localSDKStatus = arrayOfSDKStatus[i];
        if (paramString.equalsIgnoreCase(localSDKStatus.name())) {
          return localSDKStatus;
        }
        i += 1;
      }
      return null;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/HapticContentSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */