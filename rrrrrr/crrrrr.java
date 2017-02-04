package rrrrrr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus;
import com.immersion.hapticmediasdk.MediaTaskManager;
import com.immersion.hapticmediasdk.controllers.MediaController;
import java.util.concurrent.atomic.AtomicInteger;

public class crrrrr
  extends Handler
{
  public crrrrr(MediaController paramMediaController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
      do
      {
        return;
      } while ((MediaController.bц04460446044604460446(this.bС04210421С0421С).get() != paramMessage.arg1) || (MediaController.b044Aъъъъъ(this.bС04210421С0421С).get() != paramMessage.arg2));
      if (MediaController.bъ044Aъъъъ(this.bС04210421С0421С).getSDKStatus() == HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING)
      {
        MediaController.bъ044Aъъъъ(this.bС04210421С0421С).transitToState(HapticContentSDK.SDKStatus.PLAYING);
        return;
      }
      MediaController.b044A044Aъъъъ(this.bС04210421С0421С, MediaController.bц04460446044604460446(this.bС04210421С0421С).get(), SystemClock.uptimeMillis());
      this.bС04210421С0421С.playbackStarted();
      return;
    case 7: 
      MediaController.bъъ044Aъъъ(this.bС04210421С0421С, paramMessage.arg1);
      return;
    }
    MediaController.b044Aъ044Aъъъ(this.bС04210421С0421С, paramMessage);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/rrrrrr/crrrrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */