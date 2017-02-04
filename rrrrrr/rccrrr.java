package rrrrrr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.immersion.hapticmediasdk.controllers.FileReaderFactory;
import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import com.immersion.hapticmediasdk.controllers.IHapticFileReader;

public class rccrrr
  extends Handler
{
  private rccrrr(HapticPlaybackThread paramHapticPlaybackThread) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 6: 
    case 7: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        return;
        HapticPlaybackThread.bц0446ц04460446ц(this.b0415Е0415Е04150415).removeCallbacks(HapticPlaybackThread.b0446цц04460446ц(this.b0415Е0415Е04150415));
        HapticPlaybackThread.b04460446ц04460446ц(this.b0415Е0415Е04150415, paramMessage.arg1);
        HapticPlaybackThread.bцц044604460446ц(this.b0415Е0415Е04150415, paramMessage.arg2);
        HapticPlaybackThread.b0446ц044604460446ц(this.b0415Е0415Е04150415, 0);
        HapticPlaybackThread.bц0446044604460446ц(this.b0415Е0415Е04150415);
        return;
        paramMessage = paramMessage.getData();
        HapticPlaybackThread.b04460446044604460446ц(this.b0415Е0415Е04150415, paramMessage.getInt("playback_timecode"), paramMessage.getLong("playback_uptime"));
        return;
        if (HapticPlaybackThread.bццццц0446(this.b0415Е0415Е04150415) == null) {
          HapticPlaybackThread.b0446цццц0446(this.b0415Е0415Е04150415, FileReaderFactory.getHapticFileReaderInstance(HapticPlaybackThread.bц0446ццц0446(this.b0415Е0415Е04150415), HapticPlaybackThread.b04460446ццц0446(this.b0415Е0415Е04150415)));
        }
        if ((HapticPlaybackThread.bццццц0446(this.b0415Е0415Е04150415) != null) && (HapticPlaybackThread.bцц0446цц0446(this.b0415Е0415Е04150415) == 0)) {
          HapticPlaybackThread.b0446ц0446цц0446(this.b0415Е0415Е04150415, HapticPlaybackThread.bццццц0446(this.b0415Е0415Е04150415).getBlockSizeMS());
        }
      } while (HapticPlaybackThread.bццццц0446(this.b0415Е0415Е04150415) == null);
      HapticPlaybackThread.bццццц0446(this.b0415Е0415Е04150415).setBytesAvailable(paramMessage.arg1);
      return;
    case 4: 
      HapticPlaybackThread.bц04460446цц0446(this.b0415Е0415Е04150415);
      return;
    case 5: 
      HapticPlaybackThread.b044604460446цц0446(this.b0415Е0415Е04150415);
      return;
    case 8: 
      HapticPlaybackThread.bццц0446ц0446(this.b0415Е0415Е04150415, paramMessage);
      return;
    }
    HapticPlaybackThread.b0446цц0446ц0446(this.b0415Е0415Е04150415);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/rrrrrr/rccrrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */