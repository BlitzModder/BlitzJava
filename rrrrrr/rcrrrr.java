package rrrrrr;

import android.os.Handler;
import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import com.immersion.hapticmediasdk.controllers.MediaController;

public class rcrrrr
  implements Runnable
{
  public rcrrrr(MediaController paramMediaController) {}
  
  public void run()
  {
    if ((this.bС04210421042104210421.isPlaying()) && (MediaController.bъ044A044Aъъъ(this.bС04210421042104210421) != null))
    {
      MediaController.bъ044A044Aъъъ(this.bС04210421042104210421).syncUpdate(this.bС04210421042104210421.getCurrentPosition(), this.bС04210421042104210421.getReferenceTimeForCurrentPosition());
      MediaController.bъ044A044Aъъъ(this.bС04210421042104210421).getHandler().removeCallbacks(this);
      MediaController.bъ044A044Aъъъ(this.bС04210421042104210421).getHandler().postDelayed(this, 1000L);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/rrrrrr/rcrrrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */